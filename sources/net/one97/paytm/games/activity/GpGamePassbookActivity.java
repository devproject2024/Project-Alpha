package net.one97.paytm.games.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.j;
import net.one97.paytm.games.e.k;
import net.one97.paytm.games.fragment.a.c;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.PFGWalletBalancesResponse;
import net.one97.paytm.games.model.core.CJRSignupUser;
import net.one97.paytm.games.model.pfg.PFGWalletBalances;

public final class GpGamePassbookActivity extends GpBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35484b = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String r;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f35485c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f35486d;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f35487e;

    /* renamed from: f  reason: collision with root package name */
    private LottieAnimationView f35488f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f35489g;

    /* renamed from: h  reason: collision with root package name */
    private SwipeRefreshLayout f35490h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f35491i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private View o;
    private View p;
    private net.one97.paytm.games.fragment.a.c q;

    static final class b<T> implements z<o<? extends Integer, ? extends PFGWalletBalancesResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35492a;

        b(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35492a = gpGamePassbookActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            PFGWalletBalances balances;
            PFGWalletBalances balances2;
            PFGWalletBalances balances3;
            PFGWalletBalances balances4;
            PFGWalletBalances balances5;
            o oVar = (o) obj;
            GpGamePassbookActivity.a(this.f35492a).setRefreshing(false);
            if (((Number) oVar.getFirst()).intValue() != 6) {
                GpGamePassbookActivity gpGamePassbookActivity = this.f35492a;
                Toast.makeText(gpGamePassbookActivity, gpGamePassbookActivity.getString(R.string.com_gamepind_something_went_retry), 0).show();
                return;
            }
            PFGWalletBalancesResponse pFGWalletBalancesResponse = (PFGWalletBalancesResponse) oVar.getSecond();
            Double d2 = null;
            Integer valueOf = pFGWalletBalancesResponse != null ? Integer.valueOf(pFGWalletBalancesResponse.code) : null;
            if (valueOf != null && valueOf.intValue() == 2001) {
                this.f35492a.a(true);
                net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
                if (!net.one97.paytm.games.e.b.c().getValue().booleanValue()) {
                    if (!(pFGWalletBalancesResponse == null || (balances5 = pFGWalletBalancesResponse.getBalances()) == null)) {
                        d2 = balances5.getBonus_balance();
                    }
                    if (d2 == null) {
                        d2 = Double.valueOf(0.0d);
                    }
                    GpGamePassbookActivity.b(this.f35492a).setText(k.a(d2.doubleValue()));
                    return;
                }
                Double deposit_balance = (pFGWalletBalancesResponse == null || (balances4 = pFGWalletBalancesResponse.getBalances()) == null) ? null : balances4.getDeposit_balance();
                Double winning_balance = (pFGWalletBalancesResponse == null || (balances3 = pFGWalletBalancesResponse.getBalances()) == null) ? null : balances3.getWinning_balance();
                Double bonus_balance = (pFGWalletBalancesResponse == null || (balances2 = pFGWalletBalancesResponse.getBalances()) == null) ? null : balances2.getBonus_balance();
                if (!(pFGWalletBalancesResponse == null || (balances = pFGWalletBalancesResponse.getBalances()) == null)) {
                    d2 = balances.getTotal_balance();
                }
                if (deposit_balance == null) {
                    deposit_balance = Double.valueOf(0.0d);
                }
                if (winning_balance == null) {
                    winning_balance = Double.valueOf(0.0d);
                }
                if (bonus_balance == null) {
                    bonus_balance = Double.valueOf(0.0d);
                }
                if (d2 == null) {
                    d2 = Double.valueOf(0.0d);
                }
                GpGamePassbookActivity.b(this.f35492a).setText(k.a(d2.doubleValue()));
                GpGamePassbookActivity.c(this.f35492a).setText(k.a(deposit_balance.doubleValue()));
                GpGamePassbookActivity.d(this.f35492a).setText(k.a(winning_balance.doubleValue()));
                GpGamePassbookActivity.e(this.f35492a).setText(k.a(bonus_balance.doubleValue()));
            } else if (valueOf != null && valueOf.intValue() == 3012) {
                net.one97.paytm.games.b.a.a((CJRSignupUser) null);
                this.f35492a.a((GpCommonBaseResponse) pFGWalletBalancesResponse);
            } else if (valueOf != null && valueOf.intValue() == 2055) {
                net.one97.paytm.games.b.a.a((CJRSignupUser) null);
                if (GpGamePassbookActivity.f(this.f35492a).f35634f.decrementAndGet() >= 0) {
                    GpGamePassbookActivity.f(this.f35492a).a(2);
                }
            } else {
                GpGamePassbookActivity gpGamePassbookActivity2 = this.f35492a;
                Toast.makeText(gpGamePassbookActivity2, gpGamePassbookActivity2.getString(R.string.com_gamepind_something_went_retry), 0).show();
            }
        }
    }

    static final class c<T> implements z<CJRHomePageV2> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35493a;

        c(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35493a = gpGamePassbookActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
            r3 = r0.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r13) {
            /*
                r12 = this;
                net.one97.paytm.common.entity.shopping.CJRHomePageV2 r13 = (net.one97.paytm.common.entity.shopping.CJRHomePageV2) r13
                net.one97.paytm.games.activity.GpGamePassbookActivity r0 = r12.f35493a
                androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = net.one97.paytm.games.activity.GpGamePassbookActivity.a((net.one97.paytm.games.activity.GpGamePassbookActivity) r0)
                r1 = 0
                r0.setRefreshing(r1)
                if (r13 == 0) goto L_0x00f1
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2> r0 = r13.mPage
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2 r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2) r0
                if (r0 == 0) goto L_0x00f0
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2> r0 = r0.mHomePageLayoutList
                if (r0 == 0) goto L_0x00f0
                java.lang.Object r0 = r0.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r0
                if (r0 == 0) goto L_0x00f0
                java.lang.String r2 = "it"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
                java.util.ArrayList r0 = r0.getHomePageItemList()
                int r2 = r0.size()
                if (r2 <= 0) goto L_0x00f0
                r2 = 0
                if (r0 == 0) goto L_0x0043
                java.lang.Object r3 = r0.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r3
                if (r3 == 0) goto L_0x0043
                java.lang.String r3 = r3.getImageUrl()
                goto L_0x0044
            L_0x0043:
                r3 = r2
            L_0x0044:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00f0
                net.one97.paytm.games.activity.GpGamePassbookActivity r3 = r12.f35493a
                android.widget.ImageView r3 = net.one97.paytm.games.activity.GpGamePassbookActivity.g(r3)
                r3.setVisibility(r1)
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2> r3 = r13.mPage
                java.lang.Object r3 = r3.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2) r3
                java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2> r3 = r3.mHomePageLayoutList
                if (r3 == 0) goto L_0x0076
                java.lang.Object r3 = r3.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r3
                if (r3 == 0) goto L_0x0076
                java.util.ArrayList r3 = r3.getHomePageItemList()
                if (r3 == 0) goto L_0x0076
                java.lang.Object r3 = r3.get(r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r3
                goto L_0x0077
            L_0x0076:
                r3 = r2
            L_0x0077:
                net.one97.paytm.games.e.g r4 = net.one97.paytm.games.e.g.a()
                net.one97.paytm.games.c.a r5 = r4.c()
                net.one97.paytm.games.activity.GpGamePassbookActivity r4 = r12.f35493a
                r6 = r4
                android.content.Context r6 = (android.content.Context) r6
                r7 = 0
                android.content.Context r4 = (android.content.Context) r4
                java.lang.String r8 = "/passbook-pfg"
                java.lang.String r8 = net.one97.paytm.games.e.f.c(r4, r8)
                if (r3 == 0) goto L_0x0095
                java.lang.String r4 = r3.getName()
                r10 = r4
                goto L_0x0096
            L_0x0095:
                r10 = r2
            L_0x0096:
                java.lang.String r9 = ""
                java.lang.String r11 = "inbox"
                r5.sendPromotionImpression(r6, r7, r8, r9, r10, r11)
                net.one97.paytm.games.activity.GpGamePassbookActivity r4 = r12.f35493a
                r5 = r4
                android.content.Context r5 = (android.content.Context) r5
                if (r3 == 0) goto L_0x00a8
                java.lang.String r2 = r3.getName()
            L_0x00a8:
                r9 = r2
                r10 = 0
                java.lang.String r6 = "/passbook-pfg"
                java.lang.String r7 = "pfg_passbook"
                java.lang.String r8 = "banner_api_success"
                net.one97.paytm.games.e.f.a(r5, r6, r7, r8, r9, r10)
                net.one97.paytm.games.e.a.c$a r2 = net.one97.paytm.games.e.a.c.f35593a
                net.one97.paytm.games.e.a.c.a.a()
                net.one97.paytm.games.activity.GpGamePassbookActivity r2 = r12.f35493a
                android.content.Context r2 = (android.content.Context) r2
                if (r0 != 0) goto L_0x00c1
                kotlin.g.b.k.a()
            L_0x00c1:
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r1 = "views!!.get(0)"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
                java.lang.String r0 = r0.getImageUrl()
                java.lang.String r1 = "views!!.get(0).imageUrl"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.games.activity.GpGamePassbookActivity r1 = r12.f35493a
                android.widget.ImageView r1 = net.one97.paytm.games.activity.GpGamePassbookActivity.g(r1)
                net.one97.paytm.games.e.a.c.a(r2, r0, r1, 0, net.one97.paytm.games.R.drawable.games_img_defult_midcard)
                net.one97.paytm.games.activity.GpGamePassbookActivity r0 = r12.f35493a
                android.widget.ImageView r0 = net.one97.paytm.games.activity.GpGamePassbookActivity.g(r0)
                net.one97.paytm.games.activity.GpGamePassbookActivity$c$a r1 = new net.one97.paytm.games.activity.GpGamePassbookActivity$c$a
                r1.<init>(r3, r12, r13)
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r0.setOnClickListener(r1)
            L_0x00f0:
                return
            L_0x00f1:
                net.one97.paytm.games.activity.GpGamePassbookActivity r13 = r12.f35493a
                r0 = r13
                android.content.Context r0 = (android.content.Context) r0
                r4 = 0
                r5 = 0
                java.lang.String r1 = "/passbook-pfg"
                java.lang.String r2 = "pfg_passbook"
                java.lang.String r3 = "pfg_banner_failed"
                net.one97.paytm.games.e.f.a(r0, r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.GpGamePassbookActivity.c.onChanged(java.lang.Object):void");
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRHomePageItem f35494a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f35495b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ CJRHomePageV2 f35496c;

            a(CJRHomePageItem cJRHomePageItem, c cVar, CJRHomePageV2 cJRHomePageV2) {
                this.f35494a = cJRHomePageItem;
                this.f35495b = cVar;
                this.f35496c = cJRHomePageV2;
            }

            public final void onClick(View view) {
                net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
                kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
                net.one97.paytm.games.c.a c2 = a2.c();
                Context context = this.f35495b.f35493a;
                CJRHomePageItem cJRHomePageItem = this.f35494a;
                String str = null;
                c2.CJRLoadPage(context, cJRHomePageItem != null ? cJRHomePageItem.getURLType() : null, this.f35494a, 0, "GAMEPIND");
                Context context2 = this.f35495b.f35493a;
                CJRHomePageItem cJRHomePageItem2 = this.f35494a;
                net.one97.paytm.games.e.f.a(context2, "/passbook-pfg", "pfg_passbook", "pfg_banner_clicked", cJRHomePageItem2 != null ? cJRHomePageItem2.getName() : null, (String) null);
                net.one97.paytm.games.c.a c3 = net.one97.paytm.games.e.g.a().c();
                Context context3 = this.f35495b.f35493a;
                String c4 = net.one97.paytm.games.e.f.c(this.f35495b.f35493a, "/passbook-pfg");
                CJRHomePageItem cJRHomePageItem3 = this.f35494a;
                if (cJRHomePageItem3 != null) {
                    str = cJRHomePageItem3.getName();
                }
                c3.sendPromotionClickImpression(context3, 0, c4, "banner", "", str);
            }
        }
    }

    static final class d<T> implements z<o<? extends Integer, ? extends GpCommonBaseResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35497a;

        d(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35497a = gpGamePassbookActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            if (((Number) oVar.getFirst()).intValue() == 0) {
                GpGamePassbookActivity.h(this.f35497a).setVisibility(4);
                GpGamePassbookActivity.i(this.f35497a).setVisibility(0);
                return;
            }
            GpGamePassbookActivity.h(this.f35497a).setVisibility(0);
            GpGamePassbookActivity.i(this.f35497a).setVisibility(4);
            if (oVar.getSecond() != null) {
                net.one97.paytm.games.fragment.pfg.b bVar = new net.one97.paytm.games.fragment.pfg.b();
                Object second = oVar.getSecond();
                if (second == null) {
                    kotlin.g.b.k.a();
                }
                bVar.f35701a = ((GpCommonBaseResponse) second).code;
                bVar.f35702b = new Runnable(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f35498a;

                    {
                        this.f35498a = r1;
                    }

                    public final void run() {
                        GpGamePassbookActivity.f(this.f35498a.f35497a).c();
                    }
                };
                if (!this.f35497a.getSupportFragmentManager().i()) {
                    bVar.showNow(this.f35497a.getSupportFragmentManager(), "MessageDialog");
                }
            }
        }
    }

    static final class e<T> implements z<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35499a;

        e(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35499a = gpGamePassbookActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Integer num = (Integer) obj;
            if (num != null && num.intValue() == 1) {
                net.one97.paytm.games.e.g a2 = net.one97.paytm.games.e.g.a();
                kotlin.g.b.k.a((Object) a2, "GpSingleton.getInstance()");
                Intent loginScreenIntent = a2.c().getLoginScreenIntent(this.f35499a);
                loginScreenIntent.addFlags(67108864);
                this.f35499a.startActivityForResult(loginScreenIntent, 3);
            } else if (num != null && num.intValue() == 2) {
                GpGamePassbookActivity.f(this.f35499a).a(GpGamePassbookActivity.r, GpGamePassbookActivity.j(this.f35499a));
            } else if (num == null || num.intValue() != 3) {
            } else {
                if (!com.paytm.utility.a.p(this.f35499a.getApplication()) || net.one97.paytm.games.b.a.a() == null) {
                    this.f35499a.c();
                } else {
                    GpGamePassbookActivity.k(this.f35499a);
                }
            }
        }
    }

    static final class f<T> implements z<o<? extends Integer, ? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35500a;

        f(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35500a = gpGamePassbookActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            o oVar = (o) obj;
            if (oVar != null) {
                int intValue = ((Number) oVar.getFirst()).intValue();
                if (intValue == 4) {
                    GpGamePassbookActivity gpGamePassbookActivity = this.f35500a;
                    gpGamePassbookActivity.a(gpGamePassbookActivity.getString(R.string.com_gamepind_msg_loading));
                } else if (intValue == 5) {
                    this.f35500a.a();
                    String string = this.f35500a.getString(R.string.com_gamepind_some_error);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.com_gamepind_some_error)");
                    if (oVar.getSecond() instanceof String) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append(" [");
                        sb.append(oVar.getSecond());
                        sb.append(']');
                    }
                    this.f35500a.c();
                } else if (intValue == 6) {
                    this.f35500a.a();
                    Object second = oVar.getSecond();
                    if (second != null) {
                        CJRSignupUser cJRSignupUser = (CJRSignupUser) second;
                        int i2 = cJRSignupUser.code;
                        if (i2 == 2001) {
                            net.one97.paytm.games.b.a.a(cJRSignupUser);
                            GpGamePassbookActivity.f(this.f35500a).a(3);
                        } else if (i2 == 2055) {
                            net.one97.paytm.games.b.a.a((CJRSignupUser) null);
                            if (GpGamePassbookActivity.f(this.f35500a).f35634f.decrementAndGet() >= 0) {
                                GpGamePassbookActivity.f(this.f35500a).a(2);
                                return;
                            }
                            GpGamePassbookActivity gpGamePassbookActivity2 = this.f35500a;
                            kotlin.g.b.k.a((Object) gpGamePassbookActivity2.getString(R.string.com_gamepind_some_error), "getString(R.string.com_gamepind_some_error)");
                            gpGamePassbookActivity2.c();
                        } else if (i2 != 3012) {
                            GpGamePassbookActivity gpGamePassbookActivity3 = this.f35500a;
                            new StringBuilder("PFGBaseViewModel.API_SUCCESS -> RESPONSE_CODE_").append(cJRSignupUser.code);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f35500a.getString(R.string.com_gamepind_some_error));
                            sb2.append("  [CS - ");
                            sb2.append(cJRSignupUser.code);
                            sb2.append(']');
                            gpGamePassbookActivity3.c();
                        } else {
                            net.one97.paytm.games.b.a.a((CJRSignupUser) null);
                            this.f35500a.a((GpCommonBaseResponse) cJRSignupUser);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.games.model.core.CJRSignupUser");
                    }
                }
            }
        }
    }

    public static final /* synthetic */ SwipeRefreshLayout a(GpGamePassbookActivity gpGamePassbookActivity) {
        SwipeRefreshLayout swipeRefreshLayout = gpGamePassbookActivity.f35490h;
        if (swipeRefreshLayout == null) {
            kotlin.g.b.k.a("mSwipeRefresh");
        }
        return swipeRefreshLayout;
    }

    public static final /* synthetic */ TextView b(GpGamePassbookActivity gpGamePassbookActivity) {
        TextView textView = gpGamePassbookActivity.f35491i;
        if (textView == null) {
            kotlin.g.b.k.a("mTxtBalance");
        }
        return textView;
    }

    public static final /* synthetic */ TextView c(GpGamePassbookActivity gpGamePassbookActivity) {
        TextView textView = gpGamePassbookActivity.j;
        if (textView == null) {
            kotlin.g.b.k.a("mTxtDeposit");
        }
        return textView;
    }

    public static final /* synthetic */ TextView d(GpGamePassbookActivity gpGamePassbookActivity) {
        TextView textView = gpGamePassbookActivity.k;
        if (textView == null) {
            kotlin.g.b.k.a("mTxtWinning");
        }
        return textView;
    }

    public static final /* synthetic */ TextView e(GpGamePassbookActivity gpGamePassbookActivity) {
        TextView textView = gpGamePassbookActivity.l;
        if (textView == null) {
            kotlin.g.b.k.a("mTxtBonus");
        }
        return textView;
    }

    public static final /* synthetic */ net.one97.paytm.games.fragment.a.c f(GpGamePassbookActivity gpGamePassbookActivity) {
        net.one97.paytm.games.fragment.a.c cVar = gpGamePassbookActivity.q;
        if (cVar == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        return cVar;
    }

    public static final /* synthetic */ ImageView g(GpGamePassbookActivity gpGamePassbookActivity) {
        ImageView imageView = gpGamePassbookActivity.n;
        if (imageView == null) {
            kotlin.g.b.k.a("mBannerView");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView h(GpGamePassbookActivity gpGamePassbookActivity) {
        TextView textView = gpGamePassbookActivity.m;
        if (textView == null) {
            kotlin.g.b.k.a("mBtnUseBonusNow");
        }
        return textView;
    }

    public static final /* synthetic */ LottieAnimationView i(GpGamePassbookActivity gpGamePassbookActivity) {
        LottieAnimationView lottieAnimationView = gpGamePassbookActivity.f35486d;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("mUseBonusProgress");
        }
        return lottieAnimationView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = GpGamePassbookActivity.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "GpGamePassbookActivity::class.java.simpleName");
        r = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.com_gamepind_activity_passbook);
        View findViewById = findViewById(R.id.lav_balance_progress_bar);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.lav_balance_progress_bar)");
        this.f35485c = (LottieAnimationView) findViewById;
        View findViewById2 = findViewById(R.id.lav_deposit_progress_bar);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.lav_deposit_progress_bar)");
        this.f35487e = (LottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R.id.lav_winning_progress_bar);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.lav_winning_progress_bar)");
        this.f35488f = (LottieAnimationView) findViewById3;
        View findViewById4 = findViewById(R.id.lav_use_bonus_progress_bar);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.lav_use_bonus_progress_bar)");
        this.f35486d = (LottieAnimationView) findViewById4;
        View findViewById5 = findViewById(R.id.lav_bonus_progress_bar);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.lav_bonus_progress_bar)");
        this.f35489g = (LottieAnimationView) findViewById5;
        View findViewById6 = findViewById(R.id.swipeLayout_passbook);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.swipeLayout_passbook)");
        this.f35490h = (SwipeRefreshLayout) findViewById6;
        View findViewById7 = findViewById(R.id.txt_balance);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.txt_balance)");
        this.f35491i = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.txt_deposit);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById(R.id.txt_deposit)");
        this.j = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.txt_winning);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById(R.id.txt_winning)");
        this.k = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.txt_winning);
        kotlin.g.b.k.a((Object) findViewById10, "findViewById(R.id.txt_winning)");
        this.k = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.btn_use_bonus_now);
        kotlin.g.b.k.a((Object) findViewById11, "findViewById(R.id.btn_use_bonus_now)");
        this.m = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.txt_bonus);
        kotlin.g.b.k.a((Object) findViewById12, "findViewById(R.id.txt_bonus)");
        this.l = (TextView) findViewById12;
        View findViewById13 = findViewById(R.id.root_passbook);
        kotlin.g.b.k.a((Object) findViewById13, "findViewById(R.id.root_passbook)");
        this.o = findViewById13;
        View findViewById14 = findViewById(R.id.container_balances);
        kotlin.g.b.k.a((Object) findViewById14, "findViewById(R.id.container_balances)");
        this.p = findViewById14;
        View findViewById15 = findViewById(R.id.img_banner);
        kotlin.g.b.k.a((Object) findViewById15, "findViewById(R.id.img_banner)");
        this.n = (ImageView) findViewById15;
        TextView textView = this.m;
        if (textView == null) {
            kotlin.g.b.k.a("mBtnUseBonusNow");
        }
        net.one97.paytm.games.e.b bVar = net.one97.paytm.games.e.b.f35599a;
        textView.setVisibility(net.one97.paytm.games.e.b.b() ? 0 : 8);
        ai a2 = am.a((FragmentActivity) this).a(net.one97.paytm.games.fragment.a.c.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ookViewModel::class.java)");
        this.q = (net.one97.paytm.games.fragment.a.c) a2;
        net.one97.paytm.games.fragment.a.c cVar = this.q;
        if (cVar == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        q qVar = this;
        cVar.f35631c.observe(qVar, new b(this));
        net.one97.paytm.games.fragment.a.c cVar2 = this.q;
        if (cVar2 == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        cVar2.f35647i.observe(qVar, new c(this));
        net.one97.paytm.games.fragment.a.c cVar3 = this.q;
        if (cVar3 == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        cVar3.f35629a.observe(qVar, new d(this));
        net.one97.paytm.games.fragment.a.c cVar4 = this.q;
        if (cVar4 == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        cVar4.f35632d.observe(qVar, new e(this));
        net.one97.paytm.games.fragment.a.c cVar5 = this.q;
        if (cVar5 == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        cVar5.f35633e.observe(qVar, new f(this));
        net.one97.paytm.games.fragment.a.c cVar6 = this.q;
        if (cVar6 == null) {
            kotlin.g.b.k.a("mPassbookViewModel");
        }
        cVar6.a();
        SwipeRefreshLayout swipeRefreshLayout = this.f35490h;
        if (swipeRefreshLayout == null) {
            kotlin.g.b.k.a("mSwipeRefresh");
        }
        swipeRefreshLayout.setOnRefreshListener(new g(this));
        View view = this.o;
        if (view == null) {
            kotlin.g.b.k.a("mRootVw");
        }
        view.setOnTouchListener(new h(this));
        net.one97.paytm.games.e.b bVar2 = net.one97.paytm.games.e.b.f35599a;
        if (!net.one97.paytm.games.e.b.c().getValue().booleanValue()) {
            View findViewById16 = findViewById(R.id.img_info_balance);
            kotlin.g.b.k.a((Object) findViewById16, "findViewById<ImageView>(R.id.img_info_balance)");
            ((ImageView) findViewById16).setVisibility(0);
            View view2 = this.p;
            if (view2 == null) {
                kotlin.g.b.k.a("mRootBalances");
            }
            view2.setVisibility(8);
            View findViewById17 = findViewById(R.id.txt_title_balance);
            kotlin.g.b.k.a((Object) findViewById17, "findViewById<TextView>(R.id.txt_title_balance)");
            ((TextView) findViewById17).setText("BONUS BALANCE");
        }
        net.one97.paytm.games.e.g.a().c().sendOpenScreenWithDeviceInfo("/passbook-pfg/landing", "inbox", this);
    }

    static final class g implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35501a;

        g(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35501a = gpGamePassbookActivity;
        }

        public final void onRefresh() {
            GpGamePassbookActivity.k(this.f35501a);
        }
    }

    static final class h implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GpGamePassbookActivity f35502a;

        h(GpGamePassbookActivity gpGamePassbookActivity) {
            this.f35502a = gpGamePassbookActivity;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f35502a.a(false, false, false, false);
            return false;
        }
    }

    public final void a(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.f35485c;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("mBalanceProgress");
            }
            lottieAnimationView.setVisibility(4);
            LottieAnimationView lottieAnimationView2 = this.f35485c;
            if (lottieAnimationView2 == null) {
                kotlin.g.b.k.a("mBalanceProgress");
            }
            lottieAnimationView2.pauseAnimation();
            LottieAnimationView lottieAnimationView3 = this.f35487e;
            if (lottieAnimationView3 == null) {
                kotlin.g.b.k.a("mDepositProgress");
            }
            lottieAnimationView3.setVisibility(4);
            LottieAnimationView lottieAnimationView4 = this.f35487e;
            if (lottieAnimationView4 == null) {
                kotlin.g.b.k.a("mDepositProgress");
            }
            lottieAnimationView4.pauseAnimation();
            LottieAnimationView lottieAnimationView5 = this.f35488f;
            if (lottieAnimationView5 == null) {
                kotlin.g.b.k.a("mWinningProgress");
            }
            lottieAnimationView5.setVisibility(4);
            LottieAnimationView lottieAnimationView6 = this.f35488f;
            if (lottieAnimationView6 == null) {
                kotlin.g.b.k.a("mWinningProgress");
            }
            lottieAnimationView6.pauseAnimation();
            LottieAnimationView lottieAnimationView7 = this.f35489g;
            if (lottieAnimationView7 == null) {
                kotlin.g.b.k.a("mBonusProgress");
            }
            lottieAnimationView7.setVisibility(4);
            LottieAnimationView lottieAnimationView8 = this.f35489g;
            if (lottieAnimationView8 == null) {
                kotlin.g.b.k.a("mBonusProgress");
            }
            lottieAnimationView8.pauseAnimation();
            TextView textView = this.f35491i;
            if (textView == null) {
                kotlin.g.b.k.a("mTxtBalance");
            }
            textView.setVisibility(0);
            TextView textView2 = this.j;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTxtDeposit");
            }
            textView2.setVisibility(0);
            TextView textView3 = this.k;
            if (textView3 == null) {
                kotlin.g.b.k.a("mTxtWinning");
            }
            textView3.setVisibility(0);
            TextView textView4 = this.l;
            if (textView4 == null) {
                kotlin.g.b.k.a("mTxtBonus");
            }
            textView4.setVisibility(0);
            return;
        }
        LottieAnimationView lottieAnimationView9 = this.f35485c;
        if (lottieAnimationView9 == null) {
            kotlin.g.b.k.a("mBalanceProgress");
        }
        net.one97.paytm.games.e.f.a(lottieAnimationView9);
        LottieAnimationView lottieAnimationView10 = this.f35487e;
        if (lottieAnimationView10 == null) {
            kotlin.g.b.k.a("mDepositProgress");
        }
        net.one97.paytm.games.e.f.a(lottieAnimationView10);
        LottieAnimationView lottieAnimationView11 = this.f35488f;
        if (lottieAnimationView11 == null) {
            kotlin.g.b.k.a("mWinningProgress");
        }
        net.one97.paytm.games.e.f.a(lottieAnimationView11);
        LottieAnimationView lottieAnimationView12 = this.f35489g;
        if (lottieAnimationView12 == null) {
            kotlin.g.b.k.a("mBonusProgress");
        }
        net.one97.paytm.games.e.f.a(lottieAnimationView12);
        TextView textView5 = this.f35491i;
        if (textView5 == null) {
            kotlin.g.b.k.a("mTxtBalance");
        }
        textView5.setVisibility(4);
        TextView textView6 = this.j;
        if (textView6 == null) {
            kotlin.g.b.k.a("mTxtDeposit");
        }
        textView6.setVisibility(4);
        TextView textView7 = this.k;
        if (textView7 == null) {
            kotlin.g.b.k.a("mTxtWinning");
        }
        textView7.setVisibility(4);
        TextView textView8 = this.l;
        if (textView8 == null) {
            kotlin.g.b.k.a("mTxtBonus");
        }
        textView8.setVisibility(4);
    }

    public final void onClick(View view) {
        kotlin.g.b.k.c(view, "view");
        int id = view.getId();
        if (id == R.id.img_info_deposit) {
            a(true, false, false, false);
        } else if (id == R.id.img_info_winning) {
            a(false, true, false, false);
        } else if (id == R.id.img_info_bonus) {
            a(false, false, true, false);
        } else if (id == R.id.img_info_balance) {
            a(false, false, false, true);
        } else if (id == R.id.txt_queries) {
            net.one97.paytm.games.e.f.a(this, "/passbook-pfg", "pfg_passbook", "my_queries_clicked", (String) null, (String) null);
            net.one97.paytm.games.e.c.a((Activity) this, "paytmmp://contactus");
        } else if (id == R.id.txt_transaction) {
            Context context = this;
            net.one97.paytm.games.e.f.a(context, "/passbook-pfg", "pfg_passbook", "recent_transactions_clicked", AppConstants.FOR_ALL, (String) null);
            startActivity(new Intent(context, PFGTransactionActivity.class));
        } else if (id == R.id.txt_help) {
            net.one97.paytm.games.e.f.a(this, "/passbook-pfg", "pfg_passbook", "help_clicked", (String) null, (String) null);
            net.one97.paytm.games.e.c.a((Activity) this, "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=9");
        } else if (id == R.id.btn_use_bonus_now) {
            Context context2 = this;
            net.one97.paytm.games.e.f.a(context2, "/passbook-pfg", "pfg_passbook", "use_bonus_clicked", (String) null, (String) null);
            if (net.one97.paytm.games.e.f.a(context2)) {
                TextView textView = this.m;
                if (textView == null) {
                    kotlin.g.b.k.a("mBtnUseBonusNow");
                }
                textView.setVisibility(4);
                LottieAnimationView lottieAnimationView = this.f35486d;
                if (lottieAnimationView == null) {
                    kotlin.g.b.k.a("mUseBonusProgress");
                }
                net.one97.paytm.games.e.f.a(lottieAnimationView);
                net.one97.paytm.games.fragment.a.c cVar = this.q;
                if (cVar == null) {
                    kotlin.g.b.k.a("mPassbookViewModel");
                }
                cVar.c();
                return;
            }
            Toast.makeText(context2, getString(R.string.com_gamepind_no_internet_available), 0).show();
        } else if (id == R.id.img_back_arrow) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z3) {
            View findViewById = findViewById(R.id.img_down_bonus);
            kotlin.g.b.k.a((Object) findViewById, "findViewById<View>(R.id.img_down_bonus)");
            findViewById.setVisibility(0);
            View findViewById2 = findViewById(R.id.txt_info_bonus);
            kotlin.g.b.k.a((Object) findViewById2, "findViewById<View>(R.id.txt_info_bonus)");
            findViewById2.setVisibility(0);
        } else {
            View findViewById3 = findViewById(R.id.img_down_bonus);
            kotlin.g.b.k.a((Object) findViewById3, "findViewById<View>(R.id.img_down_bonus)");
            findViewById3.setVisibility(8);
            View findViewById4 = findViewById(R.id.txt_info_bonus);
            kotlin.g.b.k.a((Object) findViewById4, "findViewById<View>(R.id.txt_info_bonus)");
            findViewById4.setVisibility(8);
        }
        if (z) {
            View findViewById5 = findViewById(R.id.img_down_deposit);
            kotlin.g.b.k.a((Object) findViewById5, "findViewById<View>(R.id.img_down_deposit)");
            findViewById5.setVisibility(0);
            View findViewById6 = findViewById(R.id.txt_info_deposit);
            kotlin.g.b.k.a((Object) findViewById6, "findViewById<View>(R.id.txt_info_deposit)");
            findViewById6.setVisibility(0);
        } else {
            View findViewById7 = findViewById(R.id.img_down_deposit);
            kotlin.g.b.k.a((Object) findViewById7, "findViewById<View>(R.id.img_down_deposit)");
            findViewById7.setVisibility(8);
            View findViewById8 = findViewById(R.id.txt_info_deposit);
            kotlin.g.b.k.a((Object) findViewById8, "findViewById<View>(R.id.txt_info_deposit)");
            findViewById8.setVisibility(8);
        }
        if (z2) {
            View findViewById9 = findViewById(R.id.img_down_winning);
            kotlin.g.b.k.a((Object) findViewById9, "findViewById<View>(R.id.img_down_winning)");
            findViewById9.setVisibility(0);
            View findViewById10 = findViewById(R.id.txt_info_winning);
            kotlin.g.b.k.a((Object) findViewById10, "findViewById<View>(R.id.txt_info_winning)");
            findViewById10.setVisibility(0);
        } else {
            View findViewById11 = findViewById(R.id.img_down_winning);
            kotlin.g.b.k.a((Object) findViewById11, "findViewById<View>(R.id.img_down_winning)");
            findViewById11.setVisibility(8);
            View findViewById12 = findViewById(R.id.txt_info_winning);
            kotlin.g.b.k.a((Object) findViewById12, "findViewById<View>(R.id.txt_info_winning)");
            findViewById12.setVisibility(8);
        }
        if (z4) {
            View findViewById13 = findViewById(R.id.img_down_balance);
            kotlin.g.b.k.a((Object) findViewById13, "findViewById<View>(R.id.img_down_balance)");
            findViewById13.setVisibility(0);
            View findViewById14 = findViewById(R.id.txt_info_balance);
            kotlin.g.b.k.a((Object) findViewById14, "findViewById<View>(R.id.txt_info_balance)");
            findViewById14.setVisibility(0);
            return;
        }
        View findViewById15 = findViewById(R.id.img_down_balance);
        kotlin.g.b.k.a((Object) findViewById15, "findViewById<View>(R.id.img_down_balance)");
        findViewById15.setVisibility(8);
        View findViewById16 = findViewById(R.id.txt_info_balance);
        kotlin.g.b.k.a((Object) findViewById16, "findViewById<View>(R.id.txt_info_balance)");
        findViewById16.setVisibility(8);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3) {
            return;
        }
        if (i3 == -1) {
            net.one97.paytm.games.fragment.a.c cVar = this.q;
            if (cVar == null) {
                kotlin.g.b.k.a("mPassbookViewModel");
            }
            cVar.a(2);
            return;
        }
        c();
    }

    /* access modifiers changed from: private */
    public final void c() {
        Toast.makeText(this, getString(R.string.com_gamepind_something_went_retry), 1).show();
        finish();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = r1.getQueryParameter("source");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String j(net.one97.paytm.games.activity.GpGamePassbookActivity r1) {
        /*
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r0 = "intent"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            android.net.Uri r1 = r1.getData()
            if (r1 == 0) goto L_0x0018
            java.lang.String r0 = "source"
            java.lang.String r1 = r1.getQueryParameter(r0)
            if (r1 != 0) goto L_0x001a
        L_0x0018:
            java.lang.String r1 = "pfg_passbook"
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.activity.GpGamePassbookActivity.j(net.one97.paytm.games.activity.GpGamePassbookActivity):java.lang.String");
    }

    public static final /* synthetic */ void k(GpGamePassbookActivity gpGamePassbookActivity) {
        gpGamePassbookActivity.a(false);
        Context context = gpGamePassbookActivity;
        if (net.one97.paytm.games.e.f.a(context)) {
            net.one97.paytm.games.fragment.a.c cVar = gpGamePassbookActivity.q;
            if (cVar == null) {
                kotlin.g.b.k.a("mPassbookViewModel");
            }
            cVar.b();
            net.one97.paytm.games.fragment.a.c cVar2 = gpGamePassbookActivity.q;
            if (cVar2 == null) {
                kotlin.g.b.k.a("mPassbookViewModel");
            }
            kotlin.g.b.k.c(context, "pContext");
            if (cVar2.f35646h == null) {
                j jVar = j.f35626a;
                cVar2.f35646h = j.a(context, (com.paytm.network.listener.b) new c.a(cVar2));
                return;
            }
            return;
        }
        gpGamePassbookActivity.a(true);
        SwipeRefreshLayout swipeRefreshLayout = gpGamePassbookActivity.f35490h;
        if (swipeRefreshLayout == null) {
            kotlin.g.b.k.a("mSwipeRefresh");
        }
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(context, gpGamePassbookActivity.getString(R.string.com_gamepind_no_internet_available), 0).show();
    }
}
