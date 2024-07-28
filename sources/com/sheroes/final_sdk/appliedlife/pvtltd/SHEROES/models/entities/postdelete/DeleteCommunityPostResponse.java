package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.postdelete;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;

public class DeleteCommunityPostResponse extends BaseResponse {
    @c(a = "id")
    @a
    private long idOfEntityOrParticipant;

    public long getIdOfEntityOrParticipant() {
        return this.idOfEntityOrParticipant;
    }

    public void setIdOfEntityOrParticipant(long j) {
        this.idOfEntityOrParticipant = j;
    }
}
