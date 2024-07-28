package net.one97.paytm.paymentsBank.pdc.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.paymentsBank.R;

public class g extends c {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.passcodeLayout);
        viewGroup2.setPadding(viewGroup2.getPaddingLeft(), f.a(getResources().getDimensionPixelSize(R.dimen.dimen_100dp)), viewGroup2.getPaddingRight(), viewGroup2.getPaddingBottom());
        onCreateView.setBackgroundResource(R.color.white);
        return onCreateView;
    }
}
