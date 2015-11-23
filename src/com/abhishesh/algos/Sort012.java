package com.abhishesh.algos;

// sorts an array containing only 0,1,2 as elements
public class Sort012 {

	private int arr[];
	
	public Sort012(int []arr) {
		this.arr = arr;
	}
	
	public int[] sort(){
		if(arr==null || arr.length==0)
			return arr;
		int start = 0; //index for 0
		int mid = 0;  //index for 1
		int end = arr.length-1; //index for 2
		int temp;
		while(mid <= end) {
			switch(arr[mid]) {
				case 0:
					temp = arr[start];
					arr[start] = arr[mid];
					arr[mid] = temp;
					start++;mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					temp = arr[end];
					arr[end] = arr[mid];
					arr[mid] = temp;
					end--;
					break;
			}
		}
		return arr;
	}
}
