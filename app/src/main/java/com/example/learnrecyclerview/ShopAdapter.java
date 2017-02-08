package com.example.learnrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nguyen.van.thieub on 2/8/17.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataShops.get(position).getTen());
        holder.imgHinh.setImageResource(dataShops.get(position).getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    public void RemoveItem(int position) {
        dataShops.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgHinh;

        public ViewHolder(final View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgHinh = (ImageView) itemView.findViewById(R.id.imgHinh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove " + txtName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
