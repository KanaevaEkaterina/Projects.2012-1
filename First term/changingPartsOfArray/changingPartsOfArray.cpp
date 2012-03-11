// homework1.5.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	int const n=5, m=3;
	int mass[n+m];
	for (int i=0; i<=(n+m-1); ++i){
	    mass[i]=i;
		printf("%d", mass[i]);
	}
	printf("\n");
	printf("After change:\n");
	for (int i=n; i<=n+m-1; ++i){
	    for (int j=n-1; j>=0; --j){
		    int change=mass[i];
			mass[i]=mass[j];
			mass[j]=change;
		}
    }
	for (int i=0; i<=(n+m-1); ++i){
	    printf("%d", mass[i]);   
	}
	printf("\n");
	return 0;
}

