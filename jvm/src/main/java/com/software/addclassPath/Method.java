package com.software.addclassPath;

import com.software.buildInstruction.Instruct;
import com.software.readClassFile.Code;

import java.util.Map;

public class Method {
    int accessFlags;
    String name;
    String descriptor;
    Code code;
    Class clazz;

    public Method(int accessFlags, String name, String descriptor, Code code) {
        this.accessFlags = accessFlags;
        this.name = name;
        this.descriptor = descriptor;
        this.code = code;
    }

    public Map<Integer, Instruct> getInstructions() {
        return this.code.getInstructions(clazz.classFile.constantPool);
    }
}
