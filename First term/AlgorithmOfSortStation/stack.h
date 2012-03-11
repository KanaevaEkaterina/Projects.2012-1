#pragma once

typedef char ElementType;

struct StackElement; //элемент стека (значение+указатель)

struct Stack; // стек (голова+число элементов)

Stack * createStack(); // создание стека

ElementType pop(Stack * stack); // вытолкнуть эелемент из стека

void push(Stack * stack, ElementType value); // добавить улемент в стек

void deleteStack(Stack * stack); // удалить стек

StackElement * headS(Stack * stack); // головуъа стека

ElementType valueS(Stack * stack, StackElement * element); // значение элемента стека

int count(Stack * stack); // число элементов в стеке
