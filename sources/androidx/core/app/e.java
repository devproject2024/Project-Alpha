package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.upi.util.UpiConstants;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f2691a;

    public e() {
        this((byte) 0);
    }

    private e(byte b2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2691a = new a();
        } else {
            this.f2691a = new b();
        }
    }

    public static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b(Activity activity) {
            return null;
        }

        b() {
        }
    }

    static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private static HandlerThread f2692e;

        /* renamed from: f  reason: collision with root package name */
        private static Handler f2693f;

        /* renamed from: a  reason: collision with root package name */
        int f2694a = 1;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f2695b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f2696c = new Window.OnFrameMetricsAvailableListener() {
            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                if ((a.this.f2694a & 1) != 0) {
                    a.a(a.this.f2695b[0], frameMetrics.getMetric(8));
                }
                if ((a.this.f2694a & 2) != 0) {
                    a.a(a.this.f2695b[1], frameMetrics.getMetric(1));
                }
                if ((a.this.f2694a & 4) != 0) {
                    a.a(a.this.f2695b[2], frameMetrics.getMetric(3));
                }
                if ((a.this.f2694a & 8) != 0) {
                    a.a(a.this.f2695b[3], frameMetrics.getMetric(4));
                }
                if ((a.this.f2694a & 16) != 0) {
                    a.a(a.this.f2695b[4], frameMetrics.getMetric(5));
                }
                if ((a.this.f2694a & 64) != 0) {
                    a.a(a.this.f2695b[6], frameMetrics.getMetric(7));
                }
                if ((a.this.f2694a & 32) != 0) {
                    a.a(a.this.f2695b[5], frameMetrics.getMetric(6));
                }
                if ((a.this.f2694a & 128) != 0) {
                    a.a(a.this.f2695b[7], frameMetrics.getMetric(0));
                }
                if ((a.this.f2694a & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0) {
                    a.a(a.this.f2695b[8], frameMetrics.getMetric(2));
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<WeakReference<Activity>> f2697d = new ArrayList<>();

        a() {
        }

        static void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }

        public final void a(Activity activity) {
            if (f2692e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f2692e = handlerThread;
                handlerThread.start();
                f2693f = new Handler(f2692e.getLooper());
            }
            for (int i2 = 0; i2 <= 8; i2++) {
                SparseIntArray[] sparseIntArrayArr = this.f2695b;
                if (sparseIntArrayArr[i2] == null && (this.f2694a & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f2696c, f2693f);
            this.f2697d.add(new WeakReference(activity));
        }

        public final SparseIntArray[] b(Activity activity) {
            Iterator<WeakReference<Activity>> it2 = this.f2697d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WeakReference next = it2.next();
                if (next.get() == activity) {
                    this.f2697d.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f2696c);
            return this.f2695b;
        }
    }
}
