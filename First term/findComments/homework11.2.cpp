#include <stdio.h>
#include <iostream>
#include <fstream>
#include <utility>

using namespace std;

int indexOfChar(char ch)
{
	if (ch == '/')
		return 0;
	else if (ch == '*')
		return 1;
	else 
		return 2;
}

int main()
{
	ifstream inFile("comments.txt");
	pair <int, bool> a[4][3];
	a[0][0].first = 1;
	a[0][0].second = 0;
	a[1][0].first = 1;
	a[1][0].second = 0;
	a[2][0].first = 2;
	a[2][0].second = 1;
	a[3][0].first = 4;
	a[3][0].second = 1;
	a[0][1].first = 0;
	a[0][1].second = 0;
	a[1][1].first = 2;
	a[1][1].second = 1;
	a[2][1].first = 3;
	a[2][1].second = 1;
	a[3][1].first = 3;
	a[3][1].second = 1;
	a[0][2].first = 0;
	a[0][2].second = 0;
	a[1][2].first = 0;
	a[1][2].second = 0;
	a[2][2].first = 2;
	a[2][2].second = 1;
	a[3][2].first = 2;
	a[3][2].second = 1;
	
	char ch = 'a';
	int stage = 0;
	while (!inFile.eof())
	{
		inFile >> ch;
		if (a[stage][indexOfChar(ch)].second)
		{
			if (stage == 1)
				cout << '/';
			cout << ch;
		}
		stage = a[stage][indexOfChar(ch)].first;
		if (stage == 4)
		{
			cout << '\n';
			stage = 0;
		}
	}
	cout << '\n';
	inFile.close();
	return 0;
}