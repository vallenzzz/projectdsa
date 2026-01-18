// Call:	mergesort(arr, 0, SIZE-1);

/* function mergesort takes as input an array 
and the indices of its bounds. 'low' is the leftmost
bound and 'high' the rightmost.
It sorts the array by splitting it in two, sorting
the pieces recursively and then merging the two
sorted subarrays. */

 
void mergesort(int a[], int low, int high){

	int mid;

	if (low < high) {
		/* find middle of array */
        mid=(low+high)/2; 
		/* call mergesort on first half */
		mergesort(a, low, mid);
		/* call mergesort on second half */
		mergesort(a, mid+1, high);
		/* now that the two halves are sorted, merge them */
        merge(a, low, mid, mid+1, high); 
	}
}

/* Function merge takes as input the whole array as well as the
indices that identify the two subarrays we want to merge. The
rest of the array will be ignored. 
leftpos and leftend are the bounds of the first 'half' that we
are currently working on. rightpos and rightend are the bounds
of the second 'half'. In addition, leftpos and rightpos will
go through the subarrays as we compare their elements.

The function works as we described in class. It first compares
the elements at positions leftpos and rightpos. 
Whichever is smaller goes into a temporary array and its 
corresponding index (either leftpos or rightpos) advances. The
procedure is repeated until one of the subarrays is finished
(i.e. we have reached either leftend or rightend), in which
case we just add all the remaining elements to the temporary 
array.

In the end, we copy the temporary array into the input array. 
Note that the temporary array contains only the elements
of the subarrays that we are working on. The rest of it is 
blank. We must be careful to copy only the useful part of 
the temporary array into the input array. */

void merge(int a[], int leftpos, int leftend, int rightpos, int rightend) {

	int temp[SIZE], i;
	int currentpos=leftpos; /* this is the index in temp */
	int numOfElements=rightend-leftpos+1;

	while (leftpos <= leftend && rightpos <= rightend) 

		if (a[leftpos] <= a[rightpos]) {

			temp[currentpos]=a[leftpos];
			currentpos++;
			leftpos++;
		}
		else {
			temp[currentpos]=a[rightpos];
			currentpos++;
			rightpos++;
		}

	while (leftpos<=leftend) {/* copy rest of first half */
		temp[currentpos]=a[leftpos];
		currentpos++;
		leftpos++;
	}

	while (rightpos<=rightend) { /* copy rest of second half */
		temp[currentpos]=a[rightpos];
		currentpos++;
		rightpos++;
	}

	/* Note that this for-loop both increments i and 
	decrements rightend at each iteration. */
	for (i=1; i<=numOfElements; i++, rightend--) 
		a[rightend]=temp[rightend];
}

