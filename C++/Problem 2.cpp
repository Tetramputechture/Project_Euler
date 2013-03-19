#include <iostream>

int main()
{
	int sum=0;
	int x=1;
	int y=1;
	int z = 0;
	do { 
		if(x%2==0) sum += x;
		z=x; x+=y; y=z;
	} while (x<4000000);

	printf("%i\n", sum);

	std::cin.get();

	return 0;
}

	