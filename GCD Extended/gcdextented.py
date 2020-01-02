class number:
    def __init__(self, num, mod, rem):
        self.num = num
        self.mod = mod
        self.rem = rem

    def __repr__(self):
        return "<num:%s mod:%s rem:%s>" % (self.num, self.mod, self.rem)

    def __str__(self):
        return '%s %s %s' % (self.num, self.mod, self.rem)


def gcdextent(fnumb, snumb):
    if not (fnumb > snumb):
        print("Integers are not computationally sound")
        quit()
    print("Extended Euclidean Algorithm")
    # int1 = fnumb
    # int2 = snumb
    fnumb = number(fnumb, None, None)
    snumb = number(snumb, None, None)
    snumb.mod = int(fnumb.num / snumb.num)
    snumb.rem = int(fnumb.num % snumb.num)
    compute = True
    sol = []
    rsol = []
    tmp = number(snumb.num, snumb.mod, snumb.rem)
    rsol.append(tmp)

    while (compute):
        # print(str(fnumb.num) + " = " + str(snumb.num) + "(" + str(snumb.mod) + ") " + "+ (" + str(snumb.rem) + ")")
        sol.append(fnumb.num)
        fnumb.num = snumb.num
        snumb.num = snumb.rem
        snumb.mod = int(fnumb.num / snumb.num)
        snumb.rem = int(fnumb.num % snumb.num)
        if (snumb.rem == 0):
            break
        tmp = number(snumb.num, snumb.mod, snumb.rem)
        rsol.append(tmp)
        variable1 = None
        variable2 = None
    for (x, y) in zip(reversed(sol), reversed(rsol)):
        print(str(x) + " - " + str(y.num) + "(" + str(y.mod) + ") " + " = " + str(y.rem))

gcdextent(56, 15)
