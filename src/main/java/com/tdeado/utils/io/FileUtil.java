package com.tdeado.utils.io;

import java.io.File;
import java.io.FileOutputStream;

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
    public static void saveFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
