package java8.list;

import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>jdk8 distinct去重 后的顺序</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/10
 * </pre>
 */
public class ListDistinct {
    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");

        a.addAll(b);

        System.out.println(a);

        a = a.stream().sorted().distinct().collect(Collectors.toList());

        System.out.println(a);

        List<String> collect = a.stream().filter(e -> e.equals("1")).collect(Collectors.toList());
        System.out.println(collect);
    }



    /**
     * 答案组 合并。
     * 策略1，交叉：[1,2];[2,3]; 合并为 [1,2,3]
     * 策略2，包含：[1,2,3];[2,3]; 合并为 [1,2,3]
     * @return
     */
    @Test
    public  void mergeGroup(){
        List<List<String>> groupList = new ArrayList<>();
        List<String> a = new ArrayList<>(Arrays.asList(new String[]{"1","2","3"}));
        List<String> b = new ArrayList<>(Arrays.asList(new String[]{"2","3"}));
        groupList.add(a);
        groupList.add(b);



        //  用来存放合并后的组。
        Map<Integer,List<String>> groupMap = new LinkedHashMap<>();

        Integer initKey = 1;
        for (List<String> group : groupList) {
            if(groupMap.get(initKey)==null){
                groupMap.put(initKey,group);
            }else{
                // 遍历 合并后的组，查找当前组是否有交集。没有交集需要添加新集合。
                boolean merged = false;
                for (int i = 1; i <= initKey; i++) {
                    List<String> newGroup = new ArrayList<>(groupMap.get(i));

                    // 合并策略。交叉/包含
//                    if(CollectionKit.isEmpty(overlap(newGroup,group))){
//                        continue;
//                    }
                    if(!contains(newGroup,group)){
                        continue;
                    }

                    // 合并后的组 与 当前答案组有交集。则添加当前答案组的其他元素后去重。
                    newGroup.addAll(group);
                    newGroup = newGroup.stream().sorted().distinct().collect(Collectors.toList());
                    groupMap.put(i,newGroup);
                    merged = true; //已合并，后续不需要添加集合。
                    break;
                }
                if(!merged){
                    groupMap.put(++initKey,group);
                }
            }
        }
        System.out.println(groupMap);

    }

    private static <T> boolean contains(List<T> list1,List<T> list2){
        return (CollectionUtils.isNotEmpty(list1)&&CollectionUtils.isNotEmpty(list2))
                &&(list1.containsAll(list2) || list2.containsAll(list1));
    }

}
