package com.rnblurview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CanvasBlur extends Canvas {

    private boolean mEnabled = true;
    public void setEnabled(boolean b){
        mEnabled = b;
    }

    public boolean isEnabled(){
        return mEnabled;
    }

    @Override
    public void drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint) {
       if(mEnabled)  super.drawArc(oval, startAngle, sweepAngle, useCenter, paint);
    }

    @Override
    public void drawARGB(int a, int r, int g, int b) {
        if(mEnabled)  super.drawARGB(a, r, g, b);
    }

    @Override
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint) {
        if(mEnabled)   super.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @NonNull Matrix matrix, @Nullable Paint paint) {
        if(mEnabled)   super.drawBitmap(bitmap, matrix, paint);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull Rect dst, @Nullable Paint paint) {
        if(mEnabled)  super.drawBitmap(bitmap, src, dst, paint);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull RectF dst, @Nullable Paint paint) {
        if(mEnabled)  super.drawBitmap(bitmap, src, dst, paint);
    }

    @Override
    public void drawBitmap(@NonNull Bitmap bitmap, float left, float top, @Nullable Paint paint) {
        if(mEnabled)  super.drawBitmap(bitmap, left, top, paint);
    }

    @Override
    public void drawBitmapMesh(@NonNull Bitmap bitmap, int meshWidth, int meshHeight, @NonNull float[] verts, int vertOffset, @Nullable int[] colors, int colorOffset, @Nullable Paint paint) {
        if(mEnabled)  super.drawBitmapMesh(bitmap, meshWidth, meshHeight, verts, vertOffset, colors, colorOffset, paint);
    }

    @Override
    public void drawCircle(float cx, float cy, float radius, @NonNull Paint paint) {
        if(mEnabled)  super.drawCircle(cx, cy, radius, paint);
    }

    @Override
    public void drawColor(int color) {
        if(mEnabled)  super.drawColor(color);
    }

    @Override
    public void drawColor(long color) {
        if(mEnabled)  super.drawColor(color);
    }

    @Override
    public void drawColor(int color, @NonNull PorterDuff.Mode mode) {
        if(mEnabled)  super.drawColor(color, mode);
    }

    @Override
    public void drawColor(int color, @NonNull BlendMode mode) {
        if(mEnabled)   super.drawColor(color, mode);
    }

    @Override
    public void drawColor(long color, @NonNull BlendMode mode) {
        if(mEnabled)  super.drawColor(color, mode);
    }

    @Override
    public void drawDoubleRoundRect(@NonNull RectF outer, @NonNull float[] outerRadii, @NonNull RectF inner, @NonNull float[] innerRadii, @NonNull Paint paint) {
        if(mEnabled)  super.drawDoubleRoundRect(outer, outerRadii, inner, innerRadii, paint);
    }

    @Override
    public void drawDoubleRoundRect(@NonNull RectF outer, float outerRx, float outerRy, @NonNull RectF inner, float innerRx, float innerRy, @NonNull Paint paint) {
        if(mEnabled)  super.drawDoubleRoundRect(outer, outerRx, outerRy, inner, innerRx, innerRy, paint);
    }

    @Override
    public void drawLine(float startX, float startY, float stopX, float stopY, @NonNull Paint paint) {
        if(mEnabled)  super.drawLine(startX, startY, stopX, stopY, paint);
    }

    @Override
    public void drawLines(@NonNull float[] pts, @NonNull Paint paint) {
        if(mEnabled)  super.drawLines(pts, paint);
    }

    @Override
    public void drawLines(@NonNull float[] pts, int offset, int count, @NonNull Paint paint) {
        if(mEnabled)  super.drawLines(pts, offset, count, paint);
    }

    @Override
    public void drawOval(@NonNull RectF oval, @NonNull Paint paint) {
        if(mEnabled)   super.drawOval(oval, paint);
    }

    @Override
    public void drawOval(float left, float top, float right, float bottom, @NonNull Paint paint) {
        if(mEnabled)  super.drawOval(left, top, right, bottom, paint);
    }

    @Override
    public void drawPaint(@NonNull Paint paint) {
        if(mEnabled)   super.drawPaint(paint);
    }

    @Override
    public void drawPath(@NonNull Path path, @NonNull Paint paint) {
        if(mEnabled)  super.drawPath(path, paint);
    }

    @Override
    public void drawPicture(@NonNull Picture picture) {
        if(mEnabled)  super.drawPicture(picture);
    }

    @Override
    public void drawPicture(@NonNull Picture picture, @NonNull Rect dst) {
        if(mEnabled)   super.drawPicture(picture, dst);
    }

    @Override
    public void drawPicture(@NonNull Picture picture, @NonNull RectF dst) {
        if(mEnabled)  super.drawPicture(picture, dst);
    }

    @Override
    public void drawPoint(float x, float y, @NonNull Paint paint) {
        if(mEnabled)  super.drawPoint(x, y, paint);
    }

    @Override
    public void drawPoints(@NonNull float[] pts, @NonNull Paint paint) {
        if(mEnabled)  super.drawPoints(pts, paint);
    }

    @Override
    public void drawPoints(float[] pts, int offset, int count, @NonNull Paint paint) {
        if(mEnabled)  super.drawPoints(pts, offset, count, paint);
    }

    @Override
    public void drawRect(@NonNull Rect r, @NonNull Paint paint) {
        if(mEnabled)  super.drawRect(r, paint);
    }

    @Override
    public void drawRect(@NonNull RectF rect, @NonNull Paint paint) {
        if(mEnabled)  super.drawRect(rect, paint);
    }

    @Override
    public void drawRect(float left, float top, float right, float bottom, @NonNull Paint paint) {
        if(mEnabled)  super.drawRect(left, top, right, bottom, paint);
    }

    @Override
    public void drawRenderNode(@NonNull RenderNode renderNode) {
        if(mEnabled)  super.drawRenderNode(renderNode);
    }

    @Override
    public void drawRGB(int r, int g, int b) {
        if(mEnabled)  super.drawRGB(r, g, b);
    }

    @Override
    public void drawRoundRect(@NonNull RectF rect, float rx, float ry, @NonNull Paint paint) {
        if(mEnabled)  super.drawRoundRect(rect, rx, ry, paint);
    }

    @Override
    public void drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, @NonNull Paint paint) {
        if(mEnabled)  super.drawRoundRect(left, top, right, bottom, rx, ry, paint);
    }

    @Override
    public void drawText(@NonNull String text, float x, float y, @NonNull Paint paint) {
        if(mEnabled)  super.drawText(text, x, y, paint);
    }

    @Override
    public void drawText(@NonNull String text, int start, int end, float x, float y, @NonNull Paint paint) {
        if(mEnabled)  super.drawText(text, start, end, x, y, paint);
    }

    @Override
    public void drawText(@NonNull char[] text, int index, int count, float x, float y, @NonNull Paint paint) {
        if(mEnabled)   super.drawText(text, index, count, x, y, paint);
    }

    @Override
    public void drawText(@NonNull CharSequence text, int start, int end, float x, float y, @NonNull Paint paint) {
        if(mEnabled)  super.drawText(text, start, end, x, y, paint);
    }

    @Override
    public void drawTextOnPath(@NonNull String text, @NonNull Path path, float hOffset, float vOffset, @NonNull Paint paint) {
        if(mEnabled)  super.drawTextOnPath(text, path, hOffset, vOffset, paint);
    }

    @Override
    public void drawTextOnPath(@NonNull char[] text, int index, int count, @NonNull Path path, float hOffset, float vOffset, @NonNull Paint paint) {
        if(mEnabled)  super.drawTextOnPath(text, index, count, path, hOffset, vOffset, paint);
    }

    @Override
    public void drawTextRun(@NonNull char[] text, int index, int count, int contextIndex, int contextCount, float x, float y, boolean isRtl, @NonNull Paint paint) {
        if(mEnabled)   super.drawTextRun(text, index, count, contextIndex, contextCount, x, y, isRtl, paint);
    }

    @Override
    public void drawTextRun(@NonNull CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @NonNull Paint paint) {
        if(mEnabled)   super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, isRtl, paint);
    }

    @Override
    public void drawTextRun(@NonNull MeasuredText text, int start, int end, int contextStart, int contextEnd, float x, float y, boolean isRtl, @NonNull Paint paint) {
        if(mEnabled)  super.drawTextRun(text, start, end, contextStart, contextEnd, x, y, isRtl, paint);
    }

    @Override
    public void drawVertices(@NonNull VertexMode mode, int vertexCount, @NonNull float[] verts, int vertOffset, @Nullable float[] texs, int texOffset, @Nullable int[] colors, int colorOffset, @Nullable short[] indices, int indexOffset, int indexCount, @NonNull Paint paint) {
        if(mEnabled)  super.drawVertices(mode, vertexCount, verts, vertOffset, texs, texOffset, colors, colorOffset, indices, indexOffset, indexCount, paint);
    }

    @Override
    public void setDrawFilter(@Nullable DrawFilter filter) {
        if(mEnabled)   super.setDrawFilter(filter);
    }


}
