def gcf(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a*b/gcf(a, b)

print reduce(lcm, range(2, 21))