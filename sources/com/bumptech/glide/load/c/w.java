package com.bumptech.glide.load.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.o;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7089a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{CommunityPostActivity.TYPE_FILE, "android.resource", "content"})));

    /* renamed from: b  reason: collision with root package name */
    private final c<Data> f7090b;

    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> a(Uri uri);
    }

    public final /* synthetic */ n.a a(Object obj, int i2, int i3, i iVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), this.f7090b.a(uri));
    }

    public final /* synthetic */ boolean a(Object obj) {
        return f7089a.contains(((Uri) obj).getScheme());
    }

    public w(c<Data> cVar) {
        this.f7090b = cVar;
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f7093a;

        public d(ContentResolver contentResolver) {
            this.f7093a = contentResolver;
        }

        public final com.bumptech.glide.load.a.d<InputStream> a(Uri uri) {
            return new o(this.f7093a, uri);
        }

        public final n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f7092a;

        public b(ContentResolver contentResolver) {
            this.f7092a = contentResolver;
        }

        public final com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.i(this.f7092a, uri);
        }

        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f7091a;

        public a(ContentResolver contentResolver) {
            this.f7091a = contentResolver;
        }

        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public final com.bumptech.glide.load.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.a(this.f7091a, uri);
        }
    }
}
