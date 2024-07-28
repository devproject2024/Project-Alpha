package net.one97.paytm.passbook.main.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.core.content.b;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.BalanceBreakupModel;
import net.one97.paytm.passbook.utility.q;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private BalanceBreakupModel f57822a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f57823b;

    private View a(int i2) {
        if (this.f57823b == null) {
            this.f57823b = new HashMap();
        }
        View view = (View) this.f57823b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57823b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public a() {
    }

    public a(BalanceBreakupModel balanceBreakupModel) {
        this();
        this.f57822a = balanceBreakupModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_bottom_sheet_balance_breakup, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) a(R.id.ivClose)).setOnClickListener(new C1097a(this));
        if (this.f57822a != null) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tvAmountAvailable);
            k.a((Object) roboTextView, "tvAmountAvailable");
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.rs));
            BalanceBreakupModel balanceBreakupModel = this.f57822a;
            if (balanceBreakupModel == null) {
                k.a();
            }
            sb.append(q.a(balanceBreakupModel.getAvailableForPayment()));
            roboTextView.setText(sb.toString());
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvAmountOnHold);
            k.a((Object) roboTextView2, "tvAmountOnHold");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(R.string.rs));
            BalanceBreakupModel balanceBreakupModel2 = this.f57822a;
            if (balanceBreakupModel2 == null) {
                k.a();
            }
            sb2.append(q.a(balanceBreakupModel2.getOnHold()));
            roboTextView2.setText(sb2.toString());
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tvAmountTotalBalance);
            k.a((Object) roboTextView3, "tvAmountTotalBalance");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getString(R.string.rs));
            BalanceBreakupModel balanceBreakupModel3 = this.f57822a;
            if (balanceBreakupModel3 == null) {
                k.a();
            }
            sb3.append(q.a(balanceBreakupModel3.getTotalBalance()));
            roboTextView3.setText(sb3.toString());
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.fragment_bottom_sheet_balance_breakup, (ViewGroup) null);
        dialog.setContentView(inflate);
        try {
            Context context = getContext();
            if (context != null) {
                int c2 = b.c(context, 17170445);
                k.a((Object) inflate, "contentView");
                ViewParent parent = inflate.getParent();
                if (parent != null) {
                    ((View) parent).setBackgroundColor(c2);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.View");
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: net.one97.paytm.passbook.main.a.a$a  reason: collision with other inner class name */
    static final class C1097a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57824a;

        C1097a(a aVar) {
            this.f57824a = aVar;
        }

        public final void onClick(View view) {
            this.f57824a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57823b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
