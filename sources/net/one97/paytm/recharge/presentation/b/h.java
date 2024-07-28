package net.one97.paytm.recharge.presentation.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.g;
import net.one97.paytm.recharge.presentation.a.i;
import net.one97.paytm.recharge.presentation.d.e;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64776a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static e f64777c;

    /* renamed from: b  reason: collision with root package name */
    private i f64778b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f64779d;

    private View a(int i2) {
        if (this.f64779d == null) {
            this.f64779d = new HashMap();
        }
        View view = (View) this.f64779d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64779d.put(Integer.valueOf(i2), findViewById);
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
        return layoutInflater.inflate(R.layout.bottom_sheet_recharge_days, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        ((RecyclerView) a(R.id.rv_days)).setHasFixedSize(true);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_days);
        k.a((Object) recyclerView, "rv_days");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        e eVar = f64777c;
        if (eVar == null) {
            k.a();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("pre_selected_recharge_days")) == null) {
            str = "";
        }
        this.f64778b = new i(eVar, str);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_days);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        recyclerView2.addItemDecoration(new g(activity, 50));
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_days);
        k.a((Object) recyclerView3, "rv_days");
        recyclerView3.setAdapter(this.f64778b);
        ImageView imageView = (ImageView) a(R.id.ic_close);
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f64780a;

        b(h hVar) {
            this.f64780a = hVar;
        }

        public final void onClick(View view) {
            this.f64780a.dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64779d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
