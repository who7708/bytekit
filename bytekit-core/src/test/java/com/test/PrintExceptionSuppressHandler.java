package com.test;

import com.alibaba.bytekit.asm.binding.Binding;
import com.alibaba.bytekit.asm.interceptor.annotation.ExceptionHandler;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2021/01/15
 */ // 异常处理器
class PrintExceptionSuppressHandler {

    @ExceptionHandler(inline = true)
    public static void onSuppress(@Binding.Throwable Throwable e, @Binding.Class Object clazz) {
        System.out.println("exception handler: " + clazz);
        e.printStackTrace();
    }
}
