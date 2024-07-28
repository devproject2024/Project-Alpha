package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.x;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrderList;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.widgets.c.b;

public class c extends h {

    /* renamed from: b  reason: collision with root package name */
    public static InputFilter f63292b = new InputFilter() {
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            while (i2 < i3) {
                if (Character.getType(charSequence.charAt(i2)) == 19) {
                    return "";
                }
                i2++;
            }
            return null;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static String f63293d = "station_list";

    /* renamed from: e  reason: collision with root package name */
    private static String f63294e = "source_station";

    /* renamed from: f  reason: collision with root package name */
    private static String f63295f = "search_hint_text";

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f63296a;

    /* renamed from: c  reason: collision with root package name */
    private a f63297c;

    /* renamed from: g  reason: collision with root package name */
    private List<CJRMetroStationModel> f63298g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRMetroStationModel f63299h;

    /* renamed from: i  reason: collision with root package name */
    private String f63300i;
    /* access modifiers changed from: private */
    public AppCompatEditText j;
    private net.one97.paytm.recharge.metro.a.a k;
    private String l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public TextView o;
    private View p;
    private String q;
    private String r;
    private String s;
    private String t;
    private com.paytm.b.a.a u;
    private boolean v = false;

    public interface a {
        void a(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder);

        void a(CJRMetroStationModel cJRMetroStationModel, CJRMetroStationModel cJRMetroStationModel2);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public static c a(List<CJRMetroStationModel> list, String str, CJRMetroStationModel cJRMetroStationModel, String str2, String str3, String str4, String str5, String str6) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f63293d, (Serializable) list);
        bundle.putString("title", str);
        bundle.putSerializable(f63294e, cJRMetroStationModel);
        bundle.putString(f63295f, str2);
        bundle.putString("station_hint", str4);
        bundle.putString("station_hint_dest", str5);
        bundle.putString("ticket_type", str3);
        bundle.putString("product-type", str6);
        cVar.setArguments(bundle);
        return cVar;
    }

    public final void a() {
        this.f63296a.setVisibility(8);
        this.n = true;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.f63297c = (a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnStationSelectionListener");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getActivity() != null) {
            this.u = ax.a(getActivity().getApplicationContext(), f.a.METRO_PREF);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(f63293d)) {
                this.f63298g = (List) arguments.getSerializable(f63293d);
            }
            this.f63300i = arguments.getString("title");
            if (arguments.containsKey(f63294e)) {
                this.f63299h = (CJRMetroStationModel) arguments.getSerializable(f63294e);
            }
            if (arguments.containsKey(f63295f)) {
                this.l = arguments.getString(f63295f);
            }
            if (arguments.containsKey("station_hint")) {
                this.q = arguments.getString("station_hint");
            }
            if (arguments.containsKey("station_hint_dest")) {
                this.r = arguments.getString("station_hint_dest");
            }
            if (arguments.containsKey("ticket_type")) {
                this.s = arguments.getString("ticket_type");
            }
            if (arguments.containsKey("product-type")) {
                this.t = arguments.getString("product-type");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_station_mumbai_metro_selection_list, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.f63300i);
        this.f63296a = (LinearLayout) inflate.findViewById(R.id.recent_journey_container);
        this.m = (TextView) inflate.findViewById(R.id.from_heading_station);
        this.o = (TextView) inflate.findViewById(R.id.tv_clear);
        this.p = inflate.findViewById(R.id.view_empty);
        this.j = (AppCompatEditText) inflate.findViewById(R.id.search_edittext);
        this.j.setHintTextColor(getResources().getColor(R.color.color_b6c2cc));
        this.j.setFilters(new InputFilter[]{f63292b});
        if (this.j != null) {
            if (this.f63299h != null) {
                if (c.d.MUMBAI_METRO_TP.name().equals(this.s)) {
                    this.l = this.r;
                } else {
                    this.l = getString(R.string.metro_where_to);
                }
                this.m.setVisibility(0);
                String str = this.q + "   " + this.f63299h.getName();
                this.f63296a.setVisibility(8);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new StyleSpan(1), str.indexOf(this.f63299h.getName()), str.length(), 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.black)), str.indexOf(this.f63299h.getName()), str.length(), 33);
                this.m.setText(spannableStringBuilder);
                if (!TextUtils.isEmpty(this.s)) {
                    if ("MUMBAI_METRO_SJT".equalsIgnoreCase(this.s) || "MUMBAI_METRO_RJT".equalsIgnoreCase(this.s)) {
                        a("/mumbai-metro-qr-ticket", "mumbai_metro_qr_ticket", "station_from_selected", this.f63299h.getName());
                    } else if ("MUMBAI_METRO_TP".equalsIgnoreCase(this.s)) {
                        a("/mumbai-metro-trip-pass", "mumbai_metro_trip_pass", "station_a_selected", this.f63299h.getName());
                    }
                }
            } else {
                this.l = this.q;
                this.m.setVisibility(8);
                this.f63296a.setVisibility(0);
            }
            this.j.setHint(this.l);
        }
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.this.j.setText("");
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c.b(c.this);
            }
        });
        this.j.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(c.this.j.getText())) {
                    c.this.f63296a.setVisibility(8);
                } else if (!c.this.n) {
                    c.this.f63296a.setVisibility(0);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (c.this.f63299h == null) {
                    if (editable.length() != 0) {
                        c.this.m.setVisibility(8);
                        c.this.o.setVisibility(0);
                        c.a(c.this, editable.toString());
                    }
                    c.this.m.setVisibility(8);
                } else if (editable.length() != 0) {
                    c.this.o.setVisibility(0);
                    c.a(c.this, editable.toString());
                }
                c.this.o.setVisibility(8);
                c.a(c.this, editable.toString());
            }
        });
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.stations_list);
        this.k = new net.one97.paytm.recharge.metro.a.a(this.f63299h, this.f63298g, this.f63297c);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.k);
        recyclerView.addItemDecoration(new g(androidx.appcompat.widget.f.b().a(getContext(), R.drawable.grid_divider)));
        CJRMetroStationModel cJRMetroStationModel = this.f63299h;
        if (cJRMetroStationModel != null && !TextUtils.isEmpty(cJRMetroStationModel.getName())) {
            TextView textView = (TextView) inflate.findViewById(R.id.information_action);
            textView.setVisibility(8);
            String string = getString(R.string.from_station_to_destination, this.f63299h.getName());
            SpannableString spannableString = new SpannableString(string);
            int indexOf = string.indexOf(this.f63299h.getName()) + this.f63299h.getName().length();
            spannableString.setSpan(new ImageSpan(getContext(), R.drawable.ic_metro_station_from_to), indexOf, indexOf + 1, 33);
            textView.setText(spannableString);
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String string = getArguments().getString("key_recent_product_type");
        if (getArguments() != null && getArguments().containsKey("key_recent_product_type") && !TextUtils.isEmpty(string)) {
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            CJRMetroQRFrequentOrderList d2 = c.a.d(string);
            boolean z = false;
            if (!TextUtils.isEmpty(string)) {
                if (string.contains("DELHI")) {
                    this.v = true;
                    z = this.u.b("delhi_qr_recent_has_cleared", false, false);
                } else {
                    this.v = false;
                    if (string.equalsIgnoreCase("MUMBAI_METRO_TP")) {
                        z = this.u.b("mumbai_tp_recent_has_cleared", false, false);
                    } else {
                        z = this.u.b("mumbai_qr_recent_has_cleared", false, false);
                    }
                }
            }
            if (!z && d2 != null && d2.getmOrderList() != null && d2.getmOrderList().size() > 0) {
                j jVar = new j();
                q a2 = getChildFragmentManager().a();
                a2.b(R.id.recent_journey_container, jVar, (String) null);
                if (getArguments() != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("key_recent_product_type", string);
                    jVar.setArguments(bundle2);
                }
                a2.b();
            }
        }
        ((InputMethodManager) view.getContext().getSystemService("input_method")).toggleSoftInput(2, 1);
    }

    public void onDetach() {
        super.onDetach();
        this.f63297c = null;
    }

    private void a(String str, String str2, String str3, String str4) {
        b.a(new kotlin.g.a.a(str2, str3, str, str4) {
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ String f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final Object invoke() {
                return c.this.b(this.f$1, this.f$2, this.f$3, this.f$4);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", str);
        hashMap.put("event_action", str2);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str3);
        hashMap.put("vertical_name", "recharges_utilities");
        hashMap.put("event_label", str4);
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, getContext());
        return null;
    }

    static /* synthetic */ void b(c cVar) {
        try {
            ((InputMethodManager) cVar.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(cVar.getView().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        ArrayList arrayList = new ArrayList();
        for (CJRMetroStationModel next : cVar.f63298g) {
            if (next.getName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 4) {
            cVar.p.setVisibility(8);
        } else {
            cVar.p.setVisibility(0);
        }
        net.one97.paytm.recharge.metro.a.a aVar = cVar.k;
        int length = str.length();
        aVar.f63133b = arrayList;
        aVar.f63136e = length;
        aVar.f63135d = false;
        aVar.notifyDataSetChanged();
    }
}
