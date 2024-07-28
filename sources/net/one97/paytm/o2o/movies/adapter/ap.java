package net.one97.paytm.o2o.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.entity.CJRCPSlabItem;

public final class ap extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    final List<CJRCPSlabItem> f74448a;

    public ap(List<CJRCPSlabItem> list) {
        k.c(list, "list");
        this.f74448a = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0095, code lost:
        r1 = r1.getLabel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r6, int r7) {
        /*
            r5 = this;
            net.one97.paytm.o2o.movies.adapter.ap$a r6 = (net.one97.paytm.o2o.movies.adapter.ap.a) r6
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.o2o.movies.adapter.ap r0 = r6.f74454f
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCPSlabItem> r0 = r0.f74448a
            int r0 = r0.size()
            java.lang.String r1 = "botttomDivider"
            r2 = 0
            java.lang.String r3 = "topDivider"
            r4 = 1
            if (r0 <= r4) goto L_0x0058
            if (r7 != 0) goto L_0x002b
            android.view.View r0 = r6.f74452d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r2)
            android.view.View r0 = r6.f74453e
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r4)
            goto L_0x0068
        L_0x002b:
            net.one97.paytm.o2o.movies.adapter.ap r0 = r6.f74454f
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCPSlabItem> r0 = r0.f74448a
            int r0 = r0.size()
            int r0 = r0 - r4
            if (r7 != r0) goto L_0x0047
            android.view.View r0 = r6.f74452d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r4)
            android.view.View r0 = r6.f74453e
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r2)
            goto L_0x0068
        L_0x0047:
            android.view.View r0 = r6.f74452d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r4)
            android.view.View r0 = r6.f74453e
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r4)
            goto L_0x0068
        L_0x0058:
            android.view.View r0 = r6.f74452d
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r2)
            android.view.View r0 = r6.f74453e
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.common.a.e.a(r0, r2)
        L_0x0068:
            net.one97.paytm.o2o.movies.adapter.ap r0 = r6.f74454f
            java.util.List<net.one97.paytm.o2o.movies.entity.CJRCPSlabItem> r0 = r0.f74448a
            java.lang.Object r7 = kotlin.a.k.a(r0, (int) r7)
            net.one97.paytm.o2o.movies.entity.CJRCPSlabItem r7 = (net.one97.paytm.o2o.movies.entity.CJRCPSlabItem) r7
            if (r7 == 0) goto L_0x00c1
            com.paytm.utility.RoboTextView r0 = r6.f74449a
            java.lang.String r1 = "txtMain"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r1 = r7.getDisplay_string()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.paytm.utility.RoboTextView r0 = r6.f74450b
            java.lang.String r1 = "txtSecTitle"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.entity.CJRCPRefund r1 = r7.getRefund()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x009e
            java.lang.String r1 = r1.getLabel()
            if (r1 == 0) goto L_0x009e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x00a1
        L_0x009e:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x00a1:
            r0.setText(r1)
            com.paytm.utility.RoboTextView r6 = r6.f74451c
            java.lang.String r0 = "txtSecDesc"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            net.one97.paytm.o2o.movies.entity.CJRCPRefund r7 = r7.getRefund()
            if (r7 == 0) goto L_0x00bb
            java.lang.String r7 = r7.getDesc()
            if (r7 == 0) goto L_0x00bb
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            goto L_0x00be
        L_0x00bb:
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
        L_0x00be:
            r6.setText(r7)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.ap.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_cp_slab, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…h_cp_slab, parent, false)");
        return new a(this, inflate);
    }

    public final int getItemCount() {
        return this.f74448a.size();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final RoboTextView f74449a;

        /* renamed from: b  reason: collision with root package name */
        final RoboTextView f74450b;

        /* renamed from: c  reason: collision with root package name */
        final RoboTextView f74451c;

        /* renamed from: d  reason: collision with root package name */
        final View f74452d;

        /* renamed from: e  reason: collision with root package name */
        final View f74453e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ap f74454f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ap apVar, View view) {
            super(view);
            k.c(view, "view");
            this.f74454f = apVar;
            this.f74449a = (RoboTextView) view.findViewById(R.id.txt_main);
            this.f74450b = (RoboTextView) view.findViewById(R.id.txt_sec_title);
            this.f74451c = (RoboTextView) view.findViewById(R.id.txt_sec_desc);
            this.f74452d = view.findViewById(R.id.divider_top);
            this.f74453e = view.findViewById(R.id.divider_bottom);
        }
    }
}
