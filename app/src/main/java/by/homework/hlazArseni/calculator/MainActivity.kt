package by.homework.hlazArseni.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import by.homework.hlazArseni.calculator.repository.VarMapRepository
import by.homework.hlazArseni.calculator.services.VarCreator
import by.homework.hlazArseni.calculator.services.calc
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val repository = VarMapRepository()
    private val varCreator = VarCreator(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // val binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        setContentView(R.layout.activity_main)

    }

    fun symbolAction(view: View) {
        if (view is Button) {
//            if (view.text.isEmpty()){
                math_operation.append(view.text)
//            } else{
//               allClearAction(view)

        }
    }

    fun allClearAction(view: View) {
        math_operation.text = ""
        result_text.text = ""
    }

    fun backSpaceAction(view: View) {
        val length = math_operation.length()
        if (length > 0)
            math_operation.text = math_operation.text.subSequence(0, length - 1)
    }

    fun equalsAction(view: View) {
       result_text.text = calculateResults()
    }

    private fun calculateResults(): String {
        val expression = math_operation.text.toString()
        return calc(expression, varCreator, repository).toString()
    }

//
//    class ButtonAction(binding: ActivityMainBinding) {
//        private var canAddOperation = false
//        private var canAddDecimal = true
//        private val entryField = binding.mathOperation
//        private val resultField = binding.resultText
//
//        fun numberAction(view: View) {
//            if (view is Button) {
//                if (view.text == ".") {
//                    if (canAddDecimal)
//                        entryField.append(view.text)
//
//                    canAddDecimal = false
//                } else
//                    entryField.append(view.text)
//
//                canAddOperation = true
//            }
//        }
//
//        fun operationAction(view: View) {
//            if (view is Button && canAddOperation) {
//                entryField.append(view.text)
//                canAddOperation = false
//                canAddDecimal = true
//            }
//        }
//
//        fun allClearAction(view: View) {
//            entryField.text = ""
//            resultField.text = ""
//        }
//
//        fun backSpaceAction(view: View) {
//            val length = entryField.length()
//            if (length > 0)
//                entryField.text = entryField.text.subSequence(0, length - 1)
//        }
//
//        fun equalsAction(view: View) {
//            resultField.text = calculateResults()
//        }
//
//        private fun calculateResults(): String {
//            return ""
//        }
//
//    }

}