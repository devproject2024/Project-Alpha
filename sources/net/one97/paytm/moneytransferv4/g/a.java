package net.one97.paytm.moneytransferv4.g;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.Arrays;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.CircleTransform;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.rateMerchant.utils.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55425a = new a();

    private a() {
    }

    public static final void a(TextView textView, String str) {
        k.c(textView, "textView");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            textView.setText(f.a(str));
        }
    }

    public static final void b(TextView textView, String str) {
        k.c(textView, "textView");
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || p.a(str, "na", true)) {
            b.b(textView);
        } else {
            textView.setText(charSequence);
        }
    }

    public static final void a(ImageView imageView, TextView textView, String str, String str2) {
        k.c(imageView, H5ResourceHandlerUtil.IMAGE);
        k.c(textView, "initials");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            imageView.setPadding(4, 4, 4, 4);
            if (str2 != null) {
                textView.setText(UpiUtils.getNameInitials(f.a(str2)));
                return;
            }
            return;
        }
        w.a().a(str).a((ah) new CircleTransform()).a(R.drawable.profile_logout).a(imageView);
    }

    public static final void a(ImageView imageView, String str) {
        k.c(imageView, "imageView");
        k.c(str, "ifscCode");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence) && p.a(charSequence, (CharSequence) "ICIC", false)) {
            imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(charSequence) && p.a(str, "UPI", true)) {
            imageView.setImageDrawable(androidx.core.content.b.a(imageView.getContext(), R.drawable.ic_bhim));
        } else if (!TextUtils.isEmpty(charSequence)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(imageView.getContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView);
        }
    }

    public static final void c(TextView textView, String str) {
        k.c(textView, "textView");
        aa aaVar = aa.f47921a;
        String string = textView.getContext().getString(R.string.mt_rupees_no_space, new Object[]{UpiAppUtils.priceToString(str)});
        k.a((Object) string, "textView.context.getStri…ls.priceToString(amount))");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        textView.setText(format);
    }
}
