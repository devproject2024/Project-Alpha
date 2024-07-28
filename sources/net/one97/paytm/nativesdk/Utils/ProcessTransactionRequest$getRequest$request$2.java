package net.one97.paytm.nativesdk.Utils;

import com.android.volley.Response;
import com.android.volley.VolleyError;

final class ProcessTransactionRequest$getRequest$request$2 implements Response.ErrorListener {
    final /* synthetic */ ProcessTransactionRequest this$0;

    ProcessTransactionRequest$getRequest$request$2(ProcessTransactionRequest processTransactionRequest) {
        this.this$0 = processTransactionRequest;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.this$0.getCallback().onErrorResponse(volleyError, null);
    }
}
