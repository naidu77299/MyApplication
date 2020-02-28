package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Provides drawing instructions for a GLSurfaceView object. This class
 * must override the OpenGL ES drawing lifecycle methods:
 * <ul>
 *   <li>{@link android.opengl.GLSurfaceView.Renderer#onSurfaceCreated}</li>
 *   <li>{@link android.opengl.GLSurfaceView.Renderer#onDrawFrame}</li>
 *   <li>{@link android.opengl.GLSurfaceView.Renderer#onSurfaceChanged}</li>
 * </ul>
 */
public  class MyGLRenderer implements GLSurfaceView.Renderer {

    private static final String TAG = "MyGLRenderer";
    //private Triangle mTriangle;
    private Square   mSquare;
    private Line mline;
    //public DrawingView draw;


    // mMVPMatrix is an abbreviation for "Model View Projection Matrix"
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final float[] mRotationMatrix = new float[16];

    private float mAngle;

    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {

        // Set the background frame color
        GLES30.glClearColor(120f, 67f, 77f, 180f);

        // mTriangle = new Triangle();

    }

    public void onDrawFrame(GL10 unused) {

        // Draw background color
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT | GLES30.GL_DEPTH_BUFFER_BIT);

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
         float squareCoords[] = {
                -0.5f,  0.5f, 0.0f,   // top left
                -0.5f, 0.17f, 0.0f,   // bottom left
                -0.17f, 0.17f, 0.0f,   // bottom right
                -0.17f,  0.5f, 0.0f };
        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);

        squareCoords[0] =  0.5f;
        squareCoords[1] =  0.5f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  0.5f;
        squareCoords[4] =  0.17f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.17f;
        squareCoords[7] =  0.17f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.17f;
        squareCoords[10] =  0.5f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);

        squareCoords[0] =  -0.5f;
        squareCoords[1] =  -0.5f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  -0.5f;
        squareCoords[4] =  -0.17f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  -0.17f;
        squareCoords[7] =  -0.17f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  -0.17f;
        squareCoords[10] =  -0.5f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);


        squareCoords[0] =  0.5f;
        squareCoords[1] =  -0.5f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  0.5f;
        squareCoords[4] =  -0.17f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.17f;
        squareCoords[7] =  -0.17f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.17f;
        squareCoords[10] = -0.5f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);

        squareCoords[0] =  -0.165f;
        squareCoords[1] =  0.5f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  -0.165f;
        squareCoords[4] =  0.17f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.165f;
        squareCoords[7] =  0.17f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.165f;
        squareCoords[10] =  0.5f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);

        squareCoords[0] =  -0.165f;
        squareCoords[1] =  -0.5f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  -0.165f;
        squareCoords[4] =  -0.17f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.165f;
        squareCoords[7] =  -0.17f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.165f;
        squareCoords[10] =  -0.5f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);


        squareCoords[0] =  -0.5f;
        squareCoords[1] =  0.165f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  -0.5f;
        squareCoords[4] =  -0.165f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  -0.17f;
        squareCoords[7] =  -0.165f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  -0.17f;
        squareCoords[10] =  0.165f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);

        squareCoords[0] =  0.5f;
        squareCoords[1] =  0.165f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  0.5f;
        squareCoords[4] =  -0.165f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.17f;
        squareCoords[7] =  -0.165f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.17f;
        squareCoords[10] =  0.165f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);


        squareCoords[0] =  -0.165f;
        squareCoords[1] =  0.165f;
        squareCoords[2] =  0.0f;
        squareCoords[3] =  -0.165f;
        squareCoords[4] =  -0.165f;
        squareCoords[5] =  0.0f;
        squareCoords[6] =  0.165f;
        squareCoords[7] =  -0.165f;
        squareCoords[8] =  0.0f;
        squareCoords[9] =  0.165f;
        squareCoords[10] =  0.165f;
        squareCoords[11] =  0.0f;

        mSquare   = new Square(squareCoords);
        mSquare.draw(mMVPMatrix);



    }

   /* public class DrawingView extends View {

        //prepare for drawing and setup paint stroke properties
        //drawing path
        public Path drawPath;
        //drawing and canvas paint
        public Paint drawPaint, canvasPaint;
        //initial color
        private int paintColor = 0xFF660000;
        //canvas
        public  Canvas drawCanvas;
        //canvas bitmap
        private Bitmap canvasBitmap;

        public DrawingView(Context context, AttributeSet attrs){
            super(context, attrs);
            setupDrawing();
        }

        //setup drawing
        private void setupDrawing(){

            drawPath = new Path();
            drawPaint = new Paint();
            drawPaint.setColor(paintColor);
            drawPaint.setAntiAlias(true);
            drawPaint.setStrokeWidth(20);
            drawPaint.setStyle(Paint.Style.STROKE);
            drawPaint.setStrokeJoin(Paint.Join.ROUND);
            drawPaint.setStrokeCap(Paint.Cap.ROUND);
            canvasPaint = new Paint(Paint.DITHER_FLAG);
        }

        //size assigned to view
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            drawCanvas = new Canvas(canvasBitmap);
        }

        //draw the view - will be called after touch event
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
            canvas.drawPath(drawPath, drawPaint);

        }

        //update color
        public void setColor(String newColor){
            invalidate();
            paintColor = Color.parseColor(newColor);
            drawPaint.setColor(paintColor);
        }
        public void setColor(int color){
            invalidate();
            paintColor = color;
            drawPaint.setColor(paintColor);
        }
        public int getColor()
        {

            return drawPaint.getColor();
        }
    }*/


    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // Adjust the viewport based on geometry changes,
        // such as screen rotation
        GLES30.glViewport(0, 0, width, height);

        float ratio = (float) width / height;

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);

    }

    /**
     * Utility method for compiling a OpenGL shader.
     *
     * <p><strong>Note:</strong> When developing shaders, use the checkGlError()
     * method to debug shader coding errors.</p>
     *
     * @param type - Vertex or fragment shader type.
     * @param shaderCode - String containing the shader code.
     * @return - Returns an id for the shader.
     */
    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES30.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES30.GL_FRAGMENT_SHADER)
        int shader = GLES30.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES30.glShaderSource(shader, shaderCode);
        GLES30.glCompileShader(shader);

        return shader;
    }

    /**
     * Utility method for debugging OpenGL calls. Provide the name of the call
     * just after making it:
     *
     * <pre>
     * mColorHandle = GLES30.glGetUniformLocation(mProgram, "vColor");
     * MyGLRenderer.checkGlError("glGetUniformLocation");</pre>
     *
     * If the operation is not successful, the check throws an error.
     *
     * @param glOperation - Name of the OpenGL call to check.
     */
    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES30.glGetError()) != GLES30.GL_NO_ERROR) {
            Log.e(TAG, glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    /**
     * Returns the rotation angle of the triangle shape (mTriangle).
     *
     * @return - A float representing the rotation angle.
     */
    public float getAngle() {
        return mAngle;
    }

    public void onDraw(float x,float y) {
        //float[] scratch = new float[16];
        float LineCoords[]  ={
                0.5f,  -0.25f, 0.0f,
                -0.5f, -0.25f, 0.0f
        };
        mline = new Line(LineCoords);
        mline.draw(mMVPMatrix);
        Log.i("GL ","X="+x+" Y="+y);
    }


    /**
     * Sets the rotation angle of the triangle shape (mTriangle).
     */



}