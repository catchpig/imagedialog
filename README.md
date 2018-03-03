# imagedialog
[![Release](https://jitpack.io/v/zhuazhu/imagedialog.svg)](https://jitpack.io/#zhuazhu/imagedialog)

图片展示控件(放大缩小)

## 第三方库
[PhotoView](https://github.com/chrisbanes/PhotoView)
```
控件放大缩小控件
```

## Gradle
在Project的build.gradle中添加:
   ```
   allprojects {
    	repositories {
    		maven { url 'https://jitpack.io' }
    	}
    }
   ```
添加依赖:
```
implementation 'com.github.zhuazhu:imagedialog:last_version'
```

## 单张图片显示
```
//图片地址
String url = "http://img0.imgtn.bdimg.com/it/u=108724125,966706653&fm=26&gp=0.jpg";
new ImageDialog(this,url).show();
```

## 多张图片显示
```
List<String> list = new ArrayList<>();
list.add("http://image.tianjimedia.com/uploadImages/2015/285/24/586K2UOWHG9D.jpg");
list.add("http://image.l99.com/ad8/1437453022715_5swgd5.jpg");
list.add("http://image.fvideo.cn/uploadfile/2015/05/25/img37533071189339.jpg");
list.add("http://c.hiphotos.baidu.com/image/pic/item/728da9773912b31ba27617218e18367adab4e1a4.jpg");
list.add("http://image.tianjimedia.com/uploadImages/2015/227/37/SU4O4L7V51U5.jpg");
new ImageDialog(this,list).show();
```
## 构造方法
1.ImageDialog(Context context, String url)

设置单张图片

2.ImageDialog(Context context, String... urls)

数组设置多张图片

3.ImageDialog(Context context, List<String> urls)

集合设置多张图片

## 方法说明
|方法|描述|
|:--|:--|
|show()|展示图片|
|setIndex(int index)|设置当前展示图片,该方法必须在show()之后调用|
|setImageLoader(ImageLoader imageLoader)|设置图片加载处理器,该方法必须在show()之前调用|

## 代码参考
1.实现ImageLoader接口,选择需要加载图片的第三方库(Glide,Picasso...)如下代码使用的是Glide
```
    public class GlideImageLoader implements ImagePagerAdapter.ImageLoader {
        @Override
        public void displayImage(ImageView imageView, String path) {
            Glide.with(imageView.getContext()).load(path).into(imageView);
        }
    }
```