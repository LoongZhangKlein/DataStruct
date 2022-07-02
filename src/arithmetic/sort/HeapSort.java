package arithmetic.sort;

import java.util.Arrays;

public class HeapSort {



    public static void heapSortUse(int[] arr) {
        //
        
        /**
         * (arr.length -1)/2是为了计算下层的非叶子节点
         * 当然截止条件是根节点 所以为0
         * 第一次: j=2
         * 第二次 j=1
         * 第三次  j=0
         *
         */
        for (int unLeaf = (arr.length -1)/2; unLeaf >= 0; unLeaf--) {
            heapSort(arr, unLeaf, arr.length);
        }
        // 按照我的理解是调整堆结构之前对重新排序的数组进行首元素和末尾元素之间的位置交换
        // 五个元素比大小 只需要比较四次即可
        for (int change = arr.length - 1; change > 0; change--) {
            int temp = arr[change];
            arr[change] = arr[0];
            arr[0] = temp;
            // todo 为什么每次都传入0  那不都从根节点开始吗?
            heapSort(arr, 0, change);

        }
    }

    public static void heapSort(int[] arr, int unLeaf, int len) {
        // 进行排序之前的元素标记
        int temp = arr[unLeaf];
        // todo
        /**
         * k代表第一个非叶子节点的左孩子
         * k = i * 2 + 1是找到非叶子节点的左孩子 k = i * 2 + 2是找到非叶子节点的右孩子
         *
         *找到入参的根节点的左节点,然后进行比较  若是右节点大于左节点
         * 然后拿右节点和小树的根节点进行比较  如果大于根节点就交换
         * 当然左节点小于右节点就不用判断了 直接拿右节点比较即可
         * 左右节点都小于根节点就没必要比较了
         *
         *第一次 i =2  k=5 不满足条件 直接退出
         * 第二次 i=1  k=3 满足条件 进入for循环
         * 第三次 i=0  k=1 满足 进入循环
         */
        for (int k = unLeaf * 2 + 1; k < len; k = k * 2 + 1) {
            // todo 为什么判断条件k+1<len&&
            /**
             * 按照 46859举例
             * 限制排序时发生 越界情况 当排序到45689时 689 经排好序但是 不加k+1<len时,仍满足该判断
             * 导致k++ 此时若K+1 >k 就会把已经排好序的序列重新排序,这样排序结束,后 最外层交换元素的云焕结束
             * 但此时排序还未结束
             *
             */

            if (k+1<len&&arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                // 此处将根节点右孩子的值和根节点的值进行交换
                arr[unLeaf] = arr[k];
                // todo 为什么要把赋给i
                // 为了完成后边arr[i] = temp的赋值
                unLeaf = k;
            }else {
                // 因为进行的是从底向上的交换  所以最底下不满足要求时可以直接退出循环
                break;
            }
        }
        /**
         *i的值被arr[i] = arr[k]覆盖  需要重新
         *
         *
         * 按照我输入得数组为例   4 6 8 5 9
         * 第一次  4 6 8 5 9
         * 执行到这里 由于不满足以上所有条件  因为 节点8是叶子节点  所以仍然是原数组
         * 第二次 4 9 8 5 9 执行116行  4 9 8 5 6
         *
         *
         *
        */
        arr[unLeaf] = temp;


    }


    public static void main(String[] args) {
        int[] params = new int[]{4, 6, 8, 5, 9,7,9,21};
        heapSortUse(params);
        System.out.println(Arrays.toString(params));
    }
}
