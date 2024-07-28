package com.bumptech.glide.load;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f7264a = Charset.forName(AppConstants.UTF_8);

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
