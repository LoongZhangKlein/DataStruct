package arithmetic.search;

public class BinarySearch {
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int pivot=(left+right)/2;
            if (target<arr[pivot]){
                right=pivot-1;
            }else if (target>arr[pivot]){
                left=pivot+1;
            }else {
                return pivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,7,9,10,16,26,94,1001,1908};
        int i = binarySearch(a, 1908);
        System.out.println(i);

    }
}
