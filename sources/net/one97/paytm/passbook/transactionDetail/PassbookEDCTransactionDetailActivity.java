package net.one97.paytm.passbook.transactionDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJREDCTransaction;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.transactionDetail.c.a;

public class PassbookEDCTransactionDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private CJREDCTransaction f58982a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f58983b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f58984c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_transaction_detail);
        this.f58984c = (RelativeLayout) findViewById(R.id.loader_ll);
        this.f58983b = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.f58982a = (CJREDCTransaction) getIntent().getSerializableExtra("passbook_detail_data");
        a(this.f58982a);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f58982a = (CJREDCTransaction) intent.getSerializableExtra("passbook_detail_data");
        a(this.f58982a);
    }

    private void a(CJREDCTransaction cJREDCTransaction) {
        if (this.f58982a != null) {
            a aVar = new a();
            q a2 = getSupportFragmentManager().a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("passbook_detail_data", cJREDCTransaction);
            aVar.setArguments(bundle);
            a2.b(R.id.container_ll, aVar, (String) null);
            a2.c();
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(d.b().a(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
