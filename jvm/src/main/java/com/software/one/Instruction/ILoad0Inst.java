package com.software.one.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

//获取本地变量表的 0 位置数据取出，并推送到操作数栈栈顶。
public class ILoad0Inst implements Instruct {

    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(frame.localVars.get(0));
        frame.pc += offset();
    }
}
