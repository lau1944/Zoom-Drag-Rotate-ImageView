# Zoom-Drag-Rotate-ImageView
Zoom, Drag &amp; Rotate ImageView （可拉伸，托拉和旋转的imageview)

## What Is This (这是什么东西？）

It is called **RotateImageview** extends from ImageView,

it has multiple **gestures**
,you can get the same ImageView features as well .  


这是一个多功能ImageView，

能够实现多样的手势控制

## Demo here  
<p align="center">
  <img  src="https://github.com/lau1944/Zoom-Drag-Rotate-ImageView/blob/branch/demo.gif" />
</p>

## How To Use  （如何使用）
- **Step 1**. Add the JitPack repository to your build file

     Add it in your root build.gradle at the end of repositories:
     
     (将jitpack加入到build.gradle，如下所示）
     
     
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

- **Step 2**. Add the dependency

     （加入SDK套件)

```java
dependencies {
	        implementation 'com.github.lau1944:Zoom-Drag-Rotate-ImageView:currentversion'
	}
```

<img src="https://github.com/lau1944/Zoom-Drag-Rotate-ImageView/blob/branch/jitpack.svg">

- **Step 3**. Add Image (添加图片）
    
  **You can add it on XML file**  （在xml上直接加入）
    
```xml
   <com.easystudio.rotateimageview.RotateZoomImageView
        android:id="@+id/rotate"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:src="@drawable/money"/>
```
 **Or add image programmatically**  （或者用java上加入）
 
```java
            RotateZoomImageView iv;
            RelativeLayout playground = findViewById(R.id.playground);
            iv = new RotateZoomImageView(getApplicationContext());
            iv.setImageDrawable(getDrawable(R.drawable.money));
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(250, 250);
            lp.addRule(RelativeLayout.BELOW);
            iv.setLayoutParams(lp);
            playground.addView(iv);
 ```
 
- **Final Step**. Add OnTouch Method  （再加入如下监听事件）
 
```java
      iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return iv.onTouch(v,event);
            }
        });
```






## 赏我一杯咖啡呗
```diff
+ Donate with wechat
```
<img src="https://github.com/lau1944/Promotion-App/blob/master/wechat.png" alt="Donate with wechat" width="200"/>
