import java.util.Scanner

class MatchPattern {
    fun getInputString() {
        var scan=Scanner(System.`in`)
        println("Enter the String:")
        var str:String=scan.next()
        findMatch(str)
    }


    private fun findMatch(str: String) {
        var endCharacter=str[0]
        var i:Int=1
        var count:Int=0
        while (i<str.length){
            if(str[i]=='0' && endCharacter=='1'){
                while (str[i]=='0'){
                    i++
                }
                if (str[i]=='1'){
                    count++
                }
            }
            endCharacter=str[i]
            i++
        }
        println("Pattern Match Count: $count")
    }
}
fun main(args:Array<String>){
    var match=MatchPattern()
    match.getInputString()
}