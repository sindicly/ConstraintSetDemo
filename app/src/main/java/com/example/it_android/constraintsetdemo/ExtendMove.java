package com.example.it_android.constraintsetdemo;

import android.os.Bundle;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ExtendMove extends AppCompatActivity {
    /*宽度变长600*/
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
        resetConstraintSet.clone(constraintLayout);
    }

    public void applyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);//添加动画移动轨迹

        applyConstraintSet.constrainWidth(R.id.btn1,600);
        applyConstraintSet.constrainWidth(R.id.btn2,600);
        applyConstraintSet.constrainWidth(R.id.btn3,600);

        applyConstraintSet.applyTo(constraintLayout);

    }

    public void resetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
