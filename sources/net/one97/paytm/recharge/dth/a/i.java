package net.one97.paytm.recharge.dth.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import org.json.JSONArray;

public final class i extends net.one97.paytm.i.f {

    /* renamed from: c  reason: collision with root package name */
    public static final a f62720c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f62721d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static List<String> f62722e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f62723f = "SUBSCRIBER_MAP";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static String f62724g = "recharge_number";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static String f62725h = "proceed_button_text";

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f62726a;

    /* renamed from: b  reason: collision with root package name */
    b f62727b;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f62728i;

    public interface b {
        void a(JSONArray jSONArray, String str);
    }

    public final View b(int i2) {
        if (this.f62728i == null) {
            this.f62728i = new HashMap();
        }
        View view = (View) this.f62728i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f62728i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
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
        setStyle(0, R.style.CustomImpsBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dth_subscriber_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Button button;
        String str;
        Set<String> keySet;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null && arguments.containsKey(f62723f)) {
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 != null ? arguments2.getSerializable(f62723f) : null;
            if (!(serializable instanceof Map)) {
                serializable = null;
            }
            this.f62726a = (Map) serializable;
        }
        Map<String, String> map = this.f62726a;
        f62722e = (map == null || (keySet = map.keySet()) == null) ? null : kotlin.a.k.c(keySet);
        f62721d = 0;
        RecyclerView recyclerView = (RecyclerView) b(R.id.rv_subscriber_id);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = (RecyclerView) b(R.id.rv_subscriber_id);
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(new g(this));
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || !arguments3.containsKey(f62724g)) {
            TextView textView = (TextView) b(R.id.title);
            k.a((Object) textView, "title");
            ai.b(textView);
        } else {
            TextView textView2 = (TextView) b(R.id.title);
            if (textView2 != null) {
                Context context = getContext();
                if (context != null) {
                    int i2 = R.string.rc_dth_subscriber_heading;
                    Object[] objArr = new Object[1];
                    Bundle arguments4 = getArguments();
                    objArr[0] = arguments4 != null ? arguments4.getString(f62724g) : null;
                    str = context.getString(i2, objArr);
                } else {
                    str = null;
                }
                textView2.setText(str);
            }
            TextView textView3 = (TextView) b(R.id.title);
            k.a((Object) textView3, "title");
            ai.a(textView3);
        }
        Bundle arguments5 = getArguments();
        if (!(arguments5 == null || !arguments5.containsKey(f62725h) || (button = (Button) b(R.id.btn_proceed)) == null)) {
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                str2 = arguments6.getString(f62725h);
            }
            button.setText(str2);
        }
        ImageView imageView = (ImageView) b(R.id.close_button);
        if (imageView != null) {
            imageView.setOnClickListener(new d(this));
        }
        TextView textView4 = (TextView) b(R.id.submessagetwoViewId);
        if (textView4 != null) {
            ai.b(textView4);
        }
        TextView textView5 = (TextView) b(R.id.submessageViewId);
        if (textView5 != null) {
            textView5.setOnClickListener(new e(this));
        }
        Button button2 = (Button) b(R.id.btn_proceed);
        if (button2 != null) {
            button2.setOnClickListener(new f(this));
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f62732a;

        d(i iVar) {
            this.f62732a = iVar;
        }

        public final void onClick(View view) {
            this.f62732a.dismiss();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f62733a;

        e(i iVar) {
            this.f62733a = iVar;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) this.f62733a.b(R.id.submessagetwoViewId);
            if (textView == null || textView.getVisibility() != 0) {
                TextView textView2 = (TextView) this.f62733a.b(R.id.submessagetwoViewId);
                if (textView2 != null) {
                    ai.a(textView2);
                    return;
                }
                return;
            }
            TextView textView3 = (TextView) this.f62733a.b(R.id.submessagetwoViewId);
            if (textView3 != null) {
                ai.b(textView3);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f62734a;

        f(i iVar) {
            this.f62734a = iVar;
        }

        public final void onClick(View view) {
            b bVar;
            a aVar = i.f62720c;
            if (i.f62722e != null) {
                a aVar2 = i.f62720c;
                List b2 = i.f62722e;
                Boolean bool = null;
                Integer valueOf = b2 != null ? Integer.valueOf(b2.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 0 && i.f62721d != -1) {
                    a aVar3 = i.f62720c;
                    List b3 = i.f62722e;
                    String str = b3 != null ? (String) b3.get(i.f62721d) : null;
                    Map<String, String> map = this.f62734a.f62726a;
                    String str2 = map != null ? map.get(str) : null;
                    if (str2 != null) {
                        CharSequence charSequence = str2;
                        bool = Boolean.valueOf(charSequence == null || charSequence.length() == 0);
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (!bool.booleanValue() && (bVar = this.f62734a.f62727b) != null) {
                        bVar.a(new JSONArray(str2), str);
                    }
                    this.f62734a.dismiss();
                }
            }
        }
    }

    public static final class g extends RecyclerView.a<c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f62735a;

        g(i iVar) {
            this.f62735a = iVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            c cVar = (c) vVar;
            k.c(cVar, "holder");
            a aVar = i.f62720c;
            List b2 = i.f62722e;
            String str = b2 != null ? (String) b2.get(i2) : null;
            TextView textView = cVar.f62729a;
            if (textView != null) {
                textView.setText(str);
            }
            RadioButton radioButton = cVar.f62730b;
            if (radioButton != null) {
                radioButton.setChecked(i.f62721d == i2);
            }
            if (i.f62721d == i2) {
                androidx.core.widget.i.a(cVar.f62729a, R.style.dthSubscriberSelectedStyle);
            } else {
                androidx.core.widget.i.a(cVar.f62729a, R.style.dthSubscriberDefaultStyle);
            }
            View view = cVar.f62731c;
            if (view != null) {
                view.setOnClickListener(new a(this, cVar));
            }
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f62735a.getContext()).inflate(R.layout.dth_subscriber_row_view, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…_row_view, parent, false)");
            return new c(inflate);
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f62736a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f62737b;

            a(g gVar, c cVar) {
                this.f62736a = gVar;
                this.f62737b = cVar;
            }

            public final void onClick(View view) {
                i.f62721d = this.f62737b.getAdapterPosition();
                this.f62736a.notifyDataSetChanged();
            }
        }

        public final int getItemCount() {
            a aVar = i.f62720c;
            List b2 = i.f62722e;
            if (b2 != null) {
                return b2.size();
            }
            return 0;
        }
    }

    public static final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f62729a;

        /* renamed from: b  reason: collision with root package name */
        final RadioButton f62730b;

        /* renamed from: c  reason: collision with root package name */
        final View f62731c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_subscriberId);
            if (findViewById != null) {
                this.f62729a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.view_selector);
                if (findViewById2 != null) {
                    this.f62730b = (RadioButton) findViewById2;
                    this.f62731c = view;
                    return;
                }
                throw new u("null cannot be cast to non-null type android.widget.RadioButton");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62728i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
