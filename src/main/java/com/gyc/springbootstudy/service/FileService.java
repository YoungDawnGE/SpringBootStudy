package com.gyc.springbootstudy.service;


import org.springframework.core.io.Resource;

import java.util.List;

/**
 * Created by GYC
 * 2020/11/26 10:47
 */
public interface FileService {
    Resource loadFileAsResource(String fileName);

    /**
     * 获得file-dir路径下的所有文件资源
     * @return
     */
    List<String> loadFileNamesInDir();

}
