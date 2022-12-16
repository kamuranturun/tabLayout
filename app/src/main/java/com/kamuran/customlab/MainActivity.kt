package com.kamuran.customlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custo_tab.view.*

class MainActivity : AppCompatActivity() {

    lateinit var tLayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tLayout=tabLayout

        tLayout.addTab(tLayout.newTab()) //yeni tab olusturma
        tLayout.addTab(tLayout.newTab())

        TabOlustur()

        tLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
              tabSec(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        tabSec(0)

    }

    fun TabOlustur(){
        val tab1= LayoutInflater.from(this).inflate(R.layout.custo_tab,null)
        tab1.tvBaslik.text= "tab 1"
        tab1.tvSayi.text= "1"
        tLayout.getTabAt(0)?.setCustomView(tab1)


        val tab2= LayoutInflater.from(this).inflate(R.layout.custo_tab,null)
        tab2.tvBaslik.text= "tab 2"
        tab2.tvSayi.text= ""
        tLayout.getTabAt(1)?.setCustomView(tab2)
    }

    fun tabSec(index:Int){
        val ft=supportFragmentManager.beginTransaction()
        if(index==0){
            ft.replace(R.id.container,BlankFragment1())
        }else if (index==1){
            ft.replace(R.id.container,BlankFragment2())
        }
        ft.commit()
    }
}