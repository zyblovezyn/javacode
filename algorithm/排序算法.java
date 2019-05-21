// 常用排序
class  Sort
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		int[] arr=new int[]{5,4,3,6,7,8,1,9};
		//bubbleSort(arr);
		//quickSort(arr, 0, arr.length-1);
		insertionSort(arr);
		for (int var : arr) {
			System.out.println(var);
		}
	}

	// 冒泡排序O(N^2)
	public static void bubbleSort(int[] A){
		int len=A.length;
		for(int i=0;i<len;i++){
			for(int j=0;j<len-1-i;j++){
				if(A[j]>A[j+1]){
					int temp=A[j+1];
					A[j+1]=A[j];
					A[j]=temp;
				}
			}
		}
	}
	
	// 快速排序
	public static void quickSort(int[] arr,int start,int end){
		if(start<end){
		// 基准数
				int mid=arr[start];
				int low=start;
				int high =end;
				// 循环
				while(low<high){
					while(low<high&&mid<=arr[high]){
						high--;
					}
					arr[low]=arr[high];
					while(low<high&&arr[low]<=mid){
						low++;
					}
					arr[high]=arr[low];				
				}
				arr[low]=mid;
				quickSort(arr, start, low);
				quickSort(arr, low+1, high);
		}
	}
	
	// 选择排序O(N^2)
	public static void selectionSort(int[] arr){
		int len=arr.length;
		int minIndex,temp;

		for(int i=0;i<len;i++){
			minIndex=i;
			for(int j=i+1;j<len;j++){
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}

	//插入排序法
	public static void insertionSort(int[] arr){
		int len=arr.length;
		int preIndex,current;
		for(int i=0;i<len;i++){
			preIndex=i-1;
			current=arr[i];
			while(preIndex>=0 && arr[preIndex]>current){
 				arr[preIndex + 1] = arr[preIndex];
            	preIndex--;
			}
	 		arr[preIndex + 1] = current;
		}
	}

	// 修改于 2019-03-06
	public static void shellSort(int[] arr) {
    var len = arr.length;
    for (var gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
        // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
        for (var i = gap; i < len; i++) {
            int j = i;
            int current = arr[i];
            while (j - gap >= 0 && current < arr[j - gap]) {
                 arr[j] = arr[j - gap];
                 j = j - gap;
            }
            arr[j] = current;
        }
    }
    return ;
	}
}
