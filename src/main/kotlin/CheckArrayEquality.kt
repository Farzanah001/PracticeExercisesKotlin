import java.util.Arrays
import java.util.Scanner

class CheckArrayEquality {
    fun getInput() {
        var scan=Scanner(System.`in`)
        println("Enter the Size for Array 1:")
        var firstArraySize:Int=scan.nextInt()
        println("Enter the Array Elements:")
        var firstArray=Array<Int>(firstArraySize){0}
        for(i in 0 until firstArraySize){
            firstArray[i]=scan.nextInt()     //get input for first array
        }
        println("Enter the Size for Array 2:")
        var secondArraySize:Int=scan.nextInt()
        println("Enter the Array Elements:")
        var secondArray=Array<Int>(secondArraySize){0}
        for(i in 0 until secondArraySize){
            secondArray[i]=scan.nextInt()   //get input for second array
        }
        checkIfEqual(firstArray,secondArray)
    }

    private fun checkIfEqual(firstArray: Array<Int>, secondArray: Array<Int>) {

        //sort both arrays, if the both the arrays have same elements, then it'll both be identical after sorting
        Arrays.sort(firstArray)
        Arrays.sort(secondArray)

        //contentEquals() check whether both the arrays are identical
        if (firstArray.contentEquals(secondArray)) {
            println("Yes") //if true, prints "Yes"
        } else {
            println("No")  //if false, prints "No"
        }
    }
}
fun main(args:Array<String>){
    var checkEquality=CheckArrayEquality()
    checkEquality.getInput()

}