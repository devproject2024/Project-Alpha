package net.one97.paytm.addmoney.landing.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.helper.a;
import net.one97.paytm.i.h;

public class e extends h implements View.OnClickListener {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_min_kyc_banner, viewGroup, false);
        inflate.findViewById(R.id.kyc_layout_rl).setOnClickListener(this);
        return inflate;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.kyc_layout_rl) {
            startActivity(a.b().l(getActivity()));
        }
    }
}
