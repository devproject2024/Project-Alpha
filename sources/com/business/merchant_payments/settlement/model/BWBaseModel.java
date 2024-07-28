package com.business.merchant_payments.settlement.model;

import com.business.merchant_payments.model.BaseModel;

public abstract class BWBaseModel extends BaseModel {
    public boolean showEntryAnimation;

    public boolean getShowEntryAnimation() {
        return this.showEntryAnimation;
    }

    public void setShowEntryAnimation(boolean z) {
        this.showEntryAnimation = z;
    }
}
