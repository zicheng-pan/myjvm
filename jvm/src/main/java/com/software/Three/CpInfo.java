package com.software.Three;

//JVM规范
//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4
public class CpInfo {

    U1 tag; // 标签，用来区分不同的常量池信息
    byte[] info; // 常量池信息内容

    public CpInfo(U1 tag, byte[] info) {
        this.info = info;
        this.tag = tag;
    }
}
