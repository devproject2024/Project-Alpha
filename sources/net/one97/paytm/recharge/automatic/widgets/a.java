package net.one97.paytm.recharge.automatic.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.i.g;
import net.one97.paytm.recharge.R;

public class a extends g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private C1164a f60302a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f60303b;

    /* renamed from: net.one97.paytm.recharge.automatic.widgets.a$a  reason: collision with other inner class name */
    public interface C1164a {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof C1164a) {
            this.f60302a = (C1164a) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.w_custom_add_money_si_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        String str2;
        super.onViewCreated(view, bundle);
        String str3 = null;
        if (getArguments() == null) {
            str = getString(R.string.proceed);
            str2 = getString(R.string.cancel);
        } else {
            str3 = getArguments().getString("message", (String) null);
            str = getArguments().getString("positive", getString(R.string.proceed));
            str2 = getArguments().getString("negative", getString(R.string.cancel));
        }
        ((TextView) view.findViewById(R.id.w_custom_dialog_message)).setText(str3);
        TextView textView = (TextView) view.findViewById(R.id.w_custom_dialog_btn_positive);
        textView.setText(str);
        TextView textView2 = (TextView) view.findViewById(R.id.w_custom_dialog_btn_negative);
        textView2.setText(str2);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        getDialog().setOnCancelListener(this.f60303b);
    }

    public void onClick(View view) {
        if (this.f60302a != null) {
            view.getId();
            int i2 = R.id.w_custom_dialog_btn_positive;
        }
        dismiss();
    }
}
