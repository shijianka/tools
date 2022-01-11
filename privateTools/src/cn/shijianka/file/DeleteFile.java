package cn.shijianka.file;

import java.io.File;

public class DeleteFile {
/**
 *   2022年1月11日
 *      --增加删除功能
 */

    public DeleteFile() {
    }

    /**
     * 删除目标路径下所有内容
     */
    public boolean deleteFolder(String targetFolder) {
        File file = new File(targetFolder);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return deleteFile(targetFolder);
        } else {
            return deleteDirectory(targetFolder);
        }
    }

    /**
     * 删除目标文件
     */
    public boolean deleteFile(String targetFile) {
        File file = new File(targetFile);
        if(file.exists()&&file.isFile()){
            file.delete();
            return true;
        }
        return false;
    }

    /**
     * 删除目标文件夹
     */
    public boolean deleteDirectory(String targetDirectory) {
       if(!targetDirectory.endsWith("\\")){
           targetDirectory +="\\";
       }
       File file = new File(targetDirectory);
       if(!file.exists()||!file.isDirectory()){
           return false;
       }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isFile()){
                boolean delete = files[i].delete();
                if(!delete){
                    break;
                }
            }else {
                boolean b = deleteDirectory(files[i].getAbsolutePath());
                if(!b){
                    break;
                }
            }
        }
        if(file.delete()){
            return true;
        }else {
            return false;
        }
    }
}
