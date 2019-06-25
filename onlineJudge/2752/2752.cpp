#include<stdio.h>

int count = 5;
int data[5];

int ascendingOrder(int *data, int count ){
	int i, j, temp, max = 1000000, min = 1;
	
	for(i=0;i<count; i++){
		scanf("%d", &data[i]);
		if( data[i]>max){
			printf("Over Max Value");
			return 0;
		} else if (data[i]<min){
			printf("Below Min Value");
			return 0;
		}
	}
	    
    for(i=0;i<count;i++){     
        for(j=i+1; j<count; j++){
           	if(data[j]<data[i]){
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }        
    }
	return 1;   
}

int show(void){	
	for( int i=0;i<count; i++){
		printf("%d ", data[i]);
	}
	return 0;		
}

int main(void) {
	bool b1 = ascendingOrder(data, count);
	if(b1){
		show();
	}	   
	return 0;
	}
