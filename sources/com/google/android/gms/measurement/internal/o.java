package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.alipay.mobile.nebula.filecache.FileCache;
import com.google.android.gms.internal.measurement.ap;
import com.google.android.gms.internal.measurement.be;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class o {
    public static dn<Long> A = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, aj.f11698a);
    public static dn<Long> B = a("measurement.upload.retry_time", 1800000L, 1800000L, am.f11701a);
    public static dn<Integer> C = a("measurement.upload.retry_count", 6, 6, al.f11700a);
    public static dn<Long> D = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, ao.f11703a);
    public static dn<Integer> E = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, aq.f11705a);
    public static dn<Integer> F = a("measurement.audience.filter_result_max_count", 200, 200, ap.f11704a);
    public static dn<Long> G = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, as.f11707a);
    public static dn<Boolean> H;
    public static dn<String> I = a("measurement.test.string_flag", "---", "---", au.f11709a);
    public static dn<Long> J = a("measurement.test.long_flag", -1L, -1L, at.f11708a);
    public static dn<Integer> K = a("measurement.test.int_flag", -2, -2, aw.f11711a);
    public static dn<Double> L;
    public static dn<Integer> M = a("measurement.experiment.max_ids", 50, 50, ay.f11713a);
    public static dn<Boolean> N;
    public static dn<Boolean> O;
    public static dn<Boolean> P;
    public static dn<Boolean> Q;
    public static dn<Boolean> R;
    public static dn<Boolean> S;
    public static dn<Boolean> T;
    public static dn<Boolean> U;
    public static dn<Boolean> V;
    public static dn<Boolean> W;
    public static dn<Boolean> X;
    public static dn<Boolean> Y;
    public static dn<Boolean> Z;

    /* renamed from: a  reason: collision with root package name */
    public static dn<Boolean> f12346a;
    public static dn<Boolean> aA;
    public static dn<Boolean> aB;
    public static dn<Boolean> aC;
    public static dn<Boolean> aD;
    public static dn<Boolean> aE;
    public static dn<Boolean> aF;
    public static dn<Boolean> aG;
    public static dn<Boolean> aH;
    public static dn<Boolean> aI;
    public static dn<Boolean> aJ;
    public static dn<Boolean> aK;
    public static dn<Boolean> aL;
    public static dn<Boolean> aM;
    public static dn<Boolean> aN;
    public static dn<Boolean> aO;
    public static dn<Boolean> aP;
    public static dn<Boolean> aQ;
    /* access modifiers changed from: private */
    public static List<dn<?>> aR = Collections.synchronizedList(new ArrayList());
    private static Set<dn<?>> aS = Collections.synchronizedSet(new HashSet());
    private static dn<Boolean> aT;
    private static dn<Boolean> aU;
    public static dn<Boolean> aa;
    public static dn<Boolean> ab;
    public static dn<Boolean> ac;
    public static dn<Boolean> ad;
    public static dn<Boolean> ae;
    public static dn<Boolean> af;
    public static dn<Boolean> ag;
    public static dn<Boolean> ah;
    public static dn<Boolean> ai;
    public static dn<Boolean> aj;
    public static dn<Boolean> ak;
    public static dn<Boolean> al;
    public static dn<Boolean> am;
    public static dn<Boolean> an;
    public static dn<Boolean> ao;
    public static dn<Boolean> ap;
    public static dn<Boolean> aq;
    public static dn<Boolean> ar;
    public static dn<Boolean> as;
    public static dn<Boolean> at;
    public static dn<Boolean> au;
    public static dn<Boolean> av;
    public static dn<Boolean> aw;
    public static dn<Boolean> ax;
    public static dn<Boolean> ay;
    public static dn<Boolean> az;

    /* renamed from: b  reason: collision with root package name */
    public static dn<Long> f12347b = a("measurement.ad_id_cache_time", 10000L, 10000L, q.f12355a);

    /* renamed from: c  reason: collision with root package name */
    public static dn<Long> f12348c = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, ae.f11693a);

    /* renamed from: d  reason: collision with root package name */
    public static dn<Long> f12349d = a("measurement.config.cache_time", 86400000L, 3600000L, an.f11702a);

    /* renamed from: e  reason: collision with root package name */
    public static dn<String> f12350e = a("measurement.config.url_scheme", "https", "https", bb.f11718a);

    /* renamed from: f  reason: collision with root package name */
    public static dn<String> f12351f = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", bk.f11727a);

    /* renamed from: g  reason: collision with root package name */
    public static dn<Integer> f12352g = a("measurement.upload.max_bundles", 100, 100, bx.f11740a);

    /* renamed from: h  reason: collision with root package name */
    public static dn<Integer> f12353h = a("measurement.upload.max_batch_size", 65536, 65536, ch.f11757a);

    /* renamed from: i  reason: collision with root package name */
    public static dn<Integer> f12354i = a("measurement.upload.max_bundle_size", 65536, 65536, cu.f11770a);
    public static dn<Integer> j = a("measurement.upload.max_events_per_bundle", 1000, 1000, de.f11788a);
    public static dn<Integer> k = a("measurement.upload.max_events_per_day", 100000, 100000, t.f12358a);
    public static dn<Integer> l = a("measurement.upload.max_error_events_per_day", 1000, 1000, s.f12357a);
    public static dn<Integer> m;
    public static dn<Integer> n = a("measurement.upload.max_conversions_per_day", 500, 500, u.f12359a);
    public static dn<Integer> o = a("measurement.upload.max_realtime_events_per_day", 10, 10, x.f12362a);
    public static dn<Integer> p = a("measurement.store.max_stored_events_per_app", 100000, 100000, w.f12361a);
    public static dn<String> q = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", aa.f11689a);
    public static dn<Long> r = a("measurement.upload.backoff_period", 43200000L, 43200000L, y.f12363a);
    public static dn<Long> s = a("measurement.upload.window_interval", 3600000L, 3600000L, ac.f11691a);
    public static dn<Long> t = a("measurement.upload.interval", 3600000L, 3600000L, ab.f11690a);
    public static dn<Long> u = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, ad.f11692a);
    public static dn<Long> v = a("measurement.upload.debug_upload_interval", 1000L, 1000L, ag.f11695a);
    public static dn<Long> w = a("measurement.upload.minimum_delay", 500L, 500L, af.f11694a);
    public static dn<Long> x = a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, ai.f11697a);
    public static dn<Long> y = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, ah.f11696a);
    public static dn<Long> z;

    public static Map<String, String> a(Context context) {
        ap a2 = ap.a(context.getContentResolver(), be.a("com.google.android.gms.measurement"));
        return a2 == null ? Collections.emptyMap() : a2.a();
    }

    private static <V> dn<V> a(String str, V v2, V v3, dm<V> dmVar) {
        dn dnVar = new dn(str, v2, v3, dmVar, (byte) 0);
        aR.add(dnVar);
        return dnVar;
    }

    static {
        Boolean bool = Boolean.TRUE;
        f12346a = a("measurement.upload_dsid_enabled", bool, bool, r.f12356a);
        Integer valueOf = Integer.valueOf(AppConstants.NOT_TIME);
        m = a("measurement.upload.max_public_events_per_day", valueOf, valueOf, v.f12360a);
        Long valueOf2 = Long.valueOf(FileCache.EXPIRE_TIME);
        z = a("measurement.upload.refresh_blacklisted_config_interval", valueOf2, valueOf2, ak.f11699a);
        Boolean bool2 = Boolean.FALSE;
        H = a("measurement.test.boolean_flag", bool2, bool2, ar.f11706a);
        Double valueOf3 = Double.valueOf(-3.0d);
        L = a("measurement.test.double_flag", valueOf3, valueOf3, av.f11710a);
        Boolean bool3 = Boolean.FALSE;
        N = a("measurement.validation.internal_limits_internal_event_params", bool3, bool3, ax.f11712a);
        Boolean bool4 = Boolean.FALSE;
        O = a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", bool4, bool4, az.f11714a);
        Boolean bool5 = Boolean.TRUE;
        P = a("measurement.client.sessions.session_id_enabled", bool5, bool5, bd.f11720a);
        Boolean bool6 = Boolean.TRUE;
        Q = a("measurement.service.sessions.session_number_enabled", bool6, bool6, bc.f11719a);
        Boolean bool7 = Boolean.TRUE;
        R = a("measurement.client.sessions.background_sessions_enabled", bool7, bool7, bf.f11722a);
        Boolean bool8 = Boolean.TRUE;
        S = a("measurement.client.sessions.remove_expired_session_properties_enabled", bool8, bool8, be.f11721a);
        Boolean bool9 = Boolean.TRUE;
        T = a("measurement.service.sessions.session_number_backfill_enabled", bool9, bool9, bh.f11724a);
        Boolean bool10 = Boolean.TRUE;
        U = a("measurement.service.sessions.remove_disabled_session_number", bool10, bool10, bg.f11723a);
        Boolean bool11 = Boolean.TRUE;
        V = a("measurement.client.sessions.start_session_before_view_screen", bool11, bool11, bj.f11726a);
        Boolean bool12 = Boolean.TRUE;
        W = a("measurement.client.sessions.check_on_startup", bool12, bool12, bi.f11725a);
        Boolean bool13 = Boolean.TRUE;
        X = a("measurement.collection.firebase_global_collection_flag_enabled", bool13, bool13, bl.f11728a);
        Boolean bool14 = Boolean.FALSE;
        Y = a("measurement.collection.efficient_engagement_reporting_enabled", bool14, bool14, bn.f11730a);
        Boolean bool15 = Boolean.FALSE;
        Z = a("measurement.collection.redundant_engagement_removal_enabled", bool15, bool15, bm.f11729a);
        Boolean bool16 = Boolean.TRUE;
        aa = a("measurement.personalized_ads_signals_collection_enabled", bool16, bool16, bp.f11732a);
        Boolean bool17 = Boolean.TRUE;
        ab = a("measurement.personalized_ads_property_translation_enabled", bool17, bool17, bo.f11731a);
        Boolean bool18 = Boolean.TRUE;
        ac = a("measurement.upload.disable_is_uploader", bool18, bool18, br.f11734a);
        Boolean bool19 = Boolean.TRUE;
        ad = a("measurement.experiment.enable_experiment_reporting", bool19, bool19, bq.f11733a);
        Boolean bool20 = Boolean.TRUE;
        ae = a("measurement.collection.log_event_and_bundle_v2", bool20, bool20, bt.f11736a);
        Boolean bool21 = Boolean.FALSE;
        af = a("measurement.quality.checksum", bool21, bool21, (dm) null);
        Boolean bool22 = Boolean.TRUE;
        ag = a("measurement.module.collection.conditionally_omit_admob_app_id", bool22, bool22, bs.f11735a);
        Boolean bool23 = Boolean.FALSE;
        ah = a("measurement.sdk.dynamite.use_dynamite2", bool23, bool23, bv.f11738a);
        Boolean bool24 = Boolean.FALSE;
        ai = a("measurement.sdk.dynamite.allow_remote_dynamite", bool24, bool24, bu.f11737a);
        Boolean bool25 = Boolean.FALSE;
        aj = a("measurement.sdk.collection.validate_param_names_alphabetical", bool25, bool25, bw.f11739a);
        Boolean bool26 = Boolean.TRUE;
        ak = a("measurement.collection.event_safelist", bool26, bool26, bz.f11742a);
        Boolean bool27 = Boolean.FALSE;
        al = a("measurement.service.audience.scoped_filters_v27", bool27, bool27, by.f11741a);
        Boolean bool28 = Boolean.FALSE;
        am = a("measurement.service.audience.session_scoped_event_aggregates", bool28, bool28, cc.f11752a);
        Boolean bool29 = Boolean.FALSE;
        an = a("measurement.service.audience.session_scoped_user_engagement", bool29, bool29, ca.f11748a);
        Boolean bool30 = Boolean.TRUE;
        ao = a("measurement.service.audience.scoped_engagement_removal_when_session_expired", bool30, bool30, ce.f11754a);
        Boolean bool31 = Boolean.TRUE;
        ap = a("measurement.client.audience.scoped_engagement_removal_when_session_expired", bool31, bool31, cd.f11753a);
        Boolean bool32 = Boolean.FALSE;
        aq = a("measurement.service.audience.remove_disabled_session_scoped_user_engagement", bool32, bool32, cg.f11756a);
        Boolean bool33 = Boolean.FALSE;
        ar = a("measurement.service.audience.use_bundle_timestamp_for_property_filters", bool33, bool33, cf.f11755a);
        Boolean bool34 = Boolean.FALSE;
        as = a("measurement.service.audience.fix_prepending_previous_sequence_timestamp", bool34, bool34, ci.f11758a);
        Boolean bool35 = Boolean.FALSE;
        aT = a("measurement.service.audience.invalidate_config_cache_after_app_unisntall", bool35, bool35, ck.f11760a);
        Boolean bool36 = Boolean.TRUE;
        at = a("measurement.service.audience.fix_skip_audience_with_failed_filters", bool36, bool36, cj.f11759a);
        Boolean bool37 = Boolean.TRUE;
        au = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool37, bool37, cm.f11762a);
        Boolean bool38 = Boolean.FALSE;
        av = a("measurement.app_launch.event_ordering_fix", bool38, bool38, cl.f11761a);
        Boolean bool39 = Boolean.FALSE;
        aw = a("measurement.sdk.collection.last_deep_link_referrer", bool39, bool39, co.f11764a);
        Boolean bool40 = Boolean.FALSE;
        ax = a("measurement.sdk.collection.last_deep_link_referrer_campaign", bool40, bool40, cn.f11763a);
        Boolean bool41 = Boolean.FALSE;
        ay = a("measurement.sdk.collection.last_gclid_from_referrer", bool41, bool41, cq.f11766a);
        Boolean bool42 = Boolean.TRUE;
        az = a("measurement.sdk.collection.worker_thread_referrer", bool42, bool42, cp.f11765a);
        Boolean bool43 = Boolean.FALSE;
        aA = a("measurement.upload.file_lock_state_check", bool43, bool43, cs.f11768a);
        Boolean bool44 = Boolean.TRUE;
        aB = a("measurement.sampling.calculate_bundle_timestamp_before_sampling", bool44, bool44, cr.f11767a);
        Boolean bool45 = Boolean.FALSE;
        aC = a("measurement.ga.ga_app_id", bool45, bool45, ct.f11769a);
        Boolean bool46 = Boolean.FALSE;
        aD = a("measurement.lifecycle.app_backgrounded_tracking", bool46, bool46, cw.f11772a);
        Boolean bool47 = Boolean.FALSE;
        aE = a("measurement.lifecycle.app_in_background_parameter", bool47, bool47, cv.f11771a);
        Boolean bool48 = Boolean.FALSE;
        aF = a("measurement.integration.disable_firebase_instance_id", bool48, bool48, cy.f11774a);
        Boolean bool49 = Boolean.FALSE;
        aG = a("measurement.lifecycle.app_backgrounded_engagement", bool49, bool49, cx.f11773a);
        Boolean bool50 = Boolean.FALSE;
        aH = a("measurement.service.fix_gmp_version", bool50, bool50, da.f11784a);
        Boolean bool51 = Boolean.FALSE;
        aI = a("measurement.collection.service.update_with_analytics_fix", bool51, bool51, cz.f11775a);
        Boolean bool52 = Boolean.FALSE;
        aJ = a("measurement.service.disable_install_state_reporting", bool52, bool52, dd.f11787a);
        Boolean bool53 = Boolean.FALSE;
        aK = a("measurement.service.use_appinfo_modified", bool53, bool53, db.f11785a);
        Boolean bool54 = Boolean.TRUE;
        aU = a("measurement.upload.dsid_reflection_failure_logging", bool54, bool54, df.f11789a);
        Boolean bool55 = Boolean.TRUE;
        aL = a("measurement.client.firebase_feature_rollout.v1.enable", bool55, bool55, dh.f11791a);
        Boolean bool56 = Boolean.FALSE;
        aM = a("measurement.client.sessions.check_on_reset_and_enable", bool56, bool56, dg.f11790a);
        Boolean bool57 = Boolean.FALSE;
        aN = a("measurement.config.string.always_update_disk_on_set", bool57, bool57, dj.f11793a);
        Boolean bool58 = Boolean.FALSE;
        aO = a("measurement.scheduler.task_thread.cleanup_on_exit", bool58, bool58, di.f11792a);
        Boolean bool59 = Boolean.FALSE;
        aP = a("measurement.upload.file_truncate_fix", bool59, bool59, dl.f11795a);
        Boolean bool60 = Boolean.TRUE;
        aQ = a("measurement.lifecycle.app_background_timestamp_when_backgrounded", bool60, bool60, dk.f11794a);
    }
}
