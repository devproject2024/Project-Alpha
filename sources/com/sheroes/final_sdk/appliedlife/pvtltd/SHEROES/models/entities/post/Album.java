package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import java.util.ArrayList;
import org.parceler.Parcel;

@Parcel
public class Album extends Post {
    public static final String ALBUM_OBJ = "ALBUM_OBJ";
    public String deepLinkUrl;
    public ArrayList<Photo> photos = new ArrayList<>();
}
