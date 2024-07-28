package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.drm.g;
import java.util.Map;

public interface h<T extends g> {

    public static final class a {
    }

    public static final class b {
    }

    byte[] a() throws MediaDrmException;

    a b() throws NotProvisionedException;

    byte[] c() throws NotProvisionedException, DeniedByServerException;

    b d();

    Map<String, String> e();

    T f() throws MediaCryptoException;
}
