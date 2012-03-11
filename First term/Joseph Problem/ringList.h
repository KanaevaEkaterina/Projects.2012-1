#pragma once

typedef int ElementType;

struct CircleListElement;

struct CircleList;

CircleList * createCircleList(); //�������� ������������ ������

void addToCircle(CircleList * list, ElementType value); //���������� �������� � ����� ������������ ������

void printCircleList(CircleList * list); //����� ������ �� �����

CircleListElement * next(CircleList * list, CircleListElement * current); // ��������� ���������� ��������

ElementType value(CircleList * list, CircleListElement * element); // ��������� �������� ��������

bool life(CircleList * list, CircleListElement * element); // ��������� �������� ���� life

void kill(CircleList * list, CircleListElement * element); // ������ ���� life � �������� �� false

CircleListElement * tail(CircleList * list); // ���������� ��������� �������

void deleteCircleList(CircleList * list); //�������� ������
