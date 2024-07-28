package net.one97.paytm.transport.iocl.c;

import android.app.Application;
import android.content.Context;
import androidx.databinding.i;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.regex.Pattern;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a.e;
import net.one97.paytm.transport.iocl.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl.data.User;

public final class d extends a {

    /* renamed from: g  reason: collision with root package name */
    public i<Boolean> f14308g = new i<>(Boolean.TRUE);

    /* renamed from: h  reason: collision with root package name */
    public i<Boolean> f14309h = new i<>(Boolean.TRUE);

    /* renamed from: i  reason: collision with root package name */
    public i<String> f14310i = new i<>();
    public i<String> j = new i<>();
    public i<String> k = new i<>();
    public i<String> l = new i<>();
    public i<String> m = new i<>();
    public i<String> n = new i<>();
    public i<String> o = new i<>();
    public i<String> p = new i<>();
    public i<String> q = new i<>();
    public i<String> r = new i<>();
    public boolean s = false;
    public e.a t;
    public y<String> u = new y<>();
    /* access modifiers changed from: private */
    public FragmentActivity v;

    public d(e.a aVar, Application application, FragmentActivity fragmentActivity) {
        super(application);
        this.t = aVar;
        this.v = fragmentActivity;
        if (!b.c((Context) fragmentActivity)) {
            fragmentActivity.getString(R.string.iocl_no_connection);
            b.a((Context) (IOCLBaseActivity) fragmentActivity, fragmentActivity.getString(R.string.iocl_no_internet), false);
        } else if (b.r((Context) fragmentActivity)) {
            c();
        } else {
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(403);
            ((IOCLBaseActivity) fragmentActivity).a(net.one97.paytm.transport.iocl.b.b.f14274f, networkCustomError);
        }
    }

    public final void c() {
        this.s = true;
        net.one97.paytm.transport.iocl.b.b.b(this.v, new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                boolean unused = d.this.s = false;
                d.super.onApiSuccess(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                boolean unused = d.this.s = false;
                d.this.e();
            }
        });
        net.one97.paytm.transport.iocl.b.b.a((Context) this.v, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                d.super.onApiSuccess(iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                    ((IOCLBaseActivity) d.this.v).a(net.one97.paytm.transport.iocl.b.b.f14274f, networkCustomError);
                } else {
                    d.super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                }
            }
        });
    }

    private static boolean a(String str) {
        return Pattern.compile("^[a-zA-Z\\s\\.]+$", 2).matcher(str).find();
    }

    public final void d() {
        String str;
        String str2;
        if (!b.c((Context) getApplication())) {
            FragmentActivity fragmentActivity = this.v;
            if (fragmentActivity != null) {
                b.a((Context) (IOCLBaseActivity) fragmentActivity, "No Internet Connection", false);
            }
        } else if (f()) {
            this.f14295a.setValue(Boolean.TRUE);
            net.one97.paytm.transport.iocl.data.b bVar = new net.one97.paytm.transport.iocl.data.b();
            bVar.f14323a = true;
            User user = new User();
            user.setPincode(this.o.get());
            user.setDob(this.q.get());
            user.setMobile(b.l((Context) getApplication()));
            user.setName(this.l.get());
            bVar.f14324b = user;
            if (!(a() == null || a().getUserEnrollmentMeta() == null)) {
                bVar.f14325c = a().getUserEnrollmentMeta();
            }
            if (this.f14308g.get().booleanValue()) {
                str2 = "";
                str = "Deny";
            } else {
                str2 = a().getUserEnrollmentMeta().getAllowUpdate();
                str = "Confirm";
            }
            if (b.r((Context) this.v)) {
                net.one97.paytm.transport.iocl.b.b.a(getApplication(), bVar, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        d.super.onApiSuccess(iJRPaytmDataModel);
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                            ((IOCLBaseActivity) d.this.v).a(net.one97.paytm.transport.iocl.b.b.f14273e, networkCustomError);
                        } else {
                            d.super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                        }
                    }
                }, str, str2);
                return;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(403);
            ((IOCLBaseActivity) this.v).a(net.one97.paytm.transport.iocl.b.b.f14273e, networkCustomError);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f() {
        /*
            r5 = this;
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L_0x0037
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14308g
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x002d
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14309h
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0037
        L_0x002d:
            androidx.databinding.i<java.lang.String> r0 = r5.m
            java.lang.String r3 = "Please Enter User Name"
            r0.set(r3)
        L_0x0034:
            r0 = 0
            goto L_0x00ef
        L_0x0037:
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0071
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0071
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14308g
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0069
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14309h
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0071
        L_0x0069:
            androidx.databinding.i<java.lang.String> r0 = r5.m
            java.lang.String r3 = "Please enter name without any number or special characters."
            r0.set(r3)
            goto L_0x0034
        L_0x0071:
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x00ac
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            r3 = 3
            if (r0 >= r3) goto L_0x00ac
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14308g
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00a4
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14309h
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00ac
        L_0x00a4:
            androidx.databinding.i<java.lang.String> r0 = r5.m
            java.lang.String r3 = "Please enter name with more than 3 characters"
            r0.set(r3)
            goto L_0x0034
        L_0x00ac:
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x00e9
            androidx.databinding.i<java.lang.String> r0 = r5.l
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            r3 = 30
            if (r0 <= r3) goto L_0x00e9
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14308g
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00e0
            androidx.databinding.i<java.lang.Boolean> r0 = r5.f14309h
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00e9
        L_0x00e0:
            androidx.databinding.i<java.lang.String> r0 = r5.m
            java.lang.String r3 = "Please enter name in less than 30 characters"
            r0.set(r3)
            goto L_0x0034
        L_0x00e9:
            androidx.databinding.i<java.lang.String> r0 = r5.m
            r0.set(r1)
            r0 = 1
        L_0x00ef:
            androidx.databinding.i<java.lang.String> r3 = r5.q
            java.lang.Object r3 = r3.get()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0106
            androidx.databinding.i<java.lang.String> r0 = r5.r
            java.lang.String r3 = "Please Enter Date of Birth"
            r0.set(r3)
            r0 = 0
            goto L_0x010b
        L_0x0106:
            androidx.databinding.i<java.lang.String> r3 = r5.r
            r3.set(r1)
        L_0x010b:
            androidx.databinding.i<java.lang.String> r3 = r5.o
            java.lang.Object r3 = r3.get()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0121
            androidx.databinding.i<java.lang.String> r0 = r5.p
            java.lang.String r1 = "Please Enter Pincode"
            r0.set(r1)
            goto L_0x014a
        L_0x0121:
            androidx.databinding.i<java.lang.String> r3 = r5.o
            java.lang.Object r3 = r3.get()
            if (r3 == 0) goto L_0x0144
            androidx.databinding.i<java.lang.String> r3 = r5.o
            java.lang.Object r3 = r3.get()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.trim()
            int r3 = r3.length()
            r4 = 6
            if (r3 >= r4) goto L_0x0144
            androidx.databinding.i<java.lang.String> r0 = r5.p
            java.lang.String r1 = "Please enter a valid pin code"
            r0.set(r1)
            goto L_0x014a
        L_0x0144:
            androidx.databinding.i<java.lang.String> r2 = r5.p
            r2.set(r1)
            r2 = r0
        L_0x014a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.transport.iocl.c.d.f():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        if (android.text.TextUtils.isEmpty(a().getUser().getName()) == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e1, code lost:
        if (android.text.TextUtils.isEmpty(a().getUser().getName()) == false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0122, code lost:
        if (android.text.TextUtils.isEmpty(a().getUser().getName()) == false) goto L_0x0147;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r2 = this;
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            if (r0 == 0) goto L_0x016d
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            if (r0 == 0) goto L_0x016d
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.UserEnrollmentMeta r0 = r0.getUserEnrollmentMeta()
            if (r0 != 0) goto L_0x0051
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            if (r0 == 0) goto L_0x003d
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003d
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.common.entity.CJRAadharPanGet r1 = r2.b()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
            goto L_0x0158
        L_0x003d:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0158
            goto L_0x0147
        L_0x0051:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.UserEnrollmentMeta r0 = r0.getUserEnrollmentMeta()
            java.lang.String r0 = r0.getAllowUpdate()
            java.lang.String r1 = "N"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0090
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0088
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r1 = r2.a()
            net.one97.paytm.transport.iocl.data.User r1 = r1.getUser()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
        L_0x0088:
            androidx.databinding.i<java.lang.String> r0 = r2.n
            java.lang.String r1 = "To update your name, kindly contact your Indane Dealership"
            r0.set(r1)
            return
        L_0x0090:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.UserEnrollmentMeta r0 = r0.getUserEnrollmentMeta()
            java.lang.String r0 = r0.getAllowUpdate()
            java.lang.String r1 = "Y"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0125
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            if (r0 == 0) goto L_0x0112
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            boolean r0 = r0.isKycDone()
            if (r0 == 0) goto L_0x00e4
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d1
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.common.entity.CJRAadharPanGet r1 = r2.b()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
            goto L_0x0158
        L_0x00d1:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0158
            goto L_0x0147
        L_0x00e4:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0147
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0158
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.common.entity.CJRAadharPanGet r1 = r2.b()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
            goto L_0x0158
        L_0x0112:
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r0 = r2.a()
            net.one97.paytm.transport.iocl.data.User r0 = r0.getUser()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0158
            goto L_0x0147
        L_0x0125:
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            if (r0 == 0) goto L_0x0147
            net.one97.paytm.common.entity.CJRAadharPanGet r0 = r2.b()
            java.lang.String r0 = r0.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0147
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.common.entity.CJRAadharPanGet r1 = r2.b()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
            goto L_0x0158
        L_0x0147:
            androidx.databinding.i<java.lang.String> r0 = r2.l
            net.one97.paytm.transport.iocl.data.IOCLCommonResponse r1 = r2.a()
            net.one97.paytm.transport.iocl.data.User r1 = r1.getUser()
            java.lang.String r1 = r1.getName()
            r0.set(r1)
        L_0x0158:
            androidx.databinding.i<java.lang.String> r0 = r2.l
            java.lang.Object r0 = r0.get()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x016d
            androidx.databinding.i<java.lang.Boolean> r0 = r2.f14309h
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.set(r1)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.transport.iocl.c.d.e():void");
    }
}
