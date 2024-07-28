package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public CJRUtilityVariantV2 f63273a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends CJRActiveMetroTicketModel> f63274b;

    /* renamed from: c  reason: collision with root package name */
    public q<? super CJRUtilityVariantV2, ? super List<? extends CJRActiveMetroTicketModel>, ? super Boolean, x> f63275c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63276d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f63277e;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.metro_retur_qr_activate_alert, (ViewGroup) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0059, code lost:
        r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r9, r0)
            super.onViewCreated(r9, r10)
            int r10 = net.one97.paytm.recharge.R.id.actionYes
            android.view.View r10 = r9.findViewById(r10)
            android.widget.Button r10 = (android.widget.Button) r10
            net.one97.paytm.recharge.metro.c.a$a r0 = new net.one97.paytm.recharge.metro.c.a$a
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r10.setOnClickListener(r0)
            int r10 = net.one97.paytm.recharge.R.id.actionNo
            android.view.View r10 = r9.findViewById(r10)
            android.widget.Button r10 = (android.widget.Button) r10
            net.one97.paytm.recharge.metro.c.a$b r0 = new net.one97.paytm.recharge.metro.c.a$b
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r10.setOnClickListener(r0)
            boolean r10 = r8.f63276d
            java.lang.String r0 = "view.desc"
            if (r10 == 0) goto L_0x0053
            android.text.SpannableStringBuilder r10 = new android.text.SpannableStringBuilder
            int r1 = net.one97.paytm.recharge.R.string.metro_return_penalty_ticket_activate
            java.lang.String r1 = r8.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r10.<init>(r1)
            int r1 = net.one97.paytm.recharge.R.id.desc
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r1.setText(r10)
            goto L_0x011f
        L_0x0053:
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r10 = r8.f63274b
            r1 = 0
            r2 = 0
            if (r10 == 0) goto L_0x0066
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            if (r10 == 0) goto L_0x0066
            java.lang.String r10 = r10.getDestination()
            goto L_0x0067
        L_0x0066:
            r10 = r1
        L_0x0067:
            if (r10 == 0) goto L_0x011f
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r10 = r8.f63274b
            if (r10 == 0) goto L_0x007a
            java.lang.Object r10 = r10.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            if (r10 == 0) goto L_0x007a
            java.lang.String r10 = r10.getSource()
            goto L_0x007b
        L_0x007a:
            r10 = r1
        L_0x007b:
            if (r10 == 0) goto L_0x011f
            android.text.SpannableStringBuilder r10 = new android.text.SpannableStringBuilder
            int r3 = net.one97.paytm.recharge.R.string.metro_return_activate
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r5 = r8.f63274b
            if (r5 == 0) goto L_0x0095
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = r5.getDestination()
            goto L_0x0096
        L_0x0095:
            r5 = r1
        L_0x0096:
            r4[r2] = r5
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r5 = r8.f63274b
            if (r5 == 0) goto L_0x00a9
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            if (r5 == 0) goto L_0x00a9
            java.lang.String r5 = r5.getSource()
            goto L_0x00aa
        L_0x00a9:
            r5 = r1
        L_0x00aa:
            r6 = 1
            r4[r6] = r5
            java.lang.String r3 = r8.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r10.<init>(r3)
            r3 = r10
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r4 = r8.f63274b
            if (r4 == 0) goto L_0x00ca
            java.lang.Object r4 = r4.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            if (r4 == 0) goto L_0x00ca
            java.lang.String r4 = r4.getDestination()
            goto L_0x00cb
        L_0x00ca:
            r4 = r1
        L_0x00cb:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5 = 6
            int r4 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String) r4, (int) r2, (boolean) r2, (int) r5)
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r5 = r8.f63274b
            if (r5 == 0) goto L_0x00e5
            java.lang.Object r5 = r5.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            if (r5 == 0) goto L_0x00e5
            java.lang.String r5 = r5.getSource()
            goto L_0x00e6
        L_0x00e5:
            r5 = r1
        L_0x00e6:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r5 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String) r5, kotlin.m.p.d(r3))
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r7 = r8.f63274b
            if (r7 == 0) goto L_0x00fe
            java.lang.Object r2 = r7.get(r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r2 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r2
            if (r2 == 0) goto L_0x00fe
            java.lang.String r1 = r2.getSource()
        L_0x00fe:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r1 = r1.length()
            int r5 = r5 + r1
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r1.<init>(r6)
            r2 = 33
            r10.setSpan(r1, r4, r5, r2)
            int r10 = net.one97.paytm.recharge.R.id.desc
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
            r10.setText(r3)
        L_0x011f:
            int r10 = net.one97.paytm.recharge.R.id.close
            android.view.View r9 = r9.findViewById(r10)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0133
            net.one97.paytm.recharge.metro.c.a$c r10 = new net.one97.paytm.recharge.metro.c.a$c
            r10.<init>(r8)
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r9.setOnClickListener(r10)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* renamed from: net.one97.paytm.recharge.metro.c.a$a  reason: collision with other inner class name */
    static final class C1223a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63278a;

        C1223a(a aVar) {
            this.f63278a = aVar;
        }

        public final void onClick(View view) {
            q c2;
            if (this.f63278a.f63273a != null && this.f63278a.f63274b != null && (c2 = this.f63278a.f63275c) != null) {
                CJRUtilityVariantV2 a2 = this.f63278a.f63273a;
                if (a2 == null) {
                    k.a();
                }
                List b2 = this.f63278a.f63274b;
                if (b2 == null) {
                    k.a();
                }
                c2.invoke(a2, b2, Boolean.TRUE);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63279a;

        b(a aVar) {
            this.f63279a = aVar;
        }

        public final void onClick(View view) {
            q c2;
            if (this.f63279a.f63273a != null && this.f63279a.f63274b != null && (c2 = this.f63279a.f63275c) != null) {
                CJRUtilityVariantV2 a2 = this.f63279a.f63273a;
                if (a2 == null) {
                    k.a();
                }
                List b2 = this.f63279a.f63274b;
                if (b2 == null) {
                    k.a();
                }
                c2.invoke(a2, b2, Boolean.FALSE);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63280a;

        c(a aVar) {
            this.f63280a = aVar;
        }

        public final void onClick(View view) {
            this.f63280a.dismiss();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent != null) {
            View view2 = (View) parent;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            view2.setBackgroundColor(androidx.core.content.b.c(context, 17170445));
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f63277e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
