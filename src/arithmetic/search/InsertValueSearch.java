package arithmetic.search;

public class InsertValueSearch {
    public static int insertValueSearch(int[] arr,int left,int right,int value){
        if (left>right||value<arr[left]||value>arr[right]){
            return -1;
        }
        /**
         * 这个算法的精髓就是 这个公式了  但是我还没搞明白这个公式是为什么
         */
        int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        if (value>arr[mid]){
            return insertValueSearch(arr,mid+1,right,value);
        }else if (value<arr[mid]){
            return insertValueSearch(arr,left,mid-1,value);
        }else {
            return mid;
        }

    }
    public static void main(String[] args) {
        int[] a=new int[]{1,3,5,7,9,10,16,26,94,1001,1908};
        int i = insertValueSearch(a, 0,a.length-1,1908);
        System.out.println(i);
    }
}
