package com.ijunfu.id.utils;


import java.security.SecureRandom;

/**
 *
 * @Title  : 
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024-10-14 19:11
 * @Version: 1.0
 * @Motto  : 世界很大 世界很小
 *
 */
public class NanoId {

    // 随机数生成器
    private static final SecureRandom DEFAULT_RANDOM = new SecureRandom();

    private int size;
    private char[] alphabet;

    public NanoId() {
        // 默认长度
        this.size = 21;

        // 默认字符集
        this.alphabet = Constant.ALPHABET.toCharArray();
    }

    public NanoId(int size, char[] alphabet) {
        this.size = size;
        this.alphabet = alphabet;
    }

    public synchronized String nextId() {
        if (alphabet == null) {
            throw new IllegalArgumentException("alphabet cannot be null.");
        }

        if (alphabet.length == 0 || alphabet.length >= 256) {
            throw new IllegalArgumentException("alphabet must contain between 1 and 255 symbols.");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than zero.");
        }

        final int mask = (2 << (int) Math.floor(Math.log(alphabet.length - 1) / Math.log(2))) - 1;
        final int step = (int) Math.ceil(1.6 * mask * size / alphabet.length);

        final StringBuilder idBuilder = new StringBuilder();
        final byte[] bytes = new byte[step];

        while (true) {
            DEFAULT_RANDOM.nextBytes(bytes);

            for (int i = 0; i < step; i++) {

                final int alphabetIndex = bytes[i] & mask;

                if (alphabetIndex < alphabet.length) {
                    idBuilder.append(alphabet[alphabetIndex]);
                    if (idBuilder.length() == size) {
                        return idBuilder.toString();
                    }
                }

            }

        }
    }
}
