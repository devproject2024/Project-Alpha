package net.one97.paytm.paymentsBank.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankOpen.ica.activity.ICAAccountOpeningActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.n;

public final class d extends p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18491a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f18492b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f18493c;

    private View a(int i2) {
        if (this.f18493c == null) {
            this.f18493c = new HashMap();
        }
        View view = (View) this.f18493c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18493c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ String a(d dVar) {
        String str = dVar.f18492b;
        if (str == null) {
            k.a("status");
        }
        return str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        String string = arguments.getString("status", "");
        k.a((Object) string, "arguments!!.getString(STATUS,\"\")");
        this.f18492b = string;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        if (n.g()) {
            return layoutInflater.inflate(R.layout.fragment_current_acc_open_tab, viewGroup, false);
        }
        return null;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (n.g()) {
            String str = this.f18492b;
            if (str == null) {
                k.a("status");
            }
            if ("NOT_APPLIED".equals(str)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.cl_acc_open);
                k.a((Object) constraintLayout, "cl_acc_open");
                constraintLayout.setVisibility(0);
                ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.cl_acc_application);
                k.a((Object) constraintLayout2, "cl_acc_application");
                constraintLayout2.setVisibility(8);
                ((TextView) a(R.id.tv_view_benefits)).setOnClickListener(new b(this));
                ((ImageView) a(R.id.iv_close)).setOnClickListener(new c(this));
                return;
            }
            ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.cl_acc_open);
            k.a((Object) constraintLayout3, "cl_acc_open");
            constraintLayout3.setVisibility(8);
            ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.cl_acc_application);
            k.a((Object) constraintLayout4, "cl_acc_application");
            constraintLayout4.setVisibility(0);
            ((ConstraintLayout) a(R.id.cl_acc_application)).setOnClickListener(new C0316d(this));
            String str2 = this.f18492b;
            if (str2 == null) {
                k.a("status");
            }
            if (str2.equals("TRACK")) {
                TextView textView = (TextView) a(R.id.tv_app_reject);
                k.a((Object) textView, "tv_app_reject");
                textView.setVisibility(8);
                ((TextView) a(R.id.tv_doc_verification)).setText(R.string.doc_verification_in_process);
                return;
            }
            TextView textView2 = (TextView) a(R.id.tv_app_reject);
            k.a((Object) textView2, "tv_app_reject");
            textView2.setVisibility(0);
            ((TextView) a(R.id.tv_doc_verification)).setText(R.string.incorrect_doc);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18494a;

        b(d dVar) {
            this.f18494a = dVar;
        }

        public final void onClick(View view) {
            this.f18494a.startActivity(new Intent(this.f18494a.getActivity(), ICAAccountOpeningActivity.class));
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18495a;

        c(d dVar) {
            this.f18495a = dVar;
        }

        public final void onClick(View view) {
            if (this.f18495a.getParentFragment() != null) {
                Fragment parentFragment = this.f18495a.getParentFragment();
                if (parentFragment != null) {
                    ((b) parentFragment).o();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.fragment.BankTabFragment");
            }
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.fragment.d$d  reason: collision with other inner class name */
    static final class C0316d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18496a;

        C0316d(d dVar) {
            this.f18496a = dVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f18496a.getActivity(), ICAAccountOpeningActivity.class);
            intent.putExtra("icastatus", d.a(this.f18496a));
            this.f18496a.startActivity(intent);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18493c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final d a(String str) {
        k.c(str, "status");
        Bundle bundle = new Bundle();
        bundle.putString("status", str);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }
}
