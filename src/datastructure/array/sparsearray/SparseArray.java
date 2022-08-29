package datastructure.array.sparsearray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SparseArray {
    public static int[][] buildArray(int column,int line){
        return new int[column][line];
    }
    public static void print(int[][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }
    static void addNumber(int[][] array,int time){
        Random random = new Random();
        for (int i = 0; i < time; i++) {
            int column=random.nextInt(array[0].length);
            int line=random.nextInt(array.length);
            int number=random.nextInt(100);
            array[line][column]=number;
        }

    }
    static Integer effectiveNumber(int[][] arrays){
        int number=0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j]!=0){
                    number+=1;
                }
            }
        }
        return number;
    }

    static int[][] transToSparse(int[][] arrays){
        int number = effectiveNumber(arrays);
        int[][] sparse = buildArray(number+1, 3);
        sparse[0][0]=arrays.length;
        sparse[0][1]=arrays[0].length;
        sparse[0][2]=number;
        int line=1;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j]!=0){
                    sparse[line][0]=i;
                    sparse[line][1]=j;
                    sparse[line][2]=arrays[i][j];
                    line++;
                }
            }
        }
        return sparse;
    }
    static int[][] transToArrays(int[][] arrays){
        int line=arrays[0][0];
        int column=arrays[0][1];
        int[][] arr = buildArray(line, column);
        /**
         * 注释了的这个办法haolow
         */
        /*for (int i = 1; i < arrays.length; i++) {
            List<Integer> list = new ArrayList();
            int[] innerArray=arrays[i];
            for (int j = 0; j < innerArray.length; j++) {
                list.add(innerArray[j]);
            }
            arr[list.get(0)][list.get(1)]=list.get(2);
        }*/
        for (int i = 1; i < arrays.length; i++) {
           arr[arrays[i][0]][arrays[i][1]]=arrays[i][2];
        }
        return arr;
    }
    static void writeFile(int[][] arr){
        String path="src\\file\\array.txt";
        File file = new File(path);
        FileWriter fw=null;
        try {
             fw = new FileWriter(file);
           if (!file.exists()){
               file.createNewFile();
           }
            for (int i = 0; i <arr.length ; i++) {
                // 数组最后一行不加","
                for (int j = 0; j < arr[i].length-1; j++) {
                    fw.write(arr[i][j]+",");
                }
                fw.write(arr[i][arr[i].length-1]+"");
                fw.write("\n");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            //关闭流
            if (fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] ints = buildArray(3, 4);
        addNumber(ints,4);
        print(ints);
        System.out.println("===============");
        int[][] sparse = transToSparse(ints);
        writeFile(sparse);
        System.out.println("io完成");
        print(sparse);
        System.out.println("===============");
        int[][] in = transToArrays(sparse);
        print(in);
    }
}
