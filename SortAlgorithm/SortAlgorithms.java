import java.util.Arrays;

public class SortAlgorithms {    

	public static void main(String[] args) {
		int A[] = {2, 4, 7, 6, 8, 5, 9};
		int B[] = {6, 4, 8, 9, 5, 4, 7};
		int C[] = {5, 4, 7, 9, 6, 3, 1};
		int D[] = {4, 5, 3, 7 ,5, 9, 1};
		int E[] = {5, 7, 6, 4, 3, 1, 2};
		
		//��֤ð������
		System.out.print("ð����������ǰ" + Arrays.toString(A));
	    bubbleSort(A);
	    System.out.println("�����" + Arrays.toString(A));
		
		//��֤��������
	    System.out.print("������������ǰ" + Arrays.toString(B));
		quickSort(B,0,B.length - 1);
		System.out.println("�����" + Arrays.toString(B));
		
		//��֤��������
		System.out.print("������������ǰ"+ Arrays.toString(C));
		insertSort(C);
		System.out.println("�����" + Arrays.toString(C));
		
		//��֤ϣ������
		System.out.print("ϣ����������ǰ"+ Arrays.toString(D));
		shellSort(D);
		System.out.println("�����" + Arrays.toString(D));
		
		//��֤ѡ������
		System.out.print("ѡ����������ǰ"+ Arrays.toString(E));
		selectionSort(E);
		System.out.println("�����" + Arrays.toString(E));
		
	}
	
	//ð������
	public static void bubbleSort(int arr[]) {
		for (int i = 1; i <= arr.length; i++) {    //��������ѭ��ִ�д���		
			for (int j = 0; j <= arr.length - 1 - i; j++){    //����ÿ��ѭ�����������
				if (arr[j] >= arr[j+1]) {
					int temp;
					
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}		
		}
    }
	
	//��������
	public static void quickSort(int arr[],int low,int high){
		int p,i,j,temp;
	
		if (low >= high) {
			return;
		}
		
		p = arr[low];
		i = low;
		j = high;
		
		while (i < j) {
			while (arr[j] >= p && i < j) {
				j--;
			}
		
		    while (arr[i] <= p && i < j) {
			    i++;
		    }
		
		    temp = arr[j];
		    arr[j] = arr[i];
		    arr[i] = temp;
	    }
		
	    arr[low] = arr[i];
	    arr[i] = p;
	    
	    //�ݹ�
	    quickSort(arr,low,j-1);
	    quickSort(arr,j+1,high);
    }
    
	//��������
	public static void insertSort(int arr[]) {
		for (int i = 1; i <= arr.length - 1; i++) {
			int temp = arr[i], t = i - 1;
			
			while (t >= 0 && arr[t] > temp) {
				arr[t + 1] = arr[t];
				t--;
			}
			
			arr[t + 1] = temp;
		}	
	}
	
	//ϣ������
	public static void shellSort(int arr[]) {
		int n = arr.length;
		for (int increment = n/2; increment > 0; increment/=2) {    //ϣ����������
			//��������
			for (int i = 1; i <= arr.length - 1; i++) {
				int temp = arr[i], t = i - 1;
				
				while (t >= 0 && arr[t] > temp) {
					arr[t + 1] = arr[t];
					t--;
				}
				
				arr[t + 1] = temp;
			}				
		}
	}

	//ѡ������
	public static void selectionSort(int arr[]) {
		int pos, temp;
		
		for (int i = 0; i < arr.length - 1; i++) {	
			pos = 0;
			
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] > arr[pos]) {
					pos = j;
				}
			}	
			
		    temp = arr[arr.length - 1 - i];
		    arr[arr.length - 1 - i] = arr[pos];
		    arr[pos] = temp;
		}
	}
}