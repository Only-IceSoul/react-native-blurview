package com.rnblurview;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;


public class BlurViewManager extends ViewGroupManager<BlurView> {


    @Override
    public String getName() {
        return "JJSBlurView";
    }

    @Override
    protected BlurView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new BlurView(reactContext);
    }
    @ReactProp(name = "blurNode")
    public void setBlurNode(BlurView view, String v){
        view.setBlurNode(v == null ? "" : v);
    }


    @Override
    @ReactProp(
            name = ViewProps.BACKGROUND_COLOR,
            defaultInt = Color.TRANSPARENT,
            customType = "Color")
    public void setBackgroundColor(@NonNull BlurView view, int backgroundColor) {
        view.setBgColor(backgroundColor);
    }
}