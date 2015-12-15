package com.miracle.learn_android.ui.views.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/*
本例来源于：(仅作为学习研究用)
http://www.ibm.com/developerworks/cn/opensource/os-cn-android-anmt1/index.html
Android 动画框架详解，第 1 部分
最原始来自于：ApiDemo
*/

/**
 * Created by gongzhuo on 15/12/15.
 */
public class Rotate3DAnimation extends Animation {
    private final float mFromDegrees;
    private final float mToDegrees;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final boolean mReverse;

    private Camera mCamera;

    public Rotate3DAnimation(float mFromDegrees, float mToDegrees, float mCenterX, float mCenterY, float mDepthZ, boolean mReverse) {
        this.mFromDegrees = mFromDegrees;
        this.mToDegrees = mToDegrees;
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mDepthZ = mDepthZ;
        this.mReverse = mReverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = mFromDegrees;
        float degrees = fromDegrees + (mToDegrees - mFromDegrees) * interpolatedTime;
        final float centerX = mCenterX;
        final float centerY = mCenterY;
        final Camera camera = mCamera;
        final Matrix matrix = t.getMatrix();
        camera.save();
        if(mReverse) {
            camera.translate(0.0f,0.0f,mDepthZ*interpolatedTime);
        } else {
            camera.translate(0.0f,0.0f,mDepthZ*(1.0f - interpolatedTime));
        }

        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
    }
}
