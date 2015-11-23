package com.abhishesh.algos;

public class BinarySearch {
	//works only when the input array is sorted
	int []arr;
	public BinarySearch(int arr[]){
		this.arr = arr;
	}
	
	// iterative implementation of binary search algorithm
	public int search(int strt, int end, int key) {
		int mid;
		while(strt <= end) {
			mid = strt + (end - strt)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] < key)
				strt = mid + 1;
			else
				end = mid - 1;
		}
		return -1; //return -1 if element is not found in sorted array
	}

}
