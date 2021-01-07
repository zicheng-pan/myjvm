package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

public class IConst0Inst implements Instruct {

    //
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(0);
        frame.pc += offset();
    }
}
