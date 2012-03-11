// homework5.1.cpp: ���������� ����� ����� ��� ����������� ����������.
//

#include "stdafx.h"
#include <iostream>
#include <locale.h>
#include <string>
#include <fstream>

using namespace std;

void printTelephoneBook(int position, string massName[], int massNumber[])
{
	for (int i = 0; i <= position; i++)
	{
		cout << massName[i];
		cout << ' ';
		cout << massNumber[i];
		cout << '\n';
	}
}


int _tmain(int argc, _TCHAR* argv[])
{
	setlocale(LC_ALL, "Russian");
	string massName[100];
	int massNumber[100];
	ifstream inFile("input.txt");
	int count = 0;
	while (!inFile.eof())
	{
		inFile >> massName[count];
		cout << massName[count];
		cout << ' ';
		inFile >> massNumber[count];
		cout << massNumber[count];
		cout << '\n';
		count++;
	}
	inFile.close();
    cout << '\n';
	cout << "0 - �����; 1 - �������� ������ (��� � �������); 2 - ����� ������� �� �����; 3 - ����� ��� �� ��������; 4 - ��������� ������� ������ � ����";
	cout << '\n';
	int position = count - 1;
	int indicator = 0;
	bool flag = true;
	while (flag)
	{
		
		cout << "������� �������: ";
		cin >> indicator;
		if (indicator == 0)
			flag = false;
		if (indicator == 1)
		{
			cout << "���: ";
			string name;
			cin >> name;
			massName[position + 1] = name;
			cout << "�����: ";
			int phone = 0;
			cin >> phone;
			massNumber[position + 1] = phone;
			position++;
			cout << '\n';
			cout << "���������� ����������";
			cout << '\n';
			printTelephoneBook(position,massName, massNumber);
		}
		if (indicator == 2)
		{
			cout << "���: ";
			string name;
			cin >> name;
			cout << ' ';
			cout << "����� : ";
			for (int i = 0; i <= position; i++)
			{
				if (massName[i] == name)
				{
					cout << massNumber[i];
					break;
				}
				else
				{
					if (i == position)
						cout << "� ����������� ��� ������ �����";
				}
			}
			cout << '\n';
			
		}
		if (indicator == 3)
		{    
			cout << "�����: ";
			int number = 0;
			cin >> number;
			cout << ' ';
			cout << "��� : ";
		    {
			    for (int i = 0; i <= position; i++)
				{
					if (massNumber[i] == number)
					{
						cout << massName[i];
						break;
					}
					else
					{
						if (i == position)
							cout << "� ����������� ��� ������ ������";
					}
				}
			}
			cout << '\n';
		}
		if (indicator == 4)
		{
			ofstream outFile("output.txt");
			for (int i = 0; i <= position; i++)
			{
				outFile << massName[i];
				outFile << ' ';
				outFile << massNumber[i];
				outFile << '\n';
			}
			cout << '\n';
			outFile.close();
		}
	}
	cout << '\n';
	return 0;
}

