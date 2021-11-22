package com.example.recycleviewer;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    private LayoutInflater mInflater;
    private LinkedList<String> title,description;
    public WordListAdapter(Context context,
                           LinkedList<String> title, LinkedList<String>description) {
        mInflater = LayoutInflater.from(context);
        this.title = title;
        this.description=description;
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        public final TextView titleItemView1;
        public final TextView descItemView1;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            titleItemView1 = itemView.findViewById(R.id.title);
            descItemView1 = itemView.findViewById(R.id.text);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(view.getContext(), MainActivity2.class);
                    break;

                case 1:
                    intent =  new Intent(view.getContext(), MainActivity3.class);
                    break;
                default:
                    intent =  new Intent(view.getContext(), MainActivity4.class);
                    break;
            }
            view.getContext().startActivity(intent);
        }
    }
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder( WordListAdapter.WordViewHolder holder, int position) {
        holder.titleItemView1.setText(title.get(position));
        holder.descItemView1.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }
}
