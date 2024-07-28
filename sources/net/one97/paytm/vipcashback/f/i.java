package net.one97.paytm.vipcashback.f;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.x;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.vipcashback.fragment.f;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20896a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ View a(ScratchCardData scratchCardData, Context context, boolean z, int i2) {
            return a(scratchCardData, context, (m<? super Integer, ? super String, x>) null, (ArrayList<f>) null, (i2 & 512) != 0 ? true : z, (kotlin.g.a.b<? super String, x>) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:109:0x0391  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x039f  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0122  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x01e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static android.view.View a(net.one97.paytm.common.entity.vipcashback.ScratchCardData r17, android.content.Context r18, kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.String, kotlin.x> r19, java.util.ArrayList<net.one97.paytm.vipcashback.fragment.f> r20, boolean r21, kotlin.g.a.b<? super java.lang.String, kotlin.x> r22) {
            /*
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = r20
                r4 = r21
                java.lang.String r5 = "scratchCardData"
                kotlin.g.b.k.c(r0, r5)
                java.lang.String r5 = "mContext"
                kotlin.g.b.k.c(r1, r5)
                boolean r5 = r0.isLockedCard
                java.lang.String r6 = "view.scratchHereView"
                java.lang.String r7 = "view.lockView"
                java.lang.String r8 = "view.cashBackUnit"
                java.lang.String r10 = "view"
                java.lang.String r11 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
                java.lang.String r12 = "view.lockedCardDescription"
                r13 = 8
                r14 = 0
                r15 = 0
                if (r5 == 0) goto L_0x01e7
                android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r18)
                int r9 = net.one97.paytm.vipcashback.R.layout.locked_card_new
                android.view.View r5 = r5.inflate(r9, r14, r15)
                java.lang.String r9 = r0.cardHeadline
                if (r9 == 0) goto L_0x0067
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                if (r9 == 0) goto L_0x0044
                int r9 = r9.length()
                if (r9 != 0) goto L_0x0041
                goto L_0x0044
            L_0x0041:
                r16 = 0
                goto L_0x0046
            L_0x0044:
                r16 = 1
            L_0x0046:
                if (r16 != 0) goto L_0x0067
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
                int r1 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r5.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0089
                android.view.View r1 = (android.view.View) r1
                int r9 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r1.findViewById(r9)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0089
                java.lang.String r9 = r0.cardHeadline
                net.one97.paytm.v2.b.a.a(r1, r9)
                goto L_0x0089
            L_0x0067:
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
                int r9 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r9 = r5.findViewById(r9)
                android.widget.TextView r9 = (android.widget.TextView) r9
                if (r9 == 0) goto L_0x0089
                android.view.View r9 = (android.view.View) r9
                int r10 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r9 = r9.findViewById(r10)
                android.widget.TextView r9 = (android.widget.TextView) r9
                if (r9 == 0) goto L_0x0089
                int r10 = net.one97.paytm.vipcashback.R.string.sticker_winning_text
                java.lang.CharSequence r1 = r1.getText(r10)
                r9.setText(r1)
            L_0x0089:
                java.lang.Boolean r1 = r0.luckyDraw
                java.lang.Boolean r9 = java.lang.Boolean.TRUE
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r9)
                java.lang.String r9 = "view.luckyAmountView"
                if (r1 == 0) goto L_0x00b6
                net.one97.paytm.vipcashback.f.j r1 = net.one97.paytm.vipcashback.f.j.LUCKY_DRAW_THEME
                int r10 = net.one97.paytm.vipcashback.R.id.luckyAmountView
                android.view.View r10 = r5.findViewById(r10)
                android.widget.TextView r10 = (android.widget.TextView) r10
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
                r10.setVisibility(r15)
                int r10 = net.one97.paytm.vipcashback.R.id.luckyAmountView
                android.view.View r10 = r5.findViewById(r10)
                android.widget.TextView r10 = (android.widget.TextView) r10
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
                java.lang.String r9 = r0.redemptionMaxAmount
                net.one97.paytm.v2.b.a.a(r10, r9)
                goto L_0x00cc
            L_0x00b6:
                net.one97.paytm.vipcashback.f.d$a r1 = net.one97.paytm.vipcashback.f.d.f20859a
                java.lang.String r1 = r0.scratchCardId
                net.one97.paytm.vipcashback.f.j r1 = net.one97.paytm.vipcashback.f.d.a.a((java.lang.String) r1, (boolean) r15)
                int r10 = net.one97.paytm.vipcashback.R.id.luckyAmountView
                android.view.View r10 = r5.findViewById(r10)
                android.widget.TextView r10 = (android.widget.TextView) r10
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
                r10.setVisibility(r13)
            L_0x00cc:
                int r9 = net.one97.paytm.vipcashback.R.id.container
                android.view.View r9 = r5.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                if (r9 == 0) goto L_0x00d9
                r9.setVisibility(r15)
            L_0x00d9:
                int r9 = net.one97.paytm.vipcashback.R.id.close
                android.view.View r9 = r5.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                if (r9 == 0) goto L_0x00e6
                r9.setVisibility(r15)
            L_0x00e6:
                int r9 = net.one97.paytm.vipcashback.R.id.cashBackUnit
                android.view.View r9 = r5.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
                r9.setVisibility(r15)
                int r8 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r8 = r5.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r12)
                r8.setVisibility(r15)
                int r8 = net.one97.paytm.vipcashback.R.id.lockView
                android.view.View r8 = r5.findViewById(r8)
                android.widget.ImageView r8 = (android.widget.ImageView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
                r8.setVisibility(r15)
                int r7 = net.one97.paytm.vipcashback.R.id.container
                android.view.View r7 = r5.findViewById(r7)
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                if (r7 == 0) goto L_0x011f
                android.graphics.drawable.Drawable r7 = r7.getBackground()
                goto L_0x0120
            L_0x011f:
                r7 = r14
            L_0x0120:
                if (r7 == 0) goto L_0x01e1
                android.graphics.drawable.GradientDrawable r7 = (android.graphics.drawable.GradientDrawable) r7
                if (r7 == 0) goto L_0x0131
                java.lang.String r8 = r1.getBgColor()
                int r8 = android.graphics.Color.parseColor(r8)
                r7.setColor(r8)
            L_0x0131:
                int r7 = net.one97.paytm.vipcashback.R.id.lockedCardBottomLayout
                android.view.View r7 = r5.findViewById(r7)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                int r8 = net.one97.paytm.vipcashback.R.drawable.locked_card_text_bg_drawable
                r7.setBackgroundResource(r8)
                int r7 = net.one97.paytm.vipcashback.R.id.lockedCardBottomLayout
                android.view.View r7 = r5.findViewById(r7)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                if (r7 == 0) goto L_0x014d
                android.graphics.drawable.Drawable r7 = r7.getBackground()
                goto L_0x014e
            L_0x014d:
                r7 = r14
            L_0x014e:
                if (r7 == 0) goto L_0x01db
                android.graphics.drawable.GradientDrawable r7 = (android.graphics.drawable.GradientDrawable) r7
                if (r7 == 0) goto L_0x015f
                java.lang.String r8 = r1.getTextBgColor()
                int r8 = android.graphics.Color.parseColor(r8)
                r7.setColor(r8)
            L_0x015f:
                int r7 = net.one97.paytm.vipcashback.R.id.scratchHereView
                android.view.View r7 = r5.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
                r7.setVisibility(r13)
                int r6 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r6 = r5.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
                java.lang.String r0 = r0.description
                net.one97.paytm.v2.b.a.a(r6, r0)
                int r0 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r0 = r5.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                java.lang.String r6 = r1.getTextColor()
                int r6 = android.graphics.Color.parseColor(r6)
                r0.setTextColor(r6)
                int r0 = net.one97.paytm.vipcashback.R.id.bgConfetti
                android.view.View r0 = r5.findViewById(r0)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                int r6 = r1.getIcon()
                r0.setImageResource(r6)
                int r0 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r0 = r5.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                java.lang.String r1 = r1.getTextColor()
                int r1 = android.graphics.Color.parseColor(r1)
                r0.setTextColor(r1)
                if (r3 == 0) goto L_0x01b7
                r3.add(r14)
            L_0x01b7:
                if (r4 != 0) goto L_0x01c6
                int r0 = net.one97.paytm.vipcashback.R.id.close
                android.view.View r0 = r5.findViewById(r0)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                if (r0 == 0) goto L_0x01c6
                r0.setVisibility(r13)
            L_0x01c6:
                int r0 = net.one97.paytm.vipcashback.R.id.parentView
                android.view.View r0 = r5.findViewById(r0)
                androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
                if (r0 == 0) goto L_0x01da
                net.one97.paytm.vipcashback.f.i$a$a r1 = new net.one97.paytm.vipcashback.f.i$a$a
                r1.<init>(r2)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
            L_0x01da:
                return r5
            L_0x01db:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r11)
                throw r0
            L_0x01e1:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r11)
                throw r0
            L_0x01e7:
                boolean r5 = r0.isGame
                if (r5 == 0) goto L_0x03b6
                android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r18)
                int r9 = net.one97.paytm.vipcashback.R.layout.locked_card_new
                android.view.View r5 = r5.inflate(r9, r14, r15)
                net.one97.paytm.vipcashback.f.j r9 = net.one97.paytm.vipcashback.f.j.GAME_CAMPAIGN_THEME
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
                int r10 = net.one97.paytm.vipcashback.R.id.container
                android.view.View r10 = r5.findViewById(r10)
                android.widget.ImageView r10 = (android.widget.ImageView) r10
                java.lang.String r14 = "view.container"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r14)
                r10.setVisibility(r15)
                int r10 = net.one97.paytm.vipcashback.R.id.close
                android.view.View r10 = r5.findViewById(r10)
                android.widget.ImageView r10 = (android.widget.ImageView) r10
                if (r10 == 0) goto L_0x0217
                r10.setVisibility(r15)
            L_0x0217:
                int r10 = net.one97.paytm.vipcashback.R.id.cashBackUnit
                android.view.View r10 = r5.findViewById(r10)
                android.widget.ImageView r10 = (android.widget.ImageView) r10
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r8)
                r10.setVisibility(r15)
                int r8 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r8 = r5.findViewById(r8)
                android.widget.TextView r8 = (android.widget.TextView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r12)
                r8.setVisibility(r15)
                int r8 = net.one97.paytm.vipcashback.R.id.lockView
                android.view.View r8 = r5.findViewById(r8)
                android.widget.ImageView r8 = (android.widget.ImageView) r8
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
                r8.setVisibility(r15)
                int r7 = net.one97.paytm.vipcashback.R.id.container
                android.view.View r7 = r5.findViewById(r7)
                android.widget.ImageView r7 = (android.widget.ImageView) r7
                if (r7 == 0) goto L_0x0250
                android.graphics.drawable.Drawable r14 = r7.getBackground()
                goto L_0x0251
            L_0x0250:
                r14 = 0
            L_0x0251:
                if (r14 == 0) goto L_0x03b0
                android.graphics.drawable.GradientDrawable r14 = (android.graphics.drawable.GradientDrawable) r14
                if (r14 == 0) goto L_0x0262
                java.lang.String r7 = r9.getBgColor()
                int r7 = android.graphics.Color.parseColor(r7)
                r14.setColor(r7)
            L_0x0262:
                int r7 = net.one97.paytm.vipcashback.R.id.lockedCardBottomLayout
                android.view.View r7 = r5.findViewById(r7)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                int r8 = net.one97.paytm.vipcashback.R.drawable.locked_card_text_bg_drawable
                r7.setBackgroundResource(r8)
                int r7 = net.one97.paytm.vipcashback.R.id.lockedCardBottomLayout
                android.view.View r7 = r5.findViewById(r7)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                if (r7 == 0) goto L_0x027e
                android.graphics.drawable.Drawable r14 = r7.getBackground()
                goto L_0x027f
            L_0x027e:
                r14 = 0
            L_0x027f:
                if (r14 == 0) goto L_0x03aa
                android.graphics.drawable.GradientDrawable r14 = (android.graphics.drawable.GradientDrawable) r14
                if (r14 == 0) goto L_0x0290
                java.lang.String r7 = r9.getTextBgColor()
                int r7 = android.graphics.Color.parseColor(r7)
                r14.setColor(r7)
            L_0x0290:
                int r7 = net.one97.paytm.vipcashback.R.id.scratchHereView
                android.view.View r7 = r5.findViewById(r7)
                android.widget.TextView r7 = (android.widget.TextView) r7
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
                r7.setVisibility(r13)
                int r6 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r6 = r5.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
                java.lang.String r7 = r0.description
                net.one97.paytm.v2.b.a.a(r6, r7)
                int r6 = net.one97.paytm.vipcashback.R.id.lockedCardDescription
                android.view.View r6 = r5.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                java.lang.String r7 = r9.getTextColor()
                int r7 = android.graphics.Color.parseColor(r7)
                r6.setTextColor(r7)
                int r6 = net.one97.paytm.vipcashback.R.id.bgConfetti
                android.view.View r6 = r5.findViewById(r6)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                int r7 = r9.getIcon()
                r6.setImageResource(r7)
                java.lang.String r6 = r0.cardHeadline
                if (r6 == 0) goto L_0x0302
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                if (r6 == 0) goto L_0x02e2
                int r6 = r6.length()
                if (r6 != 0) goto L_0x02df
                goto L_0x02e2
            L_0x02df:
                r16 = 0
                goto L_0x02e4
            L_0x02e2:
                r16 = 1
            L_0x02e4:
                if (r16 != 0) goto L_0x0302
                int r1 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r5.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0321
                android.view.View r1 = (android.view.View) r1
                int r6 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r1.findViewById(r6)
                android.widget.TextView r1 = (android.widget.TextView) r1
                if (r1 == 0) goto L_0x0321
                java.lang.String r6 = r0.cardHeadline
                net.one97.paytm.v2.b.a.a(r1, r6)
                goto L_0x0321
            L_0x0302:
                int r6 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r6 = r5.findViewById(r6)
                android.widget.TextView r6 = (android.widget.TextView) r6
                if (r6 == 0) goto L_0x0321
                android.view.View r6 = (android.view.View) r6
                int r7 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r6 = r6.findViewById(r7)
                android.widget.TextView r6 = (android.widget.TextView) r6
                if (r6 == 0) goto L_0x0321
                int r7 = net.one97.paytm.vipcashback.R.string.sticker_winning_text
                java.lang.CharSequence r1 = r1.getText(r7)
                r6.setText(r1)
            L_0x0321:
                int r1 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r5.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r6 = r9.getTextColor()
                int r6 = android.graphics.Color.parseColor(r6)
                r1.setTextColor(r6)
                int r1 = net.one97.paytm.vipcashback.R.id.title
                android.view.View r1 = r5.findViewById(r1)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r6 = "view.title"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                r6 = 4
                r1.setVisibility(r6)
                int r1 = net.one97.paytm.vipcashback.R.id.bgConfetti
                android.view.View r1 = r5.findViewById(r1)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                java.lang.String r6 = "view.bgConfetti"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
                r1.setVisibility(r13)
                if (r4 != 0) goto L_0x0364
                int r1 = net.one97.paytm.vipcashback.R.id.close
                android.view.View r1 = r5.findViewById(r1)
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                if (r1 == 0) goto L_0x0364
                r1.setVisibility(r13)
            L_0x0364:
                com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
                java.lang.String r0 = r0.scratchCardImage
                com.squareup.picasso.aa r0 = r1.a((java.lang.String) r0)
                int r1 = net.one97.paytm.vipcashback.R.drawable.cashback_bg_place_holder
                com.squareup.picasso.aa r0 = r0.a((int) r1)
                int r1 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r1 = r5.findViewById(r1)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r1 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r1
                r0.a((android.widget.ImageView) r1)
                int r0 = net.one97.paytm.vipcashback.R.id.thumbnailView
                android.view.View r0 = r5.findViewById(r0)
                net.one97.paytm.vipcashback.view.CircularImageViewCashback r0 = (net.one97.paytm.vipcashback.view.CircularImageViewCashback) r0
                java.lang.String r1 = "view.thumbnailView"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r0.setVisibility(r15)
                if (r3 == 0) goto L_0x0395
                r0 = 0
                r3.add(r0)
            L_0x0395:
                int r0 = net.one97.paytm.vipcashback.R.id.parentView
                android.view.View r0 = r5.findViewById(r0)
                androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
                if (r0 == 0) goto L_0x03a9
                net.one97.paytm.vipcashback.f.i$a$b r1 = new net.one97.paytm.vipcashback.f.i$a$b
                r1.<init>(r2)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
            L_0x03a9:
                return r5
            L_0x03aa:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r11)
                throw r0
            L_0x03b0:
                kotlin.u r0 = new kotlin.u
                r0.<init>(r11)
                throw r0
            L_0x03b6:
                net.one97.paytm.vipcashback.fragment.f r5 = new net.one97.paytm.vipcashback.fragment.f
                r6 = r22
                r5.<init>(r1, r0, r4, r6)
                android.view.View r0 = r5.a((kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.String, kotlin.x>) r2)
                if (r0 != 0) goto L_0x03c6
                kotlin.g.b.k.a()
            L_0x03c6:
                int r1 = net.one97.paytm.vipcashback.R.id.containerRL
                android.view.View r1 = r0.findViewById(r1)
                androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
                int r2 = net.one97.paytm.vipcashback.R.id.parentView
                android.view.View r1 = r1.findViewById(r2)
                androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
                net.one97.paytm.vipcashback.f.i$a$c r2 = new net.one97.paytm.vipcashback.f.i$a$c
                r2.<init>()
                android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
                r1.setOnClickListener(r2)
                if (r3 == 0) goto L_0x03e5
                r3.add(r5)
            L_0x03e5:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.f.i.a.a(net.one97.paytm.common.entity.vipcashback.ScratchCardData, android.content.Context, kotlin.g.a.m, java.util.ArrayList, boolean, kotlin.g.a.b):android.view.View");
        }

        /* renamed from: net.one97.paytm.vipcashback.f.i$a$a  reason: collision with other inner class name */
        static final class C0401a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m f20897a;

            C0401a(m mVar) {
                this.f20897a = mVar;
            }

            public final void onClick(View view) {
                m mVar = this.f20897a;
                if (mVar != null) {
                    mVar.invoke(3, "");
                }
            }
        }

        static final class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m f20898a;

            b(m mVar) {
                this.f20898a = mVar;
            }

            public final void onClick(View view) {
                m mVar = this.f20898a;
                if (mVar != null) {
                    mVar.invoke(3, "");
                }
            }
        }

        static final class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f20899a = false;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewPager f20900b = null;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f20901c = 0;

            c() {
            }

            public final void onClick(View view) {
                ViewPager viewPager;
                if (this.f20899a && (viewPager = this.f20900b) != null) {
                    viewPager.setCurrentItem(this.f20901c);
                }
            }
        }
    }
}
