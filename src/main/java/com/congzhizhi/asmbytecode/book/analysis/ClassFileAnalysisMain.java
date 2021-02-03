package com.congzhizhi.asmbytecode.book.analysis;

import com.congzhizhi.asmbytecode.book.analysis.type.ClassFile;
import com.congzhizhi.asmbytecode.book.analysis.util.ClassAccessFlagUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class ClassFileAnalysisMain {

    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception("file not exists!");
        }
        byte[] byteCodeBuf = new byte[(int) file.length()];
        int lenght;
        try (InputStream in = new FileInputStream(file)) {
            lenght = in.read(byteCodeBuf);
        }
        if (lenght < 1) {
            throw new Exception("not read byte code.");
        }
        return ByteBuffer.wrap(byteCodeBuf, 0, lenght)
                .asReadOnlyBuffer();
    }

    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = readFile("D:\\codespace\\monitor_26\\target\\classes\\com\\caecc\\controller\\BusinesschainController.class");
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);

        Integer integer = classFile.getConstant_pool_count().toInt();

        System.out.println(integer);
//            System.out.println(data.toString());
//        Arrays.stream(classFile.getConstant_pool()).forEach(data->{
//        });

        System.out.println(ClassAccessFlagUtils.toClassAccessFlagsString(classFile.getAccess_flags()));




    }

}
