"""
Second part: also track the aim. The depth now only changes on behalf of the aim. 
"""

horisontal = 0
depth = 0
aim = 0

with open("input.txt") as fil:
    for linje in fil:
        info = linje.split()
        if info[0] == "forward": 
            horisontal += int(info[1])
            depth += (aim * int(info[1]))
        elif info[0] == "up": 
            aim -= int(info[1])
        else:
            aim += int(info[1])
    
    print(depth * horisontal)