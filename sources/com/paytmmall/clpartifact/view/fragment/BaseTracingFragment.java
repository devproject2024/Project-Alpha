package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.perf.a;
import com.google.firebase.perf.metrics.Trace;
import com.paytmmall.clpartifact.listeners.IHomeTraceListener;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.utils.RVLayoutListener;
import java.util.HashMap;
import kotlin.g.b.k;

public abstract class BaseTracingFragment extends BaseGestureFragment {
    private HashMap _$_findViewCache;
    private IHomeTraceListener homeListener;
    private Trace launchRenderTrace;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final IHomeTraceListener getHomeListener() {
        return this.homeListener;
    }

    public final void setHomeListener(IHomeTraceListener iHomeTraceListener) {
        this.homeListener = iHomeTraceListener;
    }

    public void onCreate(Bundle bundle) {
        IHomeTraceListener iHomeTraceListener;
        HomeUtils.d$default("Starting home render", false, 2, (Object) null);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (iHomeTraceListener = this.homeListener) == null)) {
            k.a((Object) activity, "this");
            iHomeTraceListener.stopMainActivityTrace(activity);
        }
        if (this.homeListener != null) {
            a.a();
            this.launchRenderTrace = a.b("home_launch_home_render_trace");
            Trace trace = this.launchRenderTrace;
            if (trace != null) {
                trace.start();
            }
        }
        super.onCreate(bundle);
    }

    private final void stopHomeLaunchToHomeRenderTrace() {
        Trace trace = this.launchRenderTrace;
        if (trace != null) {
            trace.stop();
        }
        this.launchRenderTrace = null;
        HomeUtils.d$default("Render complete. :)", false, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final RVLayoutListener getLayoutListener(RecyclerView recyclerView) {
        k.c(recyclerView, "recyclerView");
        return new BaseTracingFragment$getLayoutListener$1(this, recyclerView, recyclerView);
    }

    /* access modifiers changed from: protected */
    public void runHomeSettle() {
        IHomeTraceListener iHomeTraceListener;
        stopHomeLaunchToHomeRenderTrace();
        FragmentActivity activity = getActivity();
        if (activity != null && (iHomeTraceListener = this.homeListener) != null) {
            k.a((Object) activity, "this");
            iHomeTraceListener.runAfterHomeSettle(activity);
        }
    }
}
