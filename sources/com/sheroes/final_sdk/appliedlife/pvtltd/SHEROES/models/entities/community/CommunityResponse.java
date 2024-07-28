package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.lang.reflect.Member;
import java.util.List;

public class CommunityResponse extends BaseResponse {
    @c(a = "members")
    @a
    private List<Member> members;
}
