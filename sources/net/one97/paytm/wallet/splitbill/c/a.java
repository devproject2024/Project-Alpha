package net.one97.paytm.wallet.splitbill.c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private TextView f72107a;

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_bottom_sheet_add_bill_success, viewGroup, false);
        this.f72107a = (TextView) inflate.findViewById(R.id.msg);
        this.f72107a.setText("Split Bill Request\nSent Successfully");
        return inflate;
    }
}
