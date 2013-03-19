bignumber = []

file = open("problem13.txt", 'r')
for line in file:
   bignumber.extend(map(int, line.split()))
file.close()

formatted = str(sum(bignumber))
print formatted[:10]



