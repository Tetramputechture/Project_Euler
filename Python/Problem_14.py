#This is how I found out about memoization :)

lookup = {}

def countTerms(n):
   if n not in lookup:
      if n == 1:
         return 1, 0
      if not n % 2:
         lookup[n] = countTerms(n / 2)[0] + 1
      else:
         lookup[n] = countTerms(n*3 + 1)[0] + 1

   return lookup[n], n

print max(countTerms(i) for i in xrange(3, 1000000, 2))
