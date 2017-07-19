package com.zhuazhu.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhuazhu.image.ImageDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View view) {
        //单张图片
//        String url = "http://image.tianjimedia.com/uploadImages/2015/285/24/586K2UOWHG9D.jpg";
//        new ImageDialog(this,url).show();
        //多张图片
        List<String> list = new ArrayList<>();
        list.add("http://image.tianjimedia.com/uploadImages/2015/285/24/586K2UOWHG9D.jpg");
        list.add("http://image.l99.com/ad8/1437453022715_5swgd5.jpg");
        list.add("http://image.fvideo.cn/uploadfile/2015/05/25/img37533071189339.jpg");
        list.add("http://c.hiphotos.baidu" +
                ".com/image/pic/item/728da9773912b31ba27617218e18367adab4e1a4.jpg");
        list.add("http://image.tianjimedia.com/uploadImages/2015/227/37/SU4O4L7V51U5.jpg");
        new ImageDialog(this,list).show();
    }
}
