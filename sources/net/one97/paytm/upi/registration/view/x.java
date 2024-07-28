package net.one97.paytm.upi.registration.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;

public final class x extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69085a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f69086b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_reactivate_frgament, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.iv_back)).setOnClickListener(new b(this));
        ((TextView) inflate.findViewById(R.id.tv_re_activate_account)).setOnClickListener(new c(this));
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f69087a;

        b(x xVar) {
            this.f69087a = xVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f69087a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x f69088a;

        c(x xVar) {
            this.f69088a = xVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f69088a.getActivity(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", 36);
            FragmentActivity activity = this.f69088a.getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 36);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f69086b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final x a() {
        return new x();
    }
}
