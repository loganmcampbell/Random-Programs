
import java.util.ArrayList

fun main(args: Array<String>) {
    println("Enter a word: ")
    // After running this line remember to press "Enter" after typing in some input
    var message = readLine() ?:""
    message = message.toUpperCase()
    println(message)
    var x = 0

    for (letter in message)
    {
        //print(...)

        print("[" + x + "]" + ": " + letter + " ")
        x++
    }

    val original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    println()
    val nlist = arrayListOf<Int>()
    val elist = arrayListOf<Char>()
    for (c in message) {
        for (d in original.toCharArray()) {
            if (c == d)
                nlist.add(original.indexOf(c))

        }
    }
    println(nlist)

    for (x in nlist)
    {
        for (i in original.reversed()) {
            if (x == original.reversed().indexOf(i))
                elist.add(i)
        }

    }
    println(elist)
}



