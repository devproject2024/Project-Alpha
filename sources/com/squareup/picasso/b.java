package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import i.n;
import java.io.IOException;

final class b extends ab {

    /* renamed from: a  reason: collision with root package name */
    private static final int f45389a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final Context f45390b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f45391c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private AssetManager f45392d;

    b(Context context) {
        this.f45390b = context;
    }

    public final boolean a(z zVar) {
        Uri uri = zVar.f45479d;
        if (!CommunityPostActivity.TYPE_FILE.equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public final ab.a a(z zVar, int i2) throws IOException {
        if (this.f45392d == null) {
            synchronized (this.f45391c) {
                if (this.f45392d == null) {
                    this.f45392d = this.f45390b.getAssets();
                }
            }
        }
        return new ab.a(n.a(this.f45392d.open(zVar.f45479d.toString().substring(f45389a))), w.d.DISK);
    }
}
