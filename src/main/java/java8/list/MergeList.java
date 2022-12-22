package java8.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>集合交集</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/2
 * </pre>
 */
public class MergeList {
    public static void main(String[] args){
//      Integer a= null;
//      System.out.println(a>1);

//        String [] a = {"A","B","C","E","D"};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

//        int numbers = 9;
//        BigDecimal totalScore = new BigDecimal("10");
//
//        BigDecimal score1 = totalScore.divide(new BigDecimal(String.valueOf(numbers)),2,BigDecimal.ROUND_HALF_UP);
//        BigDecimal score2 = totalScore.subtract(score1.multiply(new BigDecimal(String.valueOf(numbers-1))));
//
//        System.out.println(score1);
//        System.out.println(score2);



//        List<String> a = new ArrayList<String>();
//        a.add("A");
//        a.add("B");
//        a.add(null);
//        boolean is= a.contains(null);
//        System.out.println(is);

//        Comparator<String> comparator = (o1, o2)->o1.compareTo(o2);
//        List<String> a = new ArrayList<>();
//        a.add("1");a.add("5");
//        a.add("3");a.add("4");
//        a.add("2");a.add("7");
//        Collections.sort(a,comparator);
//        System.out.println(a);
//
//
//        List<String> b = new ArrayList<>();
//        b.add("1");b.add("5");
//        b.add("3");b.add("4");
//        b.add("2");b.add("7");
//        Collections.sort(b);
//        System.out.println(b);

//        LinkedHashSet<String> objects = new LinkedHashSet<>();

//        HashMap<Integer, String> hashMap = new HashMap<>();
//        System.out.println(hashMap.get(1));

        //===================集合交集 方法一 ========================
        String s1 =             "50000,100000,200000,300000,500000,";
        String s2 = "10000,30000,50000,100000,";
        String[] a1 = s1.split(",");
        String[] a2 = s2.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(a1));
        boolean a = list.retainAll(Arrays.asList(a2));
        System.out.println(a);
        for(String s : list){
            System.out.println(s);
        }

        s1 =       "c,a,a,a,a,e";
        s2 = "d,b,d,c,a";
//        s2 =       "c,a,a,a,a,e";
//        s1 = "d,b,d,c,a";
        a1 = s1.split(",");
        a2 = s2.split(",");
        list = new ArrayList(Arrays.asList(a1));
        // 不能用返回值来判断两个集合中是否有交集!!!
        a = list.retainAll(Arrays.asList(a2));
        System.out.println(a);
        for(String s : list){
            System.out.println(s);
        }


        s1 = "c,a,a,a,a";
        s2 = "c,a";
        a1 = s1.split(",");
        a2 = s2.split(",");
        list = new ArrayList(Arrays.asList(a1));
        // 不能用返回值来判断两个集合中是否有交集!!!
        a = list.retainAll(Arrays.asList(a2));
        System.out.println(a);
        for(String s : list){
            System.out.println(s);
        }


        //===================集合交集  方法二 ========================

        List<String> list1 = new ArrayList(Arrays.asList(a1));
        List<String> list2 = new ArrayList(Arrays.asList(a2));

        List<String> collect1 = list1.stream().distinct().filter(num -> list2.contains(num))
                .collect(Collectors.toList());

        System.out.println("交集");
        collect1.stream().forEach(System.out::println);

    }
}
