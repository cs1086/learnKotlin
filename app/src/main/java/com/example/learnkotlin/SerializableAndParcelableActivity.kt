package com.example.learnkotlin

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import java.io.*


class SerializableAndParcelableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serializable_and_parcelable)
        changeActivity()
    }
    fun writeUser(){//配合User
        val user=User()
        user.name="王柏榕"
        user.age=28
//        try {
        println("####getExternalFilesDir=${""}")
//            if (!(getExternalFilesDir("testSerializable")!!.exists())) {
//                getExternalFilesDir("testSerializable")?.mkdirs();
//            }
            val objectOutputStream = ObjectOutputStream(FileOutputStream(File(getExternalFilesDir("testSerializable")?.path+"/a.txt")))
            objectOutputStream.writeObject(user)
            objectOutputStream.close()
            println("####序列畫成功")

//        }catch (e:Exception){
//            println("####序列畫失敗，原因${e.stackTrace.toString()}")
//        }
    }
    fun readUser(){//配合User
        try {
            val objectOutputStream = ObjectInputStream(FileInputStream(File(getExternalFilesDir("testSerializable")?.path+"/a.txt")))
            val user = objectOutputStream.readObject() as User
            objectOutputStream.close()
            println("####反序列畫成功,name=${user.name},age=${user.age}")
        }catch (e:Exception){
            println("####反序列畫失敗，原因${e.message}")
        }
    }
    fun changeActivity(){//配合User2
        val user2=User2()
        user2.name="王柏榕"
        user2.age=28
        val intent = Intent(this, SerializableAndParcelable2Activity::class.java)
        intent.putExtra("user2", user2)//支持Serializable、Parcelable
        startActivity(intent)
    }
    class User:Serializable{
        var serialVersionUID=10002L
        var name=""
        var age=10
    }
    class User2() : Parcelable {
        var serialVersionUID=10002L
        var name=""
        var age=10

        constructor(parcel: Parcel) : this() {
            serialVersionUID = parcel.readLong()
            name = parcel.readString()!!
            age = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeLong(serialVersionUID)
            parcel.writeString(name)
            parcel.writeInt(age)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<User2> {
            override fun createFromParcel(parcel: Parcel): User2 {
                return User2(parcel)
            }

            override fun newArray(size: Int): Array<User2?> {
                return arrayOfNulls(size)
            }
        }
    }
}