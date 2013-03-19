from operator import mul

file = "problem11.txt"
table = map(lambda x:map(int, x), map(lambda x:x.split(), open(file,"r").read().split("\n")))

results = []
for x in xrange(20):
    for y in xrange(20):
       	if x+3 < 20:
            results.append(reduce(mul, [table[y][x+i] for i in xrange(4)]))
        if y+3 < 20:
            results.append(reduce(mul, [table[y+i][x] for i in xrange(4)]))
        if y+3 < 20 and x+3 <20:
           	results.append(reduce(mul, [table[y+i][x+i] for i in xrange(4)]))
        if x > 2 and y+3 < 20:
        	results.append(reduce(mul, [table[y+i][x-i] for i in xrange(4)]))
print max(results)

