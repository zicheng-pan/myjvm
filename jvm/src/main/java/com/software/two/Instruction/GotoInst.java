package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;
//goto 指令，指令参数是个 int 数字。指令作用是无条件将程序计数器设置为指令参数的值。
public class GotoInst implements Instruct {

    public final int offset;

    public GotoInst(int offset) {
        this.offset = offset;
    }

    @Override
    public void eval(Frame frame) {
        frame.pc = offset;
    }

    @Override
    public int offset() {
        return 3;
    }
}
