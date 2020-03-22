class Fraction() {

    var numerator:Int=16
    var denomerator:Int=10
    override fun toString(): String {
        val number = "${numerator} / ${denomerator}"
        return number.toString()
    }
    fun GCD(a:Int, b:Int): Int {
        if (b == 0)
            return a
        return GCD(b, a % b)
    }
    fun ReduceFraction(): String{
        val numb = GCD(numerator,denomerator)
        numerator /= numb
        denomerator /= numb
        return ("${numerator} / ${denomerator}")
    }

    fun Multiplication(x: Int, y: Int) : Fraction{
        var numb1 = numerator*x;
        var numb2 = denomerator*y;
        var result = numb1/numb2
        return Fraction()
    }
}
fun main(){
    print(Fraction().Multiplication(5,6))
    print(Fraction().ReduceFraction())
}