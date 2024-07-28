package net.one97.paytm.nativesdk.paymethods.viewmodel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;

public final class TranscationViewModel extends ai {
    private final String transcationStatus;
    private final y<TranscationStatus> transcationStatusData = new y<>();

    public TranscationViewModel(String str) {
        k.c(str, "transcationStatus");
        this.transcationStatus = str;
        handleResponse(this.transcationStatus);
    }

    public final String getTranscationStatus() {
        return this.transcationStatus;
    }

    public final void handleResponse(String str) {
        k.c(str, Payload.RESPONSE);
        String upperCase = str.toUpperCase();
        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        if (k.a((Object) upperCase, (Object) TranscationStatus.TXN_SUCCESS.name())) {
            this.transcationStatusData.setValue(TranscationStatus.TXN_SUCCESS);
        } else if (k.a((Object) upperCase, (Object) TranscationStatus.TXN_FAILURE.name())) {
            this.transcationStatusData.setValue(TranscationStatus.TXN_FAILURE);
        } else {
            this.transcationStatusData.setValue(TranscationStatus.PENDING);
        }
    }

    public final y<TranscationStatus> getOrderStatusLiveData() {
        return this.transcationStatusData;
    }
}
