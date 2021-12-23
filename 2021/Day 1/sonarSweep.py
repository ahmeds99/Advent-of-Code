"""
I have overwritten my solution to the first problem, but it was essentially to check if 
the previous depth was larger than the current (if so, increment the counter).

The second task was a bit trickier, here I solved the problem using lists and removing and appending
the new values. The sum() function runs in O(n), and I probably could have solved it a bit faster by just adding
and subtracting the values as they came in, rather than using a list to store the current three-sums.  
"""

forrigeTreSum = []
antOkninger = 0
nåværendeTreSum = []
første = True

with open("input.txt") as fil:
    if len(forrigeTreSum) != 3:
        # Handle the first case, and initiate the lists
        for i in range(3):
            tall = int(fil.readline())
            if not første:
                nåværendeTreSum.append(tall)
            forrigeTreSum.append(tall)
            if i == 0:
                første = False

    for linje in fil:
        nåværendeTreSum.append(int(linje))
        if sum(nåværendeTreSum) > sum(forrigeTreSum):
                antOkninger += 1
        forrigeTreSum.pop(0); forrigeTreSum.append(nåværendeTreSum[2])
        nåværendeTreSum.pop(0)
        
print(antOkninger)