package java8.list;

import java8.list.bean.Data1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>描述类的信息</p>
 *
 * <pre>
 * @author wuxiongbo
 * @date 2021/6/16
 * </pre>
 */
public class FlatMap {

    @Test
    public void intersectByKeyTest(){
        List<Data1> listOfData2 = new ArrayList<>();
        listOfData2.add(new Data1(10501, "JOE"  , 100));
        listOfData2.add(new Data1(10603, "SAL"  , 100));
        listOfData2.add(new Data1(40514, "PETER", 100));
        listOfData2.add(new Data1(59562, "JIM"  , 100));
        listOfData2.add(new Data1(29415, "BOB"  , 100));
        listOfData2.add(new Data1(61812, "JOE"  , 100));

        listOfData2.add(new Data1(98432, "JOE"  , 100));
        listOfData2.add(new Data1(62556, "JEFF" , 100));
        listOfData2.add(new Data1(10599, "TOM"  , 100));


        List<Data1> listOfData1 = new ArrayList<>();
        listOfData1.add(new Data1(10501, "JOE"    ,3000000));
        listOfData1.add(new Data1(10603, "SAL"    ,6225000));
        listOfData1.add(new Data1(40514, "PETER"  ,2005000));
        listOfData1.add(new Data1(59562, "JIM"    ,3000000));
        listOfData1.add(new Data1(29415, "BOB"    ,3000000));
        listOfData1.add(new Data1(61813, "JOE"  , 3000000));

        List<Integer> ids = listOfData2.stream().map(Data1::getId).collect(Collectors.toList());
        for (Data1 data1 : listOfData1) {
            if(!ids.contains(data1.getId())){
                listOfData2.add(data1);
            }
        }

        System.out.println(listOfData2);
    }
}

