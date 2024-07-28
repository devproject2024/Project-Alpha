package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.a.a;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.squareup.picasso.ab;
import com.squareup.picasso.w;
import i.n;
import java.io.IOException;

final class l extends g {
    l(Context context) {
        super(context);
    }

    public final boolean a(z zVar) {
        return CommunityPostActivity.TYPE_FILE.equals(zVar.f45479d.getScheme());
    }

    public final ab.a a(z zVar, int i2) throws IOException {
        return new ab.a((Bitmap) null, n.a(b(zVar)), w.d.DISK, new a(zVar.f45479d.getPath()).a("Orientation"));
    }
}
