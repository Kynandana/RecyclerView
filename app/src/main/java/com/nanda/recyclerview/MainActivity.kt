package com.nanda.recyclerview

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nanda.recyclerview.adapter.AdapterPenyanyi
import com.nanda.recyclerview.databinding.ActivityMainBinding
import com.nanda.recyclerview.model.Penyanyi

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPenyanyi = ArrayList<Penyanyi>()
        listPenyanyi.add(Penyanyi("Baskara Hindia",R.drawable.hindia,"Everything You Are","Jakarta, 22 Februari 1994"))
        listPenyanyi.add(Penyanyi("Nadin Amizah",R.drawable.nadin,"Semua Aku Dirayakan","Bandung, 28 Mei 2000"))
        listPenyanyi.add(Penyanyi("Sal Priadi",R.drawable.sal,"Gala Bunga Matahari","Malang, 30 April 1992"))
        listPenyanyi.add(Penyanyi("Tulus",R.drawable.tulus,"Monokrom","Bukittinggi, 20 Agustus 1987"))

        binding.list.adapter = AdapterPenyanyi(this,listPenyanyi,object : AdapterPenyanyi.OnClickListener {
            override fun detailData(item: Penyanyi?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_penyanyi)

                    val image = this.findViewById<ImageView>(R.id.image_penyanyi)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPenyanyi)
                    val kelahiran = this.findViewById<TextView>(R.id.txtTTLPenyanyi)
                    val lagu = this.findViewById<TextView>(R.id.txtLaguPenyanyi)
                    val btn= this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    kelahiran.text = "${item?.kelahiran}"
                    lagu.text = "${item?.lagu}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }



                }.show()
            }

        })
    }

}