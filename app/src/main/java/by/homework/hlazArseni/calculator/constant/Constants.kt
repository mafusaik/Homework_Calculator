package by.homework.hlazArseni.calculator.constant

class Constants {
    companion object {
        const val ROUND_BRACKETS = "[()]"
        const val EXPRESSION_IN_BRACKETS = "\\([^()]+\\)"
        const val MATH_OPERATIONS = "(?<=[^{,+=*/-])[-+*/=]"
        const val SPACES = "\\s+"
        const val SCALAR = "-?[0-9]+(\\.[0-9]+)?+E?+(-?[0-9]+)?"
    }
}