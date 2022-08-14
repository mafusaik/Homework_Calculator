package by.homework.hlazArseni.calculator.button_functions

import android.view.View
import by.homework.hlazArseni.calculator.databinding.FragmentBinding

fun equalsAction(view: View, binding: FragmentBinding) {
        binding.resultText.text = calculateResults(view, binding)
    }