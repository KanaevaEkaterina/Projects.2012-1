// homework3.2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

int  binarySearch(int mass[], int l, int r, int key)
{   
    if (r > l)
	{
		int middle = (l + r)/2;
		if (key < mass[middle])
			return binarySearch(mass, l, middle - 1, key);
		if (key > mass[middle])
			return binarySearch(mass, middle + 1, r, key);
		else
			return mass[middle];
	}
	return -1;
} 

int chooseMiddle(int mass[], int left, int right)
{
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
		return x1;
	if (x1 < x2)
		return x2;
	if (x1 == x2)
		return x;
}

void qsort(int left, int right, int mass[])
{
	if ((right - left) > 9)
	{
	    int i = left;
	    int j = right;
	    int middle = chooseMiddle(mass, i, j);
	    while (i <= j)
	    {
		    while (mass[i] < middle)
			    i++;
		    while (mass[j] >= middle)
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
	int n = 0;
	int k = 0;
	cout << "n = ";
	cin >> n;
	cout << "k = ";
	cin >> k;
	int* mass = new int[n];
	cout << "mass: ";
	for (int i = 0; i < n; i++)
	{
		mass[i] = rand() % 100;
		cout << mass[i] ;
		cout << " ";
	}
	cout << "\n";
	qsort(0, n - 1, mass);
	cout << "assorted mass: ";
	for (int i = 0; i < n; i++)
	{
		cout << mass[i];
		cout << " ";
	}
	cout << "\n";
	cout << "result: ";
	cout << "\n";
	for (int j = 0; j < k; j++)
	{
		int number = rand() % 100;
		cout << "number: ";
		cout << number;
		cout << ' ';  
		int result = binarySearch(mass, 0, n - 1, number);
		if (result == -1)
			cout << "No";
		else
		    cout << "Yes";
		cout << " ";
    }
	delete [] mass;
	return 0;
}

