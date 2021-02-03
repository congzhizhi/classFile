package com.congzhizhi.asmbytecode.book.analysis.type.cp;

import com.congzhizhi.asmbytecode.book.analysis.type.CpInfo;
import com.congzhizhi.asmbytecode.book.analysis.type.U1;
import com.congzhizhi.asmbytecode.book.analysis.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_Class_info extends CpInfo {

    private U2 name_index;

    public CONSTANT_Class_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Class_info{" +
                "name_index=" + name_index.toInt() +
                '}';
    }

}
