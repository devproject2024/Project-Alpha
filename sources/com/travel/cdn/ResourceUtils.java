package com.travel.cdn;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.utility.b.b.b;
import com.paytm.utility.b.b.c;
import com.paytm.utility.q;
import com.travel.common.R;
import com.travel.utils.n;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.ExtensionsKt;

public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = new ResourceUtils();
    private static String LOG_TAG = "ResourceUtils";

    private ResourceUtils() {
    }

    public final String getLOG_TAG() {
        return LOG_TAG;
    }

    public final void setLOG_TAG(String str) {
        k.c(str, "<set-?>");
        LOG_TAG = str;
    }

    public static /* synthetic */ void loadBusImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadBusImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadBusImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String a2 = n.a();
        if (z2) {
            n nVar2 = n.f28540a;
            a2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, a2, aVar);
    }

    public static /* synthetic */ void loadCityBusImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadCityBusImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadCityBusImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String b2 = n.b();
        if (z2) {
            n nVar2 = n.f28540a;
            b2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, b2, aVar);
    }

    public static /* synthetic */ void loadTrainImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadTrainImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadTrainImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String d2 = n.d();
        if (z2) {
            n nVar2 = n.f28540a;
            d2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, d2, aVar);
    }

    public static /* synthetic */ void loadFlightImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadFlightImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadFlightImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String c2 = n.c();
        if (z2) {
            n nVar2 = n.f28540a;
            c2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, c2, aVar);
    }

    public static /* synthetic */ void loadTPassImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadTPassImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadTPassImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String e2 = n.e();
        if (z2) {
            n nVar2 = n.f28540a;
            e2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, e2, aVar);
    }

    public static /* synthetic */ void loadTCoreImagesFromCDN$default(ImageView imageView, String str, boolean z, boolean z2, n.a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            aVar = n.a.V1;
        }
        loadTCoreImagesFromCDN(imageView, str, z, z2, aVar);
    }

    public static final void loadTCoreImagesFromCDN(ImageView imageView, String str, boolean z, boolean z2, n.a aVar) {
        k.c(str, "imageName");
        k.c(aVar, "version");
        if (imageView == null) {
            k.a();
        }
        imageView.getContext();
        n nVar = n.f28540a;
        String f2 = n.f();
        if (z2) {
            n nVar2 = n.f28540a;
            f2 = n.g();
        }
        loadImagesFromCDN(imageView, str, z, f2, aVar);
    }

    private static final void loadImagesFromCDN(ImageView imageView, String str, boolean z, String str2, n.a aVar) {
        if (imageView == null) {
            k.a();
        }
        Context context = imageView.getContext();
        k.a((Object) context, "context");
        String string = context.getResources().getString(R.string.cdn_base_url);
        k.a((Object) string, "context.resources.getString(R.string.cdn_base_url)");
        loadPNGImagesFromCDN(imageView, INSTANCE.getCDNUrl(context, z, str2, str, aVar, string));
    }

    public static final void loadImagesFromCDNStage(ImageView imageView, String str, boolean z, String str2, n.a aVar, String str3) {
        k.c(str, "imageName");
        k.c(str2, "vertical");
        k.c(aVar, "version");
        k.c(str3, H5Param.HOST);
        if (imageView == null) {
            k.a();
        }
        Context context = imageView.getContext();
        ResourceUtils resourceUtils = INSTANCE;
        k.a((Object) context, "context");
        loadPNGImagesFromCDN(imageView, resourceUtils.getCDNUrl(context, z, str2, str, aVar, str3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r3 = (r3 = (r3 = r4.getContext()).getResources()).getDisplayMetrics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void loadPNGImagesFromCDN(android.widget.ImageView r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0014
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.m.l r2 = new kotlin.m.l
            java.lang.String r3 = " "
            r2.<init>((java.lang.String) r3)
            java.lang.String r3 = "%20"
            java.lang.String r1 = r2.replace((java.lang.CharSequence) r1, (java.lang.String) r3)
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "loading image "
            java.lang.String r2 = r3.concat(r2)
            com.paytm.utility.q.d(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = " dimen : "
            r2.<init>(r3)
            if (r4 == 0) goto L_0x0044
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L_0x0044
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0044
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            if (r3 == 0) goto L_0x0044
            int r3 = r3.widthPixels
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0045
        L_0x0044:
            r3 = r0
        L_0x0045:
            r2.append(r3)
            java.lang.String r3 = " x "
            r2.append(r3)
            if (r4 == 0) goto L_0x0068
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L_0x0068
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0068
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            if (r3 == 0) goto L_0x0068
            int r3 = r3.heightPixels
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0069
        L_0x0068:
            r3 = r0
        L_0x0069:
            r2.append(r3)
            java.lang.String r3 = " density : "
            r2.append(r3)
            if (r4 == 0) goto L_0x008c
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L_0x008c
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x008c
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            if (r3 == 0) goto L_0x008c
            float r3 = r3.density
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            goto L_0x008d
        L_0x008c:
            r3 = r0
        L_0x008d:
            r2.append(r3)
            java.lang.String r3 = " density dpi "
            r2.append(r3)
            if (r4 == 0) goto L_0x00b0
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L_0x00b0
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x00b0
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            if (r3 == 0) goto L_0x00b0
            int r3 = r3.densityDpi
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00b1
        L_0x00b0:
            r3 = r0
        L_0x00b1:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.paytm.utility.q.d(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "imageview height "
            r2.<init>(r3)
            if (r4 == 0) goto L_0x00cd
            int r3 = r4.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ce
        L_0x00cd:
            r3 = r0
        L_0x00ce:
            r2.append(r3)
            java.lang.String r3 = " width "
            r2.append(r3)
            if (r4 == 0) goto L_0x00e1
            int r3 = r4.getWidth()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00e2
        L_0x00e1:
            r3 = r0
        L_0x00e2:
            r2.append(r3)
            java.lang.String r3 = " url "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.paytm.utility.q.d(r2)
            com.paytm.utility.b.b$a r2 = com.paytm.utility.b.b.f43744a
            if (r4 == 0) goto L_0x00fc
            android.content.Context r0 = r4.getContext()
        L_0x00fc:
            if (r0 != 0) goto L_0x0101
            kotlin.g.b.k.a()
        L_0x0101:
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "imageView?.context!!.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)
            r0.f43753a = r1
            com.paytm.utility.b.b.d r1 = com.paytm.utility.b.b.d.PREFER_RGB_565
            com.paytm.utility.b.b$a$a r0 = r0.a((com.paytm.utility.b.b.d) r1)
            com.paytm.utility.b.b.a r1 = com.paytm.utility.b.b.a.RESOURCE_DISK_CACHE
            com.paytm.utility.b.b$a$a r0 = r0.a((com.paytm.utility.b.b.a) r1)
            r1 = 1
            r0.p = r1
            r0.o = r1
            com.travel.cdn.ResourceUtils$a r1 = new com.travel.cdn.ResourceUtils$a
            r1.<init>(r5)
            com.paytm.utility.b.b.b r1 = (com.paytm.utility.b.b.b) r1
            r0.a((android.widget.ImageView) r4, (com.paytm.utility.b.b.b<?>) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.cdn.ResourceUtils.loadPNGImagesFromCDN(android.widget.ImageView, java.lang.String):void");
    }

    public static final class a implements b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f23033a;

        a(String str) {
            this.f23033a = str;
        }

        public final void onError(Exception exc) {
            q.d(" png loading failed for image url " + this.f23033a);
        }

        public final /* synthetic */ void onSuccess(Object obj, c cVar) {
            q.d(" png loading success for image url " + this.f23033a);
        }
    }

    private final String getCDNUrl(Context context, boolean z, String str, String str2, n.a aVar, String str3) {
        try {
            Uri.Builder buildUpon = Uri.parse(str3).buildUpon();
            buildUpon.appendEncodedPath(ExtensionsKt.nameToLowercase(aVar));
            if (z) {
                buildUpon.appendEncodedPath("vector");
                buildUpon.appendEncodedPath(str);
                buildUpon.appendEncodedPath(str2);
                String uri = buildUpon.build().toString();
                k.a((Object) uri, "builder.build().toString()");
                return uri;
            }
            buildUpon.appendEncodedPath("non-vector");
            buildUpon.appendEncodedPath(str);
            buildUpon.appendEncodedPath(getDensityName(context));
            buildUpon.appendEncodedPath(str2);
            String uri2 = buildUpon.build().toString();
            k.a((Object) uri2, "builder.build().toString()");
            return uri2;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str3;
        }
    }

    public final String getDensityName(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.travel_cdn_denstiy);
        k.a((Object) string, "context.getString(R.string.travel_cdn_denstiy)");
        return string;
    }
}
