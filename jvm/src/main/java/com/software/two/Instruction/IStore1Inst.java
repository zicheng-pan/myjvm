package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

public class IStore1Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.localVars.put(1, frame.operandStack.pop());
        frame.pc += offset();
    }
}
