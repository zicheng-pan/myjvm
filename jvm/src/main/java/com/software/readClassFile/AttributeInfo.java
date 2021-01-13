package com.software.readClassFile;

//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7
public class AttributeInfo {

    public U2 attributeNameIndex; // 属性名索引
    public U4 attributeLength; // 属性内容长度
    public byte[] info; // 属性内容

    public AttributeInfo(U2 attributeNameIndex, U4 attributeLength, byte[] info) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
        this.info = info;
    }
}
