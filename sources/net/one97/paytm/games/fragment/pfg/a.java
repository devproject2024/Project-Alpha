package net.one97.paytm.games.fragment.pfg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.f;

public final class a extends net.one97.paytm.games.fragment.a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0600a f35694b = new C0600a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    Runnable f35695a;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f35696c;

    public final View a(int i2) {
        if (this.f35696c == null) {
            this.f35696c = new HashMap();
        }
        View view = (View) this.f35696c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f35696c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f35696c;
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
        return layoutInflater.inflate(R.layout.app_dialog_task, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        CharSequence string = arguments != null ? arguments.getString("title") : null;
        boolean z = true;
        if (!(string == null || p.a(string))) {
            TextView textView = (TextView) a(R.id.title);
            textView.setVisibility(0);
            textView.setText(string);
        }
        CharSequence string2 = arguments != null ? arguments.getString("message") : null;
        if (!(string2 == null || p.a(string2))) {
            TextView textView2 = (TextView) a(R.id.message);
            textView2.setVisibility(0);
            textView2.setText(string2);
        }
        CharSequence string3 = arguments != null ? arguments.getString("bonus") : null;
        if (!(string3 == null || p.a(string3))) {
            TextView textView3 = (TextView) a(R.id.bonus);
            textView3.setVisibility(0);
            textView3.setText(string3);
        }
        if (arguments != null) {
            str = arguments.getString("ctaText");
        }
        CharSequence charSequence = str;
        if (charSequence != null && !p.a(charSequence)) {
            z = false;
        }
        if (!z) {
            TextView textView4 = (TextView) a(R.id.btn_okay);
            textView4.setVisibility(0);
            textView4.setText(charSequence);
            textView4.setOnClickListener(new b(textView4, this, str));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f35697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f35698b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f35699c;

        b(TextView textView, a aVar, String str) {
            this.f35697a = textView;
            this.f35698b = aVar;
            this.f35699c = str;
        }

        public final void onClick(View view) {
            if (!f.a(this.f35697a.getContext())) {
                Toast.makeText(this.f35697a.getContext(), this.f35698b.getString(R.string.com_gamepind_no_internet_available), 0).show();
                return;
            }
            Runnable runnable = this.f35698b.f35695a;
            if (runnable != null) {
                runnable.run();
            }
            this.f35698b.dismissAllowingStateLoss();
        }
    }

    /* renamed from: net.one97.paytm.games.fragment.pfg.a$a  reason: collision with other inner class name */
    public static final class C0600a {
        private C0600a() {
        }

        public /* synthetic */ C0600a(byte b2) {
            this();
        }
    }
}
