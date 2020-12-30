package com.software.two;

import com.software.one.Instruct;
import com.software.one.Instruction.ILoad0Inst;
import com.software.one.Instruction.IReturnInst;
import com.software.one.Instruction.IStore0Inst;
import com.software.one.Instruction.Iconst1Inst;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseFile {

    //读取文件的内容编程集合再 执行
    public static Map<Integer, Instruct> parse(String file) {
        List<String> rawLines;
        try {
            // 获取文件的所有行
            rawLines = Files.readAllLines(Paths.get(file));
        } catch (Exception e) {
            System.out.println("file not found ?");
            return null;
        }

        if (rawLines.isEmpty()) {
            System.out.println("empty file");
            return null;
        }

        List<String> lines = rawLines.stream()
                .map(String::trim) // 消除首尾空格
                .map(it -> it.replaceAll(": ", " ")) // 替换冒号为空格
                .map(it -> it.replaceAll(", ", " ")) // 替换逗号为空格
                .map(it -> it.replaceAll(" +", " ")) // 多个空格合并
                .filter(it -> it.length() > 0)
                .collect(Collectors.toList());

        Map<Integer, Instruct> instructionMap = new HashMap<>();
        for (String raw : lines) {
            String[] terms = raw.split(" ");
            int pc = Integer.parseInt(terms[0]);
            String inst = terms[1];

            Instruct instruction = null;
            switch (inst.toLowerCase()) {
                case "iconst_1":
                    instruction = new Iconst1Inst();
                    break;
                case "istore_0":
                    instruction = new IStore0Inst();
                    break;
                case "iload_0":
                    instruction = new ILoad0Inst();
                    break;
                case "ireturn":
                    instruction = new IReturnInst();
                    break;
                default:
                    break;
            }

            if (instruction == null) {
                System.out.println("parse file failed. raw : " + raw);
                return null;
            }
            instructionMap.put(pc, instruction);
        }

        return instructionMap;
    }

}
