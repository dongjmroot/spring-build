package utils;

import java.util.Random;

/**
 * @author dongjiaming
 * @Description 随机4位验证码
 * @title: RandomCode
 * @projectName study
 * @date 2022/5/1421:36
 */
public class RandomCode {

    /**
     * 随机生成4位数的验证码
     *
     * @return String code
     */
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
