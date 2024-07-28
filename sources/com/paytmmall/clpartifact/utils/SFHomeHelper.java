package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.paytmmall.clpartifact.R;
import kotlin.g.b.k;

public final class SFHomeHelper {
    public static final SFHomeHelper INSTANCE = new SFHomeHelper();
    private static View homeView;

    private SFHomeHelper() {
    }

    public final View getHomeView() {
        return homeView;
    }

    public final void resetHomeView() {
        homeView = null;
    }

    public final void initHomeView(Context context) {
        k.c(context, "context");
        try {
            homeView = LayoutInflater.from(context).cloneInContext(new ContextThemeWrapper(context, R.style.AppThemeNoActionBar)).inflate(R.layout.fragment_home, new FrameLayout(context), false);
        } catch (InterruptedException unused) {
        }
    }
}
