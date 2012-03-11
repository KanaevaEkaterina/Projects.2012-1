// homework2.3.2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"


int _tmain(int argc, _TCHAR* argv[])
{
	
	int const n = 10;
	int mass[n] = {4, 0, 2, 6, 1, 0, 6, 5, 8, 9}; 
	int addlmass[10];
	for (int i = 0; i < 10; i++)
	{
        addlmass[i] = 0;    
	}
	for (int j = 0; j < n; j++)
	{
		addlmass[mass[j]]++;
	}
	for (int k = 0; k < 10; k++)
	{
		for (int l = 0; l < addlmass[k]; l++)
			printf("%d ", k);
	}
	printf("\n");
	return 0;
}

