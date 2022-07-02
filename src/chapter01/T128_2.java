package chapter01;
import java.util.*;
class ProcessData {
   private int   data[],max,min,avage;
   private boolean isReady;
   private void process(){
	   int min,max,avage;
	   
	   isReady=true;
	   max=data[0];min=data[0];avage=0;
	   for (int i=0;i<data.length;i++){
		   avage+=data[i];
		   if (data[i]<min)
			   min=data[i];
		   if (data[i]>max)
			   max=data[i];
	   }
	   
	   this.avage=avage/data.length;
	   this.max=max;
	   this.min=min;
   }
   int   getMax()  {
       if (!isReady)
		   process();
	   return max;
   }
   int  getMin()  {
       if (!isReady)
		   process();
	   return min;
   }
   int  getAvage() {
      if (!isReady)
		   process();
	  return avage;
   }
   int[]  setData(int[] data){
	   int len;
	   len=data.length;
	   this.data=new int[len];
	   for (int i=0;i<len;i++)
		   this.data[i]=data[i];
	   isReady=false;
	   return this.data;
   }
   int[] getData(){
	   return  data;
   }
} 

public class T128_2 {
	public static void main(String[] argv){
		int data[];
		Random random=new Random();
		ProcessData proceData=new ProcessData();
		
		data=new int[1000];
		for (int i=0;i<data.length;i++)
			data[i]=random.nextInt(100);
		
		proceData.setData(data);
		System.out.println("Min="+proceData.getMin());
		System.out.println("MAX="+proceData.getMax());
		System.out.println("Avage="+proceData.getAvage());		
	}	
}