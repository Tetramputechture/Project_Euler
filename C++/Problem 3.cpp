#include <iostream>
#include <vector>
#include <math.h>

std::vector<int> prime_sieve(int n) {
	std::vector<bool> boolvector (n, true);

	int sqrtn = sqrt(n);

	for(int i=2; i<sqrtn; i++) {
		if(boolvector[i]) {
			for(int j=i*i; j<sqrtn; j+=i) {
				boolvector[j] = false;
			}
		}
	}

	boolvector[0] = boolvector[1] = false;

	std::vector<int> primevector;

	for(int i=2; i<n; i++) {
		if(boolvector[i]) primevector.push_back(i);
	}

	return primevector;
}

int trial_division(long long n) {
	std::vector<int> primes = prime_sieve(sqrt(n));

	int highestprimefactor = 0;

	std::vector<int>::iterator it;

	for(it = primes.begin(); it < primes.end(); it++) {
		if((*it)*(*it) > n) break;
		else if(n % (n/(*it)) == 0) {
			std::cout << *it << "\n";
			highestprimefactor = n/(*it);
			n /= *it;
		}
	}

	return highestprimefactor;
}

int main() {
	//long long number;
	//std::cout << "Enter a number: ";
	//std::cin >> number;

	printf("%i\n", trial_division(600851475143));
	std::cin.get();
	std::cin.get();
	return 0;
}
