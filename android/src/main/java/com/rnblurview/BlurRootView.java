package com.rnblurview;

import android.content.Context;
import android.view.ViewGroup;

public class BlurRootView extends ViewGroup {
    
    protected String name = "";
    protected String oldName = "";

    public BlurRootView(Context context) {
        super(context);

    }

    public void setName(String n) {
        if(!name.equals(n)){
            oldName = name;
            name = n;
            setupBlurNode();
        }
    }
    
    public void setupBlurNode(){
        if(!oldName.isEmpty()){
            BlurRootViewManager.BlurNodes.remove(oldName);
        }
        if(!name.isEmpty()){
            BlurRootViewManager.BlurNodes.put(name,this);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

}
