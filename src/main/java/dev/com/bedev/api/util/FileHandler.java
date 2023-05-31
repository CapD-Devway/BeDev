package dev.com.bedev.api.util;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import dev.com.bedev.domain.uploadfile.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileHandler {


    private final Storage storage;

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;


    public UploadFile UploadFileInfo(
            MultipartFile multipartFile
    ) throws Exception {

        if (multipartFile ==null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        String path = "images/" + current_date;

        String uuid = UUID.randomUUID().toString();
        String new_file_name = uuid;

        BlobInfo blobInfo = storage.createFrom(
                BlobInfo.newBuilder(bucketName,path + "/" + new_file_name )
                        .setContentType(multipartFile.getContentType())
                        .build(),
                multipartFile.getInputStream()
        );

        String link = "https://storage.googleapis.com/" + bucketName + "/" + path + "/" + new_file_name;

        UploadFile uploadFile = UploadFile.builder()
                .downloadUrl(blobInfo.getMediaLink())
                .imageUrl(link)
                .file_size(multipartFile.getSize())
                .build();



        return uploadFile;
    }

}
