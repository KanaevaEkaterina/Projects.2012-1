#pragma once

typedef int ElementType;

struct StackElement; // елемент стэка

struct Stack; // стэк(указатель на на голову)

Stack * createStack(); // создание стэка

ElementType pop(Stack * stack); // взять элемент из стэка

void push(Stack * stack, ElementType value); // добавить элемент в стэк

void deleteStack(Stack * stack); // удалить стэк

StackElement * head(Stack* stack); // выдать указательна голову стэка
