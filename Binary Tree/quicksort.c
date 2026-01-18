/* left and right are the indices of the leftmost
and rightmost elements of the current subarray.
Call quicksort(a, 0, n-1); for an array of size n
*/

void quicksort(int a[], int left, int right) {
	int pivot_index;
	if (left < right) {
		pivot_index = partition(a, left, right);
		quicksort(a, left, pivot_index);
		quicksort(a, pivot_index+1, right);
	}
	// base case: if left > right, don't do anything.
}

/* function 'partition' partitions the array with bounds 
'left' and 'right' into two parts:
 - subarray with bounds 'left' and 'pivot_index'
 - subarray with bounds 'pivot_index+1' and 'right'
The elements of the first part are smaller than or equal to 
the elements of the second part. 
Note: Duplicate elements may appear in both parts. This will
      be remedied in subsequent partitions. 
*/
int partition(int a[], int left, int right) {
	int item = a[left];
	int i = left-1; 
	int j = right+1;

	while (1) {
		do {j--;
		} while (a[j] > item);
		
		do {i++;
		} while (a[i] < item);
		
		if (i < j) 
			swap(a, i, j); // swap ith and jth elements of array
		else
			return j;
	}
}

void swap (int a[], int i, int j) {
	int temp=a[i];
	a[i]=a[j];
	a[j]=temp;
}

