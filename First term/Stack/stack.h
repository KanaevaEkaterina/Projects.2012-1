#pragma once

typedef char ElementType;

struct StackElement; //������� ����� (��������+���������)

struct Stack; // ���� (������+����� ���������)

Stack * createStack(); // �������� �����

ElementType pop(Stack * stack); // ���������� �������� �� �����

void push(Stack * stack, ElementType value); // �������� ������� � ����

void deleteStack(Stack * stack); // ������� ����

StackElement * headS(Stack * stack); // �������� �����

ElementType valueS(Stack * stack, StackElement * element); // �������� �������� �����

int count(Stack * stack); // ����� ��������� � �����
