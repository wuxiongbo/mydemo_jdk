package classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * <p>自定义类加载器 示例</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/7/26
 * </pre>
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        /**
         * 私有方法，根据类名查找class文件，并读取为的字节数组
         * @param name
         * @return
         * @throws Exception
         */
        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);

                //defineClass：将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

    }

    public static void main(String args[]) throws Exception {
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:\\workspace\\wxb\\demo\\target\\classes");


        // 实例化
        Class clazz = classLoader.loadClass("classloader.AccountDemo");
        Object obj = clazz.newInstance();

        // 调用方法
        Method method = clazz.getDeclaredMethod("operation", null);
        method.invoke(obj, null);


        System.out.println(clazz.getClassLoader().getClass().getName());

    }
}
