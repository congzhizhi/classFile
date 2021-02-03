package com.congzhizhi.asmbytecode.book.analysis.handler;

import com.congzhizhi.asmbytecode.book.analysis.type.ClassFile;
import com.congzhizhi.asmbytecode.book.analysis.type.U4;

import java.nio.ByteBuffer;

public class MagicHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        //连续读4个字节
        classFile.setMagic(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));
        if (!"0xCAFEBABE".equalsIgnoreCase(classFile.getMagic().toHexString())) {
            throw new Exception("这不是一个Class文件");
        }
    }

}
