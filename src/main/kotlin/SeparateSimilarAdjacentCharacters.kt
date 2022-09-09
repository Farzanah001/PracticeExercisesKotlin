import java.util.*

private fun getMaxCountChar(count: IntArray): Char {
    var maximum = 0
    var character = 0.toChar()
    for (index in 0..25) {
        if (count[index] > maximum) {
            maximum = count[index]
            character = ('a'.code.plus(index)).toChar()
        }
    }

    return character
}

private fun rearrangeString(originalString: String): String {
    val originalStringLength = originalString.length

    if (originalStringLength == 0)
        return ""

    val count = IntArray(26)

    for (i in 0..25) {
        count[i] = 0
    }

    for (characters in originalString.toCharArray()) {
        count[characters.code.minus('a'.code)]++
    }

    val characterMaximum = getMaxCountChar(count)
    var maxCount = count[characterMaximum.code.minus('a'.code)]

    if (maxCount > (originalStringLength.plus(1)).div(2))
        return ""

    var modifiedString = ""

    for (index in 0 until originalStringLength) {
        modifiedString += ' '
    }

    var endIndex = 0

    while (maxCount > 0) {
        modifiedString = (modifiedString.substring(0, endIndex).plus(characterMaximum.plus(modifiedString.substring(endIndex + 1))))
        endIndex += 2
        maxCount--
    }

    count[characterMaximum.code - 'a'.code] = 0

    for (index in 0..25) {
        while (count[index] > 0) {
            endIndex = if
                    (endIndex.compareTo(originalStringLength) >= 0) 1
            else
                endIndex

            modifiedString = (modifiedString.substring(0, endIndex).plus(('a'.code + index).toChar().plus(modifiedString.substring(endIndex.plus(1)))))
            endIndex += 2
            count[index]--
        }
    }

    return modifiedString
}

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter the string: ")
    val originalString = scanner.nextLine()

    val result = rearrangeString(originalString)

    if (result === "")
        println("Not possible")
    else
        println("The modified string is: $result")
}