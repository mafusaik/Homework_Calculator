package by.homework.hlazArseni.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import by.homework.hlazArseni.calculator.databinding.FragmentBinding
import by.homework.hlazArseni.calculator.exception.CalcException
import by.homework.hlazArseni.calculator.repository.VarMapRepository
import by.homework.hlazArseni.calculator.services.VarCreator
import by.homework.hlazArseni.calculator.services.calculation
import com.google.android.material.snackbar.Snackbar


class CalculatorFragment : Fragment() {
    private val repository = VarMapRepository()
    private val varCreator = VarCreator(repository)
    private var _binding: FragmentBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            val buttons = listOf(
                button0, button1, button2, button3, button4, button5, button6, button7, button8,
                button9, buttonOpenBracket, buttonCloseBracket, buttonDiv, buttonDot,
                buttonMul, buttonMinus, buttonPlus, buttonDel, buttonAc, buttonEquals
            )

            val clickListener = View.OnClickListener {
                when (it.id) {
                    button0.id,
                    button1.id,
                    button2.id,
                    button3.id,
                    button4.id,
                    button5.id,
                    button6.id,
                    button7.id,
                    button8.id,
                    button9.id,
                    buttonOpenBracket.id,
                    buttonCloseBracket.id,
                    buttonDiv.id,
                    buttonDot.id,
                    buttonMul.id,
                    buttonMinus.id,
                    buttonPlus.id -> symbolAction(it, this)
                    buttonDel.id -> backSpaceAction(this)
                    buttonAc.id -> allClearAction(this)
                    buttonEquals.id -> equalsAction(it, this)
                }
            }
            buttons.forEach { it.setOnClickListener(clickListener) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun allClearAction(binding: FragmentBinding) {
        binding.mathOperation.text = ""
        binding.resultText.text = ""
    }

    private fun backSpaceAction(binding: FragmentBinding) {
        val length = binding.mathOperation.length()
        if (length > 0)
            binding.mathOperation.text = binding.mathOperation.text.subSequence(0, length - 1)
    }

    private fun calculateResults(view: View, binding: FragmentBinding): String {
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

    private fun equalsAction(view: View, binding: FragmentBinding) {
        binding.resultText.text = calculateResults(view, binding)
    }

    private fun symbolAction(view: View, binding: FragmentBinding) {
        if (view is Button) {
            binding.mathOperation.append(view.text)
        }
    }
}

