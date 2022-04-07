package com.wimonsiri.animalsounds;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        OnClickListener
{
    private int resBtns[] = {
            R.id.imageButton1, R.id.imageButton2, R.id.imageButton3,
            R.id.imageButton4, R.id.imageButton5, R.id.imageButton6 };
    private int resImages[] = {
            R.drawable.bird, R.drawable.cat, R.drawable.cow,
            R.drawable.dog, R.drawable.elephant, R.drawable.horse };
    private int resSounds[] = { R.raw.bird, R.raw.cat, R.raw.cow,
            R.raw.dog,R.raw.elephant, R.raw.horse,};
    private MediaPlayer mPlayer[];
    ImageButton imgBtns[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int size = resBtns.length;
        imgBtns = new ImageButton[size];
        mPlayer = new MediaPlayer[size];
        for(int n = 0; n < imgBtns.length ; n++) {
            imgBtns[n] = (ImageButton) findViewById(resBtns[n]);
            imgBtns[n].setOnClickListener(this);
            mPlayer[n] = MediaPlayer.create(this,resSounds[n]);
        }
    }
    @Override
    public void onClick(View v) {
        int id = checkId(v.getId());
        mPlayer[id].start();
    }
    private int checkId(int id) {
        int result = 0;
        for (int n = 0; n < resBtns.length; n++) {
            if (id == resBtns[n]) {
                result = n;
                break;
            }
        }
        return(result);
    }
}