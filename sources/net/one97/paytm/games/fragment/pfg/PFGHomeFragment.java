package net.one97.paytm.games.fragment.pfg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.o;
import net.one97.paytm.games.R;
import net.one97.paytm.games.activity.GpGamePassbookActivity;
import net.one97.paytm.games.activity.PfgHomeActivity;
import net.one97.paytm.games.e.a.e;
import net.one97.paytm.games.e.c;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.g;
import net.one97.paytm.games.e.k;
import net.one97.paytm.games.fragment.b;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpTasksListResponse;
import net.one97.paytm.games.model.PFGWalletBalancesResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.model.pfg.HomePageResponse;
import net.one97.paytm.games.model.pfg.PFGWalletBalances;
import net.one97.paytm.games.model.pfg.RecentGameResponse;
import org.json.JSONArray;

public class PFGHomeFragment extends b implements com.paytm.network.listener.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f35682a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35683b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35684c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f35685d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public SwipeRefreshLayout f35686e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f35687f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f35688g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f35689h;

    /* renamed from: i  reason: collision with root package name */
    private b f35690i;
    private a j;
    /* access modifiers changed from: private */
    public j k;
    private AtomicInteger l = new AtomicInteger(1);
    /* access modifiers changed from: private */
    public AlertDialog m;
    /* access modifiers changed from: private */
    public JSONArray n;
    private net.one97.paytm.games.fragment.a.b o;
    private BroadcastReceiver p = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (f.a((Activity) PFGHomeFragment.this.getActivity()) || !"action_update_login_status".equals(intent.getAction())) {
                return;
            }
            if (a.p(context)) {
                PFGHomeFragment.this.a(false);
                return;
            }
            if (PFGHomeFragment.this.f35687f != null) {
                PFGHomeFragment.this.f35687f.setText("-");
                PFGHomeFragment.this.f35687f.setVisibility(8);
                PFGHomeFragment.this.a();
            }
            if (PFGHomeFragment.this.f35688g != null) {
                PFGHomeFragment.this.f35688g.setVisibility(8);
            }
            if (PFGHomeFragment.this.k != null) {
                Fragment c2 = PFGHomeFragment.this.k.c("MessageDialog");
                if (c2 instanceof androidx.fragment.app.b) {
                    ((androidx.fragment.app.b) c2).dismissAllowingStateLoss();
                }
                Fragment c3 = PFGHomeFragment.this.k.c("BonusDialog");
                if (c3 instanceof androidx.fragment.app.b) {
                    ((androidx.fragment.app.b) c3).dismissAllowingStateLoss();
                }
            }
            if (PFGHomeFragment.this.m != null) {
                PFGHomeFragment.this.m.dismiss();
                AlertDialog unused = PFGHomeFragment.this.m = null;
            }
        }
    };

    public void onAttach(Context context) {
        super.onAttach(context);
        androidx.localbroadcastmanager.a.a.a(context).a(this.p, new IntentFilter("action_update_login_status"));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = getChildFragmentManager();
        this.o = (net.one97.paytm.games.fragment.a.b) am.a((Fragment) this).a(net.one97.paytm.games.fragment.a.b.class);
        this.o.f35639h.observe(this, new z() {
            public final void onChanged(Object obj) {
                PFGHomeFragment.this.a((GpTasksListResponse.GpTask) obj);
            }
        });
        this.o.f35631c.observe(this, new z() {
            public final void onChanged(Object obj) {
                PFGHomeFragment.this.b((o) obj);
            }
        });
        this.o.f35629a.observe(this, new z() {
            public final void onChanged(Object obj) {
                PFGHomeFragment.this.a((o) obj);
            }
        });
        a(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(GpTasksListResponse.GpTask gpTask) {
        if (gpTask != null) {
            this.o.b();
        }
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(o oVar) {
        int i2 = 8;
        if (oVar.getSecond() == null || ((Integer) oVar.getFirst()).intValue() != 6) {
            this.f35687f.setText("-");
            this.f35687f.setVisibility(0);
            ViewGroup viewGroup = this.f35688g;
            net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
            if (net.one97.paytm.games.e.b.b()) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
            return;
        }
        int i3 = ((PFGWalletBalancesResponse) oVar.getSecond()).code;
        if (i3 == 2001) {
            PFGWalletBalances balances = ((PFGWalletBalancesResponse) oVar.getSecond()).getBalances();
            net.one97.paytm.games.e.b bVar2 = net.one97.paytm.games.e.b.f35599a;
            Double d2 = null;
            if (net.one97.paytm.games.e.b.c().getValue().booleanValue()) {
                if (balances != null) {
                    d2 = balances.getTotal_balance();
                }
            } else if (balances != null) {
                d2 = balances.getBonus_balance();
            }
            if (d2 == null || d2.doubleValue() == 0.0d) {
                this.f35687f.setText("0");
                this.f35688g.setVisibility(8);
            } else {
                this.f35687f.setText(k.a(d2.doubleValue()));
                ViewGroup viewGroup2 = this.f35688g;
                net.one97.paytm.games.e.b bVar3 = net.one97.paytm.games.e.b.f35599a;
                if (net.one97.paytm.games.e.b.b()) {
                    i2 = 0;
                }
                viewGroup2.setVisibility(i2);
                e();
            }
            this.f35687f.setVisibility(0);
        } else if (i3 != 2055) {
            if (i3 == 3012) {
                a((GpCommonBaseResponse) oVar.getSecond());
            }
            this.f35687f.setText("-");
            this.f35687f.setVisibility(0);
            ViewGroup viewGroup3 = this.f35688g;
            net.one97.paytm.games.e.b bVar4 = net.one97.paytm.games.e.b.f35599a;
            if (net.one97.paytm.games.e.b.b()) {
                i2 = 0;
            }
            viewGroup3.setVisibility(i2);
        } else {
            i();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(o oVar) {
        if (((Integer) oVar.getFirst()).intValue() == 0) {
            this.f35689h.setVisibility(0);
            return;
        }
        this.f35689h.setVisibility(8);
        if (oVar.getSecond() != null) {
            this.f35690i = new b();
            this.f35690i.f35701a = ((GpCommonBaseResponse) oVar.getSecond()).code;
            this.f35690i.f35702b = new Runnable() {
                public final void run() {
                    PFGHomeFragment.this.m();
                }
            };
            f();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.o.c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pfg_home, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof PfgHomeActivity) {
            inflate.setPadding(0, 0, 0, 0);
            View findViewById = inflate.findViewById(R.id.img_back_arrow);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener(activity) {
                private final /* synthetic */ Activity f$0;

                {
                    this.f$0 = r1;
                }

                public final void onClick(View view) {
                    PFGHomeFragment.a(this.f$0, view);
                }
            });
        }
        if (getActivity() != null && "net.one97.paytm.dynamic.module.updates.AJRDiscovery".equals(getActivity().getClass().getCanonicalName())) {
            inflate.setPadding(0, 0, 0, 0);
        }
        this.f35686e = (SwipeRefreshLayout) inflate.findViewById(R.id.swipeLayoutHome);
        this.f35688g = (ViewGroup) inflate.findViewById(R.id.root_use_bonus_now);
        this.f35688g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PFGHomeFragment.this.b(view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_use_bonus_now);
        net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
        if (net.one97.paytm.games.e.b.b()) {
            net.one97.paytm.games.e.b bVar2 = net.one97.paytm.games.e.b.f35599a;
            textView.setText(net.one97.paytm.games.e.b.a().getValue().getText());
        }
        this.f35689h = (ProgressBar) inflate.findViewById(R.id.pb_use_bonus_now);
        this.f35687f = (TextView) inflate.findViewById(R.id.text_wallet_balance);
        this.f35687f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PFGHomeFragment.this.a(view);
            }
        });
        this.f35685d = (RecyclerView) inflate.findViewById(R.id.recyclerHome);
        a();
        return inflate;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, View view) {
        if (!f.a(activity)) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        f.a(g.a().b(), "/inbox/games/use-bonus-now", "pfg_bonus", "use_bonus_clicked", "", "");
        net.one97.paytm.games.fragment.a.b bVar = this.o;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        f.a(getActivity(), f.c(getActivity(), "/inbox/games"), "pfg_rewards", "balance_clicked", (String) null, (String) null);
        getActivity().startActivity(new Intent(getActivity(), GpGamePassbookActivity.class));
        if (this.f35687f.getText().equals("-")) {
            this.o.b();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        FragmentActivity activity = getActivity();
        if (isAdded() && this.f35684c) {
            if (activity != null && !f.a((Context) activity)) {
                return;
            }
            if (net.one97.paytm.games.b.a.a() == null) {
                this.f35688g.setVisibility(8);
                this.f35687f.setText("-");
                this.f35687f.setVisibility(8);
                if (a.p(activity) && !this.f35683b) {
                    this.f35683b = true;
                    net.one97.paytm.games.e.a.a((Context) activity, (com.paytm.network.listener.b) this, "PFGHomeFragment", a.b.USER_FACING, (String) null);
                    return;
                }
                return;
            }
            d();
            this.o.b();
            if (!z) {
                b();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        Context context = getContext();
        if (context == null || f.a(context)) {
            this.f35686e.setRefreshing(true);
            net.one97.paytm.games.e.a.a(getActivity(), new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (!f.a((Activity) PFGHomeFragment.this.getActivity())) {
                        if (iJRPaytmDataModel instanceof HomePageResponse) {
                            HomePageResponse homePageResponse = (HomePageResponse) iJRPaytmDataModel;
                            if (homePageResponse.getJsonDataArray() != null) {
                                JSONArray unused = PFGHomeFragment.this.n = homePageResponse.getJsonDataArray();
                                PFGHomeFragment.this.b();
                            }
                        }
                        PFGHomeFragment.this.f35686e.setRefreshing(false);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (!f.a((Activity) PFGHomeFragment.this.getActivity())) {
                        PFGHomeFragment.this.f35686e.setRefreshing(false);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        FragmentActivity activity = getActivity();
        if (!this.f35682a && this.n != null && !f.a((Activity) activity) && net.one97.paytm.games.b.a.a() != null) {
            this.f35682a = true;
            this.f35686e.setRefreshing(true);
            net.one97.paytm.games.e.a.a(activity.getApplicationContext(), "1", net.one97.paytm.games.b.a.a().masked_msisdn, (IJRPaytmDataModel) new RecentGameResponse(), (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (!f.a((Activity) PFGHomeFragment.this.getActivity())) {
                        if (iJRPaytmDataModel instanceof RecentGameResponse) {
                            RecentGameResponse recentGameResponse = (RecentGameResponse) iJRPaytmDataModel;
                            if (!f.a((Object) recentGameResponse.getJsonString())) {
                                PFGHomeFragment pFGHomeFragment = PFGHomeFragment.this;
                                e eVar = e.f35596a;
                                JSONArray unused = pFGHomeFragment.n = e.a(PFGHomeFragment.this.n, "home_page_recent", recentGameResponse.getJsonString());
                            }
                        }
                        boolean unused2 = PFGHomeFragment.this.f35682a = false;
                        PFGHomeFragment.this.f35686e.setRefreshing(false);
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    if (!f.a((Activity) PFGHomeFragment.this.getActivity())) {
                        boolean unused = PFGHomeFragment.this.f35682a = false;
                        PFGHomeFragment.this.f35686e.setRefreshing(false);
                    }
                }
            });
        }
    }

    public final void a(int i2, Object obj) {
        if (i2 == 3 && obj == NetworkInfo.State.CONNECTED) {
            a();
            a(true);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        this.f35683b = false;
        if (!f.a((Activity) getActivity()) && (iJRPaytmDataModel instanceof CJRSignupUser)) {
            CJRSignupUser cJRSignupUser = (CJRSignupUser) iJRPaytmDataModel;
            if (cJRSignupUser.code == 2001) {
                net.one97.paytm.games.b.a.a(cJRSignupUser);
                d();
                net.one97.paytm.games.fragment.a.b bVar = this.o;
                if (bVar != null) {
                    bVar.b();
                }
                b();
            } else if (cJRSignupUser.code == 3012) {
                a((GpCommonBaseResponse) cJRSignupUser);
            } else if (cJRSignupUser.code == 2055) {
                i();
            } else {
                k();
                a((GpCommonBaseResponse) cJRSignupUser, "CS");
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f35683b = false;
        if (!f.a((Activity) getActivity()) && (iJRPaytmDataModel instanceof CJRSignupUser)) {
            CJRSignupUser cJRSignupUser = (CJRSignupUser) iJRPaytmDataModel;
            CJRSignupUser cJRSignupUser2 = (CJRSignupUser) f.a(networkCustomError, cJRSignupUser, CJRSignupUser.class);
            if (cJRSignupUser2 == null) {
                a((GpCommonBaseResponse) cJRSignupUser, "CS");
            } else {
                onApiSuccess(cJRSignupUser2);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.f35684c = true;
        FragmentActivity activity = getActivity();
        g.a().c().sendOpenScreenWithDeviceInfo(f.c(activity, "/inbox/games"), "inbox", activity);
        if (activity == null || f.a((Context) activity)) {
            a(false);
        } else {
            Toast.makeText(activity, R.string.com_gamepind_msg_network_connectivity, 0).show();
        }
        e();
        j();
    }

    public void onPause() {
        super.onPause();
        this.f35684c = false;
    }

    public void onDetach() {
        androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p);
        this.o = null;
        super.onDetach();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private boolean c() {
        boolean isAdded = isAdded();
        boolean z = net.one97.paytm.games.b.a.a() != null;
        boolean z2 = !f.a((Object) net.one97.paytm.games.b.a.a().access_token);
        net.one97.paytm.games.fragment.a.b bVar = this.o;
        return isAdded && z && z2 && (bVar != null && !bVar.f35640i);
    }

    private void d() {
        if (c()) {
            g a2 = g.a();
            getContext();
            String str = a2.f().ruleId;
            if (f.a((Object) str) || H5BridgeContext.INVALID_ID.equalsIgnoreCase(str)) {
                if (net.one97.paytm.games.b.a.c().longValue() == 0) {
                    net.one97.paytm.games.b.a.a(f.a());
                }
                this.o.f35639h.setValue(null);
            } else if (net.one97.paytm.games.b.a.c().longValue() > 0) {
                this.o.f35639h.setValue(null);
            } else {
                this.o.a(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r12 = this;
            java.lang.String r0 = "ctaLink"
            net.one97.paytm.games.fragment.a.b r1 = r12.o
            boolean r1 = r1.f35640i
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            net.one97.paytm.games.model.GpTasksListResponse$GpTask r1 = net.one97.paytm.games.b.a.b()
            java.lang.String r2 = "message"
            java.lang.String r3 = "ctaText"
            if (r1 != 0) goto L_0x00ca
            net.one97.paytm.games.e.g r0 = net.one97.paytm.games.e.g.a()
            java.text.SimpleDateFormat r0 = r0.f35616c
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = net.one97.paytm.games.b.a.c()
            long r6 = r1.longValue()
            boolean r0 = net.one97.paytm.games.e.f.a((java.text.SimpleDateFormat) r0, (long) r4, (long) r6)
            if (r0 == 0) goto L_0x00c6
            net.one97.paytm.games.e.b r0 = net.one97.paytm.games.e.b.f35599a
            boolean r0 = net.one97.paytm.games.e.b.b()
            if (r0 == 0) goto L_0x00c6
            android.widget.TextView r0 = r12.f35687f
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r1 = "-"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            android.widget.TextView r0 = r12.f35687f
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            goto L_0x00c6
        L_0x0050:
            java.lang.String r0 = "Hey There, You have Rs <Amount> in your Paytm First Games Balance."
            net.one97.paytm.games.e.b r1 = net.one97.paytm.games.e.b.f35599a
            kotlin.g r1 = net.one97.paytm.games.e.b.a()
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.games.model.pfg.GamesHeaderSmsData r1 = (net.one97.paytm.games.model.pfg.GamesHeaderSmsData) r1
            java.lang.String r4 = "Use Balance Now"
            if (r1 == 0) goto L_0x007e
            java.lang.String r5 = r1.getMessage()
            boolean r5 = net.one97.paytm.games.e.f.a((java.lang.Object) r5)
            if (r5 != 0) goto L_0x0070
            java.lang.String r0 = r1.getMessage()
        L_0x0070:
            java.lang.String r5 = r1.getText()
            boolean r5 = net.one97.paytm.games.e.f.a((java.lang.Object) r5)
            if (r5 != 0) goto L_0x007e
            java.lang.String r4 = r1.getText()
        L_0x007e:
            java.lang.String r1 = "<Amount>"
            boolean r5 = r0.contains(r1)
            if (r5 == 0) goto L_0x0094
            android.widget.TextView r5 = r12.f35687f
            java.lang.CharSequence r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = r0.replace(r1, r5)
        L_0x0094:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r1.putString(r2, r0)
            r1.putString(r3, r4)
            net.one97.paytm.games.fragment.pfg.a r0 = new net.one97.paytm.games.fragment.pfg.a
            r0.<init>()
            r12.j = r0
            net.one97.paytm.games.fragment.pfg.a r0 = r12.j
            r0.setArguments(r1)
            net.one97.paytm.games.fragment.pfg.a r0 = r12.j
            net.one97.paytm.games.fragment.pfg.-$$Lambda$PFGHomeFragment$FT--TaMPMMw5dEd9cf-stRwrZeI r1 = new net.one97.paytm.games.fragment.pfg.-$$Lambda$PFGHomeFragment$FT--TaMPMMw5dEd9cf-stRwrZeI
            r1.<init>()
            r0.f35695a = r1
            boolean r0 = r12.g()
            if (r0 == 0) goto L_0x00c5
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            net.one97.paytm.games.b.a.a((java.lang.Long) r0)
        L_0x00c5:
            return
        L_0x00c6:
            r12.f()
            return
        L_0x00ca:
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r6 = r1.getAttributes()     // Catch:{ Exception -> 0x00f1 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r6 = "msgPaytm"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = "currency"
            java.lang.String r7 = r5.optString(r7)     // Catch:{ Exception -> 0x00ef }
            java.lang.String r8 = "Use Bonus Now"
            java.lang.String r8 = r5.optString(r3, r8)     // Catch:{ Exception -> 0x00ed }
            java.lang.String r9 = "paytmmp://cash_wallet?featuretype=cash_ledger&tab=Paytmfirstgames"
            java.lang.String r5 = r5.optString(r0, r9)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00f5
        L_0x00ed:
            r8 = r4
            goto L_0x00f4
        L_0x00ef:
            r7 = r4
            goto L_0x00f3
        L_0x00f1:
            r6 = r4
            r7 = r6
        L_0x00f3:
            r8 = r7
        L_0x00f4:
            r5 = r4
        L_0x00f5:
            boolean r9 = net.one97.paytm.games.e.f.a((java.lang.Object) r6)
            if (r9 == 0) goto L_0x00fe
            java.lang.String r6 = "Has been credited in your Paytm First Games Balance! Use this balance to play games and win paytm cash"
            goto L_0x0106
        L_0x00fe:
            java.lang.String r9 = "\\n"
            java.lang.String r10 = "\n"
            java.lang.String r6 = r6.replace(r9, r10)
        L_0x0106:
            boolean r9 = net.one97.paytm.games.e.f.a((java.lang.Object) r7)
            java.lang.String r10 = "bonus"
            if (r9 != 0) goto L_0x013b
            java.lang.String r9 = "paytm"
            boolean r9 = r9.equalsIgnoreCase(r7)
            if (r9 != 0) goto L_0x013b
            boolean r9 = r10.equalsIgnoreCase(r7)
            if (r9 == 0) goto L_0x011d
            goto L_0x013b
        L_0x011d:
            java.lang.String r9 = "beans"
            boolean r9 = r9.equalsIgnoreCase(r7)
            if (r9 == 0) goto L_0x014e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r1 = r1.getPointsFromClaimBean()
            r7.append(r1)
            java.lang.String r1 = " Points"
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            goto L_0x014e
        L_0x013b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "₹ "
            r7.<init>(r9)
            int r1 = r1.getPointsFromClaimBean()
            r7.append(r1)
            java.lang.String r7 = r7.toString()
        L_0x014e:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            int r9 = net.one97.paytm.games.R.string.com_gamepind_congratulations
            java.lang.String r9 = r12.getString(r9)
            java.lang.String r11 = "title"
            r1.putString(r11, r9)
            r1.putString(r2, r6)
            r1.putString(r10, r7)
            r1.putString(r3, r8)
            r1.putString(r0, r5)
            net.one97.paytm.games.fragment.pfg.a r0 = new net.one97.paytm.games.fragment.pfg.a
            r0.<init>()
            r12.j = r0
            net.one97.paytm.games.fragment.pfg.a r0 = r12.j
            r0.setArguments(r1)
            net.one97.paytm.games.fragment.pfg.a r0 = r12.j
            net.one97.paytm.games.fragment.pfg.-$$Lambda$PFGHomeFragment$OFaIgI66qF0Po-oROO6qbaKh66M r1 = new net.one97.paytm.games.fragment.pfg.-$$Lambda$PFGHomeFragment$OFaIgI66qF0Po-oROO6qbaKh66M
            r1.<init>(r5)
            r0.f35695a = r1
            boolean r0 = r12.g()
            if (r0 == 0) goto L_0x0189
            net.one97.paytm.games.b.a.a((net.one97.paytm.games.model.GpTasksListResponse.GpTask) r4)
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.fragment.pfg.PFGHomeFragment.e():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        f.a(g.a().b(), "/inbox/games/daily-pop-up", "pfg_bonus", "use_bonus_clicked", "", "");
        this.o.c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        f.a(g.a().b(), "/inbox/games/sign-up-bonus", "pfg_bonus", "use_bonus_clicked", "", "");
        if (!f.a((Object) str)) {
            g.a().c().checkDeepLinking(requireActivity(), str);
        }
    }

    private void f() {
        if (h() && !this.o.f35630b && this.f35690i != null && this.k.c("BonusDialog") == null && this.k.c("MessageDialog") == null) {
            this.f35690i.showNow(this.k, "MessageDialog");
            this.f35690i = null;
        }
    }

    private boolean g() {
        if (!h() || this.o.f35640i || this.j == null || this.k.c("MessageDialog") != null || this.k.c("BonusDialog") != null) {
            return false;
        }
        this.j.showNow(this.k, "BonusDialog");
        this.j = null;
        return true;
    }

    private boolean h() {
        j jVar = this.k;
        return jVar != null && !jVar.i() && this.f35684c;
    }

    private void a(GpCommonBaseResponse gpCommonBaseResponse, String str) {
        String str2;
        FragmentActivity activity = getActivity();
        if (!f.a((Activity) activity)) {
            String str3 = gpCommonBaseResponse.message;
            if (f.a((Object) str3)) {
                str3 = getString(R.string.com_gamepind_some_error);
            }
            if (gpCommonBaseResponse.code == 0) {
                str2 = str3 + " [" + str + "]";
            } else {
                str2 = str3 + " [" + str + gpCommonBaseResponse.code + "]";
            }
            if (this.f35684c) {
                Toast.makeText(activity, str2, 1).show();
            }
        }
    }

    private void a(GpCommonBaseResponse gpCommonBaseResponse) {
        String str;
        FragmentActivity activity = getActivity();
        if (!f.a((Activity) activity)) {
            k();
            String str2 = gpCommonBaseResponse.message;
            if (f.a((Object) str2)) {
                str2 = getString(R.string.com_gamepind_some_error);
            }
            if (gpCommonBaseResponse.code == 0) {
                str = str2 + " [CS]";
            } else {
                str = str2 + " [CS" + gpCommonBaseResponse.code + "]";
            }
            this.m = f.a((Activity) activity, "", str, getString(R.string.com_gamepind_btn_cst), getString(R.string.com_gamepind_btn_ok), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PFGHomeFragment.this.a(dialogInterface, i2);
                }
            });
            this.m.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    PFGHomeFragment.this.a(dialogInterface);
                }
            });
            j();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        if (i2 == -1) {
            FragmentActivity activity = getActivity();
            if (!f.a((Activity) activity)) {
                c.a((Activity) activity);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.m = null;
    }

    private void i() {
        k();
        if (this.l.decrementAndGet() >= 0) {
            a(false);
        }
    }

    private void j() {
        AlertDialog alertDialog = this.m;
        if (alertDialog != null && this.f35684c) {
            alertDialog.show();
        }
    }

    private void k() {
        TextView textView = this.f35687f;
        if (textView != null) {
            textView.setText("-");
            this.f35687f.setVisibility(8);
        }
        ViewGroup viewGroup = this.f35688g;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        net.one97.paytm.games.b.a.a((CJRSignupUser) null);
    }
}
