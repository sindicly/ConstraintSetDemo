package com.example.it_android.constraintsetdemo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FullScreenMove extends AppCompatActivity {
    /*充满屏幕*/
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

    /*setVisibility:我觉得这个很简单。
    clear: 我想要把 view 上的所有 constraint 都清除掉。
    connect: 我想要 view 上添加 constraint。这个方法需要5个参数。
    第一个:我想要在上面添加 constraint 的 view。
    第二个：我准备添加的 constraint 的边缘状态。
    第三个：constraint 的第一个 view，它被用来作为我的锚点。
    第四个：我的锚点 view 的边缘状态。
    第五：外边距。
    */
    public void applyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);//添加动画移动轨迹

        applyConstraintSet.setVisibility(R.id.btn2, ConstraintSet.GONE);
        applyConstraintSet.setVisibility(R.id.btn1, ConstraintSet.GONE);
        applyConstraintSet.clear(R.id.btn3);//把view上的所有 constraint 都清除掉。

        applyConstraintSet.connect(R.id.btn3, ConstraintSet.LEFT, R.id.constraintLayout, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.btn3, ConstraintSet.RIGHT, R.id.constraintLayout, ConstraintSet.RIGHT, 0);
        applyConstraintSet.connect(R.id.btn3, ConstraintSet.TOP, R.id.constraintLayout, ConstraintSet.TOP, 0);
        applyConstraintSet.connect(R.id.btn3, ConstraintSet.BOTTOM, R.id.constraintLayout, ConstraintSet.BOTTOM, 0);

        applyConstraintSet.applyTo(constraintLayout);//应用于
    }

    public void resetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
