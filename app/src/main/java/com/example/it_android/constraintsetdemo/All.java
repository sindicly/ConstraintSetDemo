package com.example.it_android.constraintsetdemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class All extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_right_move);
        constraintLayout = findViewById(R.id.constraintLayout);
        //constraintLayout里面控件必须要有id，否则applyConstraintSet.clone(constraintLayout)方法报错
        applyConstraintSet.clone(constraintLayout);
        resetConstraintSet.clone(this, R.layout.move);
    }

    public void applyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);//添加动画移动轨迹
        applyConstraintSet.applyTo(constraintLayout);//应用于
    }

    public void resetClick(View view) {

        TransitionManager.beginDelayedTransition(constraintLayout);//添加动画移动轨迹
        resetConstraintSet.applyTo(constraintLayout);
    }
}
