package java8.list;

import java8.list.bean.Answer;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * <p>List 按组分类</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/10
 * </pre>
 */
public class ListGroup {
    public static void main(String[] args){
        BigDecimal total = new BigDecimal("6");
        BigDecimal score = new BigDecimal("0");

        Map<String,Object> param = new HashMap<>(16);
        param.put("score",score);
        param.put("passed",0);

        String userAnswerStr = "B,F,A,G,F,F";

        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("1","B"));
        answerList.add(new Answer("2","D"));
        answerList.add(new Answer("3","A"));
        answerList.add(new Answer("4","G"));
        answerList.add(new Answer("5","F"));
        answerList.add(new Answer("6","C"));
        Map<Integer,List<String>> newGroupList = new LinkedHashMap<>();
        newGroupList.put(1,new ArrayList<>(Arrays.asList(new String[]{"2","5"})));
        newGroupList.put(2,new ArrayList<>(Arrays.asList(new String[]{"5","6"})));


        String[] userAnswerArr = filterOption(split(userAnswerStr));
        // 用户答案数组转集合并添加位置索引。
        List<Answer> userAnswerList = new ArrayList<>();
        for (int i = 0; i < userAnswerArr.length; i++) {
            userAnswerList.add(new Answer(String.valueOf(i+1),userAnswerArr[i]));
        }


        Map<String,Boolean> changed = new HashMap<>(16);
        for (Answer item : answerList) {
            changed.put(item.getNum(),false);
        }

        List<List<Answer>> list = re(answerList,newGroupList);
        List<List<Answer>> list2 = re(userAnswerList,newGroupList);


        BigDecimal totalScore = total;
        BigDecimal score1 = totalScore.divide(new BigDecimal(String.valueOf(answerList.size())),2,BigDecimal.ROUND_HALF_UP);
        BigDecimal score2 = totalScore.subtract(score1.multiply(new BigDecimal(String.valueOf(answerList.size()-1))));
        String lastIndex = answerList.get(answerList.size()-1).getNum();

        for (int i = 0; i < list.size(); i++) {
            List<Answer> standardAnswer = list.get(i);
            List<Answer> userAnswer = list2.get(i);
            // 判断包含关系。
            List<Answer> rightAnswers = check(standardAnswer, userAnswer);
            if(isEmpty(rightAnswers)){
                continue;
            }
            // 判断是否 最后一个空。
            for (Answer rightAnswer : rightAnswers) {
                String num = rightAnswer.getNum();
                if(!changed.get(num)){
                    score = score.add(num.equals(lastIndex)?score2:score1);
                    changed.put(num,true);
                }
            }

        }
        param.put("param",1);
        param.put("score",score);
        BigDecimal q= (BigDecimal)param.get("score");
        int q1= (int)param.get("param");
        System.out.println(q);
        System.out.println(q1);

    }



    /**
     * 字符串 转 数组。 统一转大写
     * @param a  待分割的字符串
     * @return
     */
    private static  String[] split(String a){
        a = a.replaceAll(","," , ");

        String[] strings = a.split(",");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim().toUpperCase();
        }
        return strings;
    }

    /**
     * 过滤 空选项、长度不符合要求的选项。
     * @return
     */
    private static String[] filterOption(String[] source){
        String option = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        List<String> temp = new ArrayList();
        for (int i = 0; i < source.length; i++) {
            String element = source[i];
            if(element!=null && !"".equals(element)&& option.contains(element.trim()) && element.trim().length()==1){
                temp.add(element.trim());
            }
        }
        return temp.toArray(new String[temp.size()]);
    }

    public static List<List<Answer>> re(List<Answer> answerList,Map<Integer,List<String>> newGroupList){

        List<List<Answer>> list = new ArrayList<>();

        int numbers = answerList.size();

        boolean[] flag = new boolean[numbers];
        for (int i = 0; i < flag.length; i++) {
            flag[i]=false;
        }

        // 将标准答案元素按索引分组。
        for (int i = 0; i < numbers; i++) {
            Answer item = answerList.get(i);
            AtomicBoolean inGroup = new AtomicBoolean(false);

            if(flag[i]==true){
                // 组内添加过，则不处理
                continue;
            }

            //当前答案在索引组内，则添加同组其他答案
            for (Map.Entry<Integer, List<String>> entry : newGroupList.entrySet()) {
                List<String> group = entry.getValue();
                // 元素没被添加过。并且在索引组内。
                if(!group.contains(item.getNum())){
                    continue;
                }
                List<Answer> temp = new ArrayList<>();
                // 添加当前元素所在组内的所有其他元素。
                for (String num : group) {
                    for (int j = 0; j < numbers; j++) {
                        if(answerList.get(j).getNum().equals(num)){
                            // 标记为已添加
                            flag[j]=true;
                            temp.add(answerList.get(j));
                        }
                    }
                }
                list.add(temp);
                // 将当前元素标记为在组内。
                inGroup.set(true);
                break;
            }

            // 当前答案没添加过，且不在任何索引组内。则单独为一组。
            if(!inGroup.get()){
                List<Answer> temp = new ArrayList<>();
                temp.add(item);
                flag[i]=true;
                list.add(temp);
            }

        }
        return list;
    }

    private static <T> boolean isNotEmpty(List<T> list){
        return list!=null&&list.size()!=0;
    }

    private static <T> boolean isEmpty(List<T> list){
        return !isNotEmpty(list);
    }

    private  static List<Answer> check( List<Answer> standardAnswer, List<Answer> userAnswer){
        if(isEmpty(standardAnswer) || isEmpty(userAnswer)){
            return null;
        }
        List<String> optList = userAnswer.stream().map(Answer::getOpt).collect(Collectors.toList());
        return standardAnswer.stream().filter(e-> optList.contains(e.getOpt())).collect(Collectors.toList());
    }

}
