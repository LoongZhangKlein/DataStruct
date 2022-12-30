package leetcode.hotproblems.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author loongzhang
 * @Description 合并有序的链表 难度 简单!
 * @date 2022-12-29-12:20
 */

public class MergeSortList {
    /**
     * 思路:
     * 1.若是按照顺序进行插入
     *      A 插入B表 且保证b表相同元素在前
     *      按照如下逻辑
     *          实现方法一:
     *              依次循环比较插入实现
     *              性能分析:
     *              最low
     *          实现方法二:(但是此方法无效)
     *              直接合并集合,然后进行排序,但是此种方法并不能保证谁前谁后
     *          实现方法三:将A链表中的所有数据加入B链表,在对数据进行逐个比较(笨办法)
     *
     *
     *
     */


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void sort(ListNode listNode1,ListNode listNode2){
        while (listNode1.next!=null){

        }
    }
    public static void main(String[] args) {

    }
}
