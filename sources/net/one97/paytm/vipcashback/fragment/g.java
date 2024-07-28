package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.vipcashback.R;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20995a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f20996b = f20996b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String f20997c = f20997c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f20998d = f20998d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x0269  */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x0274  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x02c3  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x02e2  */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x030a  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:183:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(android.content.Context r18, android.view.View r19, net.one97.paytm.common.entity.vipcashback.ScratchCardData r20, kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.String, kotlin.x> r21) {
            /*
                r0 = r18
                r1 = r19
                r2 = r20
                r3 = r21
                java.lang.String r4 = "mContext"
                kotlin.g.b.k.c(r0, r4)
                java.lang.String r4 = "view"
                kotlin.g.b.k.c(r1, r4)
                java.lang.String r4 = "mCardInfo"
                kotlin.g.b.k.c(r2, r4)
                int r4 = net.one97.paytm.vipcashback.R.id.confetii
                android.view.View r4 = r1.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                if (r4 == 0) goto L_0x002a
                int r5 = net.one97.paytm.vipcashback.R.drawable.ic_scratched_confetii
                android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r0, (int) r5)
                r4.setImageDrawable(r5)
            L_0x002a:
                java.lang.String r4 = r2.redemptionType
                java.lang.String r5 = "COLLECTIBLE"
                boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
                java.lang.String r5 = "abcd"
                r6 = 0
                r7 = 1
                r8 = 0
                if (r4 == 0) goto L_0x00d9
                android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r18)
                int r4 = net.one97.paytm.vipcashback.R.layout.sticker_card_new
                android.view.View r0 = r0.inflate(r4, r6, r8)
                int r4 = net.one97.paytm.vipcashback.R.id.cardView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.widget.CustomCardView r4 = (net.one97.paytm.vipcashback.widget.CustomCardView) r4
                r4.removeAllViews()
                int r4 = net.one97.paytm.vipcashback.R.id.cardView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.widget.CustomCardView r4 = (net.one97.paytm.vipcashback.widget.CustomCardView) r4
                r4.addView(r0)
                if (r0 == 0) goto L_0x00b3
                int r4 = net.one97.paytm.vipcashback.R.id.congratulationTextView
                android.view.View r4 = r0.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x006a
                java.lang.String r6 = r2.mWinningText
                net.one97.paytm.v2.b.a.a(r4, r6)
            L_0x006a:
                com.squareup.picasso.w r4 = com.squareup.picasso.w.a()
                java.lang.String r6 = r2.mThumbnail
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x007c
                int r6 = r6.length()
                if (r6 != 0) goto L_0x007b
                goto L_0x007c
            L_0x007b:
                r7 = 0
            L_0x007c:
                if (r7 != 0) goto L_0x0080
                java.lang.String r5 = r2.mThumbnail
            L_0x0080:
                com.squareup.picasso.aa r4 = r4.a((java.lang.String) r5)
                int r5 = net.one97.paytm.vipcashback.R.drawable.cashback_placeholder
                com.squareup.picasso.aa r4 = r4.a((int) r5)
                int r5 = net.one97.paytm.vipcashback.R.id.stickerThumbnailView
                android.view.View r5 = r1.findViewById(r5)
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.a((android.widget.ImageView) r5)
                int r4 = net.one97.paytm.vipcashback.R.id.description
                android.view.View r4 = r0.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x00a4
                java.lang.String r5 = r2.frontEndRedemptionType
                net.one97.paytm.v2.b.a.a(r4, r5)
            L_0x00a4:
                int r4 = net.one97.paytm.vipcashback.R.id.stickerCardDescription
                android.view.View r4 = r0.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x00b3
                java.lang.String r5 = r2.redemptionText
                net.one97.paytm.v2.b.a.a(r4, r5)
            L_0x00b3:
                java.lang.Boolean r4 = r2.isStickerType
                java.lang.String r5 = "mCardInfo.isStickerType"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x00d0
                int r4 = net.one97.paytm.vipcashback.R.id.stickerTextView
                android.view.View r1 = r1.findViewById(r4)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r4 = "view?.stickerTextView"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                r1.setVisibility(r8)
            L_0x00d0:
                java.lang.String r1 = "stickerCardView"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                a(r2, r0, r3)
                return
            L_0x00d9:
                java.lang.String r4 = r2.mThumbnail
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x00e8
                int r4 = r4.length()
                if (r4 != 0) goto L_0x00e6
                goto L_0x00e8
            L_0x00e6:
                r4 = 0
                goto L_0x00e9
            L_0x00e8:
                r4 = 1
            L_0x00e9:
                java.lang.String r9 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
                r10 = 8
                java.lang.String r11 = "view?.thumbnailView"
                if (r4 != 0) goto L_0x0166
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x0100
                int r4 = r4.length()
                if (r4 != 0) goto L_0x00fe
                goto L_0x0100
            L_0x00fe:
                r4 = 0
                goto L_0x0101
            L_0x0100:
                r4 = 1
            L_0x0101:
                if (r4 != 0) goto L_0x0127
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.String r12 = net.one97.paytm.vipcashback.fragment.g.f20996b
                boolean r4 = r4.equals(r12)
                if (r4 != 0) goto L_0x0166
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.String r12 = net.one97.paytm.vipcashback.fragment.g.f20997c
                boolean r4 = r4.equals(r12)
                if (r4 != 0) goto L_0x0166
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.String r12 = net.one97.paytm.vipcashback.fragment.g.f20998d
                boolean r4 = r4.equals(r12)
                if (r4 != 0) goto L_0x0166
            L_0x0127:
                int r4 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
                r4.setVisibility(r8)
                com.squareup.picasso.w r4 = com.squareup.picasso.w.a()
                java.lang.String r12 = r2.mThumbnail
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                if (r12 == 0) goto L_0x0148
                int r12 = r12.length()
                if (r12 != 0) goto L_0x0146
                goto L_0x0148
            L_0x0146:
                r12 = 0
                goto L_0x0149
            L_0x0148:
                r12 = 1
            L_0x0149:
                if (r12 != 0) goto L_0x014d
                java.lang.String r5 = r2.mThumbnail
            L_0x014d:
                com.squareup.picasso.aa r4 = r4.a((java.lang.String) r5)
                int r5 = net.one97.paytm.vipcashback.R.drawable.cashback_placeholder
                com.squareup.picasso.aa r4 = r4.a((int) r5)
                int r5 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r5 = r1.findViewById(r5)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r5 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r5
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                r4.a((android.widget.ImageView) r5)
                goto L_0x025f
            L_0x0166:
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x0175
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0173
                goto L_0x0175
            L_0x0173:
                r4 = 0
                goto L_0x0176
            L_0x0175:
                r4 = 1
            L_0x0176:
                if (r4 != 0) goto L_0x022f
                java.lang.String r4 = r2.frontEndRedemptionType
                java.lang.String r5 = net.one97.paytm.vipcashback.fragment.g.f20998d
                boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
                if (r4 == 0) goto L_0x022f
                int r4 = net.one97.paytm.vipcashback.R.id.scratch_view
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout r4 = (net.one97.paytm.vipcashback.view.CustomScratchableRelativeLayout) r4
                java.lang.String r5 = "scratchableView"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
                r4.setVisibility(r10)
                int r4 = net.one97.paytm.vipcashback.R.id.topLayout
                android.view.View r4 = r1.findViewById(r4)
                androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
                if (r4 == 0) goto L_0x01a9
                android.graphics.drawable.Drawable r4 = r4.getBackground()
                if (r4 == 0) goto L_0x01a9
                android.graphics.drawable.Drawable r4 = r4.mutate()
                goto L_0x01aa
            L_0x01a9:
                r4 = r6
            L_0x01aa:
                if (r4 == 0) goto L_0x0227
                android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
                int r5 = net.one97.paytm.vipcashback.R.color.color_191e33
                int r5 = androidx.core.content.b.c(r0, r5)
                r4.setColor(r5)
                int r4 = net.one97.paytm.vipcashback.R.id.confetii
                android.view.View r4 = r1.findViewById(r4)
                android.widget.ImageView r4 = (android.widget.ImageView) r4
                if (r4 == 0) goto L_0x01ca
                int r5 = net.one97.paytm.vipcashback.R.drawable.ic_scratch_card_first_points_confetti
                android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r0, (int) r5)
                r4.setImageDrawable(r5)
            L_0x01ca:
                int r4 = net.one97.paytm.vipcashback.R.id.cardTitle
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x01dd
                int r5 = net.one97.paytm.vipcashback.R.color.color_D5A55D
                int r5 = androidx.core.content.b.c(r0, r5)
                r4.setTextColor(r5)
            L_0x01dd:
                int r4 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x01ec
                android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                goto L_0x01ed
            L_0x01ec:
                r4 = r6
            L_0x01ed:
                if (r4 == 0) goto L_0x0221
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
                android.content.res.Resources r5 = r18.getResources()
                int r12 = net.one97.paytm.common.assets.R.dimen.dimen_40dp
                int r5 = r5.getDimensionPixelOffset(r12)
                r4.setMargins(r8, r5, r8, r8)
                int r5 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r5 = r1.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                if (r5 == 0) goto L_0x0211
                int r12 = net.one97.paytm.vipcashback.R.color.white
                int r12 = androidx.core.content.b.c(r0, r12)
                r5.setTextColor(r12)
            L_0x0211:
                int r5 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r5 = r1.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                if (r5 == 0) goto L_0x025f
                android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
                r5.setLayoutParams(r4)
                goto L_0x025f
            L_0x0221:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            L_0x0227:
                kotlin.u r0 = new kotlin.u
                java.lang.String r1 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
                r0.<init>(r1)
                throw r0
            L_0x022f:
                int r4 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x023e
                android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                goto L_0x023f
            L_0x023e:
                r4 = r6
            L_0x023f:
                if (r4 == 0) goto L_0x0407
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
                android.content.res.Resources r5 = r18.getResources()
                int r12 = net.one97.paytm.common.assets.R.dimen.dimen_40dp
                int r5 = r5.getDimensionPixelOffset(r12)
                r4.setMargins(r8, r5, r8, r8)
                int r5 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r5 = r1.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                if (r5 == 0) goto L_0x025f
                android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
                r5.setLayoutParams(r4)
            L_0x025f:
                int r4 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x0270
                java.lang.String r5 = r2.mWinningText
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r4.setText(r5)
            L_0x0270:
                java.lang.String r4 = r2.mCashBackAmount
                if (r4 == 0) goto L_0x02b9
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x0281
                int r4 = r4.length()
                if (r4 != 0) goto L_0x027f
                goto L_0x0281
            L_0x027f:
                r4 = 0
                goto L_0x0282
            L_0x0281:
                r4 = 1
            L_0x0282:
                if (r4 != 0) goto L_0x02b9
                int r4 = net.one97.paytm.vipcashback.R.id.amountTextView
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x02b9
                boolean r5 = r2.keepRupeeSign
                java.lang.String r12 = ""
                if (r5 != r7) goto L_0x02ac
                int r5 = net.one97.paytm.vipcashback.R.id.ruppe
                android.view.View r5 = r1.findViewById(r5)
                android.widget.TextView r5 = (android.widget.TextView) r5
                if (r5 == 0) goto L_0x02a1
                r5.setVisibility(r8)
            L_0x02a1:
                java.lang.String r5 = r2.mCashBackAmount
                if (r5 == 0) goto L_0x02a8
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                goto L_0x02b6
            L_0x02a8:
                r5 = r12
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                goto L_0x02b6
            L_0x02ac:
                java.lang.String r5 = r2.mCashBackAmount
                if (r5 == 0) goto L_0x02b3
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                goto L_0x02b6
            L_0x02b3:
                r5 = r12
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            L_0x02b6:
                r4.setText(r5)
            L_0x02b9:
                int r4 = net.one97.paytm.vipcashback.R.id.cardTitle
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x02d2
                java.lang.String r5 = r2.frontEndRedemptionType
                if (r5 == 0) goto L_0x02cc
                java.lang.String r5 = kotlin.m.p.f(r5)
                goto L_0x02cd
            L_0x02cc:
                r5 = r6
            L_0x02cd:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r4.setText(r5)
            L_0x02d2:
                java.lang.String r4 = r2.redemptionText
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x02e0
                int r4 = r4.length()
                if (r4 != 0) goto L_0x02df
                goto L_0x02e0
            L_0x02df:
                r7 = 0
            L_0x02e0:
                if (r7 != 0) goto L_0x0300
                int r4 = net.one97.paytm.vipcashback.R.id.cardDescription
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x02ef
                r4.setVisibility(r8)
            L_0x02ef:
                int r4 = net.one97.paytm.vipcashback.R.id.cardDescription
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x0300
                java.lang.String r5 = r2.redemptionText
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r4.setText(r5)
            L_0x0300:
                int r4 = net.one97.paytm.vipcashback.R.id.cashbackCTA
                android.view.View r4 = r1.findViewById(r4)
                android.widget.TextView r4 = (android.widget.TextView) r4
                if (r4 == 0) goto L_0x0314
                net.one97.paytm.vipcashback.fragment.g$a$a r5 = new net.one97.paytm.vipcashback.fragment.g$a$a
                r5.<init>(r0)
                android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
                r4.setOnClickListener(r5)
            L_0x0314:
                a(r2, r1, r3)
                boolean r3 = r2.isBetterLuck
                if (r3 == 0) goto L_0x0406
                int r3 = net.one97.paytm.vipcashback.R.id.confetii
                android.view.View r3 = r1.findViewById(r3)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                if (r3 == 0) goto L_0x0328
                r3.setVisibility(r10)
            L_0x0328:
                androidx.constraintlayout.widget.c r3 = new androidx.constraintlayout.widget.c
                r3.<init>()
                int r4 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
                int r13 = r4.getId()
                r14 = 4
                r15 = 0
                r16 = 4
                r17 = 0
                r12 = r3
                r12.a(r13, r14, r15, r16, r17)
                int r4 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
                int r13 = r4.getId()
                r14 = 3
                r16 = 3
                r12.a(r13, r14, r15, r16, r17)
                int r4 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
                int r13 = r4.getId()
                r14 = 1
                r16 = 1
                r12.a(r13, r14, r15, r16, r17)
                int r4 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r4 = r1.findViewById(r4)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r4 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r4
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r11)
                int r13 = r4.getId()
                r14 = 2
                r16 = 2
                r12.a(r13, r14, r15, r16, r17)
                int r4 = net.one97.paytm.vipcashback.R.id.topLayout
                android.view.View r4 = r1.findViewById(r4)
                androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
                r3.c((androidx.constraintlayout.widget.ConstraintLayout) r4)
                int r3 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r3 = r1.findViewById(r3)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r3 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r3
                if (r3 == 0) goto L_0x039e
                android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            L_0x039e:
                if (r6 == 0) goto L_0x0400
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
                android.content.res.Resources r3 = r18.getResources()
                int r4 = net.one97.paytm.common.assets.R.dimen.dimen_88dp
                int r3 = r3.getDimensionPixelOffset(r4)
                r6.width = r3
                r6.height = r3
                int r3 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r3 = r1.findViewById(r3)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r3 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r3
                if (r3 == 0) goto L_0x03bf
                android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
                r3.setLayoutParams(r6)
            L_0x03bf:
                boolean r2 = r2.isFlip
                if (r2 == 0) goto L_0x03f2
                int r2 = net.one97.paytm.vipcashback.R.id.winningText
                android.view.View r2 = r1.findViewById(r2)
                android.widget.TextView r2 = (android.widget.TextView) r2
                if (r2 == 0) goto L_0x03d0
                r2.setVisibility(r10)
            L_0x03d0:
                int r2 = net.one97.paytm.vipcashback.R.id.cashbackCTA
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x03f1
                android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                r3 = -2
                r2.width = r3
                android.content.res.Resources r0 = r18.getResources()
                int r3 = net.one97.paytm.common.assets.R.dimen.dimen_16dp
                int r0 = r0.getDimensionPixelOffset(r3)
                r1.setPadding(r0, r8, r0, r8)
                r1.setLayoutParams(r2)
            L_0x03f1:
                return
            L_0x03f2:
                int r0 = net.one97.paytm.vipcashback.R.id.cashbackCTA
                android.view.View r0 = r1.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                if (r0 == 0) goto L_0x0406
                r0.setVisibility(r10)
                return
            L_0x0400:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            L_0x0406:
                return
            L_0x0407:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.g.a.a(android.content.Context, android.view.View, net.one97.paytm.common.entity.vipcashback.ScratchCardData, kotlin.g.a.m):void");
        }

        /* renamed from: net.one97.paytm.vipcashback.fragment.g$a$a  reason: collision with other inner class name */
        static final class C0407a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20999a;

            C0407a(Context context) {
                this.f20999a = context;
            }

            public final void onClick(View view) {
                Toast.makeText(this.f20999a, "button clicked", 0).show();
            }
        }

        private static void a(ScratchCardData scratchCardData, View view, m<? super Integer, ? super String, x> mVar) {
            TextView textView;
            TextView textView2;
            String str = scratchCardData.redemptionCTA;
            if (str != null) {
                if (!(view == null || (textView2 = (TextView) view.findViewById(R.id.cashbackCTA)) == null)) {
                    net.one97.paytm.v2.b.a.a(textView2, scratchCardData.redemptionCTA);
                }
                if (view != null && (textView = (TextView) view.findViewById(R.id.cashbackCTA)) != null) {
                    textView.setVisibility(0);
                    textView.setText(str);
                    if (!scratchCardData.isFlip) {
                        textView.setOnClickListener(new b(textView, str, view, scratchCardData, mVar));
                    } else {
                        textView.setOnClickListener(new c(str, view, scratchCardData, mVar));
                    }
                }
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TextView f21000a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f21001b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f21002c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ScratchCardData f21003d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ m f21004e;

            b(TextView textView, String str, View view, ScratchCardData scratchCardData, m mVar) {
                this.f21000a = textView;
                this.f21001b = str;
                this.f21002c = view;
                this.f21003d = scratchCardData;
                this.f21004e = mVar;
            }

            public final void onClick(View view) {
                CharSequence charSequence = this.f21003d.redemptionCTADeeplink;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    net.one97.paytm.vipcashback.c.a.b().checkDeepLinking(this.f21000a.getContext(), this.f21003d.redemptionCTADeeplink);
                }
            }
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f21005a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f21006b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ScratchCardData f21007c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ m f21008d;

            c(String str, View view, ScratchCardData scratchCardData, m mVar) {
                this.f21005a = str;
                this.f21006b = view;
                this.f21007c = scratchCardData;
                this.f21008d = mVar;
            }

            public final void onClick(View view) {
                TextView textView;
                View view2 = this.f21006b;
                LottieAnimationView lottieAnimationView = view2 != null ? (LottieAnimationView) view2.findViewById(R.id.loadingView) : null;
                View view3 = this.f21006b;
                if (!(view3 == null || (textView = (TextView) view3.findViewById(R.id.cashbackCTA)) == null)) {
                    textView.setVisibility(4);
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(0);
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.setAnimation("Payments-Loader_cb.json");
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.loop(true);
                }
                if (lottieAnimationView != null) {
                    lottieAnimationView.playAnimation();
                }
                m mVar = this.f21008d;
                if (mVar != null) {
                    String str = this.f21007c.refrenceId;
                    k.a((Object) str, "mCardInfo.refrenceId");
                    mVar.invoke(1, str);
                }
            }
        }
    }
}
