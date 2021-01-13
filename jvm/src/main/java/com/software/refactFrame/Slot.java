package com.software.refactFrame;
//Java 语言有八个基本数据类型，分别为 boolean，char，byte，short，int，long，float，double，这八个基本类型从虚拟机的实现角度分为两组，分组的规则是占用空间的大小。
//32bit，使用 32bit 来表示的有 boolean, char, byte, short, int, float, 从严格角度讲，boolean 类型完全可以只用 1bit 来表示，但为了实现简单，我们依然采用 32bit 来实现。
//64bit，使用 64bit 来表示的有 long, double，因为必须要有 64bit 才能存下。
//从前序实验中也能看到一些端倪，比如常量池解析时 long 和 double 需要占用常量池两个位置。

import sun.security.jca.GetInstance;

public class Slot {

    // 基本类型
    public final int val;
    // 引用类型
    public final Instance ref;

    private Slot(int val, Instance ref) {
        this.val = val;
        this.ref = ref;
    }

    public static Slot val(int val) {
        return new Slot(val, null);
    }

    public static Slot ref(Instance ref) {
        return new Slot(0, ref);
    }

}
