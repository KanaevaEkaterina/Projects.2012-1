// hometask2.1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include "iostream"
#include <windows.h>



int recFib(int n)
{
	if (n <= 2)
	{
		return 1;
	}
	else
	{
		return recFib(n - 2) + recFib(n - 1);
	}
}
int linFib(int n)
{
	if (n <= 2)
	{
	    return 1;
	}
	else
	{
		int a = 1;
		int b = 1;
		int c = 1;
		for (int i = 1; i < n - 1; i++)
		{
			a = b;
			b = c;
			c = a + b;
		}
	    return c;
    }
}

int _tmain(int argc, _TCHAR* argv[])
{
	int n = 0;
	std::cout << "n = ";
	std::cin >> n;
	std::cout << "\n";
	DWORD timer1 = 0;
	timer1 = GetTickCount();
	std::cout << recFib(n);
	timer1 = GetTickCount() - timer1;
	std::cout << "\n";
	std::cout << "rectime is = ";
	std::cout << timer1;
	std::cout << "\n";
	
	DWORD timer2 = 0;
	timer2 = GetTickCount();
	std::cout << linFib(n);
	timer2 = GetTickCount() - timer2;
	std::cout << "\n";
	std::cout << "time is = ";
	std::cout << timer2;
	std::cout << "\n";
    return 0;
}

