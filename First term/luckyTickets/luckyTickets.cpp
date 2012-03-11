// homework1.6.1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	int mass[1000000];
	mass[0]=0;
	for (int i=1; i<1000000; i++){
		mass[i+1]= mass[i]+1;    
	}
	int count = 0;
	for (int i=0; i<1000000; i++){
	    if ((mass[i] / 100000)+((mass[i] % 100000) / 10000)+((mass[i] % 10000) / 1000)==((mass[i] % 1000) / 100)+((mass[i] % 100) / 10)+(mass[i]% 10)){
	        count++;
	    }
	}
	printf("number of lucky tickets: %d", count);
	
}

