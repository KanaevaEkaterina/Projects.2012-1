#include <stdio.h>
#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

const int q = 13;

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


int hashFunction (char str[], int len)
{
	int hash = str[0];
	for (int i = 1; i < len; i++)
	{
		//hash = hash*q + str[i];
		hash = hash * q - recPowerWithLogarithmicTime(q, len) * str[i] + str[i + len];
	}
	return hash;
}

int main()
{
	ifstream inFile("string.txt");
	int j = 0;
	char str[10000];
	while (!inFile.eof())
	{
		inFile >> str[j];
		j++;
	}
	int lenStr = j;
	for (int in = 0; in < lenStr; in++)
	{
		cout << str[in];
		cout << ' '; 
	}
	cout << '\n' << " Copy : ";
	char sample[100];
	int i = 0;
	char c;
	do
	{
		c = getch();
		putchar(c);
		sample[i] = c;
		i++;
	} while (c != ' ');
	int len = i;
	for (int ind = 0; ind < len; ind++)
	{
		cout << sample[ind];
		cout << ' '; 
	}
	int hash = hashFunction(str, len);
	cout << hash;
	cout << ' ';
	int hashSample = hashFunction(sample, len);
	cout << hashSample;
	bool flag = false;
	int k = 0;
	for (k = 0; k < lenStr - len + 1; k++)
	{
		if (hash == hashSample)
		{
			flag = true;			
			break;
		}
		hash = hash * q - recPowerWithLogarithmicTime(q, len) * str[k] + str[k + len];
	}
	if (flag)
		cout << "Sample is found on place " << k;
	else
		cout << "Sample is not found";
	cout << '\n';
	return 0;
}

