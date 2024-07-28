package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import java.io.File;
import org.parceler.Parcel;

@Parcel
public class Photo extends Post {
    public File file;
    public boolean isNew;
    public String url;
}
