package com.travel.citybus.brts.citybus;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.pojo.CJRCity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;

public final class s extends f {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f23322a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f23323b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRCity> f23324c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f23325d;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_bottom_sheet_citybus_dialog_layout, viewGroup, false);
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
    }

    public final void onCreate(Bundle bundle) {
        List<CJRCity> list;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("city_list_key");
        if (serializable != null) {
            ArrayList arrayList = (ArrayList) serializable;
            if (arrayList != null) {
                Collection arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (((CJRCity) next).isEnabled()) {
                        arrayList2.add(next);
                    }
                }
                list = (List) arrayList2;
            } else {
                list = null;
            }
            this.f23324c = list;
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.citybus.brts.model.pojo.CJRCity> /* = java.util.ArrayList<com.travel.citybus.brts.model.pojo.CJRCity> */");
    }

    public final void onAttach(Context context) {
        k.c(context, "activity");
        com.travel.citybus.a.a.a(context);
        super.onAttach(context);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window2 = dialog.getWindow()) == null)) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog2 = getDialog();
        if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
            window.addFlags(67108864);
        }
        View findViewById = view.findViewById(R.id.citybus_list_recyclerview_in_bottomsheet);
        k.a((Object) findViewById, "view.findViewById(R.id.c…yclerview_in_bottomsheet)");
        this.f23322a = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.close_bottomsheetfragment);
        k.a((Object) findViewById2, "view.findViewById(R.id.close_bottomsheetfragment)");
        this.f23323b = (ImageView) findViewById2;
        ImageView imageView = this.f23323b;
        if (imageView == null) {
            k.a("closeImageView");
        }
        imageView.setOnClickListener(new a(this));
        if (this.f23324c != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context baseContext = activity.getBaseContext();
            k.a((Object) baseContext, "activity!!.baseContext");
            List<CJRCity> list = this.f23324c;
            if (list == null) {
                k.a();
            }
            i iVar = new i(baseContext, list);
            RecyclerView recyclerView = this.f23322a;
            if (recyclerView == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView.setAdapter(iVar);
            RecyclerView recyclerView2 = this.f23322a;
            if (recyclerView2 == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            RecyclerView recyclerView3 = this.f23322a;
            if (recyclerView3 == null) {
                k.a("metroCityRecyclerview");
            }
            recyclerView3.setHasFixedSize(true);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f23326a;

        a(s sVar) {
            this.f23326a = sVar;
        }

        public final void onClick(View view) {
            this.f23326a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23325d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
