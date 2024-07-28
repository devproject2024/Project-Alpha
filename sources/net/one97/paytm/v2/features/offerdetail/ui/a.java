package net.one97.paytm.v2.features.offerdetail.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class a extends net.one97.paytm.i.h {

    /* renamed from: b  reason: collision with root package name */
    public static final C0372a f20485b = new C0372a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public View f20486a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.v2.features.offerdetail.c.a f20487c;

    /* renamed from: d  reason: collision with root package name */
    private final z<String> f20488d = new b(this);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f20489e;

    static final class e<T> implements z<GameOfferDetailModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20493a;

        e(a aVar) {
            this.f20493a = aVar;
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    public final View a(int i2) {
        if (this.f20489e == null) {
            this.f20489e = new HashMap();
        }
        View view = (View) this.f20489e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f20489e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20490a;

        b(a aVar) {
            this.f20490a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity;
            Intent intent;
            String str = (String) obj;
            a.i.C0390a aVar = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20811d)) {
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20490a.a(R.id.activateLoader));
                if (((TextView) this.f20490a.a(R.id.ctaBtn)) != null) {
                    TextView textView = (TextView) this.f20490a.a(R.id.ctaBtn);
                    k.a((Object) textView, "ctaBtn");
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            a.i.C0390a aVar2 = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20812e)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20490a.a(R.id.activateLoader));
                if (((TextView) this.f20490a.a(R.id.ctaBtn)) != null && (activity = this.f20490a.getActivity()) != null && (intent = activity.getIntent()) != null) {
                    intent.putExtra("isActivated", true);
                    return;
                }
                return;
            }
            a.i.C0390a aVar3 = a.i.f20808a;
            if (k.a((Object) str, (Object) a.i.f20813f)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20490a.a(R.id.activateLoader));
                TextView textView2 = (TextView) this.f20490a.a(R.id.ctaBtn);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
            }
        }
    }

    static final class c<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20491a;

        c(a aVar) {
            this.f20491a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            FragmentActivity activity = this.f20491a.getActivity();
            if (activity != null) {
                ((CashbackCompaignGameDetail) activity).a(false);
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                k.a((Object) networkCustomError, "it");
                FragmentActivity activity2 = this.f20491a.getActivity();
                if (activity2 != null) {
                    d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity2, Boolean.FALSE, 8);
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail");
        }
    }

    static final class g<T> implements z<GameOfferDetailModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20495a;

        g(a aVar) {
            this.f20495a = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:123:0x02cb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r12) {
            /*
                r11 = this;
                net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel r12 = (net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel) r12
                if (r12 == 0) goto L_0x036d
                net.one97.paytm.v2.features.offerdetail.ui.a r0 = r11.f20495a
                java.lang.String r1 = "data"
                kotlin.g.b.k.c(r12, r1)
                android.view.View r1 = r0.f20486a
                java.lang.String r2 = "mView"
                if (r1 != 0) goto L_0x0014
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0014:
                int r3 = net.one97.paytm.vipcashback.R.id.back_arrow
                android.view.View r1 = r1.findViewById(r3)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                java.lang.String r3 = "mView.back_arrow"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                r3 = 0
                r1.setVisibility(r3)
                androidx.fragment.app.FragmentActivity r1 = r0.getActivity()
                boolean r1 = r1 instanceof net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail
                if (r1 == 0) goto L_0x0041
                androidx.fragment.app.FragmentActivity r1 = r0.getActivity()
                if (r1 == 0) goto L_0x0039
                net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail r1 = (net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail) r1
                r1.a((boolean) r3)
                goto L_0x0041
            L_0x0039:
                kotlin.u r12 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail"
                r12.<init>(r0)
                throw r12
            L_0x0041:
                java.lang.String r1 = r12.validityText
                r4 = 1
                if (r1 == 0) goto L_0x00cd
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0050
                r1 = 1
                goto L_0x0051
            L_0x0050:
                r1 = 0
            L_0x0051:
                if (r1 != r4) goto L_0x00cd
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x005a
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x005a:
                int r5 = net.one97.paytm.vipcashback.R.id.validity
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = "mView.validity"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                boolean r1 = r12.isExpiredGame
                java.lang.String r6 = "gameOfferDetailModel.validityText"
                java.lang.String r7 = "dd MMM yyyy"
                java.lang.String r8 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                if (r1 == 0) goto L_0x00a1
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x007b
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x007b:
                int r9 = net.one97.paytm.vipcashback.R.id.validity
                android.view.View r1 = r1.findViewById(r9)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                int r5 = net.one97.paytm.vipcashback.R.string.cb_expired_on
                java.lang.Object[] r9 = new java.lang.Object[r4]
                net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a
                java.lang.String r10 = r12.validityText
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)
                java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.c((java.lang.String) r8, (java.lang.String) r7, (java.lang.String) r10)
                r9[r3] = r6
                java.lang.String r5 = r0.getString(r5, r9)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
                goto L_0x00cd
            L_0x00a1:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x00a8
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x00a8:
                int r9 = net.one97.paytm.vipcashback.R.id.validity
                android.view.View r1 = r1.findViewById(r9)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                int r5 = net.one97.paytm.vipcashback.R.string.valid_upto
                java.lang.Object[] r9 = new java.lang.Object[r4]
                net.one97.paytm.vipcashback.f.d$a r10 = net.one97.paytm.vipcashback.f.d.f20859a
                java.lang.String r10 = r12.validityText
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)
                java.lang.String r6 = net.one97.paytm.vipcashback.f.d.a.c((java.lang.String) r8, (java.lang.String) r7, (java.lang.String) r10)
                r9[r3] = r6
                java.lang.String r5 = r0.getString(r5, r9)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
            L_0x00cd:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x00d4
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x00d4:
                int r5 = net.one97.paytm.vipcashback.R.id.cardLayout
                android.view.View r1 = r1.findViewById(r5)
                r1.setVisibility(r3)
                net.one97.paytm.vipcashback.f.j r5 = net.one97.paytm.vipcashback.f.j.GAME_CAMPAIGN_THEME
                int r6 = net.one97.paytm.vipcashback.R.id.imgIcon
                android.view.View r6 = r1.findViewById(r6)
                net.one97.paytm.common.widgets.CircularImageView r6 = (net.one97.paytm.common.widgets.CircularImageView) r6
                if (r6 == 0) goto L_0x00ec
                r6.setVisibility(r3)
            L_0x00ec:
                int r6 = net.one97.paytm.vipcashback.R.id.imageView
                android.view.View r6 = r1.findViewById(r6)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                if (r6 == 0) goto L_0x00fa
                r7 = 4
                r6.setVisibility(r7)
            L_0x00fa:
                int r6 = net.one97.paytm.vipcashback.R.id.cardLock
                android.view.View r6 = r1.findViewById(r6)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                java.lang.String r7 = "cardLock"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                r6.setVisibility(r3)
                int r6 = net.one97.paytm.vipcashback.R.id.cardRedDot
                android.view.View r6 = r1.findViewById(r6)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                java.lang.String r7 = "cardRedDot"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                r7 = 8
                r6.setVisibility(r7)
                com.squareup.picasso.w r6 = com.squareup.picasso.w.a()
                java.lang.String r8 = r12.thumbnail
                com.squareup.picasso.aa r6 = r6.a((java.lang.String) r8)
                int r8 = net.one97.paytm.vipcashback.R.drawable.cashback_bg_place_holder
                com.squareup.picasso.aa r6 = r6.a((int) r8)
                int r8 = net.one97.paytm.vipcashback.R.id.imgIcon
                android.view.View r8 = r1.findViewById(r8)
                net.one97.paytm.common.widgets.CircularImageView r8 = (net.one97.paytm.common.widgets.CircularImageView) r8
                r6.a((android.widget.ImageView) r8)
                int r6 = net.one97.paytm.vipcashback.R.id.backGround
                android.view.View r6 = r1.findViewById(r6)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                r8 = 0
                if (r6 == 0) goto L_0x0147
                android.graphics.drawable.Drawable r6 = r6.getBackground()
                goto L_0x0148
            L_0x0147:
                r6 = r8
            L_0x0148:
                if (r6 == 0) goto L_0x0365
                android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6
                if (r6 == 0) goto L_0x0159
                java.lang.String r5 = r5.getBgColor()
                int r5 = android.graphics.Color.parseColor(r5)
                r6.setColor(r5)
            L_0x0159:
                int r5 = net.one97.paytm.vipcashback.R.id.textView
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = "textView"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r7)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x0170
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0170:
                int r5 = net.one97.paytm.vipcashback.R.id.detailtext
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = "mView.detailtext"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x0187
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0187:
                int r5 = net.one97.paytm.vipcashback.R.id.arrow
                android.view.View r1 = r1.findViewById(r5)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                java.lang.String r5 = "mView.arrow"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                java.lang.String r1 = r12.cashbackText
                if (r1 == 0) goto L_0x01d5
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x01a5
                r1 = 1
                goto L_0x01a6
            L_0x01a5:
                r1 = 0
            L_0x01a6:
                if (r1 != r4) goto L_0x01d5
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x01af
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x01af:
                int r5 = net.one97.paytm.vipcashback.R.id.cashbackText
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = "mView.cashbackText"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x01c6
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x01c6:
                int r5 = net.one97.paytm.vipcashback.R.id.cashbackText
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = r12.cashbackText
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
            L_0x01d5:
                java.lang.String r1 = r12.cashbackDescription
                if (r1 == 0) goto L_0x0213
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x01e3
                r1 = 1
                goto L_0x01e4
            L_0x01e3:
                r1 = 0
            L_0x01e4:
                if (r1 != r4) goto L_0x0213
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x01ed
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x01ed:
                int r5 = net.one97.paytm.vipcashback.R.id.cashbackdescription
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = "mView.cashbackdescription"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x0204
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0204:
                int r5 = net.one97.paytm.vipcashback.R.id.cashbackdescription
                android.view.View r1 = r1.findViewById(r5)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r5 = r12.cashbackDescription
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r1.setText(r5)
            L_0x0213:
                boolean r1 = r12.showTimeLine
                java.lang.String r5 = "mView.timelineProgress_layout"
                if (r1 == 0) goto L_0x0254
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x0220
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0220:
                int r6 = net.one97.paytm.vipcashback.R.id.timelineProgress_layout
                android.view.View r1 = r1.findViewById(r6)
                android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.TransactionsInfo> r1 = r12.transactionsInfos
                int r1 = r1.size()
                if (r1 <= r4) goto L_0x0269
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x023d
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x023d:
                int r5 = net.one97.paytm.vipcashback.R.id.timelineProgress
                android.view.View r1 = r1.findViewById(r5)
                net.one97.paytm.vipcashback.widget.TimeLineProgressView r1 = (net.one97.paytm.vipcashback.widget.TimeLineProgressView) r1
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.TransactionsInfo> r5 = r12.transactionsInfos
                java.lang.String r6 = "gameOfferDetailModel.transactionsInfos"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r6 = "info"
                kotlin.g.b.k.c(r5, r6)
                r1.f21057c = r5
                goto L_0x0269
            L_0x0254:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x025b
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x025b:
                int r6 = net.one97.paytm.vipcashback.R.id.timelineProgress_layout
                android.view.View r1 = r1.findViewById(r6)
                android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r7)
            L_0x0269:
                boolean r1 = r12.showCTA
                java.lang.String r5 = "mView.ctaBtn"
                if (r1 == 0) goto L_0x0336
                boolean r1 = r12.autoActivate
                if (r1 == 0) goto L_0x02e1
                java.lang.String r1 = r12.ctaLink
                if (r1 == 0) goto L_0x034b
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x027e
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x027e:
                int r6 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r6)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                java.lang.String r1 = r12.ctaText
                if (r1 == 0) goto L_0x02b2
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0299
                r3 = 1
            L_0x0299:
                if (r3 != r4) goto L_0x02b2
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x02a2
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x02a2:
                int r3 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r3 = r12.ctaText
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.setText(r3)
                goto L_0x02c7
            L_0x02b2:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x02b9
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x02b9:
                int r3 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r7)
            L_0x02c7:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x02ce
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x02ce:
                int r3 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                net.one97.paytm.v2.features.offerdetail.ui.a$h r3 = new net.one97.paytm.v2.features.offerdetail.ui.a$h
                r3.<init>(r0, r12, r12)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r1.setOnClickListener(r3)
                goto L_0x034b
            L_0x02e1:
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x02e8
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x02e8:
                int r4 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r4)
                android.widget.TextView r1 = (android.widget.TextView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
                r1.setVisibility(r3)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x02fd
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x02fd:
                int r3 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                androidx.fragment.app.FragmentActivity r3 = r0.getActivity()
                if (r3 == 0) goto L_0x0317
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x0317
                int r4 = net.one97.paytm.vipcashback.R.string.activate_offer
                java.lang.String r8 = r3.getString(r4)
            L_0x0317:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r1.setText(r8)
                android.view.View r1 = r0.f20486a
                if (r1 != 0) goto L_0x0323
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0323:
                int r3 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r1 = r1.findViewById(r3)
                android.widget.TextView r1 = (android.widget.TextView) r1
                net.one97.paytm.v2.features.offerdetail.ui.a$i r3 = new net.one97.paytm.v2.features.offerdetail.ui.a$i
                r3.<init>(r0, r12)
                android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
                r1.setOnClickListener(r3)
                goto L_0x034b
            L_0x0336:
                android.view.View r12 = r0.f20486a
                if (r12 != 0) goto L_0x033d
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x033d:
                int r1 = net.one97.paytm.vipcashback.R.id.ctaBtn
                android.view.View r12 = r12.findViewById(r1)
                android.widget.TextView r12 = (android.widget.TextView) r12
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
                r12.setVisibility(r7)
            L_0x034b:
                android.view.View r12 = r0.f20486a
                if (r12 != 0) goto L_0x0352
                kotlin.g.b.k.a((java.lang.String) r2)
            L_0x0352:
                int r1 = net.one97.paytm.vipcashback.R.id.detailtext
                android.view.View r12 = r12.findViewById(r1)
                android.widget.TextView r12 = (android.widget.TextView) r12
                net.one97.paytm.v2.features.offerdetail.ui.a$j r1 = new net.one97.paytm.v2.features.offerdetail.ui.a$j
                r1.<init>(r0)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r12.setOnClickListener(r1)
                return
            L_0x0365:
                kotlin.u r12 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
                r12.<init>(r0)
                throw r12
            L_0x036d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.offerdetail.ui.a.g.onChanged(java.lang.Object):void");
        }
    }

    /* renamed from: net.one97.paytm.v2.features.offerdetail.ui.a$a  reason: collision with other inner class name */
    public static final class C0372a {
        private C0372a() {
        }

        public /* synthetic */ C0372a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: type inference failed for: r5v18, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r5v21, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r3, android.view.ViewGroup r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r5 = "inflater"
            kotlin.g.b.k.c(r3, r5)
            int r5 = net.one97.paytm.vipcashback.R.layout.fragment_game_campaign
            r0 = 0
            android.view.View r3 = r3.inflate(r5, r4, r0)
            java.lang.String r4 = "inflater.inflate(R.layou…mpaign, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r2.f20486a = r3
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            boolean r3 = r3 instanceof net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail
            if (r3 == 0) goto L_0x0030
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0028
            net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail r3 = (net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail) r3
            r4 = 1
            r3.a((boolean) r4)
            goto L_0x0030
        L_0x0028:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail"
            r3.<init>(r4)
            throw r3
        L_0x0030:
            android.os.Bundle r3 = r2.getArguments()
            if (r3 == 0) goto L_0x0051
            java.lang.String r4 = "isActivated"
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x0051
            androidx.fragment.app.FragmentActivity r5 = r2.getActivity()
            if (r5 == 0) goto L_0x0051
            android.content.Intent r5 = r5.getIntent()
            if (r5 == 0) goto L_0x0051
            boolean r3 = r3.getBoolean(r4, r0)
            r5.putExtra(r4, r3)
        L_0x0051:
            net.one97.paytm.v2.features.offerdetail.a.a$a r3 = net.one97.paytm.v2.features.offerdetail.a.a.a()
            androidx.fragment.app.FragmentActivity r4 = r2.getActivity()
            r5 = 0
            if (r4 == 0) goto L_0x0070
            net.one97.paytm.v2.features.cashbackoffers.a.b.j r4 = new net.one97.paytm.v2.features.cashbackoffers.a.b.j
            android.content.Context r0 = r2.getContext()
            if (r0 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            java.lang.String r1 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r4.<init>(r0)
            goto L_0x0071
        L_0x0070:
            r4 = r5
        L_0x0071:
            net.one97.paytm.v2.features.offerdetail.a.a$a r3 = r3.a((net.one97.paytm.v2.features.cashbackoffers.a.b.j) r4)
            androidx.fragment.app.FragmentActivity r4 = r2.getActivity()
            if (r4 == 0) goto L_0x0086
            net.one97.paytm.v2.features.offerdetail.a.a.a r0 = new net.one97.paytm.v2.features.offerdetail.a.a.a
            java.lang.String r1 = "it"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            r0.<init>(r4)
            goto L_0x0087
        L_0x0086:
            r0 = r5
        L_0x0087:
            net.one97.paytm.v2.features.offerdetail.a.a$a r3 = r3.a((net.one97.paytm.v2.features.offerdetail.a.a.a) r0)
            net.one97.paytm.v2.features.offerdetail.a.b r3 = r3.a()
            net.one97.paytm.v2.features.offerdetail.c.a r4 = r3.b()
            r2.f20487c = r4
            net.one97.paytm.v2.features.offerdetail.c.a r4 = r2.f20487c
            if (r4 != 0) goto L_0x009c
            kotlin.g.b.k.a()
        L_0x009c:
            r3.a(r4)
            android.os.Bundle r3 = r2.getArguments()
            java.lang.String r4 = "campaignid"
            if (r3 == 0) goto L_0x00ac
            java.lang.String r3 = r3.getString(r4)
            goto L_0x00ad
        L_0x00ac:
            r3 = r5
        L_0x00ad:
            if (r3 == 0) goto L_0x00c7
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x015a
            android.os.Bundle r0 = r2.getArguments()
            if (r0 == 0) goto L_0x00bd
            java.lang.String r5 = r0.getString(r4)
        L_0x00bd:
            if (r5 != 0) goto L_0x00c2
            kotlin.g.b.k.a()
        L_0x00c2:
            r3.a((java.lang.String) r5)
            goto L_0x015a
        L_0x00c7:
            android.os.Bundle r3 = r2.getArguments()
            java.lang.String r4 = "gameid"
            if (r3 == 0) goto L_0x00d4
            java.lang.String r3 = r3.getString(r4)
            goto L_0x00d5
        L_0x00d4:
            r3 = r5
        L_0x00d5:
            if (r3 == 0) goto L_0x00fe
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x015a
            android.os.Bundle r0 = r2.getArguments()
            if (r0 == 0) goto L_0x00e5
            java.lang.String r5 = r0.getString(r4)
        L_0x00e5:
            if (r5 != 0) goto L_0x00ea
            kotlin.g.b.k.a()
        L_0x00ea:
            java.lang.String r4 = "gameId"
            kotlin.g.b.k.c(r5, r4)
            net.one97.paytm.v2.features.offerdetail.b.b r4 = r3.f20450a
            if (r4 != 0) goto L_0x00f8
            java.lang.String r0 = "repository"
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00f8:
            androidx.lifecycle.y<net.one97.paytm.vipcashback.f.h<java.lang.Object>> r3 = r3.f20457h
            r4.a(r3, r5)
            goto L_0x015a
        L_0x00fe:
            android.os.Bundle r3 = r2.getArguments()
            java.lang.String r4 = "campaign"
            if (r3 == 0) goto L_0x010b
            java.io.Serializable r3 = r3.getSerializable(r4)
            goto L_0x010c
        L_0x010b:
            r3 = r5
        L_0x010c:
            if (r3 == 0) goto L_0x012c
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x015a
            android.os.Bundle r0 = r2.getArguments()
            if (r0 == 0) goto L_0x011c
            java.io.Serializable r5 = r0.getSerializable(r4)
        L_0x011c:
            if (r5 == 0) goto L_0x0124
            net.one97.paytm.cashback.posttxn.Campaign r5 = (net.one97.paytm.cashback.posttxn.Campaign) r5
            r3.a((net.one97.paytm.cashback.posttxn.Campaign) r5)
            goto L_0x015a
        L_0x0124:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.Campaign"
            r3.<init>(r4)
            throw r3
        L_0x012c:
            android.os.Bundle r3 = r2.getArguments()
            java.lang.String r4 = "supercashGame"
            if (r3 == 0) goto L_0x0139
            java.io.Serializable r3 = r3.getSerializable(r4)
            goto L_0x013a
        L_0x0139:
            r3 = r5
        L_0x013a:
            if (r3 == 0) goto L_0x015a
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x015a
            android.os.Bundle r0 = r2.getArguments()
            if (r0 == 0) goto L_0x014a
            java.io.Serializable r5 = r0.getSerializable(r4)
        L_0x014a:
            if (r5 == 0) goto L_0x0152
            net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r5 = (net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4) r5
            r3.a((net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4) r5)
            goto L_0x015a
        L_0x0152:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4"
            r3.<init>(r4)
            throw r3
        L_0x015a:
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x0171
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r3 = r3.f20451b
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x0171
            r4 = r2
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            net.one97.paytm.v2.features.offerdetail.ui.a$c r5 = new net.one97.paytm.v2.features.offerdetail.ui.a$c
            r5.<init>(r2)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
        L_0x0171:
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x0188
            androidx.lifecycle.y<com.paytm.network.a> r3 = r3.f20452c
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x0188
            r4 = r2
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            net.one97.paytm.v2.features.offerdetail.ui.a$d r5 = new net.one97.paytm.v2.features.offerdetail.ui.a$d
            r5.<init>(r2)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
        L_0x0188:
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x019d
            androidx.lifecycle.y<net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel> r3 = r3.j
            if (r3 == 0) goto L_0x019d
            r4 = r2
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            net.one97.paytm.v2.features.offerdetail.ui.a$e r5 = new net.one97.paytm.v2.features.offerdetail.ui.a$e
            r5.<init>(r2)
            androidx.lifecycle.z r5 = (androidx.lifecycle.z) r5
            r3.observe(r4, r5)
        L_0x019d:
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x01ad
            androidx.lifecycle.y<java.lang.String> r3 = r3.f20458i
            if (r3 == 0) goto L_0x01ad
            r4 = r2
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            androidx.lifecycle.z<java.lang.String> r5 = r2.f20488d
            r3.observe(r4, r5)
        L_0x01ad:
            android.view.View r3 = r2.f20486a
            java.lang.String r4 = "mView"
            if (r3 != 0) goto L_0x01b6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01b6:
            int r5 = net.one97.paytm.vipcashback.R.id.back_arrow
            android.view.View r3 = r3.findViewById(r5)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            net.one97.paytm.v2.features.offerdetail.ui.a$f r5 = new net.one97.paytm.v2.features.offerdetail.ui.a$f
            r5.<init>(r2)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            net.one97.paytm.v2.features.offerdetail.c.a r3 = r2.f20487c
            if (r3 == 0) goto L_0x01dd
            androidx.lifecycle.y<net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel> r3 = r3.f20454e
            if (r3 == 0) goto L_0x01dd
            r5 = r2
            androidx.lifecycle.q r5 = (androidx.lifecycle.q) r5
            net.one97.paytm.v2.features.offerdetail.ui.a$g r0 = new net.one97.paytm.v2.features.offerdetail.ui.a$g
            r0.<init>(r2)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r3.observe(r5, r0)
        L_0x01dd:
            android.view.View r3 = r2.f20486a
            if (r3 != 0) goto L_0x01e4
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01e4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.offerdetail.ui.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20494a;

        f(a aVar) {
            this.f20494a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f20494a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20497b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20498c;

        h(a aVar, GameOfferDetailModel gameOfferDetailModel, GameOfferDetailModel gameOfferDetailModel2) {
            this.f20496a = aVar;
            this.f20497b = gameOfferDetailModel;
            this.f20498c = gameOfferDetailModel2;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            CharSequence charSequence = this.f20498c.mCampaignId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                arrayList = new ArrayList();
                arrayList.add(this.f20498c.mCampaignId);
            } else {
                arrayList = null;
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20496a.getActivity(), "cashback_offers", "transaction_cta_clicked", arrayList, (String) null, "/cashback-landing", "cashback");
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20496a.getActivity(), this.f20497b.ctaLink);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20500b;

        i(a aVar, GameOfferDetailModel gameOfferDetailModel) {
            this.f20499a = aVar;
            this.f20500b = gameOfferDetailModel;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            CharSequence charSequence = this.f20500b.mCampaignId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                arrayList = new ArrayList();
                arrayList.add(this.f20500b.mCampaignId);
            } else {
                arrayList = null;
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20499a.getActivity(), "cashback_offers", "activate_offers_clicked", arrayList, (String) null, "/cashback-landing", "cashback");
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20499a.a(R.id.activateLoader));
            net.one97.paytm.v2.features.offerdetail.c.a a2 = this.f20499a.f20487c;
            if (a2 != null) {
                a2.a();
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20501a;

        j(a aVar) {
            this.f20501a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.v2.features.offerdetail.c.a a2 = this.f20501a.f20487c;
            final LiveData<Object> b2 = a2 != null ? a2.b() : null;
            if (b2 != null) {
                b2.observe(this.f20501a, new z<Object>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ j f20502a;

                    {
                        this.f20502a = r1;
                    }

                    public final void onChanged(Object obj) {
                        Intent intent = new Intent(this.f20502a.f20501a.getActivity(), CashbackDetailActivity.class);
                        if (obj instanceof VIPCashBackOfferV4) {
                            intent.putExtra("supercashGame", (Serializable) obj);
                        } else if (obj instanceof Campaign) {
                            intent.putExtra("campaign", (Serializable) obj);
                        }
                        this.f20502a.f20501a.startActivityForResult(intent, 100);
                        LiveData liveData = b2;
                        if (liveData != null) {
                            liveData.removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Intent intent2;
        net.one97.paytm.v2.features.offerdetail.c.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            Boolean bool = null;
            if ((intent != null ? intent.getSerializableExtra("supercashGame") : null) != null) {
                net.one97.paytm.v2.features.offerdetail.c.a aVar2 = this.f20487c;
                if (aVar2 != null) {
                    Serializable serializableExtra = intent != null ? intent.getSerializableExtra("supercashGame") : null;
                    if (serializableExtra != null) {
                        aVar2.a((VIPCashBackOfferV4) serializableExtra);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4");
                    }
                }
            } else {
                if (!((intent != null ? intent.getSerializableExtra("campaign") : null) == null || (aVar = this.f20487c) == null)) {
                    Serializable serializableExtra2 = intent != null ? intent.getSerializableExtra("campaign") : null;
                    if (serializableExtra2 != null) {
                        aVar.a((Campaign) serializableExtra2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.Campaign");
                    }
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                if (intent != null) {
                    bool = Boolean.valueOf(intent.getBooleanExtra("isActivated", false));
                }
                intent2.putExtra("isActivated", bool);
            }
        }
    }

    static final class d<T> implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20492a;

        d(a aVar) {
            this.f20492a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            FragmentActivity activity = this.f20492a.getActivity();
            if (activity != null) {
                ((CashbackCompaignGameDetail) activity).a(false);
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                FragmentActivity activity2 = this.f20492a.getActivity();
                if (activity2 != null) {
                    d.a.a((Context) (AppCompatActivity) activity2, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                        final /* synthetic */ d this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            FragmentActivity activity = this.this$0.f20492a.getActivity();
                            if (activity != null) {
                                activity.onBackPressed();
                            }
                        }
                    });
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20489e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
