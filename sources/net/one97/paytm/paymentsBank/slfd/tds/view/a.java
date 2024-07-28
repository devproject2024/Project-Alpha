package net.one97.paytm.paymentsBank.slfd.tds.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;

public class a extends f {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_certificate_confirmation_bs, viewGroup, false);
        String string = getArguments().getString("EXTRA_CERTIFICATE_CONFIRMATION_BOTTOM_SHEET_TITLE");
        if (!TextUtils.isEmpty(string)) {
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(string);
        }
        ((Button) inflate.findViewById(R.id.btn_done)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.tv_email)).setText(getString(R.string.pb_tds_to_email, getArguments().getString("email_extra")));
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
        getActivity().finish();
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}
