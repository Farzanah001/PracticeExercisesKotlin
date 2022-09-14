import java.util.Scanner

class MatchPattern {
    fun getInputString() {
        var scan=Scanner(System.`in`)
        println("Enter the String:")
        var str:String=scan.next() //get the input string
        findMatch(str)
    }


    private fun findMatch(str: String) {
        var endCharacter=str[0]   //initialize with the first character of the string
        var i:Int=1
        var count:Int=0
        while (i<str.length){
            if(str[i]=='0' && endCharacter=='1'){   //if the first character is 1 and second character is 0
                while (str[i]=='0'){ //while the i-th character is 0
                    i++ //increment i. loop runs as long as the next character is 0
                }
                if (str[i]=='1'){  //if the next(i th) character is 1
                    count++  //we've found a pattern so increase the count by 1
                }
            }
            endCharacter=str[i] //assign the i-th(current) character as end character
            i++ //increment i by 1 (next iteration)
        }
        println("Pattern Match Count: $count") //count will have the total number of patterns in the input string
    }
}
fun main(args:Array<String>){
    var match=MatchPattern()
    match.getInputString()
}