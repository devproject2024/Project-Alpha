package net.one97.paytm.paymentsBank.slfd.timeline.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.AmountDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.FdDetailsResponse;
import net.one97.paytm.paymentsBank.model.slfd.NomineeDetailsResponse;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.slfd.common.view.SlfdCheckoutActivity;
import net.one97.paytm.paymentsBank.slfd.timeline.a.a;
import net.one97.paytm.paymentsBank.utils.o;

public class TimelineSlfdActivity extends SlfdBaseActivity implements a.b {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f19383b;

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f19384c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19385d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19386e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19387f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19388g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f19389h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f19390i;
    public CoordinatorLayout j;
    public RelativeLayout k;
    public LottieAnimationView l;
    public ProgressBar m;
    Double n = Double.valueOf(0.0d);
    public a.C0344a o;
    Boolean p = Boolean.FALSE;
    private final kotlin.g q = kotlin.h.a(new h(this));
    private final kotlin.g r = kotlin.h.a(new i(this));
    private boolean s;
    private String t = "";
    private String u = "";
    private final kotlin.g v = kotlin.h.a(new b(this));
    private HashMap w;

    static {
        Class<TimelineSlfdActivity> cls = TimelineSlfdActivity.class;
        f19383b = new kotlin.k.i[]{y.a((v) new w(y.b(cls), "parentContainer", "getParentContainer()Landroidx/constraintlayout/widget/ConstraintLayout;")), y.a((v) new w(y.b(cls), "progressBar", "getProgressBar()Landroid/widget/ProgressBar;")), y.a((v) new w(y.b(cls), "accountNum", "getAccountNum()Ljava/lang/String;"))};
    }

    public final View a(int i2) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.w.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z) {
    }

    static final class h extends l implements kotlin.g.a.a<ConstraintLayout> {
        final /* synthetic */ TimelineSlfdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TimelineSlfdActivity timelineSlfdActivity) {
            super(0);
            this.this$0 = timelineSlfdActivity;
        }

        public final ConstraintLayout invoke() {
            return (ConstraintLayout) this.this$0.findViewById(R.id.parent_container_timeline);
        }
    }

    static final class i extends l implements kotlin.g.a.a<ProgressBar> {
        final /* synthetic */ TimelineSlfdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(TimelineSlfdActivity timelineSlfdActivity) {
            super(0);
            this.this$0 = timelineSlfdActivity;
        }

        public final ProgressBar invoke() {
            return (ProgressBar) this.this$0.findViewById(R.id.progress_bar);
        }
    }

    static final class b extends l implements kotlin.g.a.a<String> {
        final /* synthetic */ TimelineSlfdActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TimelineSlfdActivity timelineSlfdActivity) {
            super(0);
            this.this$0 = timelineSlfdActivity;
        }

        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("account_num");
        }
    }

    public final int e() {
        return R.layout.timeline_slfd_activity;
    }

    public final a.C0344a f() {
        a.C0344a aVar = this.o;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.timeline_slfd_activity);
        String stringExtra = getIntent().getStringExtra("fd_id");
        View findViewById = findViewById(R.id.parent_container_timeline);
        k.a((Object) findViewById, "findViewById<Coordinator…arent_container_timeline)");
        this.j = (CoordinatorLayout) findViewById;
        View findViewById2 = findViewById(R.id.ll_error_container);
        k.a((Object) findViewById2, "findViewById<LinearLayou…(R.id.ll_error_container)");
        this.f19388g = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.rl_timeline_parent);
        k.a((Object) findViewById3, "findViewById<RelativeLay…(R.id.rl_timeline_parent)");
        this.f19390i = (RelativeLayout) findViewById3;
        LinearLayout linearLayout = this.f19388g;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        View findViewById4 = linearLayout.findViewById(R.id.tv_error_msg);
        if (findViewById4 != null) {
            this.f19385d = (TextView) findViewById4;
            LinearLayout linearLayout2 = this.f19388g;
            if (linearLayout2 == null) {
                k.a("llErrorContainer");
            }
            View findViewById5 = linearLayout2.findViewById(R.id.tv_retry);
            if (findViewById5 != null) {
                this.f19386e = (TextView) findViewById5;
                View findViewById6 = findViewById(R.id.tv_view_current_value);
                k.a((Object) findViewById6, "findViewById<TextView>(R.id.tv_view_current_value)");
                this.f19387f = (TextView) findViewById6;
                View findViewById7 = findViewById(R.id.wallet_loader);
                k.a((Object) findViewById7, "findViewById<LottieAnima…View>(R.id.wallet_loader)");
                this.f19384c = (LottieAnimationView) findViewById7;
                View findViewById8 = findViewById(R.id.rv_time_line_text);
                k.a((Object) findViewById8, "findViewById<RecyclerView>(R.id.rv_time_line_text)");
                this.f19389h = (RecyclerView) findViewById8;
                View findViewById9 = findViewById(R.id.rl_bottom_sheet_parent);
                k.a((Object) findViewById9, "findViewById<RelativeLay…d.rl_bottom_sheet_parent)");
                this.k = (RelativeLayout) findViewById9;
                View findViewById10 = findViewById(R.id.bs_wallet_loader);
                k.a((Object) findViewById10, "findViewById<LottieAnima…w>(R.id.bs_wallet_loader)");
                this.l = (LottieAnimationView) findViewById10;
                View findViewById11 = findViewById(R.id.translucent_progress);
                k.a((Object) findViewById11, "findViewById<ProgressBar….id.translucent_progress)");
                this.m = (ProgressBar) findViewById11;
                RecyclerView recyclerView = (RecyclerView) a(R.id.rv_time_line_text);
                k.a((Object) recyclerView, "rv_time_line_text");
                Context context = this;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                ((ImageView) a(R.id.img_back)).setOnClickListener(new c(this));
                TextView textView = this.f19386e;
                if (textView == null) {
                    k.a("tvRetry");
                }
                textView.setOnClickListener(new d(this));
                TextView textView2 = this.f19387f;
                if (textView2 == null) {
                    k.a("tvCurrentAmount");
                }
                textView2.setOnClickListener(new e(this));
                net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
                net.one97.paytm.paymentsBank.slfd.a.a.b a2 = net.one97.paytm.paymentsBank.slfd.c.a(context);
                k.a((Object) stringExtra, "fdId");
                a.C0344a aVar = new net.one97.paytm.paymentsBank.slfd.timeline.a(this, a2, stringExtra);
                k.c(aVar, "<set-?>");
                this.o = aVar;
                f().a();
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TimelineSlfdActivity f19394a;

        c(TimelineSlfdActivity timelineSlfdActivity) {
            this.f19394a = timelineSlfdActivity;
        }

        public final void onClick(View view) {
            this.f19394a.finish();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TimelineSlfdActivity f19395a;

        d(TimelineSlfdActivity timelineSlfdActivity) {
            this.f19395a = timelineSlfdActivity;
        }

        public final void onClick(View view) {
            this.f19395a.f().a();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TimelineSlfdActivity f19396a;

        e(TimelineSlfdActivity timelineSlfdActivity) {
            this.f19396a = timelineSlfdActivity;
        }

        public final void onClick(View view) {
            LottieAnimationView lottieAnimationView = this.f19396a.l;
            if (lottieAnimationView == null) {
                k.a("loaderCurrentAmount");
            }
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
            this.f19396a.f().a(this.f19396a.n);
            this.f19396a.p = Boolean.TRUE;
        }
    }

    public final void a(String str) {
        k.c(str, "message");
        Boolean bool = this.p;
        if (bool == null) {
            k.a();
        }
        if (bool.booleanValue()) {
            LottieAnimationView lottieAnimationView = this.l;
            if (lottieAnimationView == null) {
                k.a("loaderCurrentAmount");
            }
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
            CoordinatorLayout coordinatorLayout = this.j;
            if (coordinatorLayout == null) {
                k.a("clParent");
            }
            Snackbar a2 = Snackbar.a((View) coordinatorLayout, (CharSequence) str, 0);
            k.a((Object) a2, "Snackbar\n               …ge, Snackbar.LENGTH_LONG)");
            a2.c();
            this.p = Boolean.FALSE;
        } else if (this.s) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ll_nominee);
            k.a((Object) linearLayout, "ll_nominee");
            linearLayout.setVisibility(8);
            this.s = false;
        } else {
            LottieAnimationView lottieAnimationView2 = this.f19384c;
            if (lottieAnimationView2 == null) {
                k.a("contentLoadingProgress");
            }
            net.one97.paytm.common.widgets.a.b(lottieAnimationView2);
            RelativeLayout relativeLayout = this.f19390i;
            if (relativeLayout == null) {
                k.a("rlParentTimeLine");
            }
            relativeLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.f19388g;
            if (linearLayout2 == null) {
                k.a("llErrorContainer");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout2);
            TextView textView = this.f19385d;
            if (textView == null) {
                k.a("tvErrorMsg");
            }
            textView.setText(str);
        }
    }

    public final void a() {
        RelativeLayout relativeLayout = this.f19390i;
        if (relativeLayout == null) {
            k.a("rlParentTimeLine");
        }
        relativeLayout.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.f19384c;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        LinearLayout linearLayout = this.f19388g;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        LottieAnimationView lottieAnimationView = this.f19384c;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        LinearLayout linearLayout = this.f19388g;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        RelativeLayout relativeLayout = this.f19390i;
        if (relativeLayout == null) {
            k.a("rlParentTimeLine");
        }
        relativeLayout.setVisibility(0);
        if (iJRPaytmDataModel != null) {
            FdDetailsResponse fdDetailsResponse = (FdDetailsResponse) iJRPaytmDataModel;
            TextView textView = (TextView) a(R.id.tv_toolbar_title);
            k.a((Object) textView, "tv_toolbar_title");
            aa aaVar = aa.f47921a;
            String string = getString(R.string.fd_label);
            k.a((Object) string, "getString(R.string.fd_label)");
            Object[] objArr = new Object[1];
            String str = null;
            objArr[0] = fdDetailsResponse != null ? fdDetailsResponse.getFdId() : null;
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            TextView textView2 = (TextView) a(R.id.tv_toolbar_subtitle);
            k.a((Object) textView2, "tv_toolbar_subtitle");
            StringBuilder sb = new StringBuilder();
            aa aaVar2 = aa.f47921a;
            String string2 = getString(R.string.fd_roi);
            k.a((Object) string2, "getString(R.string.fd_roi)");
            Object[] objArr2 = new Object[1];
            if (fdDetailsResponse != null) {
                str = fdDetailsResponse.getInterest_rate_per_annum();
            }
            objArr2[0] = str;
            String format2 = String.format(string2, Arrays.copyOf(objArr2, 1));
            k.a((Object) format2, "java.lang.String.format(format, *args)");
            sb.append(format2);
            sb.append(getString(R.string.fd_intrest_place_holder));
            textView2.setText(sb.toString());
            a(fdDetailsResponse);
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_time_line_text);
            k.a((Object) recyclerView, "rv_time_line_text");
            recyclerView.setAdapter(new a(this, a(fdDetailsResponse)));
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.FdDetailsResponse");
    }

    public final void a(NetworkCustomError networkCustomError) {
        Boolean bool = this.p;
        if (bool == null) {
            k.a();
        }
        String str = null;
        if (bool.booleanValue()) {
            String fullUrl = networkCustomError != null ? networkCustomError.getFullUrl() : null;
            if (fullUrl == null) {
                k.a();
            }
            k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(this)");
            String t2 = net.one97.paytm.bankCommon.utils.d.t();
            k.a((Object) t2, "GTMLoader.getInstance(this).fdTimeLineUrl");
            if (p.a((CharSequence) fullUrl, (CharSequence) t2, false)) {
                LottieAnimationView lottieAnimationView = this.l;
                if (lottieAnimationView == null) {
                    k.a("loaderCurrentAmount");
                }
                net.one97.paytm.common.widgets.a.b(lottieAnimationView);
                CoordinatorLayout coordinatorLayout = this.j;
                if (coordinatorLayout == null) {
                    k.a("clParent");
                }
                Snackbar a2 = Snackbar.a((View) coordinatorLayout, (CharSequence) getString(R.string.error_fd), 0);
                k.a((Object) a2, "Snackbar.make(clParent, …d), Snackbar.LENGTH_LONG)");
                a2.c();
                this.p = Boolean.FALSE;
                return;
            }
        }
        if (this.s) {
            if (networkCustomError != null) {
                str = networkCustomError.getFullUrl();
            }
            if (str == null) {
                k.a();
            }
            k.a((Object) net.one97.paytm.bankCommon.mapping.g.a(), "GTMLoader.getInstance(this)");
            String u2 = net.one97.paytm.bankCommon.utils.d.u();
            k.a((Object) u2, "GTMLoader.getInstance(this).fdNomineeDetailUrl");
            if (p.a((CharSequence) str, (CharSequence) u2, false)) {
                LinearLayout linearLayout = (LinearLayout) a(R.id.ll_nominee);
                k.a((Object) linearLayout, "ll_nominee");
                linearLayout.setVisibility(8);
                this.s = false;
                return;
            }
        }
        RelativeLayout relativeLayout = this.f19390i;
        if (relativeLayout == null) {
            k.a("rlParentTimeLine");
        }
        relativeLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.f19388g;
        if (linearLayout2 == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout2);
        LottieAnimationView lottieAnimationView2 = this.f19384c;
        if (lottieAnimationView2 == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView2);
    }

    private final ArrayList<a> a(FdDetailsResponse fdDetailsResponse) {
        com.paytm.utility.b.k();
        com.paytm.utility.d.a(this);
        NomineeDetailsResponse nomineeDetailsResponse = null;
        this.t = fdDetailsResponse != null ? fdDetailsResponse.getFdId() : null;
        this.n = fdDetailsResponse != null ? fdDetailsResponse.getNet_principal_amount() : null;
        TextView textView = this.f19387f;
        if (textView == null) {
            k.a("tvCurrentAmount");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(textView);
        if (fdDetailsResponse != null) {
            nomineeDetailsResponse = fdDetailsResponse.getNomineeDetails();
        }
        if (nomineeDetailsResponse != null) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ll_nominee);
            k.a((Object) linearLayout, "ll_nominee");
            linearLayout.setVisibility(0);
            TextView textView2 = (TextView) a(R.id.tv_nominee_name);
            k.a((Object) textView2, "tv_nominee_name");
            textView2.setText(fdDetailsResponse.getNomineeDetails().getName());
            TextView textView3 = (TextView) a(R.id.tv_nominee_relationship);
            k.a((Object) textView3, "tv_nominee_relationship");
            textView3.setText(fdDetailsResponse.getNomineeDetails().getRelationship());
        } else {
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.ll_nominee);
            k.a((Object) linearLayout2, "ll_nominee");
            linearLayout2.setVisibility(8);
        }
        ArrayList<a> arrayList = new ArrayList<>();
        if (fdDetailsResponse == null) {
            k.a();
        }
        double bookingAmount = fdDetailsResponse.getBookingAmount();
        aa aaVar = aa.f47921a;
        String string = getString(R.string.time_line_fd_created);
        k.a((Object) string, "getString(R.string.time_line_fd_created)");
        Object[] objArr = new Object[1];
        String bookingDate = fdDetailsResponse.getBookingDate();
        if (bookingDate == null) {
            k.a();
        }
        objArr[0] = net.one97.paytm.paymentsBank.slfd.b.a.a.a(bookingDate);
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        arrayList.add(new a(format, String.valueOf(bookingAmount), getString(R.string.pricipal_amount)));
        int size = fdDetailsResponse.getFdList().size();
        double d2 = bookingAmount;
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < fdDetailsResponse.getFdList().size()) {
                String a2 = net.one97.paytm.paymentsBank.slfd.b.a.a.a(fdDetailsResponse.getFdList().get(i2).getRedemption_date());
                aa aaVar2 = aa.f47921a;
                String string2 = getString(R.string.redemption_text_label);
                k.a((Object) string2, "getString(R.string.redem…t_label\n                )");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{a2}, 1));
                k.a((Object) format2, "java.lang.String.format(format, *args)");
                d2 -= fdDetailsResponse.getFdList().get(i2).getTransaction_amount();
                if (d2 == 0.0d) {
                    aa aaVar3 = aa.f47921a;
                    String string3 = getString(R.string.full_fd_redeemed);
                    k.a((Object) string3, "getString(R.string.full_fd_redeemed)");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{format2}, 1));
                    k.a((Object) format3, "java.lang.String.format(format, *args)");
                    arrayList.add(new a(format3, "", getString(R.string.redemption_amount_label)));
                }
                arrayList.add(new a(format2, String.valueOf(d2), getString(R.string.redemption_amount_label)));
            }
        }
        String maturity_date = fdDetailsResponse.getMaturity_date();
        if (maturity_date == null) {
            k.a();
        }
        String a3 = net.one97.paytm.paymentsBank.slfd.b.a.a.a(maturity_date);
        aa aaVar4 = aa.f47921a;
        String string4 = getString(R.string.fd_maturing_on);
        k.a((Object) string4, "getString(R.string.fd_maturing_on)");
        String format4 = String.format(string4, Arrays.copyOf(new Object[]{a3}, 1));
        k.a((Object) format4, "java.lang.String.format(format, *args)");
        if (!p.a(fdDetailsResponse.getFdStatus(), "closed", false)) {
            arrayList.add(new a(format4, String.valueOf(fdDetailsResponse.getMaturity_amount()), getString(R.string.maturity_amount)));
        }
        return arrayList;
    }

    public final void b(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            AmountDetailsResponse amountDetailsResponse = (AmountDetailsResponse) iJRPaytmDataModel;
            k.c(amountDetailsResponse, "amountDetailsResponse");
            this.p = Boolean.FALSE;
            LottieAnimationView lottieAnimationView = this.l;
            if (lottieAnimationView == null) {
                k.a("loaderCurrentAmount");
            }
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
            Context context = this;
            View inflate = LayoutInflater.from(context).inflate(R.layout.slfd_current_amount_bottomsheet, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.tv_current_value_label);
            if (findViewById != null) {
                TextView textView = (TextView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.tv_amount);
                if (findViewById2 != null) {
                    TextView textView2 = (TextView) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.tv_interest_rate_label);
                    if (findViewById3 != null) {
                        TextView textView3 = (TextView) findViewById3;
                        View findViewById4 = inflate.findViewById(R.id.tv_interest_amount);
                        if (findViewById4 != null) {
                            TextView textView4 = (TextView) findViewById4;
                            View findViewById5 = inflate.findViewById(R.id.img_cancel_sheet);
                            if (findViewById5 != null) {
                                ImageView imageView = (ImageView) findViewById5;
                                View findViewById6 = inflate.findViewById(R.id.tv_redeem_fd);
                                if (findViewById6 != null) {
                                    TextView textView5 = (TextView) findViewById6;
                                    com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context);
                                    aVar.setContentView(inflate);
                                    int i2 = R.string.current_amount_today;
                                    Calendar instance = Calendar.getInstance();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM ''yy");
                                    k.a((Object) instance, "c");
                                    String format = simpleDateFormat.format(instance.getTime());
                                    k.a((Object) format, "formattedDate");
                                    textView.setText(getString(i2, new Object[]{format}));
                                    a(String.valueOf(amountDetailsResponse.getNet_amount_payout()), textView2);
                                    textView3.setText(getString(R.string.current_amount_intrest_amount, new Object[]{String.valueOf(amountDetailsResponse.getIntrest_rate())}));
                                    a(String.valueOf(amountDetailsResponse.getInterest()), textView4);
                                    k.a((Object) inflate, "bottomSheet");
                                    ViewParent parent = inflate.getParent();
                                    if (parent != null) {
                                        BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
                                        k.a((Object) from, "BottomSheetBehavior.from…ttomSheet.parent as View)");
                                        from.setState(3);
                                        aVar.show();
                                        textView5.setOnClickListener(new f(this, aVar));
                                        imageView.setOnClickListener(new g(aVar));
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.view.View");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.ImageView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.AmountDetailsResponse");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TimelineSlfdActivity f19397a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f19398b;

        f(TimelineSlfdActivity timelineSlfdActivity, com.google.android.material.bottomsheet.a aVar) {
            this.f19397a = timelineSlfdActivity;
            this.f19398b = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19397a, "fixed_deposit", "current_value_reedem_fixed_deposit_clicked", (String) null, (String) null, (String) null, "/fixed-deposit/redeem", "fixed_deposit");
            this.f19397a.f().c();
            this.f19398b.cancel();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f19399a;

        g(com.google.android.material.bottomsheet.a aVar) {
            this.f19399a = aVar;
        }

        public final void onClick(View view) {
            this.f19399a.cancel();
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f19391a;

        /* renamed from: b  reason: collision with root package name */
        String f19392b;

        /* renamed from: c  reason: collision with root package name */
        String f19393c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return k.a((Object) this.f19391a, (Object) aVar.f19391a) && k.a((Object) this.f19392b, (Object) aVar.f19392b) && k.a((Object) this.f19393c, (Object) aVar.f19393c);
        }

        public final int hashCode() {
            String str = this.f19391a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f19392b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f19393c;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "TimeLineModel(label=" + this.f19391a + ", amount=" + this.f19392b + ", description=" + this.f19393c + ")";
        }

        public a(String str, String str2, String str3) {
            this.f19391a = str;
            this.f19392b = str2;
            this.f19393c = str3;
        }
    }

    private void a(String str, TextView textView) {
        k.c(textView, "tv_amount");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.fd_amount, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(str)});
        k.a((Object) string, "getString(R.string.fd_am…ty.priceToString(amount))");
        String format = String.format(string, Arrays.copyOf(new Object[0], 0));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        net.one97.paytm.bankCommon.mapping.e.a(format, textView);
    }

    public final void b() {
        ProgressBar progressBar = this.m;
        if (progressBar == null) {
            k.a("translucentProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
    }

    public final void a(String str, Double d2) {
        ProgressBar progressBar = this.m;
        if (progressBar == null) {
            k.a("translucentProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        Intent intent = new Intent(this, SlfdCheckoutActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("slfd_amount", d2);
        intent.putExtra("account_num", (String) this.v.getValue());
        startActivity(intent);
        finish();
    }

    public final void c(String str) {
        k.c(str, "message");
        ProgressBar progressBar = this.m;
        if (progressBar == null) {
            k.a("translucentProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        CoordinatorLayout coordinatorLayout = this.j;
        if (coordinatorLayout == null) {
            k.a("clParent");
        }
        Snackbar a2 = Snackbar.a((View) coordinatorLayout, (CharSequence) str, 0);
        k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void ak_() {
        ProgressBar progressBar = this.m;
        if (progressBar == null) {
            k.a("translucentProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
        String string = getString(R.string.fd_passcode_title);
        k.a((Object) string, "getString(R.string.fd_passcode_title)");
        BankPasscodeActivity.a.a(this, string);
    }

    public final void b(String str) {
        ProgressBar progressBar = this.m;
        if (progressBar == null) {
            k.a("translucentProgress");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar);
        if (str == null) {
            str = "Something went wrong";
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a((AppCompatActivity) this, (CharSequence) str);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 121) {
            if (i2 == 301 && i3 == -1) {
                finish();
            }
        } else if (i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            a.C0344a f2 = f();
            String stringExtra = intent.getStringExtra("passcode");
            k.a((Object) stringExtra, "data.getStringExtra(PBConstants.EXTRA_PASSCODE)");
            f2.a(stringExtra);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        f().b();
    }
}
