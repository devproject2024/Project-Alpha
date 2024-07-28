package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRGroupDisplay;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomGroupDisplayView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f61990a;

    /* renamed from: b  reason: collision with root package name */
    private b f61991b;

    /* renamed from: c  reason: collision with root package name */
    private int f61992c = -1;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f61993d;

    public interface c {
        void a(a aVar);
    }

    private View a(int i2) {
        if (this.f61993d == null) {
            this.f61993d = new HashMap();
        }
        View view = (View) this.f61993d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61993d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomGroupDisplayView(Context context, CJRInputFieldsItem cJRInputFieldsItem, ArrayList<CJRGroupDisplay> arrayList, final c cVar) {
        super(context);
        k.c(cJRInputFieldsItem, "inputField");
        k.c(arrayList, "groupDisplayValues");
        k.c(cVar, "listner");
        LayoutInflater.from(context).inflate(R.layout.group_display_custom_view, this, true);
        RoboTextView roboTextView = (RoboTextView) a(R.id.title);
        k.a((Object) roboTextView, "title");
        roboTextView.setText(cJRInputFieldsItem.getTitle());
        this.f61990a = new ArrayList<>();
        CJRGroupDisplay cJRGroupDisplay = arrayList.get(0);
        k.a((Object) cJRGroupDisplay, "groupDisplayValues[0]");
        Map<String, String> valuesMap = cJRGroupDisplay.getValuesMap();
        k.a((Object) valuesMap, "groupDisplayValues[0].valuesMap");
        for (Map.Entry next : valuesMap.entrySet()) {
            ArrayList<a> arrayList2 = this.f61990a;
            if (arrayList2 != null) {
                arrayList2.add(new a(next));
            }
        }
        RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        ArrayList<a> arrayList3 = this.f61990a;
        if (arrayList3 == null) {
            k.a();
        }
        recyclerView.setAdapter(new b(context, arrayList3, new c() {
            public final void a(a aVar) {
                cVar.a(aVar);
            }
        }));
    }

    public final ArrayList<a> getRecyclerItems() {
        return this.f61990a;
    }

    public final void setRecyclerItems(ArrayList<a> arrayList) {
        this.f61990a = arrayList;
    }

    public final b getAdapter() {
        return this.f61991b;
    }

    public final void setAdapter(b bVar) {
        this.f61991b = bVar;
    }

    public final int getLastSelectedPos() {
        return this.f61992c;
    }

    public final void setLastSelectedPos(int i2) {
        this.f61992c = i2;
    }

    public static final class b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        int f61999a = -1;

        /* renamed from: b  reason: collision with root package name */
        final Context f62000b;

        /* renamed from: c  reason: collision with root package name */
        final List<a> f62001c;

        /* renamed from: d  reason: collision with root package name */
        final c f62002d;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            String str;
            Resources resources;
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            List<a> list = this.f62001c;
            if (list == null) {
                k.a();
            }
            a aVar2 = list.get(i2);
            if (aVar2 != null) {
                aVar.f62003a.setText(aVar2.f61995a);
                aVar.f62003a.setChecked(aVar2.f61998d);
                TextView textView = aVar.f62004b;
                Context context = aVar.f62005c.f62000b;
                if (context == null || (resources = context.getResources()) == null) {
                    str = null;
                } else {
                    str = resources.getString(R.string.rupee_re, new Object[]{z.c(String.valueOf(aVar2.f61996b))});
                }
                textView.setText(str);
                aVar.f62003a.setOnClickListener(new a.C1191a(aVar, aVar2, i2));
                if (aVar.f62005c.f62001c != null && aVar.f62005c.f62001c.size() == 1) {
                    aVar.f62003a.performClick();
                }
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_display_radio_recycler_item_view, (ViewGroup) null);
            k.a((Object) inflate, "layoutView");
            return new a(this, inflate);
        }

        public b(Context context, List<a> list, c cVar) {
            k.c(list, "itemList");
            k.c(cVar, "listner");
            this.f62000b = context;
            this.f62001c = list;
            this.f62002d = cVar;
        }

        public final int getItemCount() {
            return this.f62001c.size();
        }

        public final class a extends RecyclerView.v {

            /* renamed from: a  reason: collision with root package name */
            CheckBox f62003a;

            /* renamed from: b  reason: collision with root package name */
            TextView f62004b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f62005c;

            /* JADX WARNING: type inference failed for: r2v0, types: [net.one97.paytm.recharge.common.widget.CustomGroupDisplayView$b, android.view.View] */
            /* JADX WARNING: type inference failed for: r3v0, types: [int, android.view.View, java.lang.Object] */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public a(android.view.View r2, int r3) {
                /*
                    r1 = this;
                    java.lang.String r0 = "itemView"
                    kotlin.g.b.k.c(r3, r0)
                    r1.f62005c = r2
                    r1.<init>(r3)
                    int r2 = net.one97.paytm.recharge.R.id.radio_button
                    android.view.View r2 = r3.findViewById(r2)
                    java.lang.String r0 = "itemView.findViewById(R.id.radio_button)"
                    kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
                    android.widget.CheckBox r2 = (android.widget.CheckBox) r2
                    r1.f62003a = r2
                    int r2 = net.one97.paytm.recharge.R.id.price
                    android.view.View r2 = r3.findViewById(r2)
                    java.lang.String r3 = "itemView.findViewById(R.id.price)"
                    kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                    android.widget.TextView r2 = (android.widget.TextView) r2
                    r1.f62004b = r2
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CustomGroupDisplayView.b.a.<init>(net.one97.paytm.recharge.common.widget.CustomGroupDisplayView$b, android.view.View):void");
            }

            /* renamed from: net.one97.paytm.recharge.common.widget.CustomGroupDisplayView$b$a$a  reason: collision with other inner class name */
            static final class C1191a implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ a f62006a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ a f62007b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f62008c;

                C1191a(a aVar, a aVar2, int i2) {
                    this.f62006a = aVar;
                    this.f62007b = aVar2;
                    this.f62008c = i2;
                }

                public final void onClick(View view) {
                    this.f62007b.f61998d = true;
                    this.f62006a.f62003a.setChecked(true);
                    if (!(this.f62006a.f62005c.f61999a == -1 || this.f62006a.f62005c.f61999a == this.f62008c)) {
                        this.f62006a.f62005c.f62001c.get(this.f62006a.f62005c.f61999a).f61998d = false;
                        this.f62006a.f62005c.notifyItemChanged(this.f62006a.f62005c.f61999a);
                    }
                    this.f62006a.f62005c.f61999a = this.f62008c;
                    this.f62006a.f62005c.f62002d.a(this.f62007b);
                }
            }
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f61995a;

        /* renamed from: b  reason: collision with root package name */
        double f61996b;

        /* renamed from: c  reason: collision with root package name */
        String f61997c;

        /* renamed from: d  reason: collision with root package name */
        boolean f61998d;

        public a(Map.Entry<String, String> entry) {
            k.c(entry, "item");
            this.f61995a = entry.getKey();
            try {
                JSONArray jSONArray = new JSONArray(entry.getValue());
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject.has("skuId")) {
                        this.f61997c = jSONObject.getString("skuId");
                    }
                    if (jSONObject.has("price")) {
                        String string = jSONObject.getString("price");
                        k.a((Object) string, "jsonObj.getString(CJRRec…nstant.UTILITY_PRICE_KEY)");
                        this.f61996b = Double.parseDouble(string);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
