package com.travel.train.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.b.q;
import com.travel.train.c.c;
import com.travel.train.i.h;
import com.travel.train.j.o;
import com.travel.train.j.v;
import com.travel.train.model.metro.CJRClearRecentDataModel;
import com.travel.train.model.metro.CJRMetroSelectedModelForBus;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import com.travel.train.model.metro.CJRRecentTagModel;
import com.travel.train.model.metro.CJRSelectStationModel;
import com.travel.train.model.metro.CJRStationAutoSuggestModel;
import com.travel.train.model.metro.CJRStationTagModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.i.g;

public final class i extends g implements c.a, h, com.travel.train.i.i {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f27012a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f27013b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f27014c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f27015d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.train.f.d f27016e;

    /* renamed from: f  reason: collision with root package name */
    private LottieAnimationView f27017f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f27018g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f27019h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f27020i;
    private RoboTextView j;
    private RoboTextView k;
    /* access modifiers changed from: private */
    public List<CJRParcelableMetroStationModel> l;
    /* access modifiers changed from: private */
    public List<? extends CJRStationAutoSuggestModel> m;
    private Integer n;
    /* access modifiers changed from: private */
    public String o;
    private boolean p;
    private HashMap q;

    static final class d<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f27025a = new d();

        d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "alertTitle");
        k.c(str2, "alertMessage");
    }

    static final class c<T> implements io.reactivex.rxjava3.d.g<CJRClearRecentDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f27024a;

        c(i iVar) {
            this.f27024a = iVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            if (((CJRClearRecentDataModel) obj).type) {
                v vVar = v.f27608a;
                FragmentActivity activity = this.f27024a.getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                Context baseContext = activity.getBaseContext();
                k.a((Object) baseContext, "activity!!.baseContext");
                v.b(baseContext);
            }
            List a2 = this.f27024a.l;
            if (a2 != null) {
                a2.clear();
            }
            if (this.f27024a.m != null) {
                i iVar = this.f27024a;
                List b2 = iVar.m;
                if (b2 == null) {
                    k.a();
                }
                iVar.c((List<? extends CJRStationAutoSuggestModel>) b2);
            }
        }
    }

    public static final /* synthetic */ com.travel.train.f.d d(i iVar) {
        com.travel.train.f.d dVar = iVar.f27016e;
        if (dVar == null) {
            k.a("cjrSelectMetroStationPresenter");
        }
        return dVar;
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_select_metro_station_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.metro_searches_recyclerview);
        k.a((Object) findViewById, "view.findViewById(R.id.m…ro_searches_recyclerview)");
        this.f27013b = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.station_edittext);
        k.a((Object) findViewById2, "view.findViewById(R.id.station_edittext)");
        this.f27014c = (EditText) findViewById2;
        View findViewById3 = view.findViewById(R.id.lottie_in_search_recyclerview);
        k.a((Object) findViewById3, "view.findViewById(R.id.l…e_in_search_recyclerview)");
        this.f27017f = (LottieAnimationView) findViewById3;
        View findViewById4 = view.findViewById(R.id.lottie_layout);
        k.a((Object) findViewById4, "view.findViewById(R.id.lottie_layout)");
        this.f27018g = (FrameLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.close_select_metro_fragment);
        k.a((Object) findViewById5, "view.findViewById(R.id.c…se_select_metro_fragment)");
        this.f27015d = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.stations_recyclerview_layout);
        k.a((Object) findViewById6, "view.findViewById(R.id.s…ions_recyclerview_layout)");
        this.f27019h = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.not_found_layout_in_select_stations);
        k.a((Object) findViewById7, "view.findViewById(R.id.n…ayout_in_select_stations)");
        this.f27020i = (RelativeLayout) findViewById7;
        View findViewById8 = view.findViewById(R.id.header_textview_not_found);
        k.a((Object) findViewById8, "view.findViewById(R.id.header_textview_not_found)");
        this.j = (RoboTextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.extra_textview_not_found);
        k.a((Object) findViewById9, "view.findViewById(R.id.extra_textview_not_found)");
        this.k = (RoboTextView) findViewById9;
        RoboTextView roboTextView = this.j;
        if (roboTextView == null) {
            k.a("headerNotFoundTextView");
        }
        roboTextView.setText(getResources().getString(R.string.no_stations_found_header));
        RoboTextView roboTextView2 = this.k;
        if (roboTextView2 == null) {
            k.a("extraNotFoundTextView");
        }
        roboTextView2.setText(getResources().getString(R.string.no_stations_found));
        RecyclerView recyclerView = this.f27013b;
        if (recyclerView == null) {
            k.a("searchedResultRecyclerView");
        }
        recyclerView.setVisibility(4);
        Bundle arguments = getArguments();
        this.n = arguments != null ? Integer.valueOf(arguments.getInt(com.travel.train.j.g.y)) : null;
        this.o = arguments != null ? arguments.getString(com.travel.train.j.g.z) : null;
        Integer num = this.n;
        if (num != null) {
            num.intValue();
            Integer num2 = this.n;
            int i2 = com.travel.train.j.g.F;
            if (num2 != null && num2.intValue() == i2) {
                EditText editText = this.f27014c;
                if (editText == null) {
                    k.a("stationEditText");
                }
                FragmentActivity activity = getActivity();
                editText.setHint(activity != null ? activity.getString(R.string.source_metro_station) : null);
            } else {
                EditText editText2 = this.f27014c;
                if (editText2 == null) {
                    k.a("stationEditText");
                }
                FragmentActivity activity2 = getActivity();
                editText2.setHint(activity2 != null ? activity2.getString(R.string.destination_metro_station) : null);
            }
        }
        ImageView imageView = this.f27015d;
        if (imageView == null) {
            k.a("closeFragmentImageView");
        }
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        ImageView imageView2 = this.f27015d;
        if (imageView2 == null) {
            k.a("closeFragmentImageView");
        }
        imageView2.setOnClickListener(new b(this));
        this.f27016e = new com.travel.train.f.d(this);
        com.travel.train.f.d dVar = this.f27016e;
        if (dVar == null) {
            k.a("cjrSelectMetroStationPresenter");
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        k.c(context, "context");
        v vVar = v.f27608a;
        ArrayList<CJRParcelableMetroStationModel> a2 = v.a(context);
        Collection collection = a2;
        if (!(collection == null || collection.isEmpty())) {
            dVar.f26670a.a((List<? extends CJRParcelableMetroStationModel>) a2);
        }
        if (this.o != null) {
            com.travel.train.f.d dVar2 = this.f27016e;
            if (dVar2 == null) {
                k.a("cjrSelectMetroStationPresenter");
            }
            String str = this.o;
            if (str == null) {
                k.a();
            }
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            dVar2.a((String) null, str, context2);
        }
        com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRClearRecentDataModel.class).subscribe(new c(this), d.f27025a);
        EditText editText3 = this.f27014c;
        if (editText3 == null) {
            k.a("stationEditText");
        }
        editText3.addTextChangedListener(new e(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f27023a;

        b(i iVar) {
            this.f27023a = iVar;
        }

        public final void onClick(View view) {
            this.f27023a.dismiss();
            FragmentActivity activity = this.f27023a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f27026a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(i iVar) {
            this.f27026a = iVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f27026a.f27012a.removeCallbacksAndMessages((Object) null);
            if (charSequence == null || charSequence.length() == 0) {
                com.travel.train.f.d d2 = i.d(this.f27026a);
                String e2 = this.f27026a.o;
                if (e2 == null) {
                    k.a();
                }
                Context context = this.f27026a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                d2.a((String) null, e2, context);
            } else if (charSequence.length() > 0) {
                i iVar = this.f27026a;
                k.c(charSequence, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
                iVar.f27012a.post(new a(iVar, charSequence));
            }
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f27021a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CharSequence f27022b;

        a(i iVar, CharSequence charSequence) {
            this.f27021a = iVar;
            this.f27022b = charSequence;
        }

        public final void run() {
            if (this.f27021a.o != null) {
                com.travel.train.f.d d2 = i.d(this.f27021a);
                String obj = this.f27022b.toString();
                String e2 = this.f27021a.o;
                if (e2 == null) {
                    k.a();
                }
                Context context = this.f27021a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                d2.a(obj, e2, context);
            }
        }
    }

    public final void a(List<? extends CJRParcelableMetroStationModel> list) {
        k.c(list, "recentSearchList");
        Collection collection = list;
        if (!collection.isEmpty()) {
            this.l = kotlin.a.k.c(collection);
            List<CJRParcelableMetroStationModel> list2 = this.l;
            if (list2 == null) {
                k.a();
            }
            k.c(list2, "recentSearchList");
            List arrayList = new ArrayList();
            if (!list2.isEmpty()) {
                int i2 = com.travel.train.j.g.N;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                String string = context.getString(R.string.metro_recent_search);
                k.a((Object) string, "context!!.getString(R.string.metro_recent_search)");
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                String string2 = context2.getString(R.string.clear_tag);
                k.a((Object) string2, "context!!.getString(R.string.clear_tag)");
                arrayList.add(new CJRSelectStationModel(i2, new CJRRecentTagModel(string, string2)));
                List<CJRParcelableMetroStationModel> list3 = this.l;
                if (list3 == null) {
                    k.a();
                }
                for (CJRParcelableMetroStationModel cJRSelectStationModel : list3) {
                    arrayList.add(new CJRSelectStationModel(com.travel.train.j.g.O, cJRSelectStationModel));
                }
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context baseContext = activity.getBaseContext();
            k.a((Object) baseContext, "activity!!.baseContext");
            h hVar = this;
            com.travel.train.i.i iVar = this;
            Integer num = this.n;
            if (num == null) {
                k.a();
            }
            q qVar = new q(baseContext, arrayList, hVar, iVar, num.intValue(), o.b((Activity) getActivity()).f27694a);
            RecyclerView recyclerView = this.f27013b;
            if (recyclerView == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView.setAdapter(qVar);
            RecyclerView recyclerView2 = this.f27013b;
            if (recyclerView2 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView2.setNestedScrollingEnabled(false);
            RecyclerView recyclerView3 = this.f27013b;
            if (recyclerView3 == null) {
                k.a("searchedResultRecyclerView");
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            recyclerView3.setLayoutManager(new LinearLayoutManager(activity2.getBaseContext(), 1, false));
            RecyclerView recyclerView4 = this.f27013b;
            if (recyclerView4 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView4.setHasFixedSize(true);
            RecyclerView recyclerView5 = this.f27013b;
            if (recyclerView5 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView5.setVisibility(0);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        k.a((Object) onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (!(window == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.DialogFragmentAnimation;
        }
        onCreateDialog.requestWindowFeature(1);
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            window2.setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        }
        return onCreateDialog;
    }

    public final void b(List<? extends CJRStationAutoSuggestModel> list) {
        k.c(list, "suggestedStationList");
        Integer num = this.n;
        if (num != null) {
            num.intValue();
            if (this.p) {
                List arrayList = new ArrayList();
                if (!list.isEmpty()) {
                    RelativeLayout relativeLayout = this.f27019h;
                    if (relativeLayout == null) {
                        k.a("stationRecyclerviewLayout");
                    }
                    relativeLayout.setVisibility(0);
                    RelativeLayout relativeLayout2 = this.f27020i;
                    if (relativeLayout2 == null) {
                        k.a("notFoundLayout");
                    }
                    relativeLayout2.setVisibility(4);
                    this.m = list;
                    int i2 = com.travel.train.j.g.M;
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    String string = context.getString(R.string.station);
                    k.a((Object) string, "context!!.getString(R.string.station)");
                    arrayList.add(new CJRSelectStationModel(i2, string));
                    for (CJRStationAutoSuggestModel cJRSelectStationModel : list) {
                        arrayList.add(new CJRSelectStationModel(com.travel.train.j.g.P, cJRSelectStationModel));
                    }
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    Context baseContext = activity.getBaseContext();
                    k.a((Object) baseContext, "activity!!.baseContext");
                    h hVar = this;
                    com.travel.train.i.i iVar = this;
                    Integer num2 = this.n;
                    if (num2 == null) {
                        k.a();
                    }
                    q qVar = new q(baseContext, arrayList, hVar, iVar, num2.intValue(), o.b((Activity) getActivity()).f27694a);
                    RecyclerView recyclerView = this.f27013b;
                    if (recyclerView == null) {
                        k.a("searchedResultRecyclerView");
                    }
                    recyclerView.setAdapter(qVar);
                    RecyclerView recyclerView2 = this.f27013b;
                    if (recyclerView2 == null) {
                        k.a("searchedResultRecyclerView");
                    }
                    recyclerView2.setNestedScrollingEnabled(false);
                    RecyclerView recyclerView3 = this.f27013b;
                    if (recyclerView3 == null) {
                        k.a("searchedResultRecyclerView");
                    }
                    FragmentActivity activity2 = getActivity();
                    if (activity2 == null) {
                        k.a();
                    }
                    k.a((Object) activity2, "activity!!");
                    recyclerView3.setLayoutManager(new LinearLayoutManager(activity2.getBaseContext(), 1, false));
                    RecyclerView recyclerView4 = this.f27013b;
                    if (recyclerView4 == null) {
                        k.a("searchedResultRecyclerView");
                    }
                    recyclerView4.setHasFixedSize(true);
                    RecyclerView recyclerView5 = this.f27013b;
                    if (recyclerView5 == null) {
                        k.a("searchedResultRecyclerView");
                    }
                    recyclerView5.setVisibility(0);
                    return;
                }
                a();
            }
        }
    }

    public final void a() {
        RelativeLayout relativeLayout = this.f27019h;
        if (relativeLayout == null) {
            k.a("stationRecyclerviewLayout");
        }
        relativeLayout.setVisibility(4);
        RelativeLayout relativeLayout2 = this.f27020i;
        if (relativeLayout2 == null) {
            k.a("notFoundLayout");
        }
        relativeLayout2.setVisibility(0);
    }

    public final void c(List<? extends CJRStationAutoSuggestModel> list) {
        k.c(list, "suggestedStationList");
        RelativeLayout relativeLayout = this.f27019h;
        if (relativeLayout == null) {
            k.a("stationRecyclerviewLayout");
        }
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.f27020i;
        if (relativeLayout2 == null) {
            k.a("notFoundLayout");
        }
        relativeLayout2.setVisibility(4);
        Integer num = this.n;
        if (num != null) {
            num.intValue();
            if (this.p) {
                List arrayList = new ArrayList();
                Collection collection = this.l;
                if (!(collection == null || collection.isEmpty())) {
                    int i2 = com.travel.train.j.g.N;
                    Context context = getContext();
                    if (context == null) {
                        k.a();
                    }
                    String string = context.getString(R.string.metro_recent_search);
                    k.a((Object) string, "context!!.getString(R.string.metro_recent_search)");
                    Context context2 = getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    String string2 = context2.getString(R.string.clear_tag);
                    k.a((Object) string2, "context!!.getString(R.string.clear_tag)");
                    arrayList.add(new CJRSelectStationModel(i2, new CJRRecentTagModel(string, string2)));
                    List<CJRParcelableMetroStationModel> list2 = this.l;
                    if (list2 == null) {
                        k.a();
                    }
                    for (CJRParcelableMetroStationModel cJRSelectStationModel : list2) {
                        arrayList.add(new CJRSelectStationModel(com.travel.train.j.g.O, cJRSelectStationModel));
                    }
                }
                if (!list.isEmpty()) {
                    this.m = list;
                    int i3 = com.travel.train.j.g.M;
                    Context context3 = getContext();
                    if (context3 == null) {
                        k.a();
                    }
                    String string3 = context3.getString(R.string.station);
                    k.a((Object) string3, "context!!.getString(R.string.station)");
                    arrayList.add(new CJRSelectStationModel(i3, new CJRStationTagModel(string3)));
                    for (CJRStationAutoSuggestModel cJRSelectStationModel2 : list) {
                        arrayList.add(new CJRSelectStationModel(com.travel.train.j.g.P, cJRSelectStationModel2));
                    }
                }
                if (arrayList.size() == 0) {
                    EditText editText = this.f27014c;
                    if (editText == null) {
                        k.a("stationEditText");
                    }
                    String obj = editText.getText().toString();
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    o.a("metro_home", obj, "no_station_found", "/trains/metro", activity.getApplicationContext());
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                Context baseContext = activity2.getBaseContext();
                k.a((Object) baseContext, "activity!!.baseContext");
                h hVar = this;
                com.travel.train.i.i iVar = this;
                Integer num2 = this.n;
                if (num2 == null) {
                    k.a();
                }
                q qVar = new q(baseContext, arrayList, hVar, iVar, num2.intValue(), o.b((Activity) getActivity()).f27694a);
                RecyclerView recyclerView = this.f27013b;
                if (recyclerView == null) {
                    k.a("searchedResultRecyclerView");
                }
                recyclerView.setAdapter(qVar);
                RecyclerView recyclerView2 = this.f27013b;
                if (recyclerView2 == null) {
                    k.a("searchedResultRecyclerView");
                }
                recyclerView2.setNestedScrollingEnabled(false);
                RecyclerView recyclerView3 = this.f27013b;
                if (recyclerView3 == null) {
                    k.a("searchedResultRecyclerView");
                }
                FragmentActivity activity3 = getActivity();
                if (activity3 == null) {
                    k.a();
                }
                k.a((Object) activity3, "activity!!");
                recyclerView3.setLayoutManager(new LinearLayoutManager(activity3.getBaseContext(), 1, false));
                RecyclerView recyclerView4 = this.f27013b;
                if (recyclerView4 == null) {
                    k.a("searchedResultRecyclerView");
                }
                recyclerView4.setHasFixedSize(true);
                RecyclerView recyclerView5 = this.f27013b;
                if (recyclerView5 == null) {
                    k.a("searchedResultRecyclerView");
                }
                recyclerView5.setVisibility(0);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.FullScreenDialogStyleMetro);
    }

    public final void a(int i2, CJRStationAutoSuggestModel cJRStationAutoSuggestModel) {
        k.c(cJRStationAutoSuggestModel, "station");
        dismiss();
        if (i2 == com.travel.train.j.g.F) {
            String str = cJRStationAutoSuggestModel.name;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            o.a("metro_home", str, "source_selected", "/trains/metro", activity.getApplicationContext());
            com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) new CJRMetroSelectedModelForBus(com.travel.train.j.g.F, cJRStationAutoSuggestModel));
        } else {
            String str2 = cJRStationAutoSuggestModel.name;
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            o.a("metro_home", str2, "destination_selected", "/trains/metro", activity2.getApplicationContext());
            com.travel.train.g.a aVar2 = com.travel.train.g.a.f27250a;
            com.travel.train.g.a.a((Object) new CJRMetroSelectedModelForBus(com.travel.train.j.g.G, cJRStationAutoSuggestModel));
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    public final void a(CJRParcelableMetroStationModel cJRParcelableMetroStationModel) {
        k.c(cJRParcelableMetroStationModel, "pair");
        dismiss();
        com.travel.train.g.a aVar = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a((Object) cJRParcelableMetroStationModel);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        String str = cJRParcelableMetroStationModel.sourceStation + "_to_" + cJRParcelableMetroStationModel.destinationStation;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            k.a();
        }
        k.a((Object) activity2, "activity!!");
        o.a("metro_home", str, "recent_search_selected", "/trains/metro", activity2.getApplicationContext());
    }

    public final void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        this.p = true;
    }

    public final void onPause() {
        super.onPause();
        this.p = false;
    }

    public final void a(boolean z) {
        if (z) {
            FrameLayout frameLayout = this.f27018g;
            if (frameLayout == null) {
                k.a("lottieLayout");
            }
            frameLayout.setVisibility(0);
            return;
        }
        FrameLayout frameLayout2 = this.f27018g;
        if (frameLayout2 == null) {
            k.a("lottieLayout");
        }
        frameLayout2.setVisibility(4);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
