package net.one97.paytm.upgradeKyc.form60.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.one97.paytm.i.g;
import net.one97.paytm.upgradeKyc.R;

public class a extends g {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.form60_submitted_dialog_layout, viewGroup, false);
        getDialog().requestWindowFeature(1);
        return inflate;
    }

    public static a a() {
        Bundle bundle = new Bundle();
        a aVar = new a();
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_400dp);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dimen_204dp);
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(dimensionPixelSize, dimensionPixelSize2);
            getDialog().getWindow().setBackgroundDrawableResource(17170445);
        }
    }
}
