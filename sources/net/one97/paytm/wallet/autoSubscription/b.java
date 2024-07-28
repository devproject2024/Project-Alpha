package net.one97.paytm.wallet.autoSubscription;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.i.f;

public class b extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f69958a;

    public interface a {
        void b();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddDebitOrCreditCard) {
            this.f69958a = (AddDebitOrCreditCard) context;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.subscription_confirm_dialog_layout_addmoney, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.header_tv);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.getBoolean("IS_ADD_CARD", false)) {
                textView.setText(getResources().getString(R.string.auto_card_add_a_card));
            } else {
                textView.setText(getResources().getString(R.string.auto_authenticate_card));
            }
        }
        inflate.findViewById(R.id.cancel_iv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
            }
        });
        inflate.findViewById(R.id.proceed_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.dismiss();
                if (b.this.f69958a != null) {
                    b.this.f69958a.b();
                }
            }
        });
        return inflate;
    }
}
