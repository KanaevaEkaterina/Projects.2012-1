#include <stdio.h>
#include <iostream>

using namespace std;

typedef int ElementType;

struct CircleListElement
{
	bool life;
	ElementType value;
	CircleListElement * next;
};

struct CircleList
{
	CircleListElement * head;
	CircleListElement * tail;
	int count;
};

CircleList * createCircleList()
{
	CircleList * start = new CircleList;
	CircleListElement * first = new CircleListElement;
	first->value = 1;
	first->life = true;
	start->head = first;
	start->tail = first;
	first->next = start->head;
	start->count = 1;
	return start;
}

void addToCircle(CircleList * list, ElementType value)
{
	CircleListElement * last = new CircleListElement;
	last->value = value;
	last->life = true;
	last->next = list->head;
	list->tail->next = last;
	list->tail = last;
	list->count++;
	list->tail->next = list->head;
}

void printCircleList(CircleList * list)
{
	if (list->count == 0)
		cout << "Empty";
	else
	{
		CircleListElement * index = list->head;
	    bool findlast = true;
		while (index->next != list->head)
		{
			cout << index->value;
			cout << ' ';
			index = index->next;
		}
		if (findlast)
		{
			cout << index->value;
			findlast = false;
		}
	}
	cout << '\n';
}

CircleListElement * next(CircleList * list, CircleListElement * current)
{
	return current->next;
}

ElementType value(CircleList * list, CircleListElement * element)
{
	return element->value;
}

bool life(CircleList * list, CircleListElement * element)
{
	return element->life;
}

void kill(CircleList * list, CircleListElement * element)
{
	element->life = false;
}

CircleListElement * tail(CircleList * list)
{
	return list->tail;
}

void deleteCircleList(CircleList * list)
{
	int numberOfElements = list->count;
	CircleListElement * temp = list->head;
	for (int i = 0; i < numberOfElements; i++)
	{
		list->head = list->head->next;
		delete temp;
		temp = list->head;
		list->count--;
	}
	list->tail = NULL;
	delete list;
}