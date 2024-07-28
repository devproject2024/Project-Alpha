package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.flow.FlowCollector;
import net.one97.paytm.nativesdk.R;

public final class OneClickLoadingSheet$initView$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    final /* synthetic */ OneClickLoadingSheet$initView$2 this$0;

    public OneClickLoadingSheet$initView$2$invokeSuspend$$inlined$collect$1(OneClickLoadingSheet$initView$2 oneClickLoadingSheet$initView$2) {
        this.this$0 = oneClickLoadingSheet$initView$2;
    }

    public final Object emit(Object obj, d dVar) {
        int intValue = ((Number) obj).intValue();
        View mView = this.this$0.this$0.getMView();
        ProgressBar progressBar = (ProgressBar) mView.findViewById(R.id.progressBar);
        k.a((Object) progressBar, "progressBar");
        progressBar.setProgress(((this.this$0.this$0.transactionMaxTime - intValue) * 100) / this.this$0.this$0.transactionMaxTime);
        TextView textView = (TextView) mView.findViewById(R.id.timer);
        k.a((Object) textView, "timer");
        textView.setText(String.valueOf(intValue));
        return x.f47997a;
    }
}
