package leetcode.hotproblems.Array;

public class MaxArea {
    // 一次考虑片面
//    public static int maxArea(int[] height) {
//        // 先找到最大底
//        int max = 0;
//        for (int i = 0; i < height.length-1; i++) {
//            int bottom = height.length-1 - i;
//            int high = Math.min(height[i], height[height.length-1]);
//            int area = bottom * high;
//            max=area > max ? area  : max;
//        }
//        return max;
//    }

    /**
     * 双指针做法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int head=0;
        int rear=height.length-1;
        int max=0;
        while (head!=rear){
            int area=(rear-head)*Math.min(height[head],height[rear]);
            max=max<area?area:max;
            if (height[head]<height[rear]){
                head++;
            }else{
                rear--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,3,4,5,18,17,6};
        int i = maxArea(a);
        System.out.println(i);
    }
}
