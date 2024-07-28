package net.one97.paytm.passbook.paytmBalance.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.d;

public final class PaytmBalanceActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f58195a;

    public final View a(int i2) {
        if (this.f58195a == null) {
            this.f58195a = new HashMap();
        }
        View view = (View) this.f58195a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f58195a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_paytm_balance);
        ((ImageView) a(R.id.imvBackArrow)).setOnClickListener(new a(this));
        getSupportFragmentManager().a().b(R.id.paytmBalanceTransactionsContainer, new net.one97.paytm.passbook.paytmBalance.fragment.a()).c();
        ((TextView) a(R.id.okTv)).setOnClickListener(new b(this));
        d.b().b("/uth_passbook/paytmbalance", "PASSBOOK", this);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmBalanceActivity f58196a;

        a(PaytmBalanceActivity paytmBalanceActivity) {
            this.f58196a = paytmBalanceActivity;
        }

        public final void onClick(View view) {
            this.f58196a.onBackPressed();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmBalanceActivity f58197a;

        b(PaytmBalanceActivity paytmBalanceActivity) {
            this.f58197a = paytmBalanceActivity;
        }

        public final void onClick(View view) {
            LinearLayout linearLayout = (LinearLayout) this.f58197a.a(R.id.tagSavedLl);
            k.a((Object) linearLayout, "tagSavedLl");
            linearLayout.setVisibility(8);
        }
    }
}
