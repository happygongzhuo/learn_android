package com.miracle.learn_android.ui.activity.Animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.miracle.learn_android.R;

/**
 * Created by gongzhuo on 15/12/15.
 */
public class TweenAnimation extends Activity implements View.OnClickListener {

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
        Log.i("vincent","TweenAnimation:=>"+this.getClass().getName());
        Log.i("vincent","TweenAnimation:=>"+this.getLocalClassName());
        Log.i("vincent", "TweenAnimation:=>" + this.getClass().getSimpleName());
        Log.i("vincent", "TweenAnimation:=>" + this.getClass().getCanonicalName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tween_animation);
        initView();
    }


    private void initView() {
        mBtnAlphaAnim = (Button)findViewById(R.id.btn_alpha_animation);
        mBtnRotateAnim = (Button)findViewById(R.id.btn_rotate_animation);
        mBtnScaleAnim = (Button)findViewById(R.id.btn_scale_animation);
        mBtnTranslateAnim = (Button)findViewById(R.id.btn_translate_animation);

        mIvAlpha = (ImageView)findViewById(R.id.iv_alpha);
        mIvRotate = (ImageView)findViewById(R.id.iv_rotate);
        mIvScale = (ImageView)findViewById(R.id.iv_scale);
        mIvTranslate = (ImageView)findViewById(R.id.iv_translate);

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
                Animation alphaAnimation = new AlphaAnimation(0.1f,1.0f);
                alphaAnimation.setDuration(2000);
                mIvAlpha.startAnimation(alphaAnimation);
                break;
            case R.id.btn_rotate_animation:
                mIvRotate.clearAnimation();
                //mIvRotate尺寸：100dp*45dp

                //默认以左上角为锚点旋转
                //Animation rotateAnimation = new RotateAnimation(0f,360f);

                //以中心点为锚点旋转:RELAVITE_TO_SELF：使用的是相对尺寸：百分比:
                //[0.0f,0.0f]：左上角
                //[0.0f,1.0f]：左上角
                //[1.0f,0.0f]：右上角
                //[1.0f,1.0f]：右下角
                //[0.5f,0.5f]：中心点
                //Animation rotateAnimation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


                //以右下角为锚点旋转：ABSOLUTE：使用的是绝对尺寸
                //Animation rotateAnimation = new RotateAnimation(0f,360f,Animation.ABSOLUTE,100.f,Animation.ABSOLUTE,45f);

                //RELATIVE_TO_PARENT：mIvRotate控件的左上角加上父容器的宽高分别乘以pivotX/pivotY的百分比，最后的到的坐标为锚点旋转
                Animation rotateAnimation = new RotateAnimation(0f,360f,Animation.RELATIVE_TO_PARENT,0f,Animation.RELATIVE_TO_PARENT,0f);
                rotateAnimation.setDuration(2000);
                mIvRotate.startAnimation(rotateAnimation);
                break;
            case R.id.btn_scale_animation:
                mIvScale.clearAnimation();
                Animation scaleAnimation = new ScaleAnimation(0f,1.0f,0f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setDuration(2000);
                mIvScale.startAnimation(scaleAnimation);
                break;
            case R.id.btn_translate_animation:
                Animation translateAnimation = new TranslateAnimation(0f,100f,0f,100f);
                translateAnimation.setDuration(2000);
                mIvTranslate.startAnimation(translateAnimation);
                break;
        }
    }
}

/*
备注：
1.AlphaAnimation/RotateAnimation/ScaleAnimation/TranslateAnimation这4个补间动画都是继承自Animation,
过覆写Animation的applyTransformation来实现对应的动画。
1.Animation.ABSOLUTE/Animation.RELATIVE_TO_SELF/Animation.RELATIVE_TO_PARENT这几种尺寸类型是通过Animation基类的方法：

    protected float resolveSize(int type, float value, int size, int parentSize) {
        switch (type) {
            case ABSOLUTE:
                return value;
            case RELATIVE_TO_SELF:
                return size * value;
            case RELATIVE_TO_PARENT:
                return parentSize * value;
            default:
                return value;
        }
    }

来计算对应的锚点的。从上面一目了然就可以知道含义了。
*/