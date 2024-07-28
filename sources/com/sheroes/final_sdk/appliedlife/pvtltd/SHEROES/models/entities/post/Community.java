package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import org.parceler.Parcel;

@Parcel
public class Community extends Post {
    public long id;
    public String imageUrl;
    public boolean isChecked;
    public boolean isFirstOther;
    public boolean isOwner;
    public String name;
    public String thumbImageUrl;
}
