package com.example.it_android.constraintsetdemo;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void leftAndRight(View view) {
        jumUI(LeftAndRightMove.class);
    }


    public void transtition(View view) {
        jumUI(TransitionMove.class);
    }


    public void horizontal(View view) {
        jumUI(HorizonallyMove.class);

    }

    public void centerClick(View view) {
        jumUI(CenterMove.class);
    }

    private void jumUI(Class cla) {
        Intent intent = new Intent(MainActivity.this, cla);
        startActivity(intent);
    }


    public void extendClick(View view) {
        jumUI(ExtendMove.class);
    }//扩大600

    public void fullScreen(View view) {//充满屏幕
        jumUI(FullScreenMove.class);
    }

    public void exitAndDisappear(View view) {//退出消失
        jumUI(ExitActivity.class);
    }

    public void all(View view) {//退出消失
        jumUI(All.class);
    }
}
