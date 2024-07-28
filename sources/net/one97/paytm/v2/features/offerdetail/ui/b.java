package net.one97.paytm.v2.features.offerdetail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel;
import net.one97.paytm.v2.features.offerdetail.a.a;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;

public final class b extends net.one97.paytm.i.h {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20504c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public View f20505a;

    /* renamed from: b  reason: collision with root package name */
    String f20506b = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.v2.features.offerdetail.c.a f20507d;

    /* renamed from: e  reason: collision with root package name */
    private final z<String> f20508e = new C0373b(this);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f20509f;

    static final class f<T> implements z<GameOfferDetailModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20516a;

        f(b bVar) {
            this.f20516a = bVar;
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    /* renamed from: net.one97.paytm.v2.features.offerdetail.ui.b$b  reason: collision with other inner class name */
    static final class C0373b<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20510a;

        C0373b(b bVar) {
            this.f20510a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            a.i.C0390a aVar = a.i.f20808a;
            if (kotlin.g.b.k.a((Object) str, (Object) a.i.f20811d)) {
                Button button = (Button) this.f20510a.a().findViewById(R.id.payButton);
                if (button != null) {
                    button.setVisibility(4);
                }
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f20510a.a().findViewById(R.id.loader);
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                }
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f20510a.a().findViewById(R.id.loader));
                return;
            }
            a.i.C0390a aVar2 = a.i.f20808a;
            if (kotlin.g.b.k.a((Object) str, (Object) a.i.f20812e)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20510a.a().findViewById(R.id.loader));
                LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f20510a.a().findViewById(R.id.loader);
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(8);
                    return;
                }
                return;
            }
            a.i.C0390a aVar3 = a.i.f20808a;
            if (kotlin.g.b.k.a((Object) str, (Object) a.i.f20813f)) {
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f20510a.a().findViewById(R.id.loader));
                LottieAnimationView lottieAnimationView3 = (LottieAnimationView) this.f20510a.a().findViewById(R.id.loader);
                if (lottieAnimationView3 != null) {
                    lottieAnimationView3.setVisibility(8);
                }
                Button button2 = (Button) this.f20510a.a().findViewById(R.id.payButton);
                if (button2 != null) {
                    button2.setVisibility(0);
                }
            }
        }
    }

    static final class d<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20514a;

        d(b bVar) {
            this.f20514a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            if (this.f20514a.getActivity() instanceof CashbackCompaignGameDetail) {
                FragmentActivity activity = this.f20514a.getActivity();
                if (activity != null) {
                    ((CashbackCompaignGameDetail) activity).a(false);
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    kotlin.g.b.k.a((Object) networkCustomError, "it");
                    FragmentActivity activity2 = this.f20514a.getActivity();
                    if (activity2 != null) {
                        d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity2, Boolean.TRUE, 8);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail");
            }
        }
    }

    static final class e<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20515a;

        e(b bVar) {
            this.f20515a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            b.a(this.f20515a);
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            kotlin.g.b.k.a((Object) networkCustomError, "it");
            FragmentActivity activity = this.f20515a.getActivity();
            if (activity != null) {
                d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity, Boolean.FALSE, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                    final /* synthetic */ e this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        FragmentActivity activity = this.this$0.f20515a.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    static final class h<T> implements z<GameOfferDetailModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20518a;

        h(b bVar) {
            this.f20518a = bVar;
        }

        /* JADX WARNING: type inference failed for: r2v7, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x0264  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0271  */
        /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r12) {
            /*
                r11 = this;
                net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel r12 = (net.one97.paytm.common.entity.vipcashback.GameOfferDetailModel) r12
                if (r12 == 0) goto L_0x02e0
                net.one97.paytm.v2.features.offerdetail.ui.b r0 = r11.f20518a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                boolean r0 = r0 instanceof net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity
                r1 = 0
                if (r0 == 0) goto L_0x0025
                net.one97.paytm.v2.features.offerdetail.ui.b r0 = r11.f20518a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x001d
                net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity r0 = (net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity) r0
                r0.a((boolean) r1)
                goto L_0x0025
            L_0x001d:
                kotlin.u r12 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity"
                r12.<init>(r0)
                throw r12
            L_0x0025:
                boolean r0 = r12.isGameCampaign
                r2 = 0
                if (r0 == 0) goto L_0x0047
                net.one97.paytm.v2.features.offerdetail.ui.b r12 = r11.f20518a
                net.one97.paytm.v2.features.offerdetail.c.a r12 = r12.f20507d
                if (r12 == 0) goto L_0x0036
                androidx.lifecycle.LiveData r2 = r12.b()
            L_0x0036:
                if (r2 == 0) goto L_0x0046
                net.one97.paytm.v2.features.offerdetail.ui.b r12 = r11.f20518a
                androidx.lifecycle.q r12 = (androidx.lifecycle.q) r12
                net.one97.paytm.v2.features.offerdetail.ui.b$h$a r0 = new net.one97.paytm.v2.features.offerdetail.ui.b$h$a
                r0.<init>(r2, r11)
                androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
                r2.observe(r12, r0)
            L_0x0046:
                return
            L_0x0047:
                net.one97.paytm.v2.features.offerdetail.ui.b r0 = r11.f20518a
                java.lang.String r3 = "data"
                kotlin.g.b.k.c(r12, r3)
                android.view.View r3 = r0.f20505a
                java.lang.String r4 = "mView"
                if (r3 != 0) goto L_0x0057
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0057:
                int r5 = net.one97.paytm.vipcashback.R.id.dealDetailView
                android.view.View r3 = r3.findViewById(r5)
                androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
                if (r3 == 0) goto L_0x0064
                r3.setVisibility(r1)
            L_0x0064:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x006b
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x006b:
                int r5 = net.one97.paytm.vipcashback.R.id.back_arrow
                android.view.View r3 = r3.findViewById(r5)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                if (r3 == 0) goto L_0x0078
                r3.setVisibility(r1)
            L_0x0078:
                java.lang.String r3 = r12.validityText
                r5 = 1
                if (r3 == 0) goto L_0x00cf
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                int r3 = r3.length()
                if (r3 <= 0) goto L_0x0087
                r3 = 1
                goto L_0x0088
            L_0x0087:
                r3 = 0
            L_0x0088:
                if (r3 != r5) goto L_0x00cf
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0091
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0091:
                int r6 = net.one97.paytm.vipcashback.R.id.validity
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x009e
                r3.setVisibility(r1)
            L_0x009e:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x00a5
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x00a5:
                int r6 = net.one97.paytm.vipcashback.R.id.validity
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x00cf
                int r6 = net.one97.paytm.vipcashback.R.string.valid_upto
                java.lang.Object[] r7 = new java.lang.Object[r5]
                net.one97.paytm.vipcashback.f.d$a r8 = net.one97.paytm.vipcashback.f.d.f20859a
                java.lang.String r8 = r12.validityText
                java.lang.String r9 = "data.validityText"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
                java.lang.String r9 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                java.lang.String r10 = "dd MMM yyyy"
                java.lang.String r8 = net.one97.paytm.vipcashback.f.d.a.c((java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r8)
                r7[r1] = r8
                java.lang.String r6 = r0.getString(r6, r7)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.setText(r6)
            L_0x00cf:
                com.squareup.picasso.w r3 = com.squareup.picasso.w.a()
                java.lang.String r6 = r12.backgroundImageUrl
                com.squareup.picasso.aa r3 = r3.a((java.lang.String) r6)
                android.view.View r6 = r0.f20505a
                if (r6 != 0) goto L_0x00e0
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x00e0:
                int r7 = net.one97.paytm.vipcashback.R.id.cardImage
                android.view.View r6 = r6.findViewById(r7)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                net.one97.paytm.v2.features.offerdetail.ui.b$k r7 = new net.one97.paytm.v2.features.offerdetail.ui.b$k
                r7.<init>(r0)
                com.squareup.picasso.e r7 = (com.squareup.picasso.e) r7
                r3.a((android.widget.ImageView) r6, (com.squareup.picasso.e) r7)
                com.squareup.picasso.w r3 = com.squareup.picasso.w.a()
                java.lang.String r6 = r12.thumbnail
                com.squareup.picasso.aa r3 = r3.a((java.lang.String) r6)
                int r6 = net.one97.paytm.vipcashback.R.drawable.cashback_bg_place_holder
                com.squareup.picasso.aa r3 = r3.a((int) r6)
                android.view.View r6 = r0.f20505a
                if (r6 != 0) goto L_0x0109
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0109:
                int r7 = net.one97.paytm.vipcashback.R.id.cardOfferImage
                android.view.View r6 = r6.findViewById(r7)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r6 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r6
                r3.a((android.widget.ImageView) r6)
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x011b
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x011b:
                int r6 = net.one97.paytm.vipcashback.R.id.winningTextView
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0128
                r3.setVisibility(r1)
            L_0x0128:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x012f
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x012f:
                int r6 = net.one97.paytm.vipcashback.R.id.winningTextView
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0140
                java.lang.String r6 = r12.title
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.setText(r6)
            L_0x0140:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0147
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0147:
                int r6 = net.one97.paytm.vipcashback.R.id.cashbackText
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0154
                r3.setVisibility(r1)
            L_0x0154:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x015b
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x015b:
                int r6 = net.one97.paytm.vipcashback.R.id.cashbackText
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x016c
                java.lang.String r6 = r12.cashbackText
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.setText(r6)
            L_0x016c:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0173
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0173:
                int r6 = net.one97.paytm.vipcashback.R.id.viewDetails
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0180
                r3.setVisibility(r1)
            L_0x0180:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0187
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0187:
                int r6 = net.one97.paytm.vipcashback.R.id.viewDetails
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x0198
                java.lang.String r6 = r12.cashbackDescription
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.setText(r6)
            L_0x0198:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x019f
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x019f:
                int r6 = net.one97.paytm.vipcashback.R.id.moreDetails
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x01ac
                r3.setVisibility(r1)
            L_0x01ac:
                android.view.View r3 = r0.getView()
                if (r3 != 0) goto L_0x01b5
                kotlin.g.b.k.a()
            L_0x01b5:
                int r6 = net.one97.paytm.vipcashback.R.id.moreDetails
                android.view.View r3 = r3.findViewById(r6)
                if (r3 == 0) goto L_0x02d8
                android.widget.TextView r3 = (android.widget.TextView) r3
                android.text.SpannableString r6 = new android.text.SpannableString
                android.content.res.Resources r7 = r0.getResources()
                int r8 = net.one97.paytm.vipcashback.R.string.more_details
                java.lang.String r7 = r7.getString(r8)
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                r6.<init>(r7)
                android.text.style.UnderlineSpan r7 = new android.text.style.UnderlineSpan
                r7.<init>()
                int r8 = r6.length()
                r6.setSpan(r7, r1, r8, r1)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.setText(r6)
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x01e8
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x01e8:
                int r6 = net.one97.paytm.vipcashback.R.id.moreDetails
                android.view.View r3 = r3.findViewById(r6)
                android.widget.TextView r3 = (android.widget.TextView) r3
                if (r3 == 0) goto L_0x01fc
                net.one97.paytm.v2.features.offerdetail.ui.b$l r6 = new net.one97.paytm.v2.features.offerdetail.ui.b$l
                r6.<init>(r0)
                android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
                r3.setOnClickListener(r6)
            L_0x01fc:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0203
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0203:
                int r6 = net.one97.paytm.vipcashback.R.id.back_arrow
                android.view.View r3 = r3.findViewById(r6)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                net.one97.paytm.v2.features.offerdetail.ui.b$m r6 = new net.one97.paytm.v2.features.offerdetail.ui.b$m
                r6.<init>(r0)
                android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
                r3.setOnClickListener(r6)
                boolean r3 = r12.autoActivate
                if (r3 == 0) goto L_0x0280
                boolean r2 = r12.showCTA
                if (r2 == 0) goto L_0x027c
                java.lang.String r2 = r12.ctaLink
                if (r2 == 0) goto L_0x027b
                android.view.View r2 = r0.f20505a
                if (r2 != 0) goto L_0x0228
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0228:
                int r3 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r2 = r2.findViewById(r3)
                android.widget.Button r2 = (android.widget.Button) r2
                if (r2 == 0) goto L_0x0235
                r2.setVisibility(r1)
            L_0x0235:
                java.lang.String r2 = r12.ctaText
                if (r2 == 0) goto L_0x025d
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                int r2 = r2.length()
                if (r2 <= 0) goto L_0x0242
                r1 = 1
            L_0x0242:
                if (r1 != r5) goto L_0x025d
                android.view.View r1 = r0.f20505a
                if (r1 != 0) goto L_0x024b
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x024b:
                int r2 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r1 = r1.findViewById(r2)
                android.widget.Button r1 = (android.widget.Button) r1
                if (r1 == 0) goto L_0x0260
                java.lang.String r2 = r12.ctaText
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
                goto L_0x0260
            L_0x025d:
                r0.b()
            L_0x0260:
                android.view.View r1 = r0.f20505a
                if (r1 != 0) goto L_0x0267
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0267:
                int r2 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r1 = r1.findViewById(r2)
                android.widget.Button r1 = (android.widget.Button) r1
                if (r1 == 0) goto L_0x027b
                net.one97.paytm.v2.features.offerdetail.ui.b$j r2 = new net.one97.paytm.v2.features.offerdetail.ui.b$j
                r2.<init>(r0, r12)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r1.setOnClickListener(r2)
            L_0x027b:
                return
            L_0x027c:
                r0.b()
                return
            L_0x0280:
                android.view.View r3 = r0.f20505a
                if (r3 != 0) goto L_0x0287
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x0287:
                int r5 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r3 = r3.findViewById(r5)
                android.widget.Button r3 = (android.widget.Button) r3
                if (r3 == 0) goto L_0x0294
                r3.setVisibility(r1)
            L_0x0294:
                android.view.View r1 = r0.f20505a
                if (r1 != 0) goto L_0x029b
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x029b:
                int r3 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r1 = r1.findViewById(r3)
                android.widget.Button r1 = (android.widget.Button) r1
                if (r1 == 0) goto L_0x02bc
                androidx.fragment.app.FragmentActivity r3 = r0.getActivity()
                if (r3 == 0) goto L_0x02b7
                android.content.res.Resources r3 = r3.getResources()
                if (r3 == 0) goto L_0x02b7
                int r2 = net.one97.paytm.vipcashback.R.string.activate_offer
                java.lang.String r2 = r3.getString(r2)
            L_0x02b7:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r1.setText(r2)
            L_0x02bc:
                android.view.View r1 = r0.f20505a
                if (r1 != 0) goto L_0x02c3
                kotlin.g.b.k.a((java.lang.String) r4)
            L_0x02c3:
                int r2 = net.one97.paytm.vipcashback.R.id.payButton
                android.view.View r1 = r1.findViewById(r2)
                android.widget.Button r1 = (android.widget.Button) r1
                if (r1 == 0) goto L_0x02d7
                net.one97.paytm.v2.features.offerdetail.ui.b$n r2 = new net.one97.paytm.v2.features.offerdetail.ui.b$n
                r2.<init>(r0, r12)
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r1.setOnClickListener(r2)
            L_0x02d7:
                return
            L_0x02d8:
                kotlin.u r12 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.TextView"
                r12.<init>(r0)
                throw r12
            L_0x02e0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.offerdetail.ui.b.h.onChanged(java.lang.Object):void");
        }

        public static final class a implements z<Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LiveData f20519a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h f20520b;

            a(LiveData liveData, h hVar) {
                this.f20519a = liveData;
                this.f20520b = hVar;
            }

            public final void onChanged(Object obj) {
                kotlin.g.b.k.c(obj, "t");
                if (obj instanceof VIPCashBackOfferV4) {
                    Intent intent = new Intent(this.f20520b.f20518a.getContext(), CashbackCompaignGameDetail.class);
                    intent.putExtra("supercashGame", (Serializable) obj);
                    intent.putExtra("isActivated", true);
                    if (this.f20520b.f20518a.f20506b.length() > 0) {
                        intent.putExtra("activityName", this.f20520b.f20518a.f20506b);
                    }
                    FragmentActivity activity = this.f20520b.f20518a.getActivity();
                    if (activity != null) {
                        activity.startActivityForResult(intent, 105);
                    }
                }
                LiveData liveData = this.f20519a;
                if (liveData != null) {
                    liveData.removeObserver(this);
                }
            }
        }
    }

    public final View a() {
        View view = this.f20505a;
        if (view == null) {
            kotlin.g.b.k.a("mView");
        }
        return view;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        net.one97.paytm.v2.features.cashbackoffers.a.b.j jVar;
        net.one97.paytm.v2.features.offerdetail.a.a.a aVar;
        y<GameOfferDetailModel> yVar;
        LiveData liveData;
        y<GameOfferDetailModel> yVar2;
        LiveData liveData2;
        LiveData liveData3;
        y<String> yVar3;
        kotlin.g.b.k.c(layoutInflater, "inflater");
        boolean z = false;
        View inflate = layoutInflater.inflate(R.layout.fragment_offer_detail_new, viewGroup, false);
        kotlin.g.b.k.a((Object) inflate, "inflater.inflate(\n      …          false\n        )");
        this.f20505a = inflate;
        View view = this.f20505a;
        if (view == null) {
            kotlin.g.b.k.a("mView");
        }
        TextView textView = (TextView) view.findViewById(R.id.pin);
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view2 = this.f20505a;
        if (view2 == null) {
            kotlin.g.b.k.a("mView");
        }
        TextView textView2 = (TextView) view2.findViewById(R.id.pin_text);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view3 = this.f20505a;
        if (view3 == null) {
            kotlin.g.b.k.a("mView");
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view3.findViewById(R.id.imgDealCopy);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        View view4 = this.f20505a;
        if (view4 == null) {
            kotlin.g.b.k.a("mView");
        }
        TextView textView3 = (TextView) view4.findViewById(R.id.tapToAvail);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        View view5 = this.f20505a;
        if (view5 == null) {
            kotlin.g.b.k.a("mView");
        }
        TextView textView4 = (TextView) view5.findViewById(R.id.voucherCodeText);
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        View view6 = this.f20505a;
        if (view6 == null) {
            kotlin.g.b.k.a("mView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view6.findViewById(R.id.dealDetailView);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(4);
        }
        a.C0369a a2 = net.one97.paytm.v2.features.offerdetail.a.a.a();
        FragmentActivity activity = getActivity();
        ArrayList arrayList = null;
        if (activity != null) {
            kotlin.g.b.k.a((Object) activity, "it");
            jVar = new net.one97.paytm.v2.features.cashbackoffers.a.b.j(activity);
        } else {
            jVar = null;
        }
        a.C0369a a3 = a2.a(jVar);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            kotlin.g.b.k.a((Object) activity2, "it");
            aVar = new net.one97.paytm.v2.features.offerdetail.a.a.a(activity2);
        } else {
            aVar = null;
        }
        net.one97.paytm.v2.features.offerdetail.a.b a4 = a3.a(aVar).a();
        this.f20507d = a4.b();
        net.one97.paytm.v2.features.offerdetail.c.a aVar2 = this.f20507d;
        if (aVar2 == null) {
            kotlin.g.b.k.a();
        }
        a4.a(aVar2);
        net.one97.paytm.v2.features.offerdetail.c.a aVar3 = this.f20507d;
        if (!(aVar3 == null || (yVar3 = aVar3.f20458i) == null)) {
            yVar3.observe(this, this.f20508e);
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar4 = this.f20507d;
        if (!(aVar4 == null || (liveData3 = aVar4.f20451b) == null)) {
            liveData3.observe(this, new d(this));
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar5 = this.f20507d;
        if (!(aVar5 == null || (liveData2 = aVar5.f20451b) == null)) {
            liveData2.observe(this, new e(this));
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar6 = this.f20507d;
        if (!(aVar6 == null || (yVar2 = aVar6.j) == null)) {
            yVar2.observe(this, new f(this));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("campaignid")) {
                String string = arguments.getString("campaignid");
                net.one97.paytm.v2.features.offerdetail.c.a aVar7 = this.f20507d;
                if (aVar7 != null) {
                    kotlin.g.b.k.a((Object) string, "campaignId");
                    aVar7.a(string);
                }
                CharSequence charSequence = string;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    arrayList = new ArrayList();
                    arrayList.add(string);
                }
            } else if (arguments.containsKey("campaign") && arguments.getSerializable("campaign") != null) {
                Serializable serializable = arguments.getSerializable("campaign");
                if (serializable != null) {
                    Campaign campaign = (Campaign) serializable;
                    net.one97.paytm.v2.features.offerdetail.c.a aVar8 = this.f20507d;
                    if (aVar8 != null) {
                        aVar8.a(campaign);
                    }
                    CharSequence valueOf = String.valueOf(campaign.getId());
                    if (valueOf == null || valueOf.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        arrayList = new ArrayList();
                        arrayList.add(String.valueOf(campaign.getId()));
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.Campaign");
                }
            }
            ArrayList arrayList2 = arrayList;
            if (arguments.containsKey("activityName")) {
                String string2 = arguments.getString("activityName");
                kotlin.g.b.k.a((Object) string2, "getString(CashbackConstants.ACTIVITY_NAME)");
                this.f20506b = string2;
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(getActivity(), "cashback_offers", "screenview", arrayList2, (String) null, "/offer-details", "cashback");
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar9 = this.f20507d;
        if (!(aVar9 == null || (liveData = aVar9.f20452c) == null)) {
            liveData.observe(this, new g(this));
        }
        net.one97.paytm.v2.features.offerdetail.c.a aVar10 = this.f20507d;
        if (!(aVar10 == null || (yVar = aVar10.f20454e) == null)) {
            yVar.observe(this, new h(this));
        }
        View view7 = this.f20505a;
        if (view7 == null) {
            kotlin.g.b.k.a("mView");
        }
        ImageView imageView = (ImageView) view7.findViewById(R.id.back_arrow);
        if (imageView != null) {
            imageView.setOnClickListener(new i(this));
        }
        View view8 = this.f20505a;
        if (view8 == null) {
            kotlin.g.b.k.a("mView");
        }
        return view8;
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20521a;

        i(b bVar) {
            this.f20521a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f20521a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final class k implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20524a;

        k(b bVar) {
            this.f20524a = bVar;
        }

        /* renamed from: net.one97.paytm.v2.features.offerdetail.ui.b$k$b  reason: collision with other inner class name */
        static final class C0374b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k f20526a;

            C0374b(k kVar) {
                this.f20526a = kVar;
            }

            public final void run() {
                ((ScrollView) this.f20526a.f20524a.a().findViewById(R.id.scrollView)).fullScroll(130);
            }
        }

        public final void onSuccess() {
            ((ScrollView) this.f20524a.a().findViewById(R.id.scrollView)).post(new C0374b(this));
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k f20525a;

            a(k kVar) {
                this.f20525a = kVar;
            }

            public final void run() {
                ((ScrollView) this.f20525a.f20524a.a().findViewById(R.id.scrollView)).fullScroll(130);
            }
        }

        public final void onError(Exception exc) {
            ((ScrollView) this.f20524a.a().findViewById(R.id.scrollView)).post(new a(this));
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20527a;

        l(b bVar) {
            this.f20527a = bVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.v2.features.offerdetail.c.a b2 = this.f20527a.f20507d;
            final LiveData<Object> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                b3.observe(this.f20527a, new z<Object>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ l f20528a;

                    {
                        this.f20528a = r1;
                    }

                    public final void onChanged(Object obj) {
                        Intent intent = new Intent(this.f20528a.f20527a.getActivity(), CashbackDetailActivity.class);
                        if (obj instanceof VIPCashBackOfferV4) {
                            intent.putExtra("supercashGame", (Serializable) obj);
                        } else if (obj instanceof Campaign) {
                            intent.putExtra("campaign", (Serializable) obj);
                        }
                        this.f20528a.f20527a.startActivityForResult(intent, 100);
                        LiveData liveData = b3;
                        if (liveData != null) {
                            liveData.removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20530a;

        m(b bVar) {
            this.f20530a = bVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f20530a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20523b;

        j(b bVar, GameOfferDetailModel gameOfferDetailModel) {
            this.f20522a = bVar;
            this.f20523b = gameOfferDetailModel;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            kotlin.g.b.k.a((Object) view, "it");
            d.a.a(view);
            net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f20522a.getActivity(), this.f20523b.ctaLink);
            CharSequence charSequence = this.f20523b.mCampaignId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                arrayList = new ArrayList();
                arrayList.add(this.f20523b.mCampaignId);
            } else {
                arrayList = null;
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20522a.getActivity(), "cashback_offers", "transaction_cta_clicked", arrayList, (String) null, "/cashback-landing", "cashback");
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20531a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GameOfferDetailModel f20532b;

        n(b bVar, GameOfferDetailModel gameOfferDetailModel) {
            this.f20531a = bVar;
            this.f20532b = gameOfferDetailModel;
        }

        public final void onClick(View view) {
            ArrayList arrayList;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            kotlin.g.b.k.a((Object) view, "it");
            d.a.a(view);
            CharSequence charSequence = this.f20532b.mCampaignId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                arrayList = new ArrayList();
                arrayList.add(this.f20532b.mCampaignId);
            } else {
                arrayList = null;
            }
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(this.f20531a.getActivity(), "cashback_offers", "activate_offers_clicked", arrayList, (String) null, "/cashback-landing", "cashback");
            net.one97.paytm.v2.features.offerdetail.c.a b2 = this.f20531a.f20507d;
            if (b2 != null) {
                b2.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r0 = r0.getBackground();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r6 = this;
            android.view.View r0 = r6.f20505a
            java.lang.String r1 = "mView"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            int r2 = net.one97.paytm.vipcashback.R.id.moreDetails
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "mView.moreDetails"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x0022
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0022:
            int r2 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r2)
            android.widget.Button r0 = (android.widget.Button) r0
            r2 = 0
            if (r0 == 0) goto L_0x0038
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            if (r0 == 0) goto L_0x0038
            android.graphics.drawable.Drawable r0 = r0.mutate()
            goto L_0x0039
        L_0x0038:
            r0 = r2
        L_0x0039:
            if (r0 == 0) goto L_0x0101
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r3 = 3
            android.view.View r4 = r6.f20505a
            if (r4 != 0) goto L_0x0045
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0045:
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.vipcashback.R.color.color_00c4ff
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setStroke(r3, r4)
            android.view.View r3 = r6.f20505a
            if (r3 != 0) goto L_0x0059
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0059:
            android.content.Context r3 = r3.getContext()
            int r4 = net.one97.paytm.vipcashback.R.color.white
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setColor(r3)
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x006d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006d:
            int r3 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r3)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x0086
            android.content.res.Resources r3 = r6.getResources()
            int r4 = net.one97.paytm.vipcashback.R.string.more_details
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0086:
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x008d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x008d:
            int r3 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r3)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x009b
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
        L_0x009b:
            if (r2 == 0) goto L_0x00f9
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            r0 = -2
            r2.width = r0
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x00a9
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00a9:
            int r3 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r3)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x00b8
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0.setLayoutParams(r2)
        L_0x00b8:
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x00bf
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00bf:
            int r2 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r2)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x00dd
            android.view.View r2 = r6.f20505a
            if (r2 != 0) goto L_0x00d0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00d0:
            android.content.Context r2 = r2.getContext()
            int r3 = net.one97.paytm.vipcashback.R.color.color_00c4ff
            int r2 = androidx.core.content.b.c(r2, r3)
            r0.setTextColor(r2)
        L_0x00dd:
            android.view.View r0 = r6.f20505a
            if (r0 != 0) goto L_0x00e4
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e4:
            int r1 = net.one97.paytm.vipcashback.R.id.payButton
            android.view.View r0 = r0.findViewById(r1)
            android.widget.Button r0 = (android.widget.Button) r0
            if (r0 == 0) goto L_0x00f8
            net.one97.paytm.v2.features.offerdetail.ui.b$c r1 = new net.one97.paytm.v2.features.offerdetail.ui.b$c
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x00f8:
            return
        L_0x00f9:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x0101:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.offerdetail.ui.b.b():void");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20511a;

        c(b bVar) {
            this.f20511a = bVar;
        }

        public final void onClick(View view) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            kotlin.g.b.k.a((Object) view, "it");
            d.a.a(view);
            net.one97.paytm.v2.features.offerdetail.c.a b2 = this.f20511a.f20507d;
            final LiveData<Object> b3 = b2 != null ? b2.b() : null;
            if (b3 != null) {
                b3.observe(this.f20511a, new z<Object>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f20512a;

                    {
                        this.f20512a = r1;
                    }

                    public final void onChanged(Object obj) {
                        Intent intent = new Intent(this.f20512a.f20511a.getActivity(), CashbackDetailActivity.class);
                        if (obj instanceof VIPCashBackOfferV4) {
                            intent.putExtra("supercashGame", (Serializable) obj);
                        } else if (obj instanceof Campaign) {
                            intent.putExtra("campaign", (Serializable) obj);
                        }
                        this.f20512a.f20511a.startActivityForResult(intent, 100);
                        LiveData liveData = b3;
                        if (liveData != null) {
                            liveData.removeObserver(this);
                        }
                    }
                });
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        Serializable serializableExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100 && i3 == -1) {
            Intent intent2 = new Intent(getContext(), CashbackCompaignGameDetail.class);
            if (!(intent == null || (serializableExtra = intent.getSerializableExtra("supercashGame")) == null)) {
                intent2.putExtra("supercashGame", serializableExtra);
            }
            intent2.putExtra("isActivated", true);
            if (this.f20506b.length() > 0) {
                intent2.putExtra("activityName", this.f20506b);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivity(intent2);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    static final class g<T> implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20517a;

        g(b bVar) {
            this.f20517a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            b.a(this.f20517a);
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            FragmentActivity activity = this.f20517a.getActivity();
            if (activity != null) {
                d.a.a((Context) (AppCompatActivity) activity, (kotlin.g.a.a<x>) new kotlin.g.a.a<x>(this) {
                    final /* synthetic */ g this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        FragmentActivity activity = this.this$0.f20517a.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    }
                });
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    public static final /* synthetic */ void a(b bVar) {
        if (bVar.getActivity() instanceof CashbackCompaignGameDetail) {
            FragmentActivity activity = bVar.getActivity();
            if (activity != null) {
                ((CashbackCompaignGameDetail) activity).a(false);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail");
            }
        }
        if (bVar.getActivity() instanceof CashBackOfferDetailActivity) {
            FragmentActivity activity2 = bVar.getActivity();
            if (activity2 != null) {
                ((CashBackOfferDetailActivity) activity2).a(false);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.offerdetail.ui.CashBackOfferDetailActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20509f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
