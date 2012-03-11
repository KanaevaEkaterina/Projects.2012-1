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
	// ���������� ������
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
	int * firstCity = new int[numberOfRoads]; // ������ �����
	int * secondCity = new int[numberOfRoads]; // ������ �����
	int * length = new int[numberOfRoads];  // ���������� ����� ��������
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
	int * countries = new int[numberOfCities + 1]; // ������� �����������
	for (int j = 0; j <= numberOfCities; j++)
	{
		countries[j] = 0;
	}
	int capital = 0;
	int * capitals = new int[numberOfCapitals]; // ������ ������
	for (int k = 0; k < numberOfCapitals; k++)
	{
		inFile >> capital;
		capitals[k] = capital;
		countries[capital] = capital; // ��������� ������ �� ��������� �������
	}
   for (int p = 1; p <= numberOfCities; p++) // ������������� �� ������������
	{
		cout << countries[p];
		cout << ' ';
	}
	cout << '\n'; 
	
	// ����� ����������

	int count = numberOfCities - numberOfCapitals;
	while (count > 0)
	{
		for (int l = 0; l < numberOfCapitals; l++) // ��� ������ ������� ������� ��������� �����
		{
			int minIndex = -1;
			for (int m = 1; m <= numberOfCities; m++) // ������� ��� ������
			{
				if (countries[m] == capitals[l]) // ���� �����-������� ��� ����������� ��
				{
					int min = max(length, numberOfRoads);
					for (int n = 0; n < numberOfRoads; n++) // ���� ���������� ������ �� ������� � ������ ��������� �����
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
				if (firstCity[minIndex] != capitals[l]) // ��������� ����� ��������� � �������
					countries[firstCity[minIndex]] = capitals[l];
				else
					countries[secondCity[minIndex]] = capitals[l];
			}
		}
		count--;
		for (int p = 1; p <= numberOfCities; p++) // ������������� �� ������������
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