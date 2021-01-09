package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

//bipush 指令，指令参数为一个 byte 数字。
//指令作用是将指令参数数字推送到操作数栈栈顶。
public class BiPushInst implements Instruct {

    public final int val;

    public BiPushInst(int val) {
        this.val = val;
    }

    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(val);
        frame.pc += offset();
    }

    @Override
    public int offset() {
        return 2;
    }

}
