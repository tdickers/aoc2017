package aoc.one

class CircularCaptchaSolver {

    fun sum(numbers: String):Int {
        val numberList = CaptchaSolver().toIntList(numbers)

        if (numberList.size % 2 != 0) {
            throw IllegalArgumentException("Input must have even length")
        }

        var total = 0
        numberList.forEachIndexed { index, current ->
            val comparisonVal = numberList[comparisonPosition(numberList.size, index)]
            total += maybeSum(current, comparisonVal)
        }

        return total
    }

    fun maybeSum(current:Int, comparisonVal:Int):Int {
        if (current == comparisonVal) {
            return current
        }
        return 0
    }

    fun comparisonPosition(length:Int, currentIndex:Int):Int {
        val incrementAmount = length/2
        val desiredPosition = currentIndex + incrementAmount
        if (desiredPosition < length) {
            return desiredPosition;
        } else {
            return Math.abs(length - desiredPosition)
        }
    }
}