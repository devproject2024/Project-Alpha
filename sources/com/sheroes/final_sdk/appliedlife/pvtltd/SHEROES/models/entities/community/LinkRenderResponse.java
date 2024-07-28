package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;

public class LinkRenderResponse extends BaseResponse {
    @c(a = "is_og_video_link_b")
    @a
    private boolean isOgVideoLinkB;
    @c(a = "og_description_s")
    @a
    private String ogDescriptionS;
    @c(a = "og_image_url_s")
    @a
    private String ogImageUrlS;
    @c(a = "og_requested_url_s")
    @a
    private String ogRequestedUrlS;
    @c(a = "og_title_s")
    @a
    private String ogTitleS;

    public boolean isOgVideoLinkB() {
        return this.isOgVideoLinkB;
    }

    public void setOgVideoLinkB(boolean z) {
        this.isOgVideoLinkB = z;
    }

    public String getOgDescriptionS() {
        return this.ogDescriptionS;
    }

    public void setOgDescriptionS(String str) {
        this.ogDescriptionS = str;
    }

    public String getOgImageUrlS() {
        return this.ogImageUrlS;
    }

    public void setOgImageUrlS(String str) {
        this.ogImageUrlS = str;
    }

    public String getOgRequestedUrlS() {
        return this.ogRequestedUrlS;
    }

    public void setOgRequestedUrlS(String str) {
        this.ogRequestedUrlS = str;
    }

    public String getOgTitleS() {
        return this.ogTitleS;
    }

    public void setOgTitleS(String str) {
        this.ogTitleS = str;
    }
}
