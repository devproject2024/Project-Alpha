package net.one97.paytm.passbook.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.utility.n;

public final class e extends com.google.android.material.bottomsheet.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f57225a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private CJRSubWallet f57226b;

    /* renamed from: c  reason: collision with root package name */
    private n f57227c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57228d;

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
            aVar.setOnShowListener(c.f57230a);
            return aVar;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    static final class c implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57230a = new c();

        c() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            if (dialogInterface != null) {
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                if (frameLayout == null) {
                    k.a();
                }
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from(bottomSheet!!)");
                from.setState(3);
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0093, code lost:
        r2 = "";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setupDialog(android.app.Dialog r13, int r14) {
        /*
            r12 = this;
            java.lang.String r0 = "dialog"
            kotlin.g.b.k.c(r13, r0)
            super.setupDialog(r13, r14)
            android.content.Context r14 = r12.getContext()
            int r0 = net.one97.paytm.passbook.R.layout.pass_wallet_detail_bottom_sheet_dialog
            r1 = 0
            android.view.View r14 = android.view.View.inflate(r14, r0, r1)
            r13.setContentView(r14)
            android.view.ViewParent r13 = r14.getParent()     // Catch:{ Exception -> 0x0035 }
            if (r13 == 0) goto L_0x002d
            android.view.View r13 = (android.view.View) r13     // Catch:{ Exception -> 0x0035 }
            android.content.res.Resources r0 = r12.getResources()     // Catch:{ Exception -> 0x0035 }
            r2 = 17170445(0x106000d, float:2.461195E-38)
            int r0 = r0.getColor(r2)     // Catch:{ Exception -> 0x0035 }
            r13.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0036
        L_0x002d:
            kotlin.u r13 = new kotlin.u     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = "null cannot be cast to non-null type android.view.View"
            r13.<init>(r0)     // Catch:{ Exception -> 0x0035 }
            throw r13     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
        L_0x0036:
            java.lang.String r13 = "contentView"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            net.one97.paytm.passbook.beans.CJRSubWallet r13 = r12.f57226b
            java.lang.String r0 = "mSubwallet"
            if (r13 != 0) goto L_0x0044
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0044:
            if (r13 == 0) goto L_0x0053
            net.one97.paytm.passbook.beans.CJRSubWallet r13 = r12.f57226b
            if (r13 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x004d:
            net.one97.paytm.passbook.beans.WalletDetailInfo$Companion r1 = net.one97.paytm.passbook.beans.WalletDetailInfo.Companion
            net.one97.paytm.passbook.beans.WalletDetailInfo r1 = r1.getWalletData(r13)
        L_0x0053:
            if (r1 == 0) goto L_0x021e
            int r13 = net.one97.paytm.passbook.R.id.titleTv
            android.view.View r13 = r14.findViewById(r13)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            int r2 = r1.getTitle()
            r13.setText(r2)
            int r13 = net.one97.paytm.passbook.R.id.descTv
            android.view.View r13 = r14.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r2 = "view.descTv"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            android.content.Context r2 = r14.getContext()
            java.lang.String r3 = "view.context"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.passbook.utility.n r2 = r12.f57227c
            if (r2 != 0) goto L_0x0083
            java.lang.String r3 = "passbookType"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0083:
            int[] r3 = net.one97.paytm.passbook.customview.f.f57231a
            int r2 = r2.ordinal()
            r2 = r3[r2]
            java.lang.String r3 = "java.lang.String.format(format, *args)"
            r4 = 1
            r5 = 2
            r6 = 0
            switch(r2) {
                case 1: goto L_0x011f;
                case 2: goto L_0x0116;
                case 3: goto L_0x010d;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00d8;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00a3;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0099;
                default: goto L_0x0093;
            }
        L_0x0093:
            java.lang.String r2 = ""
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x0099:
            int r2 = net.one97.paytm.passbook.R.string.pass_paytm_coins_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x00a3:
            net.one97.paytm.passbook.beans.CJRSubWallet r2 = r12.f57226b
            if (r2 != 0) goto L_0x00aa
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00aa:
            java.lang.String r2 = r2.getIssuerMetadata()
            kotlin.g.b.aa r7 = kotlin.g.b.aa.f47921a
            int r7 = net.one97.paytm.passbook.R.string.loyalty_wallet_generic_detail
            java.lang.String r7 = r12.getString(r7)
            java.lang.String r8 = "getString(R.string.loyalty_wallet_generic_detail)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r6] = r2
            r8[r4] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r8, r5)
            java.lang.String r2 = java.lang.String.format(r7, r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x00cf:
            int r2 = net.one97.paytm.passbook.R.string.communication_wallet_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x00d8:
            int r2 = net.one97.paytm.passbook.R.string.fuel_wallet_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x00e1:
            net.one97.paytm.passbook.beans.CJRSubWallet r2 = r12.f57226b
            if (r2 != 0) goto L_0x00e8
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00e8:
            java.lang.String r2 = r2.getIssuerMetadata()
            kotlin.g.b.aa r7 = kotlin.g.b.aa.f47921a
            int r7 = net.one97.paytm.passbook.R.string.allowance_generic_wallet_detail
            java.lang.String r7 = r12.getString(r7)
            java.lang.String r8 = "getString(R.string.allow…ce_generic_wallet_detail)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r6] = r2
            r8[r4] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r8, r5)
            java.lang.String r2 = java.lang.String.format(r7, r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x010d:
            int r2 = net.one97.paytm.passbook.R.string.toll_wallet_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x0116:
            int r2 = net.one97.paytm.passbook.R.string.gift_wallet_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            goto L_0x0127
        L_0x011f:
            int r2 = net.one97.paytm.passbook.R.string.food_wallet_detail
            java.lang.String r2 = r12.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x0127:
            r13.setText(r2)
            java.lang.Integer r13 = r1.getIcon()
            if (r13 == 0) goto L_0x0149
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r13 = r2.a((int) r13)
            int r2 = net.one97.paytm.passbook.R.id.iconImv
            android.view.View r2 = r14.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r13.a((android.widget.ImageView) r2)
        L_0x0149:
            int r13 = r1.getOneLinerArray()
            int r2 = net.one97.paytm.passbook.R.id.oneLinearLayout
            android.view.View r2 = r14.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            java.lang.String r3 = "view.oneLinearLayout"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.content.res.Resources r5 = r12.getResources()
            java.lang.String[] r13 = r5.getStringArray(r13)
            int r5 = r13.length
            r7 = 0
        L_0x0164:
            if (r7 >= r5) goto L_0x0191
            r8 = r13[r7]
            android.content.Context r9 = r12.getContext()
            android.view.LayoutInflater r9 = android.view.LayoutInflater.from(r9)
            int r10 = net.one97.paytm.passbook.R.layout.pass_layout_wallet_detail_one_liner
            r11 = r2
            android.view.ViewGroup r11 = (android.view.ViewGroup) r11
            android.view.View r9 = r9.inflate(r10, r11, r6)
            int r10 = net.one97.paytm.passbook.R.id.titleTv
            android.view.View r10 = r9.findViewById(r10)
            java.lang.String r11 = "view.findViewById<TextView>(R.id.titleTv)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            android.widget.TextView r10 = (android.widget.TextView) r10
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r10.setText(r8)
            r2.addView(r9)
            int r7 = r7 + 1
            goto L_0x0164
        L_0x0191:
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            int r2 = net.one97.paytm.passbook.R.string.msg_note_your_wallet_is_non_transferable
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r1 = r1.getWalletName()
            java.lang.String r1 = r12.getString(r1)
            r4[r6] = r1
            java.lang.String r1 = r12.getString(r2, r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.<init>(r1)
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
            java.lang.String r2 = "#ffad00"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.<init>(r2)
            r2 = 5
            r4 = 34
            r13.setSpan(r1, r6, r2, r4)
            int r1 = net.one97.paytm.passbook.R.id.noteTv
            android.view.View r1 = r14.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            android.widget.TextView$BufferType r2 = android.widget.TextView.BufferType.SPANNABLE
            r1.setText(r13, r2)
            net.one97.paytm.passbook.beans.CJRSubWallet r13 = r12.f57226b
            if (r13 != 0) goto L_0x01d1
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x01d1:
            int r13 = r13.getSubWalletType()
            net.one97.paytm.passbook.utility.n r0 = net.one97.paytm.passbook.utility.n.PAYTM_COINS
            int r0 = r0.getValue()
            if (r13 != r0) goto L_0x021e
            int r13 = net.one97.paytm.passbook.R.id.noteTv
            android.view.View r13 = r14.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r0 = "view.noteTv"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            r0 = 8
            r13.setVisibility(r0)
            int r13 = net.one97.paytm.passbook.R.id.oneLinearLayout
            android.view.View r13 = r14.findViewById(r13)
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            r13.setVisibility(r0)
            int r13 = net.one97.paytm.passbook.R.id.iconImv
            android.view.View r13 = r14.findViewById(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            int r0 = net.one97.paytm.passbook.R.drawable.pass_paytm_coins_know_more
            r13.setImageResource(r0)
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            android.content.Context r2 = r12.getContext()
            r5 = 0
            java.lang.String r3 = "paytm_coins"
            java.lang.String r4 = "coins_know_more_clicked"
            java.lang.String r6 = "/paytm_passbook"
            java.lang.String r7 = "passbook"
            r1.a(r2, r3, r4, r5, r6, r7)
        L_0x021e:
            int r13 = net.one97.paytm.passbook.R.id.closeImv
            android.view.View r13 = r14.findViewById(r13)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            net.one97.paytm.passbook.customview.e$b r14 = new net.one97.paytm.passbook.customview.e$b
            r14.<init>(r12)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r13.setOnClickListener(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.customview.e.setupDialog(android.app.Dialog, int):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f57229a;

        b(e eVar) {
            this.f57229a = eVar;
        }

        public final void onClick(View view) {
            this.f57229a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57228d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
