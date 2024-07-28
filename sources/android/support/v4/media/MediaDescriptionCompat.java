package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final String f833a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f834b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f835c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f836d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f837e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f838f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f839g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f840h;

    /* renamed from: i  reason: collision with root package name */
    private Object f841i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f842a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f843b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f844c;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f845d;

        /* renamed from: e  reason: collision with root package name */
        Bitmap f846e;

        /* renamed from: f  reason: collision with root package name */
        Uri f847f;

        /* renamed from: g  reason: collision with root package name */
        Bundle f848g;

        /* renamed from: h  reason: collision with root package name */
        Uri f849h;
    }

    public final int describeContents() {
        return 0;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f833a = str;
        this.f834b = charSequence;
        this.f835c = charSequence2;
        this.f836d = charSequence3;
        this.f837e = bitmap;
        this.f838f = uri;
        this.f839g = bundle;
        this.f840h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f833a = parcel.readString();
        this.f834b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f835c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f836d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.f837e = (Bitmap) parcel.readParcelable(classLoader);
        this.f838f = (Uri) parcel.readParcelable(classLoader);
        this.f839g = parcel.readBundle(classLoader);
        this.f840h = (Uri) parcel.readParcelable(classLoader);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Object obj;
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f833a);
            TextUtils.writeToParcel(this.f834b, parcel, i2);
            TextUtils.writeToParcel(this.f835c, parcel, i2);
            TextUtils.writeToParcel(this.f836d, parcel, i2);
            parcel.writeParcelable(this.f837e, i2);
            parcel.writeParcelable(this.f838f, i2);
            parcel.writeBundle(this.f839g);
            parcel.writeParcelable(this.f840h, i2);
            return;
        }
        if (this.f841i != null || Build.VERSION.SDK_INT < 21) {
            obj = this.f841i;
        } else {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f833a);
            builder.setTitle(this.f834b);
            builder.setSubtitle(this.f835c);
            builder.setDescription(this.f836d);
            builder.setIconBitmap(this.f837e);
            builder.setIconUri(this.f838f);
            Bundle bundle = this.f839g;
            if (Build.VERSION.SDK_INT < 23 && this.f840h != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f840h);
            }
            builder.setExtras(bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.f840h);
            }
            this.f841i = builder.build();
            obj = this.f841i;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i2);
    }

    public final String toString() {
        return this.f834b + ", " + this.f835c + ", " + this.f836d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r11) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x008c
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x008c
            android.support.v4.media.MediaDescriptionCompat$a r1 = new android.support.v4.media.MediaDescriptionCompat$a
            r1.<init>()
            r2 = r11
            android.media.MediaDescription r2 = (android.media.MediaDescription) r2
            java.lang.String r3 = r2.getMediaId()
            r1.f842a = r3
            java.lang.CharSequence r3 = r2.getTitle()
            r1.f843b = r3
            java.lang.CharSequence r3 = r2.getSubtitle()
            r1.f844c = r3
            java.lang.CharSequence r3 = r2.getDescription()
            r1.f845d = r3
            android.graphics.Bitmap r3 = r2.getIconBitmap()
            r1.f846e = r3
            android.net.Uri r3 = r2.getIconUri()
            r1.f847f = r3
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x0047
            android.support.v4.media.session.MediaSessionCompat.a(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x0048
        L_0x0047:
            r5 = r0
        L_0x0048:
            if (r5 == 0) goto L_0x0060
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x005a
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x005a
            goto L_0x0061
        L_0x005a:
            r3.remove(r4)
            r3.remove(r6)
        L_0x0060:
            r0 = r3
        L_0x0061:
            r1.f848g = r0
            if (r5 == 0) goto L_0x0068
            r1.f849h = r5
            goto L_0x0074
        L_0x0068:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r0 < r3) goto L_0x0074
            android.net.Uri r0 = r2.getMediaUri()
            r1.f849h = r0
        L_0x0074:
            android.support.v4.media.MediaDescriptionCompat r0 = new android.support.v4.media.MediaDescriptionCompat
            java.lang.String r3 = r1.f842a
            java.lang.CharSequence r4 = r1.f843b
            java.lang.CharSequence r5 = r1.f844c
            java.lang.CharSequence r6 = r1.f845d
            android.graphics.Bitmap r7 = r1.f846e
            android.net.Uri r8 = r1.f847f
            android.os.Bundle r9 = r1.f848g
            android.net.Uri r10 = r1.f849h
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r0.f841i = r11
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
