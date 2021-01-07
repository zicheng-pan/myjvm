package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

public class ILoad2Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(frame.localVars.get(2));
        frame.pc += offset();
    }
}
