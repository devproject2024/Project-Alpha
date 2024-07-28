package net.one97.paytm.upi.mandate.f;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.mandate.data.b;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandateListResponseModel;
import net.one97.paytm.upi.mandate.utils.c;
import net.one97.paytm.upi.mandate.utils.i;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.s;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class d extends androidx.lifecycle.a implements b.a, i.a {

    /* renamed from: h  reason: collision with root package name */
    public static final b f67236h = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final y<r<List<MandateItem>>> f67237a;

    /* renamed from: b  reason: collision with root package name */
    public final y<r<String>> f67238b;

    /* renamed from: c  reason: collision with root package name */
    public final s<a> f67239c;

    /* renamed from: d  reason: collision with root package name */
    public int f67240d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67241e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67242f;

    /* renamed from: g  reason: collision with root package name */
    public final Application f67243g;

    /* renamed from: i  reason: collision with root package name */
    private final net.one97.paytm.upi.mandate.data.b f67244i = g.a(this.f67243g.getApplicationContext());
    private final net.one97.paytm.upi.profile.b.b j;
    private final i k;
    private String l;
    private MandateItem m;
    private boolean n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Application application) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f67243g = application;
        this.f67243g.getApplicationContext();
        this.j = g.a();
        this.f67237a = new y<>();
        this.f67238b = new y<>();
        this.f67239c = new s<>();
        Context applicationContext = this.f67243g.getApplicationContext();
        k.a((Object) applicationContext, "app.applicationContext");
        this.k = new i(applicationContext);
        this.n = true;
        this.k.a((i.a) this);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void a() {
        if (UpiAppUtils.isNetworkAvailable(this.f67243g)) {
            this.f67241e = false;
            this.f67237a.setValue(new r(u.LOADING, (Object) null, (t) null, false, 14));
            this.f67244i.c(this.f67240d, this);
            return;
        }
        this.f67237a.setValue(new r(u.ERROR, (Object) null, t.i.f67428a, this.f67241e, 2));
    }

    public final void a(UpiBaseDataModel upiBaseDataModel) {
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (upiBaseDataModel instanceof MandateListResponseModel) {
            MandateListResponseModel mandateListResponseModel = (MandateListResponseModel) upiBaseDataModel;
            boolean z = true;
            if (p.a("FAILURE", mandateListResponseModel.getStatus(), true)) {
                int i2 = this.f67240d;
                if (i2 != 0) {
                    this.f67240d = i2 - 1;
                    this.f67241e = true;
                }
                this.f67237a.setValue(new r(u.ERROR, (Object) null, new t.a(mandateListResponseModel.getRespMessage()), this.f67241e, 2));
                return;
            }
            List<MandateItem> mandateItemList = mandateListResponseModel.getMandateItemList();
            if ((mandateItemList != null ? mandateItemList.size() : 0) != 20) {
                z = false;
            }
            this.f67241e = z;
            List<MandateItem> mandateItemList2 = mandateListResponseModel.getMandateItemList();
            if (mandateItemList2 != null) {
                for (MandateItem mandateItem : mandateItemList2) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
                    String validityStartDate = mandateItem.getValidityStartDate();
                    Long l2 = null;
                    mandateItem.setValidityStartDate(simpleDateFormat.format(validityStartDate != null ? Long.valueOf(Long.parseLong(validityStartDate)) : null));
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
                    String validityEndDate = mandateItem.getValidityEndDate();
                    if (validityEndDate != null) {
                        l2 = Long.valueOf(Long.parseLong(validityEndDate));
                    }
                    mandateItem.setValidityEndDate(simpleDateFormat2.format(l2));
                }
            }
            this.f67237a.setValue(new r(u.SUCCESS, mandateListResponseModel.getMandateItemList(), (t) null, this.f67241e, 4));
        } else if (upiBaseDataModel instanceof MandateDefaultResponseModel) {
            MandateDefaultResponseModel mandateDefaultResponseModel = (MandateDefaultResponseModel) upiBaseDataModel;
            if (c.SUCCESS.getType().equals(mandateDefaultResponseModel.getStatus())) {
                this.f67238b.setValue(new r(u.SUCCESS, mandateDefaultResponseModel.getRespMessage(), (t) null, false, 12));
            } else {
                this.f67238b.setValue(new r(u.ERROR, (Object) null, new t.a(mandateDefaultResponseModel.getRespMessage()), false, 10));
            }
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null)) {
            this.f67237a.setValue(new r(u.ERROR, (Object) null, t.j.f67429a, this.f67241e, 2));
        } else {
            this.f67237a.setValue(new r(u.ERROR, (Object) null, t.g.f67426a, this.f67241e, 2));
        }
    }

    public final void b() {
        this.f67240d = 0;
        a();
    }

    public final void a(String str) {
        k.c(str, PayUtility.MPIN);
        s<a> sVar = this.f67239c;
        MandateItem mandateItem = this.m;
        if (mandateItem == null) {
            k.a("_mandateItem");
        }
        String userName = mandateItem.getPayer().getUserName();
        MandateItem mandateItem2 = this.m;
        if (mandateItem2 == null) {
            k.a("_mandateItem");
        }
        String amount = mandateItem2.getAmount();
        if (amount == null) {
            k.a();
        }
        MandateItem mandateItem3 = this.m;
        if (mandateItem3 == null) {
            k.a("_mandateItem");
        }
        String validityStartDate = mandateItem3.getValidityStartDate();
        if (validityStartDate == null) {
            k.a();
        }
        MandateItem mandateItem4 = this.m;
        if (mandateItem4 == null) {
            k.a("_mandateItem");
        }
        String validityEndDate = mandateItem4.getValidityEndDate();
        if (validityEndDate == null) {
            k.a();
        }
        MandateItem mandateItem5 = this.m;
        if (mandateItem5 == null) {
            k.a("_mandateItem");
        }
        String umn = mandateItem5.getUmn();
        String str2 = this.l;
        if (str2 == null) {
            k.a("_txnId");
        }
        sVar.setValue(new a.C1364a(userName, amount, validityStartDate, validityEndDate, umn, "date_millis", str, str2));
        this.f67238b.setValue(new r(u.SUCCESS, (Object) null, (t) null, false, 14));
    }

    public final void a(t tVar) {
        k.c(tVar, "error");
        this.f67238b.setValue(new r(u.ERROR, (Object) null, tVar, false, 10));
    }

    public static abstract class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f67253a = new b();

            private b() {
                super((byte) 0);
            }
        }

        /* renamed from: net.one97.paytm.upi.mandate.f.d$a$a  reason: collision with other inner class name */
        public static final class C1364a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final String f67245a;

            /* renamed from: b  reason: collision with root package name */
            private final String f67246b;

            /* renamed from: c  reason: collision with root package name */
            private final String f67247c;

            /* renamed from: d  reason: collision with root package name */
            private final String f67248d;

            /* renamed from: e  reason: collision with root package name */
            private final String f67249e;

            /* renamed from: f  reason: collision with root package name */
            private final String f67250f;

            /* renamed from: g  reason: collision with root package name */
            private final String f67251g;

            /* renamed from: h  reason: collision with root package name */
            private final String f67252h;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1364a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
                super((byte) 0);
                k.c(str2, "amount");
                k.c(str3, "startDate");
                k.c(str4, "endDate");
                k.c(str5, "umn");
                k.c(str6, "dateFormat");
                k.c(str7, PayUtility.MPIN);
                this.f67245a = str;
                this.f67246b = str2;
                this.f67247c = str3;
                this.f67248d = str4;
                this.f67249e = str5;
                this.f67250f = str6;
                this.f67251g = str7;
                this.f67252h = str8;
            }
        }
    }
}
