package com.vituniversity.hackathon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vituniversity.hackathon.Data.Blogs;

import java.util.ArrayList;

/**
 * Created by SHAAN on 14-04-17.
 */
public class RecyclerAdapter extends android.support.v7.widget.RecyclerView
        .Adapter<RecyclerAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Blogs> blogs = new ArrayList<>();
    int count = 0;

    public RecyclerAdapter(ArrayList<Blogs> blogs, Context baseContext) {
        this.blogs = blogs;
        this.context = baseContext;
    }

    public void addBlogs(Blogs Blog, int blog) {
        blogs.add(blog, null);
    }
//    blogs[0] = new Blogs("Title", "#hashtags", "FREE", 0.00f, "this is a sample blog", "14 " +
//            "Apr 2017", "3:33pm");

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public TextView tvTitle;
        public TextView tvAuthor;
        public TextView tvFreePaid;
        public TextView tvDesc;
        public TextView tvViewers;
        public TextView tvDate;
        public TextView tvTime;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
            tvFreePaid = (TextView) itemView.findViewById(R.id.tvFreePaid);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            tvViewers = (TextView) itemView.findViewById(R.id.tvViewers);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }

    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (viewHolder.tvTitle != null)
            viewHolder.tvTitle.setText(blogs.get(position).getTitle());
        if (viewHolder.tvAuthor != null)
            viewHolder.tvAuthor.setText(blogs.get(position).getAuthor());
        if (viewHolder.tvFreePaid != null) {
            String paymentType = blogs.get(position).getPaymentType();
            if (paymentType.equalsIgnoreCase("FREE"))
                viewHolder.tvFreePaid.setBackground(context.getResources().getDrawable(R.drawable
                        .free_bg));
            else
                viewHolder.tvFreePaid.setBackground(context.getResources().getDrawable(R.drawable
                        .paid_bg));
        }
        if (viewHolder.tvDesc != null)
            viewHolder.tvDesc.setText(blogs.get(position).getDesc());
        if (viewHolder.tvDate != null)
            viewHolder.tvDate.setText(blogs.get(position).getDate());
        if (viewHolder.tvTime != null)
            viewHolder.tvTime.setText(blogs.get(position).getTime());
        if (viewHolder.tvViewers != null)
            viewHolder.tvViewers.setText(blogs.get(position).getViewers());
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_card, parent,
                false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }
}