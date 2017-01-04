package com.swahilipothub.arostonoma;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionViewHolders> {

    private List<SectionFragObject> itemList;
    private Context context;

    public SectionAdapter(Context context, List<SectionFragObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SectionViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        SectionViewHolders rcv = new SectionViewHolders(layoutView,context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SectionViewHolders holder, int position) {
        holder.sectionName.setText(itemList.get(position).getName());
        holder.sectionIcon.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
