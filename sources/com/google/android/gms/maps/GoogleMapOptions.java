package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.a.j;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private Boolean f11497a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f11498b;

    /* renamed from: c  reason: collision with root package name */
    private int f11499c = -1;

    /* renamed from: d  reason: collision with root package name */
    private CameraPosition f11500d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f11501e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f11502f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f11503g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f11504h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f11505i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Float n = null;
    private Float o = null;
    private LatLngBounds p = null;
    private Boolean q;

    GoogleMapOptions(byte b2, byte b3, int i2, CameraPosition cameraPosition, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, Float f2, Float f3, LatLngBounds latLngBounds, byte b13) {
        this.f11497a = j.a(b2);
        this.f11498b = j.a(b3);
        this.f11499c = i2;
        this.f11500d = cameraPosition;
        this.f11501e = j.a(b4);
        this.f11502f = j.a(b5);
        this.f11503g = j.a(b6);
        this.f11504h = j.a(b7);
        this.f11505i = j.a(b8);
        this.j = j.a(b9);
        this.k = j.a(b10);
        this.l = j.a(b11);
        this.m = j.a(b12);
        this.n = f2;
        this.o = f3;
        this.p = latLngBounds;
        this.q = j.a(b13);
    }

    public GoogleMapOptions() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x023d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.GoogleMapOptions a(android.content.Context r11, android.util.AttributeSet r12) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x0252
            if (r12 != 0) goto L_0x0007
            goto L_0x0252
        L_0x0007:
            android.content.res.Resources r1 = r11.getResources()
            int[] r2 = com.google.android.gms.maps.R.styleable.MapAttrs
            android.content.res.TypedArray r1 = r1.obtainAttributes(r12, r2)
            com.google.android.gms.maps.GoogleMapOptions r2 = new com.google.android.gms.maps.GoogleMapOptions
            r2.<init>()
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_mapType
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0027
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_mapType
            r4 = -1
            int r3 = r1.getInt(r3, r4)
            r2.f11499c = r3
        L_0x0027:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_zOrderOnTop
            boolean r3 = r1.hasValue(r3)
            r4 = 0
            if (r3 == 0) goto L_0x003c
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_zOrderOnTop
            boolean r3 = r1.getBoolean(r3, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11497a = r3
        L_0x003c:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_useViewLifecycle
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0050
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_useViewLifecycle
            boolean r3 = r1.getBoolean(r3, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11498b = r3
        L_0x0050:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiCompass
            boolean r3 = r1.hasValue(r3)
            r5 = 1
            if (r3 == 0) goto L_0x0065
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiCompass
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11502f = r3
        L_0x0065:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiRotateGestures
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0079
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiRotateGestures
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.j = r3
        L_0x0079:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x008d
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.q = r3
        L_0x008d:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiScrollGestures
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x00a1
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiScrollGestures
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11503g = r3
        L_0x00a1:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiTiltGestures
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x00b5
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiTiltGestures
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11505i = r3
        L_0x00b5:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiZoomGestures
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x00c9
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiZoomGestures
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11504h = r3
        L_0x00c9:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiZoomControls
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x00dd
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiZoomControls
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.f11501e = r3
        L_0x00dd:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_liteMode
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x00f1
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_liteMode
            boolean r3 = r1.getBoolean(r3, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.k = r3
        L_0x00f1:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiMapToolbar
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0105
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_uiMapToolbar
            boolean r3 = r1.getBoolean(r3, r5)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.l = r3
        L_0x0105:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_ambientEnabled
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0119
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_ambientEnabled
            boolean r3 = r1.getBoolean(r3, r4)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.m = r3
        L_0x0119:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraMinZoomPreference
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x012f
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraMinZoomPreference
            r4 = -8388608(0xffffffffff800000, float:-Infinity)
            float r3 = r1.getFloat(r3, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r2.n = r3
        L_0x012f:
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraMinZoomPreference
            boolean r3 = r1.hasValue(r3)
            if (r3 == 0) goto L_0x0145
            int r3 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraMaxZoomPreference
            r4 = 2139095040(0x7f800000, float:Infinity)
            float r3 = r1.getFloat(r3, r4)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r2.o = r3
        L_0x0145:
            r3 = 0
            if (r11 == 0) goto L_0x01d6
            if (r12 != 0) goto L_0x014c
            goto L_0x01d6
        L_0x014c:
            android.content.res.Resources r4 = r11.getResources()
            int[] r5 = com.google.android.gms.maps.R.styleable.MapAttrs
            android.content.res.TypedArray r4 = r4.obtainAttributes(r12, r5)
            int r5 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsSouthWestLatitude
            boolean r5 = r4.hasValue(r5)
            if (r5 == 0) goto L_0x0169
            int r5 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsSouthWestLatitude
            float r5 = r4.getFloat(r5, r3)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L_0x016a
        L_0x0169:
            r5 = r0
        L_0x016a:
            int r6 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsSouthWestLongitude
            boolean r6 = r4.hasValue(r6)
            if (r6 == 0) goto L_0x017d
            int r6 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsSouthWestLongitude
            float r6 = r4.getFloat(r6, r3)
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x017e
        L_0x017d:
            r6 = r0
        L_0x017e:
            int r7 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsNorthEastLatitude
            boolean r7 = r4.hasValue(r7)
            if (r7 == 0) goto L_0x0191
            int r7 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsNorthEastLatitude
            float r7 = r4.getFloat(r7, r3)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            goto L_0x0192
        L_0x0191:
            r7 = r0
        L_0x0192:
            int r8 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsNorthEastLongitude
            boolean r8 = r4.hasValue(r8)
            if (r8 == 0) goto L_0x01a5
            int r8 = com.google.android.gms.maps.R.styleable.MapAttrs_latLngBoundsNorthEastLongitude
            float r8 = r4.getFloat(r8, r3)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            goto L_0x01a6
        L_0x01a5:
            r8 = r0
        L_0x01a6:
            r4.recycle()
            if (r5 == 0) goto L_0x01d6
            if (r6 == 0) goto L_0x01d6
            if (r7 == 0) goto L_0x01d6
            if (r8 != 0) goto L_0x01b2
            goto L_0x01d6
        L_0x01b2:
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            float r5 = r5.floatValue()
            double r9 = (double) r5
            float r5 = r6.floatValue()
            double r5 = (double) r5
            r4.<init>(r9, r5)
            com.google.android.gms.maps.model.LatLng r5 = new com.google.android.gms.maps.model.LatLng
            float r6 = r7.floatValue()
            double r6 = (double) r6
            float r8 = r8.floatValue()
            double r8 = (double) r8
            r5.<init>(r6, r8)
            com.google.android.gms.maps.model.LatLngBounds r6 = new com.google.android.gms.maps.model.LatLngBounds
            r6.<init>(r4, r5)
            goto L_0x01d7
        L_0x01d6:
            r6 = r0
        L_0x01d7:
            r2.p = r6
            if (r11 == 0) goto L_0x024c
            if (r12 != 0) goto L_0x01de
            goto L_0x024c
        L_0x01de:
            android.content.res.Resources r11 = r11.getResources()
            int[] r0 = com.google.android.gms.maps.R.styleable.MapAttrs
            android.content.res.TypedArray r11 = r11.obtainAttributes(r12, r0)
            int r12 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTargetLat
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x01f7
            int r12 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTargetLat
            float r12 = r11.getFloat(r12, r3)
            goto L_0x01f8
        L_0x01f7:
            r12 = 0
        L_0x01f8:
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTargetLng
            boolean r0 = r11.hasValue(r0)
            if (r0 == 0) goto L_0x0207
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTargetLng
            float r0 = r11.getFloat(r0, r3)
            goto L_0x0208
        L_0x0207:
            r0 = 0
        L_0x0208:
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double r5 = (double) r12
            double r7 = (double) r0
            r4.<init>(r5, r7)
            com.google.android.gms.maps.model.CameraPosition$a r12 = com.google.android.gms.maps.model.CameraPosition.a()
            r12.f11563a = r4
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraZoom
            boolean r0 = r11.hasValue(r0)
            if (r0 == 0) goto L_0x0225
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraZoom
            float r0 = r11.getFloat(r0, r3)
            r12.f11564b = r0
        L_0x0225:
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraBearing
            boolean r0 = r11.hasValue(r0)
            if (r0 == 0) goto L_0x0235
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraBearing
            float r0 = r11.getFloat(r0, r3)
            r12.f11566d = r0
        L_0x0235:
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTilt
            boolean r0 = r11.hasValue(r0)
            if (r0 == 0) goto L_0x0245
            int r0 = com.google.android.gms.maps.R.styleable.MapAttrs_cameraTilt
            float r0 = r11.getFloat(r0, r3)
            r12.f11565c = r0
        L_0x0245:
            r11.recycle()
            com.google.android.gms.maps.model.CameraPosition r0 = r12.d()
        L_0x024c:
            r2.f11500d = r0
            r1.recycle()
            return r2
        L_0x0252:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.GoogleMapOptions.a(android.content.Context, android.util.AttributeSet):com.google.android.gms.maps.GoogleMapOptions");
    }

    public final String toString() {
        return q.a((Object) this).a("MapType", Integer.valueOf(this.f11499c)).a("LiteMode", this.k).a("Camera", this.f11500d).a("CompassEnabled", this.f11502f).a("ZoomControlsEnabled", this.f11501e).a("ScrollGesturesEnabled", this.f11503g).a("ZoomGesturesEnabled", this.f11504h).a("TiltGesturesEnabled", this.f11505i).a("RotateGesturesEnabled", this.j).a("ScrollGesturesEnabledDuringRotateOrZoom", this.q).a("MapToolbarEnabled", this.l).a("AmbientEnabled", this.m).a("MinZoomPreference", this.n).a("MaxZoomPreference", this.o).a("LatLngBoundsForCameraTarget", this.p).a("ZOrderOnTop", this.f11497a).a("UseViewLifecycleInFragment", this.f11498b).toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, j.a(this.f11497a));
        b.a(parcel, 3, j.a(this.f11498b));
        b.b(parcel, 4, this.f11499c);
        b.a(parcel, 5, this.f11500d, i2, false);
        b.a(parcel, 6, j.a(this.f11501e));
        b.a(parcel, 7, j.a(this.f11502f));
        b.a(parcel, 8, j.a(this.f11503g));
        b.a(parcel, 9, j.a(this.f11504h));
        b.a(parcel, 10, j.a(this.f11505i));
        b.a(parcel, 11, j.a(this.j));
        b.a(parcel, 12, j.a(this.k));
        b.a(parcel, 14, j.a(this.l));
        b.a(parcel, 15, j.a(this.m));
        b.a(parcel, 16, this.n);
        b.a(parcel, 17, this.o);
        b.a(parcel, 18, this.p, i2, false);
        b.a(parcel, 19, j.a(this.q));
        b.b(parcel, a2);
    }
}
