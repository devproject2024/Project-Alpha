package com.alipay.mobile.nebulacore.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5TransProgressContent extends H5SimplePlugin {
    public static final int DEFAULT_SHOW_CLOSE_DELAY = 2000;
    public static final String KEY_SHOW_CLOSE_DELAY = "h5_showCloseDelay";
    public static final String TAG = "H5TransProgressContent";
    /* access modifiers changed from: private */
    public TextView closeTextView;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public H5PageImpl h5Page;
    private Handler handler;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    Runnable showCloseRunnable = new Runnable() {
        public void run() {
            H5TransProgressContent.this.closeTextView.setVisibility(0);
        }
    };
    Runnable showProgressRunnable = new Runnable() {
        public void run() {
            Drawable drawable = H5TransProgressContent.this.context.getResources().getDrawable(R.drawable.h5_title_bar_progress);
            drawable.setBounds(0, 0, H5Utils.dip2px(H5TransProgressContent.this.context, 26), H5Utils.dip2px(H5TransProgressContent.this.context, 26));
            H5TransProgressContent.this.progressBar.setIndeterminateDrawable(drawable);
            H5TransProgressContent.this.progressBar.setVisibility(0);
        }
    };
    private RelativeLayout transProgressLayout;

    public H5TransProgressContent(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
        initViews();
    }

    private void initViews() {
        this.context = this.h5Page.getContext().getContext();
        this.transProgressLayout = (RelativeLayout) LayoutInflater.from(this.context).inflate(com.alipay.mobile.nebulacore.R.layout.h5_trans_progress_content, (ViewGroup) null);
        this.progressBar = (ProgressBar) this.transProgressLayout.findViewById(com.alipay.mobile.nebulacore.R.id.h5_progress_pb);
        this.closeTextView = (TextView) this.transProgressLayout.findViewById(com.alipay.mobile.nebulacore.R.id.h5_close_tv);
        if (this.h5Page.getParams().containsKey("backgroundColor")) {
            this.transProgressLayout.setBackgroundColor(H5Utils.getInt(this.h5Page.getParams(), "backgroundColor"));
            this.h5Page.getWebView().getView().setBackgroundColor(0);
        }
        this.closeTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                H5TransProgressContent.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
        this.handler.postDelayed(this.showProgressRunnable, 300);
        this.handler.postDelayed(this.showCloseRunnable, (long) getH5ShowCloseDelay());
    }

    public View getContent() {
        return this.transProgressLayout;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_ERROR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PROGRESS);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action) || H5Plugin.InternalEvents.H5_PAGE_ERROR.equals(action)) {
            showWebView();
        } else if (H5Plugin.InternalEvents.H5_PAGE_PROGRESS.equals(action) && H5Utils.getInt(param, H5Param.PROGRESS) == 100) {
            showWebView();
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }

    private void showWebView() {
        this.handler.removeCallbacks(this.showProgressRunnable);
        this.handler.removeCallbacks(this.showCloseRunnable);
        this.transProgressLayout.removeAllViews();
        this.transProgressLayout.addView(this.h5Page.getWebView().getView(), new RelativeLayout.LayoutParams(-1, -1));
    }

    public void onRelease() {
        super.onRelease();
        this.handler.removeCallbacks(this.showCloseRunnable);
        this.handler.removeCallbacks(this.showProgressRunnable);
    }

    private int getH5ShowCloseDelay() {
        String config = H5Environment.getConfig(KEY_SHOW_CLOSE_DELAY);
        try {
            if (TextUtils.isEmpty(config)) {
                return DEFAULT_SHOW_CLOSE_DELAY;
            }
            return Integer.parseInt(config);
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail.", e2);
            return DEFAULT_SHOW_CLOSE_DELAY;
        }
    }
}
