package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import java.util.Date;
import org.parceler.Parcel;

@Parcel
public class CommunityTab {
    public static final String COMMUNITY_TAB_OBJ = "Community Tab Obj";
    @c(a = "community_id_l")
    public int communityId;
    @c(a = "created_by_l")
    public int createdBy;
    @c(a = "data_html_s")
    public String dataHtml;
    @c(a = "data_url_s")
    public String dataUrl;
    @c(a = "empty_description_s")
    public String emptyDescription;
    @c(a = "empty_image_s")
    public String emptyImageUrl;
    @c(a = "empty_title_s")
    public String emptyTitle;
    @c(a = "fab_icon_s")
    public String fabIconUrl;
    @c(a = "fab_url_s")
    public String fabUrl;
    @c(a = "id")
    public int id;
    @c(a = "p_is_active")
    public boolean isActive;
    @c(a = "key_s")
    public String key;
    @c(a = "p_last_modified_on")
    public Date lastModified;
    @c(a = "last_modified_by_l")
    public int lastModifiedByL;
    @c(a = "p_crdt")
    public Date mCreated;
    @c(a = "min_app_version_code_i")
    public int minAppVersionCode;
    @c(a = "priority_i")
    public int priority;
    @c(a = "show_fab_b")
    public boolean showFabButton;
    @c(a = "title_s")
    public String title;
    @c(a = "type_s")
    public String type;
}
