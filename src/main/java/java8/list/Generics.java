package java8.list;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

/**
 * <p>泛型</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/9
 * </pre>
 */
public class Generics {

    public static void main(String[] args){
        String a = ",a,,";

        a = a.replaceAll(","," , ");

        String[] strings = a.split(",");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }

        System.out.println(Arrays.asList(strings));



        String sss = "    ads    ";
        System.out.println(sss.trim());





        String b = ",a,,";
        String[] strings2 = split(b,",");
        System.out.println(Arrays.asList(strings2));




        String c = ",B,C,D,,F";
        strings2 = c.split(",");
        System.out.println(Arrays.asList(strings2));

        String d = ",a,,,,";
        strings2 = d.split(",");
        System.out.println(Arrays.asList(strings2));


        tee();
    }

    @Test
    void test(){
        String q = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


        String a = ",a,,,,asdf,,ab,,c,,";
        String[] strings = a.split(",");

        List<String> temp = new ArrayList();

        for (int i = 0; i < strings.length; i++) {
            String element = strings[i];
            if(element!=null && !"".equals(element)&& q.contains(element.trim()) && element.trim().length()==1){
                temp.add(element.trim().toUpperCase());
            }
        }

        System.out.println("======"+temp);
    }

    public static void tee(){


    }

    public static String[] split(String str, String delimiter) {
        if (str == null) {
            return null;
        }
        if (str.trim().length() == 0) {
            return new String[]{str};
        }

        int dellen = delimiter.length(); // del length
        int maxparts = (str.length() / dellen) + 2; // one more for the last
        int[] positions = new int[maxparts];

        int i, j = 0;
        int count = 0;
        positions[0] = -dellen;
        while ((i = str.indexOf(delimiter, j)) != -1) {
            count++;
            positions[count] = i;
            j = i + dellen;
        }
        count++;
        positions[count] = str.length();

        String[] result = new String[count];

        for (i = 0; i < count; i++) {
            result[i] = str.substring(positions[i] + dellen, positions[i + 1]);
        }
        return result;
    }


    public static <T, R extends Comparable<? super R>> Comparator<T> comparing(
            Function<? super T, ? extends R> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }



}
