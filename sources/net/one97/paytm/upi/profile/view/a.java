package net.one97.paytm.upi.profile.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.UpiAppUtils;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public String f68188a;

    /* renamed from: b  reason: collision with root package name */
    public String f68189b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f68190c;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_account_balance_breakup, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.tv_available_bal);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_available_bal)");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.rs_str, UpiAppUtils.priceToString(this.f68189b));
        k.a((Object) string, "getString(R.string.rs_st…String(availableBalance))");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        ((TextView) findViewById).setText(format);
        View findViewById2 = inflate.findViewById(R.id.tv_total_bal);
        k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.tv_total_bal)");
        aa aaVar2 = aa.f47921a;
        String string2 = getString(R.string.rs_str, UpiAppUtils.priceToString(this.f68188a));
        k.a((Object) string2, "getString(R.string.rs_st…ceToString(totalBalance))");
        String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
        k.a((Object) format2, "java.lang.String.format(format, *args)");
        ((TextView) findViewById2).setText(format2);
        ((ImageView) inflate.findViewById(R.id.upi_close_button)).setOnClickListener(new C1383a(this));
        try {
            String str = this.f68188a;
            double d2 = 0.0d;
            if (str != null) {
                double parseDouble = Double.parseDouble(str);
                String str2 = this.f68189b;
                if (str2 != null) {
                    d2 = Double.parseDouble(str2);
                }
                d2 = parseDouble - d2;
            }
            View findViewById3 = inflate.findViewById(R.id.tv_bal_on_hold);
            k.a((Object) findViewById3, "view.findViewById<TextView>(R.id.tv_bal_on_hold)");
            aa aaVar3 = aa.f47921a;
            String string3 = getString(R.string.rs_str, String.valueOf(d2));
            k.a((Object) string3, "getString(R.string.rs_str, onHoldMoney.toString())");
            String format3 = String.format(string3, Arrays.copyOf(new Object[0], 0));
            k.a((Object) format3, "java.lang.String.format(format, *args)");
            ((TextView) findViewById3).setText(format3);
        } catch (NumberFormatException unused) {
        }
        return inflate;
    }

    /* renamed from: net.one97.paytm.upi.profile.view.a$a  reason: collision with other inner class name */
    static final class C1383a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f68191a;

        C1383a(a aVar) {
            this.f68191a = aVar;
        }

        public final void onClick(View view) {
            this.f68191a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f68190c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
