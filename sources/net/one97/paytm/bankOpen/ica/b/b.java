package net.one97.paytm.bankOpen.ica.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankOpen.R;

public final class b extends d {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f16470b;

    public final View a(int i2) {
        if (this.f16470b == null) {
            this.f16470b = new HashMap();
        }
        View view = (View) this.f16470b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f16470b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f16470b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pb_ca_yes_no_bsdf, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.containsKey("title")) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            TextView textView = (TextView) a(R.id.dialog_title);
            k.a((Object) textView, "dialog_title");
            Bundle arguments2 = getArguments();
            textView.setText(arguments2 != null ? arguments2.getString("title") : null);
        }
        Bundle arguments3 = getArguments();
        Boolean valueOf2 = arguments3 != null ? Boolean.valueOf(arguments3.containsKey("first_btn_txt")) : null;
        if (valueOf2 == null) {
            k.a();
        }
        if (valueOf2.booleanValue()) {
            TextView textView2 = (TextView) a(R.id.first_btn);
            k.a((Object) textView2, "first_btn");
            Bundle arguments4 = getArguments();
            textView2.setText(arguments4 != null ? arguments4.getString("first_btn_txt") : null);
            ((TextView) a(R.id.first_btn)).setOnClickListener(new a(this));
        } else {
            TextView textView3 = (TextView) a(R.id.first_btn);
            k.a((Object) textView3, "first_btn");
            textView3.setVisibility(8);
        }
        Bundle arguments5 = getArguments();
        Boolean valueOf3 = arguments5 != null ? Boolean.valueOf(arguments5.containsKey("second_btn_txt")) : null;
        if (valueOf3 == null) {
            k.a();
        }
        if (valueOf3.booleanValue()) {
            TextView textView4 = (TextView) a(R.id.second_btn);
            k.a((Object) textView4, "second_btn");
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                str = arguments6.getString("second_btn_txt");
            }
            textView4.setText(str);
            ((TextView) a(R.id.second_btn)).setOnClickListener(new C0236b(this));
            return;
        }
        TextView textView5 = (TextView) a(R.id.second_btn);
        k.a((Object) textView5, "second_btn");
        textView5.setVisibility(8);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16471a;

        a(b bVar) {
            this.f16471a = bVar;
        }

        public final void onClick(View view) {
            if (this.f16471a.f16478a != null) {
                d dVar = this.f16471a.f16478a;
                if (dVar == null) {
                    k.a();
                }
                dVar.onFragmentAction(103, (Object) null);
            }
            this.f16471a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.b.b$b  reason: collision with other inner class name */
    static final class C0236b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16472a;

        C0236b(b bVar) {
            this.f16472a = bVar;
        }

        public final void onClick(View view) {
            if (this.f16472a.f16478a != null) {
                d dVar = this.f16472a.f16478a;
                if (dVar == null) {
                    k.a();
                }
                dVar.onFragmentAction(104, (Object) null);
            }
            this.f16472a.dismiss();
        }
    }
}
