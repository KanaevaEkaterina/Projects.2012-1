#include <stdio.h>
#include <iostream>
#include <locale.h>
#include "stack.h"
using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");
	Stack * stack = createStack();
	char element = 'a';
	cout << "Введите выражение в постфиксной форме(в конце '=') : ";
	while (element != '=')
	{
		cin >> element;
		if (48 <= element && element <= 57)
		{
			int elementInt = element - 48;
			push(stack, elementInt);
		}
		if (element == '+')
		{
			int a = pop(stack);
			int b = pop(stack);
			push(stack, a + b);
		}
		if (element == '*')
		{
			int a = pop(stack);
			int b = pop(stack);
			push(stack, a * b);
		}
		if (element == '/')
		{
			int a = pop(stack);
			int b = pop(stack);
			if (b != 0)
			{
				push(stack, b / a);
			}
			else
			{
				cout << "Деление на нуль";
				cout << '\n';
				break;
			}
		}
		if (element == '-')
		{
			int a = pop(stack);
			int b = pop(stack);
			push(stack, b - a);
		}
		if (element != '+' && element != '-' && element != '*' && element != '/' && element < 48 && element > 57)
        {
			cout << "Ошибка записи";
			cout << '\n';
		}
	}
	int result = pop(stack);
	if (head(stack) == NULL)
	{
		cout << "Результат вычисления: ";
		cout << result;
	}
	else
		cout << "Ошибка записи";
	cout << '\n';
	deleteStack(stack);
	return 0;
}