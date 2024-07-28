package net.one97.paytm.recharge.ordersummary.c;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.ordersummary.d.r;

public class c extends r {

    /* renamed from: b  reason: collision with root package name */
    public static final a f64038b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f64039e = "refund_amt";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f64040f = "confirmation_msg";

    /* renamed from: a  reason: collision with root package name */
    public boolean f64041a;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64042g;

    public final View a(int i2) {
        if (this.f64042g == null) {
            this.f64042g = new HashMap();
        }
        View view = (View) this.f64042g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64042g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64042g;
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

        public static c a(String str, String str2, String str3, String str4, String str5, String str6) {
            k.c(str, "title");
            k.c(str2, "positiveButtontext");
            k.c(str4, StringSet.messages);
            k.c(str5, "confirmationMsg");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("posbtntxt", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("negbtntxt", str3);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString(c.f64039e, str6);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString(c.f64040f, str5);
            }
            bundle.putSerializable(StringSet.messages, str4);
            bundle.putInt("bullet_color", R.color.v8_recharge_bullet);
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        k.c(layoutInflater, "inflater");
        if (this.f64041a) {
            Dialog dialog = getDialog();
            if (!(dialog == null || (window = dialog.getWindow()) == null)) {
                window.clearFlags(2);
            }
            new Handler().postDelayed(new b(this), 300);
        }
        return layoutInflater.inflate(R.layout.fragment_cancel_insurence_bottom_sheet, viewGroup, false);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64043a;

        b(c cVar) {
            this.f64043a = cVar;
        }

        public final void run() {
            Window window;
            Dialog dialog = this.f64043a.getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawableResource(R.color.color_translucent);
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        CharSequence charSequence;
        String string;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(f64039e)) == null) {
            str = "";
        }
        String a2 = ba.a(str, true);
        if (TextUtils.isEmpty(a2)) {
            TextView textView = (TextView) view.findViewById(R.id.tv_refund_amt_num);
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = (TextView) view.findViewById(R.id.tv_refund_amt);
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) view.findViewById(R.id.tv_refund_amt_num);
        if (textView3 != null) {
            textView3.setText(FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(a2)));
        }
        View findViewById = view.findViewById(R.id.tv_message_sub);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.tv_message_sub)");
        TextView textView4 = (TextView) findViewById;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString(f64040f)) == null) {
            charSequence = "";
        } else {
            charSequence = string;
        }
        textView4.setText(charSequence);
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
