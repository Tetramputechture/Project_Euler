#include <iostream>
#include <vector>
#include <math.h>


bool isPrime(int i) {

	if(i == 0 || i == 1) return 0;

	
	for(int divisor=3; divisor<i-1; divisor++) {

		if(i % divisor == 0) return false;
	}

	return true;
}
	

int main() {

	int highestprime = 0;

	int i = 0;

	for(int x=0; i<10001; x++) {
		if(isPrime(x)) {
			std::cout << "prime: " << x << "   count: " << i << " \n";
			highestprime = x;
			i++;
		}
	}


	printf("%i\n", highestprime);

	std::cin.get();
		
	return 0;
}
