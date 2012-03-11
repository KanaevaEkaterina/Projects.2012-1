#pragma once

typedef char ElementType;

struct QueueElement; // ������� ������� (��������+���������)

struct Queue; // ������� (������+����� ���������)

Queue * createQueue(); // �������� �������

ElementType dequeue(Queue * queue); // ���������� ������� �� �������

void enqueue(Queue * queue, ElementType value); // �������� ������� � �������

void deleteQueue(Queue * queue); // ������� �������

QueueElement * headQ(Queue * queue); // ������ �������

int count(Queue * queue); // ����� ��������� � �������

