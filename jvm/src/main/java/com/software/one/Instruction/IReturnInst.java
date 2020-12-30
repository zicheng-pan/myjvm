package com.software.one.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

// ireturn
// 返回指令涉及到栈帧的一些特殊操作，暂时简单实现，输出操作数栈顶的数值
public class IReturnInst implements Instruct {

    @Override
    public void eval(Frame frame) {
        int temp = frame.operandStack.pop();
        System.out.println(temp);
        frame.pc += offset();
    }
}
