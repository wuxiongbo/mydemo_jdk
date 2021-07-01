package reflect.proxy.superclass;

import org.junit.jupiter.api.Test;
import reflect.proxy.Main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/17
 * </pre>
 */
public class Demo {
    @Test
    void test1(){
        String a  = "121";
        List<Class<?>> clazzs = getSuperClass(a.getClass());
        for (Class<?> clazz : clazzs) {
            System.out.println(clazz.toGenericString());
        }
    }

    @Test
    void test2(){
        try {
            System.out.println("获取路径下的所有类的文件名");
            for(Class<?> c: getAllClass(Main.class)){
                System.out.println(c.getName());
            }
            //System.out.println("子类");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取这个类的所有父类
     * @param clazz
     * @return
     */
    public static List<Class<?>> getSuperClass(Class<?> clazz){
        List<Class<?>> clazzs = new ArrayList<Class<?>>();
        Class<?> suCl=clazz.getSuperclass();
        while(suCl!=null){
            clazzs.add(suCl);
            suCl=suCl.getSuperclass();
        }
        return clazzs;
    }

    /**
     * 获取路径下所有的子类或接口现实类
     * @param cls
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getAllClass(Class<?> cls) throws ClassNotFoundException{
        List<Class<?>> clazzs=new ArrayList<>();
        for(Class<?> cl: getClazzs(cls)){
            if(cls.isAssignableFrom(cl)&&!cls.equals(cl)){
                clazzs.add(cl);
            }
        }
        return clazzs;
    }


    /**
     * 取得当路径下所有的子类
     * @param cls
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClazzs(Class<?> cls) throws ClassNotFoundException{
        String pk = cls.getPackage().getName();
        String path=pk.replace(".", "/");
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(path);
        return getClazzs(new File(url.getFile()), pk);
    }


    /**
     * 迭代查找类
     * @param dir
     * @param pk
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClazzs(File dir, String pk) throws ClassNotFoundException{
        List<Class<?>> clazzs = new ArrayList<>();
        if(!dir.exists()){
            return clazzs;
        }
        for(File file : dir.listFiles()){
            if(file.toString().contains(".svn")){
                continue;
            }
            if(file.isDirectory()){
                clazzs.addAll(getClazzs(file,pk+"."+file.getName()));
            }
            String name=file.getName();
            System.out.println( "file:"+name);
            if(name.endsWith(".class")){
                clazzs.add(Class.forName(pk+"."+name.substring(0,(name.length()-6))));
            }
        }
        return clazzs;
    }


}
