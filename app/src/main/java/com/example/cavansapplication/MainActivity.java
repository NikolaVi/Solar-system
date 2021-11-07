package com.example.cavansapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Timer timer;
    Canvas canvas;
    Paint paint, paint1, paint2, paint3, paint4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = Bitmap.createBitmap(1000, 1500, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#EBEBEB"));
        canvas = new Canvas();
        canvas.setBitmap(bitmap);

        paint = new Paint();
        paint1 = new Paint();
        paint2 = new Paint();
        paint3 = new Paint();
        paint4 = new Paint();

        paint.setColor(Color.YELLOW);
        paint1.setColor(Color.RED);
        paint2.setColor(Color.BLUE);
        paint3.setColor(Color.GREEN);
        paint4.setColor(Color.GRAY);


        canvas.drawCircle(500f, 750f, 130, paint);
        canvas.drawCircle(400f, 560f, 51, paint1);
        canvas.drawCircle(750f, 920f, 48, paint2);
        canvas.drawCircle(300f, 1100f, 45, paint3);
        canvas.drawCircle(320f, 300f, 42, paint4);


        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                animationFrame();

                            }
                        }
                );
            }
        }, 3000, 80);


    }

    private void animationFrame() {

        canvas.drawColor(Color.parseColor("#EBEBEB"));

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(500f, 750f, 130f, paint);


        if (paint1 != null | paint3 != null) {
            paint1.setColor(Color.RED);
            canvas.drawCircle(400f, 560f, 51f, paint1);
            canvas.rotate(10f, 500f, 750f);

            paint3.setColor(Color.GREEN);
            canvas.drawCircle(350f, 1050f, 45, paint3);
            canvas.rotate(30f, 500f, 750f);
        }
        if (paint2 != null | paint4 != null) {
            paint2.setColor(Color.BLUE);
            canvas.drawCircle(720f, 950f, 48, paint2);
            canvas.rotate(-10f, 500f, 750f);

            paint4.setColor(Color.GRAY);
            canvas.drawCircle(290f, 330f, 42, paint4);
            canvas.rotate(-25f, 500f, 750f);
        }


        imageView.invalidate();
    }


}
