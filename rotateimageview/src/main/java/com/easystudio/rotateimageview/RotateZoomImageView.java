package com.easystudio.rotateimageview;
import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import android.view.View;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RotateZoomImageView extends AppCompatImageView implements View.OnTouchListener{
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;
    private float oldDist = 1f;
    private float d = 0f;
    private float newRot = 0f;
    float scalediff;
    public RotateZoomImageView(Context context) {
        super(context);

    }

    /*
     * Use onSizeChanged() to calculate values based on the view's size.
     * The view has no size during init(), so we must wait for this
     * callback.
     */




    /*
     * Operate on two-finger events to rotate the image.
     * This method calculates the change in angle between the
     * pointers and rotates the image accordingly.  As the user
     * rotates their fingers, the image will follow.
     */
    RelativeLayout.LayoutParams parms;
    int startwidth;
    int startheight;
    float dx = 0, dy = 0, x = 0, y = 0;
    float angle = 0;


    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    private float rotation(MotionEvent event) {
        double delta_x = (event.getX(0) - event.getX(1));
        double delta_y = (event.getY(0) - event.getY(1));
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final ImageView view = (ImageView) v;
        ((BitmapDrawable) view.getDrawable()).setAntiAlias(true);
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                parms = (RelativeLayout.LayoutParams) view.getLayoutParams();
                startwidth = parms.width;
                startheight = parms.height;
                dx = event.getRawX() - parms.leftMargin;
                dy = event.getRawY() - parms.topMargin;
                mode = DRAG;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    mode = ZOOM;
                }

                d = rotation(event);

                break;
            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;

                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {

                    x = event.getRawX();
                    y = event.getRawY();

                    parms.leftMargin = (int) (x - dx);
                    parms.topMargin = (int) (y - dy);

                    parms.rightMargin = 0;
                    parms.bottomMargin = 0;
                    parms.rightMargin = parms.leftMargin + (5 * parms.width);
                    parms.bottomMargin = parms.topMargin + (10 * parms.height);

                    view.setLayoutParams(parms);

                } else if (mode == ZOOM) {

                    if (event.getPointerCount() == 2) {

                        newRot = rotation(event);
                        float r = newRot - d;
                        angle = r;

                        x = event.getRawX();
                        y = event.getRawY();

                        float newDist = spacing(event);
                        if (newDist > 10f) {
                            float scale = newDist / oldDist * view.getScaleX();
                            if (scale > 0.6) {
                                scalediff = scale;
                                view.setScaleX(scale);
                                view.setScaleY(scale);

                            }
                        }

                        view.animate().rotationBy(angle).setDuration(0).setInterpolator(new LinearInterpolator()).start();

                        x = event.getRawX();
                        y = event.getRawY();

                        parms.leftMargin = (int) ((x - dx) + scalediff);
                        parms.topMargin = (int) ((y - dy) + scalediff);

                        parms.rightMargin = 0;
                        parms.bottomMargin = 0;
                        parms.rightMargin = parms.leftMargin + (5 * parms.width);
                        parms.bottomMargin = parms.topMargin + (10 * parms.height);

                        view.setLayoutParams(parms);


                    }
                }
                break;
        }

        return true;
    }
}
