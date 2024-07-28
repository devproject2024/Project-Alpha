package net.one97.paytm.recharge.ordersummary.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.p;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;

public final class b implements ai, p {

    /* renamed from: h  reason: collision with root package name */
    public static final a f64312h = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public String f64313a;

    /* renamed from: b  reason: collision with root package name */
    public c f64314b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f64315c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f64316d;

    /* renamed from: e  reason: collision with root package name */
    public final d f64317e;

    /* renamed from: f  reason: collision with root package name */
    final net.one97.paytm.recharge.ordersummary.f.f f64318f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f64319g;

    /* renamed from: i  reason: collision with root package name */
    private String f64320i;
    private String j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public boolean l;
    private final e m;

    public interface d {
        void a(File file);

        void l();

        void m();
    }

    public interface e {
        void a(Bundle bundle);

        void b(Bundle bundle);
    }

    private b(Context context, e eVar, d dVar, net.one97.paytm.recharge.ordersummary.f.f fVar, boolean z) {
        this.f64316d = context;
        this.m = eVar;
        this.f64317e = dVar;
        this.f64318f = fVar;
        this.f64319g = z;
        this.j = "";
        this.k = -2;
    }

    public /* synthetic */ b(Context context, e eVar, d dVar, net.one97.paytm.recharge.ordersummary.f.f fVar, boolean z, byte b2) {
        this(context, eVar, dVar, fVar, z);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Context context) {
            k.c(context, "context");
            return a(context, (e) null, (d) null, (net.one97.paytm.recharge.ordersummary.f.f) null, true);
        }

        public static b a(Context context, boolean z) {
            k.c(context, "context");
            return a(context, (e) null, (d) null, (net.one97.paytm.recharge.ordersummary.f.f) null, z);
        }

        public static b a(Context context, d dVar, net.one97.paytm.recharge.ordersummary.f.f fVar) {
            k.c(context, "context");
            return a(context, (e) null, dVar, fVar, true);
        }

        public static b a(Context context, e eVar, d dVar, net.one97.paytm.recharge.ordersummary.f.f fVar, boolean z) {
            k.c(context, "context");
            return new b(context, eVar, dVar, fVar, z, (byte) 0);
        }
    }

    public final b a(String str) {
        k.c(str, "extraParams");
        this.j = str;
        return this;
    }

    public final void a(String str, CJROrderSummaryAction cJROrderSummaryAction, Object obj) {
        k.c(str, "tag");
        k.c(cJROrderSummaryAction, "action");
        a(str, cJROrderSummaryAction, obj, this);
    }

    public final void a(String str, CJROrderSummaryAction cJROrderSummaryAction, Object obj, ai aiVar) {
        k.c(str, "tag");
        k.c(cJROrderSummaryAction, "action");
        k.c(aiVar, "responseListener");
        a(str, cJROrderSummaryAction, obj, aiVar, (IJRPaytmDataModel) new CJROSActionResponseV2());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0028, code lost:
        r0 = r0.getMethod();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r11, net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r12, java.lang.Object r13, net.one97.paytm.recharge.common.e.ai r14, com.paytm.network.model.IJRPaytmDataModel r15) {
        /*
            r10 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "action"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "responseListener"
            kotlin.g.b.k.c(r14, r0)
            java.lang.String r0 = "responseModel"
            kotlin.g.b.k.c(r15, r0)
            java.lang.String r0 = r12.getLabel()
            java.lang.String r1 = "action.label"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r10.f64320i = r0
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r0 = r12.getUrlParams()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r0.getMethod()
            if (r0 != 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r4 = r0
            goto L_0x0032
        L_0x0031:
            r4 = r1
        L_0x0032:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r0 = r12.getUrlParams()
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = r0.getUrl()
            if (r0 != 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r5 = r0
            goto L_0x0042
        L_0x0041:
            r5 = r1
        L_0x0042:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r12 = r12.getUrlParams()
            if (r12 == 0) goto L_0x0057
            com.google.gsonhtcfix.o r12 = r12.getBody()
            if (r12 == 0) goto L_0x0057
            java.lang.String r12 = r12.toString()
            if (r12 != 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r6 = r12
            goto L_0x0058
        L_0x0057:
            r6 = r1
        L_0x0058:
            r2 = r10
            r3 = r11
            r7 = r14
            r8 = r15
            r9 = r13
            r2.a(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.b.a(java.lang.String, net.one97.paytm.common.entity.shopping.CJROrderSummaryAction, java.lang.Object, net.one97.paytm.recharge.common.e.ai, com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public static final class f implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64329a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ai f64330b;

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        }

        public f(b bVar, ai aiVar) {
            this.f64329a = bVar;
            this.f64330b = aiVar;
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                b bVar = this.f64329a;
                CJROrderedCart cJROrderedCart = ((CJROrderSummary) iJRPaytmDataModel).getOrderedCartList().get(0);
                k.a((Object) cJROrderedCart, "response.orderedCartList[0]");
                CJROrderSummaryAction tapAction = cJROrderedCart.getTapAction();
                k.a((Object) tapAction, "response.orderedCartList[0].tapAction");
                bVar.a(str, tapAction, obj, this.f64330b);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = r3.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.paytm.network.model.IJRPaytmDataModel r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r1 = 0
            if (r0 == 0) goto L_0x001f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r3
            java.util.ArrayList r3 = r3.getOrderedCartList()
            if (r3 == 0) goto L_0x001a
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            if (r3 == 0) goto L_0x001a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r3 = r3.getTapAction()
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x001f
            r3 = 1
            return r3
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.b.a(com.paytm.network.model.IJRPaytmDataModel):boolean");
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.h.b$b  reason: collision with other inner class name */
    final class C1267b extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private final long f64322b;

        public C1267b(long j) {
            this.f64322b = j;
        }

        public final void onReceive(Context context, Intent intent) {
            Long l;
            Cursor query;
            d dVar;
            Object obj = null;
            if (intent != null) {
                try {
                    l = Long.valueOf(intent.getLongExtra("extra_download_id", -1));
                } catch (Exception unused) {
                    d dVar2 = b.this.f64317e;
                    if (dVar2 != null) {
                        dVar2.m();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } else {
                l = null;
            }
            Bundle extras = intent != null ? intent.getExtras() : null;
            DownloadManager.Query query2 = new DownloadManager.Query();
            long[] jArr = new long[1];
            if (extras == null) {
                k.a();
            }
            jArr[0] = extras.getLong("extra_download_id");
            query2.setFilterById(jArr);
            if (context != null) {
                obj = context.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
            }
            if (obj != null) {
                query = ((DownloadManager) obj).query(query2);
                if (query.moveToFirst()) {
                    int i2 = query.getInt(query.getColumnIndex("status"));
                    if (i2 == 8) {
                        long j = (long) query.getInt(0);
                        if (l != null) {
                            if (l.longValue() == j) {
                                long j2 = this.f64322b;
                                if (l != null) {
                                    if (l.longValue() == j2) {
                                        Uri parse = Uri.parse(query.getString(query.getColumnIndex("local_uri")));
                                        if (parse != null) {
                                            File file = new File(b.this.f64316d.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), parse.getLastPathSegment());
                                            d dVar3 = b.this.f64317e;
                                            if (dVar3 != null) {
                                                dVar3.a(file);
                                            }
                                        } else {
                                            d dVar4 = b.this.f64317e;
                                            if (dVar4 != null) {
                                                dVar4.m();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (i2 == 16) {
                        long j3 = (long) query.getInt(0);
                        if (l != null) {
                            if (l.longValue() == j3) {
                                long j4 = this.f64322b;
                                if (l != null) {
                                    if (l.longValue() == j4 && (dVar = b.this.f64317e) != null) {
                                        dVar.m();
                                    }
                                }
                            }
                        }
                    }
                }
                query.close();
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.DownloadManager");
        }
    }

    public final class c extends AsyncTask<String, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f64324b;

        /* renamed from: c  reason: collision with root package name */
        private String f64325c;

        /* renamed from: net.one97.paytm.recharge.ordersummary.h.b$c$b  reason: collision with other inner class name */
        static final class C1268b implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public static final C1268b f64328a = new C1268b();

            C1268b() {
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        public c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x006a A[Catch:{ Exception -> 0x00af }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5 A[Catch:{ Exception -> 0x00af }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onPostExecute(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.String r7 = (java.lang.String) r7
                r0 = 0
                r1 = 1
                java.lang.String r2 = "downloadUrl"
                if (r7 == 0) goto L_0x00b2
                java.lang.String r3 = "application/pdf"
                boolean r3 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x00af }
                if (r3 == 0) goto L_0x00b2
                java.lang.String r7 = r6.f64325c     // Catch:{ Exception -> 0x00af }
                if (r7 != 0) goto L_0x0017
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00af }
            L_0x0017:
                kotlin.g.b.k.c(r7, r2)     // Catch:{ Exception -> 0x00af }
                r1 = 0
                net.one97.paytm.recharge.ordersummary.h.b r2 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r2 = r2.f64317e     // Catch:{ Exception -> 0x00af }
                boolean r2 = r2 instanceof androidx.fragment.app.Fragment     // Catch:{ Exception -> 0x00af }
                java.lang.String r3 = "null cannot be cast to non-null type androidx.fragment.app.Fragment"
                if (r2 == 0) goto L_0x0038
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r1 = r1.f64317e     // Catch:{ Exception -> 0x00af }
                if (r1 == 0) goto L_0x0032
                androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1     // Catch:{ Exception -> 0x00af }
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()     // Catch:{ Exception -> 0x00af }
                goto L_0x005f
            L_0x0032:
                kotlin.u r7 = new kotlin.u     // Catch:{ Exception -> 0x00af }
                r7.<init>(r3)     // Catch:{ Exception -> 0x00af }
                throw r7     // Catch:{ Exception -> 0x00af }
            L_0x0038:
                net.one97.paytm.recharge.ordersummary.h.b r2 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r2 = r2.f64317e     // Catch:{ Exception -> 0x00af }
                boolean r2 = r2 instanceof android.app.Activity     // Catch:{ Exception -> 0x00af }
                java.lang.String r4 = "null cannot be cast to non-null type android.app.Activity"
                if (r2 == 0) goto L_0x0051
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r1 = r1.f64317e     // Catch:{ Exception -> 0x00af }
                if (r1 == 0) goto L_0x004b
                android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x00af }
                goto L_0x0068
            L_0x004b:
                kotlin.u r7 = new kotlin.u     // Catch:{ Exception -> 0x00af }
                r7.<init>(r4)     // Catch:{ Exception -> 0x00af }
                throw r7     // Catch:{ Exception -> 0x00af }
            L_0x0051:
                net.one97.paytm.recharge.ordersummary.h.b r2 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r2 = r2.f64316d     // Catch:{ Exception -> 0x00af }
                boolean r2 = r2 instanceof android.app.Activity     // Catch:{ Exception -> 0x00af }
                if (r2 == 0) goto L_0x0068
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r1 = r1.f64316d     // Catch:{ Exception -> 0x00af }
                if (r1 == 0) goto L_0x0062
            L_0x005f:
                android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x00af }
                goto L_0x0068
            L_0x0062:
                kotlin.u r7 = new kotlin.u     // Catch:{ Exception -> 0x00af }
                r7.<init>(r4)     // Catch:{ Exception -> 0x00af }
                throw r7     // Catch:{ Exception -> 0x00af }
            L_0x0068:
                if (r1 == 0) goto L_0x00a5
                boolean r2 = com.paytm.utility.s.a()     // Catch:{ Exception -> 0x00af }
                if (r2 == 0) goto L_0x00a1
                boolean r2 = com.paytm.utility.s.c((android.app.Activity) r1)     // Catch:{ Exception -> 0x00af }
                if (r2 != 0) goto L_0x00a1
                net.one97.paytm.recharge.ordersummary.h.b r2 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                r2.f64313a = r7     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r7 = r7.f64317e     // Catch:{ Exception -> 0x00af }
                boolean r7 = r7 instanceof androidx.fragment.app.Fragment     // Catch:{ Exception -> 0x00af }
                if (r7 == 0) goto L_0x009d
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r7 = r7.f64317e     // Catch:{ Exception -> 0x00af }
                if (r7 == 0) goto L_0x0097
                androidx.fragment.app.Fragment r7 = (androidx.fragment.app.Fragment) r7     // Catch:{ Exception -> 0x00af }
                java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
                java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x00af }
                r2 = 56
                r7.requestPermissions(r1, r2)     // Catch:{ Exception -> 0x00af }
                return
            L_0x0097:
                kotlin.u r7 = new kotlin.u     // Catch:{ Exception -> 0x00af }
                r7.<init>(r3)     // Catch:{ Exception -> 0x00af }
                throw r7     // Catch:{ Exception -> 0x00af }
            L_0x009d:
                com.paytm.utility.s.b((android.app.Activity) r1)     // Catch:{ Exception -> 0x00af }
                return
            L_0x00a1:
                r6.a((java.lang.String) r7)     // Catch:{ Exception -> 0x00af }
                return
            L_0x00a5:
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b$d r7 = r7.f64317e     // Catch:{ Exception -> 0x00af }
                if (r7 == 0) goto L_0x00ae
                r7.m()     // Catch:{ Exception -> 0x00af }
            L_0x00ae:
                return
            L_0x00af:
                r7 = move-exception
                goto L_0x012c
            L_0x00b2:
                if (r7 == 0) goto L_0x00fd
                java.lang.String r3 = "application/xml"
                boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x00af }
                if (r7 != 0) goto L_0x00fd
                android.content.Intent r7 = new android.content.Intent     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r1 = r1.f64316d     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.di.helper.a r3 = net.one97.paytm.recharge.di.helper.a.f62650a     // Catch:{ Exception -> 0x00af }
                java.lang.Class r3 = net.one97.paytm.recharge.di.helper.a.c()     // Catch:{ Exception -> 0x00af }
                r7.<init>(r1, r3)     // Catch:{ Exception -> 0x00af }
                java.lang.String r1 = "url"
                java.lang.String r3 = r6.f64325c     // Catch:{ Exception -> 0x00af }
                if (r3 != 0) goto L_0x00d4
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00af }
            L_0x00d4:
                r7.putExtra(r1, r3)     // Catch:{ Exception -> 0x00af }
                java.lang.String r1 = r6.f64324b     // Catch:{ Exception -> 0x00af }
                java.lang.String r2 = "title"
                if (r1 != 0) goto L_0x00e0
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00af }
            L_0x00e0:
                r7.putExtra(r2, r1)     // Catch:{ Exception -> 0x00af }
                java.lang.String r1 = "From"
                java.lang.String r2 = "Order_summary"
                r7.putExtra(r1, r2)     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.os.Bundle r1 = r1.f64315c     // Catch:{ Exception -> 0x00af }
                if (r1 == 0) goto L_0x00f5
                r7.putExtras(r1)     // Catch:{ Exception -> 0x00af }
            L_0x00f5:
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r1 = r1.f64316d     // Catch:{ Exception -> 0x00af }
                r1.startActivity(r7)     // Catch:{ Exception -> 0x00af }
                goto L_0x0133
            L_0x00fd:
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                boolean r7 = r7.l     // Catch:{ Exception -> 0x00af }
                if (r7 != 0) goto L_0x0133
                net.one97.paytm.recharge.common.utils.az r7 = net.one97.paytm.recharge.common.utils.az.f61525a     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r7 = r7.f64316d     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_DOWNLOAD     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r3 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r3 = r3.f64316d     // Catch:{ Exception -> 0x00af }
                int r4 = net.one97.paytm.recharge.R.string.try_again     // Catch:{ Exception -> 0x00af }
                java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r4 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                android.content.Context r4 = r4.f64316d     // Catch:{ Exception -> 0x00af }
                int r5 = net.one97.paytm.recharge.R.string.error_action_not_performed     // Catch:{ Exception -> 0x00af }
                java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.common.utils.az.a(r7, r1, r2, r3, r4)     // Catch:{ Exception -> 0x00af }
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x00af }
                r7.l = r0     // Catch:{ Exception -> 0x00af }
                goto L_0x0133
            L_0x012c:
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                r1.debugLogExceptions(r7)
            L_0x0133:
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this
                boolean r7 = r7.l
                if (r7 != 0) goto L_0x0149
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this
                net.one97.paytm.recharge.ordersummary.h.b$d r7 = r7.f64317e
                if (r7 == 0) goto L_0x0144
                r7.m()
            L_0x0144:
                net.one97.paytm.recharge.ordersummary.h.b r7 = net.one97.paytm.recharge.ordersummary.h.b.this
                r7.l = r0
            L_0x0149:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.b.c.onPostExecute(java.lang.Object):void");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            k.c(strArr, "params");
            try {
                this.f64324b = strArr[1];
                this.f64325c = strArr[0];
                String str = this.f64325c;
                if (str == null) {
                    k.a("downloadUrl");
                }
                URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
                k.a((Object) uRLConnection, "url.openConnection()");
                return uRLConnection.getContentType();
            } catch (Exception e2) {
                q.d(e2.getMessage());
                return null;
            }
        }

        public final void a(String str) {
            d dVar;
            k.c(str, "downloadUrl");
            Uri parse = Uri.parse(str);
            k.a((Object) parse, "invoiceUri");
            long a2 = a(parse);
            if (a2 > 0) {
                b.this.f64316d.registerReceiver(new C1267b(a2), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                d dVar2 = b.this.f64317e;
                if (dVar2 != null) {
                    dVar2.l();
                }
            } else if (a2 != b.this.k && (dVar = b.this.f64317e) != null) {
                dVar.m();
            }
        }

        public final void a(boolean z) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(b.this.f64316d);
                if (z) {
                    builder.setMessage(b.this.f64316d.getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
                } else {
                    builder.setMessage(b.this.f64316d.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
                }
                builder.setPositiveButton(b.this.f64316d.getResources().getString(R.string.action_settings), new a(this, z));
                builder.setNegativeButton(b.this.f64316d.getResources().getString(R.string.cancel), C1268b.f64328a);
                builder.show();
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f64326a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f64327b;

            a(c cVar, boolean z) {
                this.f64326a = cVar;
                this.f64327b = z;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (this.f64327b) {
                    s.b(b.this.f64316d);
                    if (b.this.f64317e instanceof Fragment) {
                        d dVar = b.this.f64317e;
                        if (dVar != null) {
                            FragmentActivity activity = ((Fragment) dVar).getActivity();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type androidx.fragment.app.Fragment");
                    } else if (b.this.f64317e instanceof Activity) {
                        d dVar2 = b.this.f64317e;
                        if (dVar2 != null) {
                            ((Activity) dVar2).finish();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    } else if (b.this.f64316d instanceof Activity) {
                        Context context = b.this.f64316d;
                        if (context != null) {
                            ((Activity) context).finish();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    }
                } else {
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        b.this.f64316d.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        q.d(e2.getMessage());
                        b.this.f64316d.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[Catch:{ Exception -> 0x0117 }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x010f A[Catch:{ Exception -> 0x0117 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final long a(android.net.Uri r10) {
            /*
                r9 = this;
                java.lang.String r0 = ".pdf"
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                android.content.Context r1 = r1.f64316d     // Catch:{ Exception -> 0x0117 }
                android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0117 }
                java.lang.String r2 = "com.android.providers.downloads"
                int r1 = r1.getApplicationEnabledSetting(r2)     // Catch:{ Exception -> 0x0117 }
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == r2) goto L_0x001e
                r2 = 3
                if (r1 == r2) goto L_0x001e
                r2 = 4
                if (r1 != r2) goto L_0x001c
                goto L_0x001e
            L_0x001c:
                r1 = 1
                goto L_0x0022
            L_0x001e:
                r9.a((boolean) r4)     // Catch:{ Exception -> 0x0117 }
                r1 = 0
            L_0x0022:
                if (r1 == 0) goto L_0x0117
                java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0117 }
                java.lang.String r2 = "mounted"
                boolean r1 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0117 }
                if (r1 == 0) goto L_0x0117
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.f.f r1 = r1.f64318f     // Catch:{ Exception -> 0x0117 }
                if (r1 == 0) goto L_0x0117
                net.one97.paytm.recharge.ordersummary.h.b r1 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                android.content.Context r1 = r1.f64316d     // Catch:{ Exception -> 0x0117 }
                java.lang.String r2 = "download"
                java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0117 }
                if (r1 == 0) goto L_0x010f
                android.app.DownloadManager r1 = (android.app.DownloadManager) r1     // Catch:{ Exception -> 0x0117 }
                android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request     // Catch:{ Exception -> 0x0117 }
                r2.<init>(r10)     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.h.b r10 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.f.f r10 = r10.f64318f     // Catch:{ Exception -> 0x0117 }
                r5 = 0
                if (r10 == 0) goto L_0x0055
                net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r10.k()     // Catch:{ Exception -> 0x0117 }
                goto L_0x0056
            L_0x0055:
                r10 = r5
            L_0x0056:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
                java.lang.String r7 = "Invoice_"
                r6.<init>(r7)     // Catch:{ Exception -> 0x0117 }
                if (r10 == 0) goto L_0x0064
                java.lang.String r7 = r10.getId()     // Catch:{ Exception -> 0x0117 }
                goto L_0x0065
            L_0x0064:
                r7 = r5
            L_0x0065:
                r6.append(r7)     // Catch:{ Exception -> 0x0117 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0117 }
                java.lang.String r7 = "Bus Ticket"
                if (r10 == 0) goto L_0x0089
                java.util.ArrayList r8 = r10.getOrderedCartList()     // Catch:{ Exception -> 0x0117 }
                if (r8 == 0) goto L_0x0089
                java.lang.Object r8 = r8.get(r4)     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8     // Catch:{ Exception -> 0x0117 }
                if (r8 == 0) goto L_0x0089
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r8 = r8.getProductDetail()     // Catch:{ Exception -> 0x0117 }
                if (r8 == 0) goto L_0x0089
                java.lang.String r8 = r8.getName()     // Catch:{ Exception -> 0x0117 }
                goto L_0x008a
            L_0x0089:
                r8 = r5
            L_0x008a:
                boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r3)     // Catch:{ Exception -> 0x0117 }
                if (r7 == 0) goto L_0x00a4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
                java.lang.String r7 = "Ticket_"
                r6.<init>(r7)     // Catch:{ Exception -> 0x0117 }
                if (r10 == 0) goto L_0x009d
                java.lang.String r5 = r10.getId()     // Catch:{ Exception -> 0x0117 }
            L_0x009d:
                r6.append(r5)     // Catch:{ Exception -> 0x0117 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0117 }
            L_0x00a4:
                java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.h.b r5 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                android.content.Context r5 = r5.f64316d     // Catch:{ Exception -> 0x0117 }
                java.lang.String r7 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x0117 }
                java.io.File r5 = r5.getExternalFilesDir(r7)     // Catch:{ Exception -> 0x0117 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
                r7.<init>()     // Catch:{ Exception -> 0x0117 }
                r7.append(r6)     // Catch:{ Exception -> 0x0117 }
                r7.append(r0)     // Catch:{ Exception -> 0x0117 }
                java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0117 }
                r10.<init>(r5, r7)     // Catch:{ Exception -> 0x0117 }
                boolean r5 = r10.exists()     // Catch:{ Exception -> 0x0117 }
                if (r5 == 0) goto L_0x00dd
                net.one97.paytm.recharge.ordersummary.h.b r0 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.h.b$d r0 = r0.f64317e     // Catch:{ Exception -> 0x0117 }
                if (r0 == 0) goto L_0x00d1
                r0.a(r10)     // Catch:{ Exception -> 0x0117 }
            L_0x00d1:
                net.one97.paytm.recharge.ordersummary.h.b r10 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                r10.l = r3     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.h.b r10 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                long r0 = r10.k     // Catch:{ Exception -> 0x0117 }
                return r0
            L_0x00dd:
                net.one97.paytm.recharge.ordersummary.h.b r10 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                r10.l = r4     // Catch:{ Exception -> 0x0117 }
                r10 = r6
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0117 }
                r2.setTitle(r10)     // Catch:{ Exception -> 0x0117 }
                java.lang.String r10 = "Downloading..."
                java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x0117 }
                r2.setDescription(r10)     // Catch:{ Exception -> 0x0117 }
                net.one97.paytm.recharge.ordersummary.h.b r10 = net.one97.paytm.recharge.ordersummary.h.b.this     // Catch:{ Exception -> 0x0117 }
                android.content.Context r10 = r10.f64316d     // Catch:{ Exception -> 0x0117 }
                java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x0117 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
                r5.<init>()     // Catch:{ Exception -> 0x0117 }
                r5.append(r6)     // Catch:{ Exception -> 0x0117 }
                r5.append(r0)     // Catch:{ Exception -> 0x0117 }
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0117 }
                r2.setDestinationInExternalFilesDir(r10, r4, r0)     // Catch:{ Exception -> 0x0117 }
                r2.setNotificationVisibility(r3)     // Catch:{ Exception -> 0x0117 }
                long r0 = r1.enqueue(r2)     // Catch:{ Exception -> 0x0117 }
                goto L_0x0119
            L_0x010f:
                kotlin.u r10 = new kotlin.u     // Catch:{ Exception -> 0x0117 }
                java.lang.String r0 = "null cannot be cast to non-null type android.app.DownloadManager"
                r10.<init>(r0)     // Catch:{ Exception -> 0x0117 }
                throw r10     // Catch:{ Exception -> 0x0117 }
            L_0x0117:
                r0 = 0
            L_0x0119:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.b.c.a(android.net.Uri):long");
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        String str2;
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
            e eVar = this.m;
            if (eVar != null) {
                eVar.a(this.f64315c);
            }
            CJROSActionResponseV2 cJROSActionResponseV2 = (CJROSActionResponseV2) iJRPaytmDataModel;
            if (cJROSActionResponseV2.getActions() != null) {
                List<CJROSActionItemV2> actions = cJROSActionResponseV2.getActions();
                if ((actions != null ? actions.size() : 0) > 0) {
                    if (actions == null) {
                        k.a();
                    }
                    CJROSActionItemV2 cJROSActionItemV2 = actions.get(0);
                    if (kotlin.m.p.a(cJROSActionItemV2.getUiControl(), "browser", true) && cJROSActionItemV2.getUrlParams() != null) {
                        CJROrderSummaryActionURLParams urlParams = cJROSActionItemV2.getUrlParams();
                        k.a((Object) urlParams, "action\n                 …               .urlParams");
                        if (!TextUtils.isEmpty(urlParams.getUrl())) {
                            this.f64314b = new c();
                            c cVar = this.f64314b;
                            if (cVar != null) {
                                String[] strArr = new String[2];
                                CJROrderSummaryActionURLParams urlParams2 = cJROSActionItemV2.getUrlParams();
                                k.a((Object) urlParams2, "action.urlParams");
                                strArr[0] = urlParams2.getUrl();
                                if (TextUtils.isEmpty(cJROSActionResponseV2.getTitle())) {
                                    str2 = this.f64320i;
                                    if (str2 == null) {
                                        k.a("mLabel");
                                    }
                                } else {
                                    str2 = cJROSActionResponseV2.getTitle();
                                }
                                strArr[1] = str2;
                                cVar.execute(strArr);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            d dVar = this.f64317e;
            if (dVar != null) {
                dVar.m();
            }
        } else if (this.m != null || this.f64317e != null) {
            d dVar2 = this.f64317e;
            if (dVar2 != null) {
                dVar2.m();
            }
            e eVar2 = this.m;
            if (eVar2 != null) {
                new NetworkCustomError(b.class.getSimpleName() + " Invalid response");
                eVar2.b(this.f64315c);
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        if (this.m == null && this.f64317e == null) {
            Toast.makeText(this.f64316d, networkCustomError != null ? networkCustomError.getMessage() : null, 1).show();
            return;
        }
        d dVar = this.f64317e;
        if (dVar != null) {
            dVar.m();
        }
        e eVar = this.m;
        if (eVar != null) {
            eVar.b(this.f64315c);
        }
    }

    public final void a(String str, String str2, String str3, String str4, ai aiVar, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CRUFlowModel flowName;
        String str5 = str2;
        String str6 = str3;
        Object obj2 = obj;
        String str7 = str;
        k.c(str, "tag");
        k.c(str2, "httpMethod");
        k.c(str3, "url");
        k.c(aiVar, "responseListener");
        k.c(iJRPaytmDataModel, "responseModel");
        String a2 = kotlin.m.p.a(str3, " ", "%20", false);
        if (!TextUtils.isEmpty(this.j)) {
            Uri parse = Uri.parse(a2);
            k.a((Object) parse, "Uri.parse(finalUrl)");
            if (parse.getQuery() != null) {
                a2 = a2 + '&' + this.j;
            } else {
                a2 = a2 + '?' + this.j;
            }
        }
        int a3 = n.a(this.f64316d, n.b());
        Uri parse2 = Uri.parse(a2);
        if (parse2 != null) {
            Uri.Builder buildUpon = parse2.buildUpon();
            buildUpon.appendQueryParameter(AppConstants.TAG_LANG_ID, String.valueOf(a3));
            String k2 = com.paytm.utility.a.k(this.f64316d);
            if (TextUtils.isEmpty(k2)) {
                k2 = "en-IN";
            }
            buildUpon.appendQueryParameter(ContactsConstant.LOCALE, k2);
            a2 = buildUpon.build().toString();
            k.a((Object) a2, "builder.build().toString()");
        }
        String str8 = a2;
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        String a4 = com.paytm.utility.d.a(this.f64316d);
        k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
        map.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, a4);
        if (kotlin.m.p.a("POST", str2, true)) {
            hashMap.put("Content-Type", "application/json");
            if (!(obj2 instanceof CJRRechargeErrorModel) || (flowName = ((CJRRechargeErrorModel) obj2).getFlowName()) == null) {
                String str9 = str4;
            } else {
                flowName.setRequestBody(str4);
            }
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.c(str, str8, aiVar, iJRPaytmDataModel, (Map<String, String>) null, (Map<String, String>) map, str4, obj));
        } else if (kotlin.m.p.a(H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD, str2, true)) {
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b(str, str8, aiVar, iJRPaytmDataModel, map, obj));
        }
    }
}
