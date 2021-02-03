import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * Description: <br/>
 *
 * @Date: 2021/1/18 16:47<br/>
 * @Author Cong ZhiZzhi<br/>
 * @Version
 * @Since JDK 1.8
 */
public class T006_MSBClassLoader  extends ClassLoader {
    @Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
    File f = new File("D:\\",name.replace(".", "/").concat(".class"));
    try {
        FileInputStream fis = new FileInputStream(f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b = 0;

        while ((b=fis.read()) !=0) {
            baos.write(b);
        }

        byte[] bytes = baos.toByteArray();
        baos.close();
        fis.close();//可以写的更加严谨

        return defineClass(name, bytes, 0, bytes.length);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return super.findClass(name); //throws ClassNotFoundException
}

    public static void main(String[] args) throws Exception {



        ClassLoader l = new T006_MSBClassLoader();
        Class clazz  = l.loadClass("Hello");

        Object obj = clazz.newInstance();
        Method method =  clazz.getDeclaredMethod("test");
        method.invoke(obj);
    }


}
