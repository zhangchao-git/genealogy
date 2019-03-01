package com.zhang.genealogy.util;

import com.zhang.genealogy.constant.Constants;
import com.zhang.genealogy.exception.CommonException;
import com.zhang.genealogy.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * MD5不可逆加密工具类
 *
 * @author wuq
 * @date 2019-02-01
 */
public class MD5Util {
    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    /**
     * 返回字符串的md5加密结果
     *
     * @param value
     * @return
     */
    public static String toMD5(String value) {
        byte[] source = null;
        try {
            source = value.getBytes(Constants.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5加密获取字节数组出错：", e);
            throw new CommonException(ErrorCode.ENCODER_DATA_ERROR, value);
        }

        String s = null;
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，所以表示成 16进制需要 32 个字符

            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) {
                // 从第一个字节开始，对 MD5 的每一个字节转换成 16进制字符的转换
                byte byte0 = tmp[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>>为逻辑右移，将符号位一起右移

                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            s = new String(str); // 换后的结果转换为字符串
        } catch (Exception e) {
            logger.error("MD5加密数据出错：", e);
            throw new CommonException(ErrorCode.ENCRYPT_DATA_ERROR, value);
        }

        return s;
    }

    /**
     * 获取指定字符串的MD5长整数HASH值
     *
     * @param value
     * @return
     */
    public static long getMD5Hash(String value) {
        long hash = 0L;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5hash = md5.digest(value.getBytes("UTF-8"));
            for (int i = 0; i < 8; i++) {
                hash = hash << 8 | md5hash[i] & 0x00000000000000FFL;
            }
        } catch (Exception e) {
            logger.error("MD5加密数据出错：", e);
            hash = 0L;
            throw new CommonException(ErrorCode.ENCRYPT_DATA_ERROR, value);
        }

        return hash;
    }

    /**
     * 获取指定字符串的无符号MD5长整数HASH值
     *
     * @param value
     * @return
     */
    public static String getUnsignMD5Hash(String value) {
        BigInteger bival = BigInteger.valueOf(getMD5Hash(value));
        if (bival.signum() < 0) bival = bival.add(BigInteger.ONE.shiftLeft(64));
        return bival.toString();
    }

}