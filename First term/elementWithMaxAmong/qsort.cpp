#include "qsort.h"
#include "stdafx.h"

void qsort(int left, int right, int mass[])
{
	if ((right - left) > 9)
	{
	    int i = left;
	    int j = right;
		int x1 = mass[left];
		int x2 = mass[left];
		int x = mass[left];
	    for(int k = left + 1; k <= right; k++)
		{
			if (mass[k] != mass[left])
			{
				x2 = mass[k];
				break;
			}
		}
		if (x1 > x2)
			x = x1;
		if (x1 < x2)
			x = x2;
		if (x1 == x2)
			return;
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
