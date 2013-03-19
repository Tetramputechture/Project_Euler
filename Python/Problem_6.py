"""
this is code before i knew of a sum function
def sumofsquares(max):
	return reduce(lambda x, y: x+y**2, range(max+1))
	
def squareofsum(max):
	return reduce(lambda x, y: x+y, range(max+1))**2

print squareofsum(100) - sumofsquares(100)
"""

print sum(range(1, 101))**2 - sum( [x**2 for x in range(1, 101)] )
