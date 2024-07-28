package com.travel.bus.busticket.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.travel.bus.busticket.a.u;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.i.f;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRBusSearchAmenitiesInfo> f22209a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f22210b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public BottomSheetBehavior f22211c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Integer> f22212d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f22213e;

    /* renamed from: f  reason: collision with root package name */
    private u f22214f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f22215g;

    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                a.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f22211c = BottomSheetBehavior.from(frameLayout);
        }
        this.f22211c.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    a.this.f22211c.setState(3);
                }
                if (i2 == 5 && a.this.getDialog() != null) {
                    a.this.getDialog().dismiss();
                }
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.travel.bus.R.layout.pre_b_lyt_amenities_bottom_sheet, viewGroup, false);
        this.f22210b = (RecyclerView) inflate.findViewById(com.travel.bus.R.id.amenities_grid_list);
        this.f22215g = (ImageView) inflate.findViewById(com.travel.bus.R.id.close_dialog);
        this.f22215g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("keyList")) {
            this.f22212d = (ArrayList) getArguments().getSerializable("keyList");
        }
        if (getArguments() != null && getArguments().containsKey("amenity_info")) {
            this.f22213e = (HashMap) getArguments().getSerializable("amenity_info");
        }
        ArrayList<Integer> arrayList = this.f22212d;
        if (!(arrayList == null || this.f22213e == null)) {
            Iterator<Integer> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f22209a.add(this.f22213e.get(String.valueOf(it2.next().intValue())));
            }
        }
        this.f22210b.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Context context = getContext();
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList2 = this.f22209a;
        this.f22214f = new u(context, arrayList2, arrayList2, "bottomDialog");
        this.f22210b.setAdapter(this.f22214f);
        this.f22214f.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (getDialog() != null) {
            getDialog().dismiss();
        }
    }
}
