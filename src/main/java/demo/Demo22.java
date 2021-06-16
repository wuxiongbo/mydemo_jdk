package demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/9
 * </pre>
 */
public class Demo22 {
    public static void main(String[] args){
        List<List<String>> groupList = new ArrayList<>();

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        List<String> b = new ArrayList<>();
        b.add("2");
        b.add("4");
        List<String> c = new ArrayList<>();
        c.add("5");
        c.add("6");

        groupList.add(a);
        groupList.add(b);
        groupList.add(c);

        System.out.println(groupList);


        Map<Integer,List<String>> newGroupList = new LinkedHashMap<>();
        Integer initKey = 1;
        if (null != groupList && groupList.size() > 0) {
            Iterator it = groupList.iterator();
            while(it.hasNext()){
                List<String> item = (List<String>) it.next();
                if(newGroupList.get(initKey)==null){
                    newGroupList.put(initKey,item);
                }else{
                    //有交集
                    boolean add = true;
                    for (int i = 1; i <= initKey; i++) {
                        // 新答案组
                        List<String> temp = new ArrayList<>(newGroupList.get(i));
                        // 新答案组
                        if(isNotEmpty(overlap(temp,item))){
                            newGroupList.get(i).addAll(item);
                            List<String> collect = newGroupList.get(i).stream().distinct().collect(Collectors.toList());
                            newGroupList.put(i,collect);
                            add=false;
                        }
                    }
                    if(add){
                        newGroupList.put(++initKey,item);
                    }
                }

            }
        }

        System.out.println(newGroupList);


    }

    static boolean isNotEmpty(List<String> list){
        return list!=null&&list.size()!=0;
    }


    private static <T> List<T> overlap(List<T> list1,List<T> list2){
        List<T> collect = list1.stream().filter(num -> list2.contains(num))
                .collect(Collectors.toList());
        return collect;
    }

}
