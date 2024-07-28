package net.one97.paytm.p2mNewDesign.models;

import java.util.Calendar;
import net.one97.paytm.fastscanner.c.a;
import net.one97.paytm.wallet.communicator.c;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f56925c = true;

    /* renamed from: e  reason: collision with root package name */
    private static b f56926e;

    /* renamed from: a  reason: collision with root package name */
    public QrData f56927a = new QrData();

    /* renamed from: b  reason: collision with root package name */
    public Long f56928b;

    /* renamed from: d  reason: collision with root package name */
    private String f56929d = getClass().getName();

    /* renamed from: f  reason: collision with root package name */
    private Long f56930f;

    /* renamed from: g  reason: collision with root package name */
    private Long f56931g;

    /* renamed from: h  reason: collision with root package name */
    private Long f56932h;

    /* renamed from: i  reason: collision with root package name */
    private Long f56933i;

    public static void a() {
        f56925c = false;
    }

    public static boolean b() {
        return f56925c;
    }

    private b() {
    }

    public static b c() {
        if (f56926e == null) {
            f56926e = new b();
        }
        return f56926e;
    }

    public final void a(String str) {
        if (this.f56927a.getTrigger_point() == null) {
            getClass().getName();
            f56925c = true;
            this.f56930f = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            this.f56927a.setTrigger_point(str);
        }
        new StringBuilder("setTriggerPoint_qrData=").append(this.f56927a);
    }

    public final void d() {
        if (this.f56927a.getTrigger_point() != null && this.f56927a.getScanClick_firstFrame() == null && this.f56930f != null) {
            this.f56931g = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            Long valueOf = Long.valueOf(this.f56931g.longValue() - this.f56930f.longValue());
            new StringBuilder("scanClick_firstFrame=").append(valueOf);
            this.f56927a.setScanClick_firstFrame(valueOf);
        }
    }

    public final void e() {
        if (this.f56927a.getTrigger_point() != null && this.f56927a.getFirstFrame_QrFound() == null && this.f56931g != null) {
            this.f56932h = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            Long valueOf = Long.valueOf(this.f56932h.longValue() - this.f56931g.longValue());
            new StringBuilder("firstFrame_QrFound=").append(valueOf);
            this.f56927a.setFirstFrame_QrFound(valueOf);
        }
    }

    public final void a(String str, int i2, String str2) {
        if (this.f56927a.getTrigger_point() != null && this.f56927a.getQrFound_qrResolution() == null && this.f56932h != null) {
            this.f56933i = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            Long valueOf = Long.valueOf(this.f56933i.longValue() - this.f56932h.longValue());
            new StringBuilder("qrFound_qrResolution=").append(valueOf);
            this.f56927a.setQrFound_qrResolution(valueOf);
            this.f56927a.setQrPayload(str);
            this.f56927a.setScannedCount(String.valueOf(i2));
            this.f56927a.setScanSessionId(str2);
        }
    }

    public final void f() {
        this.f56928b = Long.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public final void g() {
        if (this.f56927a.getTrigger_point() != null && this.f56927a.getQrResolution_enterAmount() == null && this.f56933i != null) {
            Long valueOf = Long.valueOf(Calendar.getInstance().getTimeInMillis());
            Long valueOf2 = Long.valueOf(valueOf.longValue() - this.f56933i.longValue());
            new StringBuilder("qrResolution_enterAmount=").append(valueOf2);
            this.f56927a.setQrResolution_enterAmount(valueOf2);
            Long valueOf3 = Long.valueOf((valueOf.longValue() - this.f56930f.longValue()) - this.f56927a.getFirstFrame_QrFound().longValue());
            new StringBuilder("scanClick_enterAmount=").append(valueOf3);
            this.f56927a.setScanClick_enterAmount(valueOf3);
        }
    }

    public final void b(String str) {
        if (this.f56927a.getTrigger_point() != null) {
            f56925c = false;
            QrData qrData = this.f56927a;
            a aVar = a.f50448b;
            qrData.setZxing_falied_attempts(a.d());
            QrData qrData2 = this.f56927a;
            a aVar2 = a.f50448b;
            qrData2.setFirebase_failed_attempts(a.f());
            this.f56927a.setAction(str);
            if (this.f56927a.getFirstFrame_QrFound() == null && this.f56931g != null) {
                e();
            } else if (this.f56927a.getQrResolution_enterAmount() == null && this.f56933i != null) {
                g();
            }
            new StringBuilder("QrScanSessionLogger_recordTraceOnHawkeye_qrData=").append(this.f56927a);
            c a2 = net.one97.paytm.wallet.communicator.b.a();
            net.one97.paytm.wallet.a.a aVar3 = net.one97.paytm.wallet.a.a.f69839a;
            a2.pushScanSessionHawkeyeEvent(net.one97.paytm.wallet.a.a.a(), this.f56927a);
            a aVar4 = a.f50448b;
            a.a(false);
            a aVar5 = a.f50448b;
            a.e();
            a aVar6 = a.f50448b;
            a.g();
            f56926e = null;
        }
    }

    public static void h() {
        f56926e = null;
    }
}
