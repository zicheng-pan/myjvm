package com.software.Three;

// 方法信息
//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.6
class MethodInfo {

    U2 accessFlags; // 访问标志
    U2 nameIndex; // 方法名索引
    U2 descriptorIndex; // 方法描述符索引
    U2 attributesCount; // 属性数
    AttributeInfo[] attributes; // 属性

    public MethodInfo(U2 accessFlags,
                      U2 nameIndex,
                      U2 descriptorIndex,
                      U2 attributesCount,
                      AttributeInfo[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }
}
