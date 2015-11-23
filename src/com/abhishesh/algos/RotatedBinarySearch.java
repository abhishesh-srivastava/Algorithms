package com.abhishesh.algos;

public class RotatedBinarySearch {

	private int arr[];
	
	public RotatedBinarySearch(int []arr) {
		this.arr = arr;
	}
	
	// return index of key in rotated sorted array
	public int search(int key){
		return searchUtil(key,0,arr.length-1);
	}

	// utility function implemented using binary search logic
	private int searchUtil(int key, int strt, int end) {
		int mid;
		while(strt <= end) {
			mid = strt + (end-strt)/2;
			if(arr[mid] == key) 
				return mid;
			else if(arr[strt] < arr[mid]){ //left half is sorted
				if(arr[strt]<= key && key < arr[mid])
					end = mid-1;
				else
					strt = mid+1;
			
			} else { //right half is sorted
				if(arr[mid]<=key && key < arr[end])
					strt = mid+1;
				else
					end = mid -1;
			}
		}
		return -1;
	}
}
