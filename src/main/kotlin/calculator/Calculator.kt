package calculator

object Calculator {

    private const val DELIMITER = " "

    fun execute(expression: String?): Double {
        require(!expression.isNullOrBlank())
        val terms = expression.split(DELIMITER)
        return calculate(
            numbers = getNumbers(terms),
            operators = getOperators(terms)
        )
    }

    private fun isNumber(index: Int) = index % 2 == 0

    private fun isOperator(index: Int) = index % 2 == 1

    private fun getNumbers(list: List<String>) =
        list
            .filterIndexed { i, _ -> isNumber(i) }
            .map { it.toDoubleOrThrowIllegalArgumentException() }

    private fun getOperators(list: List<String>) =
        list
            .filterIndexed { i, _ -> isOperator(i) }
            .map { Operator(it) }

    private fun String.toDoubleOrThrowIllegalArgumentException(): Double {
        return toDoubleOrNull() ?: throw IllegalArgumentException()
    }

    private fun calculate(numbers: List<Double>, operators: List<Operator>): Double {
        require(numbers.size - operators.size == 1)
        var sum = numbers[0]
        operators.forEachIndexed { index, operator ->
            sum = operator.operation()(sum, numbers[index + 1])
        }
        return sum
    }
}
