package net.one97.paytm.upi.mandate.update;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.h;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: b  reason: collision with root package name */
    public static final C1370a f67340b = new C1370a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public kotlin.g.a.a<x> f67341a;

    /* renamed from: c  reason: collision with root package name */
    private MandateItem f67342c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67343d;

    public final void b() {
        HashMap hashMap = this.f67343d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("mandate_Item");
        if (serializable != null) {
            this.f67342c = (MandateItem) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
    }

    public final int a() {
        return R.layout.bottom_sheet_mandate_decline_confirm;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        h a2 = h.a(view);
        k.a((Object) a2, "BottomSheetMandateDeclineConfirmBinding.bind(view)");
        a2.f66817c.setOnClickListener(new b(this));
        TextView textView = a2.f66821g;
        k.a((Object) textView, "payeeName");
        MandateItem mandateItem = this.f67342c;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        textView.setText(mandateItem.getPayee().getUserName());
        TextView textView2 = a2.f66822h;
        k.a((Object) textView2, "payeeVpa");
        int i2 = R.string.upi_address_value;
        Object[] objArr = new Object[1];
        MandateItem mandateItem2 = this.f67342c;
        if (mandateItem2 == null) {
            k.a("mandateItem");
        }
        objArr[0] = mandateItem2.getPayee().getVpa();
        textView2.setText(getString(i2, objArr));
        TextView textView3 = a2.f66815a;
        k.a((Object) textView3, "amountTextView");
        MandateItem mandateItem3 = this.f67342c;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        if (k.a((Object) mandateItem3.getAmountRule(), (Object) "MAX")) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.upi_mandate_upto) + " ");
            MandateItem mandateItem4 = this.f67342c;
            if (mandateItem4 == null) {
                k.a("mandateItem");
            }
            String formatNumber = UpiAppUtils.formatNumber(mandateItem4.getAmount());
            k.a((Object) formatNumber, "UpiAppUtils.formatNumber(mandateItem.amount)");
            sb.append(f.b(formatNumber));
            charSequence = sb.toString();
        } else {
            MandateItem mandateItem5 = this.f67342c;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            String formatNumber2 = UpiAppUtils.formatNumber(mandateItem5.getAmount());
            k.a((Object) formatNumber2, "UpiAppUtils.formatNumber(mandateItem.amount)");
            charSequence = f.b(formatNumber2);
        }
        textView3.setText(charSequence);
        a2.f66819e.setCircularBorder(true, (int) getResources().getDimension(R.dimen.dimen_2dp));
        MandateItem mandateItem6 = this.f67342c;
        if (mandateItem6 == null) {
            k.a("mandateItem");
        }
        CharSequence imageUrl = mandateItem6.getPayee().getImageUrl();
        if (imageUrl == null || p.a(imageUrl)) {
            a2.f66819e.setImageResource(R.color.paytm_blue);
            TextView textView4 = a2.f66820f;
            k.a((Object) textView4, "nameInitials");
            f.b((View) textView4);
            TextView textView5 = a2.f66820f;
            k.a((Object) textView5, "nameInitials");
            MandateItem mandateItem7 = this.f67342c;
            if (mandateItem7 == null) {
                k.a("mandateItem");
            }
            textView5.setText(UpiUtils.getNameInitials(f.a(mandateItem7.getPayee().getUserName())));
        } else {
            w a3 = w.a();
            MandateItem mandateItem8 = this.f67342c;
            if (mandateItem8 == null) {
                k.a("mandateItem");
            }
            a3.a(mandateItem8.getPayee().getImageUrl()).a((ImageView) a2.f66819e);
        }
        a2.j.setOnClickListener(new c(this));
        MandateItem mandateItem9 = this.f67342c;
        if (mandateItem9 == null) {
            k.a("mandateItem");
        }
        if (k.a((Object) mandateItem9.getType(), (Object) "ONETIME")) {
            TextView textView6 = a2.k;
            f.b((View) textView6);
            int i3 = R.string.upi_mandate_valid_to;
            Object[] objArr2 = new Object[2];
            MandateItem mandateItem10 = this.f67342c;
            if (mandateItem10 == null) {
                k.a("mandateItem");
            }
            objArr2[0] = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMM yyyy", mandateItem10.getValidityStartDate());
            MandateItem mandateItem11 = this.f67342c;
            if (mandateItem11 == null) {
                k.a("mandateItem");
            }
            objArr2[1] = UpiUtils.convertDateFromTo("ddMMyyyy", "dd MMM yyyy", mandateItem11.getValidityEndDate());
            textView6.setText(getString(i3, objArr2));
            TextView textView7 = a2.f66815a;
            k.a((Object) textView7, "amountTextView");
            f.b((View) textView7, (int) getResources().getDimension(R.dimen.dimen_12dp));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67344a;

        b(a aVar) {
            this.f67344a = aVar;
        }

        public final void onClick(View view) {
            this.f67344a.dismiss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67345a;

        c(a aVar) {
            this.f67345a = aVar;
        }

        public final void onClick(View view) {
            kotlin.g.a.a a2 = this.f67345a.f67341a;
            if (a2 != null) {
                a2.invoke();
            }
            this.f67345a.dismiss();
        }
    }

    public final void onDestroy() {
        this.f67341a = null;
        super.onDestroy();
    }

    /* renamed from: net.one97.paytm.upi.mandate.update.a$a  reason: collision with other inner class name */
    public static final class C1370a {
        private C1370a() {
        }

        public /* synthetic */ C1370a(byte b2) {
            this();
        }
    }
}
