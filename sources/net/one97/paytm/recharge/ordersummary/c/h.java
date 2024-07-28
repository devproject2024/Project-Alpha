package net.one97.paytm.recharge.ordersummary.c;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.b;
import net.one97.paytm.recharge.ordersummary.d.r;

public final class h extends r {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64069a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f64070e = "refund_amount";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static String f64071f = "category_id";

    /* renamed from: b  reason: collision with root package name */
    private String f64072b;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64073g;

    public final View a(int i2) {
        if (this.f64073g == null) {
            this.f64073g = new HashMap();
        }
        View view = (View) this.f64073g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64073g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(View view) {
        k.c(view, "view");
    }

    public final void d() {
        HashMap hashMap = this.f64073g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_recharge_imps_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str = null;
        Double valueOf = arguments != null ? Double.valueOf(arguments.getDouble(f64070e)) : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(f64071f);
        }
        this.f64072b = str;
        try {
            String h2 = ba.h(String.valueOf(valueOf));
            View findViewById = view.findViewById(R.id.tv_instant_refund_amt);
            if (findViewById != null) {
                ((TextView) findViewById).setText(FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(h2)));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        } catch (Exception unused) {
            View findViewById2 = view.findViewById(R.id.tv_instant_refund_amt);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setText(FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(valueOf)));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h a(String str, String str2, String str3, List<String> list, DialogInterface.OnClickListener onClickListener, Double d2, String str4) {
            k.c(str, "title");
            k.c(list, StringSet.messages);
            h hVar = new h();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("posbtntxt", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("negbtntxt", str3);
            }
            if (d2 != null) {
                d2.doubleValue();
                a aVar = h.f64069a;
                bundle.putDouble(h.f64070e, d2.doubleValue());
            }
            if (str4 != null) {
                a aVar2 = h.f64069a;
                bundle.putString(h.f64071f, str4);
            }
            bundle.putSerializable(StringSet.messages, (Serializable) list);
            hVar.setArguments(bundle);
            hVar.f64228c = onClickListener;
            return hVar;
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.positive_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            try {
                b bVar = b.f62652a;
                b.c(getContext(), ba.i(this.f64072b), "popup_cancel_clicked", (String) null);
            } catch (Throwable unused) {
            }
            DialogInterface.OnClickListener onClickListener = this.f64228c;
            if (onClickListener != null) {
                onClickListener.onClick(getDialog(), -1);
            }
        } else {
            int i3 = R.id.negative_button;
            if (valueOf != null && valueOf.intValue() == i3) {
                try {
                    b bVar2 = b.f62652a;
                    b.c(getContext(), ba.i(this.f64072b), "popup_wait_for_confirmation_clicked", (String) null);
                } catch (Throwable unused2) {
                }
                DialogInterface.OnClickListener onClickListener2 = this.f64228c;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(getDialog(), -2);
                }
            }
        }
        dismiss();
    }
}
