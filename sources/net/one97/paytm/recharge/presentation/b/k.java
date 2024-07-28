package net.one97.paytm.recharge.presentation.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class k extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64792a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f64793b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f64794c;

    private View a(int i2) {
        if (this.f64794c == null) {
            this.f64794c = new HashMap();
        }
        View view = (View) this.f64794c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64794c.put(Integer.valueOf(i2), findViewById);
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
        setCancelable(false);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_verify_card, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.loading_threedots_lav);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.playAnimation();
        }
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            z = arguments.getBoolean("is_bank_mandate_enabled", false);
        }
        this.f64793b = z;
        if (this.f64793b) {
            TextView textView = (TextView) a(R.id.tv_heading);
            if (textView != null) {
                textView.setText(getString(R.string.verifying_your_emandate_flow));
            }
            TextView textView2 = (TextView) a(R.id.txt_content);
            if (textView2 != null) {
                textView2.setText(getString(R.string.tv_content_emandate));
                return;
            }
            return;
        }
        TextView textView3 = (TextView) a(R.id.tv_heading);
        if (textView3 != null) {
            textView3.setText(getString(R.string.verifying_your_credit_card));
        }
        TextView textView4 = (TextView) a(R.id.txt_content);
        if (textView4 != null) {
            textView4.setText(getString(R.string.tv_add_rs_to_wallet));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64794c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
