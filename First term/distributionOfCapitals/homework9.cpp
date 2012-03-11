#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int max(int mass[], int length)
{
	int result = mass[0];
	for (int i = 0; i < length; i++)
	{
		if (mass[i] > result)
			result = mass[i];
	}
	return result;
}

bool full(int mass[], int length)
{
	bool flag = true;
	for (int i = 0; i < length; i++)
	{
		if (mass[i] == 0)
			flag = false;
	}
	return flag;
}

int main()
{
	ifstream inFile("cities.txt");
	// считывание данных
	int numberOfCities = 0; 
	int numberOfRoads = 0;
	inFile >> numberOfCities;
	cout << "number of cities : ";
	cout << numberOfCities;
	cout << '\n';
	inFile >> numberOfRoads;
	cout << "number of roads : ";
	cout << numberOfRoads;
	cout << '\n';
	cout << "roads between cities :";
	cout << '\n';
	int * firstCity = new int[numberOfRoads]; // первый город
	int * secondCity = new int[numberOfRoads]; // второй город
	int * length = new int[numberOfRoads];  // расстояние между городами
	for (int i = 0; i < numberOfRoads; i++)
	{
		inFile >> firstCity[i];
		cout << firstCity[i];
		inFile >> secondCity[i];
		cout << secondCity[i];
		inFile >> length[i];
		cout << length[i];
		cout << '\n';
	}
	int numberOfCapitals = 0; 
	inFile >> numberOfCapitals;
	int * countries = new int[numberOfCities + 1]; // будущие государства
	for (int j = 0; j <= numberOfCities; j++)
	{
		countries[j] = 0;
	}
	int capital = 0;
	int * capitals = new int[numberOfCapitals]; // массив столиц
	for (int k = 0; k < numberOfCapitals; k++)
	{
		inFile >> capital;
		capitals[k] = capital;
		countries[capital] = capital; // выделение столиц из остальных городов
	}
   for (int p = 1; p <= numberOfCities; p++) // распределение по государствам
	{
		cout << countries[p];
		cout << ' ';
	}
	cout << '\n'; 
	
	// конец считывания

	int count = numberOfCities - numberOfCapitals;
	while (count > 0)
	{
		for (int l = 0; l < numberOfCapitals; l++) // для каждой столицы находим ближайший город
		{
			int minIndex = -1;
			for (int m = 1; m <= numberOfCities; m++) // смотрим все города
			{
				if (countries[m] == capitals[l]) // если город-столица или принадлежит ей
				{
					int min = max(length, numberOfRoads);
					for (int n = 0; n < numberOfRoads; n++) // ищем наименьшую дорогу из столицы в другой свободный город
					{
						if (length[n] <= min && (firstCity[n] == capitals[l] && countries[secondCity[n]] == 0) || (secondCity[n] == capitals[l] && countries[firstCity[n]] == 0))
						{
							min = length[n];
							minIndex = n;
						}
					}
				}
			}
			if (minIndex != -1)
			{
				if (firstCity[minIndex] != capitals[l]) // ближайший город добавляем к столице
					countries[firstCity[minIndex]] = capitals[l];
				else
					countries[secondCity[minIndex]] = capitals[l];
			}
		}
		count--;
		for (int p = 1; p <= numberOfCities; p++) // распределение по государствам
		{
			cout << countries[p];
			cout << ' ';
		}
		cout << '\n';
	}

	for (int capital = 0; capital < numberOfCapitals; capital++)
	{
		cout << capitals[capital] << ' ';
		cout << "consists of : ";
		for (int city = 1; city <= numberOfCities; city++)
		{
			if (countries[city] == capitals[capital] && countries[city] != city)
			{
				cout << city;
				cout << ' ';
			}
		}
		cout << '\n';
	}
	delete [] firstCity;
	delete [] secondCity;
	delete [] length;
	delete [] countries;
	delete [] capitals;
	return 0;
}