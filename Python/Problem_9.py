from sys import exit

for a in range(333):		
	for b in range(500):
		c = 1000-a-b
		if a**2 + b**2 == c**2 and c>b:
			print a*b*c
			exit()
				


		









