package leetcode;

public class Day03 {
    /**
     * 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target>nums[mid]){
                start=mid+1;
            }else if(target<nums[mid]){
                end=mid-1;
            }else if(target==nums[mid]){
                return mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] nums={1,3,5,6,11,12};
        int i = searchInsert(nums, 7);
        System.out.println(i);

    }
}
