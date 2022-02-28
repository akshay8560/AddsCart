package com.as2developers.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.as2developers.myapplication.Adapters.ViewPagerAdapter;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dots_layout;
    ViewPagerAdapter adapter;
    Button getStartedbtn,skipbtn;
    TextView[] dots;

    Animation sideAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);


        //hooks
        viewPager = findViewById(R.id.viewpager);
        dots_layout = findViewById(R.id.dots);
        getStartedbtn = findViewById(R.id.getStarted_btn);
        skipbtn = findViewById(R.id.skip_btn);
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_animation);
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingScreen.this,Login_Phone.class));
                finish();
            }
        });

        getStartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingScreen.this,Login_Phone.class));
                finish();
            }
        });
        displaydots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void displaydots(int position){
        dots = new TextView[4];
        dots_layout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);

            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dots_layout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.green));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            displaydots(position);
            if(position==3){
                getStartedbtn.setVisibility(View.VISIBLE);
                getStartedbtn.setAnimation(sideAnim);
            }
            else{
                getStartedbtn.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}