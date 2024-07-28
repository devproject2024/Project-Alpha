package net.one97.paytm.passbook.statementDownload;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.utility.b;
import java.util.Calendar;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.statementDownload.m;

public class j extends h implements m.b {

    /* renamed from: a  reason: collision with root package name */
    private m f58717a;

    public final boolean a(String str) {
        return false;
    }

    public final boolean a(String str, int i2) {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = 0;
        View inflate = layoutInflater.inflate(R.layout.pass_w_calendar_view, viewGroup, false);
        int g2 = b.g((Context) getActivity());
        inflate.setPadding(g2, 0, g2, 0);
        boolean z = getArguments().getInt("key_index") == 1;
        this.f58717a.a(inflate, z);
        Calendar instance = Calendar.getInstance();
        if (!z) {
            i2 = -1;
        }
        instance.add(2, i2);
        this.f58717a.b(instance.get(1), instance.get(2) + 1, instance.get(5));
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f58717a == null) {
            this.f58717a = new m();
            this.f58717a.f58733i = "dd MMM yyyy";
        }
        this.f58717a.a(activity);
    }

    public void onDetach() {
        super.onDetach();
        m mVar = this.f58717a;
        if (mVar != null) {
            mVar.a();
        }
    }
}
