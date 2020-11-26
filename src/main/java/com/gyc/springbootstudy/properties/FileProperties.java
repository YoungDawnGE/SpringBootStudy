package com.gyc.springbootstudy.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by GYC
 * 2020/11/26 10:53
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    private String fileDir;

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}