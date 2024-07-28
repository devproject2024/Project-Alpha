package com.travel.citybus.brts.citybus;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.brts.citybus.y;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.brts.CJRBrtsDestination;

public final class u extends net.one97.paytm.i.g implements y.a, z {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f23337a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f23338b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f23339c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f23340d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f23341e;

    /* renamed from: f  reason: collision with root package name */
    private q f23342f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f23343g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f23344h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f23345i;
    private RelativeLayout j;
    private RoboTextView k;
    private RoboTextView l;
    private View m;
    private List<CJRCityAutoSuggest> n;
    /* access modifiers changed from: private */
    public Integer o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public Handler q = new Handler();
    private CJRCityAutoSuggest r;
    private CJRCityAutoSuggest s;
    private ConstraintLayout t;
    private ConstraintLayout u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private TextView y;
    private HashMap z;

    public static void a(ArrayList<CJRBrtsDestination> arrayList) {
        k.c(arrayList, "destination");
    }

    public final void a(String str, String str2) {
        k.c(str, "alertTitle");
        k.c(str2, "alertMessage");
    }

    public static final /* synthetic */ EditText a(u uVar) {
        EditText editText = uVar.f23338b;
        if (editText == null) {
            k.a("sourceEditText");
        }
        return editText;
    }

    public static final /* synthetic */ ImageView b(u uVar) {
        ImageView imageView = uVar.w;
        if (imageView == null) {
            k.a("closeSource");
        }
        return imageView;
    }

    public static final /* synthetic */ EditText c(u uVar) {
        EditText editText = uVar.f23340d;
        if (editText == null) {
            k.a("destinationEditText");
        }
        return editText;
    }

    public static final /* synthetic */ ImageView d(u uVar) {
        ImageView imageView = uVar.x;
        if (imageView == null) {
            k.a("closeDestination");
        }
        return imageView;
    }

    public static final /* synthetic */ q f(u uVar) {
        q qVar = uVar.f23342f;
        if (qVar == null) {
            k.a("cjrBusStopPresenter");
        }
        return qVar;
    }

    public static final /* synthetic */ TextView h(u uVar) {
        TextView textView = uVar.y;
        if (textView == null) {
            k.a("suggestedStopsText");
        }
        return textView;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Integer num;
        String str;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.pre_t_select_busstop_layout, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…layout, container, false)");
        this.m = inflate;
        View view = this.m;
        if (view == null) {
            k.a("fragmentView");
        }
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.metro_searches_recyclerview);
        k.a((Object) findViewById, "view.findViewById(R.id.m…ro_searches_recyclerview)");
        this.f23337a = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.city_search_source);
        k.a((Object) findViewById2, "view.findViewById(R.id.city_search_source)");
        this.f23338b = (EditText) findViewById2;
        View findViewById3 = view.findViewById(R.id.imageView9);
        k.a((Object) findViewById3, "view.findViewById(R.id.imageView9)");
        this.f23339c = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.city_search_destination_cl);
        k.a((Object) findViewById4, "view.findViewById(R.id.city_search_destination_cl)");
        this.t = (ConstraintLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.city_search_cl);
        k.a((Object) findViewById5, "view.findViewById(R.id.city_search_cl)");
        this.u = (ConstraintLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.city_search_destination);
        k.a((Object) findViewById6, "view.findViewById(R.id.city_search_destination)");
        this.f23340d = (EditText) findViewById6;
        View findViewById7 = view.findViewById(R.id.lottie_in_search_recyclerview);
        k.a((Object) findViewById7, "view.findViewById(R.id.l…e_in_search_recyclerview)");
        this.f23343g = (LottieAnimationView) findViewById7;
        View findViewById8 = view.findViewById(R.id.dotted_path_imageview);
        k.a((Object) findViewById8, "view.findViewById(R.id.dotted_path_imageview)");
        this.v = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.lottie_layout);
        k.a((Object) findViewById9, "view.findViewById(R.id.lottie_layout)");
        this.f23344h = (FrameLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.close_select_metro_fragment);
        k.a((Object) findViewById10, "view.findViewById(R.id.c…se_select_metro_fragment)");
        this.f23341e = (ImageView) findViewById10;
        View findViewById11 = view.findViewById(R.id.stations_recyclerview_layout);
        k.a((Object) findViewById11, "view.findViewById(R.id.s…ions_recyclerview_layout)");
        this.f23345i = (RelativeLayout) findViewById11;
        View findViewById12 = view.findViewById(R.id.not_found_layout_in_select_stations);
        k.a((Object) findViewById12, "view.findViewById(R.id.n…ayout_in_select_stations)");
        this.j = (RelativeLayout) findViewById12;
        View findViewById13 = view.findViewById(R.id.header_textview_not_found);
        k.a((Object) findViewById13, "view.findViewById(R.id.header_textview_not_found)");
        this.k = (RoboTextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.extra_textview_not_found);
        k.a((Object) findViewById14, "view.findViewById(R.id.extra_textview_not_found)");
        this.l = (RoboTextView) findViewById14;
        RoboTextView roboTextView = this.k;
        if (roboTextView == null) {
            k.a("headerNotFoundTextView");
        }
        roboTextView.setText(getResources().getString(R.string.no_stations_found_header));
        RoboTextView roboTextView2 = this.l;
        if (roboTextView2 == null) {
            k.a("extraNotFoundTextView");
        }
        roboTextView2.setText(getResources().getString(R.string.no_stations_found));
        View findViewById15 = view.findViewById(R.id.close_source);
        k.a((Object) findViewById15, "view.findViewById(R.id.close_source)");
        this.w = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.close_destination);
        k.a((Object) findViewById16, "view.findViewById(R.id.close_destination)");
        this.x = (ImageView) findViewById16;
        View findViewById17 = view.findViewById(R.id.suggested_stops_textview);
        k.a((Object) findViewById17, "view.findViewById(R.id.suggested_stops_textview)");
        this.y = (TextView) findViewById17;
        ImageView imageView = this.w;
        if (imageView == null) {
            k.a("closeSource");
        }
        imageView.setOnClickListener(new a(this));
        ImageView imageView2 = this.x;
        if (imageView2 == null) {
            k.a("closeDestination");
        }
        imageView2.setOnClickListener(new c(this));
        RecyclerView recyclerView = this.f23337a;
        if (recyclerView == null) {
            k.a("searchedResultRecyclerView");
        }
        recyclerView.setVisibility(4);
        Bundle arguments = getArguments();
        if (arguments != null) {
            h hVar = h.f23284a;
            num = Integer.valueOf(arguments.getInt(h.d()));
        } else {
            num = null;
        }
        this.o = num;
        if (arguments != null) {
            h hVar2 = h.f23284a;
            str = arguments.getString(h.c());
        } else {
            str = null;
        }
        this.p = str;
        this.r = arguments != null ? (CJRCityAutoSuggest) arguments.getParcelable("selected_source_stop") : null;
        this.s = arguments != null ? (CJRCityAutoSuggest) arguments.getParcelable("selected_dest_stop") : null;
        if (this.r != null) {
            EditText editText = this.f23338b;
            if (editText == null) {
                k.a("sourceEditText");
            }
            CJRCityAutoSuggest cJRCityAutoSuggest = this.r;
            if (cJRCityAutoSuggest == null) {
                k.a();
            }
            editText.setText(cJRCityAutoSuggest.getName());
            Integer num2 = this.o;
            h hVar3 = h.f23284a;
            int a2 = h.a();
            if (num2 != null && num2.intValue() == a2) {
                ImageView imageView3 = this.w;
                if (imageView3 == null) {
                    k.a("closeSource");
                }
                imageView3.setVisibility(0);
            }
            ConstraintLayout constraintLayout = this.u;
            if (constraintLayout == null) {
                k.a("sourceLayout");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            constraintLayout.setBackgroundColor(activity.getResources().getColor(R.color.select_bus));
            ConstraintLayout constraintLayout2 = this.t;
            if (constraintLayout2 == null) {
                k.a("destinationLayout");
            }
            constraintLayout2.setVisibility(0);
            ImageView imageView4 = this.f23339c;
            if (imageView4 == null) {
                k.a("imageView9");
            }
            imageView4.setVisibility(0);
            ImageView imageView5 = this.v;
            if (imageView5 == null) {
                k.a("dottedPath");
            }
            imageView5.setVisibility(0);
        }
        if (this.s != null) {
            Integer num3 = this.o;
            h hVar4 = h.f23284a;
            int b2 = h.b();
            if (num3 != null && num3.intValue() == b2) {
                ImageView imageView6 = this.x;
                if (imageView6 == null) {
                    k.a("closeDestination");
                }
                imageView6.setVisibility(0);
            }
            EditText editText2 = this.f23340d;
            if (editText2 == null) {
                k.a("destinationEditText");
            }
            CJRCityAutoSuggest cJRCityAutoSuggest2 = this.s;
            if (cJRCityAutoSuggest2 == null) {
                k.a();
            }
            editText2.setText(cJRCityAutoSuggest2.getName());
        }
        ImageView imageView7 = this.f23341e;
        if (imageView7 == null) {
            k.a("closeFragmentImageView");
        }
        imageView7.setOnClickListener(new d(this));
        this.f23342f = new q(this);
        if (this.p != null) {
            q qVar = this.f23342f;
            if (qVar == null) {
                k.a("cjrBusStopPresenter");
            }
            String str2 = this.p;
            if (str2 == null) {
                k.a();
            }
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            qVar.a((String) null, str2, context);
        }
        EditText editText3 = this.f23338b;
        if (editText3 == null) {
            k.a("sourceEditText");
        }
        editText3.addTextChangedListener(new e(this));
        EditText editText4 = this.f23338b;
        if (editText4 == null) {
            k.a("sourceEditText");
        }
        editText4.setOnTouchListener(new f(this));
        EditText editText5 = this.f23340d;
        if (editText5 == null) {
            k.a("destinationEditText");
        }
        editText5.addTextChangedListener(new g(this));
        EditText editText6 = this.f23340d;
        if (editText6 == null) {
            k.a("destinationEditText");
        }
        editText6.setOnTouchListener(new b(this));
        View view2 = this.m;
        if (view2 == null) {
            k.a("fragmentView");
        }
        return view2;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 16973834);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23346a;

        a(u uVar) {
            this.f23346a = uVar;
        }

        public final void onClick(View view) {
            u.a(this.f23346a).getText().clear();
            u.b(this.f23346a).setVisibility(8);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23348a;

        c(u uVar) {
            this.f23348a = uVar;
        }

        public final void onClick(View view) {
            u.c(this.f23348a).getText().clear();
            u.d(this.f23348a).setVisibility(8);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23349a;

        d(u uVar) {
            this.f23349a = uVar;
        }

        public final void onClick(View view) {
            this.f23349a.dismiss();
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23350a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(u uVar) {
            this.f23350a = uVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f23350a.q.removeCallbacksAndMessages((Object) null);
            if (!(charSequence == null || charSequence.length() == 0)) {
                q f2 = u.f(this.f23350a);
                String obj = charSequence.toString();
                String g2 = this.f23350a.p;
                if (g2 == null) {
                    k.a();
                }
                Context context = this.f23350a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                f2.a(obj, g2, context);
                u.b(this.f23350a).setVisibility(0);
                u.h(this.f23350a).setText(this.f23350a.getString(R.string.suggested_stops));
                return;
            }
            u.h(this.f23350a).setText(this.f23350a.getString(R.string.popular_stops));
            u.b(this.f23350a).setVisibility(8);
        }
    }

    static final class f implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23351a;

        f(u uVar) {
            this.f23351a = uVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            u uVar = this.f23351a;
            h hVar = h.f23284a;
            uVar.o = Integer.valueOf(h.a());
            Editable text = u.a(this.f23351a).getText();
            k.a((Object) text, "sourceEditText.text");
            if (text.length() > 0) {
                u.d(this.f23351a).setVisibility(8);
                u.b(this.f23351a).setVisibility(0);
                u.h(this.f23351a).setText(this.f23351a.getString(R.string.suggested_stops));
            } else {
                u.h(this.f23351a).setText(this.f23351a.getString(R.string.popular_stops));
            }
            return false;
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23352a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        g(u uVar) {
            this.f23352a = uVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f23352a.q.removeCallbacksAndMessages((Object) null);
            if (!(charSequence == null || charSequence.length() == 0)) {
                q f2 = u.f(this.f23352a);
                String obj = charSequence.toString();
                String g2 = this.f23352a.p;
                if (g2 == null) {
                    k.a();
                }
                Context context = this.f23352a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                f2.a(obj, g2, context);
                u.h(this.f23352a).setText(this.f23352a.getString(R.string.suggested_stops));
                u.d(this.f23352a).setVisibility(0);
                return;
            }
            u.h(this.f23352a).setText(this.f23352a.getString(R.string.popular_stops));
            u.d(this.f23352a).setVisibility(8);
        }
    }

    static final class b implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f23347a;

        b(u uVar) {
            this.f23347a = uVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            u uVar = this.f23347a;
            h hVar = h.f23284a;
            uVar.o = Integer.valueOf(h.b());
            Editable text = u.c(this.f23347a).getText();
            k.a((Object) text, "destinationEditText.text");
            if (text.length() > 0) {
                u.d(this.f23347a).setVisibility(0);
                u.b(this.f23347a).setVisibility(8);
                u.h(this.f23347a).setText(this.f23347a.getString(R.string.suggested_stops));
            } else {
                u.h(this.f23347a).setText(this.f23347a.getString(R.string.popular_stops));
            }
            return false;
        }
    }

    public final void a(List<CJRCityAutoSuggest> list) {
        k.c(list, "busStopList");
        Integer num = this.o;
        if (num != null) {
            num.intValue();
            if (list.isEmpty() || !isVisible()) {
                a();
                return;
            }
            TextView textView = this.y;
            if (textView == null) {
                k.a("suggestedStopsText");
            }
            textView.setVisibility(0);
            RelativeLayout relativeLayout = this.f23345i;
            if (relativeLayout == null) {
                k.a("busStopRecyclerviewLayout");
            }
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.j;
            if (relativeLayout2 == null) {
                k.a("notFoundLayout");
            }
            relativeLayout2.setVisibility(4);
            this.n = list;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Context baseContext = activity.getBaseContext();
            k.a((Object) baseContext, "activity!!.baseContext");
            o oVar = new o(baseContext, list, this);
            RecyclerView recyclerView = this.f23337a;
            if (recyclerView == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView.setAdapter(oVar);
            RecyclerView recyclerView2 = this.f23337a;
            if (recyclerView2 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView2.setNestedScrollingEnabled(false);
            RecyclerView recyclerView3 = this.f23337a;
            if (recyclerView3 == null) {
                k.a("searchedResultRecyclerView");
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            recyclerView3.setLayoutManager(new LinearLayoutManager(activity2.getBaseContext(), 1, false));
            RecyclerView recyclerView4 = this.f23337a;
            if (recyclerView4 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView4.setHasFixedSize(true);
            RecyclerView recyclerView5 = this.f23337a;
            if (recyclerView5 == null) {
                k.a("searchedResultRecyclerView");
            }
            recyclerView5.setVisibility(0);
        }
    }

    public final void a() {
        TextView textView = this.y;
        if (textView == null) {
            k.a("suggestedStopsText");
        }
        textView.setVisibility(8);
        RelativeLayout relativeLayout = this.f23345i;
        if (relativeLayout == null) {
            k.a("busStopRecyclerviewLayout");
        }
        relativeLayout.setVisibility(4);
        RelativeLayout relativeLayout2 = this.j;
        if (relativeLayout2 == null) {
            k.a("notFoundLayout");
        }
        relativeLayout2.setVisibility(0);
    }

    public final void a(boolean z2) {
        if (z2) {
            FrameLayout frameLayout = this.f23344h;
            if (frameLayout == null) {
                k.a("lottieLayout");
            }
            frameLayout.setVisibility(0);
            return;
        }
        FrameLayout frameLayout2 = this.f23344h;
        if (frameLayout2 == null) {
            k.a("lottieLayout");
        }
        frameLayout2.setVisibility(4);
    }

    public final void a(CJRCityAutoSuggest cJRCityAutoSuggest) {
        k.c(cJRCityAutoSuggest, "station");
        dismiss();
        Integer num = this.o;
        h hVar = h.f23284a;
        int a2 = h.a();
        if (num != null && num.intValue() == a2) {
            com.travel.citybus.brts.utils.e eVar = com.travel.citybus.brts.utils.e.f23402a;
            h hVar2 = h.f23284a;
            com.travel.citybus.brts.utils.e.a((Object) new k(h.a(), cJRCityAutoSuggest));
            return;
        }
        com.travel.citybus.brts.utils.e eVar2 = com.travel.citybus.brts.utils.e.f23402a;
        h hVar3 = h.f23284a;
        com.travel.citybus.brts.utils.e.a((Object) new k(h.b(), cJRCityAutoSuggest));
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
