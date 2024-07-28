package com.travel.citybus.brts.citybus;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.model.pojo.CJRBusStopModel;
import com.travel.citybus.brts.utils.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.g;

public final class t extends g {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f23327a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f23328b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f23329c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f23330d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f23331e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f23332f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f23333g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRBusStopModel> f23334h;

    /* renamed from: i  reason: collision with root package name */
    private Double f23335i = Double.valueOf(0.0d);
    private String j;
    private String k;
    private Integer l;
    private String m;
    private HashMap n;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Double d2;
        String str;
        String str2;
        Integer num;
        String str3;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.stop_details_fragment_layout, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.stop_recyclerview);
        k.a((Object) findViewById, "view.findViewById(R.id.stop_recyclerview)");
        this.f23327a = (RecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.cross_button);
        k.a((Object) findViewById2, "view.findViewById(R.id.cross_button)");
        this.f23328b = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.price_textview);
        k.a((Object) findViewById3, "view.findViewById(R.id.price_textview)");
        this.f23329c = (RoboTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.bus_name_textview);
        k.a((Object) findViewById4, "view.findViewById(R.id.bus_name_textview)");
        this.f23330d = (RoboTextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.bus_desc_textview);
        k.a((Object) findViewById5, "view.findViewById(R.id.bus_desc_textview)");
        this.f23331e = (RoboTextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.stops_count_textview);
        k.a((Object) findViewById6, "view.findViewById(R.id.stops_count_textview)");
        this.f23332f = (RoboTextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.bus_logo);
        k.a((Object) findViewById7, "view.findViewById(R.id.bus_logo)");
        this.f23333g = (ImageView) findViewById7;
        Bundle arguments = getArguments();
        ArrayList<CJRBusStopModel> arrayList = null;
        if (arguments != null) {
            h hVar = h.f23284a;
            d2 = Double.valueOf(arguments.getDouble(h.h(), 0.0d));
        } else {
            d2 = null;
        }
        this.f23335i = d2;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            h hVar2 = h.f23284a;
            str = arguments2.getString(h.i());
        } else {
            str = null;
        }
        this.j = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            h hVar3 = h.f23284a;
            str2 = arguments3.getString(h.j());
        } else {
            str2 = null;
        }
        this.k = str2;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            h hVar4 = h.f23284a;
            num = Integer.valueOf(arguments4.getInt(h.k()));
        } else {
            num = null;
        }
        this.l = num;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            h hVar5 = h.f23284a;
            str3 = arguments5.getString(h.l());
        } else {
            str3 = null;
        }
        this.m = str3;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            h hVar6 = h.f23284a;
            arrayList = arguments6.getParcelableArrayList(h.g());
        }
        if (arrayList != null) {
            this.f23334h = arrayList;
            if (this.f23335i != null) {
                RoboTextView roboTextView = this.f23329c;
                if (roboTextView == null) {
                    k.a("priceTextView");
                }
                roboTextView.setText(com.travel.citybus.brts.utils.a.a(this.f23335i));
            } else {
                RoboTextView roboTextView2 = this.f23329c;
                if (roboTextView2 == null) {
                    k.a("priceTextView");
                }
                roboTextView2.setVisibility(4);
            }
            if (this.j != null) {
                RoboTextView roboTextView3 = this.f23330d;
                if (roboTextView3 == null) {
                    k.a("busNameTextView");
                }
                roboTextView3.setText("Route " + this.j);
            } else {
                RoboTextView roboTextView4 = this.f23330d;
                if (roboTextView4 == null) {
                    k.a("busNameTextView");
                }
                roboTextView4.setVisibility(4);
            }
            if (this.k != null) {
                RoboTextView roboTextView5 = this.f23331e;
                if (roboTextView5 == null) {
                    k.a("busTypeTextView");
                }
                roboTextView5.setText(this.k);
            } else {
                RoboTextView roboTextView6 = this.f23331e;
                if (roboTextView6 == null) {
                    k.a("busTypeTextView");
                }
                roboTextView6.setVisibility(4);
            }
            if (this.l != null) {
                RoboTextView roboTextView7 = this.f23332f;
                if (roboTextView7 == null) {
                    k.a("busNoOfStopsTextView");
                }
                Integer num2 = this.l;
                if (num2 == null) {
                    k.a();
                }
                roboTextView7.setText(f.a(num2.intValue()));
            } else {
                RoboTextView roboTextView8 = this.f23332f;
                if (roboTextView8 == null) {
                    k.a("busNoOfStopsTextView");
                }
                roboTextView8.setVisibility(4);
            }
            if (this.m != null) {
                com.paytm.utility.t.a(false);
                getContext();
                String str4 = this.m;
                ImageView imageView = this.f23333g;
                if (imageView == null) {
                    k.a("marchantLogo");
                }
                com.paytm.utility.t.b(str4, imageView);
            }
            ArrayList<CJRBusStopModel> arrayList2 = this.f23334h;
            if (arrayList2 != null) {
                if (arrayList2 == null) {
                    k.a();
                }
                a(arrayList2);
            }
            ImageView imageView2 = this.f23328b;
            if (imageView2 == null) {
                k.a("cross");
            }
            imageView2.setOnClickListener(new a(this));
            return inflate;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<com.travel.citybus.brts.model.pojo.CJRBusStopModel> /* = java.util.ArrayList<com.travel.citybus.brts.model.pojo.CJRBusStopModel> */");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f23336a;

        a(t tVar) {
            this.f23336a = tVar;
        }

        public final void onClick(View view) {
            Dialog dialog = this.f23336a.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    private final void a(List<CJRBusStopModel> list) {
        int size;
        List arrayList = new ArrayList();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            arrayList.add(new p(com.travel.citybus.brts.a.f23175c, new b(list.get(0).getName())));
            if (list.size() > 2 && (size = list.size() - 2) > 0) {
                int i2 = 1;
                while (true) {
                    arrayList.add(new p(com.travel.citybus.brts.a.f23174b, new n(list.get(i2).getName())));
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
            if (list.size() > 1) {
                arrayList.add(new p(com.travel.citybus.brts.a.f23176d, new b(list.get(list.size() - 1).getName())));
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context baseContext = activity.getBaseContext();
        k.a((Object) baseContext, "activity!!.baseContext");
        l lVar = new l(baseContext, arrayList);
        RecyclerView recyclerView = this.f23327a;
        if (recyclerView == null) {
            k.a("stopsRecyclerView");
        }
        recyclerView.setAdapter(lVar);
        RecyclerView recyclerView2 = this.f23327a;
        if (recyclerView2 == null) {
            k.a("stopsRecyclerView");
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        k.a((Object) activity2, "activity!!");
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity2.getBaseContext()));
        RecyclerView recyclerView3 = this.f23327a;
        if (recyclerView3 == null) {
            k.a("stopsRecyclerView");
        }
        recyclerView3.setHasFixedSize(true);
    }

    public final void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, getResources().getDimensionPixelSize(R.dimen.intermediate_dialog_height));
        }
    }

    public final int getTheme() {
        return R.style.CustomDialogFragment;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(requireContext(), getTheme());
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
