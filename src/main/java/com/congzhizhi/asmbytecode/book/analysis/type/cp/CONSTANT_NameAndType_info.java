package com.congzhizhi.asmbytecode.book.analysis.type.cp;

import com.congzhizhi.asmbytecode.book.analysis.type.CpInfo;
import com.congzhizhi.asmbytecode.book.analysis.type.U1;
import com.congzhizhi.asmbytecode.book.analysis.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_NameAndType_info extends CpInfo {

    private U2 name_index;
    private U2 descriptor_index;

    public CONSTANT_NameAndType_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        name_index = new U2(codeBuf.get(), codeBuf.get());
        descriptor_index = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_NameAndType_info";
    }

}
