package com.alipay.mobile.h5container.api;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.process.H5EventHandler;
import com.alipay.mobile.nebula.provider.H5LoadingViewProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5LoadingView implements H5LoadingViewProvider {
    public static final String TAG = "H5LoadingView";
    /* access modifiers changed from: private */
    public View backLoadingView;
    private View contentView;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;

    public void setIcon(String str) {
    }

    public View getContentView(final Activity activity) {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        if (activity != null) {
            H5Log.d(TAG, "getContentView: activity.getResouces()=" + activity.getResources());
        }
        this.contentView = H5ViewCache.getCachedViewById(R.layout.h5_loading_fragment);
        if (this.contentView == null) {
            this.contentView = LayoutInflater.from(activity).inflate(R.layout.h5_loading_fragment, (ViewGroup) null);
        }
        this.backLoadingView = this.contentView.findViewById(R.id.h5_lv_nav_back_loading);
        this.progressBar = (ProgressBar) this.contentView.findViewById(R.id.h5_nav_loading_loading);
        this.backLoadingView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!activity.isFinishing()) {
                    if (H5Utils.isInTinyProcess()) {
                        H5EventHandler h5EventHandler = (H5EventHandler) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
                        if (h5EventHandler != null) {
                            h5EventHandler.moveTaskToBackAndStop(activity, false);
                        }
                    } else {
                        activity.finish();
                    }
                    H5Log.d(H5LoadingView.TAG, "isFinishing " + activity.isFinishing());
                }
            }
        });
        this.progressBar.postDelayed(new Runnable() {
            public void run() {
                H5LoadingView.this.progressBar.setVisibility(0);
            }
        }, 300);
        return this.contentView;
    }

    public void stopLoading(final Activity activity) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            try {
                progressBar2.setIndeterminateDrawable((Drawable) null);
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        View view = this.backLoadingView;
        if (view != null) {
            view.postDelayed(new Runnable() {
                public void run() {
                    try {
                        if (!activity.isFinishing() && H5LoadingView.this.backLoadingView != null) {
                            H5LoadingView.this.backLoadingView.setVisibility(8);
                        }
                    } catch (Exception e2) {
                        H5Log.e(H5LoadingView.TAG, (Throwable) e2);
                    }
                }
            }, 5000);
        }
    }

    public void setTitle(String str) {
        TextView textView;
        View view = this.contentView;
        if (view != null && (textView = (TextView) view.findViewById(R.id.h5_ll_lv_nav_title)) != null) {
            textView.setText(str);
        }
    }
}
