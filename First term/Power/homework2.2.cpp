// homework2.2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <windows.h>
using namespace std;

int recPower(int number, int power)
{
	if (power == 0)
		return 1;
	if (power > 0)
		return recPower(number, power - 1) * number;
}

int recPowerWithLogarithmicTime(int number, int power)
{
	if (power == 0)
		return 1;
	if (power == 1)
		return number;
	if (power >= 2)
	{
		if (power % 2 == 0)
		{
		  	int variable = recPowerWithLogarithmicTime(number, power / 2);
			return variable * variable;
		}
		if (power % 2 == 1)
		{
			int variable = recPowerWithLogarithmicTime(number, power / 2 + 1);
			return variable * variable / number;
		}
	}
}


int _tmain(int argc, _TCHAR* argv[])
{
	cout << "Enter number: ";
	int number = 0;
	cin >> number;
	cout << "Enter power: ";
	int power = 0;
	cin >> power;

	DWORD timer1 = 0;
	timer1 = GetTickCount();
	int result1 = recPower(number, power);
	timer1 = GetTickCount() - timer1;
	cout << result1;
	cout << '\n';
	cout << "time: ";
	cout << timer1;
	cout << '\n';

	DWORD timer2 = 0;
	timer2 = GetTickCount();
	int result2 = recPowerWithLogarithmicTime(number, power);
	timer2 = GetTickCount() - timer2;
	cout << result2;
	cout << '\n';
	cout << "logarithmic time: ";
	cout << timer2;
	cout << '\n';
    return 0;
}

