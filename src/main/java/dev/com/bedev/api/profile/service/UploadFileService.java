package dev.com.bedev.api.profile.service;

import dev.com.bedev.api.util.FileHandler;
import dev.com.bedev.domain.uploadfile.UploadFile;
import dev.com.bedev.domain.uploadfile.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final FileHandler fileHandler;
    private final UploadFileRepository uploadFileRepository;
    public UploadFile addUploadFile(
            MultipartFile file

    ) throws Exception {

        UploadFile uploadFile = fileHandler.UploadFileInfo(file);

        return uploadFileRepository.save(uploadFile);
    }
}

