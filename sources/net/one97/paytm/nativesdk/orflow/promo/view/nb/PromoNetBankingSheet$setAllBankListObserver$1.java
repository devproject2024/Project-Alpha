package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;

public final class PromoNetBankingSheet$setAllBankListObserver$1 implements z<NBResponse> {
    final /* synthetic */ PromoNetBankingSheet this$0;

    PromoNetBankingSheet$setAllBankListObserver$1(PromoNetBankingSheet promoNetBankingSheet) {
        this.this$0 = promoNetBankingSheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r6.getBody()).getNbPayOption();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.instruments.netbanking.modal.Body r1 = r6.getBody()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption r1 = r1.getNbPayOption()
            if (r1 == 0) goto L_0x0014
            java.util.ArrayList r1 = r1.getPayChannelOptions()
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            r2 = 8
            java.lang.String r3 = "mView.pb_progress"
            r4 = 0
            if (r1 != 0) goto L_0x0070
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            java.util.ArrayList r6 = r6.mAllBanksList
            if (r6 == 0) goto L_0x0031
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r6 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r6
            if (r6 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam$NetworkCallState r1 = net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam.NetworkCallState.Failed
            r6.setNetworkCallState(r1)
        L_0x0031:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            android.view.View r6 = r6.getMView()
            int r1 = net.one97.paytm.nativesdk.R.id.pb_progress
            android.view.View r6 = r6.findViewById(r1)
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r2)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r6 = new net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam
            r1 = 10
            r6.<init>(r1, r0)
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r0 = r5.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r0 = r0.mAllNetBankingAdapter
            if (r0 == 0) goto L_0x005d
            java.util.ArrayList r0 = r0.getFilteredList()
            if (r0 == 0) goto L_0x005d
            r0.add(r6)
        L_0x005d:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r0 = r5.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r0 = r0.mAllNetBankingAdapter
            if (r0 == 0) goto L_0x0129
            java.util.ArrayList r0 = r0.getMasterList()
            if (r0 == 0) goto L_0x0129
            r0.add(r6)
            goto L_0x0129
        L_0x0070:
            net.one97.paytm.nativesdk.instruments.netbanking.modal.Body r1 = r6.getBody()
            if (r1 == 0) goto L_0x00c6
            net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption r1 = r1.getNbPayOption()
            if (r1 == 0) goto L_0x00c6
            java.util.ArrayList r1 = r1.getPayChannelOptions()
            if (r1 == 0) goto L_0x00c6
            int r1 = r1.size()
            if (r1 != 0) goto L_0x00c6
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            java.util.ArrayList r6 = r6.mAllBanksList
            if (r6 == 0) goto L_0x009d
            java.lang.Object r6 = r6.get(r4)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r6 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r6
            if (r6 == 0) goto L_0x009d
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam$NetworkCallState r0 = net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam.NetworkCallState.Failed
            r6.setNetworkCallState(r0)
        L_0x009d:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            android.view.View r6 = r6.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.pb_progress
            android.view.View r6 = r6.findViewById(r0)
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            r6.setVisibility(r2)
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            android.view.View r6 = r6.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.list_empty_layout_container
            android.view.View r6 = r6.findViewById(r0)
            java.lang.String r0 = "mView.list_empty_layout_container"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r6.setVisibility(r4)
            goto L_0x0129
        L_0x00c6:
            net.one97.paytm.nativesdk.instruments.netbanking.modal.Body r6 = r6.getBody()
            if (r6 == 0) goto L_0x0129
            net.one97.paytm.nativesdk.instruments.netbanking.modal.NbPayOption r6 = r6.getNbPayOption()
            if (r6 == 0) goto L_0x0129
            java.util.ArrayList r6 = r6.getPayChannelOptions()
            if (r6 == 0) goto L_0x0129
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r1 = r5.this$0
            java.util.ArrayList r1 = r1.mAllBanksList
            if (r1 == 0) goto L_0x00ed
            java.lang.Object r1 = r1.get(r4)
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = (net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam) r1
            if (r1 == 0) goto L_0x00ed
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam$NetworkCallState r2 = net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam.NetworkCallState.Success
            r1.setNetworkCallState(r2)
        L_0x00ed:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r1 = r5.this$0
            androidx.lifecycle.ai r1 = r1.getMViewModel()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel r1 = (net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionViewModel) r1
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r2 = r5.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r2 = r2.mAllNetBankingAdapter
            if (r2 == 0) goto L_0x0102
            java.util.ArrayList r2 = r2.getFilteredList()
            goto L_0x0103
        L_0x0102:
            r2 = r0
        L_0x0103:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r3 = r5.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r3 = r3.mAllNetBankingAdapter
            if (r3 == 0) goto L_0x010f
            java.util.ArrayList r0 = r3.getMasterList()
        L_0x010f:
            r1.prepareAllNBListData(r6, r2, r0)
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            android.view.View r6 = r6.getMView()
            int r0 = net.one97.paytm.nativesdk.R.id.nbLoadingView
            android.view.View r6 = r6.findViewById(r0)
            android.widget.ScrollView r6 = (android.widget.ScrollView) r6
            java.lang.String r0 = "mView.nbLoadingView"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            r0 = 4
            r6.setVisibility(r0)
        L_0x0129:
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet r6 = r5.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoAllNetBankingAdapter r6 = r6.mAllNetBankingAdapter
            if (r6 == 0) goto L_0x0134
            r6.notifyDataSetChanged()
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.nb.PromoNetBankingSheet$setAllBankListObserver$1.onChanged(net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse):void");
    }
}
