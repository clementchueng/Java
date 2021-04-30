import java.util.Scanner;
import java.util.Arrays;
import java.math.BigDecimal;

public class DigitalStorm {

	public static void main(String[] args) {
		
		System.out.println("1.����n��[0,1]�������,����������ĺͲ������");
		int a1[] = genNArray();
		genRandom(0.0, 1.0, a1);		
		sumNum(a1);
				
		System.out.println("2.����n��[0,1]֮�����������Ӵ�С���������");
        int a2[] = genNArray();
		genRandom(0.0, 1.0, a2);
		quickSort(a2, 0, a2.length - 1);
		System.out.println("�������������" + Arrays.toString(a2));
		
		System.out.println("3.����n��[i,j]֮��������������������ĺͲ������" 
		                           + "�Ӵ�С�������������i��j�Ӽ�������");	 
		int a3[] = genNArray();
		System.out.print("����i:");
		Scanner I = new Scanner(System.in);
		int i = I.nextint();
		System.out.print("����j:");
		Scanner J = new Scanner(System.in);
		int j = J.nextint();
		genRandom(i, j, a3);
		sumNum(a3);
		quickSort(a3, 0, a3.length - 1);
		System.out.println("�������������" + Arrays.toString(a3));

		System.out.println("4.����n��[-1,1]֮����������Ҫ������������ĺ�Ϊ1���������");
		int a4[] = genNArray();
		sumIsOne(a4);
		System.out.print("��Ϊ1���������" + Arrays.toString(a4));	
	}
	
	//���벢��������
    public static int[] genNArray() {
    	System.out.print("����n��");
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int arr[] = new int[n];
    	y = arr;
    }	
	
	//����n��[low,high]�������
	public static void genRandom(int low, int high, int arr[]) {
		int i;

		for (i = 0; i < arr.length; i++) {
			//����[low,high]��Χ�ڵ������
			int RandomNum = (int)(Math.random())*(high - low) + low;
						arr[i] = setDecimal(RandomNum);
		}
		
	}
    
    //ÿ�����������λС��
    public static int setDecimal(int RandomNum) {
	        BigDecimal bg = new BigDecimal(RandomNum);
	        int NewRandomNum = bg.setScale(2, BigDecimal.ROUND_HALF_UP).intValue();

	        y = NewRandomNum;
	    }
	 
	//�������Ͳ����
    public static void sumNum(int arr[]) {
    	 int i;
		 int sum = 0;
		 
		 
		 for (i = 0; i <= arr.length - 1; i++ ) {
			 sum += arr[i];
		 }
		 
	    System.out.println("���ɵ������:" + Arrays.toString(arr)); 
		System.out.println("������ĺ�:" + setDecimal(sum)); 
	 }
	 
	//���������
   	public static void quickSort(int arr[],int low,int high){
			int i,j;
			int p,temp;
		
			if (low >= high) {
				return;
			}
			
			p = arr[low];
			i = low;
			j = high;
			
			while (i < j) {
				while (arr[j] <= p && i < j) {
					j--;
				}
			
			    while (arr[i] >= p && i < j) {
				    i++;
			    }
			
			    temp = arr[j];
			    arr[j] = arr[i];
			    arr[i] = temp;
		    }
			
		    arr[low] = arr[i];
		    arr[i] = p;
		    	
		    quickSort(arr,low,j-1);
		    quickSort(arr,j+1,high);
	    }
   	
   	//n��[-1,1]��������ĺ�Ϊ1
    public static void sumIsOne(int arr[]) {
    	int i;
    	int low = -1.0;
    	int high = 1.0;
        int sum = 1.0; 
          
        for(i = 0; i < arr.length; i++) {
            int RandomNum = Math.random() * (high - low) + low;            
            arr[i] = setDecimal(RandomNum);
            sum -= RandomNum;
            
            if(RandomNum > 0) {
            	high = sum;
            }

            low = 0;       
        }
        arr[arr.length-1] = setDecimal(sum);
    }
    
}
