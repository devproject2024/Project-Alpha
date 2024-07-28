package com.business.merchant_payments.newhome;

import android.widget.Toast;
import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;
import com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;

public final class QrBottomSheet$observeQrSummaryApi$$inlined$let$lambda$1 implements z<b<QRSummary>> {
    public final /* synthetic */ QrBottomSheet this$0;

    public QrBottomSheet$observeQrSummaryApi$$inlined$let$lambda$1(QrBottomSheet qrBottomSheet) {
        this.this$0 = qrBottomSheet;
    }

    public final void onChanged(b<QRSummary> bVar) {
        QRSummary qRSummary;
        k.d(bVar, "qrSummaryLiveDataWrapper");
        e eVar = bVar.f7357b;
        if (eVar == e.LOADING) {
            QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).setQRLoadingImage(true);
        } else if (eVar != e.OFFLINE || !p.a("NO NETWORK", bVar.f7359d, true)) {
            T t = bVar.f7358c;
            if (t == null || bVar.f7357b != e.SUCCESS || (qRSummary = (QRSummary) t) == null) {
                e eVar2 = bVar.f7357b;
                if (eVar2 == e.ERROR) {
                    if (bVar.f7356a != null) {
                        this.this$0.qrViewModel.handleErrorCondition(bVar.f7356a);
                    }
                    if (this.this$0.isVisible()) {
                        QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).showReloadQrView();
                    }
                } else if (eVar2 == e.FAILURE && this.this$0.isVisible()) {
                    QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).showReloadQrView();
                }
            } else {
                ArrayList<QRSummaryListItem> arrayList = qRSummary.getmQRSummaryList();
                if (arrayList != null) {
                    this.this$0.qrViewModel.handleQRProgressBar(false);
                    QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).setQRLoadingImage(false);
                    if (!arrayList.isEmpty()) {
                        QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).updateQRView(qRSummary);
                        this.this$0.chekForVerifyQrPopup();
                        return;
                    }
                    QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).showReloadQrView();
                    Toast.makeText(this.this$0.getContext(), "QR not found", 1).show();
                    return;
                }
                QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).showReloadQrView();
            }
        } else {
            QrBottomSheet.access$getManageQrViewHandler$p(this.this$0).showReloadQrView();
        }
    }
}
