package by.homework.hlazArseni.calculator.services

import by.homework.hlazArseni.calculator.entity.Var
import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.repository.VarMapRepository

fun calcOneOperation(
    leftOperand: String,
    operation: String,
    rightOperand: String,
    varCreator: VarCreator,
    repository: VarMapRepository
): Var? {
    val right = varCreator.createVar(rightOperand)
    when (operation) {
        "=" -> return repository.save(leftOperand, right)
    }
    val left = varCreator.createVar(leftOperand)
    when (operation) {
        "+" -> return left.plus(right)
        "-" -> return left.minus(right)
        "*" -> return left.times(right)
        "/" -> return left.div(right)
    }
    throw CalcException("not found operation $operation")
}