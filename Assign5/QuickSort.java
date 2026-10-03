

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {3,1,8,7,6,2,4,9,5};
		showArray(array);
		quickSort(array);
		showArray(array);
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
		
	}
	
	public static void quickSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive quickSort *
		//**********************************************
		quickSort(array,0,array.length-1);
	}
	public static void counter(int left, int right) {//figuring out how the recursive calls needs to end
		if(left >= right){
			System.out.println("you broke out of the recurssive statement??");
			return;
			
		}
		counter(left, right);//would be the quick sort running - stack overflow would be a good thing in this case
	}
	
	public static void quickSort(int[] array, int left, int right) {
		if((left >= right)) { //base case 
			////left should always be less than the right and if it is not then don't sort
			//System.out.println("You broke out of the recursion");
			return;
		}
		
		int lIndex = left-1;
		int rIndex;
		int pivot = array[right];
		//dynamic values for rIndex and lIndex so the method can apply easily when the calls begin
		//for the first call rIndex will be the left most point and lIndex is one less than the left most point or 0 and -1
		for(rIndex = left; rIndex < right; rIndex++) {
			if(array[rIndex] <= pivot) {
				lIndex++;
				swap(array, lIndex, rIndex);//swapping the value that is less than the pivot at rIndex with a value that has been passed by rIndex which has
				//been proven to be greater than the pivot
			}
		}
		swap(array, lIndex+1, right); //since the for loop stops one value before the pivot we have to swap them outside of the loop
		rIndex = lIndex+2;
		//lIndex will be the first value that is either less than or equal to the pivot
		//so lIndex+1 becomes where the pivot is stored then 
		//andlIndex +2 is going to be the first index that is greater than the pivot or rIndex
		quickSort(array, left, lIndex); //using lIndex b/c we need to exclude the previous pivot since the array has already been sorted according to its value
		quickSort(array, rIndex , right);//same thing here but for the right
	}
	
	public static void swap(int[] array, int lIndex, int rIndex) {
		int temp = array[lIndex];
		array[lIndex] = array[rIndex];
		array[rIndex] = temp;
	}

}
