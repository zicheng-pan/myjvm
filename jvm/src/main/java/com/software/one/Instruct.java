package com.software.one;

// 指令
public interface Instruct {

    // offset, 字长， 因为字节码的长度不一致，一般情况下是 1，此处提供默认方法用来获取指定的字长。用来在指令结束时改变栈帧的程序计数器，使之指向下一条指令。
    default int offset() {
        return 1;
    }

    void eval(Frame frame);

}
