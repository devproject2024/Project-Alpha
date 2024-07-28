package net.one97.paytm.payments.visascp.customAsync;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.payments.visascp.util.Logger;
import net.one97.paytm.payments.visascp.util.VisaSCPConstants;

public class CustomThreadPoolExecutorManager {
    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static CustomThreadPoolExecutorManager f552 = null;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f553 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f554 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Handler f555;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ExecutorService f556;

    static {
        int i2 = f553;
        int i3 = (i2 & -70) | ((~i2) & 69);
        int i4 = (i2 & 69) << 1;
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f554 = i5 % 128;
        if (i5 % 2 == 0) {
        }
    }

    private CustomThreadPoolExecutorManager() {
        int i2 = NUMBER_OF_CORES;
        this.f556 = new ThreadPoolExecutor(i2 << 1, i2 << 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
        f555 = new Handler(Looper.getMainLooper());
    }

    public static CustomThreadPoolExecutorManager getsInstance() {
        if (f552 == null) {
            synchronized (CustomThreadPoolExecutorManager.class) {
                if (f552 == null) {
                    f552 = new CustomThreadPoolExecutorManager();
                }
            }
        }
        return f552;
    }

    public ExecutorService getExecutorService() {
        int i2 = f553;
        int i3 = (i2 & 28) + (i2 | 28);
        int i4 = (i3 & -1) + (i3 | -1);
        f554 = i4 % 128;
        int i5 = i4 % 2;
        ExecutorService executorService = this.f556;
        int i6 = f553;
        int i7 = i6 & 115;
        int i8 = i6 | 115;
        int i9 = (i7 ^ i8) + ((i8 & i7) << 1);
        f554 = i9 % 128;
        if (i9 % 2 != 0) {
        }
        return executorService;
    }

    public void onErrorResponse(final Response.ErrorListener errorListener, final VolleyError volleyError) {
        postOnUIThread(new Runnable() {

            /* renamed from: ˎ  reason: contains not printable characters */
            private static int f557 = 0;

            /* renamed from: ˏ  reason: contains not printable characters */
            private static int f558 = 1;

            public final void run() {
                int i2 = f558 + 80;
                int i3 = ((i2 | -1) << 1) - (~i2);
                f557 = i3 % 128;
                int i4 = i3 % 2;
                Response.ErrorListener.this.onErrorResponse(volleyError);
                int i5 = f558;
                int i6 = (((i5 & 28) + (i5 | 28)) + 0) - 1;
                f557 = i6 % 128;
                int i7 = i6 % 2;
            }
        });
        int i2 = f553;
        int i3 = i2 & 85;
        int i4 = -(-((i2 ^ 85) | i3));
        int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
        f554 = i5 % 128;
        int i6 = i5 % 2;
    }

    public void postOnUIThread(Runnable runnable) {
        int i2 = f553;
        int i3 = (i2 ^ 49) + ((i2 & 49) << 1);
        f554 = i3 % 128;
        if (i3 % 2 != 0) {
        }
        f555.post(runnable);
        int i4 = f553;
        int i5 = i4 & 27;
        int i6 = (i4 | 27) & (~i5);
        int i7 = i5 << 1;
        int i8 = ((i6 | i7) << 1) - (i6 ^ i7);
        f554 = i8 % 128;
        int i9 = i8 % 2;
    }

    public <T> void executeAsyncTask(CustomCallable<T> customCallable) {
        try {
            customCallable.onPreExecuteData();
            this.f556.submit(new BackgroundTask(f555, customCallable));
            int i2 = f554;
            int i3 = i2 & 27;
            int i4 = (i3 - (~((i2 ^ 27) | i3))) - 1;
            f553 = i4 % 128;
            if (i4 % 2 != 0) {
            }
        } catch (Exception e2) {
            Logger.e(VisaSCPConstants.LOG_TAG, VisaSCPConstants.EXCEPTION_MESSAGE, e2);
        }
    }

    public static class BackgroundTask<T> implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static int f561 = 1;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static int f562;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final CustomCallable<T> f563;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Handler f564;

        public BackgroundTask(Handler handler, CustomCallable<T> customCallable) {
            this.f564 = handler;
            this.f563 = customCallable;
        }

        public void run() {
            try {
                this.f564.post(new MainThreadTaskHandler(this.f563, this.f563.call()));
                int i2 = f562;
                int i3 = i2 & 69;
                int i4 = (i2 ^ 69) | i3;
                int i5 = (i3 ^ i4) + ((i4 & i3) << 1);
                f561 = i5 % 128;
                if (i5 % 2 == 0) {
                }
            } catch (Exception e2) {
                Logger.e(VisaSCPConstants.LOG_TAG, VisaSCPConstants.EXCEPTION_MESSAGE, e2);
            }
        }
    }

    public static class MainThreadTaskHandler<T> implements Runnable {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static int f565 = 0;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f566 = 1;

        /* renamed from: ˊ  reason: contains not printable characters */
        private CustomCallable<T> f567;

        /* renamed from: ॱ  reason: contains not printable characters */
        private T f568;

        public MainThreadTaskHandler(CustomCallable<T> customCallable, T t) {
            this.f567 = customCallable;
            this.f568 = t;
        }

        public void run() {
            int i2 = f566;
            int i3 = i2 & 41;
            int i4 = ((((i2 ^ 41) | i3) << 1) - (~(-((i2 | 41) & (~i3))))) - 1;
            f565 = i4 % 128;
            int i5 = i4 % 2;
            this.f567.onPostExecuteData(this.f568);
            int i6 = f565;
            int i7 = (((i6 & 16) + (i6 | 16)) - 0) - 1;
            f566 = i7 % 128;
            if (i7 % 2 == 0) {
            }
        }
    }
}
