#pragma once

typedef char ElementType;

struct QueueElement; // элемент очереди (значение+указатель)

struct Queue; // очередь (голова+число элементов)

Queue * createQueue(); // создание очереди

ElementType dequeue(Queue * queue); // вытолкнуть элемент из очереди

void enqueue(Queue * queue, ElementType value); // добавить элемент в очередь

void deleteQueue(Queue * queue); // удалить очередь

QueueElement * headQ(Queue * queue); // голова очереди

int count(Queue * queue); // число элементов в очереди

