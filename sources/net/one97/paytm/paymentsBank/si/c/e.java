package net.one97.paytm.paymentsBank.si.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.i.g;
import net.one97.paytm.paymentsBank.R;

public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public d f18885a;

    public static e a(d dVar) {
        e eVar = new e();
        eVar.f18885a = dVar;
        return eVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setOnDismissListener(this);
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.si_fragment_success, (ViewGroup) null, false);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        d dVar = this.f18885a;
        if (dVar != null) {
            dVar.onFragmentAction(107, (Object) null);
        }
        super.onDismiss(dialogInterface);
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }
}
