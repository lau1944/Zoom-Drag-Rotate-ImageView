# Zoom-Drag-Rotate-ImageView
Zoom, Drag &amp; Rotate ImageView （可拉伸，托拉和旋转的imageview)

## What Is This

It is called **RotateImageview** extends from ImageView,

it has multiple **gestures**
,you can get the same ImageView features as well .  

## Demo here 
<p align="center">
  <img  src="https://github.com/lau1944/Zoom-Drag-Rotate-ImageView/blob/branch/demo.gif" />
</p>

## How To Use 
- **Step 1**. Add the JitPack repository to your build file

     Add it in your root build.gradle at the end of repositories:
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

- **Step 2**. Add the dependency

```java
dependencies {
	        implementation 'com.github.lau1944:Zoom-Drag-Rotate-ImageView:currentversion'
	}
```

<img src="https://github.com/lau1944/Zoom-Drag-Rotate-ImageView/blob/branch/jitpack.svg">

- **Step 3**. Add Image
    
  **You can add it on XML file**
    
```xml
   <com.easystudio.rotateimageview.RotateZoomImageView
        android:id="@+id/rotate"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:src="@drawable/money"/>
```
 **Or add image programmatically** 
 
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
 
- **Final Step**. Add OnTouch Method
 
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
