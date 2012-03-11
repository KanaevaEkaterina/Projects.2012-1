// hometask2.3.1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>

using namespace std;



int _tmain(int argc, _TCHAR* argv[])
{
	int const n = 10;
	int mass[n] = {6, 1, 7, 3, 4, 2, 9, 5, 8, 0};
    for (int i = 1; i <= n - 1; i++)
	{
		bool flag = true;
		for (int j = 0; j <= n - 2 ; j++)
		{
			if (mass[j] > mass[j + 1])
			{
				int change = mass[j];
				mass[j] = mass[j + 1];
				mass[j + 1] = change;
				flag = false;
			}
		}
		if (flag)
		{
			break;
		}

	}
	for (int i = 0; i < n; i++)
	{
		cout << mass[i] << " ";
    }
	cout << "\n";
	return 0;
}

