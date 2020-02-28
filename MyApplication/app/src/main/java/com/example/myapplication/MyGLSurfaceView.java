/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.myapplication;

import android.app.LauncherActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.opengles.GL10;


/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView {


    private final MyGLRenderer mRenderer;
    MainActivity maContext;

    public MyGLSurfaceView(Context context) {

        super(context);
        maContext=(MainActivity) context;

        // Create an OpenGL ES 2.0 context.  CHANGED to 3.0  JW.
        setEGLContextClientVersion(3);
        //fix for error No Config chosen, but I don't know what this does.
        super.setEGLConfigChooser(8 , 8, 8, 8, 16, 0);
        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = new MyGLRenderer();
        setRenderer(mRenderer);



        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }



    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        //Drawing l =new Drawing(0,0);

        final  float x = event.getX();
        final float y = event.getY();
        Log.i("GL Surface View","X="+x+" Y="+y);
        switch(event.getAction()) {
           /* case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_BUTTON_PRESS:
            case MotionEvent.ACTION_UP:
                        //l.onDrawFrame();
                        //mRenderer.draw.drawPath.moveTo(x, y);
                        //mRenderer.draw.drawPath.lineTo(x,y);
                        //mRenderer.draw.drawCanvas.drawPath(mRenderer.draw.drawPath, mRenderer.draw.drawPaint);
                        //drawPath.reset();



        }
        return true;*/
            float touchX = event.getX();
            float touchY = event.getY();
            //respond to down, move and up events
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    drawPath.moveTo(touchX, touchY);
                    drawCanvas.drawCircle(touchX, touchY, 15, drawPaint);
                    break;
                case MotionEvent.ACTION_MOVE:
                    drawPath.lineTo(touchX, touchY);

                    break;
                case MotionEvent.ACTION_UP:
                    drawPath.lineTo(touchX, touchY);
                    drawCanvas.drawCircle(touchX, touchY, 15, drawPaint);
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
                    break;
                default:
                    return false;
            }
            //redraw
            invalidate();
            return true;
    }


}
