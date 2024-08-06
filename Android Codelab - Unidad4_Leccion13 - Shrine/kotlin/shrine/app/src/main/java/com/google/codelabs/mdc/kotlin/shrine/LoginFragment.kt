package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.

        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)
        val nextButton: MaterialButton = view.findViewById(R.id.next_button)
        val passwordTextInput: TextInputLayout = view.findViewById(R.id.password_text_input)
        val passwordEditText: EditText = view.findViewById(R.id.password_edit_text)

        nextButton.setOnClickListener {
            if (!isPasswordValid(passwordEditText.text!!)) {
                passwordTextInput.error = getString(R.string.shr_error_password)
            } else {
                passwordTextInput.error = null
                // Importante!!! Para navegar al siguiente fragment tras darle al boton de Next y validarse el formato de la contraseña
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }
        passwordEditText.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(passwordEditText.text!!)) {
                passwordTextInput.error = null
            }
            false
        }
        return view
    }


    private fun isPasswordValid(text: Editable?): Boolean{
        return text != null && text.length >= 8
    }

}
