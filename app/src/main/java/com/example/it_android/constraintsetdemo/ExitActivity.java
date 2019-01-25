package com.example.it_android.constraintsetdemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ExitActivity extends AppCompatActivity {
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

        /*处理位置出现水平居中动画时，偏移的问题*/
        applyConstraintSet.clear(R.id.btn1);
        applyConstraintSet.clear(R.id.btn2);
        applyConstraintSet.clear(R.id.btn3);

        applyConstraintSet.connect(R.id.btn1, ConstraintSet.LEFT, R.id.constraintLayout, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.btn2, ConstraintSet.RIGHT, R.id.constraintLayout, ConstraintSet.RIGHT, 0);

        applyConstraintSet.connect(R.id.btn3, ConstraintSet.LEFT, R.id.btn1, ConstraintSet.RIGHT, 0);
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.RIGHT, R.id.btn3, ConstraintSet.LEFT, 0);

        applyConstraintSet.connect(R.id.btn3, ConstraintSet.RIGHT, R.id.btn2, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.btn2, ConstraintSet.LEFT, R.id.btn3, ConstraintSet.RIGHT, 0);


        /*第一个：头部 view 的 id。
         第二个：chain 里尾部 view 的 id。
         第三个：int 数组，把头部和尾部 view 的 id 放入 int 数组。
         第四个：float 数组，如果我们需要权重的 chaining 的话它可以给我们权重，否则的话为空。
         第五个：chaining 的风格，类似 CHAIN_SPREAD。
         */

        applyConstraintSet.createHorizontalChain(R.id.btn1, ConstraintSet.LEFT,
                R.id.btn2, ConstraintSet.RIGHT, new int[]{R.id.btn1, R.id.btn2},
                null, ConstraintWidget.CHAIN_SPREAD);

        applyConstraintSet.constrainWidth(R.id.btn1, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainWidth(R.id.btn2, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainWidth(R.id.btn3, ConstraintSet.WRAP_CONTENT);

        applyConstraintSet.constrainHeight(R.id.btn1, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.btn2, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.constrainHeight(R.id.btn3, ConstraintSet.WRAP_CONTENT);
        applyConstraintSet.applyTo(constraintLayout);

    }

    public void resetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
