package com.test;

import com.alibaba.bytekit.utils.AgentUtils;
import com.alibaba.bytekit.utils.HexDump;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2021/01/15
 */ //测试入口类
class SampleDemo {

    public static void main(String[] args) throws Exception {

        // 启动Sample
        // System.out.println("before retransform ...");
        // try {
        //     Sample sample = new Sample();
        //     sample.hello("1", false);
        //     sample.hello("2", true);
        // } catch (Exception e) {
        //     e.printStackTrace(System.out);
        // }
        // System.out.println();

        // 对Sample类的hello方法进行拦截处理，返回增强后的字节码
        byte[] bytes = EnhanceUtil.enhanceClass(Sample.class, new String[]{"hello"}, SampleInterceptor.class);

        // HexDump.dump(bytes, 0, new FileOutputStream(new File("dum.txt")), 0);
        HexDump.dump(bytes);

        // 查看反编译结果
        //System.out.println(Decompiler.decompile(bytes));

        // 通过 reTransform 增强类
        AgentUtils.reTransform(Sample.class, bytes);

        // 启动Sample
        System.out.println("after retransform ...");
        try {
            Sample sample = new Sample();
            sample.hello("3", false);
            sample.hello("4", true);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
