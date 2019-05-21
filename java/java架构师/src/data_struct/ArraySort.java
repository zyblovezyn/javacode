
public class ArraySort {
    

    // 冒泡排序法
    private void bubbleSort(int[] arr){
        int len=arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if(arr[j]>arr[j]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return ;
    }
    // 选择排序法
    private void selectionSort(int[] arr){
        final int len=arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(arr[i]<arr[j]){
                    int temp=arr[j];
                    arr[i]=arr[j];
                    arr[j]=temp;  
                }
            }
            
        }
        return ;
    }
        // 插入排序法
        private void insertionSort(int[] arr){
            final int len=arr.length;
            for (int i = 0; i < len; i++) {
                 preIndex=i-1;
                 cur=arr[i];
                 while(preIndex>=0 && arr[preIndex]>cur){
                     arr[preIndex+1]=arr[preIndex];
                     preIndex--;
                 }
                 arr[preIndex+1]=cur;
            }
            return ;
        }
}
