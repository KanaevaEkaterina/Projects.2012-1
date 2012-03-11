// homework1.4.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"

#include <math.h>

int Div(int dividend, int divider, int quotient)
{
    while (dividend >= divider)
	{
		dividend -= divider;
		quotient++;
	}
	return quotient;
}

int _tmain(int argc, _TCHAR* argv[])
{
	int dividend = 0;
	int divider = 0;
	printf ("Enter dividend: ");
    scanf ("%d", &dividend);
    printf ("Enter divider: ");
    scanf ("%d", &divider);
	int quotient = 0;
	int sign = 0;
	if (dividend > 0 && divider > 0)
	{
		quotient = 0;
		sign = 1;

	}
	if (dividend < 0 && divider < 0)
	{
		quotient = 1;
		sign = 1;

	}
	if (dividend > 0 && divider < 0)
	{
		quotient = 0;
		sign = -1;

	}
	if (dividend < 0 && divider > 0)
	{
		quotient = 1;
		sign = -1;

	}
	printf("quotient = %d\n", Div(abs(dividend), abs(divider), quotient) * sign);
}

