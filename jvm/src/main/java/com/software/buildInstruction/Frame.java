package com.software.buildInstruction;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//栈帧 对象
public class Frame {

    //程序计数器 没有OOM的问题
    public int pc = 0;

    //本地变量表  用来存放 this变量->方法中的其他形参->方法内部定义的局部变量
    public final Map<Integer, Integer> localVars = new HashMap<Integer, Integer>();

    //操作数栈  主要用于保存计算过程的中间结果，同时作为计算过程中变量临时的存储空间。
    //操作数栈就是JVM执行引擎的一个工作区，当一个方法刚开始执行的时候，一个新的栈帧也会随之被创建出来，这时方法的操作数栈是空的（这个时候数组是有长度的，只是操作数栈为空）
    public final Stack<Integer> operandStack = new Stack<Integer>();

}
