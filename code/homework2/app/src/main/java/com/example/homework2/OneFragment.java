package com.example.homework2;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ltj
 * @since 2021/7/15 12:10
 */
public class OneFragment extends Fragment {
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter ;
    List<News> mNewsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


        mRecyclerView =getView(). findViewById(R.id.recyclerview);

        // 构造一些数据
        mNewsList.add(new News("=> 皮卡丘","越是能制造出强大电流的皮卡丘，脸颊上的囊就越柔软，同时也越有伸展性。"));
        mNewsList.add(new News("=> 小火龙","天生喜欢热热的东西。据说当它被雨淋湿的时候，尾巴的末端会冒出烟来。"));
        mNewsList.add(new News("=> 妙蛙花","据说充足的营养和阳光会让花儿的颜色变得更加鲜艳。花香会治愈人心。"));
        mNewsList.add(new News("=> 杰尼龟","甲壳的作用不仅仅是用来保护自己。它圆润的外形和表面的沟槽会减小水的阻力，使它能快速地游动。"));
        mNewsList.add(new News("=> 巴大蝶","当它飞快地扑打翅膀，带有剧毒的鳞粉就会随着风向这里飘过来。"));
        mNewsList.add(new News("=> 比比鸟","会飞在空中巡视自己广阔的领地。要是有谁胆敢侵犯它的领地，它就会毫不留情地用利爪狠狠惩治一番。"));
        mNewsList.add(new News("=> 雷丘","长长的尾巴能够像接地线一样保护自己，因此即使是高压电也不会让它麻痹。"));
        mNewsList.add(new News("=> 小锯鳄","个子虽小但颚的力量很强。这力量强大到小锯鳄只是想轻轻咬一下，但却会让对方遭受重伤的程度。"));


        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(getContext(), R.layout.item_list, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            News news = mNewsList.get(position);
            holder.mTitleTv.setText(news.title);
            holder.mTitleContent.setText(news.content);
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView mTitleTv;
        TextView mTitleContent;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.textView);
            mTitleContent = itemView.findViewById(R.id.textView2);
        }
    }


}

