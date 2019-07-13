package com.aop.aop.password;

import java.util.Random;

public class KeyGenerator {
    public static final long WEAK_KEY = 0xFFFFFFF0000000L;
    private static final long STRONG_KEY = 0xACDF03F590AE56L;
    private Random random = new Random();

    public long getKey() {
        int x = random.nextInt(3);
        if (x == 1) {
            return WEAK_KEY;
        } else {
            return STRONG_KEY;
        }
    }
}
