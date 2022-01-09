package cn.shijianka.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class fileHash {
    private fileHash() {
    }
    public static String fileHashCode(String filePath, int hashType) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        String type;
        switch (hashType) {
            case 1:
                type = "MD5";
                break;
            case 2:
                type = "SHA-1";
                break;
            case 3:
                type = "SHA-256";
                break;
            default:
                type = "MD5";
        }
        return md5HashCode(fis, type);
    }

    private static String md5HashCode(InputStream fis, String type) {
        try {
            /**
             * MD5,SHA-1,SHA-256
             */
            MessageDigest messageDigest = MessageDigest.getInstance(type);
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = fis.read(bytes, 0, 1024)) != -1) {
                messageDigest.update(bytes, 0, length);
            }
            fis.close();
            /**
             * 转换并返回包含16个元素字节数组,返回数值范围为-128到127
             */
            byte[] hashBytes = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, hashBytes);
            return bigInteger.toString(16);//转换为16进制
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
