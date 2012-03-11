#pragma once

typedef int ElementType;

struct CircleListElement;

struct CircleList;

CircleList * createCircleList(); //создание циклического списка

void addToCircle(CircleList * list, ElementType value); //добавление элемента в конец циклического списка

void printCircleList(CircleList * list); //вывод списка на экран

CircleListElement * next(CircleList * list, CircleListElement * current); // получение следующего элемента

ElementType value(CircleList * list, CircleListElement * element); // получение значения элемента

bool life(CircleList * list, CircleListElement * element); // получение значения поля life

void kill(CircleList * list, CircleListElement * element); // меняет поле life у элемента на false

CircleListElement * tail(CircleList * list); // возвращает последний элемент

void deleteCircleList(CircleList * list); //удаление списка
