package com.shenzhen.futian.gesturedetectorimooc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView ivImg;

    private GestureDetector mDetector;

    class mGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e1.getX() - e2.getX() > 50) {
                Toast.makeText(MainActivity.this, "往左滑动了！", Toast.LENGTH_SHORT).show();
            } else if (e2.getX() - e1.getX() > 50) {
                Toast.makeText(MainActivity.this, "往右滑动了！", Toast.LENGTH_SHORT).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImg = (ImageView) findViewById(R.id.ivImg);
        mDetector = new GestureDetector(new mGestureListener());
        ivImg.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mDetector.onTouchEvent(event);
        return true;
    }
}
