package com.software.one.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

//将常量 1 推送到当前栈帧的操作数栈栈顶。
public class Iconst1Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(1);
        frame.pc += offset();
    }
}
