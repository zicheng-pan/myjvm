package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;
//if_icmpgt 指令，指令参数是个 int 数字，指令需要拆开来理解，if、i、cmp、gt，if 表控制，i 是指令的操作数据类型，与之前提到的一致，为 int 类型，cmp，compare 缩写，表比较，gt, greater than 缩写，表示大于。
//指令作用是比较栈顶两个数的大小，将栈顶两个数出栈，如果后出栈的数字大于先出栈的数字，那么将程序计数器设置为指令参数对应的值，否则正常进行下一指令。

public class IfICmpGtInst implements Instruct {

    public final int offset;

    public IfICmpGtInst(int offset) {
        this.offset = offset;
    }

    @Override
    public void eval(Frame frame) {
        int v2 = frame.operandStack.pop();
        int v1 = frame.operandStack.pop();
        if (v1 > v2) {
            frame.pc = offset;
        } else {
            frame.pc += offset();
        }
    }

    @Override
    public int offset() {
        return 3;
    }

}
