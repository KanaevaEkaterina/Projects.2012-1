#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

int stop(char * string, int length, char ch)
{
		int i = -1;
		for (i = length - 2; i > 0; i--)
		{
			if (string[i] == ch)
				break;
		}
		if (i != -1)
			return i;
		else
			return 0;
}

int mur(const char * haystack, const char * needle)
{
	int i, j, k;
	int needle_table[256];
 
   int needle_len = strlen(needle);
   int haystack_len = strlen(haystack);
 
   if (needle_len < haystack_len)
   {
      for (i = 0; i < 256; i++)
         needle_table[i] = needle_len;
      for (i = 1; i < needle_len; i++)
         needle_table[needle[i]] = needle_len-i;
 
      i = needle_len;
      j = i;
      while ((j > 0) && (i <= haystack_len))
      {
         j = needle_len;
         k = i;
         while ((j > 0) && (haystack[k] == needle[j]))
         {
            k--;
            j--;
         }
         i += needle_table[haystack[i]];
      }
 
      if (k > haystack_len - needle_len)
         return 0;
      else
         return k + 1;
   }
   else
      return 0;
}

int main()
{
	char * text = new char[10000];
	ifstream inFile("text.txt");
	char ch;
	int i = 0;
	while (!inFile.eof())
	{
		inFile >> ch;
		if (!inFile.eof())
		{
			text[i] = ch;
			i++;
		}
		else
			break;
	}
	int numberInText = i;
	cout << numberInText;
	cout << '\n';	
	cout << "String : ";
	char * needle = new char[100];
	char el = 'a';
	int j = 0;
	while (el != '=')
	{
		cin >> el;
		if (el != '=')
		{
			needle[j] = el;
			j++;
		} else break;
	}
	int numberInString = j;
	cout << numberInString;
	cout << '\n';	
	int k = numberInString - 1;
	int l = 0;
	while(k > -1)
	{
		if (needle[l + k] == text[l + k])
		{
			if (k = 0)
			{
				cout << "number " <<  l;
				break;
			}
			else
				k--;
		}
		else
		{
			l += numberInString - stop(needle, numberInString, text[l + k]);
			k = numberInString - 1;
		}
	}
	
	return 0;
}

