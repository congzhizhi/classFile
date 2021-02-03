package com.congzhizhi.asmbytecode.book.analysis.type.cp;

import com.congzhizhi.asmbytecode.book.analysis.type.CpInfo;
import com.congzhizhi.asmbytecode.book.analysis.type.U1;
import com.congzhizhi.asmbytecode.book.analysis.type.U4;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_Integer_info extends CpInfo {

    private U4 bytes;

    public CONSTANT_Integer_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bytes = new U4(codeBuf.get(),codeBuf.get(),codeBuf.get(),codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Integer_info";
    }
}
