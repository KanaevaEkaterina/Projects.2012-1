#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

void change(int a[], int i, int j)
{
	int c = a[i];
	a[i] = a[j];
	a[j] = c;
}

void Sort(int mass[], int n, int mass1[], int mass2[])
{
for (int i = 1; i <= n - 1; i++)
	{
		bool flag = true;
		for (int j = 0; j <= n - 2 ; j++)
		{
			if (mass[j] > mass[j + 1])
			{
				change(mass, j, j + 1);
				change(mass1, j, j + 1);
				change(mass2, j, j + 1);
				flag = false;
			}
		}
		if (flag)
		{
			break;
		}
	}
}

int main()
{
	ifstream inFile1("graf.txt");
	int i = 0;
	int ch = 0;
	double count = 0;
	while (!inFile1.eof()) 
	{ 
		inFile1 >> ch;
		count++;
	}
	inFile1.close();
	double numberOfNodesDouble = sqrt(count);
	int numberOfNodes = static_cast< int >(numberOfNodesDouble); // количество вершин
	int * first = new int[numberOfNodes]; // массив первых вершин
    int * second = new int[numberOfNodes]; // массив вторых вершин
	int * road = new int[numberOfNodes]; // массив путей из первой во вторую вершину
	ifstream inFile2("graf.txt");
	int index = 0;	
	for (int i = 0; i < numberOfNodes; i++)
	{
		for (int j = 0; j < numberOfNodes; j++)
		{
			inFile2 >> ch;
			if (j > i && ch != 0)
			{
				first[index] = i + 1;
				second[index] = j + 1;
				road[index] = ch;
				index++;
			}
		}
	}
	inFile2.close();
	int numberOfRoads = index; // количество путей между вершинами
	Sort(road, numberOfRoads, first, second); // сортировка вершин по возрастанию величины путей
	int * cities = new int[numberOfNodes + 1]; // соединены уже вершины или нет
	for (int k = 1; k <= numberOfNodes; k++)
	{
		cities[k] = 0;
	}
	cout << "Minimal tree (first top - second top - length of road):";
	cout << '\n';
	for (int l = 0; l < numberOfNodes; l++)
	{
		if (cities[first[l]] != cities[second[l]] || (cities[first[l]] == 0 && cities[second[l]] == 0)) // вершины находятся в разных компонентах связности или еще не принадлежат никакой
		{
			if (cities[first[l]] == 0 && cities[second[l]] == 0)
			{
				cities[first[l]] = first[l];
				cities[second[l]] = first[l];
			}
			else if (cities[first[l]] == 0 && cities[second[l]] != 0)
			{
				cities[first[l]] = cities[second[l]];
			}
			else if (cities[first[l]] != 0 && cities[second[l]] == 0)
			{
				cities[second[l]] = cities[first[l]];
			}
			else 
			{
				for (int m = 0; m < numberOfNodes; m++)
				{
					if (cities[m] == cities[second[l]])
						cities[m] = cities[first[l]];
				}
			}
			cout << first[l] << ' ' << second[l] << ' ' << road[l];
			cout << '\n';
		}
	}
	cout << '\n';
	delete [] cities;
	delete [] first;
	delete [] second;
	delete [] road;
	return 0;
}