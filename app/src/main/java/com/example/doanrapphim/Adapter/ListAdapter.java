package com.example.doanrapphim.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.doanrapphim.R;
import com.example.doanrapphim.Activity_ChiTiet.Group;
import com.example.doanrapphim.Activity_ChiTiet.Item;

import java.util.List;
import java.util.Map;

public class ListAdapter extends BaseExpandableListAdapter {
    private List<Group> listgroup;
    private Map<Group, List<Item>> listitem;

    public ListAdapter(List<Group> listgroup, Map<Group, List<Item>> listitem) {
        this.listgroup = listgroup;
        this.listitem = listitem;
    }

    @Override
    public int getGroupCount() {
        if (listgroup != null)
            return listgroup.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (listitem != null && listgroup != null)
            return listitem.get(listgroup.get(groupPosition)).size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listgroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listitem.get(listgroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        Group g = listgroup.get(groupPosition);
        return  g.getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return  0;

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_group, parent, false);
        }
        TextView tvGroup = convertView.findViewById(R.id.tv);
        Group groupitem = listgroup.get(groupPosition);
        tvGroup.setText(groupitem.getName().toUpperCase());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        }
        TextView tvItem = convertView.findViewById(R.id.tvitem);
        Item ltitem = listitem.get(listgroup.get(groupPosition)).get(childPosition);
        tvItem.setText(ltitem.getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
