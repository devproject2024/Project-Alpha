package net.one97.paytm.paymentsBank.chequebook.returnedCheque.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a;
import net.one97.paytm.paymentsBank.chequebook.utils.b;
import net.one97.paytm.paymentsBank.utils.o;

public final class CBReturnedChequeActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f17744a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cb_returned_chq_lyt);
        a.C0284a aVar = a.f17747e;
        b.a(this, R.id.returned_cheque_frag_container, new a());
        int i2 = R.id.btn_back;
        if (this.f17744a == null) {
            this.f17744a = new HashMap();
        }
        View view = (View) this.f17744a.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f17744a.put(Integer.valueOf(i2), view);
        }
        ((ImageView) view).setOnClickListener(new a(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CBReturnedChequeActivity f17745a;

        a(CBReturnedChequeActivity cBReturnedChequeActivity) {
            this.f17745a = cBReturnedChequeActivity;
        }

        public final void onClick(View view) {
            this.f17745a.onBackPressed();
        }
    }

    public final void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
