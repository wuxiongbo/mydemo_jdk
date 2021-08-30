package java8;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/8/19
 * </pre>
 */
public class StringDemo {
    public static void main(String[] args){

//        String a = "/data/uploadApp_tmp/";
//        String s = a.replaceFirst("/", "");
//        System.out.println(s);

        String l = "1428321048241283073";
        System.setProperty(l,"2131235432");
        Long lLong1 = Long.valueOf(l);
        Long lLong2 = Long.getLong(l);
        System.out.println(lLong1);
        System.out.println(lLong2);


        String split = "/";
        String a = "/data/uploadApp_tmp/ ";
        a = a.trim();
        int firstIndex = 0;
        int lastIndex = a.length();
        if(a.startsWith(split)){
            firstIndex++;
        }
        if(a.endsWith(split)){
            lastIndex--;
        }
       System.out.println(a.substring(firstIndex,lastIndex));

    }
}
