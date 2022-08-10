package by.homework.hlazArseni.calculator.interfaces

import by.homework.hlazArseni.calculator.entity.Var

interface Repository {

    fun save(name: String, value: Var?): Var?
    fun get(name: String?): Var?
}