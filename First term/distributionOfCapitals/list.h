#pragma once

struct ListElement;

struct List;

typedef int ElementType;

List * createList();

void addToEnd(List * list, ElementType value);

void add(List * list, ElementType value);

void deleteList(List * list);

void deleteFromEnd (List * list);

void deleteElement(List * list, ElementType value);

void printList(List * list);