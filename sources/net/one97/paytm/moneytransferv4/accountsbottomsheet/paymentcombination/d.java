package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.p2p.PaymentOptionItem;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.common.entity.p2p.SourcePayment;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.ac;
import net.one97.paytm.moneytransfer.c.ag;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f55124a = "";

    /* renamed from: b  reason: collision with root package name */
    private final ag f55125b;

    /* renamed from: c  reason: collision with root package name */
    private final ac f55126c;

    public d(ag agVar, ac acVar) {
        k.c(agVar, "viewBinding");
        k.c(acVar, "bottomCardBinding");
        this.f55125b = agVar;
        this.f55126c = acVar;
    }

    public final void a(PaymentOptionItem paymentOptionItem, Map<String, String> map) {
        String str;
        String str2;
        SourcePayment sourcePayment;
        String ifscCode;
        k.c(paymentOptionItem, "paymentOptionItem");
        k.c(map, "balanceMap");
        ag agVar = this.f55125b;
        TextView textView = agVar.P;
        k.a((Object) textView, "tvSelectedSourceLabel");
        TextView textView2 = agVar.P;
        k.a((Object) textView2, "tvSelectedSourceLabel");
        Context context = textView2.getContext();
        int i2 = R.string.mt_v4_selected_bank;
        Object[] objArr = new Object[1];
        SourcePayment sourcePayment2 = paymentOptionItem.getSourcePayment();
        if (sourcePayment2 == null || (str = sourcePayment2.getBankName()) == null) {
            str = "";
        }
        boolean z = false;
        objArr[0] = str;
        String string = context.getString(i2, objArr);
        SourcePayment sourcePayment3 = paymentOptionItem.getSourcePayment();
        if (sourcePayment3 == null || (str2 = sourcePayment3.getBankAccountNumber()) == null) {
            str2 = "";
        }
        textView.setText(m.a(string, str2));
        ImageView imageView = agVar.j;
        SourcePayment sourcePayment4 = paymentOptionItem.getSourcePayment();
        String ifscCode2 = sourcePayment4 != null ? sourcePayment4.getIfscCode() : null;
        ConstraintLayout a2 = agVar.a();
        k.a((Object) a2, "root");
        m.a(imageView, ifscCode2, a2.getContext());
        ac acVar = this.f55126c;
        SourcePayment sourcePayment5 = paymentOptionItem.getSourcePayment();
        if (sourcePayment5 != null) {
            TextView textView3 = acVar.n;
            k.a((Object) textView3, "sourceName");
            String bankName = sourcePayment5.getBankName();
            if (bankName == null) {
                bankName = "";
            }
            textView3.setText(m.a(bankName, sourcePayment5.getBankAccountNumber()));
            SourcePayment sourcePayment6 = paymentOptionItem.getSourcePayment();
            if (sourcePayment6 == null) {
                k.a();
            }
            CharSequence charSequence = map.get(sourcePayment6.getBankAccountNumber());
            if (charSequence == null || p.a(charSequence)) {
                z = true;
            }
            if (!z) {
                TextView textView4 = acVar.f53616h;
                k.a((Object) textView4, "checkBalanceTv");
                SourcePayment sourcePayment7 = paymentOptionItem.getSourcePayment();
                if (sourcePayment7 == null) {
                    k.a();
                }
                textView4.setText(map.get(sourcePayment7.getBankAccountNumber()));
                TextView textView5 = acVar.f53616h;
                ConstraintLayout a3 = acVar.a();
                k.a((Object) a3, "root");
                textView5.setTextColor(b.c(a3.getContext(), R.color.color_666666));
            } else if (k.a((Object) "Y", (Object) sourcePayment5.getMpinSet()) || !((sourcePayment = paymentOptionItem.getSourcePayment()) == null || (ifscCode = sourcePayment.getIfscCode()) == null || !p.a((CharSequence) ifscCode, (CharSequence) "PYTM", true))) {
                TextView textView6 = acVar.f53616h;
                k.a((Object) textView6, "checkBalanceTv");
                TextView textView7 = acVar.n;
                k.a((Object) textView7, "sourceName");
                textView6.setText(textView7.getContext().getString(R.string.check_balance));
                TextView textView8 = acVar.f53616h;
                TextView textView9 = acVar.n;
                k.a((Object) textView9, "sourceName");
                textView8.setTextColor(b.c(textView9.getContext(), R.color.color_00b9f5));
            } else {
                TextView textView10 = acVar.f53616h;
                k.a((Object) textView10, "checkBalanceTv");
                TextView textView11 = acVar.n;
                k.a((Object) textView11, "sourceName");
                textView10.setText(textView11.getContext().getString(R.string.upi_set_mpin));
                TextView textView12 = acVar.f53616h;
                TextView textView13 = acVar.n;
                k.a((Object) textView13, "sourceName");
                textView12.setTextColor(b.c(textView13.getContext(), R.color.color_00b9f5));
            }
            ImageView imageView2 = acVar.m;
            String ifscCode3 = sourcePayment5.getIfscCode();
            TextView textView14 = acVar.n;
            k.a((Object) textView14, "sourceName");
            m.a(imageView2, ifscCode3, textView14.getContext());
        }
        b(paymentOptionItem);
        b();
    }

    public final void a(PaymentOptionItem paymentOptionItem, ReceiverInfo receiverInfo, Map<String, String> map) {
        String str;
        String str2;
        SourcePayment sourcePayment;
        String ifscCode;
        k.c(paymentOptionItem, "paymentOptionItem");
        k.c(receiverInfo, "receiverInfo");
        k.c(map, "balanceMap");
        ag agVar = this.f55125b;
        TextView textView = agVar.P;
        k.a((Object) textView, "tvSelectedSourceLabel");
        TextView textView2 = agVar.P;
        k.a((Object) textView2, "tvSelectedSourceLabel");
        Context context = textView2.getContext();
        int i2 = R.string.mt_v4_selected_bank;
        Object[] objArr = new Object[1];
        SourcePayment sourcePayment2 = paymentOptionItem.getSourcePayment();
        if (sourcePayment2 == null || (str = sourcePayment2.getBankName()) == null) {
            str = "";
        }
        boolean z = false;
        objArr[0] = str;
        String string = context.getString(i2, objArr);
        SourcePayment sourcePayment3 = paymentOptionItem.getSourcePayment();
        if (sourcePayment3 == null || (str2 = sourcePayment3.getBankAccountNumber()) == null) {
            str2 = "";
        }
        textView.setText(m.a(string, str2));
        ImageView imageView = agVar.j;
        SourcePayment sourcePayment4 = paymentOptionItem.getSourcePayment();
        String ifscCode2 = sourcePayment4 != null ? sourcePayment4.getIfscCode() : null;
        ConstraintLayout a2 = agVar.a();
        k.a((Object) a2, "root");
        m.a(imageView, ifscCode2, a2.getContext());
        ac acVar = this.f55126c;
        SourcePayment sourcePayment5 = paymentOptionItem.getSourcePayment();
        if (sourcePayment5 != null) {
            TextView textView3 = acVar.n;
            k.a((Object) textView3, "sourceName");
            String bankName = sourcePayment5.getBankName();
            if (bankName == null) {
                bankName = "";
            }
            textView3.setText(m.a(bankName, sourcePayment5.getBankAccountNumber()));
            SourcePayment sourcePayment6 = paymentOptionItem.getSourcePayment();
            if (sourcePayment6 == null) {
                k.a();
            }
            CharSequence charSequence = map.get(sourcePayment6.getBankAccountNumber());
            if (charSequence == null || p.a(charSequence)) {
                z = true;
            }
            if (!z) {
                TextView textView4 = acVar.f53616h;
                k.a((Object) textView4, "checkBalanceTv");
                SourcePayment sourcePayment7 = paymentOptionItem.getSourcePayment();
                if (sourcePayment7 == null) {
                    k.a();
                }
                textView4.setText(map.get(sourcePayment7.getBankAccountNumber()));
                TextView textView5 = acVar.f53616h;
                ConstraintLayout a3 = acVar.a();
                k.a((Object) a3, "root");
                textView5.setTextColor(b.c(a3.getContext(), R.color.color_666666));
            } else if (k.a((Object) "Y", (Object) sourcePayment5.getMpinSet()) || !((sourcePayment = paymentOptionItem.getSourcePayment()) == null || (ifscCode = sourcePayment.getIfscCode()) == null || !p.a((CharSequence) ifscCode, (CharSequence) "PYTM", true))) {
                TextView textView6 = acVar.f53616h;
                k.a((Object) textView6, "checkBalanceTv");
                TextView textView7 = acVar.n;
                k.a((Object) textView7, "sourceName");
                textView6.setText(textView7.getContext().getString(R.string.check_balance));
                TextView textView8 = acVar.f53616h;
                TextView textView9 = acVar.n;
                k.a((Object) textView9, "sourceName");
                textView8.setTextColor(b.c(textView9.getContext(), R.color.color_00b9f5));
            } else {
                TextView textView10 = acVar.f53616h;
                k.a((Object) textView10, "checkBalanceTv");
                TextView textView11 = acVar.n;
                k.a((Object) textView11, "sourceName");
                textView10.setText(textView11.getContext().getString(R.string.upi_set_mpin));
                TextView textView12 = acVar.f53616h;
                TextView textView13 = acVar.n;
                k.a((Object) textView13, "sourceName");
                textView12.setTextColor(b.c(textView13.getContext(), R.color.color_00b9f5));
            }
            ImageView imageView2 = acVar.m;
            String ifscCode3 = sourcePayment5.getIfscCode();
            TextView textView14 = acVar.n;
            k.a((Object) textView14, "sourceName");
            m.a(imageView2, ifscCode3, textView14.getContext());
        }
        b(paymentOptionItem);
        b();
    }

    public final void a(PaymentOptionItem paymentOptionItem) {
        k.c(paymentOptionItem, "paymentOptionItem");
        ag agVar = this.f55125b;
        TextView textView = agVar.P;
        k.a((Object) textView, "tvSelectedSourceLabel");
        TextView textView2 = agVar.w;
        k.a((Object) textView2, "llUniPay");
        textView.setText(textView2.getContext().getString(R.string.paytm_wallet));
        agVar.j.setImageResource(R.drawable.mt_v4_wallet);
        ac acVar = this.f55126c;
        TextView textView3 = acVar.n;
        k.a((Object) textView3, "sourceName");
        TextView textView4 = acVar.n;
        k.a((Object) textView4, "sourceName");
        textView3.setText(textView4.getContext().getString(R.string.paytm_wallet));
        TextView textView5 = acVar.f53616h;
        TextView textView6 = acVar.n;
        k.a((Object) textView6, "sourceName");
        textView5.setTextColor(b.c(textView6.getContext(), R.color.color_1d252d));
        ImageView imageView = acVar.m;
        ConstraintLayout a2 = acVar.a();
        k.a((Object) a2, "root");
        imageView.setImageDrawable(b.a(a2.getContext(), R.drawable.mt_v4_wallet));
        SourcePayment sourcePayment = paymentOptionItem.getSourcePayment();
        String str = null;
        if (!TextUtils.isEmpty(sourcePayment != null ? sourcePayment.getBalance() : null)) {
            TextView textView7 = acVar.f53616h;
            k.a((Object) textView7, "checkBalanceTv");
            TextView textView8 = acVar.n;
            k.a((Object) textView8, "sourceName");
            Context context = textView8.getContext();
            int i2 = R.string.upi_new_balance;
            Object[] objArr = new Object[1];
            SourcePayment sourcePayment2 = paymentOptionItem.getSourcePayment();
            if (sourcePayment2 != null) {
                str = sourcePayment2.getBalance();
            }
            objArr[0] = UpiAppUtils.priceToString(str);
            textView7.setText(context.getString(i2, objArr));
        } else {
            TextView textView9 = acVar.f53616h;
            k.a((Object) textView9, "checkBalanceTv");
            TextView textView10 = acVar.n;
            k.a((Object) textView10, "sourceName");
            textView9.setText(textView10.getContext().getString(R.string.upi_available_balance));
        }
        b(paymentOptionItem);
        b();
    }

    public final void a(String str, PaymentOptionItem paymentOptionItem) {
        String str2 = this.f55124a;
        if (!(str2 != null ? Boolean.valueOf(str2.equals(str)) : null).booleanValue()) {
            if (str != null) {
                this.f55124a = str;
            }
            b(paymentOptionItem);
            b();
        }
    }

    private final void b(PaymentOptionItem paymentOptionItem) {
        if (paymentOptionItem != null) {
            SourcePayment sourcePayment = paymentOptionItem.getSourcePayment();
            String str = null;
            if (k.a((Object) SDKConstants.AI_KEY_WALLET, (Object) sourcePayment != null ? sourcePayment.getPaymentType() : null)) {
                TextView textView = this.f55125b.w;
                String str2 = this.f55124a;
                SourcePayment sourcePayment2 = paymentOptionItem.getSourcePayment();
                m.a(textView, str2, sourcePayment2 != null ? sourcePayment2.getBalance() : null);
                TextView textView2 = this.f55126c.f53611c;
                String str3 = this.f55124a;
                SourcePayment sourcePayment3 = paymentOptionItem.getSourcePayment();
                if (sourcePayment3 != null) {
                    str = sourcePayment3.getBalance();
                }
                m.a(textView2, str3, str);
                return;
            }
            m.a(this.f55125b.w, this.f55124a);
            m.a(this.f55126c.f53611c, this.f55124a);
        }
    }

    public final void a() {
        ag agVar = this.f55125b;
        agVar.p.setBackgroundColor(Color.parseColor("#0c00aced"));
        TextView textView = agVar.w;
        k.a((Object) textView, "llUniPay");
        f.a((View) textView);
        LottieAnimationView lottieAnimationView = agVar.o;
        k.a((Object) lottieAnimationView, "bottomLoader");
        f.b((View) lottieAnimationView);
        AnimationFactory.startWalletLoader(agVar.o);
        ac acVar = this.f55126c;
        acVar.f53612d.setBackgroundColor(Color.parseColor("#0c00aced"));
        TextView textView2 = acVar.f53611c;
        k.a((Object) textView2, "cardViewButton");
        f.a((View) textView2);
        LottieAnimationView lottieAnimationView2 = acVar.f53613e;
        k.a((Object) lottieAnimationView2, "cardViewloader");
        f.b((View) lottieAnimationView2);
        AnimationFactory.startWalletLoader(acVar.f53613e);
    }

    public final void b() {
        ag agVar = this.f55125b;
        agVar.p.setBackgroundColor(-1);
        TextView textView = agVar.w;
        k.a((Object) textView, "llUniPay");
        f.b((View) textView);
        LottieAnimationView lottieAnimationView = agVar.o;
        k.a((Object) lottieAnimationView, "bottomLoader");
        f.a((View) lottieAnimationView);
        AnimationFactory.stopWalletLoader(agVar.o);
        ac acVar = this.f55126c;
        acVar.f53612d.setBackgroundColor(-1);
        TextView textView2 = acVar.f53611c;
        k.a((Object) textView2, "cardViewButton");
        f.b((View) textView2);
        LottieAnimationView lottieAnimationView2 = acVar.f53613e;
        k.a((Object) lottieAnimationView2, "cardViewloader");
        f.a((View) lottieAnimationView2);
        AnimationFactory.stopWalletLoader(acVar.f53613e);
    }

    public final void a(String str) {
        k.c(str, "balance");
        ac acVar = this.f55126c;
        TextView textView = acVar.f53616h;
        k.a((Object) textView, "checkBalanceTv");
        textView.setText(str);
        TextView textView2 = acVar.f53616h;
        ConstraintLayout a2 = acVar.a();
        k.a((Object) a2, "root");
        textView2.setTextColor(b.c(a2.getContext(), R.color.color_666666));
    }
}
