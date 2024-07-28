package net.one97.paytm.newaddmoney.utils;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class AddMoneyCommonDestinationView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f55846a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f55847b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f55848c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f55849d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f55850e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f55851f;

    /* JADX WARNING: type inference failed for: r3v6, types: [android.view.View] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddMoneyCommonDestinationView(android.content.Context r3, net.one97.paytm.newaddmoney.utils.b r4) {
        /*
            r2 = this;
            java.lang.String r0 = "cardType"
            kotlin.g.b.k.c(r4, r0)
            r2.<init>(r3)
            r0 = 0
            if (r3 == 0) goto L_0x0012
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r3 = r3.getSystemService(r1)
            goto L_0x0013
        L_0x0012:
            r3 = r0
        L_0x0013:
            if (r3 == 0) goto L_0x0075
            android.view.LayoutInflater r3 = (android.view.LayoutInflater) r3
            r2.f55846a = r3
            android.view.LayoutInflater r3 = r2.f55846a
            if (r3 != 0) goto L_0x0020
            kotlin.g.b.k.a()
        L_0x0020:
            int r1 = net.one97.paytm.addmoney.R.layout.layout_addmoney_destination_view
            android.view.View r3 = r3.inflate(r1, r0)
            r2.removeAllViews()
            r2.addView(r3)
            if (r3 == 0) goto L_0x0037
            int r1 = net.one97.paytm.addmoney.R.id.title
            android.view.View r1 = r3.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0038
        L_0x0037:
            r1 = r0
        L_0x0038:
            r2.f55847b = r1
            if (r3 == 0) goto L_0x0045
            int r1 = net.one97.paytm.addmoney.R.id.subTitle
            android.view.View r1 = r3.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0046
        L_0x0045:
            r1 = r0
        L_0x0046:
            r2.f55849d = r1
            if (r3 == 0) goto L_0x0053
            int r1 = net.one97.paytm.addmoney.R.id.otherText
            android.view.View r1 = r3.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            r2.f55850e = r1
            if (r3 == 0) goto L_0x0061
            int r1 = net.one97.paytm.addmoney.R.id.radio_button
            android.view.View r1 = r3.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x0062
        L_0x0061:
            r1 = r0
        L_0x0062:
            r2.f55848c = r1
            if (r3 == 0) goto L_0x006f
            int r0 = net.one97.paytm.addmoney.R.id.card_type_iv
            android.view.View r3 = r3.findViewById(r0)
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x006f:
            r2.f55851f = r0
            r2.setTitleBasedOnDestinationType(r4)
            return
        L_0x0075:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type android.view.LayoutInflater"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.newaddmoney.utils.AddMoneyCommonDestinationView.<init>(android.content.Context, net.one97.paytm.newaddmoney.utils.b):void");
    }

    private final void setTitleBasedOnDestinationType(b bVar) {
        int i2 = a.f55852a[bVar.ordinal()];
        if (i2 == 1) {
            String string = getContext().getString(R.string.paytm_wallet);
            k.a((Object) string, "context.getString(R.string.paytm_wallet)");
            setTitle(string);
            setCardIcon(b.a(getContext(), R.drawable.ic_wallet_bal_copy));
        } else if (i2 == 2) {
            String string2 = getContext().getString(R.string.paytm_giftvoucher);
            k.a((Object) string2, "context.getString(R.string.paytm_giftvoucher)");
            setTitle(string2);
            setCardIcon(b.a(getContext(), R.drawable.uam_ic_gift_voucher));
        }
    }

    public final void setTitle(String str) {
        k.c(str, "title");
        TextView textView = this.f55847b;
        if (textView != null) {
            c.a(textView, str);
        }
    }

    public final void setRadioButtonEnable(boolean z) {
        if (z) {
            ImageView imageView = this.f55848c;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ic_radio_active_addmoney_addmoney);
            }
            TextView textView = this.f55847b;
            if (textView != null) {
                c.a(textView, true);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f55848c;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.ic_radio_inactive_addmoney);
        }
        TextView textView2 = this.f55847b;
        if (textView2 != null) {
            c.a(textView2, false);
        }
    }

    public final void setSubTitle(String str) {
        TextView textView = this.f55849d;
        if (textView != null) {
            c.a(textView, str);
        }
    }

    public final void setCardIcon(Drawable drawable) {
        ImageView imageView = this.f55851f;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setOtherText(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        TextView textView = this.f55849d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f55850e;
        if (textView2 != null) {
            c.a(textView2, str);
        }
    }

    public final void setOtherTextClickListner(View.OnClickListener onClickListener) {
        k.c(onClickListener, "onClickListener");
        TextView textView = this.f55850e;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public final void setDisabled(boolean z) {
        ImageView imageView = this.f55848c;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }
}
