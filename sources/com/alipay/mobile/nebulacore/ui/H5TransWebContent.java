package com.alipay.mobile.nebulacore.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5PageImpl;

public class H5TransWebContent extends H5SimplePlugin {
    private static final String HIDE_TRANS_BACK = "hideTransBack";
    public static final String TAG = "H5TransWebContent";
    /* access modifiers changed from: private */
    public H5PageImpl h5Page;
    private View layout;
    private ImageView transBackImg;
    private LinearLayout transLayout;
    private RelativeLayout webContent;

    public H5TransWebContent(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
        initViews();
    }

    private void initViews() {
        this.layout = LayoutInflater.from(this.h5Page.getContext().getContext()).inflate(R.layout.h5_trans_web_content, (ViewGroup) null);
        this.webContent = (RelativeLayout) this.layout.findViewById(R.id.h5_trans_web_content);
        this.transLayout = (LinearLayout) this.layout.findViewById(R.id.h5_tf_nav_ly);
        this.transBackImg = (ImageView) this.layout.findViewById(R.id.h5_tf_nav_back);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_TRANS_ANIMATE, false)) {
            H5TransProgressContent h5TransProgressContent = new H5TransProgressContent(this.h5Page);
            this.h5Page.getPluginManager().register((H5Plugin) h5TransProgressContent);
            this.webContent.addView(h5TransProgressContent.getContent(), layoutParams);
        } else {
            this.webContent.addView(this.h5Page.getWebView().getView(), layoutParams);
        }
        this.transBackImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (H5TransWebContent.this.h5Page != null) {
                    H5TransWebContent.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_BACK, (e) null);
                }
            }
        });
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl != null && !H5Utils.getBoolean(h5PageImpl.getParams(), H5Param.LONG_FULLSCREEN, false)) {
            this.transLayout.setVisibility(8);
        }
    }

    public View getContent() {
        return this.layout;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.CLOSE_WEBVIEW);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK);
        h5EventFilter.addAction(HIDE_TRANS_BACK);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.CLOSE_WEBVIEW.equals(action)) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
            return true;
        } else if (H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK.equals(action) || H5Plugin.InternalEvents.H5_TOOLBAR_BACK.equals(action)) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_BACK, (e) null);
            return true;
        } else if (!HIDE_TRANS_BACK.equals(action)) {
            return false;
        } else {
            this.transLayout.setVisibility(8);
            h5BridgeContext.sendSuccess();
            return true;
        }
    }

    public void onRelease() {
        super.onRelease();
    }
}
