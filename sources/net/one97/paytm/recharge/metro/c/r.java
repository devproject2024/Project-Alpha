package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.metro.a.g;
import net.one97.paytm.recharge.metro.c.q;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.ordersummary.h.d;

public final class r extends q implements g.a {

    /* renamed from: g  reason: collision with root package name */
    private final String f63441g = "destination_station";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g f63442h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public AutoCompleteTextView f63443i;
    private final String j;
    private Button k;
    private String l;
    /* access modifiers changed from: private */
    public TextView m;
    private boolean n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public d q;
    private HashMap r;

    public final q a(List<? extends CJRMetroStationModel> list, String str, CJRMetroStationModel cJRMetroStationModel, String str2, boolean z, String str3, String str4) {
        k.c(list, "pStationList");
        k.c(cJRMetroStationModel, "sourceStation");
        k.c(str3, "eventCategory");
        k.c(str4, "eventLabel");
        r rVar = new r();
        Bundle bundle = new Bundle();
        bundle.putSerializable(q.f63433b, (Serializable) list);
        bundle.putString("title", str);
        bundle.putSerializable(q.f63434c, cJRMetroStationModel);
        bundle.putString(this.f63441g, str2);
        bundle.putBoolean("is_store_value_pass", z);
        bundle.putString("metro_event_category", str3);
        bundle.putString("metro_event_label", str4);
        rVar.setArguments(bundle);
        return rVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.q = new d(context);
        }
        if (this.f63438f != null) {
            if (this.f63438f.containsKey(this.f63441g)) {
                this.l = this.f63438f.getString(this.f63441g);
            }
            if (this.f63438f.containsKey("is_store_value_pass")) {
                this.n = this.f63438f.getBoolean("is_store_value_pass");
            }
            if (this.f63438f.containsKey("metro_event_category")) {
                this.p = this.f63438f.getString("metro_event_category");
            }
            if (this.f63438f.containsKey("metro_event_label")) {
                this.o = this.f63438f.getString("metro_event_label");
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_station_selection_list_v2, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        this.k = (Button) view.findViewById(R.id.btn_proceed);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.custom_toolbar);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.search_header);
        this.m = (TextView) relativeLayout.findViewById(R.id.search_hint);
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        Button button = this.k;
        if (button != null) {
            button.setVisibility(0);
        }
        View findViewById = view.findViewById(R.id.search_operator);
        if (findViewById != null) {
            this.f63443i = (AutoCompleteTextView) findViewById;
            AutoCompleteTextView autoCompleteTextView = this.f63443i;
            if (autoCompleteTextView != null) {
                String str = this.j;
                if (!(str == null || autoCompleteTextView == null)) {
                    autoCompleteTextView.setHint(str);
                }
                AutoCompleteTextView autoCompleteTextView2 = this.f63443i;
                if (autoCompleteTextView2 != null) {
                    autoCompleteTextView2.addTextChangedListener(new a(this));
                }
            }
            Button button2 = this.k;
            if (button2 != null) {
                button2.setOnClickListener(new b(this));
            }
            super.onViewCreated(view, bundle);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.AutoCompleteTextView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f63445a;

        b(r rVar) {
            this.f63445a = rVar;
        }

        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
                r9 = this;
                net.one97.paytm.recharge.metro.c.r r10 = r9.f63445a
                net.one97.paytm.recharge.ordersummary.h.d r0 = r10.q
                if (r0 == 0) goto L_0x0031
                net.one97.paytm.recharge.metro.c.r r10 = r9.f63445a
                java.lang.String r10 = r10.p
                java.lang.String r1 = ""
                if (r10 != 0) goto L_0x0013
                r10 = r1
            L_0x0013:
                net.one97.paytm.recharge.metro.c.r r2 = r9.f63445a
                java.lang.String r2 = r2.o
                if (r2 != 0) goto L_0x001d
                r4 = r1
                goto L_0x001e
            L_0x001d:
                r4 = r2
            L_0x001e:
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ab.f61496a
                java.lang.String r1 = "CJRRechargeUtilityConstant.UTILITY"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                r6 = 0
                r7 = 0
                r8 = 96
                java.lang.String r2 = "exit_station_proceed_clicked"
                java.lang.String r3 = ""
                r1 = r10
                net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            L_0x0031:
                net.one97.paytm.recharge.metro.c.r r10 = r9.f63445a
                net.one97.paytm.recharge.metro.a.g r10 = r10.f63442h
                r0 = 0
                if (r10 == 0) goto L_0x003d
                net.one97.paytm.recharge.model.metro.CJRMetroStationModel r10 = r10.f63177d
                goto L_0x003e
            L_0x003d:
                r10 = r0
            L_0x003e:
                if (r10 == 0) goto L_0x0052
                net.one97.paytm.recharge.metro.c.r r10 = r9.f63445a
                net.one97.paytm.recharge.metro.c.q$a r10 = r10.f63435a
                net.one97.paytm.recharge.metro.c.r r1 = r9.f63445a
                net.one97.paytm.recharge.metro.a.g r1 = r1.f63442h
                if (r1 == 0) goto L_0x004e
                net.one97.paytm.recharge.model.metro.CJRMetroStationModel r0 = r1.f63177d
            L_0x004e:
                r10.a(r0)
                return
            L_0x0052:
                net.one97.paytm.recharge.metro.c.r r10 = r9.f63445a
                android.content.Context r10 = r10.getContext()
                net.one97.paytm.recharge.metro.c.r r1 = r9.f63445a
                android.content.Context r1 = r1.getContext()
                if (r1 == 0) goto L_0x0066
                int r0 = net.one97.paytm.recharge.R.string.metro_select_any_station_to_exit
                java.lang.String r0 = r1.getString(r0)
            L_0x0066:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1 = 0
                android.widget.Toast r10 = android.widget.Toast.makeText(r10, r0, r1)
                r10.show()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.r.b.onClick(android.view.View):void");
        }
    }

    /* access modifiers changed from: protected */
    public final void a(RecyclerView recyclerView) {
        if (getContext() == null) {
            super.a(recyclerView);
            return;
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        CJRMetroStationModel cJRMetroStationModel = this.f63437e;
        k.a((Object) cJRMetroStationModel, "mSourceStation");
        List list = this.f63436d;
        k.a((Object) list, "mStationList");
        q.a aVar = this.f63435a;
        k.a((Object) aVar, "mListener");
        this.f63442h = new g(context, cJRMetroStationModel, list, aVar, this, this.l, this.n);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f63442h);
        }
        if (recyclerView != null) {
            f b2 = f.b();
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            recyclerView.addItemDecoration(new net.one97.paytm.common.widgets.g(b2.a(context2, R.drawable.grid_divider)));
        }
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f63444a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "charSequence");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "charSequence");
        }

        a(r rVar) {
            this.f63444a = rVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "editable");
            r.a(this.f63444a, editable.toString());
            AutoCompleteTextView e2 = this.f63444a.f63443i;
            if ((e2 != null ? e2.getText() : null) != null) {
                TextView f2 = this.f63444a.m;
                if (f2 != null) {
                    f2.setVisibility(8);
                    return;
                }
                return;
            }
            TextView f3 = this.f63444a.m;
            if (f3 != null) {
                f3.setVisibility(0);
            }
        }
    }

    public final void a(boolean z) {
        String str;
        d dVar = this.q;
        if (dVar != null) {
            String str2 = this.p;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.o;
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            String str4 = ab.f61496a;
            k.a((Object) str4, "CJRRechargeUtilityConstant.UTILITY");
            d.a(dVar, str2, "exit_station_selected", "", str, str4, (Object) null, (Object) null, 96);
        }
        if (z) {
            Button button = this.k;
            if (button != null) {
                button.setBackgroundColor(Color.parseColor("#00b9f5"));
            }
            Button button2 = this.k;
            if (button2 != null) {
                button2.setEnabled(true);
                return;
            }
            return;
        }
        Button button3 = this.k;
        if (button3 != null) {
            button3.setBackgroundColor(Color.parseColor("#b6c2cc"));
        }
        Button button4 = this.k;
        if (button4 != null) {
            button4.setEnabled(false);
        }
    }

    public static final /* synthetic */ void a(r rVar, String str) {
        ArrayList arrayList = new ArrayList();
        for (CJRMetroStationModel cJRMetroStationModel : rVar.f63436d) {
            k.a((Object) cJRMetroStationModel, "s");
            String name = cJRMetroStationModel.getName();
            k.a((Object) name, "s.name");
            if (name != null) {
                String lowerCase = name.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                CharSequence charSequence = lowerCase;
                if (str != null) {
                    String lowerCase2 = str.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (p.a(charSequence, (CharSequence) lowerCase2, false)) {
                        arrayList.add(cJRMetroStationModel);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        g gVar = rVar.f63442h;
        if (gVar != null) {
            gVar.a(arrayList);
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
