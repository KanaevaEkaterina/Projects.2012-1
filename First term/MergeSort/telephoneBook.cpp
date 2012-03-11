#include <stdio.h>
#include <iostream>
#include "list.h"
#include <fstream>
#include <string>
#include "mergeSort.h"

using namespace std;

int main()
{
	List * list = createList();
	ifstream inFile("telephonebook.txt");
	string name = "gf";
	int number;
	char ch;
	while (!inFile.eof())
	{
		inFile >> name;
		if (!inFile.eof())
		{
			inFile >> ch;
			inFile >> number;
			addToEnd(list, name, number);
		}
	}
	cout << "List :";
	cout << '\n';
	printList(list);
	cout << "Sorted list :";
	cout << '\n'; 
	mergeSort(list, next(list, head(list)), count(list), 1);
	printList(list);
	cout << '\n';
	inFile.close();
	return 0;
}