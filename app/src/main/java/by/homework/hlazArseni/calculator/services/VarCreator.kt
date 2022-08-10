package by.homework.hlazArseni.calculator.services

import by.homework.hlazArseni.calculator.constant.Constants
import by.homework.hlazArseni.calculator.entity.Scalar
import by.homework.hlazArseni.calculator.entity.Var
import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.repository.VarMapRepository

class VarCreator(private var repository: VarMapRepository) {

    fun createVar(stringVar: String): Var = when {
        stringVar.matches(Regex(Constants.SCALAR)) -> Scalar(stringVar)
        else -> repository.get(stringVar)?.let {
            repository.get(stringVar)
        } ?: throw CalcException("incorrect string $stringVar")
    }
}