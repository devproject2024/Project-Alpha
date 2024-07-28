package net.one97.paytm.recharge.mobile_v3.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class e extends r {

    /* renamed from: b  reason: collision with root package name */
    public static final a f63750b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f63751f = "confirmation_msg";

    /* renamed from: a  reason: collision with root package name */
    public boolean f63752a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f63753e;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f63754g;

    public final View a(int i2) {
        if (this.f63754g == null) {
            this.f63754g = new HashMap();
        }
        View view = (View) this.f63754g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f63754g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f63754g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
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

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        if (this.f63753e) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.clearFlags(2);
            }
            new Handler().postDelayed(new b(this), 300);
        }
        return layoutInflater.inflate(R.layout.v3_delete_recent_bottom_sheet, viewGroup, false);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f63755a;

        b(e eVar) {
            this.f63755a = eVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f63755a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_message_sub);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_message_sub)");
        TextView textView = (TextView) findViewById;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(f63751f)) == null) {
            str = "";
        }
        textView.setText(str);
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

    public final void a() {
        TextView textView;
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.loading_three_dots_lav);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
            cJRRechargeLottieAnimationView.setVisibility(8);
        }
        if (getContext() != null && (textView = (TextView) a(R.id.positive_button)) != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(context, R.color.color_00B9F5));
        }
    }

    public final void onClick(View view) {
        if (!this.f63752a) {
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i2 = R.id.positive_button;
            if (valueOf != null && valueOf.intValue() == i2) {
                DialogInterface.OnClickListener onClickListener = this.f64228c;
                if (onClickListener != null) {
                    onClickListener.onClick(getDialog(), -1);
                    return;
                }
                return;
            }
            int i3 = R.id.negative_button;
            if (valueOf != null && valueOf.intValue() == i3) {
                DialogInterface.OnClickListener onClickListener2 = this.f64228c;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(getDialog(), -2);
                }
                dismiss();
                return;
            }
            int i4 = R.id.close_button;
            if (valueOf != null && valueOf.intValue() == i4) {
                dismiss();
            }
        }
    }

    public final void b() {
        setCancelable(true);
        this.f63752a = false;
    }
}
