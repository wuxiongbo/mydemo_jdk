package reflect.jdk_reflect.superclass;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/10/8
 * </pre>
 */
public class ClassUtil {
    /**
     * 获取这个类的所有父类
     * @param clazz
     * @return
     */
    public static List<Class<?>> getSuperClass(Class<?> clazz){
        List<Class<?>> clazzList = new ArrayList<Class<?>>();

        // 获取父类
        Class<?> suClass=clazz.getSuperclass();

        // 遍历添加 父类的父类
        while(suClass!=null){
            clazzList.add(suClass);
            suClass = suClass.getSuperclass();
        }

        return clazzList;
    }

    /**
     * 获取路径下所有的子类或接口现实类
     * @param cls
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getAllClass(Class<?> cls) throws ClassNotFoundException{
        List<Class<?>> clazzs=new ArrayList<>();
        for(Class<?> cl: getClazzList(cls)){
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
    public static List<Class<?>> getClazzList(Class<?> cls) throws ClassNotFoundException{
        String packageName = cls.getPackage().getName();
        String path=packageName.replace(".", "/");
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(path);
        return getClazzList(new File(url.getFile()), packageName);
    }


    /**
     * 迭代查找类
     * @param dir
     * @param packageName
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClazzList(File dir, String packageName) throws ClassNotFoundException{
        List<Class<?>> clazzs = new ArrayList<>();
        if(!dir.exists()){
            return clazzs;
        }
        for(File file : dir.listFiles()){
            if(file.toString().contains(".svn")){
                continue;
            }
            if(file.isDirectory()){
                clazzs.addAll(getClazzList(file,packageName+"."+file.getName()));
            }
            String name=file.getName();
            System.out.println( "file:"+name);
            if(name.endsWith(".class")){
                clazzs.add(Class.forName(packageName+"."+name.substring(0,(name.length()-6))));
            }
        }
        return clazzs;
    }

}
