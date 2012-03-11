// homework4.3.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
using namespace std;


int _tmain(int argc, _TCHAR* argv[])
{
	char* file_name = "textfile.txt";
	FILE *file = fopen(file_name, "r");
	char string[100];
	int count = 0;
	int stringAmong = 0;
	while (!feof(file))
	{
        stringAmong++;
		fgets(string, 100, file);
		int i = 0;
		while (string[i] != '\0')
        {
			if (string[i] != ' ' && string[i] != '\t' && string[i] != '\0' && string[i] != '\n')
			{
				count++;
				break;
			}
			i++;
		}
	}
	int result = stringAmong - count; 	
	cout << "Among of empty strings = ";
	cout << result;
	fclose(file);
	cout << '\n';
	return 0;
}


