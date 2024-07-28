package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserBO;
import org.parceler.Parcel;

@Parcel
public class Post {
    public static final String FEED_OBJ = "FEED_OBJ";
    public UserBO author;
    public String body;
    public String createdAt;
    public int remote_id;
    public String title;
    public String updatedAt;
}
