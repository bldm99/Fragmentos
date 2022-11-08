package com.miempresa.usofragmentosv4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.miempresa.usofragmentosv4.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Resultados.newInstance] factory method to
 * create an instance of this fragment.
 *
 */




class Resultados : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    fun suma(a :Int , b:Int):String{
         var res = a + b
        return "$a + $b = $res"   //78 + 1 = 79
    }

    fun resta(a :Int , b:Int):String{
        var res = a - b
        return "$a - $b = $res"
    }

    fun multiplicacion(a :Int , b:Int):String{
        var res = a * b
        return "$a x $b = $res"
    }

    fun division(a :Int , b:Int):String{
        var res = a / b
        return "$a / $b = $res"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_resultados, container, false)

        val view:View =
            inflater.inflate(R.layout.fragment_resultados , container , false)

        var resultadofinal = view.findViewById<TextView>(R.id.resultadofinal)
        var eleccionmat = view.findViewById<TextView>(R.id.eleccionmat)



        if(arguments != null){

            val recibidon1 = requireArguments().getString("valor1").toString().toInt()
            val recibidon2 = requireArguments().getString("valor2").toString().toInt()

            val operacion = requireArguments().getString("ope")



            eleccionmat.text = operacion

            if (operacion == "sumar"){
                var output = suma(recibidon1,recibidon2) //78 + 1 = 79
                resultadofinal.text = "$output"
            }
            if (operacion == "restar"){
                var output = resta(recibidon1,recibidon2)
                resultadofinal.text = "$output"
            }
            if (operacion == "multiplicar"){
                var output = multiplicacion(recibidon1,recibidon2)
                resultadofinal.text = "$output"
            }
            if (operacion == "dividir"){
                var output = division(recibidon1,recibidon2)
                resultadofinal.text = "$output"
            }



        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Resultados.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Resultados().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}