#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ifstream inFile("text.txt");
	char str[20]={-1};
	char ch;
	int i = 0;
	while (!inFile.eof())
	{
		inFile >> ch;
		while(ch != ' ')
		{
			str[i] = ch;
			inFile >> ch;
			i++;
		}
		i = 0;
	}
	for (int j = 0; j < 20; j++)
	{
		cout << str[i];
	}
	cout << '\n';
	inFile.close();
	return 0;
}