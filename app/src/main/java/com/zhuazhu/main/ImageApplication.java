package com.zhuazhu.main;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * 创建时间:2017/7/19 15:33<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/7/19 15:33<br/>
 * 描述:
 */

public class ImageApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFresco();
    }
    /**
     * 初始化图片加载
     */
    private void initFresco(){
        DiskCacheConfig config = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(getExternalFilesDir("fresco"))
                .build();
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(config)
                .setDownsampleEnabled(true)
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .build();
        Fresco.initialize(this,pipelineConfig);
    }
}
