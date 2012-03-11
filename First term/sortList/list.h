#pragma once

#include <iostream>
using namespace std;

struct ListElement;

struct List;

List * createList();

void addToEnd(List * list, string value);

void add(List * list, string value);

void deleteList(List * list);

void deleteFromEnd (List * list);

void deleteElement(List * list, string value);

void printList(List * list);