import java.util.Scanner

class FrequencyOfWords {
    fun getInputString() {
        var scan=Scanner(System.`in`)
        println("Enter the Text:")
        var inputText:String=scan.nextLine()
        findFrequency(inputText)
    }

    private fun findFrequency(inputText: String) {
        var splitWords= inputText.split("\\s+|[\\-\\+\\$\\?\\.@&].*").toMutableList()
        //we split the given string based on the given delimiters(space, hyphen, and other special characters)
        //splitWords is a list, that stores the individual words of the given string.
        var count:Int=1
        for(i in 0 until splitWords.size){ //starts first element(word) of the array(sentence)
            for(j in i+1 until splitWords.size){ //immediate next element(word) in the array
                if(splitWords[i] == splitWords[j] && splitWords[i]!=="-1"){ //if both the words are equal and unvisited(-1 represents that the word is already visited and taken into account)
                    splitWords[j]="-1" //set the visited word to -1
                    count++ //increase the count
                }
            }
            if(count>1 && splitWords[i]!="-1"){ //prints the words that are present in the string, more than once
                println("${splitWords[i]} -> $count") //prints the word along with count
                splitWords[i]="-1" //if the i-th word is compared with all the other words, set it to -1.
            }
            count=1 //reset the count to 1, because we need the count of all the repeated words
        }
    }
}
fun main(args:Array<String>){
    var frequency=FrequencyOfWords()
    frequency.getInputString()
}