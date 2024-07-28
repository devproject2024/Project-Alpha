package net.one97.paytm.paymentsBank.pdc.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public class f extends h implements View.OnClickListener {
    public static f a() {
        return new f();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pdc_status_options, (ViewGroup) null, false);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.pdc_track_order_action_item, (ViewGroup) null);
        ((TextView) inflate2.findViewById(R.id.action_text)).setText(R.string.needhelp_dialog_title);
        ((ImageView) inflate2.findViewById(R.id.action_icon)).setImageResource(R.drawable.pb_ic_help);
        inflate2.setOnClickListener(this);
        inflate2.setTag("HelpOptionView");
        ((ViewGroup) inflate.findViewById(R.id.pdcOptionLayout)).addView(inflate2);
        return inflate;
    }

    public void onClick(View view) {
        if ("HelpOptionView".equals((String) view.getTag())) {
            o.a().checkDeepLink(getActivity(), "paytmmp://csttree?featuretype=cst_issue&verticalid=1000004&l1=3000102");
        }
    }
}
