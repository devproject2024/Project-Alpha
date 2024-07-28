package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class SelectedCommunityResponse extends BaseResponse {
    @c(a = "docs")
    @a
    private List<CommunityPostResponse> docs = null;

    public List<CommunityPostResponse> getDocs() {
        return this.docs;
    }

    public void setDocs(List<CommunityPostResponse> list) {
        this.docs = list;
    }
}
