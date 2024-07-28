package net.one97.paytm.paymentsBank.download.b.a;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.download.a.a.d;
import net.one97.paytm.paymentsBank.download.activity.DownloadActivity;
import net.one97.paytm.paymentsBank.download.c.b;
import net.one97.paytm.paymentsBank.download.c.c;

public final class a implements net.one97.paytm.paymentsBank.download.b.a {

    /* renamed from: a  reason: collision with root package name */
    private DownloadActivity f18306a;

    /* renamed from: b  reason: collision with root package name */
    private Map<c, View> f18307b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Intent f18308c;

    public a(Object obj, Intent intent) {
        this.f18306a = (DownloadActivity) obj;
        this.f18308c = intent;
    }

    public final void a() {
        this.f18307b.put(c.BACK_IMAGE_VIEW, this.f18306a.findViewById(R.id.iv_back_arrow));
        LinearLayout linearLayout = (LinearLayout) this.f18306a.findViewById(R.id.ll_downloads_type_wrapper);
        ArrayList<net.one97.paytm.paymentsBank.download.c.a> arrayList = new ArrayList<>();
        b bVar = new b();
        bVar.f18310a = this.f18306a.getString(R.string.pb_download_bank_statement);
        bVar.f18311b = c.BANK_ACCOUNT_STATEMENT;
        arrayList.add(bVar);
        b bVar2 = new b();
        bVar2.f18310a = this.f18306a.getString(R.string.pb_download_certificate_of_interest);
        bVar2.f18311b = c.CERTIFICATE_OF_INTEREST;
        arrayList.add(bVar2);
        if (this.f18308c.hasExtra("SHOW_TDS")) {
            b bVar3 = new b();
            bVar3.f18310a = this.f18306a.getString(R.string.pb_download_tds_certificate);
            bVar3.f18311b = c.TDS_CERTIFICATE;
            arrayList.add(bVar3);
        }
        for (net.one97.paytm.paymentsBank.download.c.a aVar : arrayList) {
            View inflate = this.f18306a.getLayoutInflater().inflate(R.layout.download_type_layout, linearLayout, false);
            b bVar4 = (b) aVar;
            ((TextView) inflate.findViewById(R.id.tv_heading)).setText(bVar4.f18310a);
            this.f18307b.put(bVar4.f18311b, inflate);
            linearLayout.addView(inflate);
        }
        b();
    }

    /* renamed from: net.one97.paytm.paymentsBank.download.b.a.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18309a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.paymentsBank.download.c.c[] r0 = net.one97.paytm.paymentsBank.download.c.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18309a = r0
                int[] r0 = f18309a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.paymentsBank.download.c.c r1 = net.one97.paytm.paymentsBank.download.c.c.BACK_IMAGE_VIEW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f18309a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.paymentsBank.download.c.c r1 = net.one97.paytm.paymentsBank.download.c.c.BANK_ACCOUNT_STATEMENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f18309a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.paymentsBank.download.c.c r1 = net.one97.paytm.paymentsBank.download.c.c.CERTIFICATE_OF_INTEREST     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f18309a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.paymentsBank.download.c.c r1 = net.one97.paytm.paymentsBank.download.c.c.TDS_CERTIFICATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.download.b.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    private void b() {
        for (Map.Entry next : this.f18307b.entrySet()) {
            int i2 = AnonymousClass1.f18309a[((c) next.getKey()).ordinal()];
            if (i2 == 1) {
                ((View) next.getValue()).setOnClickListener(new net.one97.paytm.paymentsBank.download.a.a.a(this.f18306a));
            } else if (i2 == 2) {
                ((View) next.getValue()).setOnClickListener(new net.one97.paytm.paymentsBank.download.a.a.b(this.f18306a));
            } else if (i2 == 3) {
                ((View) next.getValue()).setOnClickListener(new net.one97.paytm.paymentsBank.download.a.a.c(this.f18306a));
            } else if (i2 == 4) {
                ((View) next.getValue()).setOnClickListener(new d(this.f18306a));
            }
        }
    }
}
