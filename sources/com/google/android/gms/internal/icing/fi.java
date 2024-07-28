package com.google.android.gms.internal.icing;

import android.net.Uri;

public final class fi implements fg {

    /* renamed from: a  reason: collision with root package name */
    private static final x<Boolean> f10231a;

    /* renamed from: b  reason: collision with root package name */
    private static final x<Boolean> f10232b;

    /* renamed from: c  reason: collision with root package name */
    private static final x<Boolean> f10233c;

    /* renamed from: d  reason: collision with root package name */
    private static final x<Boolean> f10234d;

    /* renamed from: e  reason: collision with root package name */
    private static final x<Boolean> f10235e;

    /* renamed from: f  reason: collision with root package name */
    private static final x<Boolean> f10236f;

    /* renamed from: g  reason: collision with root package name */
    private static final x<Boolean> f10237g;

    /* renamed from: h  reason: collision with root package name */
    private static final x<Boolean> f10238h;

    /* renamed from: i  reason: collision with root package name */
    private static final x<Boolean> f10239i;
    private static final x<Boolean> j;
    private static final x<Boolean> k;
    private static final x<Boolean> l;
    private static final x<Boolean> m;
    private static final x<Boolean> n;
    private static final x<Boolean> o;
    private static final x<Boolean> p;
    private static final x<Boolean> q;
    private static final x<Boolean> r;
    private static final x<Boolean> s;
    private static final x<Boolean> t;

    public final boolean a() {
        return f10237g.c().booleanValue();
    }

    static {
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.icing"));
        y yVar = new y(Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/")));
        f10231a = x.a(yVar, "block_action_upload_if_data_sharing_disabled", false);
        f10232b = x.a(yVar, "disable_remove_fanout_for_messaging", true);
        f10233c = x.a(yVar, "disable_update_fanout_for_messaging", true);
        f10234d = x.a(yVar, "enable_accurate_errors_for_validate_corpus_keys", false);
        f10235e = x.a(yVar, "enable_actionsv2_using_unified_indexing", false);
        f10236f = x.a(yVar, "enable_additional_type_for_email", false);
        f10237g = x.a(yVar, "enable_client_grant_slice_permission", true);
        f10238h = x.a(yVar, "gms_icing_corpus_schema_store_as_ground_truth", false);
        f10239i = x.a(yVar, "enable_custom_action_url_generation", false);
        j = x.a(yVar, "enable_failure_response_for_apitask_exceptions", false);
        k = x.a(yVar, "enable_message_section_for_clock_types", false);
        l = x.a(yVar, "enable_on_device_sharing_control_ui", false);
        m = x.a(yVar, "enable_on_device_sharing_control_ui_text_top", false);
        n = x.a(yVar, "enable_safe_app_indexing_package_removal", false);
        o = x.a(yVar, "enable_safe_index_cleanup", true);
        p = x.a(yVar, "enable_slice_authority_validation", false);
        q = x.a(yVar, "enable_st_nary_logical_operator", false);
        r = x.a(yVar, "redirect_user_actions_from_persistent_to_main", false);
        s = x.a(yVar, "type_access_whitelist_enforce_platform_permissions", false);
        t = x.a(yVar, "unified_indexing_request_queue", false);
    }
}
