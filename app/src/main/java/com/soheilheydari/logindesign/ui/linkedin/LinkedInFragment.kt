package com.soheilheydari.logindesign.ui.linkedin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.soheilheydari.logindesign.R

class LinkedInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_linked_in, container, false)
        var login = root.findViewById<Button>(R.id.btnLinkedin)

        login.setOnClickListener {
            val intent = Intent(context, LinkedinActivity::class.java)
            startActivity(intent)
        }

        val help = "دکمه continue رو کلیک کنید" + "\n" +
                "و بعد وارد حسابتان شوید." + "\n" +
                "در صورت نیاز فیلترشکنتون رو روشن کنید."

//        var textView = root.findViewById<TextView>(R.id.textView)
//        textView.setText(help)

        return root
    }


}