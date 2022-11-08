package com.miempresa.usofragmentosv4.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.miempresa.usofragmentosv4.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IngresoValores.newInstance] factory method to
 * create an instance of this fragment.
 */
class IngresoValores : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        //return inflater.inflate(R.layout.fragment_ingreso_valores, container, false)

        val view:View =
            inflater.inflate(R.layout.fragment_ingreso_valores , container , false)

        var seleccion = view.findViewById<Spinner>(R.id.seleccion)

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.operaciones,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            seleccion.adapter = adapter
        }

        //var t = seleccion.getSelectedItem().toString();



        var txtvalor1 = view.findViewById<EditText>(R.id.txtvalor1)
        var txtvalor2 = view.findViewById<EditText>(R.id.txtvalor2)
        var btnResolver = view.findViewById<Button>(R.id.btnResolver)


        btnResolver.setOnClickListener( View.OnClickListener{
            val resultados = Resultados()
            val args = Bundle()

            //enviando datos con el nombre name con valor de lo escrito en el fragmento2 xml
            args.putString("valor1"  , txtvalor1.getText().toString())
            args.putString("valor2"  , txtvalor2.getText().toString())

            args.putString("ope"  ,seleccion.getSelectedItem().toString())
            resultados.arguments  = args

            val transaccion : FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.contenedor1, resultados)
            transaccion.commit()
        })
        return view


    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IngresoValores.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IngresoValores().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}