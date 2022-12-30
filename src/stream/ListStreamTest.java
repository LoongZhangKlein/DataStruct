package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-20-15:01
 */

public class ListStreamTest {
    static List<User> addUser(){

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setName(UUID.randomUUID().toString());
            user.setAge(String.valueOf(i));
            user.setCode(String.valueOf(i));
            user.setSex(String.valueOf(i));
            user.setType(String.valueOf(i));
            userList.add(user);
        }
        userList.forEach(user -> System.out.println(user));
        return userList;
    }

    static void mergeUser(List<User> userList){
//        Map<String, List<User>> collectToMap = userList.stream().collect(Collectors.groupingBy(user ->
//                user.getCode() + user.getType()
//        ));
//        collectToMap.forEach((k,v)->{
//            System.out.println(k+"========>"+v);
//        });
        // todo 这里加上Collectors.toList()这个有啥区别吗?
        Map<String, List<User>> collectToMapSuper = userList.stream().collect(Collectors.groupingBy(user ->
                (user.getCode() + user.getType()), Collectors.toList()
        ));
        List<User> newUserList = new ArrayList<>();

        collectToMapSuper.forEach((id,transfer)->{
            transfer.stream().reduce((a,b)->
                    new User(a,b)
            ).ifPresent(newUserList::add);
        });
        System.out.println("以下是新组成的用户集合");
        newUserList.forEach(res->{
            System.out.println(res);
        });
    }
    static void filterList(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter(res->
            res>5).forEach(System.out::println);
        Integer first = list.stream().filter(res ->
                res > 6
        ).findFirst().get();
        System.out.println("匹配的第一个元素"+first);


    }
    static void mapTest(){
        String[] strArr = { "aCDd", "bcDDd", "defDDe", "fTr" };
        // 并非终结流
        List<String> collectString = Arrays.stream(strArr).map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(collectString);
        List<Integer> integersList = Arrays.asList(1, 2, 3, 4, 5, 65, 6);
        List<Integer> collectInteger = integersList.stream().map(integer -> integer + 3).collect(Collectors.toList());
        System.out.println(collectInteger);


        //List<String> collect = Arrays.stream(strArr).map(String::toLowerCase);
    }

    /**
     * 将两个字符数组合并成一个字符数组
     *
     * @param
     */
    static void mergeCharArray(){
        List<String> listOne = Arrays.asList("1,2,3,4");
        List<String> listTwo = Arrays.asList("4,5,6,7");
        List<List<String>> lists = Arrays.asList(listOne, listTwo);
        List<String> list = Arrays.asList("1,2,3,4","4,5,6,7");
        System.out.println("合并后的字符数组"+lists);
        System.out.println("字符数组"+list);
        List<String> collectString = list.stream().flatMap(res -> {
            Stream<String> stream = Arrays.stream(res.split(","));
            return stream;
        }).collect(Collectors.toList());
        System.out.println("合并后的字符数组"+collectString);
    }

    /**
     * 测试规约
     */
    static void testReduce(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        Integer sum = list.stream().reduce((x, y) -> x + y).get();
        System.out.println(sum);
        Integer sumTwo = list.stream().reduce(1000, Integer::sum);
        System.out.println(sumTwo);
    }

    /**
     * 测试归并物料
     */
    static void testReduceForMerge(){
        List<User> userList = addUser();
        List<User> newUserList = new ArrayList<>();
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(o -> (o.getCode() + o.getType()), Collectors.toList()));
        collect.forEach((id,transfer)->{
            transfer.stream().reduce((a,b)->
                    new User(a,b)
            ).ifPresent(newUserList::add);
        });
        newUserList.stream().forEach(res-> System.out.println(res));
    }
    public static void main(String[] args) {
       // List<User> userList = addUser();
        //mergeUser(userList);
        //filterList();
//        mapTest();
        //mergeCharArray();
        testReduceForMerge();
        //testReduce();
    }
}
