package net.one97.paytm.paymentsBank.chequebook.depositedCheque.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.depositedCheque.view.a;
import net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.CBReturnedChequeActivity;

public final class CBDepositedChequesActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f17521a;

    private View a(int i2) {
        if (this.f17521a == null) {
            this.f17521a = new HashMap();
        }
        View view = (View) this.f17521a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17521a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cb_deposited_cheques_layout);
        a.C0269a aVar = a.f17525e;
        net.one97.paytm.paymentsBank.chequebook.utils.b.a(this, R.id.deposited_cheque_frag_container, new a());
        ((ImageView) a(R.id.btn_back)).setOnClickListener(new a(this));
        a(R.id.returned_chq_click_listener_view).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBDepositedChequesActivity f17522a;

        a(CBDepositedChequesActivity cBDepositedChequesActivity) {
            this.f17522a = cBDepositedChequesActivity;
        }

        public final void onClick(View view) {
            this.f17522a.onBackPressed();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBDepositedChequesActivity f17523a;

        b(CBDepositedChequesActivity cBDepositedChequesActivity) {
            this.f17523a = cBDepositedChequesActivity;
        }

        public final void onClick(View view) {
            this.f17523a.startActivity(new Intent(this.f17523a, CBReturnedChequeActivity.class));
        }
    }
}
