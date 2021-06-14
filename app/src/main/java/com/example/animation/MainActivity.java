package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import static android.view.animation.Animation.INFINITE;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private Button stop;
    //private VelocityTracker vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.anim.property_animator);
        set.setTarget(findViewById(R.id.PG));
        set.start();*/
        /*if(vt == null)
            vt = VelocityTracker.obtain();*/
        final View img = findViewById(R.id.PG);
        // Setting up a spring animation to animate the view’s translationY property with the final
        // spring position at 0.
        //final SpringAnimation springAnim = new SpringAnimation(img, DynamicAnimation.TRANSLATION_Y,1000);
        start = findViewById(R.id.butto_start);
        stop = findViewById(R.id.butto_stop);
        /*vt.computeCurrentVelocity(1);
        float velocity = vt.getYVelocity();
        springAnim.setStartVelocity(velocity);*/

        ObjectAnimator animation = ObjectAnimator.ofFloat(img, "translationY", 1000f);
        animation.setDuration(5000);
        //animation.reverse();
        animation.setRepeatCount(INFINITE);
        animation.setRepeatMode(ObjectAnimator.RESTART);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //springAnim.start();
                if(animation.isPaused())
                {
                    animation.resume();
                }
                else
                {
                    animation.start();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.pause();
            }
        });
        //springAnim.addUpdateListener()
    }
}