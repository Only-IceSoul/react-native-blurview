package com.rnblurview;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


import java.util.Objects;

public class BlurView extends ViewGroup {
    static float DEFAULT_SCALE_FACTOR = 8f;
    static float DEFAULT_BLUR_RADIUS = 10f;

    RenderScript mRs ;
    Bitmap mBitmapBlur;
    CanvasBlur mCanvas = new CanvasBlur();
    boolean mIsBlur = false;
    float mRadius = DEFAULT_BLUR_RADIUS;
    BlurRootView mRootView;

    private float mScaleFactor = 1f;
    private final SizeScaler mSizeScaler = new SizeScaler(DEFAULT_SCALE_FACTOR);
    private final Paint mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private Allocation mOutAllocation;
    private final ScriptIntrinsicBlur mScript;
    private int mBgColor = Color.TRANSPARENT;

    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        @Override
        public boolean onPreDraw() {
            updateBlur();
            return true;
        }
    };

    BlurView(Context context){
        super(context);
        mRs = RenderScript.create(context);
        mScript = ScriptIntrinsicBlur.create(mRs, Element.U8_4(mRs));
        actionOnLayout();
    }
    public void setRadius(float v){
        if(mRadius != v){
            mRadius = v > 25f ? 25f : Math.max(v, 0f);
            updateBlur();
            invalidate();
        }
    }
    private void actionOnLayout(){
        addOnLayoutChangeListener(new OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                v.removeOnLayoutChangeListener(this);
                setupBlurNode();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(mOnPreDrawListener);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(mOnPreDrawListener);
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void dispatchDraw(Canvas canvas) {
        if(!mIsBlur) {
            if(getWidth() > 0 && getHeight() > 0){
                canvas.drawColor(mBgColor);
                drawBlur(canvas);
                super.dispatchDraw(canvas);
            }
        }else{
           mCanvas.setEnabled(false);
        }
    }
    private void updateBlur(){
        if(mRootView != null && mBitmapBlur != null && getWidth() > 0 && getHeight() > 0) {
            mBitmapBlur.eraseColor(Color.TRANSPARENT);
            mCanvas.setEnabled(true);
            drawNode();
            if(mRadius > 0f){   blur();   }

        }
    }
    private void drawBlur(Canvas canvas){
        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        canvas.drawBitmap(mBitmapBlur,0,0,mPaint);
        canvas.restore();
    }

    int[] mNodeLocation =  new int[2];
    int[] mChildLocation =  new int[2];

    private void setupMatrix(){

        mRootView.getLocationOnScreen(mNodeLocation);
        getLocationOnScreen(mChildLocation);

        int left = mChildLocation[0] - mNodeLocation[0];
        int top = mChildLocation[1] - mNodeLocation[1];

        float scaledLeftPosition = -left / mScaleFactor;
        float scaledTopPosition = -top / mScaleFactor;

        mCanvas.translate(scaledLeftPosition, scaledTopPosition);
        mCanvas.scale(1 / mScaleFactor, 1 / mScaleFactor);
    }


    private boolean mCreateNewAllocation = false;
    private void blur(){
        Allocation input = Allocation.createFromBitmap(mRs, mBitmapBlur);
        if(mCreateNewAllocation){
            if(mOutAllocation != null) mOutAllocation.destroy();
            mOutAllocation = Allocation.createTyped(mRs, input.getType());
            mCreateNewAllocation = false;
        }
        mScript.setRadius(mRadius);
        mScript.setInput(input);
        mScript.forEach(mOutAllocation);
        input.destroy();
        mOutAllocation.copyTo(mBitmapBlur);
    }

    private void drawNode() {
        mCanvas.save();
        setupMatrix();
        mIsBlur = true;
        mRootView.draw(mCanvas);
        mIsBlur = false;
        mCanvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        setupBitmap(w,h);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void setupBitmap(int w, int h){
        SizeScaler.Size bitmapSize = mSizeScaler.scale(w, h);
        mScaleFactor = bitmapSize.scaleFactor;
        if(mBitmapBlur == null  ) {
            if(w > 0 && h > 0) {
                mBitmapBlur = Bitmap.createBitmap(bitmapSize.width, bitmapSize.height, Bitmap.Config.ARGB_8888);
                mCanvas.setBitmap(mBitmapBlur);
                mCreateNewAllocation = true;
            }
        }else if(bitmapSize.width != mBitmapBlur.getWidth() || bitmapSize.height != mBitmapBlur.getHeight()){
            if(w > 0 && h > 0) {
                mBitmapBlur = Bitmap.createBitmap(bitmapSize.width, bitmapSize.height, Bitmap.Config.ARGB_8888);
                mCanvas.setBitmap(mBitmapBlur);
                mCreateNewAllocation = true;
            }
        }
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


   public void setBgColor(int v){
        mBgColor = v;
        invalidate();
   }

    private String mBlurNode = "";
    public void setBlurNode(String v) {
        if(!Objects.equals(mBlurNode, v)) {
            mBlurNode = v;
            setupBlurNode();
        }
    }
    private void setupBlurNode(){
        if(!mBlurNode.isEmpty()){
            mRootView = BlurRootViewManager.BlurNodes.get(mBlurNode);
        }
        updateBlur();
    }

}

