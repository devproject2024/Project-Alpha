package net.one97.paytm.recharge.ordersummary.c;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.ordersummary.d.r;

public class g extends r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64067a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f64068b;

    public final View a(int i2) {
        if (this.f64068b == null) {
            this.f64068b = new HashMap();
        }
        View view = (View) this.f64068b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64068b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64068b;
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

        public static g a(String str, String str2, List<String> list) {
            k.c(str, "title");
            k.c(list, StringSet.messages);
            g gVar = new g();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("posbtntxt", str2);
            }
            if (!TextUtils.isEmpty((CharSequence) null)) {
                bundle.putString("negbtntxt", (String) null);
            }
            bundle.putSerializable(StringSet.messages, (Serializable) list);
            bundle.putInt("bullet_color", R.color.v8_recharge_bullet);
            gVar.setArguments(bundle);
            return gVar;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_dialog_message_list_v8, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.getBoolean("IS_HTML_MESSAGE", false)) {
            super.onViewCreated(view, bundle);
            return;
        }
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString(StringSet.messages) : null;
        if (net.one97.paytm.recharge.common.utils.g.c(string)) {
            TextView textView = (TextView) a(R.id.htmlMessageTv);
            if (textView != null) {
                ai.a(textView);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                TextView textView2 = (TextView) a(R.id.htmlMessageTv);
                if (textView2 != null) {
                    textView2.setText(Html.fromHtml(string, 0));
                }
            } else {
                TextView textView3 = (TextView) a(R.id.htmlMessageTv);
                if (textView3 != null) {
                    textView3.setText(Html.fromHtml(string));
                }
            }
            TextView textView4 = (TextView) a(R.id.htmlMessageTv);
            if (textView4 != null) {
                textView4.setMovementMethod(LinkMovementMethod.getInstance());
            }
            ((ImageView) view.findViewById(R.id.close_button)).setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) a(R.id.contentLL);
            if (linearLayout != null) {
                ai.b(linearLayout);
            }
        }
    }

    public void onClick(View view) {
        dismiss();
    }
}
