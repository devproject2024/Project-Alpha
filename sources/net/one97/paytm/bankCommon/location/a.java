package net.one97.paytm.bankCommon.location;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.i.h;

public final class a extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final C0226a f16282b = new C0226a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.bankCommon.utils.b f16283a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f16284c;

    private View a(int i2) {
        if (this.f16284c == null) {
            this.f16284c = new HashMap();
        }
        View view = (View) this.f16284c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16284c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final net.one97.paytm.bankCommon.utils.b a() {
        net.one97.paytm.bankCommon.utils.b bVar = this.f16283a;
        if (bVar == null) {
            k.a("locationUtils");
        }
        return bVar;
    }

    /* renamed from: net.one97.paytm.bankCommon.location.a$a  reason: collision with other inner class name */
    public static final class C0226a {
        private C0226a() {
        }

        public /* synthetic */ C0226a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_bank_grant_permission, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f16283a = new net.one97.paytm.bankCommon.utils.b((AppCompatActivity) activity);
            View findViewById = view.findViewById(R.id.iv_back);
            k.a((Object) findViewById, "view.findViewById(R.id.iv_back)");
            ((ImageView) findViewById).setOnClickListener(new b(this));
            Button button = (Button) a(R.id.btn_grant_permission);
            if (button != null) {
                button.setOnClickListener(new c(this));
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16285a;

        b(a aVar) {
            this.f16285a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16285a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f16286a;

        c(a aVar) {
            this.f16286a = aVar;
        }

        public final void onClick(View view) {
            this.f16286a.a(false);
            if (this.f16286a.f16283a != null) {
                this.f16286a.a().a();
            }
        }
    }

    public final void onResume() {
        super.onResume();
        if (getActivity() != null) {
            if (com.google.android.gms.common.c.a().a((Context) getActivity()) != 0) {
                a(false);
                Context context = getContext();
                FragmentActivity activity = getActivity();
                Toast.makeText(context, activity != null ? activity.getString(R.string.play_services_unavailable) : null, 0).show();
                return;
            }
            a(true);
        }
    }

    public final void a(boolean z) {
        Button button = (Button) a(R.id.btn_grant_permission);
        if (button != null) {
            button.setEnabled(z);
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        if (this.f16283a != null) {
            net.one97.paytm.bankCommon.utils.b bVar = this.f16283a;
            if (bVar == null) {
                k.a("locationUtils");
            }
            k.c(strArr, "permissions");
            k.c(iArr, "grantResults");
            if (i2 == 1 && iArr[0] == 0) {
                bVar.a();
                return;
            }
            Context context = bVar.f16314a;
            bVar.a(context != null ? context.getString(R.string.loc_grant_permission) : null);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f16284c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
