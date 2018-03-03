package com.zhuazhu.wedgit;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 创建时间:2017/12/20 18:13<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/12/20 18:13<br/>
 * 描述:ViewPager和PhotoView共用是,解决放大缩小问题的封装
 */

public class MultipleTouchViewPager extends ViewPager {
    public MultipleTouchViewPager(Context context) {
        super(context);
    }

    public MultipleTouchViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重写onTouchEvent和onInterceptTouchEvent,
     * 解决放大缩小的问题,
     * java.lang.IllegalArgumentException: pointerIndex out of range pointerIndex=-1 pointerCount=1
     */

    //    @Override
    //    public boolean onTouchEvent(MotionEvent ev) {
    //        try {
    //            return super.onTouchEvent(ev);
    //        } catch (IllegalArgumentException ex) {
    //            ex.printStackTrace();
    //        }
    //        return false;
    //    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
