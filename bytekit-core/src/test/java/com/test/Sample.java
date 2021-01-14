package com.test;

// 要拦截增强的目标类
class Sample {
    private int exceptionCount = 0;

    public String hello(String str, boolean exception) {
        if (exception) {
            exceptionCount++;
            throw new RuntimeException("test exception, str: " + str);
        }
        return "hello " + str;
    }
}

