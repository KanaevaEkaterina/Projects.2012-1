#pragma once;

typedef char ElementType;

struct StackElement; // элемент стека

struct Stack; // стек (указатель на голову)

Stack * createStack(); // создание стека

ElementType pop(Stack * stack); // взять элемент из стека

void push(Stack * stack, ElementType value); // добавить элемент в стек

void deleteStack(Stack * stack); // удалить стек

StackElement * head(Stack * stack); // указатель на голову стека