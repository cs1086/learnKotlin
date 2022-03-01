package com.example.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class GithubStarsActivity : AppCompatActivity() {
    lateinit var find:Button
    lateinit var item:EditText
    lateinit var starList:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_stars)
        find=findViewById(R.id.find)
        item=findViewById(R.id.item)
        starList=findViewById(R.id.starList)
        find.setOnClickListener {
            val userName=item.text
            val url = "https://api.github.com/users/$userName/starred"
            Thread{
                var response=OkHttpHelper.getResponse(url)
                val jsonList=getProjectList(response)
                val intent=Intent(this,InfoActivity::class.java)
                intent.putParcelableArrayListExtra("projects",ArrayList(jsonList))
                startActivity(intent)
            }.start()
        }
    }
    fun getProjectList(jsonAry:JSONArray):MutableList<ProjectModel>{
        val projectList= mutableListOf<ProjectModel>()
        for(i in 0 until jsonAry.length()){
            val item=jsonAry.getJSONObject(i)
            val owner=item.getJSONObject("owner")
            val ownerName=owner.getString("login")
            val avatarURL=owner.getString("avatar_url")
            val projectName = item.get("name").toString()
            val description = item.get("description").toString()
            val starCount = item.get("stargazers_count").toString().toInt()
            val forkCount = item.get("forks_count").toString().toInt()
            val projectModel=ProjectModel(projectName, description, avatarURL, starCount, forkCount, ownerName)
            projectList.add(projectModel)

        }
        return projectList
    }
}