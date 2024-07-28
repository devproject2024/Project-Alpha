package com.alipay.mobile.framework.loading;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.Map;

public abstract class LoadingView extends FrameLayout {
    protected Activity hostActivity;
    protected a onCancelListener;

    public interface a {
    }

    public final void cancel() {
    }

    public abstract void onHandleMessage(String str, Map<String, Object> map);

    public abstract void onStart();

    public abstract void onStop();

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setOnCancelListener(a aVar) {
        this.onCancelListener = aVar;
    }

    public void setHostActivity(Activity activity) {
        this.hostActivity = activity;
    }

    public final void start() {
        post(new Runnable() {
            public final void run() {
                try {
                    LoadingView.this.onStart();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void stop() {
        post(new Runnable() {
            public final void run() {
                try {
                    LoadingView.this.onStop();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void sendMessage(final String str, final Map<String, Object> map) {
        post(new Runnable() {
            public final void run() {
                try {
                    LoadingView.this.onHandleMessage(str, map);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void performAnimation(String str, Animator.AnimatorListener animatorListener) {
        throw new IllegalArgumentException(str + " animation not supported.");
    }
}
