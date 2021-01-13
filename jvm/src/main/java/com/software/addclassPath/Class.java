package com.software.addclassPath;

import com.software.readClassFile.ClassFile;

//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-5.html#jvms-5.4.2
//jvm中的class 加载流程
//将MethodInfo 转换成为Method 将FieldInfo也转换成为Field
//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-5.html#jvms-5.3
//ClassFile 是 class 二进制文件的对等对象，在实际使用中有所不便，比如获取类名，获取父类等操作需要解析字节数组再进行业务逻辑，因此需要另一个模型来承载业务逻辑，我们称之为 Class
public class Class {
    ClassFile classFile;
    /**
     * class 状态
     */
    int stat;
    String name;
    Class superClass;
    Method[] methods;

    public Class(String name, Class superClass, Method[] methods, ClassFile classFile) {
        this.name = name;
        this.superClass = superClass;
        this.methods = methods;
        this.classFile = classFile;

        if (methods != null) {
            for (Method method : methods) {
                method.clazz = this;
            }
        }
    }

}
