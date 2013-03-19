from math import sqrt

def isprime(n):
	for x in range(2, int(n**0.5)+1):
		if n%x==0: return False
	return True
	
def largest_prime_factor(n):
	prime_factor = 0
	x = 2
	
	while x <= sqrt(n):
		if(n%x == 0 and isprime(x)):
			prime_factor = x
		x+=1
		
	return prime_factor
	
print largest_prime_factor(600851475143)