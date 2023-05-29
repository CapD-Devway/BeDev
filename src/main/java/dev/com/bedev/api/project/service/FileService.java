package dev.com.bedev.api.project.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final String uploadDirectory = "";

    public String storeFile(String imgPath) {
        try {
            if(imgPath == null || imgPath.isEmpty()) {
                return null;
            }

            Path sourcePath = Paths.get(imgPath);
            String originalFileName = sourcePath.getFileName().toString();
            String storedFileName = System.currentTimeMillis() + "_" + originalFileName;

            Path destinationPath = Paths.get(uploadDirectory, storedFileName);
            Files.copy(sourcePath, destinationPath); // 파일 복사

            return storedFileName; // 저장된 파일 이름 반환
        } catch (IOException e) {
            throw new RuntimeException("파일 첨부에 실패했습니다.", e);
        }
    }
}


