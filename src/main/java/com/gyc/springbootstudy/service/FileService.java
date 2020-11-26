package com.gyc.springbootstudy.service;


import org.springframework.core.io.Resource;

/**
 * Created by GYC
 * 2020/11/26 10:47
 */
public interface FileService {
    Resource loadFileAsResource(String fileName);
}
