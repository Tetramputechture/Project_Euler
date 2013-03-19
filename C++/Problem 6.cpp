#include <iostream>
#include <cmath>

inline double sumofSquares(int number) {

	double total = 0;

	for(int i=1; i<=number; i++) {
		total += pow(i, 2);
	}
	return total;
}

inline double squareofSums(int number) {

	double total = 0;

	for(int i=1; i<=number; i++) {
		total += i;
	}

	return pow(total, 2);
}

int main() {
	
	int number = 1000;

	double difference =  squareofSums(number) - sumofSquares(number);

	printf("Sum of squares of first %i natural numbers: %d\n", number, sumofSquares(number));
	printf("Square of sums of first %i natural numbers: %d\n", number, squareofSums(number));
	printf("Difference: %i\n", difference);

	_sleep(10000);

	return 0;
}


	

	