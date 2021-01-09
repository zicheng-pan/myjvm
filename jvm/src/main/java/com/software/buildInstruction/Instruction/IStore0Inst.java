package com.software.buildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

//将当前栈帧的操作数栈顶数据弹出，并放到本地变量表的 0 位置。
public class IStore0Inst implements Instruct {

    @Override
    public void eval(Frame frame) {
        frame.localVars.put(0, frame.operandStack.pop());
        frame.pc += offset();
    }
}
