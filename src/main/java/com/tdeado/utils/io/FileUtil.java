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

    /**
     * TODO:递归扫描指定文件夹下面的指定文件
     * @param folderPath 扫描目录
     * @return ArrayList<Object>
     */
    public static ArrayList<Object> scanFilesWithRecursion(String folderPath) throws RuntimeException{
        ArrayList<Object> scanFiles = new ArrayList<Object>();
        ArrayList<String> dirctorys = new ArrayList<String>();
        File directory = new File(folderPath);
        if(!directory.isDirectory()){
            throw new RuntimeException('"' + folderPath + '"' + " input path is not a Directory , please input the right path of the Directory. ^_^...^_^");
        }
        if(directory.isDirectory()){
            File [] filelist = directory.listFiles();
            for(int i = 0; i < filelist.length; i ++){
                /**如果当前是文件夹，进入递归扫描文件夹**/
                if(filelist[i].isDirectory()){
                    dirctorys.add(filelist[i].getAbsolutePath());
                    /**递归扫描下面的文件夹**/
                    scanFiles.addAll(scanFilesWithRecursion(filelist[i].getAbsolutePath()));
                }
                /**非文件夹**/
                else{
                    scanFiles.add(filelist[i].getAbsolutePath());
                }
            }
        }
        return scanFiles;
    }
    /**
     * TODO:递归扫描指定文件夹下面的指定文件
     * @param folderPath 扫描目录
     * @return ArrayList<Object>
     */
    public static ArrayList<File> scanFilesWithRecursion(File folderPath) throws RuntimeException{
        ArrayList<File> scanFiles = new ArrayList<File>();
        ArrayList<String> dirctorys = new ArrayList<String>();
        File directory = folderPath;
        if(!directory.isDirectory()){
            throw new RuntimeException('"' + folderPath.getAbsolutePath() + '"' + " input path is not a Directory , please input the right path of the Directory. ^_^...^_^");
        }
        if(directory.isDirectory()){
            File [] filelist = directory.listFiles();
            for(int i = 0; i < filelist.length; i ++){
                /**如果当前是文件夹，进入递归扫描文件夹**/
                if(filelist[i].isDirectory()){
                    dirctorys.add(filelist[i].getAbsolutePath());
                    /**递归扫描下面的文件夹**/
                    scanFiles.addAll(scanFilesWithRecursion(filelist[i]));
                }
                /**非文件夹**/
                else{
                    scanFiles.add(filelist[i]);
                }
            }
        }
        return scanFiles;
    }
}
