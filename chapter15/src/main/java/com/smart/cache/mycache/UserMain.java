package com.smart.cache.mycache;


public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        // 开始查询账号
        userService.getUserById("001001");// 第一次查询，应该是数据库查询
        userService.getUserById("001001");// 第二次查询，应该直接从缓存返回

        userService.reload();// 重置缓存
        System.out.println("重置缓存...");

        userService.getUserById("001001");// 应该是数据库查询
        userService.getUserById("001001");// 第二次查询，应该直接从缓存返回
    }

}
