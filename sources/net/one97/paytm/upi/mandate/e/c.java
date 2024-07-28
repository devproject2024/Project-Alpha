package net.one97.paytm.upi.mandate.e;

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
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.e.j;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.e.a;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class c extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67166a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private MandateItem f67167b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f67168c;

    public final void b() {
        HashMap hashMap = this.f67168c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public static final /* synthetic */ MandateItem a(c cVar) {
        MandateItem mandateItem = cVar.f67167b;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        return mandateItem;
    }

    public final int a() {
        return R.layout.bottom_sheet_mandate_details;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("mandate_item");
        if (serializable != null) {
            this.f67167b = (MandateItem) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        j a2 = j.a(view);
        k.a((Object) a2, "BottomSheetMandateDetailsBinding.bind(view)");
        TextView textView = a2.p;
        k.a((Object) textView, "tvImportantLabel");
        f.a(textView, R.drawable.upi_ic_important);
        TextView textView2 = a2.l;
        k.a((Object) textView2, "payeeName");
        MandateItem mandateItem = this.f67167b;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        textView2.setText(mandateItem.getPayee().getUserName());
        TextView textView3 = a2.m;
        k.a((Object) textView3, "payeeVpa");
        MandateItem mandateItem2 = this.f67167b;
        if (mandateItem2 == null) {
            k.a("mandateItem");
        }
        textView3.setText(mandateItem2.getPayee().getVpa());
        TextView textView4 = a2.f66833a;
        k.a((Object) textView4, "amountTextView");
        MandateItem mandateItem3 = this.f67167b;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        if (k.a((Object) mandateItem3.getAmountRule(), (Object) "MAX")) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.upi_mandate_upto) + " ");
            MandateItem mandateItem4 = this.f67167b;
            if (mandateItem4 == null) {
                k.a("mandateItem");
            }
            String formatNumber = UpiAppUtils.formatNumber(mandateItem4.getAmount());
            k.a((Object) formatNumber, "UpiAppUtils.formatNumber(mandateItem.amount)");
            sb.append(f.b(formatNumber));
            charSequence = sb.toString();
        } else {
            MandateItem mandateItem5 = this.f67167b;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            String formatNumber2 = UpiAppUtils.formatNumber(mandateItem5.getAmount());
            k.a((Object) formatNumber2, "UpiAppUtils.formatNumber(mandateItem.amount)");
            charSequence = f.b(formatNumber2);
        }
        textView4.setText(charSequence);
        a2.j.setCircularBorder(true, (int) getResources().getDimension(R.dimen.dimen_2dp));
        MandateItem mandateItem6 = this.f67167b;
        if (mandateItem6 == null) {
            k.a("mandateItem");
        }
        CharSequence imageUrl = mandateItem6.getPayee().getImageUrl();
        if (imageUrl == null || p.a(imageUrl)) {
            a2.j.setImageResource(R.color.paytm_blue);
            TextView textView5 = a2.k;
            k.a((Object) textView5, "nameInitials");
            f.b((View) textView5);
            TextView textView6 = a2.k;
            k.a((Object) textView6, "nameInitials");
            MandateItem mandateItem7 = this.f67167b;
            if (mandateItem7 == null) {
                k.a("mandateItem");
            }
            textView6.setText(UpiUtils.getNameInitials(f.a(mandateItem7.getPayee().getUserName())));
        } else {
            w a3 = w.a();
            MandateItem mandateItem8 = this.f67167b;
            if (mandateItem8 == null) {
                k.a("mandateItem");
            }
            a3.a(mandateItem8.getPayee().getImageUrl()).a((ImageView) a2.j);
        }
        TextView textView7 = a2.q;
        k.a((Object) textView7, "umnTextView");
        int i2 = R.string.upi_umn_no;
        Object[] objArr = new Object[1];
        MandateItem mandateItem9 = this.f67167b;
        if (mandateItem9 == null) {
            k.a("mandateItem");
        }
        objArr[0] = mandateItem9.getUmn();
        textView7.setText(getString(i2, objArr));
        TextView textView8 = a2.o;
        k.a((Object) textView8, "rrnTextView");
        int i3 = R.string.upi_rrn;
        Object[] objArr2 = new Object[1];
        MandateItem mandateItem10 = this.f67167b;
        if (mandateItem10 == null) {
            k.a("mandateItem");
        }
        objArr2[0] = mandateItem10.getRrn();
        textView8.setText(getString(i3, objArr2));
        TextView textView9 = a2.f66837e;
        k.a((Object) textView9, "bankName");
        MandateItem mandateItem11 = this.f67167b;
        if (mandateItem11 == null) {
            k.a("mandateItem");
        }
        String bankName = mandateItem11.getPayer().getBankName();
        if (bankName == null) {
            k.a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bankName + " ");
        MandateItem mandateItem12 = this.f67167b;
        if (mandateItem12 == null) {
            k.a("mandateItem");
        }
        sb2.append(UpiUtils.getFormattedMaskedAcc(mandateItem12.getPayer().getBankAccount()));
        textView9.setText(sb2.toString());
        ImageView imageView = a2.f66835c;
        MandateItem mandateItem13 = this.f67167b;
        if (mandateItem13 == null) {
            k.a("mandateItem");
        }
        UpiUtils.setBankIcon(imageView, mandateItem13.getPayer().getBankIfsc(), requireContext());
        a2.r.setOnClickListener(new b(this));
        a2.f66839g.setOnClickListener(new C1358c(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67169a;

        b(c cVar) {
            this.f67169a = cVar;
        }

        public final void onClick(View view) {
            a.C1357a aVar = a.f67157a;
            MandateItem a2 = c.a(this.f67169a);
            androidx.fragment.app.j childFragmentManager = this.f67169a.getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            k.c(a2, "mandateItem");
            k.c(childFragmentManager, "fragmentManager");
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mandate_item", a2);
            aVar2.setArguments(bundle);
            aVar2.show(childFragmentManager, "");
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.e.c$c  reason: collision with other inner class name */
    static final class C1358c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f67170a;

        C1358c(c cVar) {
            this.f67170a = cVar;
        }

        public final void onClick(View view) {
            this.f67170a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(MandateItem mandateItem, androidx.fragment.app.j jVar) {
            k.c(mandateItem, "mandateItem");
            k.c(jVar, "fragmentManager");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("mandate_item", mandateItem);
            cVar.setArguments(bundle);
            cVar.show(jVar, "");
        }
    }
}
