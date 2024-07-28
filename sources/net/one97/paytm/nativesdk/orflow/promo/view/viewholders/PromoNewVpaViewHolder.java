package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
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
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoNewVpaViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
    public static final Companion Companion = new Companion((g) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromoNewVpaViewHolder(Context context, View view) {
        super(context, view);
        k.c(context, "context");
        k.c(view, "view");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoNewVpaViewHolder create(Context context, ViewGroup viewGroup) {
            k.c(context, "context");
            k.c(viewGroup, "parent");
            return new PromoNewVpaViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_new_upi));
        }
    }

    public final void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        if (promoPayOptionAdapterParam != null) {
            if (promoPayOptionAdapterParam.isSelected()) {
                TextView textView = (TextView) getMView().findViewById(R.id.tvNewVPATitle);
                k.a((Object) textView, "mView.tvNewVPATitle");
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                AppCompatEditText appCompatEditText = (AppCompatEditText) getMView().findViewById(R.id.etNewVPA);
                k.a((Object) appCompatEditText, "mView.etNewVPA");
                appCompatEditText.setVisibility(0);
                ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).requestFocus();
                TextView textView2 = (TextView) getMView().findViewById(R.id.cardInputTitle);
                k.a((Object) textView2, "mView.cardInputTitle");
                textView2.setVisibility(0);
                String inputError = promoPayOptionAdapterParam.getInputError();
                String promoErrorMessage = promoPayOptionAdapterParam.getPromoErrorMessage();
                String nonPromoErrorMessage = promoPayOptionAdapterParam.getNonPromoErrorMessage();
                ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).setText(promoPayOptionAdapterParam.getUpiAddress());
                promoPayOptionAdapterParam.setInputError(inputError);
                promoPayOptionAdapterParam.setPromoErrorMessage(promoErrorMessage);
                promoPayOptionAdapterParam.setNonPromoErrorMessage(nonPromoErrorMessage);
            } else {
                TextView textView3 = (TextView) getMView().findViewById(R.id.tvNewVPATitle);
                k.a((Object) textView3, "mView.tvNewVPATitle");
                textView3.setTypeface(Typeface.DEFAULT);
                ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).clearFocus();
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) getMView().findViewById(R.id.etNewVPA);
                k.a((Object) appCompatEditText2, "mView.etNewVPA");
                appCompatEditText2.setVisibility(8);
                AppCompatEditText appCompatEditText3 = (AppCompatEditText) getMView().findViewById(R.id.etNewVPA);
                if (appCompatEditText3 != null) {
                    appCompatEditText3.setText("");
                }
                TextView textView4 = (TextView) getMView().findViewById(R.id.cardInputTitle);
                k.a((Object) textView4, "mView.cardInputTitle");
                textView4.setVisibility(8);
                promoPayOptionAdapterParam.setInputError((String) null);
                promoPayOptionAdapterParam.setPromoErrorMessage((String) null);
                promoPayOptionAdapterParam.setNonPromoErrorMessage((String) null);
                promoPayOptionAdapterParam.setUpiAddress((String) null);
            }
            RadioButton radioButton = (RadioButton) getMView().findViewById(R.id.radio_button);
            k.a((Object) radioButton, "mView.radio_button");
            radioButton.setChecked(promoPayOptionAdapterParam.isSelected());
            RelativeLayout relativeLayout = (RelativeLayout) getMView().findViewById(R.id.newVPAContainer);
            k.a((Object) relativeLayout, "mView.newVPAContainer");
            relativeLayout.setTag(Integer.valueOf(getAdapterPosition()));
            ((RelativeLayout) getMView().findViewById(R.id.newVPAContainer)).setOnClickListener(getMOnClickListener());
            if (TextUtils.isEmpty(promoPayOptionAdapterParam.getInputError())) {
                AppCompatEditText appCompatEditText4 = (AppCompatEditText) getMView().findViewById(R.id.etNewVPA);
                k.a((Object) appCompatEditText4, "mView.etNewVPA");
                appCompatEditText4.setBackground(b.a(getMContext(), R.drawable.edit_text_blue_line));
                TextView textView5 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView5, "mView.tvInputError");
                textView5.setVisibility(8);
            } else {
                AppCompatEditText appCompatEditText5 = (AppCompatEditText) getMView().findViewById(R.id.etNewVPA);
                k.a((Object) appCompatEditText5, "mView.etNewVPA");
                appCompatEditText5.setBackground(b.a(getMContext(), R.drawable.edit_text_error_line));
                TextView textView6 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView6, "mView.tvInputError");
                textView6.setVisibility(0);
                TextView textView7 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView7, "mView.tvErrorMessage");
                textView7.setVisibility(8);
                TextView textView8 = (TextView) getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView8, "mView.tvInputError");
                textView8.setText(promoPayOptionAdapterParam.getInputError());
            }
            if (!TextUtils.isEmpty(promoPayOptionAdapterParam.getNonPromoErrorMessage())) {
                promoPayOptionAdapterParam.setPromoErrorMessage(promoPayOptionAdapterParam.getNonPromoErrorMessage());
            }
            if (TextUtils.isEmpty(promoPayOptionAdapterParam.getPromoErrorMessage())) {
                TextView textView9 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView9, "mView.tvErrorMessage");
                textView9.setVisibility(8);
            } else {
                TextView textView10 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView10, "mView.tvErrorMessage");
                textView10.setText(promoPayOptionAdapterParam.getPromoErrorMessage());
                TextView textView11 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                k.a((Object) textView11, "mView.tvErrorMessage");
                textView11.setVisibility(0);
            }
            ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).addTextChangedListener(new PromoNewVpaViewHolder$bindView$1(this, promoPayOptionAdapterParam));
            ((ImageView) getMView().findViewById(R.id.iv_cross)).setOnClickListener(new PromoNewVpaViewHolder$bindView$2(this));
            ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).setOnClickListener(PromoNewVpaViewHolder$bindView$3.INSTANCE);
            ((AppCompatEditText) getMView().findViewById(R.id.etNewVPA)).setOnKeyListener(new PromoNewVpaViewHolder$bindView$4(this));
        }
    }
}
