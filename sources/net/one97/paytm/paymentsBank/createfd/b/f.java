package net.one97.paytm.paymentsBank.createfd.b;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.activity.FdPostTransactionActivity;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;

public final class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f18112a;

    public final View a(int i2) {
        if (this.f18112a == null) {
            this.f18112a = new HashMap();
        }
        View view = (View) this.f18112a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18112a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
        HashMap hashMap = this.f18112a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        e();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        layoutInflater.inflate(R.layout.fd_post_transaction_success_bottom_layout, onCreateView != null ? (ViewGroup) onCreateView.findViewById(R.id.middleLayout) : null, true);
        return onCreateView;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        k.c(view, "view");
        c(R.color.color_21c17a);
        if (Build.VERSION.SDK_INT >= 21) {
            Context context = getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (!(activity == null || (window = activity.getWindow()) == null)) {
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                window.setStatusBarColor(b.c(context2, R.color.color_21c17a));
            }
        }
        a(Integer.valueOf(R.string.fd_success_heading), this.f18116c, Integer.valueOf(R.drawable.success));
        if (this.f18118e != null) {
            String str = this.f18118e;
            b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (p.a(str, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
                a(Boolean.TRUE);
            } else {
                String str2 = this.f18118e;
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                if (p.a(str2, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
                    a(Boolean.FALSE);
                    b();
                    TextView textView = (TextView) a(R.id.fd_tv_view_details);
                    if (textView != null) {
                        textView.setOnClickListener(new a(this));
                    }
                }
            }
        }
        b((TextView) a(R.id.tv_datetime));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f18113a;

        a(f fVar) {
            this.f18113a = fVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f18113a.getActivity();
            if (!(activity instanceof FdPostTransactionActivity)) {
                activity = null;
            }
            FdPostTransactionActivity fdPostTransactionActivity = (FdPostTransactionActivity) activity;
            if (fdPostTransactionActivity != null) {
                fdPostTransactionActivity.a(b.a.c.SUCCESS_DETAIL, this.f18113a.f18115b);
            }
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String i2 = i();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(i2, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
            d();
        }
        List arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.f18119f)) {
            this.f18120g = true;
            String i3 = i();
            b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (p.a(i3, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
                String string = getString(R.string.pb_fd_updated_deposit_amount);
                int i4 = R.drawable.ic_passbook_list;
                b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                arrayList.add(new OptionsModel(string, i4, Integer.valueOf(net.one97.paytm.paymentsBank.createfd.utils.b.y), this.f18119f));
            }
        }
        String string2 = getString(R.string.option_help);
        int i5 = R.drawable.pb_contact_us_icon_new;
        b.a aVar4 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        arrayList.add(new OptionsModel(string2, i5, Integer.valueOf(net.one97.paytm.paymentsBank.createfd.utils.b.x), (String) null, 8, (g) null));
        a((List<OptionsModel>) arrayList);
    }
}
