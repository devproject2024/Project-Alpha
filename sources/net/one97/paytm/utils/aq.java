package net.one97.paytm.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.os.Handler;
import com.paytm.utility.q;
import net.one97.paytm.wallet.communicator.b;

public class aq {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String f69651e = aq.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Handler f69652a;

    /* renamed from: b  reason: collision with root package name */
    public a f69653b;

    /* renamed from: c  reason: collision with root package name */
    int f69654c;

    /* renamed from: d  reason: collision with root package name */
    double f69655d;

    public interface a {
        void d(boolean z);

        void f();
    }

    public final void a(final Context context, a aVar) {
        boolean booleanFromGTM = b.a().getBooleanFromGTM(context, "shouldDetectNetwork", false);
        final int integerFromGTM = b.a().getIntegerFromGTM(context, "qrInfoNetworkTimeout");
        if (booleanFromGTM && !a(context)) {
            this.f69655d = 0.0d;
            this.f69653b = aVar;
            this.f69652a = new Handler();
            this.f69654c = integerFromGTM + 1;
            final double[] dArr = new double[1];
            this.f69652a.postDelayed(new Runnable() {
                public final void run() {
                    if (aq.this.f69654c >= 0) {
                        double mobileTxBytes = (double) TrafficStats.getMobileTxBytes();
                        double d2 = mobileTxBytes - dArr[0];
                        String unused = aq.f69651e;
                        q.b("Bytes Transmitted : ".concat(String.valueOf(d2)));
                        String unused2 = aq.f69651e;
                        q.b("Timer value : " + aq.this.f69654c);
                        dArr[0] = mobileTxBytes;
                        if (aq.this.f69654c <= integerFromGTM) {
                            String unused3 = aq.f69651e;
                            q.b("Adding to total : " + aq.this.f69654c);
                            aq aqVar = aq.this;
                            aqVar.f69655d = aqVar.f69655d + d2;
                        }
                        aq aqVar2 = aq.this;
                        aqVar2.f69654c--;
                        int i2 = integerFromGTM / 2;
                        if (aq.this.f69654c == i2) {
                            String unused4 = aq.f69651e;
                            q.b("iterations over");
                            if (aq.this.f69653b != null) {
                                aq.this.f69653b.d(aq.a(aq.this.f69655d, context, i2));
                            }
                        }
                        if (aq.this.f69654c == 0) {
                            String unused5 = aq.f69651e;
                            q.b("exiting from loop");
                            if (aq.this.f69653b != null) {
                                aq.this.f69653b.f();
                                return;
                            }
                            return;
                        }
                        aq.this.f69652a.postDelayed(this, 1000);
                    }
                }
            }, 1000);
        }
    }

    private static boolean a(Context context) {
        if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean a(double d2, Context context, int i2) {
        double d3 = d2 / ((double) i2);
        q.b("Average Transmission : ".concat(String.valueOf(d3)));
        return d3 > ((double) b.a().getIntegerFromGTM(context, "speedThresholdBytesPerSecond"));
    }
}
