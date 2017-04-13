package com.example.administrator.adapterdemo.commonadcpter.animation;

import android.animation.Animator;
import android.view.View;

/**
 * 基本动画
 */
public interface  BaseAnimation {

    Animator[] getAnimators(View view);

}
