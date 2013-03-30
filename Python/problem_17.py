def convert(number):
	lettercount = 0

	numstr = str(number)

	# One's places
	if len(numstr) == 1:
		if number == 1 or number == 2 or number == 6:
			lettercount += 3

		elif number == 4 or number == 5 or number == 9:
			lettercount += 4

		else:
			lettercount += 5

	# Ten's places
	elif len(numstr) == 2:
		if number == 10:
			lettercount += 3

		elif number == 50 or number == 40 or number == 60:
			lettercount += 5

		elif number == 11 or number == 12 or number == 20 or number == 30 or\
			number == 80 or number == 90:
			lettercount += 6

		elif number == 15 or number == 16 or number == 70:
			lettercount += 7

		elif number == 13 or number == 14 or number == 18 or number == 19:
			lettercount += 8

		elif number == 17:
			lettercount += 9

		else:
			lettercount += convert(int((numstr)[-1]))
			lettercount += convert((int(numstr) // 10) * 10)

	# Hundred's places
	elif len(numstr) == 3:
		if not number % 100:
			lettercount += convert(int((numstr)[0])) + 7

		else:
			lettercount += convert(int((numstr)[1:]))
			lettercount += convert((int(numstr) // 100) * 100) + 3

	return lettercount

print sum(convert(1000)) + 11












