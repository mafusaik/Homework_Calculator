package by.homework.hlazArseni.calculator.services

import by.homework.hlazArseni.calculator.constant.Constants
import by.homework.hlazArseni.calculator.entity.Var
import by.homework.hlazArseni.calculator.repository.VarMapRepository

fun calc(
    inputExpression: String,
    varCreator: VarCreator,
    repository: VarMapRepository
): Var {
    var expression = inputExpression
        .replace(Constants.SPACES.toRegex(), "")

    while (expression.contains("(")) {
        expression = deleteBrackets(expression, varCreator, repository)
    }

    val operands: MutableList<String> = Regex(Constants.MATH_OPERATIONS)
        .split(expression).toMutableList()
    val operations = mutableListOf<String>()

    Regex(Constants.MATH_OPERATIONS).findAll(expression)
        .forEach { operations.add(it.value) }

    while (operations.isNotEmpty()) {
        val index: Int = getPriority(operations)
        val leftOperand = operands.removeAt(index)
        val operation = operations.removeAt(index)
        val rightOperand = operands.removeAt(index)
        val result: Var? =
            calcOneOperation(leftOperand, operation, rightOperand, varCreator, repository)
        operands.add(index, result.toString())
    }
    return varCreator.createVar(operands[0])
}