package net.one97.paytm.packageScanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.paytm.utility.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;

public final class PackageScanManager {

    /* renamed from: d  reason: collision with root package name */
    public static final a f57023d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public PackageInstallReceiver f57024a;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f57025b = Executors.newSingleThreadExecutor();

    /* renamed from: c  reason: collision with root package name */
    public final Context f57026c;

    public PackageScanManager(Context context) {
        this.f57026c = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final class PackageInstallReceiver extends BroadcastReceiver {
        public PackageInstallReceiver() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            com.paytm.utility.q.d(" package removed " + r4.getData());
            r2.f57027a.a(r3, false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
            com.paytm.utility.q.d("New package installed " + r4.getData());
            r2.f57027a.a(r3, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r3, android.content.Intent r4) {
            /*
                r2 = this;
                if (r4 == 0) goto L_0x0007
                java.lang.String r0 = r4.getAction()
                goto L_0x0008
            L_0x0007:
                r0 = 0
            L_0x0008:
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                int r1 = r0.hashCode()
                switch(r1) {
                    case -1306353155: goto L_0x0049;
                    case 525384130: goto L_0x0025;
                    case 1544582882: goto L_0x001c;
                    case 1580442797: goto L_0x0013;
                    default: goto L_0x0012;
                }
            L_0x0012:
                goto L_0x006c
            L_0x0013:
                java.lang.String r1 = "android.intent.action.PACKAGE_FULLY_REMOVED"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006c
                goto L_0x002d
            L_0x001c:
                java.lang.String r1 = "android.intent.action.PACKAGE_ADDED"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006c
                goto L_0x0051
            L_0x0025:
                java.lang.String r1 = "android.intent.action.PACKAGE_REMOVED"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006c
            L_0x002d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = " package removed "
                r0.<init>(r1)
                android.net.Uri r4 = r4.getData()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                com.paytm.utility.q.d(r4)
                net.one97.paytm.packageScanner.PackageScanManager r4 = net.one97.paytm.packageScanner.PackageScanManager.this
                r0 = 0
                r4.a(r3, r0)
                goto L_0x006c
            L_0x0049:
                java.lang.String r1 = "android.intent.action.INSTALL_PACKAGE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x006c
            L_0x0051:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "New package installed "
                r0.<init>(r1)
                android.net.Uri r4 = r4.getData()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                com.paytm.utility.q.d(r4)
                net.one97.paytm.packageScanner.PackageScanManager r4 = net.one97.paytm.packageScanner.PackageScanManager.this
                r0 = 1
                r4.a(r3, r0)
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.packageScanner.PackageScanManager.PackageInstallReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public final void a(Context context, boolean z) {
        if (d.b() != null) {
            net.one97.paytm.common.b.a b2 = d.b();
            if (b2 == null) {
                k.a();
            }
            boolean b3 = b2.b(context);
            if (d.b().a("should_scan_for_fraud_apps", false) && !b3 && context != null && com.paytm.utility.a.p(context)) {
                q.d("Starting package scan");
                this.f57025b.execute(new a(context, z));
            }
        }
    }

    public final void a() {
        this.f57024a = new PackageInstallReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.INSTALL_PACKAGE");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        Context context = this.f57026c;
        if (context != null) {
            context.registerReceiver(this.f57024a, intentFilter);
        }
    }
}
