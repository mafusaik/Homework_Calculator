package by.homework.hlazArseni.calculator.services

import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.repository.VarMapRepository
import java.util.*

fun parser() {
    val printer = Printer()
    val repository = VarMapRepository()
    val varCreator = VarCreator(repository)
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val expression = scanner.nextLine()
        if (expression == "end") {
            break
        } else try {
            val result = calc(expression, varCreator, repository)
            printer.print(result)
        } catch (e: CalcException) {
            println(e.message)
        }
    }
}