package com.abhishesh.algos;

public class MaxSubarraySum {
	private int [] arr;
	
	public MaxSubarraySum(int arr[]) {
		this.arr = arr;
	}
	
	int calculateMaxSubArraySum(){
		if(arr==null || arr.length==0)
			return 0;
		int sum=0,tSum=0;
		for(int i = 0;i < arr.length;i++) {
			tSum += arr[i];
			if(tSum <= 0){
				tSum = 0;
			}
			if(tSum > sum) {
				sum = tSum;
			}
		}
		return sum;
	}
}
