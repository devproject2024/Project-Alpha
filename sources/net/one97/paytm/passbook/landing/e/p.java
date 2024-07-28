package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;

public final class p extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<CJRPaytmMoneyInfoV2> f57671a;

    public p(f<CJRPaytmMoneyInfoV2> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57671a = fVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f57672a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57673b;

        public a(p pVar, net.one97.paytm.passbook.landing.f.a aVar) {
            this.f57672a = pVar;
            this.f57673b = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            r9 = r9.getDataInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                android.content.Context r1 = r9.getContext()
                java.lang.String r2 = "uth_passbook"
                java.lang.String r3 = "Paytm_money_clicked"
                java.lang.String r4 = "open_account"
                r5 = 0
                java.lang.String r6 = "/uth_passbook_myaccounts"
                java.lang.String r7 = "PASSBOOK"
                net.one97.paytm.passbook.utility.q.a(r1, r2, r3, r4, r5, r6, r7)
                net.one97.paytm.passbook.landing.e.p r9 = r8.f57672a
                net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r9 = r9.f57671a
                if (r9 == 0) goto L_0x0036
                T r9 = r9.f57887b
                net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r9 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r9
                if (r9 == 0) goto L_0x0036
                net.one97.paytm.passbook.beans.DataInfo r9 = r9.getDataInfo()
                if (r9 == 0) goto L_0x0036
                net.one97.paytm.passbook.beans.MFAndNpsItems r9 = r9.getMutualFunds()
                if (r9 == 0) goto L_0x0036
                java.lang.String r9 = r9.getDeeplink()
                if (r9 != 0) goto L_0x004c
            L_0x0036:
                net.one97.paytm.passbook.landing.e.p r9 = r8.f57672a
                net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r9 = r9.f57671a
                T r9 = r9.f57887b
                net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r9 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r9
                if (r9 == 0) goto L_0x004b
                net.one97.paytm.passbook.beans.DataInfo r9 = r9.getDataInfo()
                if (r9 == 0) goto L_0x004b
                java.lang.String r9 = r9.getDeeplink()
                goto L_0x004c
            L_0x004b:
                r9 = 0
            L_0x004c:
                net.one97.paytm.passbook.landing.f.a r0 = r8.f57673b
                net.one97.paytm.passbook.main.widget.InitCards r0 = r0.p()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "balanceSummaryUIHandler.…utualFundInitCard.context"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.passbook.landing.e.p.a((java.lang.String) r9, (android.content.Context) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.p.a.onClick(android.view.View):void");
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f57674a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57675b;

        public b(p pVar, net.one97.paytm.passbook.landing.f.a aVar) {
            this.f57674a = pVar;
            this.f57675b = aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            r9 = r9.getDataInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                android.content.Context r1 = r9.getContext()
                java.lang.String r2 = "uth_passbook"
                java.lang.String r3 = "Paytm_money_clicked"
                java.lang.String r4 = "open_account"
                r5 = 0
                java.lang.String r6 = "/uth_passbook_myaccounts"
                java.lang.String r7 = "PASSBOOK"
                net.one97.paytm.passbook.utility.q.a(r1, r2, r3, r4, r5, r6, r7)
                net.one97.paytm.passbook.landing.e.p r9 = r8.f57674a
                net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r9 = r9.f57671a
                if (r9 == 0) goto L_0x0036
                T r9 = r9.f57887b
                net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r9 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r9
                if (r9 == 0) goto L_0x0036
                net.one97.paytm.passbook.beans.DataInfo r9 = r9.getDataInfo()
                if (r9 == 0) goto L_0x0036
                net.one97.paytm.passbook.beans.MFAndNpsItems r9 = r9.getNps()
                if (r9 == 0) goto L_0x0036
                java.lang.String r9 = r9.getDeeplink()
                if (r9 != 0) goto L_0x004c
            L_0x0036:
                net.one97.paytm.passbook.landing.e.p r9 = r8.f57674a
                net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r9 = r9.f57671a
                T r9 = r9.f57887b
                net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r9 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r9
                if (r9 == 0) goto L_0x004b
                net.one97.paytm.passbook.beans.DataInfo r9 = r9.getDataInfo()
                if (r9 == 0) goto L_0x004b
                java.lang.String r9 = r9.getDeeplink()
                goto L_0x004c
            L_0x004b:
                r9 = 0
            L_0x004c:
                net.one97.paytm.passbook.landing.f.a r0 = r8.f57675b
                net.one97.paytm.passbook.main.widget.InitCards r0 = r0.p()
                android.content.Context r0 = r0.getContext()
                java.lang.String r1 = "balanceSummaryUIHandler.…utualFundInitCard.context"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.passbook.landing.e.p.a((java.lang.String) r9, (android.content.Context) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.p.b.onClick(android.view.View):void");
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f57681a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f57682b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57683c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRPaytmMoneyInfoV2 f57684d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LinearLayout f57685e;

        public d(String str, p pVar, net.one97.paytm.passbook.landing.f.a aVar, CJRPaytmMoneyInfoV2 cJRPaytmMoneyInfoV2, LinearLayout linearLayout) {
            this.f57681a = str;
            this.f57682b = pVar;
            this.f57683c = aVar;
            this.f57684d = cJRPaytmMoneyInfoV2;
            this.f57685e = linearLayout;
        }

        public final void onClick(View view) {
            String str = this.f57681a;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            p.a(str, context);
            q.a(view.getContext(), "uth_passbook", "Paytm_money_NPS_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f57676a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f57677b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57678c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRPaytmMoneyInfoV2 f57679d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LinearLayout f57680e;

        public c(String str, p pVar, net.one97.paytm.passbook.landing.f.a aVar, CJRPaytmMoneyInfoV2 cJRPaytmMoneyInfoV2, LinearLayout linearLayout) {
            this.f57676a = str;
            this.f57677b = pVar;
            this.f57678c = aVar;
            this.f57679d = cJRPaytmMoneyInfoV2;
            this.f57680e = linearLayout;
        }

        public final void onClick(View view) {
            String str = this.f57676a;
            k.a((Object) view, "it");
            Context context = view.getContext();
            k.a((Object) context, "it.context");
            p.a(str, context);
            q.a(view.getContext(), "uth_passbook", "Paytm_money_MF_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static void a(PassbookBalanceCardView passbookBalanceCardView, PassbookBalanceCardView passbookBalanceCardView2) {
        if (passbookBalanceCardView != null) {
            passbookBalanceCardView.a();
        }
        if (passbookBalanceCardView2 != null) {
            passbookBalanceCardView2.a();
        }
    }

    public static final /* synthetic */ void a(String str, Context context) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (kotlin.m.p.b(str, "http", false)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    context.startActivity(intent);
                    return;
                }
                net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                if (context != null) {
                    b2.a(str, (Activity) context);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            } catch (Exception e2) {
                l.a((Throwable) e2);
            }
        }
    }
}
