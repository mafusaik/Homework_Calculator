package by.homework.hlazArseni.calculator.repository

import by.homework.hlazArseni.calculator.entity.Var
import by.homework.hlazArseni.calculator.interfaces.Repository

class VarMapRepository : Repository {

    private var vars = mutableMapOf<String, Var?>()

    override fun save(name: String, value: Var?): Var? {
        vars[name] = value
        return value
    }

    override fun get(name: String?): Var? {
        return vars[name]
    }
}

