// homework5.2.cpp: определ€ет точку входа дл€ консольного приложени€.
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
	cout << "0 -выйти; 1 -добавить значение в список; 2 -удалить значение из списка; 3 -распечатать";
	cout << '\n';
	int indicator = 0;
	bool flag = true;
	int value = 0;
	while (flag)
	{
		cout << "¬ведите команду: ";
		cin >> indicator;
		switch (indicator) {
			case 0: 
				flag = false;
				break;
			case 1:
			{
				cout << "¬ведите значение: ";
				cin >> value;
				cout << '\n';
				add(list, value);
				break;
			}
			case 2:
			{
				cout << "¬ведите значение: ";
				cin >> value;
				deleteElement(list, value);
				cout << '\n';
				cout << "—писок: ";
				printList(list);
				break;
			}
			case 3:
			{
				cout << "—писок: ";
			    printList(list);
				break;
			}
		}
		cout << '\n';
	}
	return 0;
}

