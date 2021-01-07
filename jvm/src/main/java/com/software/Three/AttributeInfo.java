package com.software.Three;

//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7
public class AttributeInfo {

    U2 attributeNameIndex; // 属性名索引
    U4 attributeLength; // 属性内容长度
    byte[] info; // 属性内容

    AttributeInfo(U2 attributeNameIndex, U4 attributeLength, byte[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }
}
