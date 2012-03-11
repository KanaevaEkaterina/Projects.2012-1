#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

//typedef int ElementType;

struct ListElement
{
	string name;
	int number;
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

void addToEnd(List * list, string name, int number)
{
	ListElement * last = new ListElement;
	last->name = name;
	last->number = number;
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
		cout << "list is empty";
}

/*void deleteElement(List * list, ElementType value)
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
}*/

/*void add(List * list, ElementType value)
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
}*/

void printList(List * list)
{
	if (list->count == 0)
		cout << "list is empty";
	else
	{
		ListElement * index = list->head->next;
		while (index != NULL)
		{
			cout << index->name;
			cout << ' ';
			cout << '-';
			cout << ' ';
			cout << index->number;
			index = index->next;
			cout << '\n';
		}
	}
	cout << '\n';
}

ListElement * head(List * list)
{
	return list->head;
}

ListElement * next(List * list, ListElement * element)
{
	return element->next;
}

int number(List * list, ListElement * element)
{
	return element->number;
}

string name(List * list, ListElement * element)
{
	return element->name;
}

int count(List * list)
{
	return list->count;
}

List * copyList(List * listBeg, List * listFin)
{
	ListElement * tmp = listFin->head->next;
	while (tmp != NULL)
	{
		listFin->head->next = listFin->head->next->next;
		delete tmp;
		tmp = listFin->head->next;
		listFin->count--;
	}
    tmp = next(listBeg, head(listBeg));
	while (tmp != NULL)
	{
		addToEnd(listFin, name(listBeg, tmp), number(listBeg, tmp));
	}
	return listFin;
}

void change(List * list, ListElement* i, ListElement * j)
{
	list->head->next = j;
	j->next = i;
	i->next = NULL;
}

ListElement * plus(ListElement * beg, int plusValue)
{
	ListElement * index = beg;
	for (int i = 0; i < plusValue; i++)
	{
		index = index-> next;
	}
	return index;
}