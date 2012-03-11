#include <stdio.h>
#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

const int q = 13;

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

int hashFunction(char str[], int beg, int end)
{
	int hash = 0;
	for (int i = beg; i < end; i++)
	{
		hash = hash * q + str[i];
	}
	return hash;
}

bool charByChar(char str[], char sample[], int k, int sampleLen)
{
	bool flag = true;
	for (int i = 0; i < sampleLen; i++)
	{ 
		if (str[k + i] != sample[i])
		{
			flag = false;
			break;
		}
	}
	return flag;
}

int main()
{
	ifstream inFile("string.txt");
	char str[1000];
	int i = 0;
	char ch = 'a';
	while (!inFile.eof())
	{
		inFile >> ch;
		if (!inFile.eof())
		{
			str[i] = ch;
			i++;
		}
	}
	int strLen = i;
	char sample[100];
	int j = 0;
	do
	{
		ch = getch();
		putchar(ch);
		if (ch != ' ')
		{
			sample[j] = ch;
			j++;
		}
	} while (ch != ' ');
	cout << '\n';
	int sampleLen = j;
	int hashSample = hashFunction(sample, 0, sampleLen);
	int hashStr = hashFunction(str, 0, sampleLen);
	int result = 0;
	bool search = false;
	for (int k = 0; k <= strLen - sampleLen; k++)
	{
		if (hashSample == hashStr && charByChar(str, sample, k, sampleLen))
		{
			result = k;
			search = true;
			break;
		}
		hashStr = hashStr * q + str[k + sampleLen] - str[k] * myPower(q, sampleLen);
	}
	if (search)
	{
		cout << "Is found on place " << result + 1;
	}
	else
		cout << "Not found";
	cout << '\n';
	return 0;
}