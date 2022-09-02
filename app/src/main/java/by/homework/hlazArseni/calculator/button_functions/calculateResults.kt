package by.homework.hlazArseni.calculator.button_functions

import android.view.View
import by.homework.hlazArseni.calculator.databinding.FragmentBinding
import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.repository.VarMapRepository
import by.homework.hlazArseni.calculator.services.VarCreator
import by.homework.hlazArseni.calculator.services.calculation
import com.google.android.material.snackbar.Snackbar

private val repository = VarMapRepository()
private val varCreator = VarCreator(repository)

fun calculateResults(view: View, binding: FragmentBinding): String {
        val expression = binding.mathOperation.text.toString()
        var result = ""
        try {
            result = calculation(expression, varCreator, repository).toString()
        } catch (e: CalcException) {
            Snackbar.make(view, e.message.toString(), Snackbar.LENGTH_INDEFINITE)
                .setAction("clear") {
                    allClearAction(binding)
                }
                .show()
        }
        return result
    }