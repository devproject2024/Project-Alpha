package net.one97.paytm.upi.mandate.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.e.s;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.c.a;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67535a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private s f67536b;

    /* renamed from: c  reason: collision with root package name */
    private MandateItem f67537c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f67538d;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Object obj = arguments.get("mandate_item");
        if (obj != null) {
            this.f67537c = (MandateItem) obj;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_pager_pending_mandate, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f67536b = s.a(view);
        s sVar = this.f67536b;
        if (sVar == null) {
            k.a();
        }
        TextView textView = sVar.f66889f;
        k.a((Object) textView, "payeeName");
        MandateItem mandateItem = this.f67537c;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        textView.setText(mandateItem.getPayee().getUserName());
        TextView textView2 = sVar.f66890g;
        k.a((Object) textView2, "payeeVpa");
        MandateItem mandateItem2 = this.f67537c;
        if (mandateItem2 == null) {
            k.a("mandateItem");
        }
        textView2.setText(mandateItem2.getPayee().getVpa());
        TextView textView3 = sVar.f66884a;
        k.a((Object) textView3, "amount");
        MandateItem mandateItem3 = this.f67537c;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        if (k.a((Object) mandateItem3.getAmountRule(), (Object) "MAX")) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.upi_mandate_upto) + " ");
            MandateItem mandateItem4 = this.f67537c;
            if (mandateItem4 == null) {
                k.a("mandateItem");
            }
            String formatNumber = UpiAppUtils.formatNumber(mandateItem4.getAmount());
            k.a((Object) formatNumber, "UpiAppUtils.formatNumber(mandateItem.amount)");
            sb.append(f.b(formatNumber));
            charSequence = sb.toString();
        } else {
            MandateItem mandateItem5 = this.f67537c;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            String formatNumber2 = UpiAppUtils.formatNumber(mandateItem5.getAmount());
            k.a((Object) formatNumber2, "UpiAppUtils.formatNumber(mandateItem.amount)");
            charSequence = f.b(formatNumber2);
        }
        textView3.setText(charSequence);
        TextView textView4 = sVar.f66888e;
        k.a((Object) textView4, "nameInitials");
        TextView textView5 = sVar.f66889f;
        k.a((Object) textView5, "payeeName");
        textView4.setText(UpiUtils.getNameInitials(textView5.getText().toString()));
        sVar.f66887d.setImageResource(R.color.paytm_blue);
        sVar.f66885b.setOnClickListener(new b(this));
        TextView textView6 = sVar.f66891h;
        k.a((Object) textView6, "updatePlaceHolder");
        View view2 = textView6;
        MandateItem mandateItem6 = this.f67537c;
        if (mandateItem6 == null) {
            k.a("mandateItem");
        }
        CharSequence accRefId = mandateItem6.getAccRefId();
        f.a(view2, !(accRefId == null || p.a(accRefId)));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy, hh:mm a");
        MandateItem mandateItem7 = this.f67537c;
        if (mandateItem7 == null) {
            k.a("mandateItem");
        }
        String mandateApprovalExpireOn = mandateItem7.getMandateApprovalExpireOn();
        String format = simpleDateFormat.format(new Date(mandateApprovalExpireOn != null ? Long.parseLong(mandateApprovalExpireOn) : 0));
        TextView textView7 = sVar.f66892i;
        k.a((Object) textView7, "validity");
        textView7.setText(getString(R.string.upi_request_expires, format));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f67539a;

        b(j jVar) {
            this.f67539a = jVar;
        }

        public final void onClick(View view) {
            j.a(this.f67539a);
        }
    }

    public final void onDestroyView() {
        this.f67536b = null;
        super.onDestroyView();
        HashMap hashMap = this.f67538d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        a.C1352a aVar = net.one97.paytm.upi.mandate.c.a.f67054a;
        MandateItem mandateItem = jVar.f67537c;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        androidx.fragment.app.j childFragmentManager = jVar.getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        a.C1352a.a(mandateItem, childFragmentManager, (UpiPendingRequestModel) null);
    }
}
