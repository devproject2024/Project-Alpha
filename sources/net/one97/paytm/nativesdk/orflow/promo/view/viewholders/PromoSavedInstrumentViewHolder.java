package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoSavedInstrumentViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
    public static final Companion Companion = new Companion((g) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoSavedInstrumentViewHolder(Context context, View view) {
        super(context, view);
        k.c(context, "context");
        k.c(view, "itemView");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoSavedInstrumentViewHolder create(Context context, ViewGroup viewGroup) {
            k.c(context, "context");
            k.c(viewGroup, "parent");
            return new PromoSavedInstrumentViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_saved_card_item));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x049c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bindView(net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r17) {
        /*
            r16 = this;
            r0 = r17
            r1 = 1
            java.lang.String r3 = "mView.tv_saved_card_number"
            java.lang.String r4 = "mView.tvSavedCardTitle"
            r5 = 8
            r6 = 0
            if (r0 == 0) goto L_0x004e
            int r7 = r17.getVIEWTYPE()
            r8 = 6
            if (r7 != r8) goto L_0x004e
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setVisibility(r5)
            android.view.View r3 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r3 = r3.findViewById(r7)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r7 = "Paytm Postpaid"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.setText(r7)
            android.view.View r3 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.ivBankLogo
            android.view.View r3 = r3.findViewById(r7)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r7 = net.one97.paytm.nativesdk.R.drawable.ic_postpaid
            r3.setImageResource(r7)
            goto L_0x03e0
        L_0x004e:
            if (r0 == 0) goto L_0x0092
            int r7 = r17.getVIEWTYPE()
            r8 = 5
            if (r7 != r8) goto L_0x0092
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.ivBankLogo
            android.view.View r7 = r7.findViewById(r8)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            int r8 = net.one97.paytm.nativesdk.R.drawable.native_paytm_header_logo
            r7.setImageResource(r8)
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setVisibility(r5)
            android.view.View r3 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r3 = r3.findViewById(r7)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r7 = "Paytm Payments Bank"
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.setText(r7)
            goto L_0x03e0
        L_0x0092:
            if (r0 == 0) goto L_0x0110
            int r7 = r17.getVIEWTYPE()
            if (r7 != r1) goto L_0x0110
            net.one97.paytm.nativesdk.common.model.BaseDataModel r7 = r17.getData()
            boolean r7 = r7 instanceof net.one97.paytm.nativesdk.common.model.PayChannelOptions
            if (r7 == 0) goto L_0x0110
            net.one97.paytm.nativesdk.common.model.BaseDataModel r7 = r17.getData()
            if (r7 == 0) goto L_0x0108
            net.one97.paytm.nativesdk.common.model.PayChannelOptions r7 = (net.one97.paytm.nativesdk.common.model.PayChannelOptions) r7
            android.view.View r8 = r16.getMView()
            int r9 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r7.getChannelName()
            r9.append(r10)
            java.lang.String r10 = " Net Banking"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            java.lang.String r7 = r7.getIconUrl()
            if (r7 == 0) goto L_0x00f4
            android.content.Context r8 = r16.getMContext()
            com.bumptech.glide.i r8 = com.bumptech.glide.b.b(r8)
            com.bumptech.glide.h r7 = r8.a((java.lang.String) r7)
            android.view.View r8 = r16.getMView()
            int r9 = net.one97.paytm.nativesdk.R.id.ivBankLogo
            android.view.View r8 = r8.findViewById(r9)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r7.a((android.widget.ImageView) r8)
        L_0x00f4:
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setVisibility(r5)
            goto L_0x03e0
        L_0x0108:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PayChannelOptions"
            r0.<init>(r1)
            throw r0
        L_0x0110:
            r7 = 4
            java.lang.String r8 = "null cannot be cast to non-null type java.lang.String"
            if (r0 == 0) goto L_0x0305
            int r9 = r17.getVIEWTYPE()
            if (r9 != 0) goto L_0x0305
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r17.getData()
            boolean r9 = r9 instanceof net.one97.paytm.nativesdk.common.model.SavedInstruments
            if (r9 == 0) goto L_0x0305
            net.one97.paytm.nativesdk.common.model.BaseDataModel r9 = r17.getData()
            if (r9 == 0) goto L_0x02fd
            net.one97.paytm.nativesdk.common.model.SavedInstruments r9 = (net.one97.paytm.nativesdk.common.model.SavedInstruments) r9
            android.view.View r10 = r16.getMView()
            int r11 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r10 = r10.findViewById(r11)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
            java.lang.String r11 = r9.getDisplayName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r10.setText(r11)
            java.lang.String r10 = r9.getChannelCode()
            java.lang.String r11 = "savedInstruments.channelCode"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.util.Locale r11 = java.util.Locale.getDefault()
            java.lang.String r12 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            if (r10 == 0) goto L_0x02f7
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.util.Locale r13 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r12)
            java.lang.String r14 = "Amex"
            java.lang.String r13 = r14.toLowerCase(r13)
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r11)
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r13)
            java.lang.String r14 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            java.lang.String r15 = "savedInstruments.cardDetails.firstSixDigit"
            java.lang.String r2 = "savedInstruments.cardDetails"
            if (r13 == 0) goto L_0x01ba
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            net.one97.paytm.nativesdk.common.model.CardDetails r11 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            java.lang.String r11 = r11.getFirstSixDigit()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r15)
            if (r11 == 0) goto L_0x01b4
            java.lang.String r7 = r11.substring(r6, r7)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            r10.append(r7)
            java.lang.String r7 = " XXXXXX X"
            r10.append(r7)
            net.one97.paytm.nativesdk.common.model.CardDetails r7 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            java.lang.String r2 = r7.getLastFourDigit()
            r10.append(r2)
            java.lang.String r2 = r10.toString()
            goto L_0x02a0
        L_0x01b4:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x01ba:
            java.util.Locale r13 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r12)
            java.lang.String r1 = "Diners"
            java.lang.String r1 = r1.toLowerCase(r13)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x020e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.nativesdk.common.model.CardDetails r10 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            java.lang.String r10 = r10.getFirstSixDigit()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r15)
            if (r10 == 0) goto L_0x0208
            java.lang.String r7 = r10.substring(r6, r7)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            r1.append(r7)
            java.lang.String r7 = " XXXXXX "
            r1.append(r7)
            net.one97.paytm.nativesdk.common.model.CardDetails r7 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            java.lang.String r2 = r7.getLastFourDigit()
            r1.append(r2)
            java.lang.String r2 = r1.toString()
            goto L_0x02a0
        L_0x0208:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x020e:
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            java.lang.String r13 = "VISA"
            java.lang.String r1 = r13.toLowerCase(r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x026a
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            java.lang.String r13 = "Rupay"
            java.lang.String r1 = r13.toLowerCase(r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x026a
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            java.lang.String r13 = "Master"
            java.lang.String r1 = r13.toLowerCase(r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x026a
            java.util.Locale r1 = java.util.Locale.getDefault()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            java.lang.String r12 = "MAESTRO"
            java.lang.String r1 = r12.toLowerCase(r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0267
            goto L_0x026a
        L_0x0267:
            java.lang.String r2 = ""
            goto L_0x02a0
        L_0x026a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.nativesdk.common.model.CardDetails r10 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            java.lang.String r10 = r10.getFirstSixDigit()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r15)
            if (r10 == 0) goto L_0x02f1
            java.lang.String r7 = r10.substring(r6, r7)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r14)
            r1.append(r7)
            java.lang.String r7 = " XXXX XXXX "
            r1.append(r7)
            net.one97.paytm.nativesdk.common.model.CardDetails r7 = r9.getCardDetails()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
            java.lang.String r2 = r7.getLastFourDigit()
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x02a0:
            android.view.View r1 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.view.View r1 = r16.getMView()
            int r2 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r6)
            java.lang.String r1 = r9.getIconUrl()
            if (r1 == 0) goto L_0x02e7
            android.content.Context r2 = r16.getMContext()
            com.bumptech.glide.i r2 = com.bumptech.glide.b.b(r2)
            com.bumptech.glide.h r1 = r2.a((java.lang.String) r1)
            android.view.View r2 = r16.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.ivBankLogo
            android.view.View r2 = r2.findViewById(r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r1.a((android.widget.ImageView) r2)
        L_0x02e7:
            boolean r1 = r9.isEmiAvailable()
            java.lang.String r2 = r9.getSubventionType()
            goto L_0x03e2
        L_0x02f1:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x02f7:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x02fd:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.SavedInstruments"
            r0.<init>(r1)
            throw r0
        L_0x0305:
            if (r0 == 0) goto L_0x03e0
            int r1 = r17.getVIEWTYPE()
            r2 = 3
            if (r1 != r2) goto L_0x03e0
            net.one97.paytm.nativesdk.common.model.BaseDataModel r1 = r17.getData()
            boolean r1 = r1 instanceof net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail
            if (r1 == 0) goto L_0x03e0
            net.one97.paytm.nativesdk.common.model.BaseDataModel r1 = r17.getData()
            if (r1 == 0) goto L_0x03d8
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r1 = (net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail) r1
            java.lang.String r2 = r1.getMaskedAccountNumber()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0343
            android.view.View r2 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r2 = r2.findViewById(r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r1 = r1.getBank()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            goto L_0x03a8
        L_0x0343:
            android.view.View r2 = r16.getMView()
            int r9 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r2 = r2.findViewById(r9)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            if (r1 == 0) goto L_0x035e
            java.lang.String r10 = r1.getBank()
            goto L_0x035f
        L_0x035e:
            r10 = 0
        L_0x035f:
            r9.append(r10)
            java.lang.String r10 = "  XX  "
            r9.append(r10)
            if (r1 == 0) goto L_0x039b
            java.lang.String r10 = r1.getMaskedAccountNumber()
            if (r10 == 0) goto L_0x039b
            java.lang.String r1 = r1.getMaskedAccountNumber()
            if (r1 == 0) goto L_0x037e
            int r1 = r1.length()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x037f
        L_0x037e:
            r1 = 0
        L_0x037f:
            if (r1 != 0) goto L_0x0384
            kotlin.g.b.k.a()
        L_0x0384:
            int r1 = r1.intValue()
            int r1 = r1 - r7
            if (r10 == 0) goto L_0x0395
            java.lang.String r1 = r10.substring(r1)
            java.lang.String r7 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            goto L_0x039c
        L_0x0395:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r8)
            throw r0
        L_0x039b:
            r1 = 0
        L_0x039c:
            r9.append(r1)
            java.lang.String r1 = r9.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
        L_0x03a8:
            android.view.View r1 = r16.getMView()
            int r2 = net.one97.paytm.nativesdk.R.id.ivBankLogo
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            android.content.Context r2 = r16.getMContext()
            android.content.res.Resources r2 = r2.getResources()
            int r7 = net.one97.paytm.nativesdk.R.drawable.nativesdk_bhim_upi_icon
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r7)
            r1.setImageDrawable(r2)
            android.view.View r1 = r16.getMView()
            int r2 = net.one97.paytm.nativesdk.R.id.tv_saved_card_number
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r1.setVisibility(r5)
            goto L_0x03e0
        L_0x03d8:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail"
            r0.<init>(r1)
            throw r0
        L_0x03e0:
            r1 = 0
            r2 = 0
        L_0x03e2:
            if (r0 == 0) goto L_0x03fc
            android.view.View r3 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.rb_saved_card_label
            android.view.View r3 = r3.findViewById(r7)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            java.lang.String r7 = "mView.rb_saved_card_label"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            boolean r7 = r17.isSelected()
            r3.setChecked(r7)
        L_0x03fc:
            java.lang.String r3 = "mView.tvPromoError"
            if (r0 == 0) goto L_0x049c
            boolean r7 = r17.isSelected()
            r8 = 1
            if (r7 != r8) goto L_0x049c
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            android.graphics.Typeface r4 = android.graphics.Typeface.DEFAULT_BOLD
            r7.setTypeface(r4)
            java.lang.String r4 = r17.getPromoErrorMessage()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0452
            android.view.View r4 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            r4.setVisibility(r6)
            android.view.View r4 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.lang.String r0 = r17.getPromoErrorMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            goto L_0x04c8
        L_0x0452:
            java.lang.String r4 = r17.getNonPromoErrorMessage()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0489
            android.view.View r4 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            r4.setVisibility(r6)
            android.view.View r4 = r16.getMView()
            int r7 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r4 = r4.findViewById(r7)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.lang.String r0 = r17.getNonPromoErrorMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            goto L_0x04c8
        L_0x0489:
            android.view.View r0 = r16.getMView()
            int r4 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r5)
            goto L_0x04c8
        L_0x049c:
            android.view.View r7 = r16.getMView()
            int r8 = net.one97.paytm.nativesdk.R.id.tvPromoError
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            r7.setVisibility(r5)
            if (r0 == 0) goto L_0x04b4
            r3 = 0
            r0.setNonPromoErrorMessage(r3)
        L_0x04b4:
            android.view.View r0 = r16.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.tvSavedCardTitle
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            r0.setTypeface(r3)
        L_0x04c8:
            android.view.View r0 = r16.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.savedCardContainer
            android.view.View r0 = r0.findViewById(r3)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            java.lang.String r3 = "mView.savedCardContainer"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r3 = r16.getAdapterPosition()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.setTag(r3)
            android.view.View r0 = r16.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.savedCardContainer
            android.view.View r0 = r0.findViewById(r3)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            android.view.View$OnClickListener r3 = r16.getMOnClickListener()
            r0.setOnClickListener(r3)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            boolean r0 = r0.isMultiItemEmiFlow()
            java.lang.String r3 = "mView.tvEmiText"
            if (r0 == 0) goto L_0x054c
            if (r1 == 0) goto L_0x054c
            android.view.View r0 = r16.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.ivEmiIcon
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "mView.ivEmiIcon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r6)
            android.view.View r0 = r16.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.tvEmiText
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r6)
            android.view.View r0 = r16.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.tvEmiText
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r1 = r16.getMContext()
            r4 = r16
            java.lang.String r1 = r4.getEmiAvailableText(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            return
        L_0x054c:
            r4 = r16
            android.view.View r0 = r16.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.ivEmiIcon
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "mView.ivEmiIcon"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r5)
            android.view.View r0 = r16.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.tvEmiText
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoSavedInstrumentViewHolder.bindView(net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam):void");
    }

    public final String getEmiAvailableText(Context context, String str) {
        k.c(context, "context");
        if (p.a(SDKConstants.EmiSubventionType.ZERO_COST.name(), str, true)) {
            String string = context.getString(R.string.emi_available_zero_cost_orflow);
            k.a((Object) string, "context.getString(R.stri…ailable_zero_cost_orflow)");
            return string;
        } else if (p.a(SDKConstants.EmiSubventionType.LOW_COST.name(), str, true)) {
            String string2 = context.getString(R.string.emi_available_low_cost_orflow);
            k.a((Object) string2, "context.getString(R.stri…vailable_low_cost_orflow)");
            return string2;
        } else {
            String string3 = context.getString(R.string.emi_available_text_orflow);
            k.a((Object) string3, "context.getString(R.stri…mi_available_text_orflow)");
            return string3;
        }
    }
}
