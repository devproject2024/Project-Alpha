package com.alipay.mobile.nebulacore.util;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.ArrayList;
import java.util.List;

public class H5ScreenShotObserver {
    /* access modifiers changed from: private */
    public static final String EXTERNAL_CONTENT_URI_MATCHER = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    /* access modifiers changed from: private */
    public static final String[] PROJECTION = {"_data", "date_added"};
    private static final String SORT_ORDER = "date_added DESC";
    private static final String TAG = "H5ScreenShotObserver";
    /* access modifiers changed from: private */
    public H5ScreenShotListener mCommonListener;
    private final ContentObserver mContentObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
        public void onChange(boolean z) {
            H5Log.d(H5ScreenShotObserver.TAG, "old onChange ".concat(String.valueOf(z)));
            try {
                super.onChange(z);
                onChange(z, (Uri) null);
            } catch (Throwable th) {
                H5Log.e(H5ScreenShotObserver.TAG, th);
            }
        }

        /* access modifiers changed from: package-private */
        public Cursor query(Uri uri) {
            if (uri == null) {
                return H5ScreenShotObserver.this.mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, H5ScreenShotObserver.PROJECTION, (String) null, (String[]) null, H5ScreenShotObserver.SORT_ORDER);
            }
            if (!uri.toString().contains(H5ScreenShotObserver.EXTERNAL_CONTENT_URI_MATCHER)) {
                return null;
            }
            return H5ScreenShotObserver.this.mContext.getContentResolver().query(uri, H5ScreenShotObserver.PROJECTION, (String) null, (String[]) null, H5ScreenShotObserver.SORT_ORDER);
        }

        public void onChange(boolean z, Uri uri) {
            try {
                H5Log.d(H5ScreenShotObserver.TAG, "new onChange " + z + ", uri " + uri);
                if (H5ScreenShotObserver.this.mContext == null) {
                    H5Log.w(H5ScreenShotObserver.TAG, "new onChange mContext == null");
                    return;
                }
                Cursor query = query(uri);
                if (query != null) {
                    if (!query.moveToFirst()) {
                        query.close();
                        return;
                    }
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (Math.abs((System.currentTimeMillis() / 1000) - query.getLong(query.getColumnIndex("date_added"))) <= 10 && !TextUtils.isEmpty(string) && string.toLowerCase().contains("screenshot")) {
                        H5Log.d(H5ScreenShotObserver.TAG, "onScreenShot, listeners: " + H5ScreenShotObserver.this.mListener.size() + ", path: " + string);
                        if (H5ScreenShotObserver.this.mCommonListener != null) {
                            H5ScreenShotObserver.this.mCommonListener.onScreenShot();
                        }
                        if (H5ScreenShotObserver.this.mListener.size() > 0) {
                            for (H5ScreenShotListener onScreenShot : H5ScreenShotObserver.this.mListener) {
                                onScreenShot.onScreenShot();
                            }
                        }
                    }
                    query.close();
                }
            } catch (Throwable th) {
                H5Log.e(H5ScreenShotObserver.TAG, th);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public final List<H5ScreenShotListener> mListener = new ArrayList();

    public interface H5ScreenShotListener {
        void onScreenShot();
    }

    public H5ScreenShotObserver(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            H5Log.d(TAG, "registerContentObserver");
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.mContentObserver);
        }
    }

    public void setCommonListener(H5ScreenShotListener h5ScreenShotListener) {
        this.mCommonListener = h5ScreenShotListener;
    }

    public void registerListener(H5ScreenShotListener h5ScreenShotListener) {
        this.mListener.add(h5ScreenShotListener);
    }

    public void release() {
        this.mListener.clear();
        if (this.mContext != null) {
            H5Log.d(TAG, "unregisterContentObserver");
            this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
        }
        this.mContext = null;
    }
}
