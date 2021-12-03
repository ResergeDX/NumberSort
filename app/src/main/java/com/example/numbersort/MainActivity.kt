package com.example.numbersort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numbersort.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number: ArrayList<Int> =  arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //number.add(0)
        val adaptador= Adaptador(this@MainActivity,number)
        with(binding) {
            rvListNumbers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvListNumbers.adapter = adaptador
        }
    }

    fun saveNum(view: android.view.View) {
        var info=""
        with(binding) {
            if(etNumber.text.toString()!="") {
                info = etNumber.text.toString()
                number.add(Integer.parseInt(info))
                etNumber.text.clear()
                update()
            }else{
                etNumber.error=getString(R.string.ErrorNumber)
            }
        }
    }

    fun sortAscend(view: android.view.View) {
        if(number.size>1){
            number.sort()
            update()
        }else if(number.size==1){
            Toast.makeText(this, R.string.OneListItem, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, R.string.NoInfoList, Toast.LENGTH_LONG).show()
        }
    }
    fun sortDesc(view: android.view.View) {
        if(number.size>1){
            number.sort()
            number.reverse()
            update()
        }else if(number.size==1){
            Toast.makeText(this, R.string.OneListItem, Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, R.string.NoInfoList, Toast.LENGTH_LONG).show()
        }
    }
    fun clearList(view: android.view.View) {
        if(number.size>1){
            number.clear()
            update()
            Toast.makeText(this,R.string.ListCleared,Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, R.string.NoInfoList, Toast.LENGTH_LONG).show()
        }

    }

    private fun update(){
        binding.rvListNumbers.adapter = Adaptador(this@MainActivity,number)
    }




}