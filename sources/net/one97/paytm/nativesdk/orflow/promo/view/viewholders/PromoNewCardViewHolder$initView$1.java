package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.b;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoNewCardViewHolder$initView$1 implements TextWatcher {
    final /* synthetic */ PromoNewCardViewHolder this$0;

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    PromoNewCardViewHolder$initView$1(PromoNewCardViewHolder promoNewCardViewHolder) {
        this.this$0 = promoNewCardViewHolder;
    }

    public final void afterTextChanged(Editable editable) {
        PromoPayOptionAdapterParam access$getItem$p;
        if (editable != null) {
            PromoPayOptionAdapterParam access$getItem$p2 = this.this$0.item;
            if (access$getItem$p2 != null && access$getItem$p2.isSelected()) {
                if (TextUtils.isEmpty(editable.toString())) {
                    ImageView imageView = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
                    k.a((Object) imageView, "mView.iv_cross");
                    imageView.setVisibility(8);
                    TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.cardInputTitle);
                    k.a((Object) textView, "mView.cardInputTitle");
                    textView.setVisibility(4);
                } else {
                    ImageView imageView2 = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
                    k.a((Object) imageView2, "mView.iv_cross");
                    imageView2.setVisibility(0);
                    TextView textView2 = (TextView) this.this$0.getMView().findViewById(R.id.cardInputTitle);
                    k.a((Object) textView2, "mView.cardInputTitle");
                    textView2.setVisibility(0);
                }
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && this.this$0.dash == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(this.this$0.dash)).length <= 4) {
                editable.insert(editable.length() - 1, String.valueOf(this.this$0.dash));
            }
            String obj = editable.toString();
            PromoPayOptionAdapterParam access$getItem$p3 = this.this$0.item;
            if (access$getItem$p3 != null) {
                access$getItem$p3.setCardNumber(obj);
            }
            if (this.this$0.newCardType != null) {
                if (p.a(this.this$0.newCardType, SDKConstants.AMEX, true)) {
                    PromoPayOptionAdapterParam access$getItem$p4 = this.this$0.item;
                    if (access$getItem$p4 != null) {
                        access$getItem$p4.setCardSizeShouldBe(15);
                    }
                } else if (p.a(this.this$0.newCardType, SDKConstants.DINERS, true)) {
                    PromoPayOptionAdapterParam access$getItem$p5 = this.this$0.item;
                    if (access$getItem$p5 != null) {
                        access$getItem$p5.setCardSizeShouldBe(14);
                    }
                } else if (p.a(this.this$0.newCardType, SDKConstants.MAESTRO, true)) {
                    PromoPayOptionAdapterParam access$getItem$p6 = this.this$0.item;
                    if (access$getItem$p6 != null) {
                        access$getItem$p6.setCardSizeShouldBe(19);
                    }
                } else if ((p.a(this.this$0.newCardType, SDKConstants.MASTER, true) || p.a(this.this$0.newCardType, SDKConstants.VISA, true) || p.a(this.this$0.newCardType, SDKConstants.RUPAY, true)) && (access$getItem$p = this.this$0.item) != null) {
                    access$getItem$p.setCardSizeShouldBe(16);
                }
            }
            if ((obj.length() == 7 || obj.length() > 7) && !this.this$0.binApiCallInProgress && !this.this$0.fetchBinHitOnce) {
                this.this$0.binApiCallInProgress = true;
                this.this$0.fetchBinDetails(p.a(obj, String.valueOf(this.this$0.dash), "", false));
            }
            if (obj.length() < 7) {
                this.this$0.newCardType = null;
                PromoPayOptionAdapterParam access$getItem$p7 = this.this$0.item;
                if (access$getItem$p7 != null) {
                    access$getItem$p7.setCardSizeShouldBe(0);
                }
                ImageView imageView3 = (ImageView) this.this$0.getMView().findViewById(R.id.iv_card_logo);
                k.a((Object) imageView3, "mView.iv_card_logo");
                imageView3.setVisibility(8);
                this.this$0.setEmiText((BinResponse) null);
                this.this$0.fetchBinHitOnce = false;
                PromoPayOptionAdapterParam access$getItem$p8 = this.this$0.item;
                if (access$getItem$p8 != null) {
                    access$getItem$p8.setInputError((String) null);
                }
                TextView textView3 = (TextView) this.this$0.getMView().findViewById(R.id.tvInputError);
                k.a((Object) textView3, "mView.tvInputError");
                textView3.setVisibility(8);
            }
            PromoPayOptionAdapterParam access$getItem$p9 = this.this$0.item;
            if (access$getItem$p9 == null) {
                k.a();
            }
            if (access$getItem$p9.getCardSizeShouldBe() > 0) {
                int length = p.a(obj, "-", "", false).length();
                PromoPayOptionAdapterParam access$getItem$p10 = this.this$0.item;
                if (access$getItem$p10 == null) {
                    k.a();
                }
                if (length == access$getItem$p10.getCardSizeShouldBe()) {
                    SDKUtility.hideKeyboard((AppCompatEditText) this.this$0.getMView().findViewById(R.id.etCardNumber), this.this$0.getMContext());
                }
            }
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.tvErrorMessage);
        k.a((Object) textView, "mView.tvErrorMessage");
        textView.setVisibility(8);
        PromoPayOptionAdapterParam access$getItem$p = this.this$0.item;
        if (!TextUtils.isEmpty(access$getItem$p != null ? access$getItem$p.getInputError() : null)) {
            PromoPayOptionAdapterParam access$getItem$p2 = this.this$0.item;
            if (access$getItem$p2 != null) {
                access$getItem$p2.setInputError((String) null);
            }
            AppCompatEditText appCompatEditText = (AppCompatEditText) this.this$0.getMView().findViewById(R.id.etCardNumber);
            k.a((Object) appCompatEditText, "mView.etCardNumber");
            appCompatEditText.setBackground(b.a(this.this$0.getMContext(), R.drawable.edit_text_blue_line));
        }
        PromoPayOptionAdapterParam access$getItem$p3 = this.this$0.item;
        if (access$getItem$p3 != null) {
            access$getItem$p3.setPromoErrorMessage((String) null);
        }
        PromoPayOptionAdapterParam access$getItem$p4 = this.this$0.item;
        if (access$getItem$p4 != null) {
            access$getItem$p4.setNonPromoErrorMessage((String) null);
        }
    }
}
