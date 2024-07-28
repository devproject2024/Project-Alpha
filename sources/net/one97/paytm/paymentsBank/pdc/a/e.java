package net.one97.paytm.paymentsBank.pdc.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;

public class e extends h {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pdc_deliver_address, (ViewGroup) null, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        String string = arguments.getString("extra_address");
        String string2 = arguments.getString("extra_name");
        String string3 = arguments.getString("extra_mobile");
        View view = getView();
        ((TextView) view.findViewById(R.id.pdc_delivery_name)).setText(string2);
        ((TextView) view.findViewById(R.id.pdc_delivery_address)).setText(string);
        if (!TextUtils.isEmpty(string3) && string3.length() == 10) {
            ((TextView) view.findViewById(R.id.pdc_delivery_ph_no)).setText(string3.substring(0, 5) + " " + string3.substring(5, 10));
        }
    }
}
