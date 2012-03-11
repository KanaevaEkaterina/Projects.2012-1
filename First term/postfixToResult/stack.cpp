#include <stdio.h>

typedef int ElementType;

struct StackElement
{
	ElementType value;
	StackElement * next;
};

struct Stack
{
	StackElement * head;
};

Stack * createStack()
{
	Stack * result = new Stack;
	result->head = NULL;
	return result;
}

ElementType pop(Stack * stack)
{
	if (stack->head == NULL)
		return 0;
	if (stack->head != NULL)
	{
		ElementType result = stack->head->value;
		StackElement * temp = stack->head;
		stack->head = stack->head->next;
		delete temp;
		return result;
	}
}

void push(Stack * stack, ElementType value)
{
	StackElement * first = new StackElement;
	first->value = value;
	first->next = stack->head;
	stack->head = first;
}

void deleteStack(Stack * stack)
{
	StackElement * temp = stack->head;
	while (temp != NULL)
	{
		stack->head = stack->head->next;
		delete temp;
		temp = stack->head;
	}
	delete stack;
}

StackElement * head(Stack* stack)
{
	return stack->head;
}