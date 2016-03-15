package com.tencent.qcloud.timchat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.TIMFriendGroup;
import com.tencent.qcloud.timchat.R;
import com.tencent.qcloud.timchat.ui.ManagerGroupActivity;

import java.util.List;

/**
 *
 */
public class GroupListAdapter extends BaseAdapter {
    private Context mContext;
    private List<TIMFriendGroup> mGroupList;
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private ManagerGroupActivity mManagerGroupActivity;
    public GroupListAdapter(Context context, List<TIMFriendGroup> grouplist,ManagerGroupActivity activity) {
        mContext = context;
        mGroupList = grouplist;
        mManagerGroupActivity = activity;
    }


    @Override
    public int getCount() {
        return mGroupList.size();
    }

    @Override
    public Object getItem(int i) {
        return mGroupList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int groupPosition, View convertView, ViewGroup viewGroup) {
        ItemHolder Holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_mylist, null);
            Holder = new ItemHolder();
            Holder.groupname = (TextView) convertView.findViewById(R.id.group_name);
            Holder.delete = (TextView) convertView.findViewById(R.id.delete_group);
            Holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mManagerGroupActivity.deleteGroup(groupPosition);
                    notifyDataSetChanged();
                }
            });
            convertView.setTag(Holder);
        } else {
            Holder = (ItemHolder) convertView.getTag();
        }
        Holder.groupname.setText(mGroupList.get(groupPosition).getGroupName());
//        Holder.img.setText(mGroupList.get(groupPosition).getName());
//        if (imageLoader != null)
//            imageLoader.displayImage(mGroupList.get(groupPosition).ge, Holder.img);
        return convertView;
    }

    class ItemHolder {
        public TextView groupname;
        public TextView delete;
    }

}