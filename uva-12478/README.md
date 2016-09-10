## [12478 - Hardest Problem Ever (Easy)](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=279&page=show_problem&problem=3922)

You are given a 9 × 9 grid containing letters:
```
OBIDAIBKR
RKAULHISP
SADIYANNO
HEISAWHIA
IRAKIBULS
MFBINTRNO
UTOYZIFAH
LEBSYNUNE
EMOTIONAL
```

Names given below (in no particular order) are hidden in the grid:
```
RAKIBUL
ANINDYA
MOSHIUR
SHIPLU
KABIR
SUNNY
OBAIDA
WASI
```

They are hidden in the following ways:

1. The names are present in the grid either vertically or horizontally. (Letters of a particular name will be adjacent either only horizontally or only vertically).
2. Each person’s name may not be in its original form, letters may be permuted. For example “wasi” can be present as “iaws”, which is found in the 4th row.
3. Exactly the names mentioned above are given. Knowing any other name of them will not give you any advantage.

Now, the task: It is guaranteed that only one name is hidden exactly twice in this grid. All the
other names are hidden exactly once. You have to print the name which is hidden just twice.

### Input

There is no input for this problem.

### Output

Output just one string which is the name hidden twice in the grid

*Note: First sort the names, compare them to all sorted substrings with the same length from the horizontal and verticle lines in the grid.*
