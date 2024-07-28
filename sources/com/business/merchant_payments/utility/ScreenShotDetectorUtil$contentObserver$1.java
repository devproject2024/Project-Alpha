package com.business.merchant_payments.utility;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.utility.ScreenShotDetectorUtil;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;
import kotlin.m.p;

public final class ScreenShotDetectorUtil$contentObserver$1 extends ContentObserver {
    public String prev = "";
    public final /* synthetic */ ScreenShotDetectorUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenShotDetectorUtil$contentObserver$1(ScreenShotDetectorUtil screenShotDetectorUtil, Handler handler) {
        super(handler);
        this.this$0 = screenShotDetectorUtil;
    }

    public final String getPrev() {
        return this.prev;
    }

    public final void setPrev(String str) {
        k.d(str, "<set-?>");
        this.prev = str;
    }

    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    public final void onChange(boolean z) {
        super.onChange(z);
    }

    public final void onChange(boolean z, Uri uri) {
        String str;
        ScreenShotDetectorUtil.ScreenshotDetectionListener mListener;
        FragmentActivity fragmentActivity;
        super.onChange(z, uri);
        if ((this.prev.length() == 0) || !p.a((CharSequence) String.valueOf(uri), (CharSequence) this.prev, false)) {
            this.prev = String.valueOf(uri);
            if (this.this$0.isReadExternalStoragePermissionGranted()) {
                WeakReference<FragmentActivity> mActivityWeakReference = this.this$0.getMActivityWeakReference();
                if (mActivityWeakReference == null || (fragmentActivity = (FragmentActivity) mActivityWeakReference.get()) == null) {
                    str = null;
                } else {
                    ScreenShotDetectorUtil screenShotDetectorUtil = this.this$0;
                    k.b(fragmentActivity, "it");
                    str = screenShotDetectorUtil.getFilePathFromContentResolver(fragmentActivity, uri);
                }
                if (this.this$0.isScreenshotPath(str) && str != null && (mListener = this.this$0.getMListener()) != null) {
                    mListener.onScreenCaptured(str);
                    return;
                }
                return;
            }
            ScreenShotDetectorUtil.ScreenshotDetectionListener mListener2 = this.this$0.getMListener();
            if (mListener2 != null) {
                mListener2.onScreenCapturedWithDeniedPermission();
            }
        }
    }
}
