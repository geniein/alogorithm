#include<stdio.h>

int number = 10;
int data[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

void quickSort( int *data, int start, int end ){
	
	if (start >= end){
		return;
	}
	
	int pivot;
	pivot = data[start];
	
	int i = start + 1, j = end, temp;
	
	while(i <=j){	
		while(data[i]>pivot){		
			i++;
		}
		
		while(data[j]>pivot){		
			j--;
		}
		
		if(i > j){
				temp = data[j];
				data[i] = data[j];
				data[j] = data[i];			
		}else {
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;	
		}
	}
	
	quickSort(data, start,j-1);
	quickSort(data, j+1 ,end);
}

int show(void){	
	for( int i=0;i<number; i++){
		printf("%d ", data[i]);
	}
	return 0;		
}

int main(void){
	quickSort(data , 0, number-1);	
	show();
	return 0;
}


