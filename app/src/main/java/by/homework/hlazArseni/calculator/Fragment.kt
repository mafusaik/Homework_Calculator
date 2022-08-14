package by.homework.hlazArseni.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.homework.hlazArseni.calculator.button_functions.allClearAction
import by.homework.hlazArseni.calculator.button_functions.backSpaceAction
import by.homework.hlazArseni.calculator.button_functions.equalsAction
import by.homework.hlazArseni.calculator.button_functions.symbolAction
import by.homework.hlazArseni.calculator.databinding.FragmentBinding


class Fragment : Fragment() {

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
            val clickListener = View.OnClickListener {
                when (it.id) {
                    button0.id -> symbolAction(it, this)
                    button1.id -> symbolAction(it, this)
                    button2.id -> symbolAction(it, this)
                    button3.id -> symbolAction(it, this)
                    button4.id -> symbolAction(it, this)
                    button5.id -> symbolAction(it, this)
                    button6.id -> symbolAction(it, this)
                    button7.id -> symbolAction(it, this)
                    button8.id -> symbolAction(it, this)
                    button9.id -> symbolAction(it, this)
                    buttonOpenBracket.id -> symbolAction(it, this)
                    buttonCloseBracket.id -> symbolAction(it, this)
                    buttonDiv.id -> symbolAction(it, this)
                    buttonDot.id -> symbolAction(it, this)
                    buttonMul.id -> symbolAction(it, this)
                    buttonMinus.id -> symbolAction(it, this)
                    buttonPlus.id -> symbolAction(it, this)
                    buttonDel.id -> backSpaceAction(this)
                    buttonAc.id -> allClearAction(this)
                    buttonEquals.id -> equalsAction(it, this)
                }
            }

            button0.setOnClickListener(clickListener)
            button1.setOnClickListener(clickListener)
            button2.setOnClickListener(clickListener)
            button3.setOnClickListener(clickListener)
            button4.setOnClickListener(clickListener)
            button5.setOnClickListener(clickListener)
            button6.setOnClickListener(clickListener)
            button7.setOnClickListener(clickListener)
            button8.setOnClickListener(clickListener)
            button9.setOnClickListener(clickListener)
            buttonOpenBracket.setOnClickListener(clickListener)
            buttonCloseBracket.setOnClickListener(clickListener)
            buttonDiv.setOnClickListener(clickListener)
            buttonDot.setOnClickListener(clickListener)
            buttonMul.setOnClickListener(clickListener)
            buttonMinus.setOnClickListener(clickListener)
            buttonPlus.setOnClickListener(clickListener)
            buttonDel.setOnClickListener(clickListener)
            buttonAc.setOnClickListener(clickListener)
            buttonEquals.setOnClickListener(clickListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

