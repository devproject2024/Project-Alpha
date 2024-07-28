package net.one97.paytm.fastag.ui.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.one97.paytm.fastag.R;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f13842a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13843b;

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener($$Lambda$a$DGkA_IAxumDDeZpLruKNHr6UieI.INSTANCE);
        return aVar;
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        dialog.setContentView(View.inflate(getContext(), R.layout.dialog_ask_for_kyc_ft, (ViewGroup) null));
        this.f13842a = (ImageView) dialog.findViewById(R.id.iv_close);
        this.f13842a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.f13843b = (TextView) dialog.findViewById(R.id.complete_now_tv);
        this.f13843b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (isAdded()) {
            dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        try {
            net.one97.paytm.fastag.c.b bVar = net.one97.paytm.fastag.c.a.a().f13559b;
            Context context = view.getContext();
            bVar.checkDeepLinking(context, net.one97.paytm.fastag.c.a.a().f13559b.deeplinkSchemaName() + "min_kyc?call_back_url=" + URLEncoder.encode("paytmmp://fastag_toll", AppConstants.UTF_8) + "&vertical=" + "FASTag");
        } catch (UnsupportedEncodingException unused) {
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }
}
