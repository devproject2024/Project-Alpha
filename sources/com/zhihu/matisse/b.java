package com.zhihu.matisse;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.sendbird.android.constant.StringSet;
import com.zhihu.matisse.internal.c.e;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

public enum b {
    JPEG("image/jpeg", arraySetOf("jpg", "jpeg")),
    PNG("image/png", arraySetOf("png")),
    GIF("image/gif", arraySetOf("gif")),
    BMP("image/x-ms-bmp", arraySetOf("bmp")),
    WEBP("image/webp", arraySetOf("webp")),
    MPEG("video/mpeg", arraySetOf("mpeg", "mpg")),
    MP4("video/mp4", arraySetOf("mp4", "m4v")),
    QUICKTIME("video/quicktime", arraySetOf("mov")),
    THREEGPP("video/3gpp", arraySetOf("3gp", "3gpp")),
    THREEGPP2("video/3gpp2", arraySetOf("3g2", "3gpp2")),
    MKV("video/x-matroska", arraySetOf("mkv")),
    WEBM("video/webm", arraySetOf("webm")),
    TS("video/mp2ts", arraySetOf(StringSet.ts)),
    AVI("video/avi", arraySetOf("avi"));
    
    private final Set<String> mExtensions;
    private final String mMimeTypeName;

    private b(String str, Set<String> set) {
        this.mMimeTypeName = str;
        this.mExtensions = set;
    }

    public static Set<b> ofAll() {
        return EnumSet.allOf(b.class);
    }

    public static Set<b> ofImageBut(b bVar) {
        Set<b> ofImage = ofImage();
        ofImage.remove(bVar);
        return ofImage;
    }

    public static Set<b> ofAllBut(b bVar) {
        EnumSet<E> allOf = EnumSet.allOf(b.class);
        allOf.remove(bVar);
        return allOf;
    }

    public static Set<b> of(b bVar, b... bVarArr) {
        return EnumSet.of(bVar, bVarArr);
    }

    public static Set<b> ofImage() {
        return EnumSet.of(JPEG, PNG, GIF, BMP, WEBP);
    }

    public static Set<b> ofImage(boolean z) {
        return EnumSet.of(GIF);
    }

    public static Set<b> ofGif() {
        return ofImage(true);
    }

    public static Set<b> ofVideo() {
        return EnumSet.of(MPEG, new b[]{MP4, QUICKTIME, THREEGPP, THREEGPP2, MKV, WEBM, TS, AVI});
    }

    public static boolean isImage(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(H5ResourceHandlerUtil.IMAGE);
    }

    public static boolean isVideo(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(H5ResourceHandlerUtil.VIDEO);
    }

    public static boolean isGif(String str) {
        if (str == null) {
            return false;
        }
        return str.equals(GIF.toString());
    }

    private static Set<String> arraySetOf(String... strArr) {
        return new androidx.a.b(Arrays.asList(strArr));
    }

    public final String toString() {
        return this.mMimeTypeName;
    }

    public final boolean checkType(ContentResolver contentResolver, Uri uri) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (uri == null) {
            return false;
        }
        String extensionFromMimeType = singleton.getExtensionFromMimeType(contentResolver.getType(uri));
        String str = null;
        boolean z = false;
        for (String next : this.mExtensions) {
            if (next.equals(extensionFromMimeType)) {
                return true;
            }
            if (!z) {
                String a2 = e.a(contentResolver, uri);
                if (!TextUtils.isEmpty(a2)) {
                    a2 = a2.toLowerCase(Locale.US);
                }
                str = a2;
                z = true;
            }
            if (str != null && str.endsWith(next)) {
                return true;
            }
        }
        return false;
    }
}
