package java8.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> 合并组 </p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/9
 * </pre>
 */
public class MergeGroup {
    public static void main(String[] args) {
        List<List<String>> groupList = new ArrayList<>();

        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");
        b.add("3");
        List<String> c = new ArrayList<>();
        c.add("5");
        c.add("6");

        groupList.add(a);
        groupList.add(b);
        groupList.add(c);

        System.out.println(groupList);

        //合并后
        Map<Integer, List<String>> groupMap = new LinkedHashMap<>();

        Integer initKey = 1;
        if (isNotEmpty(groupList)) {
            for (List<String> group : groupList) {
                if (groupMap.get(initKey) == null) {
                    groupMap.put(initKey, group);
                } else {
                    // 有合并
                    boolean merged = false;
                    for (int i = 1; i <= initKey; i++) {
                        // 新答案组
                        List<String> newGroup = new ArrayList<>(groupMap.get(i));

//                        合并策略
                        boolean filter = contains(newGroup, group);
//                        boolean filter = isNotEmpty(overlap(newGroup,group));
                        if (filter) {
                            newGroup.addAll(group);
                            newGroup = newGroup.stream().distinct().sorted().collect(Collectors.toList());
                            groupMap.put(i, newGroup);
                            merged = true;
                            break;
                        }
                    }
                    if (!merged) {
                        groupMap.put(++initKey, group);
                    }
                }
            }

        }

        System.out.println(groupMap);


    }

    private static <T> boolean isNotEmpty(List<T> list) {
        return list != null && list.size() != 0;
    }


    private static <T> boolean contains(List<T> list1, List<T> list2) {
        return list1.containsAll(list2) || list2.containsAll(list1);
    }

    private static <T> List<T> overlap(List<T> list1, List<T> list2) {
        List<T> collect = list1.stream().filter(num -> list2.contains(num))
                .collect(Collectors.toList());
        return collect;
    }

}
