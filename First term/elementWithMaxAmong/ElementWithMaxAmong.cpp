// homework4.2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include "qsort.h"
#include <iostream>

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	char* file_name = "text.txt";
	FILE *file = fopen(file_name, "r");
	int n = 0;
	fscanf(file, "%d", &n);
	cout << n;
	cout << "\n";
	int * mass = new int[n];
	for (int i = 0; i < n; i++)
		fscanf(file, "%d", &mass[i]);
	fclose(file);
	for (int i = 0; i < n; i++)
		cout << mass[i];
	cout << "\n";
	qsort(0, n - 1, mass);
	for (int i = 0; i < n; i++)
		cout << mass[i];
	cout << "\n";
	int count = 1;
	int maxAmong = 1;
	int maxNumber = mass[0];
	for (int i = 1; i < n; i++)
	{
		if (mass[i] == mass[i - 1] )
		{
			count++;
		}
		if (mass[i] != mass[i - 1] || i == n - 1)
		{
		    if (count > maxAmong)
		    {
				maxAmong = count;
				maxNumber = mass[i - 1];
			}
			count = 1;
		}
	}
    cout << "\n";
	cout << "number with maximum among : ";
	cout << maxNumber;
	cout << "\n";
	delete [] mass;
	return 0;
}
