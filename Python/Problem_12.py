def count_factors(number):
   max = int(number**0.5)+1
   factors = 0
   for x in range(1,max):
      if not number%x:    
         factors += 2
   return factors

x = 1
triangle = 1
while True:
   if not x%2:   
      factors = count_factors(x//2)*count_factors(x+1)    #whatifinstead's optimizations
   else:
      factors = count_factors(x)*count_factors((x+1)//2)    #whatifinstead's optimizations
   if factors > 500:
      break
   x += 1
   triangle += x

print triangle





