package com.miracle.learn_android.ui.activity.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.miracle.learn_android.R;

/**
 * Created by gongzhuo on 15/12/15.
 */
public class TweenAnimationLoadFile extends Activity implements View.OnClickListener {

    private Button mBtnAlphaAnim;
    private Button mBtnRotateAnim;
    private Button mBtnScaleAnim;
    private Button mBtnTranslateAnim;

    private ImageView mIvAlpha;
    private ImageView mIvRotate;
    private ImageView mIvScale;
    private ImageView mIvTranslate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tween_animation);
        initView();
    }


    private void initView() {
        mBtnAlphaAnim = (Button) findViewById(R.id.btn_alpha_animation);
        mBtnRotateAnim = (Button) findViewById(R.id.btn_rotate_animation);
        mBtnScaleAnim = (Button) findViewById(R.id.btn_scale_animation);
        mBtnTranslateAnim = (Button) findViewById(R.id.btn_translate_animation);

        mIvAlpha = (ImageView) findViewById(R.id.iv_alpha);
        mIvRotate = (ImageView) findViewById(R.id.iv_rotate);
        mIvScale = (ImageView) findViewById(R.id.iv_scale);
        mIvTranslate = (ImageView) findViewById(R.id.iv_translate);

        mBtnAlphaAnim.setOnClickListener(this);
        mBtnRotateAnim.setOnClickListener(this);
        mBtnScaleAnim.setOnClickListener(this);
        mBtnTranslateAnim.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha_animation:
                mIvAlpha.clearAnimation();
                Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(2000);
                mIvAlpha.startAnimation(alphaAnimation);
                break;
            case R.id.btn_rotate_animation:
                mIvRotate.clearAnimation();
                Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
                mIvRotate.startAnimation(rotateAnimation);
                break;
            case R.id.btn_scale_animation:
                mIvScale.clearAnimation();
                Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
                mIvScale.startAnimation(scaleAnimation);
                break;
            case R.id.btn_translate_animation:
                Animation translateAnimation = new TranslateAnimation(0f, 100f, 0f, 100f);
                translateAnimation.setDuration(2000);
                mIvTranslate.startAnimation(translateAnimation);
                break;
        }
    }
}

/*
备注：
1 pivotX/pivotY中：
50:表示绝对尺寸，业也即Animation.ABSOLUTE
50%：表示相对于控件自身，也即Animation.RELATIVE_TO_SELF
50%p：标识相对于父控件，也即Animation.RELATIVE_TO_PARENT

2 fillBefore/fillAfter:
fillBefore：动画结束的时候，画面停留在第一帧；
fillAfter：动画结束的时候，画面停留在最后一帧；

*/