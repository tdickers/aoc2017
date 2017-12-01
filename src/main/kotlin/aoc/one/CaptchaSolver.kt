package aoc.one

class CaptchaSolver {
    fun toIntList(intStr: String):List<Int> {
        return intStr.toCharArray().map { char -> char.toInt() - 48}
    }

    fun sum(numbers: String):Int {
        var accumulator = 0
        var total = 0
        var numberList = toIntList(numbers)

        numberList.forEachIndexed { index, current ->
            var next:Int

            if (index == numberList.size - 1) {
                next = numberList[0]
            } else {
                next = numberList[index + 1]
            }

            if (current == next) {
                accumulator += current
                if (index == numberList.size - 1) {
                    total += accumulator // last item
                }
            } else {
                total += accumulator
                accumulator = 0
            }

//            println("Current is " + current)
//            println("Next is " + next)
//            println("Accumulator is " + accumulator)
//            println("Total is " + total)
//            println("-----")
        }

        return total
    }
}