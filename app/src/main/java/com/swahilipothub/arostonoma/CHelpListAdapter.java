package com.swahilipothub.arostonoma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.swahilipothub.arostonoma.app.AppController;

import java.util.List;

/**
 * Created by Kevin Barassa on 03-Jan-17.
 */

public class CHelpListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<CHelp> helpItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CHelpListAdapter(Activity activity, List<CHelp> helpItems) {
        this.activity = activity;
        this.helpItems = helpItems;
    }

    @Override
    public int getCount() {
        return helpItems.size();
    }

    @Override
    public Object getItem(int location) {
        return helpItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.chelp_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView icon = (NetworkImageView) convertView
                .findViewById(R.id.help_image);
        TextView title = (TextView) convertView.findViewById(R.id.help_title);
        TextView desc = (TextView) convertView.findViewById(R.id.help_desc);

        // getting help data for the row
        CHelp help = helpItems.get(position);

        // Icon
        icon.setImageUrl(help.getIcon(), imageLoader);

        // Help title
        title.setText(help.getTitle());

        // help details
        desc.setText(help.getDetails());

        return convertView;
    }
}
