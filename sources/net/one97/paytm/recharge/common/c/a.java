package net.one97.paytm.recharge.common.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.fragment.d;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final C1179a f60952a = new C1179a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f60953b;

    public final View a(int i2) {
        if (this.f60953b == null) {
            this.f60953b = new HashMap();
        }
        View view = (View) this.f60953b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f60953b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f60953b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    /* renamed from: net.one97.paytm.recharge.common.c.a$a  reason: collision with other inner class name */
    public static final class C1179a {
        private C1179a() {
        }

        public /* synthetic */ C1179a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_set_bill_reminder_successfully, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            TextView textView = (TextView) a(R.id.txt_message);
            k.a((Object) textView, "txt_message");
            textView.setText(arguments.getString("key_message"));
        }
    }
}
