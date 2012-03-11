// homework5.2.cpp: ���������� ����� ����� ��� ����������� ����������.
//

#include "stdafx.h"
#include <locale.h>
#include <iostream>
#include "list.h"

using namespace std;
typedef int ElementType;

int _tmain(int argc, _TCHAR* argv[])
{
	setlocale(LC_ALL, "RUS");
	List * list = createList();
	cout << "0 -�����; 1 -�������� �������� � ������; 2 -������� �������� �� ������; 3 -�����������";
	cout << '\n';
	int indicator = 0;
	bool flag = true;
	int value = 0;
	while (flag)
	{
		cout << "������� �������: ";
		cin >> indicator;
		switch (indicator) {
			case 0: 
				flag = false;
				break;
			case 1:
			{
				cout << "������� ��������: ";
				cin >> value;
				cout << '\n';
				add(list, value);
				break;
			}
			case 2:
			{
				cout << "������� ��������: ";
				cin >> value;
				deleteElement(list, value);
				cout << '\n';
				cout << "������: ";
				printList(list);
				break;
			}
			case 3:
			{
				cout << "������: ";
			    printList(list);
				break;
			}
		}
		cout << '\n';
	}
	return 0;
}

