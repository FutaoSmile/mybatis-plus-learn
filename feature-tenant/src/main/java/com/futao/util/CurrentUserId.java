package com.futao.util;

/**
 * @author futao
 * @date 2020/12/15
 */
public class CurrentUserId {
    private static final ThreadLocal<Long> CURRENT_USER_ID = new ThreadLocal<>();

    public static Long s() {
        return CURRENT_USER_ID.get();
    }

    public static void set(Long id) {
        CURRENT_USER_ID.set(id);
    }
}
