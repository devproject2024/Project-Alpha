package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.travel.train.R;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;

public final class al extends f {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f26893a;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme_train);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_where_is_my_pnr_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.close_pnr_dialog);
        k.a((Object) findViewById, "view.findViewById(R.id.close_pnr_dialog)");
        findViewById.setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ al f26894a;

        a(al alVar) {
            this.f26894a = alVar;
        }

        public final void onClick(View view) {
            this.f26894a.dismiss();
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f26893a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
