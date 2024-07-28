package net.one97.paytm.addmoney.cvvHelp.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.q;
import net.one97.paytm.addmoney.cvvHelp.a.a;
import net.one97.paytm.addmoney.cvvHelp.model.CvvHelpModel;
import net.one97.paytm.i.h;

public class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private CvvHelpModel f48554a;

    /* renamed from: b  reason: collision with root package name */
    private q f48555b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f48556c;

    public static c a(CvvHelpModel cvvHelpModel, a aVar) {
        c cVar = new c();
        cVar.f48554a = cvvHelpModel;
        cVar.f48556c = aVar;
        return cVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f48555b = (q) f.a(getLayoutInflater(), R.layout.uam_cvv_help_card_layout, (ViewGroup) null, false);
        this.f48555b.a(new net.one97.paytm.addmoney.cvvHelp.d.a(this.f48554a.getTitle(), this.f48554a.getDescription(), this.f48554a.getAmexCard()));
        if (this.f48554a.getAmexCard().booleanValue()) {
            this.f48555b.f48092c.setImageDrawable(getResources().getDrawable(R.drawable.cvv_help_amex_addmoney));
        } else {
            this.f48555b.f48092c.setImageDrawable(getResources().getDrawable(R.drawable.uam_cvv_help));
        }
        this.f48555b.f48090a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f48556c.a();
            }
        });
        this.f48555b.f48091b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.f48556c.a();
            }
        });
        return this.f48555b.getRoot();
    }
}
