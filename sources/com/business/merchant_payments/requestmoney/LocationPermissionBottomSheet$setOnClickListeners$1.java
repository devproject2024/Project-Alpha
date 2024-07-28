package com.business.merchant_payments.requestmoney;

import android.view.View;
import com.business.merchant_payments.requestmoney.LocationPermissionBottomSheet;
import kotlin.g.b.k;

public final class LocationPermissionBottomSheet$setOnClickListeners$1 implements View.OnClickListener {
    public final /* synthetic */ LocationPermissionBottomSheet this$0;

    public LocationPermissionBottomSheet$setOnClickListeners$1(LocationPermissionBottomSheet locationPermissionBottomSheet) {
        this.this$0 = locationPermissionBottomSheet;
    }

    public final void onClick(View view) {
        if (this.this$0.iShowLocationPrompt != null) {
            LocationPermissionBottomSheet.IShowLocationPrompt access$getIShowLocationPrompt$p = this.this$0.iShowLocationPrompt;
            k.a((Object) access$getIShowLocationPrompt$p);
            access$getIShowLocationPrompt$p.showLocationPrompt();
        } else {
            this.this$0.showLocationPrompt();
        }
        this.this$0.dismiss();
    }
}
