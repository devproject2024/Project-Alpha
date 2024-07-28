package net.one97.paytm.addmoney.cvvHelp.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.s;
import net.one97.paytm.addmoney.cvvHelp.a.a;
import net.one97.paytm.i.f;

public class b extends f implements a {

    /* renamed from: a  reason: collision with root package name */
    private s f48552a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.addmoney.cvvHelp.b.a f48553b;

    public static b a(net.one97.paytm.addmoney.cvvHelp.b.a aVar) {
        b bVar = new b();
        bVar.f48553b = aVar;
        return bVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f48552a = (s) androidx.databinding.f.a(layoutInflater, R.layout.uam_cvv_help_layout, viewGroup, false);
        this.f48552a.f48099a.setAdapter(new a(getActivity(), getChildFragmentManager(), this.f48553b, this));
        return this.f48552a.getRoot();
    }

    public final void a() {
        dismiss();
    }
}
