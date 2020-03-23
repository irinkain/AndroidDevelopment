class Fraction(private var numerator: Int, private var denomerator: Int) {

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

    fun Multiplication(fraction: Fraction) : Fraction{
        val numb1 = this.numerator * fraction.numerator
        val numb2 = this.denomerator * fraction.denomerator
        return Fraction(numb1,numb2)
    }
}
fun main(){
    val frac1 = Fraction(8,10)
    val frac2 = Fraction(2,5)
    print((frac1).Multiplication(frac2))
}