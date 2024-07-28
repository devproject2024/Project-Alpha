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
import kotlin.u;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoNewVpaViewHolder$bindView$1 implements TextWatcher {
    final /* synthetic */ PromoPayOptionAdapterParam $item;
    final /* synthetic */ PromoNewVpaViewHolder this$0;

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    PromoNewVpaViewHolder$bindView$1(PromoNewVpaViewHolder promoNewVpaViewHolder, PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        this.this$0 = promoNewVpaViewHolder;
        this.$item = promoPayOptionAdapterParam;
    }

    public final void afterTextChanged(Editable editable) {
        String str;
        String obj;
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.$item;
        if (editable == null || (obj = editable.toString()) == null) {
            str = null;
        } else if (obj != null) {
            str = p.b(obj).toString();
        } else {
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        promoPayOptionAdapterParam.setUpiAddress(str);
        String upiAddress = this.$item.getUpiAddress();
        k.a((Object) upiAddress, "item.upiAddress");
        if (upiAddress.length() > 0) {
            ImageView imageView = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
            k.a((Object) imageView, "mView.iv_cross");
            imageView.setVisibility(0);
            TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.cardInputTitle);
            k.a((Object) textView, "mView.cardInputTitle");
            textView.setVisibility(0);
            return;
        }
        ImageView imageView2 = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
        k.a((Object) imageView2, "mView.iv_cross");
        imageView2.setVisibility(8);
        TextView textView2 = (TextView) this.this$0.getMView().findViewById(R.id.cardInputTitle);
        k.a((Object) textView2, "mView.cardInputTitle");
        textView2.setVisibility(4);
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.tvErrorMessage);
        k.a((Object) textView, "mView.tvErrorMessage");
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.this$0.getMView().findViewById(R.id.tvInputError);
        k.a((Object) textView2, "mView.tvInputError");
        textView2.setVisibility(8);
        if (!TextUtils.isEmpty(this.$item.getInputError())) {
            this.$item.setInputError((String) null);
            AppCompatEditText appCompatEditText = (AppCompatEditText) this.this$0.getMView().findViewById(R.id.etNewVPA);
            k.a((Object) appCompatEditText, "mView.etNewVPA");
            appCompatEditText.setBackground(b.a(this.this$0.getMContext(), R.drawable.edit_text_blue_line));
        }
        this.$item.setPromoErrorMessage((String) null);
        this.$item.setNonPromoErrorMessage((String) null);
    }
}
