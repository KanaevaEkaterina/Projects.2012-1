#include "stdafx.h"
#include <iostream>

using namespace std;

typedef char ElementType;

struct ListElement
{
	ElementType value;
	ListElement * next;
};

struct List 
{
	ListElement * head;
	ListElement * tail;
	int count;
};

List * createList()
{
	List * start = new List;
	ListElement * guard = new ListElement;
	start->head = guard;
	start->tail = guard;
	guard->next = NULL;
	start->count = 0;
	return start;
}

void addToEnd(List * list, ElementType value)
{
	ListElement * last = new ListElement;
	last->value = value;
	last->next = NULL;
	list->tail->next = last;
	list->tail = last;
	list->count++;
}

void deleteList(List * list)
{
    ListElement * tmp = list->head;
	while (tmp != NULL)
	{
		list->head = list->head->next;
		delete tmp;
		tmp = list->head;
		list->count--;
	}
	delete list;
}

void deleteFromEnd (List * list)
{
	ListElement * index = list->head;
	if (list->head != NULL)
	{
		if (list->head->next == NULL)
			list->head = NULL;
		else
		{
			index = list->head;
			while (index->next->next != NULL)
				index = index->next;
			ListElement * temp = index->next;
			index->next = NULL;
			delete temp;
		}
	}
	else
		cout << "Список пуст";
}

void deleteElement(List * list, ElementType value)
{
	ListElement * index = list->head;
	while (index->next != NULL)
	{
		if (index->next->value == value)
		{
			ListElement * temp = index->next;
			index->next = index->next->next;
			delete temp;
			list->count--;
		}
		else
			index = index->next;
	}
}

void add(List * list, ElementType value)
{
	ListElement * index = list->head;
	ListElement * further = new ListElement;
	while (index->next != NULL)
	{
		if (index->next->value <= value)
		{
			index = index->next;
		}
		else
		{
			further->value = value;
			further->next = index->next;
			index->next = further;
			list->count++;
			break;
		}
	}
	if (index->next == NULL)
	{
		addToEnd(list, value);
		list->count++;
	}
}

void printList(List * list)
{
	if (list->count == 0)
		cout << "Список пуст";
	else
	{
		ListElement * index = list->head;
		while (index->next != NULL)
		{
			index = index->next;
			cout << index->value;
			cout << ' ';
		}
	}
	cout << '\n';
}
