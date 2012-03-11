#pragma once

typedef int ElementType;

struct StackElement; // ������� �����

struct Stack; // ����(��������� �� �� ������)

Stack * createStack(); // �������� �����

ElementType pop(Stack * stack); // ����� ������� �� �����

void push(Stack * stack, ElementType value); // �������� ������� � ����

void deleteStack(Stack * stack); // ������� ����

StackElement * head(Stack* stack); // ������ ����������� ������ �����
