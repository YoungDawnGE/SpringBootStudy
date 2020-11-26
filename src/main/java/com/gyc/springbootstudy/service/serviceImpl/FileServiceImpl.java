package com.gyc.springbootstudy.service.serviceImpl;

import com.gyc.springbootstudy.exception.FileException;
import com.gyc.springbootstudy.properties.FileProperties;
import com.gyc.springbootstudy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by GYC
 * 2020/11/26 10:51
 */
@Service
@EnableConfigurationProperties({FileProperties.class})
public class FileServiceImpl implements FileService {

    private final Path filePath;

    @Autowired
    public FileServiceImpl(FileProperties fileProperties) {
        filePath = Paths.get(fileProperties.getFileDir()).toAbsolutePath().normalize();
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        Path path = filePath.resolve(fileName).normalize();
        try {
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }
            throw new FileException("file " + fileName + " not found");
        } catch (MalformedURLException e) {
            throw new FileException("file " + fileName + " not found", e);
        }
    }
}