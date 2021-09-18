package com.rnblurview;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.HashMap;
import java.util.Map;

public class BlurRootViewManager extends ViewGroupManager<BlurRootView> {

    public final static Map<String, BlurRootView> BlurNodes = new HashMap<>();

    @Override
    public String getName() {
        return "JJSBlurRootView";
    }

    @Override
    protected BlurRootView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new BlurRootView(reactContext);
    }

    @ReactProp(name = "name")
    public void setName(BlurRootView view, String v){
        view.setName(v == null ? "" : v);
    }

}