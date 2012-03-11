#pragma once

struct ListElement;

struct List;

//typedef int ElementType;

List * createList();

void addToEnd(List * list, std::string name, int number);

//void add(List * list, ElementType value);
void deleteList(List * list);

void deleteFromEnd (List * list);

//void deleteElement(List * list, ElementType value);

void printList(List * list);

ListElement * head(List * list);

ListElement * next(List * list, ListElement * element);

std::string name(List * list, ListElement * element);

int number(List * list, ListElement * element);

int count(List * list);

List * copyList(List * listBeg, List * listFin);

void change(List * list, ListElement* i, ListElement * j);

ListElement * plus(ListElement * beg, int plusValue);