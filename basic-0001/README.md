## Under Attack

### Introduction

Imagine you will design a computer chess game and need to find out all the spots that are under attack by a piece given its current position.

For this problem, we only consider three major pieces: queen(Q), rook(R), and kight(K).

The chess board will be represented with a 8x8 2-D array of characters, which contains the following information: 

1. If a piece is placed on a spot, that array element will be marked with the name of the piece ('Q', 'R', or 'K').
2. If a spot is under attack, that array element will be marked with a '*' character.
3. Otherwise, all array elements will be marked with a '_' character.

You will be given the position of a piece under consideration and asked for printing chess board in ASCII format that displays the status of every spot on the board.

### Sample Input
```
K  2  3
R  1  4
Q  3  2
```

### Sample Output
```
_ _ * _ * _ _ _
_ * _ _ _ * _ _
_ _ _ K _ _ _ _
_ * _ _ _ * _ _
_ _ * _ * _ _ _
_ _ _ _ _ _ _ _
_ _ _ _ _ _ _ _
_ _ _ _ _ _ _ _

_ _ _ _ * _ _ _
* * * * R * * *
_ _ _ _ * _ _ _
_ _ _ _ * _ _ _
_ _ _ _ * _ _ _
_ _ _ _ * _ _ _
_ _ _ _ * _ _ _
_ _ _ _ * _ _ _

_ _ * _ _ * _ _
* _ * _ * _ _ _
_ * * * _ _ _ _
* * Q * * * * *
_ * * * _ _ _ _
* _ * _ * _ _ _
_ _ * _ _ * _ _
_ _ * _ _ _ * _

```