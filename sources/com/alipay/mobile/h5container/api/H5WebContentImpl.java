package com.alipay.mobile.h5container.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebula.view.H5Progress;
import com.alipay.mobile.nebula.view.H5WebContentView;
import java.util.concurrent.atomic.AtomicBoolean;

public class H5WebContentImpl implements H5WebContentView {
    /* access modifiers changed from: private */
    public static String TAG = "H5WebContentImpl";
    public View contentView = H5ViewCache.getCachedViewById(R.layout.h5_web_content);
    private H5LoadingView h5LoadingView;
    public H5Progress h5Progress;
    public TextView h5ProviderDomain;
    public LinearLayout h5ProviderLayout;
    public TextView h5ProviderUc;
    public TextView h5ProviderUcLogo;
    public View hDivider;
    /* access modifiers changed from: private */
    public AtomicBoolean isShowProgress = new AtomicBoolean(false);
    public H5PullContainer pullContainer;
    public View webContent;

    public boolean isCustomBackground() {
        return false;
    }

    public H5WebContentImpl(Context context) {
        if (this.contentView == null) {
            this.contentView = LayoutInflater.from(context).inflate(R.layout.h5_web_content, (ViewGroup) null);
        }
        this.webContent = this.contentView.findViewById(R.id.h5_web_content);
        this.h5ProviderLayout = (LinearLayout) this.contentView.findViewById(R.id.h5_ly_provider_layout);
        this.h5ProviderDomain = (TextView) this.contentView.findViewById(R.id.h5_tv_provider_domain);
        this.h5ProviderUcLogo = (TextView) this.contentView.findViewById(R.id.h5_tv_provider_uclogo);
        this.h5ProviderUc = (TextView) this.contentView.findViewById(R.id.h5_tv_provider_uc);
        this.hDivider = this.contentView.findViewById(R.id.h5_h_divider);
        this.h5Progress = (H5Progress) this.contentView.findViewById(R.id.h5_pb_progress);
        this.h5LoadingView = (H5LoadingView) this.contentView.findViewById(R.id.h5_loading_view);
        this.h5Progress.setNotifier(new H5Progress.ProgressNotifier() {
            public void onProgressBegin() {
                String access$000 = H5WebContentImpl.TAG;
                H5Log.d(access$000, "isShowProgress:" + H5WebContentImpl.this.isShowProgress + " visible:" + H5WebContentImpl.this.h5Progress.getVisibility());
                H5WebContentImpl.this.isShowProgress.set(true);
            }

            public void onProgressEnd() {
                String access$000 = H5WebContentImpl.TAG;
                H5Log.d(access$000, "isShowProgress:" + H5WebContentImpl.this.isShowProgress + " visible:" + H5WebContentImpl.this.h5Progress.getVisibility());
                if (H5WebContentImpl.this.isShowProgress.compareAndSet(true, false) && H5WebContentImpl.this.h5Progress.getVisibility() == 0) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
                    translateAnimation.setDuration(300);
                    H5WebContentImpl.this.h5Progress.startAnimation(translateAnimation);
                    H5WebContentImpl.this.h5Progress.setVisibility(8);
                }
            }
        });
        this.pullContainer = (H5PullContainer) this.contentView.findViewById(R.id.h5_pc_container);
        this.webContent.setBackgroundColor(context.getResources().getColor(R.color.h5_provider));
    }

    public H5PullContainer getPullContainer() {
        H5PullContainer h5PullContainer = this.pullContainer;
        if (h5PullContainer != null) {
            return h5PullContainer;
        }
        return null;
    }

    public H5Progress getProgress() {
        H5Progress h5Progress2 = this.h5Progress;
        if (h5Progress2 != null) {
            return h5Progress2;
        }
        return null;
    }

    public View getContentView() {
        return this.contentView;
    }

    public void setProviderText(String str) {
        this.h5ProviderDomain.setText(str);
    }

    public void setProviderLogo(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.h5ProviderUcLogo.setBackground(drawable);
        } else {
            this.h5ProviderUcLogo.setBackgroundDrawable(drawable);
        }
    }

    public void setProviderUc(String str) {
        this.h5ProviderUc.setText(str);
    }

    public void showProviderVisibility(boolean z) {
        if (z) {
            this.h5ProviderLayout.setVisibility(0);
        } else {
            this.h5ProviderLayout.setVisibility(8);
        }
    }

    public View getHdivider() {
        return this.hDivider;
    }

    public LinearLayout getProviderLayout() {
        return this.h5ProviderLayout;
    }

    public void switchCustomContentBg(int i2, Drawable drawable, boolean z) {
        if (i2 != -16777216) {
            i2 |= -16777216;
        }
        this.webContent.setBackgroundColor(i2);
        this.h5ProviderDomain.setTextColor(-1);
        this.h5ProviderDomain.setAlpha(0.8f);
        if (z) {
            this.h5ProviderUc.setTextColor(-1);
            this.h5ProviderUc.setAlpha(0.8f);
            setProviderLogo(drawable);
        }
    }

    public void swicthDefaultContentBg(Drawable drawable, boolean z) {
        this.webContent.setBackgroundColor(H5Param.DEFAULT_LONG_BOUNCE_TOP_COLOR);
        this.h5ProviderDomain.setTextColor(-6579301);
        this.h5ProviderDomain.setAlpha(1.0f);
        if (z) {
            this.h5ProviderUc.setTextColor(-6579301);
            this.h5ProviderUc.setAlpha(1.0f);
            setProviderLogo(drawable);
        }
    }

    public TextView getH5ProviderDomain() {
        return this.h5ProviderDomain;
    }

    public H5LoadingView getH5LoadingView() {
        return this.h5LoadingView;
    }
}
