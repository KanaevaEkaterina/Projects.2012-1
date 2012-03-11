#include <stdio.h>
#include <iostream>
#include "queue.h"
#include "stack.h"

using namespace std;

int main()
{
	Stack * stack = createStack();
	Queue * queue = createQueue();
	char op2;
	char token = 'a';
	cout << "Sequence ('...='): ";
	while (token != '=')
	{
		cin >> token;
		if (token != '=')
		{
			if (token >= '0' && token <= '9')
			{
				enqueue(queue, token);
			}
			else if (token == '+' || token == '-')
			{
				op2 = pop(stack);
				if (op2 == '+' || op2 == '*' || op2 == '/' || op2 == '-')
					enqueue(queue, op2);
				push(stack, op2);
				push(stack, token);
			}
			else if (token == '*' || token == '/')
			{
				op2 = pop(stack);
				if (op2 == '*' || op2 == '/')
					enqueue(queue, op2);
				push(stack, op2);
				push(stack, token);
			}
			else if (token == '(')
				push(stack, token);
			else if (token == ')')
			{
				bool bracketError = true;
				while (count(stack) != 0)
				{
					ElementType op2 = pop(stack);
					while (op2 != '(')
					{
						enqueue(queue, op2);
						if (count(stack) != 0)
						{
							op2 = pop(stack);
						} 
						else 
							break;
					}
					bracketError = false;
				}
				if (bracketError)
					cout << "Incorrect bracket's sequence";
			}
		}
	}
	while (count(stack) != 0)
	{
		op2 = pop(stack);
		if (op2 == '(')
			cout << "Incorrect bracket's sequence";
		else
			enqueue(queue, op2);
	}
	while (count(queue) != 0)
	{
		cout << dequeue(queue);
	}
	deleteStack(stack);
	deleteQueue(queue);
	cout << '\n';
	return 0;
}