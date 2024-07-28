package com.google.android.gms.internal.vision;

public final class ia implements hy {

    /* renamed from: a  reason: collision with root package name */
    private static final z<Long> f11234a;

    /* renamed from: b  reason: collision with root package name */
    private static final z<Boolean> f11235b;

    /* renamed from: c  reason: collision with root package name */
    private static final z<Boolean> f11236c;

    /* renamed from: d  reason: collision with root package name */
    private static final z<Boolean> f11237d;

    /* renamed from: e  reason: collision with root package name */
    private static final z<Boolean> f11238e;

    /* renamed from: f  reason: collision with root package name */
    private static final z<Boolean> f11239f;

    /* renamed from: g  reason: collision with root package name */
    private static final z<Boolean> f11240g;

    /* renamed from: h  reason: collision with root package name */
    private static final z<Boolean> f11241h;

    /* renamed from: i  reason: collision with root package name */
    private static final z<Boolean> f11242i;
    private static final z<Boolean> j;
    private static final z<Boolean> k;
    private static final z<Boolean> l;
    private static final z<Long> m;
    private static final z<Long> n;

    public final boolean a() {
        return f11236c.c().booleanValue();
    }

    public final boolean b() {
        return f11240g.c().booleanValue();
    }

    static {
        ad adVar = new ad(w.a("com.google.android.gms.vision.sdk"));
        if (!adVar.f10984e) {
            ad adVar2 = new ad(adVar.f10980a, adVar.f10981b, "vision.sdk:", adVar.f10983d, adVar.f10984e, adVar.f10985f, adVar.f10986g, adVar.f10987h, adVar.f10988i);
            f11234a = z.a(adVar2, "OptionalModule__check_alarm_seconds", 10);
            f11235b = z.a(adVar2, "OptionalModule__enable_barcode_optional_module", false);
            f11236c = z.a(adVar2, "OptionalModule__enable_barcode_optional_module_v25", false);
            f11237d = z.a(adVar2, "OptionalModule__enable_face_optional_module", false);
            f11238e = z.a(adVar2, "OptionalModule__enable_face_optional_module_v25", true);
            f11239f = z.a(adVar2, "OptionalModule__enable_ica_optional_module", false);
            f11240g = z.a(adVar2, "OptionalModule__enable_ica_optional_module_v25", false);
            f11241h = z.a(adVar2, "OptionalModule__enable_ocr_optional_module", false);
            f11242i = z.a(adVar2, "OptionalModule__enable_ocr_optional_module_v25", false);
            j = z.a(adVar2, "OptionalModule__enable_old_download_path", true);
            k = z.a(adVar2, "OptionalModule__enable_optional_module_download_retry", false);
            l = z.a(adVar2, "OptionalModule__enable_progress_listener_for_optional_module_download", false);
            m = z.a(adVar2, "OptionalModule__listener_timeout_in_minutes", 5);
            n = z.a(adVar2, "OptionalModule__max_download_status_pending_count", 5);
            return;
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }
}
