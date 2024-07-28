package net.one97.paytm.paymentsBank.createfd.b;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;

public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f18102a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f18103b;

    public View a(int i2) {
        if (this.f18103b == null) {
            this.f18103b = new HashMap();
        }
        View view = (View) this.f18103b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18103b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void e() {
        HashMap hashMap = this.f18103b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        e();
    }

    /* access modifiers changed from: protected */
    public final void f() {
        ProgressDialog progressDialog;
        if (this.f18102a == null) {
            Context context = getContext();
            Context context2 = getContext();
            this.f18102a = ProgressDialog.show(context, r1, context2 != null ? context2.getString(R.string.please_wait) : null);
        }
        ProgressDialog progressDialog2 = this.f18102a;
        if (progressDialog2 != null && !progressDialog2.isShowing() && (progressDialog = this.f18102a) != null) {
            progressDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        try {
            ProgressDialog progressDialog = this.f18102a;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }
}
