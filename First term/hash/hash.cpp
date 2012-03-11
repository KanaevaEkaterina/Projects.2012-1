#include <stdio.h>
#include <iostream>
#include <string>
#include "list.h"

using namespace std;

const int q = 13;
const int n = 100;

struct Hash {
	List * mass[n];
};

int hashFunction(string str, int len)
{
	int hash = 0;
	for (int i = 0; i < len; i++)
	{
		hash = hash * q + str[i];
	}
	return hash;
}


void addHash(string str, int len, Hash * hash)
{
	 int i = hashFunction(str, len) % 100;
	 addToEnd(hash->mass[i], str);
}


void printHash(Hash * hash)
{
	for (int i = 0; i < n; i++)
	{
		printList(hash->mass[i]);
		cout << '\n';
	}
}