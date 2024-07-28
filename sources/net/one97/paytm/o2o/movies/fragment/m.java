package net.one97.paytm.o2o.movies.fragment;

import java.util.HashMap;

public class m extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f75399a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f75400b;

    /* JADX WARNING: type inference failed for: r11v83, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            r9 = this;
            java.lang.String r11 = "inflater"
            kotlin.g.b.k.c(r10, r11)
            int r11 = net.one97.paytm.o2o.movies.R.layout.fragment_critic_review_detail
            r12 = 0
            r0 = 0
            android.view.View r10 = r10.inflate(r11, r12, r0)
            android.os.Bundle r11 = r9.getArguments()
            if (r11 == 0) goto L_0x001c
            java.lang.String r12 = "reviewItem"
            android.os.Parcelable r11 = r11.getParcelable(r12)
            r12 = r11
            net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem r12 = (net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem) r12
        L_0x001c:
            java.lang.String r11 = "view"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtValueRating
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r1 = "view.txtValueRating"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            r2 = 8
            r11.setVisibility(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtReview
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r3 = "view.txtReview"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            r11.setVisibility(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.tvReviewer
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r4 = "view.tvReviewer"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            r11.setVisibility(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.tvDate
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r5 = "view.tvDate"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setVisibility(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.ivRatingStar
            android.view.View r11 = r10.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            java.lang.String r6 = "view.ivRatingStar"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)
            r11.setVisibility(r2)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtLabelRating
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r7 = "view.txtLabelRating"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            r11.setVisibility(r2)
            if (r12 == 0) goto L_0x01a6
            java.lang.String r11 = r12.f74230d
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2 = 1
            if (r11 == 0) goto L_0x0095
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r11 = 0
            goto L_0x0096
        L_0x0095:
            r11 = 1
        L_0x0096:
            if (r11 != 0) goto L_0x00d4
            int r11 = net.one97.paytm.o2o.movies.R.id.txtValueRating
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            java.lang.String r8 = r12.f74230d
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r11.setText(r8)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtLabelRating
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            r11.setVisibility(r0)
            int r11 = net.one97.paytm.o2o.movies.R.id.ivRatingStar
            android.view.View r11 = r10.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)
            r11.setVisibility(r0)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtValueRating
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            r11.setVisibility(r0)
        L_0x00d4:
            java.lang.String r11 = r12.f74231e
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x00e3
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x00e1
            goto L_0x00e3
        L_0x00e1:
            r11 = 0
            goto L_0x00e4
        L_0x00e3:
            r11 = 1
        L_0x00e4:
            if (r11 != 0) goto L_0x0106
            int r11 = net.one97.paytm.o2o.movies.R.id.txtReview
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            java.lang.String r1 = r12.f74231e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
            int r11 = net.one97.paytm.o2o.movies.R.id.txtReview
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            r11.setVisibility(r0)
        L_0x0106:
            java.lang.String r11 = r12.f74229c
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x0115
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x0113
            goto L_0x0115
        L_0x0113:
            r11 = 0
            goto L_0x0116
        L_0x0115:
            r11 = 1
        L_0x0116:
            if (r11 != 0) goto L_0x016e
            java.lang.String r11 = r12.f74232f
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x0127
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x0125
            goto L_0x0127
        L_0x0125:
            r11 = 0
            goto L_0x0128
        L_0x0127:
            r11 = 1
        L_0x0128:
            if (r11 != 0) goto L_0x014e
            int r11 = net.one97.paytm.o2o.movies.R.id.tvReviewer
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r12.f74229c
            r1.append(r3)
            java.lang.String r3 = ", "
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
            goto L_0x0160
        L_0x014e:
            int r11 = net.one97.paytm.o2o.movies.R.id.tvReviewer
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            java.lang.String r1 = r12.f74229c
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
        L_0x0160:
            int r11 = net.one97.paytm.o2o.movies.R.id.tvReviewer
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            r11.setVisibility(r0)
        L_0x016e:
            java.lang.String r11 = r12.f74232f
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x017c
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x017b
            goto L_0x017c
        L_0x017b:
            r2 = 0
        L_0x017c:
            if (r2 != 0) goto L_0x01a6
            int r11 = net.one97.paytm.o2o.movies.R.id.tvDate
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            java.lang.String r12 = r12.f74232f
            java.lang.String r1 = "yyyy-MM-dd"
            java.lang.String r2 = "MMM dd, yyyy"
            java.lang.String r12 = com.paytm.utility.b.h(r12, r1, r2)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
            int r11 = net.one97.paytm.o2o.movies.R.id.tvDate
            android.view.View r11 = r10.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            r11.setVisibility(r0)
        L_0x01a6:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.m.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f75400b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
