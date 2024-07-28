package com.business.merchant_payments.utility;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import java.lang.ref.WeakReference;
import kotlin.g.b.g;

public final class ScreenShotDetectorUtil implements p {
    public static final Companion Companion = new Companion((g) null);
    public static final String FILE_PATH = "screenshots";
    public final ContentObserver contentObserver = new ScreenShotDetectorUtil$contentObserver$1(this, new Handler());
    public WeakReference<FragmentActivity> mActivityWeakReference;
    public ScreenshotDetectionListener mListener;

    public interface ScreenshotDetectionListener {
        void onScreenCaptured(String str);

        void onScreenCapturedWithDeniedPermission();
    }

    public ScreenShotDetectorUtil(FragmentActivity fragmentActivity, ScreenshotDetectionListener screenshotDetectionListener, k kVar) {
        kotlin.g.b.k.d(fragmentActivity, "activity");
        kotlin.g.b.k.d(screenshotDetectionListener, "listener");
        kotlin.g.b.k.d(kVar, "lifecycle");
        kVar.a(this);
        this.mActivityWeakReference = new WeakReference<>(fragmentActivity);
        this.mListener = screenshotDetectionListener;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final WeakReference<FragmentActivity> getMActivityWeakReference() {
        return this.mActivityWeakReference;
    }

    public final void setMActivityWeakReference(WeakReference<FragmentActivity> weakReference) {
        this.mActivityWeakReference = weakReference;
    }

    public final ScreenshotDetectionListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(ScreenshotDetectionListener screenshotDetectionListener) {
        this.mListener = screenshotDetectionListener;
    }

    @aa(a = k.a.ON_RESUME)
    public final void startScreenShotService() {
        FragmentActivity fragmentActivity;
        ContentResolver contentResolver;
        WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
        if (weakReference != null && (fragmentActivity = (FragmentActivity) weakReference.get()) != null && (contentResolver = fragmentActivity.getContentResolver()) != null) {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.contentObserver);
        }
    }

    @aa(a = k.a.ON_PAUSE)
    public final void stopScreenShotService() {
        FragmentActivity fragmentActivity;
        ContentResolver contentResolver;
        WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
        if (weakReference != null && (fragmentActivity = (FragmentActivity) weakReference.get()) != null && (contentResolver = fragmentActivity.getContentResolver()) != null) {
            contentResolver.unregisterContentObserver(this.contentObserver);
        }
    }

    /* access modifiers changed from: private */
    public final String getFilePathFromContentResolver(Context context, Uri uri) {
        Cursor cursor;
        if (uri != null) {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_display_name", "_data"}, (String) null, (String[]) null, (String) null);
            } catch (IllegalStateException unused) {
            }
        } else {
            cursor = null;
        }
        if (cursor != null && cursor.moveToFirst()) {
            String string = cursor.getString(cursor.getColumnIndex("_data"));
            kotlin.g.b.k.b(string, "cursor.getString(cursor.…Store.Images.Media.DATA))");
            cursor.close();
            return string;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final boolean isReadExternalStoragePermissionGranted() {
        WeakReference<FragmentActivity> weakReference = this.mActivityWeakReference;
        FragmentActivity fragmentActivity = weakReference != null ? (FragmentActivity) weakReference.get() : null;
        kotlin.g.b.k.a((Object) fragmentActivity);
        return b.a((Context) fragmentActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* access modifiers changed from: private */
    public final boolean isScreenshotPath(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            kotlin.g.b.k.b(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.m.p.a((CharSequence) lowerCase, (CharSequence) FILE_PATH, false)) {
                return true;
            }
        }
        return false;
    }
}
