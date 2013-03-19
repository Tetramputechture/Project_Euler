return max([a * b for a in xrange(900, 1000) for b in xrange(a, 1000) 
			if str(a * b) == str(a * b)[::-1]])