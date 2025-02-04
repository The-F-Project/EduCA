package org.thefproject.fedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.airbnb.lottie.LottieAnimationView
import org.thefproject.fedu.R

class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Инфлейтим кастомный макет
        val view = inflater.inflate(R.layout.activity_custom_dialog, container, false)

        // Получаем элементы из макета
        val titleTextView: TextView = view.findViewById(R.id.dialog_title)
        val messageTextView: TextView = view.findViewById(R.id.dialog_message)
        val button1: Button = view.findViewById(R.id.dialog_button3)
        val button2: Button = view.findViewById(R.id.dialog_button2)
        val animationView: LottieAnimationView = view.findViewById(R.id.animationView)

        // Устанавливаем текст сообщения (можно передать через аргументы)
        titleTextView.text = arguments?.getString("title") ?: "Заголовок"
        messageTextView.text = arguments?.getString("message") ?: "Сообщение"

        // Устанавливаем обработчики нажатий на кнопки
        button1.setOnClickListener {
            // Действие для первой кнопки
            dismiss() // Закрываем диалог
        }

        button2.setOnClickListener {
            // Действие для второй кнопки
            dismiss() // Закрываем диалог
        }

        return view
    }

    companion object {
        fun newInstance(title: String, message: String): CustomDialogFragment {
            val fragment = CustomDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putString("message", message)
            fragment.arguments = args
            return fragment
        }
    }
}