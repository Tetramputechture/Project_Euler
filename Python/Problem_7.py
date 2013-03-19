def isprime(n):
	for x in range(2, int(n**0.5)+1):
		if n%x==0: return False
	return True
	
def findprime(n):
	prime = 0
	count = 0
	x = 3 #so we can increment by 2 to make the loop run faster
	
	while count < n-1: #n-1 because we start at 3
			if(isprime(x)):
				solution = x
				count+=1
			x+=2 
			
	return prime
	
print findprime(10001)