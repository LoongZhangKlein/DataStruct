package arithmetic.sort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 官方解答
     *
     * @param s
     * @param l
     * @param r
     */
    static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int left = l, right = r, x = s[l];
            while (left < right) {
                // 从右向左找第一个小于x的数
                while (left < right && s[right] >= x) {
                    right--;
                }

                if (left < right) {
                    s[left++] = s[right];
                }

                // 从左向右找第一个大于等于x的数
                while (left < right && s[left] < x) {
                    left++;
                }

                if (left < right) {
                    s[right--] = s[left];
                }

            }
            s[right] = x;
           /* quick_sort(s, l, left - 1);
            quick_sort(s, left + 1, r);*/
        }
    }


    public static void quickSortMine(int[] nums, int l, int r) {
        if(l<r){
            int left = l;
            int right = r;
            int pivot = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= pivot) {
                    right--;
                }
                if (left < right) {
                    nums[left++] = nums[right];
                }
                while (left < right && nums[left] < pivot) {
                    left++;
                }
                if (left < right) {
                    nums[right--] = nums[left];
                }


            }
            nums[left] = pivot;
            quickSortMine(nums, l, left - 1);
            quickSortMine(nums, left + 1, r);
        }

    }

    /**
     * 从大到小
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSortMineReverse(int[] nums, int l, int r) {
        if(l<r){
            int left = l;
            int right = r;
            int pivot = nums[left];
            while (left < right) {
                while (left < right && nums[right] <= pivot) {
                    right--;
                }
                if (left < right) {
                    nums[left++] = nums[right];
                }
                while (left < right && nums[left] > pivot) {
                    left++;
                }
                if (left < right) {
                    nums[right--] = nums[left];
                }


            }
            nums[left] = pivot;
            quickSortMineReverse(nums, l, left - 1);
            quickSortMineReverse(nums, left + 1, r);
        }

    }

    /**
     * 速度最快
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSortTwo(int[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int pivot = arr[l];
        int left = l;
        int right = r;
        while (left != right) {
            while (arr[right] >= pivot && right > left) {
                right--;
            }

            while (arr[left] <= pivot && right > left) {
                left++;
            }

            if (right > left) {
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        // right  和 left一样
        arr[l] = arr[left];
        arr[left] = pivot;
        quickSortTwo(arr, l, left - 1);
        quickSortTwo(arr, left + 1, r);

    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] arrOne = {6, 6, 2, -1, 9, 3, 4, 5, 3, 5, 10, 8};
        /*  quickSortTwo(arr, 0, arr.length - 1);*/
      /*  quick_sort(arrOne, 0, arrOne.length - 1);
        System.out.println(Arrays.toString(arrOne) + arrOne.length);*/
        quickSortMineReverse(arrOne, 0, arrOne.length - 1);
        System.out.println(Arrays.toString(arrOne) + arrOne.length);
    }
}
