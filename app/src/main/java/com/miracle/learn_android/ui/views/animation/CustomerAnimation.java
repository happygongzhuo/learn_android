package com.miracle.learn_android.ui.views.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by gongzhuo on 15/12/15.
 */
public class CustomerAnimation  extends Animation {
    private int mWaveTimes = 5;
    private int mWaveRange = 50;
    public CustomerAnimation() {
    }

    public CustomerAnimation(int mWaveTimes, int mWaveRange) {
        this.mWaveTimes = mWaveTimes;
        this.mWaveRange = mWaveRange;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Log.i("vincent", "time=" + interpolatedTime);
        t.getMatrix().setTranslate((int)(Math.sin(interpolatedTime*Math.PI * mWaveTimes)*mWaveRange),0);
    }
}
