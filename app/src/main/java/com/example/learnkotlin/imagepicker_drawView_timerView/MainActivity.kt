package com.example.learnkotlin.imagepicker_drawView_timerView

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.learnkotlin.R

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }
    var tabButton:Button?=null
    var tvCount:TextView?=null
    var seekBar: SeekBar?=null
    var editText:EditText?=null
    var imageView:ImageView?=null
    var number=0
    var customView: CustomView?=null
    var ballView: BallView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        customView=findViewById(R.id.customView)
        ballView=findViewById(R.id.ballView)
        ballView?.setCrashView(customView!!)
        tabButton=findViewById<Button>(R.id.btnCount)
        tvCount=findViewById<TextView>(R.id.tvCount)
        tabButton?.setOnClickListener{
            tvCount?.text=(++number).toString();
            seekBar?.setProgress(number)
        }
        seekBar=findViewById<SeekBar>(R.id.seekBar)
        seekBar?.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Log.d(TAG, "onProgressChanged: p0=$p0,p1=$p1,p2=$p2" )
                tvCount?.text=p1.toString()
                editText?.setText(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Log.d(TAG, "onStartTrackingTouch: $p0")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Log.d(TAG, "onStopTrackingTouch: $p0")
            }

        })
        editText=findViewById(R.id.editTextTextPersonName)
        editText?.setOnEditorActionListener{ v,actionId,event->
            Log.d(TAG,"actionId=$actionId,event=${event?.action}")
//            seekBar?.setProgress(v.text.toString().toInt())
//            tvCount?.setText(v.text)
            false
        }
        imageView=findViewById(R.id.customView)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.resetItem ->{
                number=0;
                tvCount?.text=number.toString()
                editText?.setText(number.toString())
            }
            //打開相簿
            R.id.album ->{
                var intent= Intent()
                intent.type="image/*"
                startActivityForResult(intent,54)

            }
            //打開相機
            R.id.camera ->{
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, 64)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Log.d(TAG, "onActivityResult: requestCode=$requestCode,resultCode=$resultCode,data=$data")
        when(requestCode){
            54->{
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val resolver = this.contentResolver
                    val bitmap =
                            MediaStore.Images.Media.getBitmap(resolver, data?.data)
                    imageView?.setImageBitmap(bitmap)
                }
            }
            64->{
                if (resultCode == Activity.RESULT_OK && data != null) {
                    imageView?.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
        }
    }

}
