package com.zhuazhu.image;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

/**
 * 创建时间:2017/5/25 18:29<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/5/25 18:29<br/>
 * 描述:展示图片,可放大缩小,图片切换查看
 * 如果使用setIndex方法,必须先show()之后,才能调该方法
 */

public class ImageDialog extends Dialog implements OnClickListener,OnPhotoTapListener,OnPageChangeListener {
    private String imgurl;
    /**
     * 单张图片使用
     * @param context
     * @param url
     */
    public ImageDialog(Context context, String url) {
        super(context, R.style.imagedialog_dialog);
        imgurl = url;
    }
    private List<String> mUrls = new ArrayList<>();
    private int url_length = 1;

    /**
     * 多张图片使用
     * @param context
     * @param urls
     */
    public ImageDialog(Context context, List<String> urls) {
        super(context, R.style.imagedialog_dialog);
        mUrls = urls;
        url_length = mUrls.size();

    }
    private String host = "";

    /**
     * 设置图片地址前缀
     * @param host
     */
    public void setHost(String host){
        if(isNotEmpty(host)){
            this.host = host;
        }
    }
    private ViewPager mViewPager;
    private TextView mIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_image);
		/*
         * 获取圣诞框的窗口对象及参数对象以修改对话框的布局设置,
         * 可以直接调用getWindow(),表示获得这个Activity的Window
         * 对象,这样这可以以同样的方式改变这个Activity的属性.
         */
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        PhotoDraweeView draweeView = (PhotoDraweeView) findViewById(R.id.img);
        ImageView close = (ImageView) findViewById(R.id.close);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mIndex = (TextView) findViewById(R.id.index);
        close.setOnClickListener(this);
        if(mUrls.size()>0){
            frameLayout.setVisibility(View.VISIBLE);
            draweeView.setVisibility(View.GONE);
            initViewPage();
        }else{
            frameLayout.setVisibility(View.GONE);
            draweeView.setVisibility(View.VISIBLE);
            if(isNotEmpty(host)){
                imgurl = host+imgurl;
            }
            Uri URI = Uri.parse(imgurl);
            draweeView.setPhotoUri(URI);
            draweeView.setOnPhotoTapListener(this);
        }
    }
    private void initViewPage(){
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mUrls.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoDraweeView v = new PhotoDraweeView(getContext());
                String url = mUrls.get(position);
                if(isNotEmpty(host)){
                    url = host+url;
                }
                Uri URI = Uri.parse(url);
                v.setPhotoUri(URI);
                ViewParent vp = v.getParent();
                if (vp!=null){
                    ViewGroup parent = (ViewGroup)vp;
                    parent.removeView(v);
                }
                container.addView(v);
                v.setOnPhotoTapListener(new OnPhotoTapListener() {
                    @Override
                    public void onPhotoTap(View view, float x, float y) {
                        cancel();
                    }
                });
                return v;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

            }
        });
        mViewPager.setCurrentItem(0);
        mIndex.setText("1/"+url_length);
        mViewPager.addOnPageChangeListener(this);
    }
    public void setIndex(int index){
        if(index>=url_length){
            return;
        }
        mViewPager.setCurrentItem(index);
    }
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public boolean isEmpty(String str) {
        boolean flag = true;
        flag = (str == null || "".equals(str.trim()));
        return flag;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    @Override
    public void onClick(View v) {
        cancel();
    }

    @Override
    public void onPhotoTap(View view, float x, float y) {
        cancel();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mIndex.setText((position+1)+"/"+url_length);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
