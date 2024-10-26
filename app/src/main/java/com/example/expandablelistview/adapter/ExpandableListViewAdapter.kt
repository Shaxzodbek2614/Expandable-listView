package com.example.expandablelistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListAdapter
import com.example.expandablelistview.databinding.ItemChildBinding
import com.example.expandablelistview.databinding.ItemParentBinding
import java.util.HashMap

class ExpandableListViewAdapter(val titleList:ArrayList<String>,val map:HashMap<String,java.util.ArrayList<String>>,val rvAction: RvAction):BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return titleList.size
    }


    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }


    override fun getGroup(groupPosition: Int): Any {
        return  titleList[groupPosition]
    }


    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }


    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }


    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }


    override fun hasStableIds(): Boolean {
        return false
    }


    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemParent = ItemParentBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        itemParent.name.text = titleList[groupPosition]

        return itemParent.root
    }


    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childItem = ItemChildBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
        childItem.childName.text = map[titleList[groupPosition]]?.get(childPosition)

        childItem.root.setOnClickListener {
            rvAction.childItemClick(map[titleList[groupPosition]]!!.get(childPosition))
        }
        return childItem.root
    }


    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    interface RvAction{
        fun childItemClick(childPositionName:String)
        fun parentItemClick(name:String)
    }
}