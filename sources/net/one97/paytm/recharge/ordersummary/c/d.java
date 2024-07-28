package net.one97.paytm.recharge.ordersummary.c;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.d.r;

public class d extends r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64044a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f64045b;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f64046e;

    public final View a(int i2) {
        if (this.f64046e == null) {
            this.f64046e = new HashMap();
        }
        View view = (View) this.f64046e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64046e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64046e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        if (this.f64045b) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.clearFlags(2);
            }
            new Handler().postDelayed(new b(this), 300);
        }
        return layoutInflater.inflate(R.layout.content_dialog_alert_v8, viewGroup, false);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64047a;

        b(d dVar) {
            this.f64047a = dVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f64047a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final void a(View view) {
        k.c(view, "view");
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(StringSet.messages) : null;
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        View findViewById = view.findViewById(R.id.messages);
        k.a((Object) findViewById, "(view.findViewById<TextView>(R.id.messages))");
        TextView textView = (TextView) findViewById;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }
}
