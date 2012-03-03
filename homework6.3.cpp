#include <stdio.h>
#include <iostream>
#include "stack.h"

using namespace std;

int main()
{
	Stack * stack = createStack();
	char  bracket = 'a';
	bool indicator = true;
	cout << "Sequence ('.' in the end): ";
	char current = pop(stack);
	cout << current;
	while (bracket != '.')
	{
		cin >> bracket;
		if(bracket != '.')
		{
			if (bracket == '{' || bracket == '[' || bracket == '(')
				push(stack, bracket);
			else if (bracket == '}')
			{
				if (pop(stack) != '{')
				{
					indicator = false;
					break;
				}
			}
			else if (bracket == ']')
			{
				if (pop(stack) != '[')
				{
					indicator = false;
					break;
				}
			}
			else if (bracket == ')')
			{
				if (pop(stack) != '(')
				{
					indicator = false;
					break;
				}
			}
			else
			{
				indicator = false;
				break;
			}
		}
	} 
	if (indicator && head(stack) == NULL)
		cout << "right sequence";
	else
		cout << "wrong sequence";
	deleteStack(stack);
	cout << '\n';
	return 0;
} 