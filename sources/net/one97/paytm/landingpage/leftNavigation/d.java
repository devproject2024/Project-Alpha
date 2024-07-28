package net.one97.paytm.landingpage.leftNavigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.threading.Task;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import io.reactivex.rxjava3.b.b;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.home.LeftNavigationModel;
import net.one97.paytm.common.entity.paymentsbank.CJRAccountSummary;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.activity.HomeActionBarBaseActivity;
import net.one97.paytm.landingpage.activity.HomeBaseActivity;
import net.one97.paytm.landingpage.c.a;
import net.one97.paytm.landingpage.leftNavigation.a;
import net.one97.paytm.landingpage.leftNavigation.d;
import net.one97.paytm.landingpage.leftNavigation.h;
import net.one97.paytm.landingpage.leftNavigation.model.CJRBankInfo;
import net.one97.paytm.landingpage.utils.g;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends h implements View.OnClickListener, a, a.c {
    /* access modifiers changed from: private */
    public g A;
    private b B = new b();
    private BroadcastReceiver C;
    private BroadcastReceiver D;
    private boolean E = false;
    /* access modifiers changed from: private */
    public boolean F = false;
    private boolean G = false;
    private BroadcastReceiver H;
    private BroadcastReceiver I;
    private BroadcastReceiver J;
    private boolean K = false;
    private z<SanitizedResponseModel> L;
    private List<com.paytmmall.clpartifact.modal.clpCommon.View> M = new ArrayList();
    private boolean N;
    private e O;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<IJRDataModel> f52834a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f52835b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52836c;

    /* renamed from: d  reason: collision with root package name */
    public String f52837d;

    /* renamed from: e  reason: collision with root package name */
    private DrawerLayout f52838e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f52839f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f52840g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f52841h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.landingpage.b.a f52842i;
    private String j = "";
    private Activity k;
    /* access modifiers changed from: private */
    public i l;
    private z<String> m;
    private z<net.one97.paytm.landingpage.leftNavigation.model.a> n;
    private z<Boolean> o;
    private z<Boolean> p;
    private boolean q;
    private boolean r;
    private List<com.paytmmall.clpartifact.modal.clpCommon.View> s = new ArrayList();
    private List<com.paytmmall.clpartifact.modal.clpCommon.View> t = new ArrayList();
    private List<com.paytmmall.clpartifact.modal.clpCommon.View> u = new ArrayList();
    private List<com.paytmmall.clpartifact.modal.clpCommon.View> v = new ArrayList();
    private String w;
    private boolean x;
    private z<CJRBankInfo> y;
    private z<CJRAccountSummary> z;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f52839f = context;
        if (context instanceof Activity) {
            this.k = (Activity) context;
        }
        if (context instanceof HomeActionBarBaseActivity) {
            this.f52838e = ((HomeActionBarBaseActivity) context).f52708d;
        } else if (context instanceof HomeBaseActivity) {
            this.f52838e = ((HomeBaseActivity) context).f52708d;
        }
        this.j = com.paytm.utility.a.b((Context) getActivity());
        this.K = true;
        this.O = new e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f52835b = new a(getActivity(), this.f52839f, this.f52834a, this.M, this, this, this.O);
        LeftNavigationModel leftNavigationModel = new LeftNavigationModel();
        leftNavigationModel.getClass();
        LeftNavigationModel.HeaderModel headerModel = new LeftNavigationModel.HeaderModel();
        this.E = net.one97.paytm.common.b.d.b().t();
        headerModel.setSecurityShieldEnabled(net.one97.paytm.common.b.d.b().j(this.f52839f) && this.E);
        leftNavigationModel.setHeader(headerModel);
        this.f52834a.add(leftNavigationModel);
        LeftNavigationModel leftNavigationModel2 = new LeftNavigationModel();
        leftNavigationModel2.getClass();
        LeftNavigationModel.HeaderModel headerModel2 = new LeftNavigationModel.HeaderModel();
        ArrayList arrayList = new ArrayList();
        arrayList.add(e.b.CONSUMER.name());
        if (net.one97.paytm.common.b.d.a().G(this.f52839f)) {
            arrayList.add(e.b.RESELLER.name());
        }
        if (net.one97.paytm.common.b.d.a().H(this.f52839f)) {
            arrayList.add(e.b.MERCHANT.name());
        }
        headerModel2.setAvailableProfiles(arrayList);
        String ak = com.paytm.utility.b.ak(this.f52839f);
        if (TextUtils.isEmpty(ak)) {
            ak = e.b.CONSUMER.name();
        }
        this.w = ak;
        headerModel2.setSelectedProfile(this.w);
        leftNavigationModel2.setHeader(headerModel2);
        this.f52834a.add(leftNavigationModel2);
        LeftNavigationModel leftNavigationModel3 = new LeftNavigationModel();
        leftNavigationModel3.getClass();
        leftNavigationModel3.setFooter(new LeftNavigationModel.FooterModel());
        this.f52834a.add(leftNavigationModel3);
        this.l = (i) am.a((Fragment) this).a(i.class);
        this.A = (g) am.a(getActivity()).a(g.class);
        Context context = this.f52839f;
        if (context != null && com.paytm.utility.a.p(context)) {
            this.n = new z() {
                public final void onChanged(Object obj) {
                    d.this.a((net.one97.paytm.landingpage.leftNavigation.model.a) obj);
                }
            };
            LeftNavigationModel leftNavigationModel4 = (LeftNavigationModel) this.f52834a.get(0);
            this.m = new z(leftNavigationModel4.getHeader(), leftNavigationModel4) {
                private final /* synthetic */ LeftNavigationModel.HeaderModel f$1;
                private final /* synthetic */ LeftNavigationModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onChanged(Object obj) {
                    d.this.a(this.f$1, this.f$2, (String) obj);
                }
            };
            this.y = new z() {
                public final void onChanged(Object obj) {
                    d.this.a((CJRBankInfo) obj);
                }
            };
            this.z = new z() {
                public final void onChanged(Object obj) {
                    d.this.a((CJRAccountSummary) obj);
                }
            };
            this.o = new z() {
                public final void onChanged(Object obj) {
                    d.this.c((Boolean) obj);
                }
            };
            this.p = new z() {
                public final void onChanged(Object obj) {
                    d.this.b((Boolean) obj);
                }
            };
            if (com.paytm.utility.a.p(this.f52839f)) {
                this.l.f52863a.observe(this, this.m);
                this.l.f52865c.observe(this, this.y);
                this.l.f52866d.observe(this, this.z);
                this.l.f52864b.observe(this, this.n);
                this.A.f52854a.observe(this, this.o);
                this.A.f52856c.observe(this, this.p);
                this.l.f52871i.observe(this, new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new kotlin.g.a.b() {
                    public final Object invoke(Object obj) {
                        return d.this.b((String) obj);
                    }
                }));
                this.l.f52870h.observe(this, new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new kotlin.g.a.b() {
                    public final Object invoke(Object obj) {
                        return d.this.a((Boolean) obj);
                    }
                }));
            }
            this.C = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    boolean unused = d.this.F = true;
                    d.this.a("I will do it later", "security_shield_off");
                    d.this.A.a(false);
                }
            };
            androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.C, new IntentFilter(net.one97.paytm.common.b.d.a().I()));
            this.D = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    d.this.A.a(net.one97.paytm.common.b.d.b().t());
                }
            };
            androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.D, new IntentFilter("update_flyout_app_lock_changed_security_settings"));
        }
        this.H = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getAction() != null && intent.getAction().equals("net.one97.paytm.action.ACTION_REFRESH_PSA") && net.one97.paytm.common.b.d.a().G(d.this.f52839f)) {
                    if (d.this.f52834a != null && d.this.f52834a.size() > 0) {
                        ((LeftNavigationModel) d.this.f52834a.get(1)).getHeader().getAvailableProfiles().add(e.b.RESELLER.name());
                    }
                    d.this.f52835b.notifyItemChanged(1);
                }
            }
        };
        this.I = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                d.this.d();
                d.this.l.d();
            }
        };
        this.J = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null && intent.getAction() != null && intent.getAction().equalsIgnoreCase("ACTION_UPDATE_PROFILE")) {
                    d.this.b();
                }
            }
        };
        androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.H, new IntentFilter("net.one97.paytm.action.ACTION_REFRESH_PSA"));
        androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.I, new IntentFilter(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
        androidx.localbroadcastmanager.a.a.a(this.f52839f.getApplicationContext()).a(this.J, new IntentFilter("ACTION_UPDATE_PROFILE"));
        this.L = new z() {
            public final void onChanged(Object obj) {
                d.this.a((SanitizedResponseModel) obj);
            }
        };
        ((w) this.l.f52869g.getValue()).observe(this, this.L);
        i iVar = this.l;
        y<SanitizedResponseModel> yVar = iVar.f52867e;
        f fVar = iVar.f52868f;
        b bVar = b.f52831a;
        SanitizedResponseModel a2 = b.a();
        if (a2 == null) {
            h hVar = h.f52857a;
            Context context2 = fVar.f52852a;
            k.c(context2, "context");
            String a3 = f.a(h.a(context2), context2);
            x.e eVar = new x.e();
            eVar.element = null;
            if (a3 != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new h.a(eVar, a3));
            }
            HomeResponse homeResponse = (HomeResponse) eVar.element;
            if (homeResponse != null) {
                a2 = fVar.a(homeResponse);
            }
            if (a2 == null) {
                h hVar2 = h.f52857a;
                HomeResponse b2 = h.b(fVar.f52852a);
                if (b2 != null) {
                    a2 = fVar.a(b2);
                }
                if (a2 == null) {
                    h hVar3 = h.f52857a;
                    HomeResponse c2 = h.c(fVar.f52852a);
                    if (c2 != null) {
                        a2 = fVar.a(c2);
                    }
                    if (a2 == null) {
                        a2 = null;
                    }
                }
            }
        }
        yVar.setValue(a2);
        if (bundle != null) {
            c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        List<com.paytmmall.clpartifact.modal.clpCommon.View> list;
        if (sanitizedResponseModel != null) {
            this.O.f52851a = sanitizedResponseModel.getGaEnableListener();
            this.M.clear();
            List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
            this.u.clear();
            this.s.clear();
            this.t.clear();
            this.v.clear();
            for (com.paytmmall.clpartifact.modal.clpCommon.View next : rvWidgets) {
                if (next != null) {
                    if (next.getSeourl() != null) {
                        String lowerCase = next.getSeourl().toLowerCase();
                        char c2 = 65535;
                        switch (lowerCase.hashCode()) {
                            case 542480154:
                                if (lowerCase.equals("https://user")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 822883735:
                                if (lowerCase.equals("https://merchant")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 977606465:
                                if (lowerCase.equals("https://reseller")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1371089177:
                                if (lowerCase.equals("https://logout")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            this.v.add(next);
                        } else if (c2 == 1) {
                            this.s.add(next);
                        } else if (c2 == 2) {
                            this.u.add(next);
                        } else if (c2 != 3) {
                            this.s.add(next);
                            this.u.add(next);
                            this.t.add(next);
                            this.v.add(next);
                        } else {
                            this.t.add(next);
                        }
                    } else {
                        this.s.add(next);
                        this.u.add(next);
                        this.t.add(next);
                        this.v.add(next);
                    }
                }
            }
            if (this.f52836c) {
                if (com.paytm.utility.b.ak(this.f52839f).equals(e.b.RESELLER.name())) {
                    list = this.s;
                } else if (com.paytm.utility.b.ak(this.f52839f).equals(e.b.MERCHANT.name())) {
                    list = this.t;
                } else {
                    list = this.u;
                }
                this.M.addAll(list);
            } else {
                this.M.addAll(this.v);
            }
            this.f52835b.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "profile_building");
        hashMap.put("creative", str2);
        hashMap.put(Payload.RESPONSE, str);
        net.one97.paytm.common.b.d.a().a(this.f52839f.getApplicationContext(), CLPConstants.GTM_SCREEN_NAME_FLYOUT, (Map<String, String>) hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        ArrayList<IJRDataModel> arrayList = this.f52834a;
        LeftNavigationModel leftNavigationModel = (arrayList == null || arrayList.size() <= 0) ? null : (LeftNavigationModel) this.f52834a.get(0);
        if (!(leftNavigationModel == null || leftNavigationModel.getHeader() == null)) {
            leftNavigationModel.getHeader().setSecurityShieldEnabled(bool.booleanValue());
            boolean booleanValue = bool.booleanValue();
            String str = bool.booleanValue() == this.E ? ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE : "success";
            if (this.G && !this.F) {
                new Handler().postDelayed(new Runnable(str, booleanValue) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ boolean f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        d.this.a(this.f$1, this.f$2);
                    }
                }, 200);
            }
            this.E = booleanValue;
            if (!bool.booleanValue()) {
                this.F = false;
            }
            this.f52835b.notifyItemChanged(0);
        }
        if (bool.booleanValue()) {
            this.l.d();
        }
        this.G = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        this.l.d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, boolean z2) {
        a(str, z2 ? "security_shield_on" : "security_shield_off");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_left_navigation, viewGroup, false);
        this.f52840g = (RecyclerView) inflate.findViewById(R.id.ln_left_nav_recycler_view);
        this.f52841h = (ProgressBar) inflate.findViewById(R.id.pb_share_upi);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f52839f);
        linearLayoutManager.setOrientation(1);
        this.f52840g.setLayoutManager(linearLayoutManager);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f52840g.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this.f52839f, R.anim.layout_animation_bottom_slide));
        }
        ((androidx.recyclerview.widget.y) this.f52840g.getItemAnimator()).m = false;
        this.f52840g.setAdapter(this.f52835b);
        if (com.paytm.utility.a.p(getActivity())) {
            this.f52836c = true;
        }
        if (this.f52836c) {
            d();
        }
        return inflate;
    }

    public void onClick(View view) {
        DrawerLayout drawerLayout = this.f52838e;
        if (drawerLayout != null) {
            drawerLayout.d(8388611);
        }
        new Handler().postDelayed(new Runnable(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                d.this.a(this.f$1);
            }
        }, 250);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        DrawerLayout drawerLayout;
        int id = view.getId();
        if (id == R.id.ln_profile_login) {
            f();
        } else if (id == R.id.ln_profile_signup) {
            e();
        } else if (id == R.id.close && (drawerLayout = this.f52838e) != null) {
            drawerLayout.d(8388611);
        }
    }

    public final void a() {
        if (this.f52839f != null) {
            net.one97.paytm.common.b.d.a().b(this.f52839f.getApplicationContext(), "", "profile_building", this.E ? "security_shield_on" : "security_shield_off");
        }
    }

    public final void b() {
        LeftNavigationModel leftNavigationModel = (LeftNavigationModel) this.f52834a.get(0);
        LeftNavigationModel.HeaderModel header = leftNavigationModel.getHeader();
        String a2 = s.a(getActivity());
        if (TextUtils.isEmpty(a2)) {
            String aa = com.paytm.utility.b.aa(this.f52839f);
            if (!TextUtils.isEmpty(aa)) {
                header.setName(com.paytm.utility.b.A(aa).trim());
            } else if (TextUtils.isEmpty(this.j)) {
                String ab = com.paytm.utility.b.ab(this.f52839f);
                if (!TextUtils.isEmpty(ab)) {
                    header.setName(ab.trim());
                }
            } else {
                header.setName(this.j.trim());
            }
            this.l.a();
        } else {
            header.setName(a2.trim());
        }
        this.f52834a.set(0, leftNavigationModel);
        this.f52835b.notifyItemChanged(0);
    }

    /* access modifiers changed from: private */
    public void d() {
        LeftNavigationModel.HeaderModel header = ((LeftNavigationModel) this.f52834a.get(0)).getHeader();
        String al = com.paytm.utility.b.al(this.f52839f);
        if (!TextUtils.isEmpty(al)) {
            header.setHeaderImageUrl(al);
            this.f52835b.notifyItemChanged(0);
            return;
        }
        header.setHeaderImageUrl("");
        this.f52835b.notifyItemChanged(0);
    }

    public void onDestroy() {
        super.onDestroy();
        androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.H);
        androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.I);
        androidx.localbroadcastmanager.a.a.a(this.f52839f.getApplicationContext()).a(this.J);
        b bVar = this.B;
        if (bVar != null) {
            bVar.a();
        }
        Context context = this.f52839f;
        if (context != null && com.paytm.utility.a.p(context)) {
            androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.C);
            androidx.localbroadcastmanager.a.a.a(this.f52839f).a(this.D);
        }
    }

    public final void a(View view, int i2, final LeftNavigationModel leftNavigationModel) {
        if (!this.q) {
            this.q = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    d.this.l();
                }
            }, 500);
            if (i2 == 0) {
                if (view.getId() == R.id.ln_profile_login) {
                    DrawerLayout drawerLayout = this.f52838e;
                    if (drawerLayout != null) {
                        drawerLayout.a();
                    }
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            d.this.f();
                        }
                    }, 250);
                } else if (view.getId() == R.id.ln_profile_signup) {
                    DrawerLayout drawerLayout2 = this.f52838e;
                    if (drawerLayout2 != null) {
                        drawerLayout2.a();
                    }
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            d.this.e();
                        }
                    }, 250);
                } else if (view.getId() == R.id.iv_left_navi || view.getId() == R.id.view_login || view.getId() == R.id.ln_name_tv || view.getId() == R.id.tv_edit_profile) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            d.this.k();
                        }
                    }, 500);
                    net.one97.paytm.common.b.d.a().a(getContext().getApplicationContext(), CLPConstants.GTM_SCREEN_NAME_FLYOUT, "/-menu_items", "Header");
                } else if (view.getId() == R.id.share_upi_iv || view.getId() == R.id.upi_id_tv) {
                    if (this.f52841h.getVisibility() != 0) {
                        this.f52841h.setVisibility(0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("af_dp", "paytmmp://cash_wallet?featuretype=sendmoneymobile$recipient=" + com.paytm.utility.a.b(getContext()) + "$amount=$comment=");
                        hashMap.put("af_scheme", "paytmmp://cash_wallet");
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("featuretype", "sendmoneymobile");
                            jSONObject.put("recipient", com.paytm.utility.a.b(getContext()));
                            jSONObject.put("amount", "");
                            jSONObject.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, "");
                            hashMap.put("af_scheme_parameter", jSONObject.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        net.one97.paytm.common.b.d.a().a(getContext(), "social", hashMap, (m<String, Integer, Object>) new m<String, Integer, Object>() {
                            public final /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return a((String) obj);
                            }

                            private Object a(String str) {
                                Intent intent;
                                Task.runOnMainThread(new Runnable() {
                                    public final void run() {
                                        d.AnonymousClass6.this.a();
                                    }
                                });
                                String string = d.this.getContext().getString(R.string.upi_id_share, new Object[]{leftNavigationModel.getHeader().getName(), leftNavigationModel.getHeader().getPrimaryUpiId(), str});
                                Intent intent2 = new Intent(d.this.getContext(), ShareUPIReceiver.class);
                                intent2.putExtra("UPI_ID", leftNavigationModel.getHeader().getPrimaryUpiId());
                                PendingIntent broadcast = PendingIntent.getBroadcast(d.this.getContext(), 5557, intent2, 134217728);
                                Intent intent3 = new Intent();
                                intent3.setAction("android.intent.action.SEND");
                                intent3.putExtra("android.intent.extra.TEXT", string);
                                intent3.setType("text/plain");
                                if (Build.VERSION.SDK_INT >= 22) {
                                    intent = Intent.createChooser(intent3, (CharSequence) null, broadcast.getIntentSender());
                                } else {
                                    intent = Intent.createChooser(intent3, (CharSequence) null);
                                }
                                if (intent.resolveActivity(d.this.getContext().getPackageManager()) != null) {
                                    d.this.startActivity(intent, (Bundle) null);
                                }
                                g.a(d.this.getContext(), "Flyout", "Sharing_UPI", leftNavigationModel.getHeader().getPrimaryUpiId());
                                return null;
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ void a() {
                                d.this.f52841h.setVisibility(8);
                            }
                        });
                    }
                } else if (view.getId() == R.id.iv_back_left_navi) {
                    DrawerLayout drawerLayout3 = this.f52838e;
                    if (drawerLayout3 != null) {
                        drawerLayout3.a();
                    }
                } else if (view.getId() == R.id.link_bank_iv || view.getId() == R.id.link_bank_tv) {
                    g.a(this.f52839f, "Flyout", "Link_Account", "/");
                    String primaryUpiId = leftNavigationModel.getHeader().getPrimaryUpiId();
                    if (this.N) {
                        if (!net.one97.paytm.upi.registration.b.a.a.a.a(this.f52839f.getApplicationContext()).h()) {
                            if (!TextUtils.isEmpty(primaryUpiId)) {
                                UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                                UpiAddBankHelperActivity.a.a(this.f52839f, primaryUpiId);
                            } else {
                                DrawerLayout drawerLayout4 = this.f52838e;
                                if (drawerLayout4 != null) {
                                    drawerLayout4.a();
                                }
                                new Handler().postDelayed(new Runnable() {
                                    public final void run() {
                                        net.one97.paytm.common.b.d.b().a(d.this.getContext(), "paytmmp://upi_landing");
                                    }
                                }, 250);
                            }
                        }
                    } else if (UpiUtils.isInActiveProfileExist(this.f52839f.getApplicationContext())) {
                        startActivity(UpiUtils.getUpiLandingPageActivityIntent(getContext()));
                    } else {
                        startActivity(new Intent(getContext(), UpiSelectBankActivity.class));
                    }
                } else if (view.getId() == R.id.switch_security_shield) {
                    this.G = true;
                    ArrayList<IJRDataModel> arrayList = this.f52834a;
                    LeftNavigationModel leftNavigationModel2 = (arrayList == null || arrayList.size() <= 0) ? null : (LeftNavigationModel) this.f52834a.get(0);
                    if (!(leftNavigationModel2 == null || leftNavigationModel2.getHeader() == null)) {
                        if (!net.one97.paytm.common.b.d.b().j(this.f52839f)) {
                            net.one97.paytm.common.b.d.b().a(this.f52839f, "paytmmp://login?screen=setAppLock&requestCode=5556");
                        } else if (leftNavigationModel2.getHeader().isSecurityShieldEnabled()) {
                            net.one97.paytm.common.b.d.b().a(this.f52839f, "paytmmp://login?screen=deactivateAppLock&requestCode=".concat("5554"));
                        } else {
                            net.one97.paytm.common.b.d.b().a(this.f52839f, "paytmmp://login?screen=activateAppLock&requestCode=".concat("5555"));
                        }
                    }
                }
            }
            if (i2 != 1) {
                return;
            }
            if (view.getId() == R.id.tv_personal_profile && !this.w.equalsIgnoreCase(e.b.CONSUMER.name())) {
                ((LeftNavigationModel) this.f52834a.get(1)).getHeader().setSelectedProfile(e.b.CONSUMER.name());
                this.M.clear();
                this.M.addAll(this.u);
                this.f52835b.notifyDataSetChanged();
                this.w = e.b.CONSUMER.name();
                com.paytm.utility.b.y(this.f52839f, this.w);
            } else if (view.getId() == R.id.tv_service_profile && !this.w.equalsIgnoreCase(e.b.RESELLER.name())) {
                ((LeftNavigationModel) this.f52834a.get(1)).getHeader().setSelectedProfile(e.b.RESELLER.name());
                this.M.clear();
                this.M.addAll(this.s);
                this.f52835b.notifyDataSetChanged();
                this.w = e.b.RESELLER.name();
                com.paytm.utility.b.y(this.f52839f, this.w);
            } else if (view.getId() == R.id.tv_merchant_profile && !this.w.equalsIgnoreCase(e.b.MERCHANT.name())) {
                ((LeftNavigationModel) this.f52834a.get(1)).getHeader().setSelectedProfile(e.b.MERCHANT.name());
                this.M.clear();
                this.M.addAll(this.t);
                this.f52835b.notifyDataSetChanged();
                this.w = e.b.MERCHANT.name();
                com.paytm.utility.b.y(this.f52839f, this.w);
            } else if (view.getId() != R.id.tv_ppbl_check_balance) {
            } else {
                if (com.paytm.utility.a.m(this.f52839f)) {
                    i iVar = this.l;
                    net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
                    iVar.getApplication();
                    String a2 = b2.a(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW);
                    k.a((Object) a2, "HomeHelper.getAppLaunchM…M.KEY_CHECK_PPBL_BALANCE)");
                    Map<String, String> linkedHashMap = new LinkedHashMap<>();
                    String lowerCase = "Authorization".toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    String b3 = net.one97.paytm.common.b.d.a().b((Context) iVar.getApplication());
                    k.a((Object) b3, "HomeHelper.getModuleInte…SOToken(getApplication())");
                    linkedHashMap.put(lowerCase, b3);
                    linkedHashMap.put("Content-Type", "application/json");
                    linkedHashMap.put("channel", UpiConstants.B2C_ANDROID);
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42885i = new CJRAccountSummary();
                    bVar.f42879c = a.C0715a.GET;
                    bVar.f42878b = a.c.HOME;
                    bVar.f42882f = linkedHashMap;
                    bVar.f42880d = a2;
                    bVar.f42884h = null;
                    bVar.n = a.b.SILENT;
                    bVar.f42877a = iVar.getApplication();
                    bVar.o = "javaClass";
                    bVar.j = iVar;
                    bVar.l().a();
                    return;
                }
                com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
                hVar.setTitle(getResources().getString(R.string.no_connection));
                hVar.a(getResources().getString(R.string.no_internet));
                hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                    public final void onClick(View view) {
                        com.paytm.utility.h.this.cancel();
                    }
                });
                hVar.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.q = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        if (isAdded()) {
            startActivity(net.one97.paytm.common.b.d.a().l(this.f52839f));
        }
    }

    public final void a(String str) {
        this.f52842i = new net.one97.paytm.landingpage.b.a();
        this.f52842i.execute(new String[]{str});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRBankInfo cJRBankInfo) {
        if (cJRBankInfo != null) {
            this.x = true;
            this.f52837d = cJRBankInfo.getAccountNo();
            ((LeftNavigationModel) this.f52834a.get(1)).getHeader().setAccountNumber(net.one97.paytm.landingpage.utils.d.a(this.f52837d));
            this.f52835b.notifyItemChanged(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRAccountSummary cJRAccountSummary) {
        if (isAdded() && cJRAccountSummary != null) {
            LeftNavigationModel.HeaderModel header = ((LeftNavigationModel) this.f52834a.get(1)).getHeader();
            String string = this.f52839f.getString(R.string.rupee_string);
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(cJRAccountSummary.getEffectiveBalance());
            if (!TextUtils.isEmpty(valueOf) && !valueOf.equals(AppUtility.CENTER_DOT)) {
                valueOf = new DecimalFormat(AppConstants.PRICE_PATTERN, DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(new BigDecimal(valueOf));
            }
            objArr[0] = valueOf;
            header.setAccountBalance(String.format(string, objArr));
            this.f52835b.notifyItemChanged(1);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                d.this.i();
            }
        }, 250);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        getActivity().runOnUiThread(new Runnable() {
            public final void run() {
                d.this.j();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        if (com.paytm.utility.a.p(getActivity())) {
            startActivity(net.one97.paytm.common.b.d.a().l(this.k));
        } else {
            a((String) null, getActivity().getString(R.string.sign_up), true);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (getActivity() != null) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    d.this.g();
                }
            }, 250);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        getActivity().runOnUiThread(new Runnable() {
            public final void run() {
                d.this.h();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (com.paytm.utility.a.p(getActivity())) {
            startActivity(net.one97.paytm.common.b.d.a().l(this.k));
        } else {
            a(getActivity().getString(R.string.hello_sign_in), (String) null, false);
        }
    }

    private void a(String str, String str2, boolean z2) {
        String str3;
        Intent b2 = net.one97.paytm.common.b.d.a().b(this.k);
        b2.putExtra("isUpiFlow", true);
        b2.putExtra("sign_in_sign_up_with_step_2", true);
        if (!TextUtils.isEmpty(str)) {
            b2.putExtra("sign_in_title", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            b2.putExtra("sign_up_title", str2);
        }
        if (z2) {
            b2.putExtra("launchSignUp", true);
            str3 = "/signup_clicked_from_hmenu";
        } else {
            str3 = "/login_clicked_from_hmenu";
        }
        b2.putExtra("previous_screen_name", str3);
        b2.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        b2.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
        getActivity().startActivityForResult(b2, 111);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(LeftNavigationModel.HeaderModel headerModel, LeftNavigationModel leftNavigationModel, String str) {
        if (!TextUtils.isEmpty(str)) {
            headerModel.setName(com.paytm.utility.b.A(str).trim());
            this.f52834a.set(0, leftNavigationModel);
            this.f52835b.notifyItemChanged(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.landingpage.leftNavigation.model.a aVar) {
        if (!isAdded() || aVar.f52877a == null || aVar.f52877a.getStatusCode() == 401 || aVar.f52877a.getStatusCode() == 410) {
            this.r = true;
            Bundle bundle = new Bundle();
            bundle.putBoolean("isLeftNavSessionTimeout", this.r);
            FragmentActivity activity = getActivity();
            new NetworkCustomError();
            r.a(activity, (String) null, bundle, false, true);
        } else if (aVar.f52878b instanceof CJRBankInfo) {
            ((LeftNavigationModel) this.f52834a.get(1)).getHeader().setAccountNumber("");
            this.f52835b.notifyItemChanged(1);
        }
    }

    public final void c() {
        if (this.K && com.paytm.utility.a.m(this.f52839f)) {
            this.K = false;
            this.l.c();
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing() && com.paytm.utility.a.p(this.k.getApplicationContext())) {
            b();
            this.l.e();
            ((LeftNavigationModel) this.f52834a.get(0)).getHeader();
            if (net.one97.paytm.common.b.d.a().G(this.f52839f) && !this.x) {
                this.l.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ kotlin.x b(String str) {
        LeftNavigationModel leftNavigationModel = (LeftNavigationModel) this.f52834a.get(0);
        leftNavigationModel.getHeader().setPrimaryUpiId(str);
        this.f52834a.set(0, leftNavigationModel);
        this.f52835b.notifyItemChanged(0);
        return kotlin.x.f47997a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ kotlin.x a(Boolean bool) {
        LeftNavigationModel leftNavigationModel = (LeftNavigationModel) this.f52834a.get(0);
        leftNavigationModel.getHeader().setShowLinkBankAccount(true);
        this.f52834a.set(0, leftNavigationModel);
        this.f52835b.notifyItemChanged(0);
        return kotlin.x.f47997a;
    }
}
