// homework4.1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <locale.h>
using namespace std;

int const sizeOfInt = sizeof(int) * 8;

int myPower(int number, int power)
{
    if (power == 0) 
		return 1;
	if (power % 2 == 0)
	{
		int result = myPower(number, power / 2);
		return result * result;
	}
	else
		return number * myPower(number, power - 1);
}

void binaryRepresentation(int n, bool * mass)
{
	int mask = 1;
	for (int i = 0; i < sizeOfInt; i++)
	{
		if ((mask & n) == 0)
			mass[i] = false;
		else
			mass[i] = true;
		mask = mask << 1;
	}
	for (int i = sizeOfInt - 1; i >= 0; i--)
    {
		cout << mass[i];
        cout << ' ';
	}
}

int metricSystemRepresentation(bool * mass)
{
	int metricSystem = 0;
	for (int i = 0; i < sizeOfInt; i++)
		metricSystem += mass[i] * myPower(2,i);
	return metricSystem;
}


int _tmain(int argc, _TCHAR* argv[])
{
	setlocale(LC_ALL, "Russian");
	cout << "Введите а = ";
	int a = 0;
	cin >> a;
	cout << "Введите b = ";
	int b = 0;
	cin >> b;
	
	
	cout << "Двоичный код:";
	cout << '\n';
	bool mass1[sizeOfInt];
	cout << "a = ";
    binaryRepresentation(a, mass1);
	cout << '\n';
	bool mass2[sizeOfInt];
	cout << "b = ";
    binaryRepresentation(b, mass2);
	cout << '\n';
   

	bool massSum[sizeOfInt];
	int count = 0;
	for (int i = 0; i < sizeOfInt; i++)
	{
		if (mass1[i] + mass2[i] + count >= 2)
		{
			count = 1;
			massSum[i] = false;
		}
		if (mass1[i] + mass2[i] + count == 0)
		{
			massSum[i] = false;
			count = 0;
		}
		if (mass1[i] + mass2[i] + count == 1)
		{
			massSum[i] = true;
			count = 0;
		}
	}
	cout << "a + b = ";
	for (int i = sizeOfInt - 1; i >= 0; i--)
	{
		cout << massSum[i];
		cout << ' ';
	}
	cout << '\n';


	
	cout << "Десятичная система счисления:";
	cout << '\n';
	cout << "a + b = ";
	cout << metricSystemRepresentation(massSum);
	cout << '\n';
	cout << "a = ";
    cout << metricSystemRepresentation(mass1);
	cout << '\n';
	cout << "b = ";
    cout << metricSystemRepresentation(mass2);
	cout << '\n';
	return 0;
}

