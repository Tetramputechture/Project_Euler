#include <iostream>

/*for a number looping from 1 to int_max
	test if number is divisible by numbers 1 through 20
		if it is, smallest number is that number 
		return
		
		else, increment number*/

int main() {
	
	for(int number = 20; number<INT_MAX; number += 20)
	{
		for(int divisor = 1; divisor <= 20; divisor++)
		{
			if(number % divisor != 0) break;

			else if(divisor == 20)
			{
				printf("your number is %i\n", number);
				std::cin.get();
				return 0;
			}

		}
	}

	std::cin.get();

	return 0;
	
}


	

	