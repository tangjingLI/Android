package com.example.homework2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author ltj
 * @since 2021/7/15 12:10
 */
public class TwoFragment extends Fragment {
//    private ImageView imageView;
    private TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        imageView = getView().findViewById(R.id.p1);
//        ObjectAnimator.ofFloat(imageView, "translationX", 800).setDuration(10000).start();
        textView=getView().findViewById(R.id.text1);
        textView.setBackgroundResource(R.drawable.frame2);
        AnimationDrawable animationDrawable = (AnimationDrawable) textView.getBackground();
        animationDrawable.start();
    }
}
