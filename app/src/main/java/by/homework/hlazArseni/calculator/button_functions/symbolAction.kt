package by.homework.hlazArseni.calculator.button_functions

import android.view.View
import android.widget.Button
import by.homework.hlazArseni.calculator.databinding.FragmentBinding

fun symbolAction(view: View, binding: FragmentBinding) {
        if (view is Button) {
            binding.mathOperation.append(view.text)
        }
    }