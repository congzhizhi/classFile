package java.com.congzhizhi.asmbytecode.book.analysis;

import com.wujiuye.asmbytecode.book.second.type.ClassFile;
import org.junit.Test;

import java.nio.ByteBuffer;

public class MagicAndVersionTest {

    @Test
    public void testMagicAndVersionHandler() throws Exception {
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile("/Users/wjy/MyProjects/asm-bytecode-project/build/classes/java/main/com/congzhizhi/asmbytecode/book/vmstack/RecursionAlgorithmMain.class");
        ClassFile classFile = ClassFileAnalysiser.analysis(codeBuf);
        System.out.println(classFile.getMagic().toHexString());
        System.out.println(classFile.getMinor_version().toInt());
        System.out.println(classFile.getMagor_version().toInt());
    }

}
