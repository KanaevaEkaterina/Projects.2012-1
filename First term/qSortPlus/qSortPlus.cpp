// homework3.1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"

void qsort(int left, int right, int mass[])
{
	if ((right - left) > 9)
	{
	    int i = left;
	    int j = right;
	    int x = mass[(right - left) / 2];
	    while (i <= j)
	    {
		    while (mass[i] < x)
			    i++;
		    while (mass[j] >= x)
			    j--;
		    if (i <= j)
		    {
			    int a = mass[i];
			    mass[i] = mass[j];
			    mass[j] = a;
			    i++;
			    j--;
		    }
	    }
	    if (left < j)
	        qsort (left, j, mass);
	    if (i < right)
            qsort (i, right, mass);
    }
	else
	{
		for (int k = left + 1; k < (right + 1); k++)
			{
				for (int l = k; l > left; l--)
			        {
				        if (mass[l - 1] > mass[l])
				        {
					        int a = mass[l];
							mass[l] = mass[l - 1];
							mass[l - 1] = a;
						}
					}
			}
    }
}




int _tmain(int argc, _TCHAR* argv[])
{
	int const n = 20;
	int mass[n] = {1, 2, 7 , 3, 5, 4, 7, 6, 3, 5, 0, 6, 1, 0, 8, 4, 9, 7, 2, 3};
	qsort (0, n - 1, mass); 
	for (int i = 0; i < n; ++i)
	{
		printf("%d ", mass[i]);
	}
	printf("\n");
	return 0;
}

