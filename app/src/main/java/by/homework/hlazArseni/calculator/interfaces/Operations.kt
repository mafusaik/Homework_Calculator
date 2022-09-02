package by.homework.hlazArseni.calculator.interfaces

import by.homework.hlazArseni.calculator.entity.Var

interface Operation {
    operator fun plus(other: Var?): Var?
    operator fun minus(other: Var?): Var?
    operator fun times(other: Var?): Var?
    operator fun div(other: Var?): Var?
}