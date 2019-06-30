package com.tdeado.utils.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 */
public class FileUtil {
    /**
     * 保存文件
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static boolean saveFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return true;
    }

    public static boolean createFile(String newVersion) throws IOException {
        return true;
    }

}
