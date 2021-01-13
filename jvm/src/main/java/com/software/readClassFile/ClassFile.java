package com.software.readClassFile;

// 定义class 文件
public class ClassFile {

    public U4 magic; // 魔数
    public U2 minorVersion; // minor_version
    public U2 majorVersion; // major_version
    public U2 constantPoolCount; // 常量池大小
    public CpInfo[] constantPool; // 常量池
    public U2 accessFlags; // 访问标志
    public U2 thisClass; // 当前类名索引
    public U2 superClass; // 父类类名索引
    public U2 interfacesCount; // 接口数
    public U2[] interfaces; // 接口
    public U2 fieldsCount; // 字段数
    public FieldInfo[] fields; // 字段
    public U2 methodsCount; // 方法数
    public MethodInfo[] methods; // 方法
    public U2 attributesCount; // 属性数
    public AttributeInfo[] attributes; // 属性

    public ClassFile(
            U4 magic,
            U2 minorVersion,
            U2 majorVersion,
            U2 constantPoolCount,
            CpInfo[] constantPool,
            U2 accessFlags,
            U2 thisClass,
            U2 superClass,
            U2 interfacesCount,
            U2[] interfaces,
            U2 fieldsCount,
            FieldInfo[] fields,
            U2 methodsCount,
            MethodInfo[] methods,
            U2 attributesCount,
            AttributeInfo[] attributes) {
        this.magic = magic;
        this.minorVersion = minorVersion;
        this.majorVersion = majorVersion;
        this.constantPoolCount = constantPoolCount;
        this.constantPool = constantPool;
        this.accessFlags = accessFlags;
        this.thisClass = thisClass;
        this.superClass = superClass;
        this.interfacesCount = interfacesCount;
        this.interfaces = interfaces;
        this.fieldsCount = fieldsCount;
        this.fields = fields;
        this.methodsCount = methodsCount;
        this.methods = methods;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }
}
