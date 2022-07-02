package chapter01;


import java.util.Random;

public class T128_1 {
    public int getNumber() {
        Random random = new Random();
        int numb = random.nextInt(100);
        return numb;
    }

    public int[][] getArrary(int data, int array[][]) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = data;
            }
        }
        return array;
    }

    public int[][] getMaxMinAvg(int array[][]) {
        int max,min,avg;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int maxNumb=array[i][j];
                if (array[i][j]<maxNumb){
                    max=maxNumb;
                }else {
                    max=array[i][j];
                }
            }
        }
        return array;
    }

    public static void main(String args[]) {
        int data[][], relt[], row, col;
        data = new int[4][6];


    }
}
