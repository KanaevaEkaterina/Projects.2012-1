#include <stdio.h>
#include <iostream>

using namespace std;

bool digit(char ch)
{
	return ch >= '0' && ch <= '9';
}

int main()
{
	int stage = 0;
	char ch = 'a';
	bool flag = true;
	cout << "Number ('?' in the end) : ";
	while (flag)
	{
		switch (stage)
		{
			case 0:
				cin >> ch;
				if (digit(ch))
					stage = 1;
				else
					stage = -1;
				break;
			case 1:
				cin >> ch;
				if (digit(ch))
					stage = 1;
				else if (ch == '.')
					stage = 2;
				else if (ch == '?')
					stage = 8;
				else if (ch == 'E')
					stage = 4;
				else 
					stage = -1;
				break;
			case 2:
				cin >> ch;
				if (digit(ch))
					stage = 3;
				else
					stage = -1;
				break;
			case 3:
				cin >> ch;
				if (digit(ch))
					stage = 3;
				else if (ch == 'E')
					stage = 4;
				else if (ch == '?')
					stage = 8;
				else
					stage = -1;
				break;
			case 4:
				cin >> ch;
				if (digit(ch))
					stage = 5;
				else if (ch == '+' || ch == '-')
					stage = 6;
				else if (ch == '?')
					stage = 8;
				else
					stage = -1;
				break;
			case 6:
				cin >> ch;
				if (digit(ch))
					stage = 7;
				else
					stage = -1;
				break;
			case 5:
				cin >> ch;
				if (digit(ch))
					stage = 5;
				else if (ch == '?')
					stage = 8;
				else
					stage = -1;
				break;
			case 7:
				cin >> ch;
				if (digit(ch))
					stage = 7;
				else if (ch == '?')
					stage = 8;
				else
					stage = -1;
				break;
			case 8:
				cout << "Real number";
				flag = false;
				break;
			case -1:
				cout << "Not real number";
				flag = false;
				break;
		}
	} 
	cout << '\n';
	return 0;
}