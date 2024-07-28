package com.bumptech.glide.load.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.InputStream;

public final class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6978a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f6979b;

    /* renamed from: c  reason: collision with root package name */
    private final C0096a<Data> f6980c;

    /* renamed from: com.bumptech.glide.load.c.a$a  reason: collision with other inner class name */
    public interface C0096a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), this.f6980c.a(this.f6979b, uri.toString().substring(f6978a)));
    }

    public final /* synthetic */ boolean a(Object obj) {
        Uri uri = (Uri) obj;
        if (!CommunityPostActivity.TYPE_FILE.equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public a(AssetManager assetManager, C0096a<Data> aVar) {
        this.f6979b = assetManager;
        this.f6980c = aVar;
    }

    public static class c implements C0096a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f6987a;

        public c(AssetManager assetManager) {
            this.f6987a = assetManager;
        }

        public final n<Uri, InputStream> a(r rVar) {
            return new a(this.f6987a, this);
        }

        public final d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.a.n(assetManager, str);
        }
    }

    public static class b implements C0096a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f6984a;

        public b(AssetManager assetManager) {
            this.f6984a = assetManager;
        }

        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f6984a, this);
        }

        public final d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }
    }
}
