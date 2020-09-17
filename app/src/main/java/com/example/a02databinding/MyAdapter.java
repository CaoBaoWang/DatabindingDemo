package com.example.a02databinding;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a02databinding.databinding.LayoutFragmentBlankItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter{
    private  Activity context;
    List<Item> list;

    public MyAdapter (List list, Activity context) {
        this.list= list;
        this.context = context;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutFragmentBlankItemBinding binding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.layout_fragment_blank_item, parent, false);


        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LayoutFragmentBlankItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
//        assert binding != null;
        binding.setItem(list.get(position));
        binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }





    class Holder extends RecyclerView.ViewHolder {



        public Holder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    list.get(position).setI(222);
                    notifyDataSetChanged();

                }
            });
        }

    }

}
