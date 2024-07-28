package net.one97.paytm.paymentsBank.createfd.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;

public final class c extends g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f18104a;

    public final View a(int i2) {
        if (this.f18104a == null) {
            this.f18104a = new HashMap();
        }
        View view = (View) this.f18104a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18104a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
        HashMap hashMap = this.f18104a;
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
        layoutInflater.inflate(R.layout.fd_post_transaction_failure_bottom_layout, onCreateView != null ? (ViewGroup) onCreateView.findViewById(R.id.middleLayout) : null, true);
        return onCreateView;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Window window;
        k.c(view, "view");
        c(R.color.color_fd5c5c);
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
            window.setStatusBarColor(b.c(context2, R.color.color_fd5c5c));
        }
        a(Integer.valueOf(R.string.fd_failure_heading), this.f18116c, Integer.valueOf(R.drawable.pb_fd_create_ic_failed));
        a((TextView) a(R.id.tv_message));
        b((TextView) a(R.id.tv_datetime));
        Button button = (Button) a(R.id.btn_retry);
        if (button != null) {
            button.setOnClickListener(new a(this));
        }
        a(Boolean.TRUE);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18105a;

        a(c cVar) {
            this.f18105a = cVar;
        }

        public final void onClick(View view) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            FragmentActivity activity = this.f18105a.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            BankPasscodeActivity.a.a(activity, "Enter your Paytm Payments Bank passcode to proceed");
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        d();
        List arrayList = new ArrayList();
        String string = getString(R.string.option_help);
        int i2 = R.drawable.pb_contact_us_icon_new;
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        arrayList.add(new OptionsModel(string, i2, Integer.valueOf(net.one97.paytm.paymentsBank.createfd.utils.b.x), (String) null, 8, (g) null));
        a((List<OptionsModel>) arrayList);
    }
}
