package arithmetic.sort;

import java.util.Arrays;

public class RadixSort {
    /**
     * 简单的遍历 寻找数组中最大的数  用来确定执行的次数
     *
     * @param arr
     * @return
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 技术排序核心逻辑
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        // 获取数组中最大数值来确定的需要取余的次数
        int max = getMax(arr);
        // 算出需要执行的次数
        int length = (max + "").length();
        // 创建一个用来装填数据的桶 选用二维数组  当然 改进版本的桶排序可以选择arraysList
        int[][] bucket = new int[10][arr.length];
        /**
         * 作用
         * 1.创建一维数组用来给每个桶进行标号
         * 2.当排序完成后用来判断桶中装填数据的个数 从而方便从桶中取出数据
         *
         */

        int[] bucketFlag = new int[10];
        /**
         * 此处学习韩老师的写法 当然开辟了我的新大陆,虽然看着不太舒服  但是想用一下子(特地记录)
         * 其中的n是用来标记删除的次数
         * 比如124 取个位数 就是124%10  取十位数就是124/10%10  其余以此类推
         */
        for (int time = 0, n = 1; time < length; time++, n = n * 10) {
            for (int i = 0; i < arr.length; i++) {
                int mod = arr[i] / n % 10;
                /**
                 * 这里学的时候第一眼没看懂  决定自己实现 完成后发现是变量名字把自己搞得不太懂
                 * 其实就是把第i个元素 放到第 j 个桶中的第k个位置
                 * 例如:当124 取个位数 得到的余数数4就应该放到 第4个桶中的第一个位置
                 * 但是当另外一个数的取余结果仍然为4时就不应该继续方法标号为4的桶的第一个位置,
                 * 应该放到标号为4的桶的第二个位置
                 * 这就是bucketFlag的作用  所以下一行的bucketFlag[mod]++;的作用也就明确了
                 */
                bucket[mod][bucketFlag[mod]] = arr[i];
                bucketFlag[mod]++;
            }

            int k = 0;
            /**
             * 取出元素重新赋值给传入的数组
             * 这时候给桶来标号的数组的作用就可以看见了
             */
            for (int i = 0; i < bucketFlag.length; i++) {
                if (bucketFlag[i] != 0) {
                    for (int j = 0; j < bucketFlag[i]; j++) {
                        arr[k++] = bucket[i][j];
                    }
                }
                /**
                 * 没有想到的点
                 */
                bucketFlag[i] = 0;

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{44, 13, 32, 21, 35, 66, 187};
        /*radixSort(arr);*/
        System.out.println(124 / 10 % 10);

    }
}
