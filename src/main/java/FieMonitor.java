import org.apache.log4j.helpers.FileWatchdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * Description: <br/>
 *
 * @Date: 2021/1/18 16:53<br/>
 * @Author Cong ZhiZzhi<br/>
 * @Version
 * @Since JDK 1.8
 */
public class FieMonitor {
   static ClassLoader l = new T006_MSBClassLoader();

        public static void main(String[] args)
        {
            GloablConfig gloablconfig = new GloablConfig("D:\\Hello.class");
            gloablconfig.setDelay(10000);
            gloablconfig.start();
            while (true)
            {
                try
                {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        public static class GloablConfig extends FileWatchdog
        {
            protected GloablConfig(String filename)
            {
                super(filename);
            }
            @Override
            protected void doOnChange()
            {
                System.out.println("监听");
                l =null;
                l = new T006_MSBClassLoader();
                Class clazz = null;
                try {
                    clazz = l.loadClass("Hello");
                Object obj = clazz.newInstance();
                Method method =  clazz.getDeclaredMethod("test");
                method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }


}
