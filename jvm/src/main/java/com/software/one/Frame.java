package com.software.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//栈帧 对象
public class Frame {

    //程序计数器
    public int pc = 0;

    //本地变量表
    public final Map<Integer, Integer> localVars = new HashMap<Integer, Integer>();

    //操作数栈
    public final Stack<Integer> operandStack = new Stack<Integer>();

}
