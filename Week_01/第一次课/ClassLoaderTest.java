package JavaTest;

import java.io.*;
import java.lang.reflect.Method;

public class ClassLoaderTest extends ClassLoader {

        public static void main(String[] args)throws Exception{
            ClassLoaderTest classLoaderTest=new ClassLoaderTest();
            Class<?> cls=classLoaderTest.findClass("Hello");
            Method hello=cls.getDeclaredMethod("hello");
            hello.setAccessible(true);
            hello.invoke(cls.newInstance());
        }
            //匿名内部类实现自定义类加载器
    @Override
    protected Class<?> findClass(String name){
            String filePath="C:\\Users\\wmt\\Desktop\\myStudy\\JavaCourse\\myJava_code\\JAVA-000" +
                    "\\Week_01\\Hello\\" +name+".xlass";
            File file=new File(filePath);
        InputStream in=null;
        if(file.exists()){
            try {
                in=new FileInputStream(file);
                byte[] b=new byte[in.available()];
                in.read(b, 0, b.length);
                for(int i=0;i<b.length;i++){
                    b[i]= (byte) (255-b[i]);
                }
                return defineClass(name,b,0,b.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
