package demo;

import lombok.Data;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/10
 * </pre>
 */
public class Demo1232 {
    public static void main(String[] args){
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("1","B"));
        answerList.add(new Answer("2","D"));
        answerList.add(new Answer("3","A"));
        answerList.add(new Answer("4","G"));
        answerList.add(new Answer("5","F"));
        answerList.add(new Answer("6","C"));

        Map<Integer,List<String>> newGroupList = new LinkedHashMap<>();
        newGroupList.put(1,new ArrayList<>(Arrays.asList(new String[]{"2","3","5"})));
        newGroupList.put(2,new ArrayList<>(Arrays.asList(new String[]{"4","6"})));

        int numbers = answerList.size();

        boolean[] flag = new boolean[numbers];
        for (int i = 0; i < flag.length; i++) {
            flag[i]=false;
        }

        List<List<Answer>> list = new ArrayList<>();

        // 将标准答案元素按索引分组。
        for (int i = 0; i < numbers; i++) {
            Answer item = answerList.get(i);
            int index = i;
            AtomicBoolean inGroup = new AtomicBoolean(false);

            if(flag[index]==true){
                // 组内添加过，则不处理
                continue;
            }

            //当前答案在索引组内，则添加同组其他答案
            newGroupList.forEach((k, goup) ->{
                // 元素没被添加过。并且在索引组内。
                if(flag[index]==false && goup.contains(item.getNum())){
                    List<Answer> temp = new ArrayList<>();
                    // 添加当前元素所在组内的所有其他元素。
                    for (String loca : goup) {
                        for (int j = 0; j < numbers; j++) {
                            if(answerList.get(j).getNum().equals(loca)){
                                // 标记为已添加
                                flag[j]=true;
                                temp.add(answerList.get(j));
                            }
                        }
                    }
                    list.add(temp);
                    // 将当前元素标记为在组内。
                    inGroup.set(true);
                }
            });

            // 当前答案没添加过，且不在任何索引组内。则单独为一组。
            if(flag[index]==false && !inGroup.get()){
                List<Answer> temp = new ArrayList<>();
                temp.add(item);
                flag[i]=true;
                list.add(temp);
            }

        }

        System.out.println(list);

    }


    @Data
    static class Answer{
        String num;
        String opt;
        public Answer(String num,String opt){
            this.num = num;
            this.opt = opt;
        }
    }

}
