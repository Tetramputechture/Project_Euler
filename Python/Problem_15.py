
L = [1] * 20
for i in range(20):
    for j in range(i):
       	L[j] = L[j]+L[j-1]
    L[i] = 2 * L[i - 1]
print L[19]