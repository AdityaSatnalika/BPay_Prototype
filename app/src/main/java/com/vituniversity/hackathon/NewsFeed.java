package com.vituniversity.hackathon;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.vituniversity.hackathon.Data.Blogs;

import java.util.ArrayList;

public class NewsFeed extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    //Blogs blogs[] = new Blogs[10];
    ArrayList<Blogs> blogs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        boolean fabEnabled = getIntent().getBooleanExtra("fabEnabled", false);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fabEnabled) {
            fab.setVisibility(View.VISIBLE);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), NewBlog.class);
                    startActivity(intent);
                }
            });
        } else {
            fab.setVisibility(View.GONE);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getBaseContext(), recyclerView, new RecyclerItemClickListener
                        .OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                        Toast.makeText(getBaseContext(), blogs.get(position).getTitle() + "is " +
                                "clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getBaseContext(), ViewBlog.class);
                        boolean isPaid;
                        if (blogs.get(position).getPaymentType().equalsIgnoreCase("PAID"))
                            isPaid = true;
                        else
                            isPaid = false;
                        intent.putExtra("isPaid", isPaid);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        blogs.add(new Blogs("Excitement", "Shantanu", "#Sporty", "FREE", 0.00f, "This is the body " +
                "of my blog", "This is the Desc", "14 Apr 2017", "8:00 pm"));
        blogs.add(new Blogs("Erotica", "Anshul", "#jaldibol, #nahibhai", "PAID", 2.00f, "This is " +
                "the body of my blog", "This is the Desc", "2 Mar 2017", "7:10 am"));
        blogs.add(new Blogs("Hackathon", "Aditya", "#C2C", "FREE", 0.00f, "This is the body " +
                "of my blog", "This is the Desc", "14 Apr 2017", "8:00 pm"));
        adapter = new RecyclerAdapter(blogs, getBaseContext());
        recyclerView.setAdapter(adapter);

    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);

            public void onLongItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
