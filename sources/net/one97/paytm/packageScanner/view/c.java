package net.one97.paytm.packageScanner.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.packageScanner.RemoteAppDataModel;
import net.one97.paytm.paytm_finance.R;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.packageScanner.a.a f57050a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<RemoteAppDataModel> f57051b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f57052c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RadioButton f57053d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RadioButton f57054e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f57055f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f57056g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f57057h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f57058i;
    /* access modifiers changed from: private */
    public boolean j = true;
    private TextView k;
    private ConstraintLayout l;
    private ConstraintLayout m;
    private HashMap n;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.security_alert_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        this.l = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.user_consent1_layout) : null;
        View view3 = getView();
        this.m = view3 != null ? (ConstraintLayout) view3.findViewById(R.id.user_consent2_layout) : null;
        View view4 = getView();
        this.f57053d = view4 != null ? (RadioButton) view4.findViewById(R.id.radio_button_1) : null;
        View view5 = getView();
        this.k = view5 != null ? (TextView) view5.findViewById(R.id.proceed) : null;
        View view6 = getView();
        this.f57054e = view6 != null ? (RadioButton) view6.findViewById(R.id.radio_button_2) : null;
        View view7 = getView();
        this.f57055f = view7 != null ? (TextView) view7.findViewById(R.id.tv_user_consent1) : null;
        View view8 = getView();
        this.f57056g = view8 != null ? (TextView) view8.findViewById(R.id.tv_user_consent1_hindi) : null;
        View view9 = getView();
        this.f57057h = view9 != null ? (TextView) view9.findViewById(R.id.tv_user_consent2) : null;
        View view10 = getView();
        this.f57058i = view10 != null ? (TextView) view10.findViewById(R.id.tv_user_consent2_hindi) : null;
        ConstraintLayout constraintLayout = this.l;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new a(this));
        }
        ConstraintLayout constraintLayout2 = this.m;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new b(this));
        }
        Bundle arguments = getArguments();
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.containsKey("InstalledAppList")) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 != null ? arguments2.getSerializable("InstalledAppList") : null;
            if (serializable != null && (serializable instanceof ArrayList)) {
                this.f57051b = (ArrayList) serializable;
            }
        }
        ArrayList<RemoteAppDataModel> arrayList = this.f57051b;
        if (getContext() != null) {
            this.f57050a = new net.one97.paytm.packageScanner.a.a(getContext(), arrayList);
            View view11 = getView();
            this.f57052c = view11 != null ? (RecyclerView) view11.findViewById(R.id.recycler_view) : null;
            RecyclerView recyclerView = this.f57052c;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            }
            RecyclerView recyclerView2 = this.f57052c;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.f57050a);
            }
        }
        try {
            if (getContext() != null) {
                net.one97.paytm.common.b.d.a().a(getContext(), "Screen_opened", (ArrayList<String>) null);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(new C1065c(this));
        }
        RadioButton radioButton = this.f57053d;
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new d(this));
        }
        RadioButton radioButton2 = this.f57054e;
        if (radioButton2 != null) {
            radioButton2.setOnCheckedChangeListener(new e(this));
        }
    }

    /* renamed from: net.one97.paytm.packageScanner.view.c$c  reason: collision with other inner class name */
    static final class C1065c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57061a;

        C1065c(c cVar) {
            this.f57061a = cVar;
        }

        public final void onClick(View view) {
            if (this.f57061a.j) {
                new a().show(this.f57061a.getChildFragmentManager().a(), a.class.getName());
            } else {
                new b().show(this.f57061a.getChildFragmentManager().a(), b.class.getName());
            }
        }
    }

    static final class d implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57062a;

        d(c cVar) {
            this.f57062a = cVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f57062a.j = true;
                RadioButton b2 = this.f57062a.f57054e;
                if (b2 != null) {
                    b2.setChecked(false);
                }
                c.b(this.f57062a, true);
            }
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57063a;

        e(c cVar) {
            this.f57063a = cVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f57063a.j = false;
                RadioButton c2 = this.f57063a.f57053d;
                if (c2 != null) {
                    c2.setChecked(false);
                }
                c.b(this.f57063a, false);
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57059a;

        a(c cVar) {
            this.f57059a = cVar;
        }

        public final void onClick(View view) {
            RadioButton c2 = this.f57059a.f57053d;
            if (c2 != null) {
                c2.setChecked(true);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57060a;

        b(c cVar) {
            this.f57060a = cVar;
        }

        public final void onClick(View view) {
            RadioButton b2 = this.f57060a.f57054e;
            if (b2 != null) {
                b2.setChecked(true);
            }
        }
    }

    public static final /* synthetic */ void b(c cVar, boolean z) {
        if (z) {
            Context context = cVar.getContext();
            if (context != null) {
                TextView textView = cVar.f57055f;
                if (textView != null) {
                    textView.setTextColor(androidx.core.content.b.c(context, R.color.home_tag_color));
                }
                TextView textView2 = cVar.f57057h;
                if (textView2 != null) {
                    textView2.setTextColor(androidx.core.content.b.c(context, R.color.heading_text_color));
                }
            }
            TextView textView3 = cVar.f57055f;
            if (textView3 != null) {
                net.one97.paytm.utils.c.a.a(textView3, true);
            }
            TextView textView4 = cVar.f57056g;
            if (textView4 != null) {
                net.one97.paytm.utils.c.a.a(textView4, true);
            }
            TextView textView5 = cVar.f57057h;
            if (textView5 != null) {
                net.one97.paytm.utils.c.a.a(textView5, false);
            }
            TextView textView6 = cVar.f57058i;
            if (textView6 != null) {
                net.one97.paytm.utils.c.a.a(textView6, false);
                return;
            }
            return;
        }
        Context context2 = cVar.getContext();
        if (context2 != null) {
            TextView textView7 = cVar.f57055f;
            if (textView7 != null) {
                textView7.setTextColor(androidx.core.content.b.c(context2, R.color.heading_text_color));
            }
            TextView textView8 = cVar.f57057h;
            if (textView8 != null) {
                textView8.setTextColor(androidx.core.content.b.c(context2, R.color.home_tag_color));
            }
        }
        TextView textView9 = cVar.f57055f;
        if (textView9 != null) {
            net.one97.paytm.utils.c.a.a(textView9, false);
        }
        TextView textView10 = cVar.f57056g;
        if (textView10 != null) {
            net.one97.paytm.utils.c.a.a(textView10, false);
        }
        TextView textView11 = cVar.f57057h;
        if (textView11 != null) {
            net.one97.paytm.utils.c.a.a(textView11, true);
        }
        TextView textView12 = cVar.f57058i;
        if (textView12 != null) {
            net.one97.paytm.utils.c.a.a(textView12, true);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
