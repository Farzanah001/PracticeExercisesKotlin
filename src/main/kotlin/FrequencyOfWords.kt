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
        var count:Int=1
        for(i in 0 until splitWords.size){
            for(j in i+1 until splitWords.size){
                if(splitWords[i] == splitWords[j] && splitWords[i]!=="-1"){
                    splitWords[j]="-1"
                    count++
                }
            }
            if(count>1 && splitWords[i]!="-1"){
                println("${splitWords[i]} -> $count")
                splitWords[i]="-1"
            }
            count=1
        }
    }
}
fun main(args:Array<String>){
    var frequency=FrequencyOfWords()
    frequency.getInputString()
}