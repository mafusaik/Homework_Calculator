package by.homework.hlazArseni.calculator.button_functions

import by.homework.hlazArseni.calculator.databinding.FragmentBinding

fun backSpaceAction(binding: FragmentBinding) {
        val length = binding.mathOperation.length()
        if (length > 0)
            binding.mathOperation.text = binding.mathOperation.text.subSequence(0, length - 1)
    }