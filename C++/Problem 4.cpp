#include <iostream>
#include <sstream>

std::string invertString(std::string str) {

	std::reverse(str.begin(), str.end());

	return str;
}

bool isPalindrome(int number) {

	std::string numstring;

	std::ostringstream convert;

	convert << number;

	numstring = convert.str().c_str();

	if(numstring == invertString(numstring)) return 1;
	else return 0;
}

int main() {
	
	int tempn = 0;
	int n = 0;
	for(int i = 999; i >= 100; i--)
	{
		for(int s = 999; s >=100; s--)
		{
			int n = i*s;
			if(n != 0)
			{
				if(isPalindrome(n) && n > tempn) {
					tempn = n;
					printf("%i is a palindrome \n", i*s);
				}
			}
		}
	}

	std::cin.get();

	return 0;
}


	