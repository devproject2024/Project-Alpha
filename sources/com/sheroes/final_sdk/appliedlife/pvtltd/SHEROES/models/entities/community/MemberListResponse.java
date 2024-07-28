package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.List;

public class MemberListResponse extends BaseResponse {
    @c(a = "members")
    @a
    private List<MembersList> members = null;

    public List<MembersList> getMembers() {
        return this.members;
    }

    public void setMembers(List<MembersList> list) {
        this.members = list;
    }
}
