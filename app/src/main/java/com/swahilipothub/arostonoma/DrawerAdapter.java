package com.swahilipothub.arostonoma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kevin Barassa on 04-Jan-17.
 */

public class DrawerAdapter extends ArrayAdapter<DrawerItem> {
    Context mContext;
    int resourceId;
    ArrayList<DrawerItem> data = new ArrayList<DrawerItem>();

    public DrawerAdapter(Context context, int layoutResourceId, ArrayList<DrawerItem> data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new ViewHolder();
            holder.imgItem = (ImageView) itemView.findViewById(R.id.image_icon);
            holder.txtItem = (TextView) itemView.findViewById(R.id.detail_name);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        DrawerItem item = getItem(position);
        holder.imgItem.setImageDrawable(item.getImage());
        holder.txtItem.setText(item.getTitle());

        return itemView;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtItem;
    }

}
