package com.travel.train.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.model.metro.CJRMetroHomeCityBottomSheetModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;

public final class f extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f26956a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f26957b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRMetroHomeCityBottomSheetModel> f26958c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f26959d;

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_bottom_sheet_metro_dialog_layout, viewGroup, false);
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f26958c = (ArrayList) arguments.getSerializable(g.x);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        View findViewById = view.findViewById(R.id.metro_list_recyclerview_in_bottomsheet);
        k.a((Object) findViewById, "view.findViewById(R.id.m…yclerview_in_bottomsheet)");
        this.f26956a = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.close_bottomsheetfragment);
        k.a((Object) findViewById2, "view.findViewById(R.id.close_bottomsheetfragment)");
        this.f26957b = (ImageView) findViewById2;
        ImageView imageView = this.f26957b;
        if (imageView == null) {
            k.a("closeImageView");
        }
        imageView.setOnClickListener(new a(this));
        if (this.f26958c != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context baseContext = activity.getBaseContext();
            k.a((Object) baseContext, "activity!!.baseContext");
            ArrayList<CJRMetroHomeCityBottomSheetModel> arrayList = this.f26958c;
            if (arrayList == null) {
                k.a();
            }
            com.travel.train.b.f fVar = new com.travel.train.b.f(baseContext, arrayList);
            RecyclerView recyclerView = this.f26956a;
            if (recyclerView == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView.setAdapter(fVar);
            RecyclerView recyclerView2 = this.f26956a;
            if (recyclerView2 == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            RecyclerView recyclerView3 = this.f26956a;
            if (recyclerView3 == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView3.setHasFixedSize(true);
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

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f26960a;

        a(f fVar) {
            this.f26960a = fVar;
        }

        public final void onClick(View view) {
            this.f26960a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f26959d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
