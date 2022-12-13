"""
First part was trivial, put everything in a nested list, and iterate vertically on behalf of the length of the
numbers. 

Second part a bit trickier, but we can use the gamma- and epsilon rate that we found in part one. 
Remember that gamma is the most common value, and epsilon the least common value. 
Just kidding, this solution works but is a bit ugly, it could defintely be improved. Possibly with a hashmap?
"""

alleLinjer = []
gammaRate = ""
epsilonRate = ""

with open("input.txt") as fil:
    for linje in fil:
        alleLinjer.append(linje.strip())

oxygenTall = alleLinjer.copy()
for i in range(len(alleLinjer[0])):
    antEn = 0
    if len(oxygenTall) == 1:
        break

    for linje in oxygenTall:
        if linje[i] == "1":
            antEn += 1

    if antEn >= len(oxygenTall) / 2:
        for nummer in alleLinjer:
            if nummer[i] == "0":
                if nummer in oxygenTall:
                    oxygenTall.remove(nummer)
    else:
        for nummer in alleLinjer:
            if nummer[i] == "1":
                if nummer in oxygenTall:
                    oxygenTall.remove(nummer)
                    
co2Tall = alleLinjer.copy()
for i in range(len(alleLinjer[0])):
    antEn = 0
    if len(co2Tall) == 1:
        break

    for linje in co2Tall:
        if linje[i] == "1":
            antEn += 1

    if antEn >= len(co2Tall) / 2:
        for nummer in alleLinjer:
            if nummer[i] == "1":
                if nummer in co2Tall:
                    co2Tall.remove(nummer)
    else:
        for nummer in alleLinjer:
            if nummer[i] == "0":
                if nummer in co2Tall:
                    co2Tall.remove(nummer)

print(int(oxygenTall[0], 2) * int(co2Tall[0], 2))