package by.homework.hlazArseni.calculator.entity

import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.interfaces.Operation

abstract class Var : Operation {

    override fun plus(other: Var?): Var? {
        throw CalcException("Incorrect operation $this + $other")
    }

    override fun minus(other: Var?): Var? {
        throw CalcException("Incorrect operation $this - $other")
    }

    override fun times(other: Var?): Var? {
        throw CalcException("Incorrect operation $this * $other")
    }

    override fun div(other: Var?): Var? {
        throw CalcException("Incorrect operation $this / $other")
    }

    override fun toString(): String {
        return "unknown variable"
    }
}