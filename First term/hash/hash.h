#pragma once;

#include <iostream>
using namespace std;

struct Hash;

int hashFunction(string str, int len);

void addHash(string str, int len, Hash * hash);

void printHash(Hash * hash);