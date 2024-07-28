package com.business.merchant_payments.ups;

import com.business.common_module.utilities.LogUtility;
import kotlin.d.a;
import kotlin.d.f;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class UPSDataProvider$$special$$inlined$CoroutineExceptionHandler$1 extends a implements CoroutineExceptionHandler {
    public UPSDataProvider$$special$$inlined$CoroutineExceptionHandler$1(f.c cVar) {
        super(cVar);
    }

    public final void handleException(f fVar, Throwable th) {
        LogUtility.d("UPSDataProvider", th + " handled !");
    }
}
