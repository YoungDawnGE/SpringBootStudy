package com.gyc.springbootstudy.service.serviceImpl;

import com.gyc.springbootstudy.exception.FileException;
import com.gyc.springbootstudy.properties.FileProperties;
import com.gyc.springbootstudy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> loadFileNamesInDir() {
        File fileParent = filePath.toFile();//存放文件的父目录
        File[] files = fileParent.listFiles();//父目录下的所有文件
        //全都是文件 没有目录  so不做校验
        List<String> fileNames = new ArrayList<>();
        if (null == files) {
            throw new FileException("file not found");
        }
        for (File f : files) {
            fileNames.add(f.getName());
        }
        return fileNames;
    }
}