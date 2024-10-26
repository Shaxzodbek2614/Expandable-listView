package com.example.expandablelistview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.expandablelistview.adapter.ExpandableListViewAdapter
import com.example.expandablelistview.databinding.ActivityMainBinding
import java.util.HashMap

class MainActivity : AppCompatActivity(),ExpandableListViewAdapter.RvAction{
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var expandableListViewAdapter: ExpandableListViewAdapter

    lateinit var titleList:ArrayList<String>
    lateinit var map:HashMap<String,ArrayList<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        loadData()

        expandableListViewAdapter = ExpandableListViewAdapter(titleList,map,this)
        binding.expandableListview.setAdapter(expandableListViewAdapter)

        binding.expandableListview.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(this, "Item bosildi", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun loadData(){
        titleList = ArrayList()
        map = HashMap()

        titleList.add("Android 19")
        titleList.add("Android 20")
        titleList.add("Android 22")
        titleList.add("Android 23")

        val list1 = arrayListOf("Alisher","MuhammadYusuf","Shavkatjon","Xojiakbar","Abdumajid","Ibroimjon")
        val list2 = arrayListOf("Iskandar","Muhammadodil","Yosir","Ahrorbek","Iqboljon")
        val list3 = arrayListOf("Habibulox","Biloliddin","Alisher","Xasanboy")
        val list4 = arrayListOf("Muhammadsolih","Abdulbosid","Asadbek","Muhammadumar","Saydullo")

        map[titleList[0]] = list1
        map[titleList[1]] = list2
        map[titleList[2]] = list3
        map[titleList[3]] = list4
    }

    override fun childItemClick(childPositionName: String) {

    }

    override fun parentItemClick(name: String) {
        TODO("Not yet implemented")
    }
}