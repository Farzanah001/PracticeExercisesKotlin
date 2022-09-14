import java.util.*

private fun getMaxCountChar(count: IntArray): Char {
    var maximum = 0
    var character = 0.toChar()
    for (index in 0..25) {
        if (count[index] > maximum) {    //sets the maximum value of the array as maximum
            maximum = count[index]
            character = ('a'.code.plus(index)).toChar()   //gets the equivalent alphabet character
        }
    }

    return character  //returns the character
}

private fun rearrangeString(originalString: String): String {
    val originalStringLength = originalString.length

    if (originalStringLength == 0)
        return ""

    val count = IntArray(26)  //array to store alphabet characters (ascii value)

    for (i in 0..25) {
        count[i] = 0      //set all the elements as 0
    }

    for (characters in originalString.toCharArray()) {
        count[characters.code.minus('a'.code)]++   //ascii code of current character - ascii code of 'a'(97)
        //increments the value of the element on the character array
        //eg: if the character is 'b', 98-97=1. Increments the count[1] by 1
    }

    val characterMaximum = getMaxCountChar(count)   //function to get which character is present max. no. of times
    var maxCount = count[characterMaximum.code.minus('a'.code)] //returns the array value of the character
    //i.e. if the character is 'b', maxCount will have the number of 'b's present in the array (value stored in count[1])

    if (maxCount > (originalStringLength.plus(1)).div(2))
        //if there are more distinct characters than similar characters, then its not possible to get the desired output
        //eg: originalString="aaade". count[0]=3. 3>[(5+1)/2]=3>6. So, Its Not Possible to completely separate the similar characters
        return ""

    var modifiedString = ""

    for (index in 0 until originalStringLength) {
        //initialize the string with n(length of the originalString) ' '(spaces)
        modifiedString += ' '
    }

    var endIndex = 0  //initialize the variable with 0 (first character will be assigned. and will be moved forward)

    while (maxCount > 0) { //loop count=count of the maximum repeated character
        modifiedString = (modifiedString.substring(0, endIndex).plus(characterMaximum.plus(modifiedString.substring(endIndex + 1))))
        //place the similar characters in even places. (replaces the space by the character
        endIndex += 2   //skips the elements by 2 (points to the even locations)
        maxCount--
    }

    count[characterMaximum.code - 'a'.code] = 0 //set the repeated character's count to 0

    for (index in 0..25) {
        while (count[index] > 0) { //checks only the distinct characters now.
            endIndex = if (endIndex >= originalStringLength)
                1
            else
                endIndex

            modifiedString = (modifiedString.substring(0, endIndex).plus(('a'.code + index).toChar().plus(modifiedString.substring(endIndex.plus(1)))))
            //places the distinct characters on odd positions (one by one)
            endIndex += 2 //starts from an odd position and skips by 2(points to the odd locations)
            count[index]-- //decreases the character count by 1, to indicate that one of the character is already placed
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