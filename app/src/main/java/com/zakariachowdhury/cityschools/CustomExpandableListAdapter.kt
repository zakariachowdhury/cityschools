package com.zakariachowdhury.cityschools

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView


class CustomExpandableListAdapter(
    context: Context, expandableListTitle: List<String>,
    expandableListDetail: HashMap<String, ArrayList<String>>
) : BaseExpandableListAdapter() {
    private val context: Context
    private val expandableListTitle: List<String>
    private val expandableListDetail: HashMap<String, ArrayList<String>>
    override fun getChild(listPosition: Int, expandedListPosition: Int): String? {
        return expandableListDetail[expandableListTitle[listPosition]]
            ?.get(expandedListPosition)
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView: View? = convertView
        val expandedListText =
            getChild(listPosition, expandedListPosition) as String
        if (convertView == null) {
            val layoutInflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_item, null)
        }
        val expandedListTextView = convertView
            ?.findViewById(R.id.expandedListItem) as TextView
        expandedListTextView.text = expandedListText
        return convertView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        if (expandableListDetail[expandableListTitle[listPosition]] != null) {
            return expandableListDetail[expandableListTitle[listPosition]]!!.size
        }
        return 0
    }

    override fun getGroup(listPosition: Int): Any {
        return expandableListTitle[listPosition]
    }

    override fun getGroupCount(): Int {
        return expandableListTitle.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup?
    ): View? {
        var convertView: View? = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.list_group, null)
        }
        val listTitleTextView = convertView
            ?.findViewById(R.id.listTitle) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(
        listPosition: Int,
        expandedListPosition: Int
    ): Boolean {
        return true
    }

    init {
        this.context = context
        this.expandableListTitle = expandableListTitle
        this.expandableListDetail = expandableListDetail
    }
}