package net.one97.paytm.paymentsBank.fragment;

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
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;

public final class g extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18508b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.paymentsBank.permission.a f18509a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f18510c;

    private View a(int i2) {
        if (this.f18510c == null) {
            this.f18510c = new HashMap();
        }
        View view = (View) this.f18510c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18510c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
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
        System.out.println("fragmenttttt_bank_libraryyyy");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f18509a = new net.one97.paytm.paymentsBank.permission.a((AppCompatActivity) activity);
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
        final /* synthetic */ g f18511a;

        b(g gVar) {
            this.f18511a = gVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f18511a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f18512a;

        c(g gVar) {
            this.f18512a = gVar;
        }

        public final void onClick(View view) {
            this.f18512a.a(false);
            if (this.f18512a.f18509a != null) {
                net.one97.paytm.paymentsBank.permission.a aVar = this.f18512a.f18509a;
                if (aVar == null) {
                    k.a("locationUtils");
                }
                aVar.a();
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
        if (this.f18509a != null) {
            net.one97.paytm.paymentsBank.permission.a aVar = this.f18509a;
            if (aVar == null) {
                k.a("locationUtils");
            }
            k.c(strArr, "permissions");
            k.c(iArr, "grantResults");
            if (i2 == 1 && iArr[0] == 0) {
                aVar.a();
                return;
            }
            Context context = aVar.f18754a;
            aVar.a(context != null ? context.getString(R.string.loc_grant_permission) : null);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18510c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
