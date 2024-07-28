package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.miscellanous;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class ApproveSpamPostRequest extends BaseRequest {
    @c(a = "id")
    @a
    private Long id;
    @c(a = "is_active")
    @a
    private boolean isActive = true;
    @c(a = "is_approved")
    @a
    private boolean isApproved;
    @c(a = "is_spam")
    @a
    private boolean isSpam;

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public boolean isSpam() {
        return this.isSpam;
    }

    public void setSpam(boolean z) {
        this.isSpam = z;
    }

    public boolean isApproved() {
        return this.isApproved;
    }

    public void setApproved(boolean z) {
        this.isApproved = z;
    }
}
