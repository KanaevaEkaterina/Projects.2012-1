#include <stdio.h>
#include <iostream>
#include "list.h"

using namespace std;

void merge1(List * list, int len1, int len2, ListElement * beg)
{
	List * newList1 = createList(); // разделение списка на два новых
	//ListElement * index = next(list, head(list));
	ListElement * index = beg;
	for (int i = 0; i < len1; i++)
	{
	   addToEnd(newList1, name(list, index), number(list, index));
	   index = next(list, index);
	}
	List * newList2 = createList();
	for (int j = 0; j < len2; j++)
	{
		addToEnd(newList2, name(list, index), number(list, index));
	    index = next(list, index);
	}
	//
	ListElement * r = next(newList1, head(newList1)); 
	ListElement * l = next(newList2, head(newList2)); 
	List * newList = createList();
	while (r != NULL && l != NULL)
	{
		if (number(newList1, r) < number(newList2, l))
		{
			addToEnd(newList, name(newList1, r), number(newList1, r));
			if (next(newList1, r) != NULL)
				r = next(newList1, r);
			else break;
		}
		else
		{
			addToEnd(newList, name(newList2, l), number(newList2, l));
			if (next(newList2, l) != NULL)
				l = next(newList2, l);
			else break;
		}
	}
	while (r != NULL)
	{
		addToEnd(newList, name(newList1, r), number(newList1, r));
		if (next(newList1, r) != NULL)
			r = next(newList1, r);
		else break;
	}
	while (l != NULL)
	{
		addToEnd(newList, name(newList2, l), number(newList2, l));
		if (next(newList2, l) != NULL)
			l = next(newList2, l);
		else break;
	}
	deleteList(newList1);
	deleteList(newList2);
	list = copyList(newList, list);
}
 
void mergeSort(List * list, ListElement * beg, int len, int parametr)
{
	if (len == 2)
	{
		if (parametr == 1)
		{
			ListElement * i = beg;
			if (number(list, i) > number(list, next(list, i)))
			{
				change(list, i, next(list, i));
			}
		}
		/*if (parametr == 2)
		{
			ListElement * i = next(list, head(list));
			if (name(list, i) > name(list, next(list, i)))
			{
				change(list, i, next(list, i));
			}
		}*/
	}
	else if (len > 2)
	{
		if (len % 2 == 1)
		{
			if (parametr == 1)
			{
				mergeSort(list, beg, len/2, parametr);
				mergeSort(list, plus(beg, len/2), len/2 + 1, parametr);
				merge1(list, len/2, len/2 + 1, beg);
			}
			/*if (parametr == 2)
			{
				mergeSort(list, beg, len/2, parametr);
				mergeSort(list, plus(beg, len/2), len/2 + 1, parametr);
				merge2(list, len/2, len/2 + 1, beg);
			}*/
		}
		if (len % 2 == 0)
		{
			if (parametr == 1)
			{
				mergeSort(list, beg, len/2, parametr);
				mergeSort(list, plus(beg, len/2 + 1), len/2, parametr);
				merge1(list, len/2, len/2, beg);
			}
			/*if (parametr == 2)
			{
				mergeSort(list, beg, len/2, parametr);
				mergeSort(list, plus(beg, len/2 + 1), len/2, parametr);
				merge2(list, len/2, len/2, beg);
			}*/
		}
	}
}	