package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by Dias Aziz on 15/05/2016.
 */
public final class Intro extends AppIntro2 {

    @Override
    public void init(@Nullable Bundle savedInstanceState) {

        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro2_2));
        addSlide(SampleSlide.newInstance(R.layout.intro3_2));
        setFadeAnimation();
    }



    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Intro.this.finish();
    }

    @Override
    public void onSlideChanged() {

    }
}
