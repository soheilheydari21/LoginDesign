package com.soheilheydari.logindesign.ui.youtube

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.soheilheydari.logindesign.R

class YoutubeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_youtube, container, false)
        var login = root.findViewById<Button>(R.id.btnYoutube)

        login.setOnClickListener {
            val intent = Intent(context, YoutubeActivity::class.java)
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