package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.h.a;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public class PromoNewCardViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public boolean binApiCallInProgress;
    /* access modifiers changed from: private */
    public final char dash = '-';
    /* access modifiers changed from: private */
    public boolean fetchBinHitOnce;
    /* access modifiers changed from: private */
    public PromoPayOptionAdapterParam item;
    /* access modifiers changed from: private */
    public String newCardType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoNewCardViewHolder(Context context, View view) {
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

        public final PromoNewCardViewHolder create(Context context, ViewGroup viewGroup) {
            k.c(context, "context");
            k.c(viewGroup, "parent");
            return new PromoNewCardViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_newcard));
        }
    }

    private final void initView() {
        ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).addTextChangedListener(new PromoNewCardViewHolder$initView$1(this));
        ((ImageView) getMView().findViewById(R.id.iv_cross)).setOnClickListener(new PromoNewCardViewHolder$initView$2(this));
    }

    public void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        if (promoPayOptionAdapterParam != null) {
            if (this.item == null) {
                this.item = promoPayOptionAdapterParam;
                initView();
            }
            if (promoPayOptionAdapterParam.isSelected()) {
                TextView textView = (TextView) getMView().findViewById(R.id.tvNewCardTitle);
                k.a((Object) textView, "mView.tvNewCardTitle");
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                AppCompatEditText appCompatEditText = (AppCompatEditText) getMView().findViewById(R.id.etCardNumber);
                k.a((Object) appCompatEditText, "mView.etCardNumber");
                appCompatEditText.setVisibility(0);
                ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).requestFocus();
                TextView textView2 = (TextView) getMView().findViewById(R.id.cardInputTitle);
                k.a((Object) textView2, "mView.cardInputTitle");
                textView2.setVisibility(4);
                String inputError = promoPayOptionAdapterParam.getInputError();
                String promoErrorMessage = promoPayOptionAdapterParam.getPromoErrorMessage();
                String nonPromoErrorMessage = promoPayOptionAdapterParam.getNonPromoErrorMessage();
                ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).setText(promoPayOptionAdapterParam.getCardNumber());
                promoPayOptionAdapterParam.setInputError(inputError);
                promoPayOptionAdapterParam.setPromoErrorMessage(promoErrorMessage);
                promoPayOptionAdapterParam.setNonPromoErrorMessage(nonPromoErrorMessage);
            } else {
                TextView textView3 = (TextView) getMView().findViewById(R.id.tvNewCardTitle);
                k.a((Object) textView3, "mView.tvNewCardTitle");
                textView3.setTypeface(Typeface.DEFAULT);
                ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).clearFocus();
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) getMView().findViewById(R.id.etCardNumber);
                k.a((Object) appCompatEditText2, "mView.etCardNumber");
                appCompatEditText2.setVisibility(8);
                TextView textView4 = (TextView) getMView().findViewById(R.id.cardInputTitle);
                k.a((Object) textView4, "mView.cardInputTitle");
                textView4.setVisibility(8);
                promoPayOptionAdapterParam.setInputError((String) null);
                promoPayOptionAdapterParam.setPromoErrorMessage((String) null);
                promoPayOptionAdapterParam.setNonPromoErrorMessage((String) null);
                promoPayOptionAdapterParam.setCardNumber("");
                ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).setText("");
                ImageView imageView = (ImageView) getMView().findViewById(R.id.iv_cross);
                k.a((Object) imageView, "mView.iv_cross");
                imageView.setVisibility(8);
            }
            if (SDKConstants.CREDIT.equals(promoPayOptionAdapterParam.getMode())) {
                TextView textView5 = (TextView) getMView().findViewById(R.id.tvNewCardTitle);
                k.a((Object) textView5, "mView.tvNewCardTitle");
                textView5.setText(getMContext().getString(R.string.native_new_credit_card_title));
            } else {
                TextView textView6 = (TextView) getMView().findViewById(R.id.tvNewCardTitle);
                k.a((Object) textView6, "mView.tvNewCardTitle");
                textView6.setText(getMContext().getString(R.string.native_new_debit_card_title));
            }
            RadioButton radioButton = (RadioButton) getMView().findViewById(R.id.radio_button);
            k.a((Object) radioButton, "mView.radio_button");
            radioButton.setChecked(promoPayOptionAdapterParam.isSelected());
            RelativeLayout relativeLayout = (RelativeLayout) getMView().findViewById(R.id.newCardContainer);
            k.a((Object) relativeLayout, "mView.newCardContainer");
            relativeLayout.setTag(Integer.valueOf(getAdapterPosition()));
            ((RelativeLayout) getMView().findViewById(R.id.newCardContainer)).setOnClickListener(getMOnClickListener());
            if (TextUtils.isEmpty(promoPayOptionAdapterParam.getInputError())) {
                AppCompatEditText appCompatEditText3 = (AppCompatEditText) getMView().findViewById(R.id.etCardNumber);
                k.a((Object) appCompatEditText3, "mView.etCardNumber");
                appCompatEditText3.setBackground(b.a(getMContext(), R.drawable.edit_text_blue_line));
                TextView textView7 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView7, "mView.tvInputError");
                textView7.setVisibility(8);
            } else {
                AppCompatEditText appCompatEditText4 = (AppCompatEditText) getMView().findViewById(R.id.etCardNumber);
                k.a((Object) appCompatEditText4, "mView.etCardNumber");
                appCompatEditText4.setBackground(b.a(getMContext(), R.drawable.edit_text_error_line));
                TextView textView8 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView8, "mView.tvInputError");
                textView8.setVisibility(0);
                TextView textView9 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView9, "mView.tvErrorMessage");
                textView9.setVisibility(8);
                TextView textView10 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView10, "mView.tvInputError");
                textView10.setText(promoPayOptionAdapterParam.getInputError());
            }
            if (!TextUtils.isEmpty(promoPayOptionAdapterParam.getNonPromoErrorMessage())) {
                promoPayOptionAdapterParam.setPromoErrorMessage(promoPayOptionAdapterParam.getNonPromoErrorMessage());
            }
            if (TextUtils.isEmpty(promoPayOptionAdapterParam.getPromoErrorMessage())) {
                TextView textView11 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView11, "mView.tvErrorMessage");
                textView11.setVisibility(8);
            } else {
                TextView textView12 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView12, "mView.tvErrorMessage");
                textView12.setText(promoPayOptionAdapterParam.getPromoErrorMessage());
                TextView textView13 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView13, "mView.tvErrorMessage");
                textView13.setVisibility(0);
            }
            ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).setOnClickListener(PromoNewCardViewHolder$bindView$1.INSTANCE);
            ((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).setOnKeyListener(new PromoNewCardViewHolder$bindView$2(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r0 = (r0 = r0.getBody()).getBinDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fetchBinDetails(java.lang.String r4) {
        /*
            r3 = this;
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r0 = r0.getBinResposne(r4)
            if (r0 == 0) goto L_0x005b
            r0 = 0
            r3.binApiCallInProgress = r0
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r0 = r0.getBinResposne(r4)
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail r0 = r0.getBinDetail()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.getChannelCode()
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            r3.newCardType = r0
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r0 = r0.getBinResposne(r4)
            if (r0 == 0) goto L_0x0044
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x0044
            java.lang.String r0 = r0.getIconUrl()
            if (r0 == 0) goto L_0x0044
            r3.setCardIcon(r0)
        L_0x0044:
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r0 = r0.getBinResposne(r4)
            r3.setEmiText(r0)
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r4 = r0.getBinResposne(r4)
            r3.showInputErrorText(r4)
            return
        L_0x005b:
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r1 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r2 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r2 = r2.getInstance()
            java.lang.String r2 = r2.getMid()
            r0.setMid(r2)
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r1 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r1 = r1.getInstance()
            java.lang.String r1 = r1.getSsoToken()
            r0.setSsoToken(r1)
            r0 = 1
            r3.fetchBinHitOnce = r0
            net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository r0 = net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository.getInstance()
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder$fetchBinDetails$2 r1 = new net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder$fetchBinDetails$2
            r1.<init>(r3, r4)
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r1 = (net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource.Callback) r1
            r0.fetchBinDetails(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder.fetchBinDetails(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r2 = (r2 = r8.getBody()).getResultInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showInputErrorText(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r8) {
        /*
            r7 = this;
            android.view.View r0 = r7.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.tvInputError
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "mView.tvInputError"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x00f0
            r0 = 0
            if (r8 == 0) goto L_0x002b
            net.one97.paytm.nativesdk.common.model.Body r2 = r8.getBody()
            if (r2 == 0) goto L_0x002b
            net.one97.paytm.nativesdk.common.model.ResultInfo r2 = r2.getResultInfo()
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = r2.getResultCode()
            goto L_0x002c
        L_0x002b:
            r2 = r0
        L_0x002c:
            if (r2 != 0) goto L_0x002f
            return
        L_0x002f:
            int r3 = r2.hashCode()
            r4 = 0
            r5 = 8
            java.lang.String r6 = "mView.tvErrorMessage"
            switch(r3) {
                case 1507426: goto L_0x00a3;
                case 1537246: goto L_0x004f;
                case 1537248: goto L_0x0046;
                case 1537249: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x00f0
        L_0x003d:
            java.lang.String r3 = "2014"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f0
            goto L_0x0057
        L_0x0046:
            java.lang.String r3 = "2013"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f0
            goto L_0x0057
        L_0x004f:
            java.lang.String r3 = "2011"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f0
        L_0x0057:
            android.view.View r2 = r7.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.tvErrorMessage
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r2.setVisibility(r5)
            android.view.View r2 = r7.getMView()
            int r3 = net.one97.paytm.nativesdk.R.id.tvInputError
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r8 = r8.getBody()
            if (r8 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.common.model.ResultInfo r8 = r8.getResultInfo()
            if (r8 == 0) goto L_0x0088
            java.lang.String r0 = r8.getResultMsg()
        L_0x0088:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            android.view.View r8 = r7.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvInputError
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            r8.setVisibility(r4)
            r7.scrollRecyclerViewWithDelay()
            return
        L_0x00a3:
            java.lang.String r8 = "1003"
            boolean r8 = r2.equals(r8)
            if (r8 == 0) goto L_0x00f0
            android.view.View r8 = r7.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvErrorMessage
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            r8.setVisibility(r5)
            android.view.View r8 = r7.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvInputError
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            android.content.Context r0 = r7.getMContext()
            int r2 = net.one97.paytm.nativesdk.R.string.enter_valid_card_number
            java.lang.String r0 = r0.getString(r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
            android.view.View r8 = r7.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvInputError
            android.view.View r8 = r8.findViewById(r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            r8.setVisibility(r4)
            r7.scrollRecyclerViewWithDelay()
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder.showInputErrorText(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r3 = r3.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setEmiText(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r3) {
        /*
            r2 = this;
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            boolean r0 = r0.isMultiItemEmiFlow()
            java.lang.String r1 = "mView.tvEmiText"
            if (r0 == 0) goto L_0x0038
            if (r3 == 0) goto L_0x001b
            net.one97.paytm.nativesdk.common.model.Body r3 = r3.getBody()
            if (r3 == 0) goto L_0x001b
            java.lang.Boolean r3 = r3.getEmiAvailable()
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0038
            android.view.View r3 = r2.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvEmiText
            android.view.View r3 = r3.findViewById(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r0 = 0
            r3.setVisibility(r0)
            return
        L_0x0038:
            android.view.View r3 = r2.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.tvEmiText
            android.view.View r3 = r3.findViewById(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r0 = 8
            r3.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder.setEmiText(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse):void");
    }

    /* access modifiers changed from: private */
    public final void setCardIcon(String str) {
        if (((AppCompatEditText) getMView().findViewById(R.id.etCardNumber)).length() >= 6) {
            com.bumptech.glide.b.b(getMContext()).a(str).a((ImageView) getMView().findViewById(R.id.iv_card_logo));
            ImageView imageView = (ImageView) getMView().findViewById(R.id.iv_card_logo);
            k.a((Object) imageView, "mView.iv_card_logo");
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = (ImageView) getMView().findViewById(R.id.iv_card_logo);
        k.a((Object) imageView2, "mView.iv_card_logo");
        imageView2.setVisibility(8);
    }

    private final void scrollRecyclerViewWithDelay() {
        Resources resources = getMContext().getResources();
        k.a((Object) resources, "mContext.resources");
        new Handler().postDelayed(new PromoNewCardViewHolder$scrollRecyclerViewWithDelay$1(this, a.a(TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()))), 50);
    }
}
