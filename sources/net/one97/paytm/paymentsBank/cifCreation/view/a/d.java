package net.one97.paytm.paymentsBank.cifCreation.view.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public final class d extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18033a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f18034c = "hrs";

    /* renamed from: b  reason: collision with root package name */
    private long f18035b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f18036d;

    private View a(int i2) {
        if (this.f18036d == null) {
            this.f18036d = new HashMap();
        }
        View view = (View) this.f18036d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18036d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(long j) {
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putLong(d.f18034c, j);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Long l = null;
        Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.containsKey(f18034c)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                l = Long.valueOf(arguments2.getLong(f18034c));
            }
            if (l == null) {
                k.a();
            }
            this.f18035b = l.longValue();
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.on_boarding_progress_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f18035b <= 24) {
            TextView textView = (TextView) a(R.id.tv_subheading);
            if (textView != null) {
                textView.setText(getString(R.string.pb_fd_boarding_pending_less_then_day));
            }
            TextView textView2 = (TextView) a(R.id.need_help);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            TextView textView3 = (TextView) a(R.id.tv_subheading);
            if (textView3 != null) {
                textView3.setText(getString(R.string.pb_fd_boarding_pending_more_then_day));
            }
            TextView textView4 = (TextView) a(R.id.need_help);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) a(R.id.need_help);
            if (textView5 != null) {
                textView5.setOnClickListener(new b(this));
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.img_cross_view);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new c(this));
        }
        TextView textView6 = (TextView) a(R.id.btn_ok);
        if (textView6 != null) {
            textView6.setOnClickListener(new C0298d(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18037a;

        b(d dVar) {
            this.f18037a = dVar;
        }

        public final void onClick(View view) {
            if (this.f18037a.getActivity() != null && com.paytm.utility.b.c((Context) this.f18037a.getActivity())) {
                o.a().openHelpAndSupport(this.f18037a.getContext(), true);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18038a;

        c(d dVar) {
            this.f18038a = dVar;
        }

        public final void onClick(View view) {
            this.f18038a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.cifCreation.view.a.d$d  reason: collision with other inner class name */
    static final class C0298d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18039a;

        C0298d(d dVar) {
            this.f18039a = dVar;
        }

        public final void onClick(View view) {
            this.f18039a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f18036d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
