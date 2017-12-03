# imagedialog
[ ![Download](https://api.bintray.com/packages/zhu/maven/imagedialog/images/download.svg) ](https://bintray.com/zhu/maven/imagedialog/_latestVersion)

图片展示控件(放大缩小)
## 第三方库
[fresco](https://github.com/facebook/fresco)
```
facebook第三方图片加载库:fresco
该库需要在Application中初始化,详见fresco的链接地址
```
[photodraweeview](https://github.com/ongakuer/PhotoDraweeView)
```
控件放大缩小控件:photodraweeview
```

## Gradle
```
dependencies {
    compile ('com.zhuazhu.image:library:0.1.5',{
            exclude group: 'com.android.support'
            //如果项目中已经用到了,需要排除
            exclude group: 'com.facebook.fresco'
            //如果项目中已经用到了,需要排除
            exclude group: 'me.relex'
    })
}
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

## 方法说明
```
设置图片访问地址的前缀:
    setHost(String host)
如:
    String host = "http://image.tianjimedia.com";
    ImageDialog dialog = new ImageDialog(this,"/uploadImages/2015/285/24/586K2UOWHG9D.jpg");
    dialog.setHost(host);
    dialog.show();
```
