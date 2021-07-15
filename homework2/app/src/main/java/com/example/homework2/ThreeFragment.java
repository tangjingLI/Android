package com.example.homework2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author ltj
 * @since 2021/7/15 12:10
 */
public class ThreeFragment extends Fragment {
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        imageView = getView().findViewById(R.id.p2);
//        ObjectAnimator rotationX = ObjectAnimator.ofFloat(imageView, "rotation", 0.5f, 360f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 1);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0, 1);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000);
        animatorSet.play(alpha).with(scaleY).with(scaleX);
        animatorSet.start();
    }
}