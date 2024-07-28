package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.i.u;
import com.travel.train.j.n;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRNearByStation;
import com.travel.train.model.trainticket.CJRNearByStationResult;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.x;
import kotlin.s;

public final class ad extends am {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26774b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    boolean f26775a;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f26776c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f26777d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f26778e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f26779f;

    /* renamed from: g  reason: collision with root package name */
    private Button f26780g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f26781h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f26782i;
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public CJRTrainSearchResults k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public u m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public CJRNearByStationResult o;
    private com.travel.train.k.c p;
    /* access modifiers changed from: private */
    public CJRTrainSearchInput q;
    private HashMap r;

    private View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<CJRNearByStationResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26784a;

        c(ad adVar) {
            this.f26784a = adVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f26784a.o = (CJRNearByStationResult) obj;
            if (this.f26784a.n) {
                ad adVar = this.f26784a;
                ad.b(adVar, adVar.o);
            }
        }
    }

    static final class d<T> implements z<s<? extends CJRTrainSearchResults, ? extends CJRTrainSearchInput, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26785a;

        d(ad adVar) {
            this.f26785a = adVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            s sVar = (s) obj;
            this.f26785a.k = (CJRTrainSearchResults) sVar.getFirst();
            this.f26785a.q = (CJRTrainSearchInput) sVar.getSecond();
            if (sVar.getThird() != null) {
                ad adVar = this.f26785a;
                Object third = sVar.getThird();
                if (third == null) {
                    k.a();
                }
                adVar.l = ((Number) third).intValue();
            }
            ad adVar2 = this.f26785a;
            CJRTrainSearchInput e2 = adVar2.q;
            this.f26785a.getActivity();
            String c2 = n.c(e2);
            k.a((Object) c2, "CJRTrainSearchResultsUti…ainSearchInput, activity)");
            adVar2.j = c2;
            ad.f(this.f26785a);
            this.f26785a.n = true;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (getParentFragment() != null && (getParentFragment() instanceof u)) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.m = (u) parentFragment;
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type com.travel.train.trainlistener.IJRTrainSRPListener");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pre_t_no_result_found_train_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        View view2 = view;
        k.c(view2, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            g.a aVar = new g.a(g.b.BOOKING);
            a.C0484a aVar2 = com.travel.train.a.a.f25797a;
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            k.a((Object) activity2, "activity!!");
            g.a a2 = aVar.a(aVar2.a(new com.travel.train.a.a.a(activity2)));
            a2.f27667b = true;
            this.p = (com.travel.train.k.c) am.a(activity, (al.b) new com.travel.train.k.g(a2)).a(com.travel.train.k.c.class);
        }
        this.f26776c = (ImageView) view2.findViewById(R.id.no_train_image);
        this.f26777d = (TextView) view2.findViewById(R.id.no_result_label);
        this.f26778e = (TextView) view2.findViewById(R.id.no_trains_text);
        this.f26779f = (TextView) view2.findViewById(R.id.no_trains_text1);
        this.f26780g = (Button) view2.findViewById(R.id.modify_search_btn);
        this.f26781h = (LinearLayout) view2.findViewById(R.id.alternate_dates_container);
        this.f26782i = (LinearLayout) view2.findViewById(R.id.nearby_station_container);
        Button button = this.f26780g;
        if (button != null) {
            button.setOnClickListener(new b(this));
        }
        com.travel.train.k.c cVar = this.p;
        if (cVar != null) {
            if (!(cVar == null || (liveData2 = cVar.l) == null)) {
                liveData2.observe(this, new c(this));
            }
            com.travel.train.k.c cVar2 = this.p;
            if (cVar2 == null) {
                k.a();
            }
            LiveData liveData3 = cVar2.f27633d;
            com.travel.train.k.c cVar3 = this.p;
            if (cVar3 == null) {
                k.a();
            }
            LiveData liveData4 = cVar3.f27631b;
            com.travel.train.k.c cVar4 = this.p;
            if (cVar4 == null) {
                k.a();
            }
            LiveData liveData5 = cVar4.f27632c;
            k.c(liveData3, "a");
            k.c(liveData4, "b");
            k.c(liveData5, "c");
            w wVar = new w();
            x.e eVar = new x.e();
            eVar.element = null;
            x.e eVar2 = new x.e();
            eVar2.element = null;
            x.e eVar3 = new x.e();
            eVar3.element = null;
            x.a aVar3 = new x.a();
            aVar3.element = false;
            x.a aVar4 = new x.a();
            aVar4.element = false;
            x.a aVar5 = new x.a();
            aVar5.element = false;
            g gVar = r5;
            x.a aVar6 = aVar5;
            LiveData liveData6 = liveData5;
            g gVar2 = new g(wVar, eVar, eVar2, eVar3, aVar3, aVar4, aVar6);
            wVar.addSource(liveData3, new h(eVar, aVar3, gVar));
            wVar.addSource(liveData4, new i(eVar2, aVar4, gVar));
            wVar.addSource(liveData6, new j(eVar3, aVar6, gVar));
            q qVar = this;
            wVar.observe(qVar, new d(this));
            com.travel.train.k.c cVar5 = this.p;
            if (cVar5 != null && (liveData = cVar5.f27637h) != null) {
                liveData.observe(qVar, new e(this));
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26783a;

        b(ad adVar) {
            this.f26783a = adVar;
        }

        public final void onClick(View view) {
            u a2 = this.f26783a.m;
            if (a2 != null) {
                a2.g();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26787a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f26788b;

        f(ad adVar, List list) {
            this.f26787a = adVar;
            this.f26788b = list;
        }

        public final void onClick(View view) {
            u a2;
            n.a(net.one97.paytm.common.utility.d.dE, (Context) this.f26787a.getActivity());
            k.a((Object) view, "view");
            Object tag = view.getTag();
            if (tag != null) {
                String str = (String) this.f26788b.get(((Integer) tag).intValue());
                if (str != null) {
                    CharSequence charSequence = str;
                    int length = charSequence.length() - 1;
                    int i2 = 0;
                    boolean z = false;
                    while (i2 <= length) {
                        boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (!z2) {
                            z = true;
                        } else {
                            i2++;
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence.subSequence(i2, length + 1).toString())) {
                        this.f26787a.getActivity();
                        String d2 = com.paytm.utility.b.d(str, "yyyyMMdd", "dd MMM yy, EEE");
                        if (!TextUtils.isEmpty(d2) && (a2 = this.f26787a.m) != null) {
                            a2.a(d2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void a(String str, String str2, boolean z) {
        TextView textView = this.f26779f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f26778e;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        LinearLayout linearLayout = this.f26781h;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (z) {
            Button button = this.f26780g;
            if (button != null) {
                button.setVisibility(0);
            }
        } else {
            Button button2 = this.f26780g;
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
        TextView textView3 = this.f26777d;
        if (textView3 != null) {
            textView3.setText(str);
        }
        TextView textView4 = this.f26778e;
        if (textView4 != null) {
            textView4.setText(str2);
        }
        if (this.l == 250) {
            ImageView imageView = (ImageView) a(R.id.no_train_image);
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_group_81));
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) a(R.id.no_train_image);
        if (imageView2 != null) {
            imageView2.setImageDrawable(getResources().getDrawable(R.drawable.ic_generic_error_illustration));
        }
    }

    static final class g extends l implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ x.a $isARecieved;
        final /* synthetic */ x.a $isBRecieved;
        final /* synthetic */ x.a $isCRecieved;
        final /* synthetic */ x.e $lastA;
        final /* synthetic */ x.e $lastB;
        final /* synthetic */ x.e $lastC;
        final /* synthetic */ w $this_apply;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(w wVar, x.e eVar, x.e eVar2, x.e eVar3, x.a aVar, x.a aVar2, x.a aVar3) {
            super(0);
            this.$this_apply = wVar;
            this.$lastA = eVar;
            this.$lastB = eVar2;
            this.$lastC = eVar3;
            this.$isARecieved = aVar;
            this.$isBRecieved = aVar2;
            this.$isCRecieved = aVar3;
        }

        public final void invoke() {
            T t = this.$lastA.element;
            T t2 = this.$lastB.element;
            T t3 = this.$lastC.element;
            if (this.$isARecieved.element && this.$isBRecieved.element && this.$isCRecieved.element) {
                this.$isARecieved.element = false;
                this.$isBRecieved.element = false;
                this.$isCRecieved.element = false;
                this.$this_apply.setValue(new s(t, t2, t3));
            }
        }
    }

    static final class h<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26789a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26790b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f26791c;

        h(x.e eVar, x.a aVar, g gVar) {
            this.f26789a = eVar;
            this.f26790b = aVar;
            this.f26791c = gVar;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [A, T, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(A r3) {
            /*
                r2 = this;
                java.lang.String r0 = java.lang.String.valueOf(r3)
                java.lang.String r1 = "PAYTM :: A recieved : "
                java.lang.String r0 = r1.concat(r0)
                java.io.PrintStream r1 = java.lang.System.out
                r1.println(r0)
                kotlin.g.b.x$e r0 = r2.f26789a
                r0.element = r3
                kotlin.g.b.x$a r3 = r2.f26790b
                r0 = 1
                r3.element = r0
                com.travel.train.fragment.ad$g r3 = r2.f26791c
                r3.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ad.h.onChanged(java.lang.Object):void");
        }
    }

    static final class i<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26792a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26793b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f26794c;

        i(x.e eVar, x.a aVar, g gVar) {
            this.f26792a = eVar;
            this.f26793b = aVar;
            this.f26794c = gVar;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [B, T, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(B r3) {
            /*
                r2 = this;
                java.lang.String r0 = java.lang.String.valueOf(r3)
                java.lang.String r1 = "PAYTM :: B recieved : "
                java.lang.String r0 = r1.concat(r0)
                java.io.PrintStream r1 = java.lang.System.out
                r1.println(r0)
                kotlin.g.b.x$e r0 = r2.f26792a
                r0.element = r3
                kotlin.g.b.x$a r3 = r2.f26793b
                r0 = 1
                r3.element = r0
                com.travel.train.fragment.ad$g r3 = r2.f26794c
                r3.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ad.i.onChanged(java.lang.Object):void");
        }
    }

    static final class j<T> implements z<S> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f26795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.a f26796b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f26797c;

        j(x.e eVar, x.a aVar, g gVar) {
            this.f26795a = eVar;
            this.f26796b = aVar;
            this.f26797c = gVar;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [C, T, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChanged(C r3) {
            /*
                r2 = this;
                java.lang.String r0 = java.lang.String.valueOf(r3)
                java.lang.String r1 = "PAYTM :: C recieved : "
                java.lang.String r0 = r1.concat(r0)
                java.io.PrintStream r1 = java.lang.System.out
                r1.println(r0)
                kotlin.g.b.x$e r0 = r2.f26795a
                r0.element = r3
                kotlin.g.b.x$a r3 = r2.f26796b
                r0 = 1
                r3.element = r0
                com.travel.train.fragment.ad$g r3 = r2.f26797c
                r3.invoke()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ad.j.onChanged(java.lang.Object):void");
        }
    }

    static final class e<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f26786a;

        e(ad adVar) {
            this.f26786a = adVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ad.b(this.f26786a, (CJRNearByStationResult) null);
        }
    }

    public static final /* synthetic */ void b(ad adVar, CJRNearByStationResult cJRNearByStationResult) {
        if (cJRNearByStationResult == null || cJRNearByStationResult.getNearByStations() == null || cJRNearByStationResult.getNearByStations().size() <= 0) {
            String string = adVar.getString(R.string.no_trains_for_the_route_text);
            k.a((Object) string, "getString(R.string.no_trains_for_the_route_text)");
            String string2 = adVar.getString(R.string.no_trains_for_the_route_msg);
            k.a((Object) string2, "getString(R.string.no_trains_for_the_route_msg)");
            adVar.a(string, string2, true);
            return;
        }
        List<CJRNearByStation> nearByStations = cJRNearByStationResult.getNearByStations();
        k.a((Object) nearByStations, "nearByResponse.nearByStations");
        LinearLayout linearLayout = adVar.f26782i;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = adVar.f26782i;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        LayoutInflater from = LayoutInflater.from(adVar.getActivity());
        adVar.f26775a = true;
        View inflate = from.inflate(R.layout.pre_t_near_by_station_title, adVar.f26782i, false);
        LinearLayout linearLayout3 = adVar.f26782i;
        if (linearLayout3 != null) {
            linearLayout3.addView(inflate);
        }
        int size = nearByStations.size();
        for (int i2 = 0; i2 < size; i2++) {
            View inflate2 = from.inflate(R.layout.pre_t_nearby_station_layout, adVar.f26782i, false);
            k.a((Object) inflate2, "convertView");
            CJRTrainSearchInput cJRTrainSearchInput = adVar.q;
            if (cJRTrainSearchInput == null) {
                k.a();
            }
            new com.travel.train.viewholder.q(inflate2, cJRTrainSearchInput, adVar.m).a(adVar.getActivity(), nearByStations.get(i2), i2);
            LinearLayout linearLayout4 = adVar.f26782i;
            if (linearLayout4 != null) {
                linearLayout4.addView(inflate2);
            }
        }
        String string3 = adVar.getString(R.string.no_trains_for_the_route_text);
        k.a((Object) string3, "getString(R.string.no_trains_for_the_route_text)");
        String string4 = adVar.getString(R.string.try_using_alt_routes);
        k.a((Object) string4, "getString(R.string.try_using_alt_routes)");
        adVar.a(string3, string4, false);
    }

    public static final /* synthetic */ void f(ad adVar) {
        com.travel.train.k.c cVar;
        CJRTrainSearchResults cJRTrainSearchResults;
        adVar.f26775a = false;
        int i2 = adVar.l;
        if (i2 == 0) {
            return;
        }
        if (i2 != 200 || (cJRTrainSearchResults = adVar.k) == null) {
            LinearLayout linearLayout = adVar.f26781h;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = adVar.f26782i;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            Button button = adVar.f26780g;
            if (button != null) {
                button.setVisibility(8);
            }
            if (!(adVar.q == null || (cVar = adVar.p) == null)) {
                HashMap<String, String> b2 = n.b(adVar.getContext());
                k.a((Object) b2, "CJRTrainSearchResultsUtil.getHeaderParams(context)");
                HashMap<String, String> b3 = n.b(adVar.q);
                k.a((Object) b3, "CJRTrainSearchResultsUti…ations(mTrainSearchInput)");
                k.c(b2, "headers");
                k.c(b3, "urlParams");
                com.travel.train.a.a aVar = cVar.r;
                if (aVar != null) {
                    com.paytm.network.listener.b bVar = cVar;
                    aVar.b(bVar, bVar, b2, b3);
                }
            }
            String string = adVar.getString(R.string.no_trains_for_the_route_text);
            k.a((Object) string, "getString(R.string.no_trains_for_the_route_text)");
            String string2 = adVar.getString(R.string.searching_for_near_by_station_msg);
            k.a((Object) string2, "getString(R.string.searc…_for_near_by_station_msg)");
            adVar.a(string, string2, false);
        } else if (cJRTrainSearchResults != null && cJRTrainSearchResults.getBody() != null) {
            LinearLayout linearLayout3 = adVar.f26781h;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = adVar.f26782i;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            Button button2 = adVar.f26780g;
            if (button2 != null) {
                button2.setVisibility(8);
            }
            ImageView imageView = adVar.f26776c;
            if (imageView != null) {
                imageView.setImageDrawable(adVar.getResources().getDrawable(R.drawable.ic_illustration_01));
            }
            TextView textView = adVar.f26777d;
            if (textView != null) {
                textView.setText(adVar.getString(R.string.no_trains_label, adVar.j));
            }
            CJRTrainSearchResultsBody body = cJRTrainSearchResults.getBody();
            List<String> alternate_dates = body != null ? body.getAlternate_dates() : null;
            if (alternate_dates != null && alternate_dates.size() > 0) {
                TextView textView2 = adVar.f26779f;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = adVar.f26779f;
                if (textView3 != null) {
                    textView3.setText(adVar.getString(R.string.no_trains_msg, Integer.valueOf(alternate_dates.size())));
                }
                LinearLayout linearLayout5 = adVar.f26781h;
                if (linearLayout5 != null) {
                    linearLayout5.removeAllViews();
                }
                int size = alternate_dates != null ? alternate_dates.size() : 0;
                LayoutInflater from = LayoutInflater.from(adVar.getActivity());
                RoboTextView[] roboTextViewArr = new RoboTextView[size];
                for (int i3 = 0; i3 < size; i3++) {
                    if (alternate_dates == null) {
                        k.a();
                    }
                    String str = alternate_dates.get(i3);
                    if (com.paytm.utility.b.c(str, "yyyyMMdd")) {
                        View inflate = from.inflate(R.layout.pre_t_lyt_alternate_dates, (ViewGroup) null);
                        adVar.getActivity();
                        String i4 = com.travel.train.j.i.i(str);
                        if (i4 != null && !TextUtils.isEmpty(i4)) {
                            View findViewById = inflate.findViewById(R.id.alternate_date_text_view);
                            if (findViewById != null) {
                                roboTextViewArr[i3] = (RoboTextView) findViewById;
                                RoboTextView roboTextView = roboTextViewArr[i3];
                                if (roboTextView != null) {
                                    roboTextView.setText(adVar.getString(R.string.alternate_date_text_mesg, i4));
                                }
                                LinearLayout linearLayout6 = adVar.f26781h;
                                if (linearLayout6 != null) {
                                    linearLayout6.addView(inflate);
                                }
                                k.a((Object) inflate, "convertView");
                                inflate.setTag(Integer.valueOf(i3));
                                inflate.setOnClickListener(new f(adVar, alternate_dates));
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
                            }
                        }
                    }
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.r;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
