package com.congzhizhi.asmbytecode.book.analysis.type.cp;

import com.congzhizhi.asmbytecode.book.analysis.type.CpInfo;
import com.congzhizhi.asmbytecode.book.analysis.type.U1;
import com.congzhizhi.asmbytecode.book.analysis.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_Fieldref_info extends CpInfo {

    private U2 class_index;
    private U2 name_and_type_index;

    public CONSTANT_Fieldref_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        class_index = new U2(codeBuf.get(), codeBuf.get());
        name_and_type_index = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Fieldref_info";
    }

}
