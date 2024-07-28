package net.one97.paytm.wallet.rateMerchant;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.u;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.rateMerchant.a;
import net.one97.paytm.wallet.rateMerchant.c.c;
import net.one97.paytm.wallet.rateMerchant.entity.AnswerOption;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import net.one97.paytm.wallet.rateMerchant.entity.QnAModel;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestion;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionData;
import net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse;
import net.one97.paytm.wallet.rateMerchant.utils.HorizontalStepView;

public final class b extends net.one97.paytm.i.f implements a.C1454a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f71619a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private View f71620b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f71621c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f71622d;

    /* renamed from: e  reason: collision with root package name */
    private RatingBar f71623e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f71624f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f71625g;

    /* renamed from: h  reason: collision with root package name */
    private View f71626h;

    /* renamed from: i  reason: collision with root package name */
    private View f71627i;
    private View j;
    private ImageView k;
    private LottieAnimationView l;
    private FrameLayout m;
    private TextView n;
    private View o;
    private RatingBar p;
    private ViewAnimator q;
    private HorizontalStepView r;
    private net.one97.paytm.wallet.rateMerchant.c.a s;
    /* access modifiers changed from: private */
    public final List<Integer> t = new ArrayList();
    private C1457b u;
    private String v;
    private HashMap w;

    static final class h<T> implements z<MerchantPPReviewData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71665a;

        h(b bVar) {
            this.f71665a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            MerchantPPReviewData merchantPPReviewData = (MerchantPPReviewData) obj;
            if (merchantPPReviewData != null) {
                try {
                    b.a(this.f71665a, merchantPPReviewData);
                } catch (Exception unused) {
                    this.f71665a.dismissAllowingStateLoss();
                }
            } else {
                this.f71665a.dismissAllowingStateLoss();
            }
        }
    }

    static final class i<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71666a;

        i(b bVar) {
            this.f71666a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.b bVar;
            NetworkCustomError.ErrorType errorType;
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            String str = null;
            if (aVar != null) {
                bVar = aVar.f71611a;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                int i2 = c.f71675a[bVar.ordinal()];
                if (i2 == 1) {
                    this.f71666a.e();
                } else if (i2 != 2 && i2 == 3) {
                    FragmentActivity activity = this.f71666a.getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity, "activity!!");
                    Context context = activity;
                    NetworkCustomError networkCustomError = aVar.f71613c;
                    if (!(networkCustomError == null || (errorType = networkCustomError.getErrorType()) == null)) {
                        str = errorType.name();
                    }
                    Toast.makeText(this.f71666a.getActivity(), net.one97.paytm.wallet.rateMerchant.utils.a.a(context, str), 0).show();
                }
            }
        }
    }

    static final class j<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71667a;

        j(b bVar) {
            this.f71667a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.wallet.rateMerchant.a.b bVar;
            int i2;
            net.one97.paytm.wallet.rateMerchant.a.a aVar = (net.one97.paytm.wallet.rateMerchant.a.a) obj;
            if (aVar != null) {
                bVar = aVar.f71611a;
            } else {
                bVar = null;
            }
            if (bVar != null && (i2 = c.f71676b[bVar.ordinal()]) != 1 && i2 != 2 && i2 == 3) {
                int i3 = (int) b.a(this.f71667a).f71681d;
                Toast.makeText(this.f71667a.getActivity(), this.f71667a.getResources().getQuantityString(R.plurals.feedback_rate_message, i3, new Object[]{Integer.valueOf(i3)}), 0).show();
            }
        }
    }

    static final class k<T> implements z<net.one97.paytm.wallet.rateMerchant.a.a<ReviewQuestionResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71668a;

        k(b bVar) {
            this.f71668a = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v10 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                net.one97.paytm.wallet.rateMerchant.a.a r6 = (net.one97.paytm.wallet.rateMerchant.a.a) r6
                r0 = 0
                if (r6 == 0) goto L_0x0008
                net.one97.paytm.wallet.rateMerchant.a.b r1 = r6.f71611a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.wallet.rateMerchant.c.f71677c
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 0
                r3 = 1
                if (r1 == r3) goto L_0x006b
                r4 = 2
                if (r1 == r4) goto L_0x0065
                r4 = 3
                if (r1 == r4) goto L_0x001f
                goto L_0x0064
            L_0x001f:
                net.one97.paytm.wallet.rateMerchant.b r1 = r5.f71668a
                net.one97.paytm.wallet.rateMerchant.b.a((net.one97.paytm.wallet.rateMerchant.b) r1, (boolean) r2)
                com.paytm.network.model.NetworkCustomError r6 = r6.f71613c
                if (r6 == 0) goto L_0x0032
                com.paytm.network.model.NetworkCustomError$ErrorType r6 = r6.getErrorType()
                if (r6 == 0) goto L_0x0032
                java.lang.String r0 = r6.name()
            L_0x0032:
                if (r0 == 0) goto L_0x005f
                com.paytm.network.model.NetworkCustomError$ErrorType r6 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError
                java.lang.String r6 = r6.name()
                boolean r6 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r6, (boolean) r3)
                if (r6 == 0) goto L_0x005f
                net.one97.paytm.wallet.rateMerchant.b r6 = r5.f71668a
                int r0 = net.one97.paytm.wallet.R.string.channels_no_internet
                java.lang.String r6 = r6.getString(r0)
                java.lang.String r0 = "getString(R.string.channels_no_internet)"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
                net.one97.paytm.wallet.rateMerchant.b r0 = r5.f71668a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.content.Context r0 = (android.content.Context) r0
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                android.widget.Toast r6 = android.widget.Toast.makeText(r0, r6, r2)
                r6.show()
                return
            L_0x005f:
                net.one97.paytm.wallet.rateMerchant.b r6 = r5.f71668a
                r6.b()
            L_0x0064:
                return
            L_0x0065:
                net.one97.paytm.wallet.rateMerchant.b r6 = r5.f71668a
                net.one97.paytm.wallet.rateMerchant.b.a((net.one97.paytm.wallet.rateMerchant.b) r6, (boolean) r3)
                return
            L_0x006b:
                net.one97.paytm.wallet.rateMerchant.b r1 = r5.f71668a
                net.one97.paytm.wallet.rateMerchant.b.a((net.one97.paytm.wallet.rateMerchant.b) r1, (boolean) r2)
                ResultType r6 = r6.f71612b
                net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse r6 = (net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionResponse) r6
                if (r6 == 0) goto L_0x007a
                net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionData r0 = r6.getReviewQuestionData()
            L_0x007a:
                net.one97.paytm.wallet.rateMerchant.b r6 = r5.f71668a     // Catch:{ Exception -> 0x0080 }
                net.one97.paytm.wallet.rateMerchant.b.a((net.one97.paytm.wallet.rateMerchant.b) r6, (net.one97.paytm.wallet.rateMerchant.entity.ReviewQuestionData) r0)     // Catch:{ Exception -> 0x0080 }
                return
            L_0x0080:
                net.one97.paytm.wallet.rateMerchant.b r6 = r5.f71668a
                r6.dismissAllowingStateLoss()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.rateMerchant.b.k.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ net.one97.paytm.wallet.rateMerchant.c.a a(b bVar) {
        net.one97.paytm.wallet.rateMerchant.c.a aVar = bVar.s;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public static final /* synthetic */ RatingBar b(b bVar) {
        RatingBar ratingBar = bVar.p;
        if (ratingBar == null) {
            kotlin.g.b.k.a("ratingBarSelectable");
        }
        return ratingBar;
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.b$b  reason: collision with other inner class name */
    public static final class C1457b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Fragment> f71633a;

        public C1457b(WeakReference<Fragment> weakReference) {
            kotlin.g.b.k.c(weakReference, "ref");
            this.f71633a = weakReference;
        }

        public final void handleMessage(Message message) {
            Integer valueOf = message != null ? Integer.valueOf(message.what) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                Fragment fragment = (Fragment) this.f71633a.get();
                if (!(fragment instanceof com.google.android.material.bottomsheet.b)) {
                    fragment = null;
                }
                com.google.android.material.bottomsheet.b bVar = (com.google.android.material.bottomsheet.b) fragment;
                if (bVar != null && bVar.isAdded()) {
                    bVar.dismissAllowingStateLoss();
                    return;
                }
                return;
            }
            super.handleMessage(message);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(String str, MerchantPPReviewData merchantPPReviewData) {
            Bundle bundle = new Bundle();
            bundle.putString("merchant_name", str);
            bundle.putSerializable("channel_merchant_data", merchantPPReviewData);
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.ptxn_feedback_fragment, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.merchant_info_header);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.merchant_info_header)");
        this.f71620b = findViewById;
        View view = this.f71620b;
        if (view == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        View findViewById2 = view.findViewById(R.id.tvMerchantName);
        kotlin.g.b.k.a((Object) findViewById2, "merchantInfoHeader.findV…ById(R.id.tvMerchantName)");
        this.f71621c = (TextView) findViewById2;
        View view2 = this.f71620b;
        if (view2 == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        View findViewById3 = view2.findViewById(R.id.tvFollowers);
        kotlin.g.b.k.a((Object) findViewById3, "merchantInfoHeader.findViewById(R.id.tvFollowers)");
        this.f71622d = (TextView) findViewById3;
        View view3 = this.f71620b;
        if (view3 == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        View findViewById4 = view3.findViewById(R.id.ratingBarFilled);
        kotlin.g.b.k.a((Object) findViewById4, "merchantInfoHeader.findV…yId(R.id.ratingBarFilled)");
        this.f71623e = (RatingBar) findViewById4;
        View view4 = this.f71620b;
        if (view4 == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        View findViewById5 = view4.findViewById(R.id.tvFollowing);
        kotlin.g.b.k.a((Object) findViewById5, "merchantInfoHeader.findViewById(R.id.tvFollowing)");
        this.f71624f = (TextView) findViewById5;
        View view5 = this.f71620b;
        if (view5 == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        View findViewById6 = view5.findViewById(R.id.ivForward);
        kotlin.g.b.k.a((Object) findViewById6, "merchantInfoHeader.findViewById(R.id.ivForward)");
        this.f71625g = (ImageView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.fl_feedback_content);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.fl_feedback_content)");
        this.j = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.ivClose);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.ivClose)");
        this.k = (ImageView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.tvRateExperience);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.tvRateExperience)");
        this.n = (TextView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.loadingContainer);
        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById(R.id.loadingContainer)");
        this.m = (FrameLayout) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.parent_multi_choice);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.parent_multi_choice)");
        this.f71626h = findViewById11;
        View findViewById12 = inflate.findViewById(R.id.parent_feedback_success);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.parent_feedback_success)");
        this.f71627i = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.rate_merchant_view);
        kotlin.g.b.k.a((Object) findViewById13, "view.findViewById(R.id.rate_merchant_view)");
        this.o = findViewById13;
        View findViewById14 = inflate.findViewById(R.id.singleChoice_animator);
        kotlin.g.b.k.a((Object) findViewById14, "view.findViewById(R.id.singleChoice_animator)");
        this.q = (ViewAnimator) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.singlechoice_progress);
        kotlin.g.b.k.a((Object) findViewById15, "view.findViewById(R.id.singlechoice_progress)");
        this.r = (HorizontalStepView) findViewById15;
        View view6 = this.o;
        if (view6 == null) {
            kotlin.g.b.k.a("rateMerchantView");
        }
        View findViewById16 = view6.findViewById(R.id.ratingBarSelectable);
        kotlin.g.b.k.a((Object) findViewById16, "rateMerchantView.findVie…R.id.ratingBarSelectable)");
        this.p = (RatingBar) findViewById16;
        View findViewById17 = inflate.findViewById(R.id.wallet_loader);
        kotlin.g.b.k.a((Object) findViewById17, "view.findViewById(R.id.wallet_loader)");
        this.l = (LottieAnimationView) findViewById17;
        this.u = new C1457b(new WeakReference(this));
        return inflate;
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71669a;

        l(b bVar) {
            this.f71669a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f71669a).a("toggle_follow_state", (Object) null);
            b.a(this.f71669a, b.a(this.f71669a).f71680c ? "follow_clicked" : "unfollow_clicked", (ArrayList) null, 6);
        }
    }

    static final class m implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71670a;

        m(b bVar) {
            this.f71670a = bVar;
        }

        public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
            if (f2 < 1.0f) {
                b.b(this.f71670a).setRating(1.0f);
            }
            b.a(this.f71670a).a("save_rating", (Object) Float.valueOf(f2));
            b.a(this.f71670a).a("get_rating_question", (Object) Float.valueOf(f2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(f2));
            b.a(this.f71670a, "PG_rate_clicked", arrayList, 4);
        }
    }

    static final class n implements RatingBar.OnRatingBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71671a;

        n(b bVar) {
            this.f71671a = bVar;
        }

        public final void onRatingChanged(RatingBar ratingBar, float f2, boolean z) {
            b.a(this.f71671a).a("update_rating", (Object) Float.valueOf(f2));
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71672a;

        o(b bVar) {
            this.f71672a = bVar;
        }

        public final void onClick(View view) {
            b.c(this.f71672a);
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71673a;

        p(b bVar) {
            this.f71673a = bVar;
        }

        public final void onClick(View view) {
            b.c(this.f71673a);
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71674a;

        q(b bVar) {
            this.f71674a = bVar;
        }

        public final void onClick(View view) {
            this.f71674a.dismissAllowingStateLoss();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        Window window = dialog != null ? dialog.getWindow() : null;
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.dimAmount = 0.1f;
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCanceledOnTouchOutside(false);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_left);
        ViewAnimator viewAnimator = this.q;
        if (viewAnimator == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        viewAnimator.setInAnimation(loadAnimation);
        ViewAnimator viewAnimator2 = this.q;
        if (viewAnimator2 == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        viewAnimator2.setOutAnimation(loadAnimation2);
        Bundle arguments = getArguments();
        this.v = arguments != null ? arguments.getString("merchant_name") : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("channel_merchant_data") : null;
        if (!(serializable instanceof MerchantPPReviewData)) {
            serializable = null;
        }
        MerchantPPReviewData merchantPPReviewData = (MerchantPPReviewData) serializable;
        if (merchantPPReviewData == null) {
            dismissAllowingStateLoss();
            return;
        }
        this.s = (net.one97.paytm.wallet.rateMerchant.c.a) net.one97.paytm.wallet.rateMerchant.utils.a.a((Fragment) this, net.one97.paytm.wallet.rateMerchant.c.a.class);
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent != null) {
            ((View) parent).setBackgroundColor(0);
            net.one97.paytm.wallet.rateMerchant.c.a aVar = this.s;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar.f71682e = merchantPPReviewData;
            aVar.f71679b.setValue(merchantPPReviewData);
            net.one97.paytm.wallet.rateMerchant.c.a.a(merchantPPReviewData);
            net.one97.paytm.wallet.rateMerchant.c.a aVar2 = this.s;
            if (aVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar2.f71679b.observe(getViewLifecycleOwner(), new h(this));
            net.one97.paytm.wallet.rateMerchant.c.a aVar3 = this.s;
            if (aVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar3.f71683f.observe(getViewLifecycleOwner(), new i(this));
            net.one97.paytm.wallet.rateMerchant.c.a aVar4 = this.s;
            if (aVar4 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar4.f71684g.observe(getViewLifecycleOwner(), new j(this));
            net.one97.paytm.wallet.rateMerchant.c.a aVar5 = this.s;
            if (aVar5 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar5.f71685h.observe(getViewLifecycleOwner(), new k(this));
            TextView textView = this.f71624f;
            if (textView == null) {
                kotlin.g.b.k.a("tvFollow");
            }
            textView.setOnClickListener(new l(this));
            RatingBar ratingBar = this.p;
            if (ratingBar == null) {
                kotlin.g.b.k.a("ratingBarSelectable");
            }
            ratingBar.setOnRatingBarChangeListener(new m(this));
            RatingBar ratingBar2 = this.f71623e;
            if (ratingBar2 == null) {
                kotlin.g.b.k.a("ratingBarFilled");
            }
            ratingBar2.setOnRatingBarChangeListener(new n(this));
            TextView textView2 = this.f71621c;
            if (textView2 == null) {
                kotlin.g.b.k.a("merchantName");
            }
            textView2.setOnClickListener(new o(this));
            ImageView imageView = this.f71625g;
            if (imageView == null) {
                kotlin.g.b.k.a("ivForward");
            }
            imageView.setOnClickListener(new p(this));
            ImageView imageView2 = this.k;
            if (imageView2 == null) {
                kotlin.g.b.k.a("ivClose");
            }
            imageView2.setOnClickListener(new q(this));
            a(this, "pg_rate_window_loaded", (ArrayList) null, 6);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71641a;

        c(b bVar) {
            this.f71641a = bVar;
        }

        public final void onClick(View view) {
            this.f71641a.a();
            b.a(this.f71641a).a("rate_experience", (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        View view = this.o;
        if (view == null) {
            kotlin.g.b.k.a("rateMerchantView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.a(view);
        TextView textView = this.n;
        if (textView == null) {
            kotlin.g.b.k.a("rateYouExperience");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
        RatingBar ratingBar = this.f71623e;
        if (ratingBar == null) {
            kotlin.g.b.k.a("ratingBarFilled");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(ratingBar);
        c();
        View view2 = this.f71626h;
        if (view2 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(view2);
    }

    /* access modifiers changed from: private */
    public final void b() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        C1457b bVar = this.u;
        if (bVar != null) {
            bVar.sendMessageDelayed(obtain, 2000);
        }
    }

    private final void a(ReviewQuestion reviewQuestion, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(reviewQuestion.getQuestionId()));
        arrayList.add(String.valueOf(i2 - i3));
        a(this, "pg_question_viewed", arrayList, 4);
    }

    private final void c() {
        ViewAnimator viewAnimator = this.q;
        if (viewAnimator == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        viewAnimator.removeAllViews();
        ViewAnimator viewAnimator2 = this.q;
        if (viewAnimator2 == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(viewAnimator2);
        HorizontalStepView horizontalStepView = this.r;
        if (horizontalStepView == null) {
            kotlin.g.b.k.a("singleChoiceProgress");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(horizontalStepView);
    }

    private final int d() {
        ViewAnimator viewAnimator = this.q;
        if (viewAnimator == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        return viewAnimator.getDisplayedChild();
    }

    private final void b(ReviewQuestion reviewQuestion, int i2, int i3) {
        View view = this.o;
        if (view == null) {
            kotlin.g.b.k.a("rateMerchantView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(view);
        View view2 = this.f71626h;
        if (view2 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(view2);
        ViewAnimator viewAnimator = this.q;
        if (viewAnimator == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        if (viewAnimator.getChildCount() != i2) {
            ViewAnimator viewAnimator2 = this.q;
            if (viewAnimator2 == null) {
                kotlin.g.b.k.a("singleChoiceAnimator");
            }
            viewAnimator2.removeAllViews();
            HorizontalStepView horizontalStepView = this.r;
            if (horizontalStepView == null) {
                kotlin.g.b.k.a("singleChoiceProgress");
            }
            horizontalStepView.b();
            for (int i4 = 0; i4 < i2; i4++) {
                LayoutInflater layoutInflater = getLayoutInflater();
                int i5 = R.layout.ptxn_singlechoice_question;
                ViewAnimator viewAnimator3 = this.q;
                if (viewAnimator3 == null) {
                    kotlin.g.b.k.a("singleChoiceAnimator");
                }
                View inflate = layoutInflater.inflate(i5, viewAnimator3, false);
                ViewAnimator viewAnimator4 = this.q;
                if (viewAnimator4 == null) {
                    kotlin.g.b.k.a("singleChoiceAnimator");
                }
                viewAnimator4.addView(inflate);
            }
            ViewAnimator viewAnimator5 = this.q;
            if (viewAnimator5 == null) {
                kotlin.g.b.k.a("singleChoiceAnimator");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(viewAnimator5);
            HorizontalStepView horizontalStepView2 = this.r;
            if (horizontalStepView2 == null) {
                kotlin.g.b.k.a("singleChoiceProgress");
            }
            horizontalStepView2.setStepCount(i2);
            HorizontalStepView horizontalStepView3 = this.r;
            if (horizontalStepView3 == null) {
                kotlin.g.b.k.a("singleChoiceProgress");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(horizontalStepView3);
            HorizontalStepView horizontalStepView4 = this.r;
            if (horizontalStepView4 == null) {
                kotlin.g.b.k.a("singleChoiceProgress");
            }
            horizontalStepView4.a();
        }
        if (d() != i2 - (i3 + 1)) {
            ViewAnimator viewAnimator6 = this.q;
            if (viewAnimator6 == null) {
                kotlin.g.b.k.a("singleChoiceAnimator");
            }
            viewAnimator6.showNext();
            HorizontalStepView horizontalStepView5 = this.r;
            if (horizontalStepView5 == null) {
                kotlin.g.b.k.a("singleChoiceProgress");
            }
            horizontalStepView5.a();
        }
        ViewAnimator viewAnimator7 = this.q;
        if (viewAnimator7 == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        View currentView = viewAnimator7.getCurrentView();
        TextView textView = (TextView) currentView.findViewById(R.id.tvQuestionTitle);
        TextView textView2 = (TextView) currentView.findViewById(R.id.tvOption1);
        TextView textView3 = (TextView) currentView.findViewById(R.id.tvOption2);
        TextView textView4 = (TextView) currentView.findViewById(R.id.tvOption3);
        kotlin.g.b.k.a((Object) textView, "questionTitle");
        textView.setText(reviewQuestion.getQuestionTitle());
        kotlin.g.b.k.a((Object) textView2, "option1");
        textView2.setText(reviewQuestion.getOptionList().get(0).getOptionTitle());
        kotlin.g.b.k.a((Object) textView3, "option2");
        textView3.setText(reviewQuestion.getOptionList().get(1).getOptionTitle());
        if (reviewQuestion.getOptionList().size() > 2) {
            kotlin.g.b.k.a((Object) textView4, "option3");
            textView4.setText(reviewQuestion.getOptionList().get(2).getOptionTitle());
        }
        textView2.setActivated(false);
        textView3.setActivated(false);
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        textView2.setTextColor(androidx.core.content.b.c(context, R.color.blue_dot));
        Context context2 = getContext();
        if (context2 == null) {
            kotlin.g.b.k.a();
        }
        textView3.setTextColor(androidx.core.content.b.c(context2, R.color.blue_dot));
        textView2.setOnClickListener(new e(this, textView2, reviewQuestion));
        textView3.setOnClickListener(new f(this, textView3, reviewQuestion));
        textView4.setOnClickListener(new g(this, reviewQuestion));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f71654b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReviewQuestion f71655c;

        e(b bVar, TextView textView, ReviewQuestion reviewQuestion) {
            this.f71653a = bVar;
            this.f71654b = textView;
            this.f71655c = reviewQuestion;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "it");
            view.setActivated(!view.isActivated());
            if (view.isActivated()) {
                TextView textView = this.f71654b;
                Context context = this.f71653a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                textView.setTextColor(androidx.core.content.b.c(context, R.color.white));
            } else {
                TextView textView2 = this.f71654b;
                Context context2 = this.f71653a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(context2, R.color.blue_dot));
            }
            AnswerOption answerOption = this.f71655c.getOptionList().get(0);
            b.a(this.f71653a, this.f71655c.getQuestionId(), answerOption.getOptionId(), answerOption.getOptionTitle());
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71660a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f71661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReviewQuestion f71662c;

        f(b bVar, TextView textView, ReviewQuestion reviewQuestion) {
            this.f71660a = bVar;
            this.f71661b = textView;
            this.f71662c = reviewQuestion;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "it");
            view.setActivated(!view.isActivated());
            if (view.isActivated()) {
                TextView textView = this.f71661b;
                Context context = this.f71660a.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                textView.setTextColor(androidx.core.content.b.c(context, R.color.white));
            } else {
                TextView textView2 = this.f71661b;
                Context context2 = this.f71660a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                textView2.setTextColor(androidx.core.content.b.c(context2, R.color.blue_dot));
            }
            AnswerOption answerOption = this.f71662c.getOptionList().get(1);
            b.a(this.f71660a, this.f71662c.getQuestionId(), answerOption.getOptionId(), answerOption.getOptionTitle());
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71663a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewQuestion f71664b;

        g(b bVar, ReviewQuestion reviewQuestion) {
            this.f71663a = bVar;
            this.f71664b = reviewQuestion;
        }

        public final void onClick(View view) {
            if (this.f71664b.getOptionList().size() > 2) {
                kotlin.g.b.k.a((Object) view, "it");
                view.setActivated(!view.isActivated());
                AnswerOption answerOption = this.f71664b.getOptionList().get(2);
                b.a(this.f71663a, this.f71664b.getQuestionId(), answerOption.getOptionId(), answerOption.getOptionTitle());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, String str, int i3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(i2));
        arrayList.add(this.t.toString());
        arrayList.add(String.valueOf(i3));
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                kotlin.g.b.k.a();
            }
            arrayList.add(str);
        }
        a(this, "pg_answer_clicked", arrayList, 4);
    }

    private final void a(ReviewQuestion reviewQuestion) {
        ViewAnimator viewAnimator = this.q;
        if (viewAnimator == null) {
            kotlin.g.b.k.a("singleChoiceAnimator");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(viewAnimator);
        View view = this.o;
        if (view == null) {
            kotlin.g.b.k.a("rateMerchantView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(view);
        View view2 = this.f71626h;
        if (view2 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.a(view2);
        View view3 = this.f71626h;
        if (view3 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        TextView textView = (TextView) view3.findViewById(R.id.tvQuestionTitle);
        View view4 = this.f71626h;
        if (view4 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        RecyclerView recyclerView = (RecyclerView) view4.findViewById(R.id.rvMultiChoiceOptions);
        View view5 = this.f71626h;
        if (view5 == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view5.findViewById(R.id.fabDone);
        floatingActionButton.c();
        kotlin.g.b.k.a((Object) textView, "questionTitle");
        textView.setText(reviewQuestion.getQuestionTitle());
        kotlin.g.b.k.a((Object) recyclerView, "rvOptions");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new a(reviewQuestion.getOptionList(), this));
        recyclerView.setHasFixedSize(true);
        floatingActionButton.setOnClickListener(new d(this, reviewQuestion));
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71642a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReviewQuestion f71643b;

        d(b bVar, ReviewQuestion reviewQuestion) {
            this.f71642a = bVar;
            this.f71643b = reviewQuestion;
        }

        public final void onClick(View view) {
            b.a(this.f71642a).a("multichoice_answer_submitted", (Object) new QnAModel(this.f71643b.getQuestionId(), kotlin.a.k.e(this.f71642a.t)));
            this.f71642a.a(this.f71643b.getQuestionId(), (String) null, 1);
        }
    }

    public final void a(int i2) {
        View view = this.f71626h;
        if (view == null) {
            kotlin.g.b.k.a("parentMultiChoiceView");
        }
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabDone);
        if (this.t.contains(Integer.valueOf(i2))) {
            this.t.remove(Integer.valueOf(i2));
        } else {
            this.t.add(Integer.valueOf(i2));
        }
        if (this.t.size() > 0) {
            floatingActionButton.b();
        } else {
            floatingActionButton.c();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        net.one97.paytm.wallet.rateMerchant.c.a aVar = this.s;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String str = null;
        if (aVar.f71680c) {
            TextView textView = this.f71624f;
            if (textView == null) {
                kotlin.g.b.k.a("tvFollow");
            }
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.channels_following);
            }
            textView.setText(str);
            TextView textView2 = this.f71624f;
            if (textView2 == null) {
                kotlin.g.b.k.a("tvFollow");
            }
            textView2.setActivated(false);
            TextView textView3 = this.f71624f;
            if (textView3 == null) {
                kotlin.g.b.k.a("tvFollow");
            }
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            textView3.setTextColor(androidx.core.content.b.c(context2, R.color.color_999999));
            return;
        }
        TextView textView4 = this.f71624f;
        if (textView4 == null) {
            kotlin.g.b.k.a("tvFollow");
        }
        Context context3 = getContext();
        if (context3 != null) {
            str = context3.getString(R.string.channels_follow);
        }
        textView4.setText(str);
        TextView textView5 = this.f71624f;
        if (textView5 == null) {
            kotlin.g.b.k.a("tvFollow");
        }
        textView5.setActivated(true);
        TextView textView6 = this.f71624f;
        if (textView6 == null) {
            kotlin.g.b.k.a("tvFollow");
        }
        Context context4 = getContext();
        if (context4 == null) {
            kotlin.g.b.k.a();
        }
        textView6.setTextColor(androidx.core.content.b.c(context4, R.color.blue_dot));
    }

    static /* synthetic */ void a(b bVar, String str, ArrayList arrayList, int i2) {
        if ((i2 & 2) != 0) {
            arrayList = null;
        }
        bVar.a(str, (ArrayList<String>) arrayList);
    }

    private final void a(String str, ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        net.one97.paytm.wallet.rateMerchant.c.a aVar = this.s;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String a2 = aVar.a();
        if (a2 != null) {
            arrayList2.add(a2);
        }
        net.one97.paytm.wallet.rateMerchant.c.a aVar2 = this.s;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        List<String> b2 = aVar2.b();
        String obj = b2 != null ? b2.toString() : null;
        if (obj != null) {
            arrayList2.add(obj);
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.addAll(arrayList);
        }
        if (getActivity() != null) {
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEventsWithMultipleLabel(getActivity(), "channels_post_transaction", str, arrayList2, (String) null, "Payment_success", "wallet");
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        c.a aVar = net.one97.paytm.wallet.rateMerchant.c.c.f71702a;
        net.one97.paytm.wallet.rateMerchant.c.c.f71703d = null;
    }

    public static final /* synthetic */ void c(b bVar) {
        net.one97.paytm.wallet.communicator.b.a().checkDeepLinking(bVar.getActivity(), "paytmmp://channels_home");
        FragmentActivity activity = bVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
        a(bVar, "pg_merchant_name_clicked", (ArrayList) null, 6);
    }

    public static final /* synthetic */ void a(b bVar, MerchantPPReviewData merchantPPReviewData) {
        View view = bVar.f71620b;
        if (view == null) {
            kotlin.g.b.k.a("merchantInfoHeader");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.a(view);
        TextView textView = bVar.f71621c;
        if (textView == null) {
            kotlin.g.b.k.a("merchantName");
        }
        String str = bVar.v;
        if (str == null) {
            str = merchantPPReviewData.getMerchantName();
        }
        CharSequence charSequence = str;
        if (charSequence == null) {
        }
        textView.setText(charSequence);
        Integer followersCount = merchantPPReviewData.getFollowersCount();
        if (followersCount != null && followersCount.intValue() == 0) {
            TextView textView2 = bVar.f71622d;
            if (textView2 == null) {
                kotlin.g.b.k.a("tvFollowerCount");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView2);
        } else {
            TextView textView3 = bVar.f71622d;
            if (textView3 == null) {
                kotlin.g.b.k.a("tvFollowerCount");
            }
            textView3.setText(bVar.getString(R.string.people_following, followersCount));
        }
        TextView textView4 = bVar.n;
        if (textView4 == null) {
            kotlin.g.b.k.a("rateYouExperience");
        }
        textView4.setOnClickListener(new c(bVar));
        Float rating = merchantPPReviewData.getRating();
        float floatValue = rating != null ? rating.floatValue() : 0.0f;
        if (Float.compare(floatValue, 0.0f) != 0) {
            RatingBar ratingBar = bVar.f71623e;
            if (ratingBar == null) {
                kotlin.g.b.k.a("ratingBarFilled");
            }
            ratingBar.setRating(floatValue);
            RatingBar ratingBar2 = bVar.f71623e;
            if (ratingBar2 == null) {
                kotlin.g.b.k.a("ratingBarFilled");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(ratingBar2);
            TextView textView5 = bVar.n;
            if (textView5 == null) {
                kotlin.g.b.k.a("rateYouExperience");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView5);
        } else {
            TextView textView6 = bVar.n;
            if (textView6 == null) {
                kotlin.g.b.k.a("rateYouExperience");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView6);
        }
        bVar.e();
        ReviewQuestion questions = merchantPPReviewData.getQuestions();
        if (questions != null) {
            if (questions.isMultichoice()) {
                bVar.a(questions);
            } else {
                Integer totalQuestionCount = merchantPPReviewData.getTotalQuestionCount();
                if (totalQuestionCount == null) {
                    kotlin.g.b.k.a();
                }
                int intValue = totalQuestionCount.intValue();
                Integer remainingQuestionCount = merchantPPReviewData.getRemainingQuestionCount();
                if (remainingQuestionCount == null) {
                    kotlin.g.b.k.a();
                }
                bVar.b(questions, intValue, remainingQuestionCount.intValue());
            }
            Integer totalQuestionCount2 = merchantPPReviewData.getTotalQuestionCount();
            if (totalQuestionCount2 == null) {
                kotlin.g.b.k.a();
            }
            int intValue2 = totalQuestionCount2.intValue();
            Integer remainingQuestionCount2 = merchantPPReviewData.getRemainingQuestionCount();
            if (remainingQuestionCount2 == null) {
                kotlin.g.b.k.a();
            }
            bVar.a(questions, intValue2, remainingQuestionCount2.intValue());
            return;
        }
        bVar.a();
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        if (z) {
            FrameLayout frameLayout = bVar.m;
            if (frameLayout == null) {
                kotlin.g.b.k.a("loadingContainer");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(frameLayout);
            LottieAnimationView lottieAnimationView = bVar.l;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("progressLoader");
            }
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
            return;
        }
        FrameLayout frameLayout2 = bVar.m;
        if (frameLayout2 == null) {
            kotlin.g.b.k.a("loadingContainer");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.b(frameLayout2);
        LottieAnimationView lottieAnimationView2 = bVar.l;
        if (lottieAnimationView2 == null) {
            kotlin.g.b.k.a("progressLoader");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView2);
    }

    public static final /* synthetic */ void a(b bVar, ReviewQuestionData reviewQuestionData) {
        RatingBar ratingBar = bVar.f71623e;
        if (ratingBar == null) {
            kotlin.g.b.k.a("ratingBarFilled");
        }
        net.one97.paytm.wallet.rateMerchant.utils.b.a(ratingBar);
        ReviewQuestion reviewQuestion = reviewQuestionData != null ? reviewQuestionData.getReviewQuestion() : null;
        if (reviewQuestion == null) {
            bVar.b();
            View view = bVar.f71627i;
            if (view == null) {
                kotlin.g.b.k.a("feedbackSuccessView");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(view);
            View view2 = bVar.f71620b;
            if (view2 == null) {
                kotlin.g.b.k.a("merchantInfoHeader");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(view2);
            View view3 = bVar.o;
            if (view3 == null) {
                kotlin.g.b.k.a("rateMerchantView");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(view3);
            View view4 = bVar.f71626h;
            if (view4 == null) {
                kotlin.g.b.k.a("parentMultiChoiceView");
            }
            net.one97.paytm.wallet.rateMerchant.utils.b.b(view4);
            bVar.c();
            return;
        }
        if (reviewQuestion.isMultichoice()) {
            bVar.a(reviewQuestion);
        } else {
            bVar.b(reviewQuestion, reviewQuestionData.getTotalQuestionCount(), reviewQuestionData.getRemainingQuestionCount());
        }
        bVar.a(reviewQuestion, reviewQuestionData.getTotalQuestionCount(), reviewQuestionData.getRemainingQuestionCount());
    }

    public static final /* synthetic */ void a(b bVar, int i2, int i3, String str) {
        bVar.t.clear();
        bVar.t.add(Integer.valueOf(i3));
        QnAModel qnAModel = new QnAModel(i2, kotlin.a.k.e(bVar.t));
        net.one97.paytm.wallet.rateMerchant.c.a aVar = bVar.s;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar.a("singlechoice_answer_submitted", (Object) qnAModel);
        bVar.a(i2, str, bVar.d() + 1);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
