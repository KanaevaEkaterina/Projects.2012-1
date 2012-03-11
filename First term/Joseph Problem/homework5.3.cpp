#include <stdio.h>
#include <iostream>
#include <locale.h>
#include "ringList.h"

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	CircleList * list = createCircleList();
	cout << "¬ведите число солдат: ";
	int number = 0;
	cin >> number;
	cout << "¬ведите размер шага при счете: ";
	int deadline = 0;
	cin >> deadline;
	for (int i = 2; i <= number; i++)
		addToCircle(list, i);
	int aliveNumber = number;
	CircleListElement * index = tail(list);
	while (aliveNumber > 1)
	{
		for (int i = 1; i <= deadline; i++)
		{
			do {
				index = next(list, index);
			} while (!life(list, index));
		}
		kill(list, index);
		aliveNumber--;
	}
	while (!life(list, index))
		index = next(list, index);
    cout << "ќставшийс€ солдат: ";
	cout << value(list, index);
	deleteCircleList(list);
	cout << '\n';
	return 0;
}