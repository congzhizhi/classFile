package com.congzhizhi.asmbytecode.book.analysis.attribute;

import com.congzhizhi.asmbytecode.book.analysis.type.U2;
import com.congzhizhi.asmbytecode.book.analysis.type.U4;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValue_attribute {

    private U2 attribute_name_index;
    private U4 attribute_length;
    private U2 constantvalue_index;

}
