package cn.shijianka.file;

import java.io.File;
import java.util.ArrayList;

public class DeleteFile {
    /**
     * 2022年1月11日
     * --增加删除功能
     */

    public DeleteFile() {
    }

    private int deleteForFileCount = 0; //成功删除的文件总数量
    private int deleteForDirectoryCount = 0; //成功删除的文件夹总数量
    private ArrayList<String> deleteNameForFileList = new ArrayList<>(); //删除的文件名集合
    private ArrayList<String> deleteNameForDirectoryList = new ArrayList<>(); //删除的文件夹名称集合

    public int getDeleteForFileCount() {
        return deleteForFileCount;
    }

    public ArrayList<String> getDeleteNameForFileList() {
        return deleteNameForFileList;
    }

    public ArrayList<String> getDeleteNameForDirectoryList() {
        return deleteNameForDirectoryList;
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
        if (file.exists() && file.isFile()) {
            boolean delete = file.delete();
            if (delete) {
                deleteForFileCount++;
                deleteNameForFileList.add(file.getName());
            }
            return delete;
        }
        return false;
    }

    /**
     * 删除目标文件夹
     */
    public boolean deleteDirectory(String targetDirectory) {
        if (!targetDirectory.endsWith("\\")) {
            targetDirectory += "\\";
        }
        File file = new File(targetDirectory);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                boolean delete = files[i].delete();
                if (delete) {
                    deleteForFileCount++;
                    deleteNameForFileList.add(files[i].getName());
                }
                if (!delete) {
                    break;
                }
            } else {
                boolean b = deleteDirectory(files[i].getAbsolutePath());
                if (!b) {
                    break;
                }
            }
        }
        if (file.delete()) {
            deleteForDirectoryCount++;
            deleteNameForDirectoryList.add(file.getName());
            return true;
        } else {
            return false;
        }
    }
}
