package net.one97.paytm.upgradeKyc.editprofile.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.v;
import androidx.lifecycle.al;
import androidx.lifecycle.an;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.ImageUtility;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRProfilePic;
import net.one97.paytm.common.entity.CJRUserDefaultInfo;
import net.one97.paytm.common.entity.CJRUserInfo;
import net.one97.paytm.common.entity.CJRUserInfoV2;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.utils.croptool.CropImage;
import net.one97.paytm.landingpage.utils.croptool.CropImageView;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;

public final class c extends net.one97.paytm.i.h implements View.OnClickListener, a.e {

    /* renamed from: d  reason: collision with root package name */
    public static final C1313c f65926d = new C1313c((byte) 0);
    private static boolean y = true;

    /* renamed from: a  reason: collision with root package name */
    public final String f65927a = AppConstants.KEY_EMAIL;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.c.b f65928b;

    /* renamed from: c  reason: collision with root package name */
    boolean f65929c;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.g f65930e = v.a(this, y.b(net.one97.paytm.upgradeKyc.editprofile.gallery.j.class), new a(this), new b(this));
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.gallery.h f65931f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.editprofile.gallery.k f65932g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View f65933h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f65934i = new Handler();
    private boolean j;
    private net.one97.paytm.upgradeKyc.editprofile.e.d k;
    private Activity l;
    private String m;
    private final String n;
    /* access modifiers changed from: private */
    public CJRUserInfoV2 o;
    private LottieAnimationView p;
    private boolean q;
    private boolean r;
    private b s;
    private String t;
    private boolean u;
    private boolean v;
    private final d w;
    private final Runnable x;
    private HashMap z;

    public final View a(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final net.one97.paytm.upgradeKyc.editprofile.gallery.j e() {
        return (net.one97.paytm.upgradeKyc.editprofile.gallery.j) this.f65930e.getValue();
    }

    public static final class a extends kotlin.g.b.l implements kotlin.g.a.a<an> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final an invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            an viewModelStore = requireActivity.getViewModelStore();
            kotlin.g.b.k.a((Object) viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class b extends kotlin.g.b.l implements kotlin.g.a.a<al.b> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        public final al.b invoke() {
            FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            al.b defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            kotlin.g.b.k.a((Object) defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            FrameLayout frameLayout = (FrameLayout) this.this$0.a(R.id.galleryContainer);
            kotlin.g.b.k.a((Object) frameLayout, "galleryContainer");
            frameLayout.setVisibility(0);
            this.this$0.f65931f = new net.one97.paytm.upgradeKyc.editprofile.gallery.h();
            androidx.fragment.app.q a2 = this.this$0.getChildFragmentManager().a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
            a2.a(R.id.galleryContainer, (Fragment) c.a(this.this$0)).b();
        }
    }

    static final class g extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            this.this$0.f();
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            this.this$0.j();
        }
    }

    static final class i extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            this.this$0.j();
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            FrameLayout frameLayout = (FrameLayout) this.this$0.a(R.id.viewProfileContainer);
            kotlin.g.b.k.a((Object) frameLayout, "viewProfileContainer");
            frameLayout.setVisibility(0);
            this.this$0.f65932g = new net.one97.paytm.upgradeKyc.editprofile.gallery.k();
            androidx.fragment.app.q a2 = this.this$0.getChildFragmentManager().a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
            a2.a(R.id.viewProfileContainer, (Fragment) c.b(this.this$0)).b();
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            this.this$0.g();
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.b<Uri, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Uri) obj);
            return x.f47997a;
        }

        public final void invoke(Uri uri) {
            c cVar = this.this$0;
            kotlin.g.b.k.a((Object) uri, "it");
            cVar.a(uri);
        }
    }

    static final class m extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            FrameLayout frameLayout = (FrameLayout) this.this$0.a(R.id.galleryContainer);
            kotlin.g.b.k.a((Object) frameLayout, "galleryContainer");
            if (net.one97.paytm.upi.f.d(frameLayout) && this.this$0.f65931f != null) {
                FrameLayout frameLayout2 = (FrameLayout) this.this$0.a(R.id.galleryContainer);
                kotlin.g.b.k.a((Object) frameLayout2, "galleryContainer");
                frameLayout2.setVisibility(8);
                androidx.fragment.app.q a2 = this.this$0.getChildFragmentManager().a();
                kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
                a2.a((Fragment) c.a(this.this$0)).b();
            }
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            Context applicationContext;
            c cVar = this.this$0;
            FragmentActivity activity = cVar.getActivity();
            if (!(activity == null || (applicationContext = activity.getApplicationContext()) == null)) {
                ag.a aVar = ag.f69605a;
                ag.a.a(applicationContext).a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, "", true);
                androidx.localbroadcastmanager.a.a.a(applicationContext).a(new Intent(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
                com.paytm.utility.b.a((Context) cVar.getActivity(), Boolean.TRUE);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) cVar.a(R.id.edit_profile_user_iv);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.edit_profile_deafult_image);
            }
            ImageView imageView = (ImageView) cVar.a(R.id.edit_profile_tv);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            cVar.h();
            cVar.a((File) null);
        }
    }

    public c() {
        String name = c.class.getName();
        kotlin.g.b.k.a((Object) name, "KycProfileFragment::class.java.name");
        this.m = name;
        this.n = "+91 ";
        this.q = true;
        this.r = true;
        this.t = "";
        this.w = new d(this);
        this.x = new o(this);
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.editprofile.gallery.h a(c cVar) {
        net.one97.paytm.upgradeKyc.editprofile.gallery.h hVar = cVar.f65931f;
        if (hVar == null) {
            kotlin.g.b.k.a("galleryFragment");
        }
        return hVar;
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.editprofile.gallery.k b(c cVar) {
        net.one97.paytm.upgradeKyc.editprofile.gallery.k kVar = cVar.f65932g;
        if (kVar == null) {
            kotlin.g.b.k.a("viewProfileFragment");
        }
        return kVar;
    }

    public static final /* synthetic */ View g(c cVar) {
        View view = cVar.f65933h;
        if (view == null) {
            kotlin.g.b.k.a("snackBarView");
        }
        return view;
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.view.c$c  reason: collision with other inner class name */
    public static final class C1313c {
        private C1313c() {
        }

        public /* synthetic */ C1313c(byte b2) {
            this();
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        Activity activity = this.l;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        net.one97.paytm.utils.r.a(activity, (Exception) networkCustomError, AJRProfileActivity.class.getName(), (Bundle) null);
    }

    public final void a() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            if (!activity.isFinishing()) {
                Toast.makeText(getActivity(), getString(R.string.profile_saved_toast), 0).show();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.onBackPressed();
                }
            }
        }
    }

    public final void a(CJRUserInfo cJRUserInfo) {
        Context applicationContext;
        kotlin.g.b.k.c(cJRUserInfo, "userinfo");
        CJRUserInfoV2 a2 = net.one97.paytm.common.b.d.a().a(cJRUserInfo);
        net.one97.paytm.common.b.e a3 = net.one97.paytm.common.b.d.a();
        net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
        kotlin.g.b.k.a((Object) b2, "HomeHelper.getAppLaunchModuleInterface()");
        a3.a(a2, b2.a());
        net.one97.paytm.common.b.a b3 = net.one97.paytm.common.b.d.b();
        kotlin.g.b.k.a((Object) b3, "HomeHelper.getAppLaunchModuleInterface()");
        androidx.localbroadcastmanager.a.a.a(b3.a()).a(new Intent("ACTION_UPDATE_PROFILE"));
        FragmentActivity activity = getActivity();
        if (!(activity == null || (applicationContext = activity.getApplicationContext()) == null)) {
            androidx.localbroadcastmanager.a.a.a(applicationContext).a(new Intent(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
        }
        TextView textView = (TextView) a(R.id.save_name);
        if (textView != null) {
            textView.setText(getString(R.string.edit));
        }
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.display_name_et);
        kotlin.g.b.k.a((Object) textInputEditText, "display_name_et");
        textInputEditText.setEnabled(false);
        net.one97.paytm.common.b.e a4 = net.one97.paytm.common.b.d.a();
        FragmentActivity activity2 = getActivity();
        a4.E(activity2 != null ? activity2.getApplicationContext() : null);
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "title");
        kotlin.g.b.k.c(str2, "msg");
        com.paytm.utility.b.b(getContext(), str, str2);
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        this.l = (Activity) context;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.e eVar = this;
        a.C1308a aVar = net.one97.paytm.upgradeKyc.editprofile.d.a.f65816b;
        Activity activity = this.l;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        net.one97.paytm.upgradeKyc.editprofile.d.a a2 = a.C1308a.a(activity);
        if (a2 == null) {
            kotlin.g.b.k.a();
        }
        this.k = new net.one97.paytm.upgradeKyc.editprofile.e.d(eVar, a2);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_fragment_profile, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Editable text;
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.p = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.iv_back_button)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.edit_email)).setOnClickListener(onClickListener);
        ((TextInputEditText) a(R.id.display_mobile_et)).setOnClickListener(onClickListener);
        ((AppCompatEditText) a(R.id.display_email_et)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.edit_mob)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.edit_profile_tv)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.save_name)).setOnClickListener(onClickListener);
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.edit_profile_user_iv);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(onClickListener);
        }
        TextView textView = (TextView) a(R.id.retry_network);
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        ImageView imageView = (ImageView) a(R.id.name_info);
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
        ((ImageButton) a(R.id.nudge_close)).setOnClickListener(onClickListener);
        TextView textView2 = (TextView) a(R.id.edit_wallet_status);
        if (textView2 != null) {
            textView2.setOnClickListener(new q(this));
        }
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.display_name_et);
        if (!(textInputEditText == null || (text = textInputEditText.getText()) == null)) {
            kotlin.g.b.k.a((Object) text, "it");
            if (text.length() == 0) {
                TextInputEditText textInputEditText2 = (TextInputEditText) a(R.id.display_name_et);
                kotlin.g.b.k.a((Object) textInputEditText2, "display_name_et");
                textInputEditText2.setOnFocusChangeListener(new p(this));
                TextView textView3 = (TextView) a(R.id.save_name);
                kotlin.g.b.k.a((Object) textView3, "save_name");
                textView3.setText(getString(R.string.add));
            }
        }
        if (com.paytm.utility.b.c(getContext())) {
            y = false;
            l();
        } else {
            b(true);
        }
        Activity activity = this.l;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        activity.getWindow().setSoftInputMode(3);
        e().q.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new f(this)));
        e().s.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new g(this)));
        e().n.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new h(this)));
        e().w.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new i(this)));
        e().y.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new j(this)));
        e().A.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new k(this)));
        e().l.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new l(this)));
        e().u.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new m(this)));
        e().C.observe(getViewLifecycleOwner(), new net.one97.paytm.upgradeKyc.editprofile.gallery.e(new n(this)));
        TextInputEditText textInputEditText3 = (TextInputEditText) a(R.id.display_name_et);
        if (textInputEditText3 != null) {
            net.one97.paytm.utils.c.a.a(textInputEditText3, true);
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.display_email_et);
        if (appCompatEditText != null) {
            net.one97.paytm.utils.c.a.a(appCompatEditText, true);
        }
        TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.display_mobile_et);
        if (textInputEditText4 != null) {
            net.one97.paytm.utils.c.a.a(textInputEditText4, true);
        }
    }

    public final void f() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.galleryContainer);
        kotlin.g.b.k.a((Object) frameLayout, "galleryContainer");
        frameLayout.setVisibility(8);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
        net.one97.paytm.upgradeKyc.editprofile.gallery.h hVar = this.f65931f;
        if (hVar == null) {
            kotlin.g.b.k.a("galleryFragment");
        }
        a2.a((Fragment) hVar).b();
    }

    public final void g() {
        FrameLayout frameLayout = (FrameLayout) a(R.id.viewProfileContainer);
        kotlin.g.b.k.a((Object) frameLayout, "viewProfileContainer");
        frameLayout.setVisibility(8);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
        net.one97.paytm.upgradeKyc.editprofile.gallery.k kVar = this.f65932g;
        if (kVar == null) {
            kotlin.g.b.k.a("viewProfileFragment");
        }
        a2.a((Fragment) kVar).b();
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65938a;

        q(c cVar) {
            this.f65938a = cVar;
        }

        public final void onClick(View view) {
            c.d(this.f65938a);
        }
    }

    static final class p implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65937a;

        p(c cVar) {
            this.f65937a = cVar;
        }

        public final void onFocusChange(View view, boolean z) {
            TextInputEditText textInputEditText = (TextInputEditText) this.f65937a.a(R.id.display_name_et);
            CharSequence text = textInputEditText != null ? textInputEditText.getText() : null;
            if (text == null || text.length() == 0) {
                return;
            }
            if (z) {
                TextView textView = (TextView) this.f65937a.a(R.id.save_name);
                if (textView != null) {
                    textView.setText(this.f65937a.getString(R.string.save));
                }
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f65937a.a(R.id.display_name_et);
                if (textInputEditText2 != null) {
                    textInputEditText2.setSelection(((TextInputEditText) this.f65937a.a(R.id.display_name_et)).length());
                    return;
                }
                return;
            }
            TextView textView2 = (TextView) this.f65937a.a(R.id.save_name);
            if (textView2 != null) {
                textView2.setText(this.f65937a.getString(R.string.edit));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = r0.getUserDefaultInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k() {
        /*
            r3 = this;
            net.one97.paytm.common.entity.CJRUserInfoV2 r0 = r3.o
            if (r0 == 0) goto L_0x0050
            r1 = 0
            if (r0 == 0) goto L_0x0012
            net.one97.paytm.common.entity.CJRUserDefaultInfo r0 = r0.getUserDefaultInfo()
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getDisplayName()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0050
            int r0 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r0 = r3.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            net.one97.paytm.common.entity.CJRUserInfoV2 r2 = r3.o
            if (r2 == 0) goto L_0x0031
            net.one97.paytm.common.entity.CJRUserDefaultInfo r2 = r2.getUserDefaultInfo()
            if (r2 == 0) goto L_0x0031
            java.lang.String r1 = r2.getDisplayName()
        L_0x0031:
            java.lang.String r1 = com.paytm.utility.b.A((java.lang.String) r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r0 = r3.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x006d
            int r1 = net.one97.paytm.landingpage.R.string.edit
            java.lang.String r1 = r3.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x006d
        L_0x0050:
            int r0 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r0 = r3.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            java.lang.String r1 = ""
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r0 = r3.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            if (r0 == 0) goto L_0x006d
            r1 = 1
            r0.setEnabled(r1)
        L_0x006d:
            int r0 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r0 = r3.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            net.one97.paytm.upgradeKyc.editprofile.view.c$d r1 = r3.w
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r0.addTextChangedListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.k():void");
    }

    public final void a(CJRAadharPanGet cJRAadharPanGet) {
        kotlin.g.b.k.c(cJRAadharPanGet, Payload.RESPONSE);
        if (TextUtils.isEmpty(cJRAadharPanGet.getName())) {
            k();
            return;
        }
        TextInputEditText textInputEditText = (TextInputEditText) a(R.id.display_name_et);
        if (textInputEditText != null) {
            textInputEditText.setText(com.paytm.utility.b.A(cJRAadharPanGet.getName()));
        }
    }

    public final void b() {
        View a2 = a(R.id.blockingView);
        if (a2 != null) {
            a2.setVisibility(0);
        }
        net.one97.paytm.common.widgets.a.a(this.p);
    }

    public final void c() {
        View a2 = a(R.id.blockingView);
        if (a2 != null) {
            a2.setVisibility(8);
        }
        net.one97.paytm.common.widgets.a.b(this.p);
    }

    /* JADX WARNING: type inference failed for: r5v9, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v17, types: [net.one97.paytm.common.entity.CJRUserDefaultInfo] */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x043c, code lost:
        if (r2 != r7.getId()) goto L_0x043e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0466, code lost:
        if (r5.booleanValue() != false) goto L_0x0468;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0468, code lost:
        net.one97.paytm.common.b.d.a().d(getFragmentManager());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = net.one97.paytm.landingpage.R.id.iv_back_button
            android.view.View r2 = r0.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0053
            net.one97.paytm.common.b.e r5 = net.one97.paytm.common.b.d.a()
            android.content.Context r6 = r17.getContext()
            java.lang.String r7 = "personal_details"
            java.lang.String r8 = "profile_back_clicked"
            java.lang.String r9 = ""
            java.lang.String r10 = "/profile_settings"
            java.lang.String r11 = ""
            r5.a(r6, r7, r8, r9, r10, r11)
            boolean r1 = r0.j
            if (r1 == 0) goto L_0x0049
            android.content.Context r1 = r17.getContext()
            if (r1 == 0) goto L_0x0049
            java.lang.String r2 = "input_method"
            java.lang.Object r1 = r1.getSystemService(r2)
            if (r1 == 0) goto L_0x0041
            android.view.inputmethod.InputMethodManager r1 = (android.view.inputmethod.InputMethodManager) r1
            r1.toggleSoftInput(r4, r3)
            goto L_0x0049
        L_0x0041:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            r1.<init>(r2)
            throw r1
        L_0x0049:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            if (r1 == 0) goto L_0x0052
            r1.onBackPressed()
        L_0x0052:
            return
        L_0x0053:
            int r2 = net.one97.paytm.landingpage.R.id.edit_mob
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            r5 = 0
            if (r2 == 0) goto L_0x0123
            android.content.Context r2 = r17.getContext()
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            if (r2 == 0) goto L_0x00f1
            boolean r2 = r0.r
            if (r2 == 0) goto L_0x007d
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            androidx.fragment.app.j r3 = r17.getFragmentManager()
            r2.c((androidx.fragment.app.j) r3)
            goto L_0x00f4
        L_0x007d:
            net.one97.paytm.common.entity.CJRUserInfoV2 r2 = r0.o
            if (r2 == 0) goto L_0x0085
            net.one97.paytm.common.entity.CJRUserDefaultInfo r5 = r2.getUserDefaultInfo()
        L_0x0085:
            if (r5 == 0) goto L_0x00f4
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            androidx.fragment.app.FragmentActivity r3 = r17.getActivity()
            android.content.Context r3 = (android.content.Context) r3
            android.content.Intent r2 = r2.a((android.content.Context) r3)
            int r3 = net.one97.paytm.landingpage.R.id.display_mobile_et
            android.view.View r3 = r0.a((int) r3)
            com.google.android.material.textfield.TextInputEditText r3 = (com.google.android.material.textfield.TextInputEditText) r3
            java.lang.String r4 = "display_mobile_et"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "mobileNumber"
            r2.putExtra(r5, r3)
            net.one97.paytm.common.entity.CJRUserInfoV2 r3 = r0.o
            java.io.Serializable r3 = (java.io.Serializable) r3
            java.lang.String r5 = "extra_home_data"
            r2.putExtra(r5, r3)
            java.lang.String r3 = "mobile"
            java.lang.String r5 = "mobile_email"
            r2.putExtra(r5, r3)
            boolean r5 = r0.r
            java.lang.String r6 = "verify_mobile_email"
            if (r5 != 0) goto L_0x00cf
            android.content.Intent r3 = r2.putExtra(r6, r3)
            java.lang.String r4 = "intent.putExtra(CJRConst…Y_MOBILE_EMAIL, \"mobile\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            goto L_0x00eb
        L_0x00cf:
            int r3 = net.one97.paytm.landingpage.R.id.display_mobile_et
            android.view.View r3 = r0.a((int) r3)
            com.google.android.material.textfield.TextInputEditText r3 = (com.google.android.material.textfield.TextInputEditText) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.text.Editable r3 = r3.getText()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x00eb
            java.lang.String r3 = "mobileadd"
            r2.putExtra(r6, r3)
        L_0x00eb:
            r3 = 211(0xd3, float:2.96E-43)
            r0.startActivityForResult(r2, r3)
            goto L_0x00f4
        L_0x00f1:
            r17.m()
        L_0x00f4:
            if (r1 == 0) goto L_0x0122
            int r1 = r18.getId()
            int r2 = net.one97.paytm.landingpage.R.id.edit_mob
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "edit_mob"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r2 = r2.getId()
            if (r1 != r2) goto L_0x04da
            net.one97.paytm.common.b.e r3 = net.one97.paytm.common.b.d.a()
            android.content.Context r4 = r17.getContext()
            java.lang.String r5 = "personal_details"
            java.lang.String r6 = "update_mobile_no_clicked"
            java.lang.String r7 = ""
            java.lang.String r8 = "/profile_settings"
            java.lang.String r9 = ""
            r3.a(r4, r5, r6, r7, r8, r9)
        L_0x0122:
            return
        L_0x0123:
            int r2 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r2 = r0.a((int) r2)
            androidx.appcompat.widget.AppCompatEditText r2 = (androidx.appcompat.widget.AppCompatEditText) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x041b
            int r2 = net.one97.paytm.landingpage.R.id.edit_email
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0141
            goto L_0x041b
        L_0x0141:
            int r2 = net.one97.paytm.landingpage.R.id.edit_profile_user_iv
            android.view.View r2 = r0.a((int) r2)
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x03dc
            int r2 = net.one97.paytm.landingpage.R.id.edit_profile_tv
            android.view.View r2 = r0.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x015f
            goto L_0x03dc
        L_0x015f:
            int r2 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x031d
            int r1 = net.one97.paytm.landingpage.R.string.add
            java.lang.String r1 = r0.getString(r1)
            int r2 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0182
            java.lang.CharSequence r2 = r2.getText()
            goto L_0x0183
        L_0x0182:
            r2 = r5
        L_0x0183:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x019a
            int r1 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r1 = r0.a((int) r1)
            com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
            if (r1 == 0) goto L_0x0196
            r1.requestFocus()
        L_0x0196:
            r17.r()
            return
        L_0x019a:
            int r1 = net.one97.paytm.landingpage.R.string.edit
            java.lang.String r1 = r0.getString(r1)
            int r2 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x01af
            java.lang.CharSequence r2 = r2.getText()
            goto L_0x01b0
        L_0x01af:
            r2 = r5
        L_0x01b0:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01eb
            r0.j = r4
            int r1 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r1 = r0.a((int) r1)
            com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
            if (r1 == 0) goto L_0x01c5
            r1.setEnabled(r4)
        L_0x01c5:
            int r1 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r1 = r0.a((int) r1)
            com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
            if (r1 == 0) goto L_0x01d2
            r1.requestFocus()
        L_0x01d2:
            r17.r()
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            android.content.Context r3 = r17.getContext()
            java.lang.String r4 = "personal_details"
            java.lang.String r5 = "edit_display_name"
            java.lang.String r6 = "edit_clicked"
            java.lang.String r7 = "/profile_settings"
            java.lang.String r8 = ""
            r2.a(r3, r4, r5, r6, r7, r8)
            return
        L_0x01eb:
            android.content.Context r1 = r17.getContext()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x0319
            boolean r1 = r0.f65929c
            if (r1 == 0) goto L_0x030c
            int r1 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r1 = r0.a((int) r1)
            com.google.android.material.textfield.TextInputEditText r1 = (com.google.android.material.textfield.TextInputEditText) r1
            java.lang.String r2 = "display_name_et"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.text.Editable r1 = r1.getText()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x022b
            int r1 = net.one97.paytm.landingpage.R.id.fragment_profile_display_name_layout
            android.view.View r1 = r0.a((int) r1)
            com.google.android.material.textfield.TextInputLayout r1 = (com.google.android.material.textfield.TextInputLayout) r1
            java.lang.String r4 = "fragment_profile_display_name_layout"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            int r4 = net.one97.paytm.landingpage.R.string.disp_name_empty_message
            java.lang.String r4 = r0.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setError(r4)
            goto L_0x022c
        L_0x022b:
            r3 = 1
        L_0x022c:
            if (r3 == 0) goto L_0x031c
            net.one97.paytm.common.entity.CJRUserInfoV2 r1 = r0.o
            if (r1 == 0) goto L_0x024e
            net.one97.paytm.common.entity.CJRUserDefaultInfo r3 = r1.getUserDefaultInfo()
            if (r3 == 0) goto L_0x024e
            int r4 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r4 = r0.a((int) r4)
            com.google.android.material.textfield.TextInputEditText r4 = (com.google.android.material.textfield.TextInputEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            android.text.Editable r2 = r4.getText()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.setDisplayName(r2)
        L_0x024e:
            if (r1 == 0) goto L_0x031c
            net.one97.paytm.common.b.e r6 = net.one97.paytm.common.b.d.a()
            android.content.Context r7 = r17.getContext()
            java.lang.String r8 = "personal_details"
            java.lang.String r9 = "save_display_name"
            java.lang.String r10 = ""
            java.lang.String r11 = "/profile_settings"
            java.lang.String r12 = ""
            r6.a(r7, r8, r9, r10, r11, r12)
            net.one97.paytm.upgradeKyc.editprofile.e.d r2 = r0.k
            if (r2 == 0) goto L_0x02ed
            java.lang.String r3 = "userinfo"
            kotlin.g.b.k.c(r1, r3)
            net.one97.paytm.upgradeKyc.editprofile.b.a$e r3 = r2.f65832a
            r3.b()
            net.one97.paytm.upgradeKyc.editprofile.d.a r3 = r2.f65833b
            if (r3 == 0) goto L_0x02ed
            net.one97.paytm.upgradeKyc.editprofile.b.a$d r2 = (net.one97.paytm.upgradeKyc.editprofile.b.a.d) r2
            java.lang.String r4 = "callback"
            kotlin.g.b.k.c(r2, r4)
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r6 = "id"
            if (r1 == 0) goto L_0x028c
            java.lang.String r7 = r1.getUserId()     // Catch:{ JSONException -> 0x02a2 }
            goto L_0x028d
        L_0x028c:
            r7 = r5
        L_0x028d:
            r4.put(r6, r7)     // Catch:{ JSONException -> 0x02a2 }
            java.lang.String r6 = "displayName"
            if (r1 == 0) goto L_0x029e
            net.one97.paytm.common.entity.CJRUserDefaultInfo r7 = r1.getUserDefaultInfo()     // Catch:{ JSONException -> 0x02a2 }
            if (r7 == 0) goto L_0x029e
            java.lang.String r5 = r7.getDisplayName()     // Catch:{ JSONException -> 0x02a2 }
        L_0x029e:
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x02a2 }
            goto L_0x02a3
        L_0x02a2:
        L_0x02a3:
            net.one97.paytm.common.b.a r5 = net.one97.paytm.common.b.d.b()
            java.lang.String r6 = "userInfoUpdation"
            java.lang.String r8 = r5.a((java.lang.String) r6)
            net.one97.paytm.common.b.e r5 = net.one97.paytm.common.b.d.a()
            android.content.Context r6 = r3.f65818a
            java.util.Map r10 = r5.q(r6)
            android.content.Context r7 = r3.f65818a
            net.one97.paytm.upgradeKyc.editprofile.d.a$f r5 = new net.one97.paytm.upgradeKyc.editprofile.d.a$f
            r5.<init>(r2)
            r9 = r5
            com.paytm.network.listener.b r9 = (com.paytm.network.listener.b) r9
            r11 = 0
            com.paytm.network.a$a r12 = com.paytm.network.a.C0715a.PUT
            java.lang.String r13 = r4.toString()
            net.one97.paytm.common.entity.CJRUserInfo r4 = new net.one97.paytm.common.entity.CJRUserInfo
            r4.<init>()
            r14 = r4
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            com.paytm.network.a$c r15 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r16 = com.paytm.network.a.b.SILENT
            com.paytm.network.a r4 = net.one97.paytm.common.b.d.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            android.content.Context r3 = r3.f65818a
            boolean r3 = com.paytm.utility.a.m(r3)
            if (r3 == 0) goto L_0x02ea
            if (r4 == 0) goto L_0x02e6
            r4.a()
            goto L_0x02ed
        L_0x02e6:
            com.paytm.utility.a.c()
            goto L_0x02ed
        L_0x02ea:
            r2.a()
        L_0x02ed:
            int r2 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r2 = r0.a((int) r2)
            com.google.android.material.textfield.TextInputEditText r2 = (com.google.android.material.textfield.TextInputEditText) r2
            net.one97.paytm.common.entity.CJRUserDefaultInfo r1 = r1.getUserDefaultInfo()
            java.lang.String r3 = "newUserInfo.userDefaultInfo"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r1 = r1.getDisplayName()
            java.lang.String r1 = com.paytm.utility.b.A((java.lang.String) r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            return
        L_0x030c:
            d.a.a.c r1 = d.a.a.c.a()
            net.one97.paytm.upgradeKyc.editprofile.c.a r2 = new net.one97.paytm.upgradeKyc.editprofile.c.a
            r2.<init>()
            r1.c(r2)
            return
        L_0x0319:
            r17.m()
        L_0x031c:
            return
        L_0x031d:
            int r2 = net.one97.paytm.landingpage.R.id.retry_network
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0340
            android.content.Context r1 = r17.getContext()
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x033c
            r0.b((boolean) r3)
            r17.l()
            return
        L_0x033c:
            r0.b((boolean) r4)
            return
        L_0x0340:
            int r2 = net.one97.paytm.landingpage.R.id.name_info
            android.view.View r2 = r0.a((int) r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            r4 = 8
            if (r2 == 0) goto L_0x03aa
            int r1 = net.one97.paytm.landingpage.R.id.nameVerifiedText
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "nameVerifiedText"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r1 = r1.getVisibility()
            if (r1 != r4) goto L_0x039c
            net.one97.paytm.common.b.e r6 = net.one97.paytm.common.b.d.a()
            android.content.Context r7 = r17.getContext()
            java.lang.String r8 = "personal_details"
            java.lang.String r9 = "kyc_name_info_button_clicked"
            java.lang.String r10 = ""
            java.lang.String r11 = "/profile_settings"
            java.lang.String r12 = ""
            r6.a(r7, r8, r9, r10, r11, r12)
            int r1 = net.one97.paytm.landingpage.R.id.nameVerifiedText
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0385
            r1.setVisibility(r3)
        L_0x0385:
            androidx.lifecycle.m r1 = androidx.lifecycle.s.a(r17)
            r6 = r1
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            r7 = 0
            r8 = 0
            net.one97.paytm.upgradeKyc.editprofile.view.c$e r1 = new net.one97.paytm.upgradeKyc.editprofile.view.c$e
            r1.<init>(r0, r5)
            r9 = r1
            kotlin.g.a.m r9 = (kotlin.g.a.m) r9
            r10 = 3
            r11 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            return
        L_0x039c:
            int r1 = net.one97.paytm.landingpage.R.id.nameVerifiedText
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x03a9
            r1.setVisibility(r4)
        L_0x03a9:
            return
        L_0x03aa:
            int r2 = net.one97.paytm.landingpage.R.id.nudge_close
            android.view.View r2 = r0.a((int) r2)
            android.widget.ImageButton r2 = (android.widget.ImageButton) r2
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x04da
            int r1 = net.one97.paytm.landingpage.R.id.addProfileImageNudge
            android.view.View r1 = r0.a((int) r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            if (r1 == 0) goto L_0x03c5
            r1.setVisibility(r4)
        L_0x03c5:
            net.one97.paytm.common.b.e r5 = net.one97.paytm.common.b.d.a()
            android.content.Context r6 = r17.getContext()
            java.lang.String r7 = "personal_details"
            java.lang.String r8 = "profile_image_nudge_cancelled"
            java.lang.String r9 = ""
            java.lang.String r10 = "/profile_settings"
            java.lang.String r11 = ""
            r5.a(r6, r7, r8, r9, r10, r11)
            goto L_0x04da
        L_0x03dc:
            android.content.Context r1 = r17.getContext()
            java.lang.String r1 = com.paytm.utility.b.al(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0402
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            android.content.Context r3 = r17.getContext()
            java.lang.String r4 = "personal_details"
            java.lang.String r5 = "edit_profile_image"
            java.lang.String r6 = "personal_details"
            java.lang.String r7 = "/profile_settings"
            java.lang.String r8 = ""
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L_0x0417
        L_0x0402:
            net.one97.paytm.common.b.e r9 = net.one97.paytm.common.b.d.a()
            android.content.Context r10 = r17.getContext()
            java.lang.String r11 = "personal_details"
            java.lang.String r12 = "add_profile_image"
            java.lang.String r13 = "personal_details"
            java.lang.String r14 = "/profile_settings"
            java.lang.String r15 = ""
            r9.a(r10, r11, r12, r13, r14, r15)
        L_0x0417:
            r17.i()
            return
        L_0x041b:
            android.content.Context r2 = r17.getContext()
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r2)
            java.lang.String r6 = "edit_email"
            if (r2 == 0) goto L_0x0474
            if (r1 == 0) goto L_0x043e
            int r2 = r18.getId()
            int r7 = net.one97.paytm.landingpage.R.id.edit_email
            android.view.View r7 = r0.a((int) r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            int r7 = r7.getId()
            if (r2 == r7) goto L_0x0468
        L_0x043e:
            int r2 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r2 = r0.a((int) r2)
            androidx.appcompat.widget.AppCompatEditText r2 = (androidx.appcompat.widget.AppCompatEditText) r2
            if (r2 == 0) goto L_0x045d
            android.text.Editable r2 = r2.getText()
            if (r2 == 0) goto L_0x045d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0458
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0459
        L_0x0458:
            r3 = 1
        L_0x0459:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
        L_0x045d:
            if (r5 != 0) goto L_0x0462
            kotlin.g.b.k.a()
        L_0x0462:
            boolean r2 = r5.booleanValue()
            if (r2 == 0) goto L_0x0477
        L_0x0468:
            net.one97.paytm.common.b.e r2 = net.one97.paytm.common.b.d.a()
            androidx.fragment.app.j r3 = r17.getFragmentManager()
            r2.d((androidx.fragment.app.j) r3)
            goto L_0x0477
        L_0x0474:
            r17.m()
        L_0x0477:
            if (r1 == 0) goto L_0x04c0
            int r2 = r18.getId()
            int r3 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r3 = r0.a((int) r3)
            androidx.appcompat.widget.AppCompatEditText r3 = (androidx.appcompat.widget.AppCompatEditText) r3
            java.lang.String r4 = "display_email_et"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r3 = r3.getId()
            if (r2 != r3) goto L_0x04c0
            int r2 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r2 = r0.a((int) r2)
            androidx.appcompat.widget.AppCompatEditText r2 = (androidx.appcompat.widget.AppCompatEditText) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.text.Editable r2 = r2.getText()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x04bd
            net.one97.paytm.common.b.e r7 = net.one97.paytm.common.b.d.a()
            android.content.Context r8 = r17.getContext()
            java.lang.String r9 = "personal_details"
            java.lang.String r10 = "click_email_id_box"
            java.lang.String r11 = ""
            java.lang.String r12 = "/profile_settings"
            java.lang.String r13 = ""
            r7.a(r8, r9, r10, r11, r12, r13)
            goto L_0x04c0
        L_0x04bd:
            r17.q()
        L_0x04c0:
            if (r1 == 0) goto L_0x04da
            int r1 = r18.getId()
            int r2 = net.one97.paytm.landingpage.R.id.edit_email
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            int r2 = r2.getId()
            if (r1 != r2) goto L_0x04da
            r17.q()
        L_0x04da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.onClick(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.addProfileImageNudge);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        net.one97.paytm.common.b.d.a().a(getContext(), "personal_details", "profile_image_nudge_shown", "", "/profile_settings", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        if ((r0.subSequence(r3, r4 + 1).toString().length() == 0) != false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r8 = this;
            boolean r0 = com.paytm.utility.s.a()
            if (r0 == 0) goto L_0x001c
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = com.paytm.utility.s.c((android.app.Activity) r0)
            if (r0 != 0) goto L_0x001c
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            com.paytm.utility.s.b((android.app.Activity) r0)
            return
        L_0x001c:
            androidx.fragment.app.FragmentActivity r0 = r8.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.paytm.utility.b.al(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x006a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r3 = r0.length()
            int r3 = r3 - r2
            r4 = r3
            r3 = 0
            r5 = 0
        L_0x0034:
            if (r3 > r4) goto L_0x0054
            if (r5 != 0) goto L_0x003a
            r6 = r3
            goto L_0x003b
        L_0x003a:
            r6 = r4
        L_0x003b:
            char r6 = r0.charAt(r6)
            r7 = 32
            if (r6 > r7) goto L_0x0045
            r6 = 1
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            if (r5 != 0) goto L_0x004f
            if (r6 != 0) goto L_0x004c
            r5 = 1
            goto L_0x0034
        L_0x004c:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x004f:
            if (r6 == 0) goto L_0x0054
            int r4 = r4 + -1
            goto L_0x0034
        L_0x0054:
            int r4 = r4 + r2
            java.lang.CharSequence r0 = r0.subSequence(r3, r4)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0067
            r0 = 1
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            if (r0 == 0) goto L_0x006b
        L_0x006a:
            r1 = 1
        L_0x006b:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r2 = "isProfileEmpty"
            r0.putBoolean(r2, r1)
            net.one97.paytm.upgradeKyc.editprofile.gallery.f r1 = new net.one97.paytm.upgradeKyc.editprofile.gallery.f
            r1.<init>()
            r1.setArguments(r0)
            androidx.fragment.app.j r0 = r8.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            java.lang.Class<net.one97.paytm.upgradeKyc.editprofile.gallery.f> r2 = net.one97.paytm.upgradeKyc.editprofile.gallery.f.class
            java.lang.String r2 = r2.getName()
            r1.show((androidx.fragment.app.q) r0, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.i():void");
    }

    public final void a(NetworkCustomError networkCustomError) {
        Class<c> cls = c.class;
        kotlin.g.b.k.c(networkCustomError, "error");
        c();
        net.one97.paytm.prime.f.a aVar = new net.one97.paytm.prime.f.a();
        aVar.setAlertMessage(networkCustomError.getAlertMessage());
        aVar.setmAlertTitle(networkCustomError.getAlertTitle());
        aVar.setmErrorCode(networkCustomError.getErrorType().toString());
        aVar.setUniqueReference(networkCustomError.getUniqueReference());
        aVar.setUrl(networkCustomError.getFullUrl());
        if (aVar.getMessage() != null) {
            com.paytm.utility.q.b(aVar.getMessage());
        }
        if (aVar.getMessage() != null) {
            com.paytm.utility.q.b(aVar.getMessage());
        }
        if (networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403 || networkCustomError.getStatusCode() == 401) {
            net.one97.paytm.utils.r.a(getActivity(), cls.getName(), (Bundle) null, false, true);
        }
        if (!TextUtils.isEmpty(aVar.getMessage()) && (kotlin.m.p.a(aVar.getMessage(), "410", true) || kotlin.m.p.a(aVar.getMessage(), UpiUtils.AUTHENTICATION_FAILURE_401, true))) {
            Activity activity = this.l;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            net.one97.paytm.utils.r.a(activity, (Exception) aVar, cls.getName(), (Bundle) null);
        } else if (networkCustomError.getMessage() != null && !net.one97.paytm.utils.r.a(getContext(), (Exception) networkCustomError)) {
            if (networkCustomError.getMessage() == null || !kotlin.m.p.a(networkCustomError.getMessage(), "parsing_error", true)) {
                String string = getResources().getString(R.string.network_error_message);
                kotlin.g.b.k.a((Object) string, "resources.getString(R.st…ng.network_error_message)");
                Activity activity2 = this.l;
                if (activity2 == null) {
                    kotlin.g.b.k.a("mActivity");
                }
                com.paytm.utility.b.b((Context) activity2, getResources().getString(R.string.network_error_heading), string);
                return;
            }
            Activity activity3 = this.l;
            if (activity3 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            com.paytm.utility.b.d((Context) activity3, networkCustomError.getUrl(), aVar.getmErrorCode());
        }
    }

    public final void d() {
        com.paytm.utility.b.b(getContext(), getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0299, code lost:
        if (r14.equals("PAYTM_MIN_KYC_EXPIRED") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02a2, code lost:
        if (r14.equals("PAYTM_MIN_KYC") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a9, code lost:
        if (r14.equals("PAYTM_BASIC_WALLET") != false) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02b0, code lost:
        if (r14.equals("PAYTM_PRIME_WALLET") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02b7, code lost:
        if (r14.equals("PAYTM_NON_WALLET") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02be, code lost:
        if (r14.equals("PAYTM_AHDAR_OTP_KYC_EXPIRED") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02c5, code lost:
        if (r14.equals("PAYTM_MIN_KYC_LOCKED") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02cc, code lost:
        if (r14.equals("PAYTM_PRIMITIVE") != false) goto L_0x02ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02ce, code lost:
        k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02d6, code lost:
        if (r14.equals("PAYTM_ADHAR_OTP_KYC") != false) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02d8, code lost:
        r14 = r13.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02da, code lost:
        if (r14 == null) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02dc, code lost:
        r5 = r14.f65833b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02de, code lost:
        if (r5 == null) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02e0, code lost:
        r5.a((net.one97.paytm.upgradeKyc.editprofile.b.a.d) r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02e6, code lost:
        k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02e9, code lost:
        r14 = r13.t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02ef, code lost:
        switch(r14.hashCode()) {
            case -2007004454: goto L_0x04a0;
            case -2004957431: goto L_0x0495;
            case -1686223585: goto L_0x048a;
            case -1330922216: goto L_0x0483;
            case -1201059895: goto L_0x047c;
            case -698611625: goto L_0x03dd;
            case -243305528: goto L_0x03d5;
            case -132749366: goto L_0x02fe;
            case 1913706384: goto L_0x02f4;
            default: goto L_0x02f2;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02fa, code lost:
        if (r14.equals("PAYTM_MIN_KYC_EXPIRED") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0304, code lost:
        if (r14.equals("PAYTM_MIN_KYC") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0306, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x030e, code lost:
        if (r14 == null) goto L_0x0329;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0310, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0314, code lost:
        if (r0 == null) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0316, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x031a, code lost:
        if (r0 == null) goto L_0x0323;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x031c, code lost:
        r0 = r0.getString(net.one97.paytm.landingpage.R.string.active);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0323, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0324, code lost:
        r14.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0329, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0331, code lost:
        if (r14 == null) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0333, code lost:
        r14.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0336, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x033e, code lost:
        if (r14 == null) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0340, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0344, code lost:
        if (r0 == null) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0346, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x034a, code lost:
        if (r0 == null) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x034c, code lost:
        r0 = r0.getString(net.one97.paytm.landingpage.R.string.rs);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0353, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0354, code lost:
        r3 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0358, code lost:
        if (r3 == null) goto L_0x0367;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x035a, code lost:
        r3 = r3.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x035e, code lost:
        if (r3 == null) goto L_0x0367;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0360, code lost:
        r3 = r3.getString(net.one97.paytm.landingpage.R.string.active_ten_thousand_per_month);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0367, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0368, code lost:
        r14.setText(kotlin.g.b.k.a(r0, (java.lang.Object) r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0371, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.save_name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0379, code lost:
        if (r14 == null) goto L_0x037e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x037b, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x037e, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0386, code lost:
        if (r14 == null) goto L_0x038b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0388, code lost:
        r14.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x038b, code lost:
        r14 = (com.google.android.material.textfield.TextInputEditText) a(net.one97.paytm.landingpage.R.id.display_name_et);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0393, code lost:
        if (r14 == null) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0395, code lost:
        r14.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0398, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.kycVerifiedView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03a0, code lost:
        if (r14 == null) goto L_0x03a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a2, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03a5, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.edit_wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03ad, code lost:
        if (r14 == null) goto L_0x03c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03af, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03b3, code lost:
        if (r0 == null) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b5, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b9, code lost:
        if (r0 == null) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03bb, code lost:
        r2 = r0.getString(net.one97.paytm.landingpage.R.string.upgrade_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c1, code lost:
        r14.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03c6, code lost:
        r14 = (android.widget.ImageView) a(net.one97.paytm.landingpage.R.id.name_info);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ce, code lost:
        if (r14 == null) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03d0, code lost:
        r14.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03d9, code lost:
        if (r14.equals("PAYTM_BASIC_WALLET") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03e1, code lost:
        if (r14.equals("PAYTM_PRIME_WALLET") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03e3, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03eb, code lost:
        if (r14 == null) goto L_0x0406;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03ed, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03f1, code lost:
        if (r0 == null) goto L_0x0400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03f3, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03f7, code lost:
        if (r0 == null) goto L_0x0400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03f9, code lost:
        r0 = r0.getString(net.one97.paytm.landingpage.R.string.active);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0400, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0401, code lost:
        r14.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0406, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x040e, code lost:
        if (r14 == null) goto L_0x0413;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0410, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0413, code lost:
        a(net.one97.paytm.landingpage.R.drawable.ic_kyc_verified, true);
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0420, code lost:
        if (r14 == null) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0422, code lost:
        r14.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0425, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.kycVerifiedView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x042d, code lost:
        if (r14 == null) goto L_0x0432;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x042f, code lost:
        r14.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0432, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.save_name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x043a, code lost:
        if (r14 == null) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x043c, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x043f, code lost:
        r14 = (com.google.android.material.textfield.TextInputEditText) a(net.one97.paytm.landingpage.R.id.display_name_et);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0447, code lost:
        if (r14 == null) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0449, code lost:
        r14.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x044c, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.edit_wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0454, code lost:
        if (r14 == null) goto L_0x046d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0456, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x045a, code lost:
        if (r0 == null) goto L_0x0468;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x045c, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0460, code lost:
        if (r0 == null) goto L_0x0468;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0462, code lost:
        r2 = r0.getString(net.one97.paytm.landingpage.R.string.view_benefits);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0468, code lost:
        r14.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x046d, code lost:
        r14 = (android.widget.ImageView) a(net.one97.paytm.landingpage.R.id.name_info);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0475, code lost:
        if (r14 == null) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0477, code lost:
        r14.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0480, code lost:
        if (r14.equals("PAYTM_NON_WALLET") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0487, code lost:
        if (r14.equals("PAYTM_AHDAR_OTP_KYC_EXPIRED") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x048e, code lost:
        if (r14.equals("PAYTM_MIN_KYC_LOCKED") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0490, code lost:
        a(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0499, code lost:
        if (r14.equals("PAYTM_PRIMITIVE") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x049b, code lost:
        a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04a4, code lost:
        if (r14.equals("PAYTM_ADHAR_OTP_KYC") == false) goto L_0x0539;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04a6, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04ae, code lost:
        if (r14 == null) goto L_0x04c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x04b0, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04b4, code lost:
        if (r0 == null) goto L_0x04c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04b6, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04ba, code lost:
        if (r0 == null) goto L_0x04c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x04bc, code lost:
        r0 = r0.getString(net.one97.paytm.landingpage.R.string.active);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x04c3, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x04c4, code lost:
        r14.setText(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x04c9, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x04d1, code lost:
        if (r14 == null) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x04d3, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04d6, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x04de, code lost:
        if (r14 == null) goto L_0x04e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x04e0, code lost:
        r14.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x04e3, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.save_name);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x04eb, code lost:
        if (r14 == null) goto L_0x04f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x04ed, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x04f0, code lost:
        r14 = (com.google.android.material.textfield.TextInputEditText) a(net.one97.paytm.landingpage.R.id.display_name_et);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x04f8, code lost:
        if (r14 == null) goto L_0x04fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x04fa, code lost:
        r14.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x04fd, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.kycVerifiedView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0505, code lost:
        if (r14 == null) goto L_0x050a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0507, code lost:
        r14.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x050a, code lost:
        r14 = (android.widget.TextView) a(net.one97.paytm.landingpage.R.id.edit_wallet_status);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0512, code lost:
        if (r14 == null) goto L_0x052b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0514, code lost:
        r0 = getContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0518, code lost:
        if (r0 == null) goto L_0x0526;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x051a, code lost:
        r0 = r0.getResources();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x051e, code lost:
        if (r0 == null) goto L_0x0526;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0520, code lost:
        r2 = r0.getString(net.one97.paytm.landingpage.R.string.upgrade_limit);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0526, code lost:
        r14.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x052b, code lost:
        r14 = (android.widget.ImageView) a(net.one97.paytm.landingpage.R.id.name_info);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0533, code lost:
        if (r14 == null) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0535, code lost:
        r14.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0539, code lost:
        r14 = (androidx.constraintlayout.widget.Group) a(net.one97.paytm.landingpage.R.id.kycStatusGroups);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0541, code lost:
        if (r14 == null) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0543, code lost:
        r14.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0548, code lost:
        if (r13.v == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x054a, code lost:
        r13.v = false;
        r14 = net.one97.paytm.common.b.d.b();
        kotlin.g.b.k.a((java.lang.Object) r14, "HomeHelper.getAppLaunchModuleInterface()");
        androidx.localbroadcastmanager.a.a.a(r14.a()).a(new android.content.Intent("ACTION_UPDATE_PROFILE"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0567, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:286:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.CJRUserInfoV2 r14) {
        /*
            r13 = this;
            java.lang.String r0 = "userinfo"
            kotlin.g.b.k.c(r14, r0)
            r13.o = r14
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.paytm.utility.b.al(r0)
            r1 = 8
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0171
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r6 = r5.length()
            int r6 = r6 - r3
            r7 = r6
            r6 = 0
            r8 = 0
        L_0x0023:
            if (r6 > r7) goto L_0x0043
            if (r8 != 0) goto L_0x0029
            r9 = r6
            goto L_0x002a
        L_0x0029:
            r9 = r7
        L_0x002a:
            char r9 = r5.charAt(r9)
            r10 = 32
            if (r9 > r10) goto L_0x0034
            r9 = 1
            goto L_0x0035
        L_0x0034:
            r9 = 0
        L_0x0035:
            if (r8 != 0) goto L_0x003e
            if (r9 != 0) goto L_0x003b
            r8 = 1
            goto L_0x0023
        L_0x003b:
            int r6 = r6 + 1
            goto L_0x0023
        L_0x003e:
            if (r9 == 0) goto L_0x0043
            int r7 = r7 + -1
            goto L_0x0023
        L_0x0043:
            int r7 = r7 + r3
            java.lang.CharSequence r5 = r5.subSequence(r6, r7)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0056
            r5 = 1
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x0171
            int r5 = net.one97.paytm.landingpage.R.id.edit_profile_user_iv
            android.view.View r5 = r13.a((int) r5)
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5
            if (r5 == 0) goto L_0x0068
            int r6 = net.one97.paytm.landingpage.R.drawable.edit_profile_deafult_image
            r5.setImageResource(r6)
        L_0x0068:
            int r5 = net.one97.paytm.landingpage.R.id.edit_profile_tv
            android.view.View r5 = r13.a((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0075
            r5.setVisibility(r1)
        L_0x0075:
            java.lang.String r5 = android.os.Environment.getExternalStorageState()
            java.lang.String r6 = "mounted"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r3)
            if (r5 == 0) goto L_0x0174
            androidx.fragment.app.FragmentActivity r5 = r13.getActivity()
            if (r5 == 0) goto L_0x00be
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.File r6 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r6 = r6.toString()
            r5.append(r6)
            androidx.fragment.app.FragmentActivity r6 = r13.getActivity()
            if (r6 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            java.lang.String r7 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.String r6 = com.paytm.utility.b.am(r6)
            r5.append(r6)
            java.lang.String r6 = "/profilePicture.jpg"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r5)
            goto L_0x00bf
        L_0x00be:
            r5 = r2
        L_0x00bf:
            androidx.fragment.app.FragmentActivity r6 = r13.getActivity()
            android.content.Context r6 = (android.content.Context) r6
            boolean r6 = com.paytm.utility.b.an(r6)
            if (r6 == 0) goto L_0x012a
            if (r5 == 0) goto L_0x012a
            com.paytm.utility.b.b$a r0 = com.paytm.utility.b.b.f43744a     // Catch:{ Exception -> 0x0118 }
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()     // Catch:{ Exception -> 0x0118 }
            if (r0 != 0) goto L_0x00d8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0118 }
        L_0x00d8:
            java.lang.String r6 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x0118 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0118 }
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.a(r0)     // Catch:{ Exception -> 0x0118 }
            r0.f43753a = r5     // Catch:{ Exception -> 0x0118 }
            com.paytm.network.a$c r5 = com.paytm.network.a.c.HOME     // Catch:{ Exception -> 0x0118 }
            java.lang.String r5 = r5.name()     // Catch:{ Exception -> 0x0118 }
            com.paytm.utility.b.b$a$a r0 = com.paytm.utility.b.b.a.C0750a.a((com.paytm.utility.b.b.a.C0750a) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x0118 }
            r0.n = r3     // Catch:{ Exception -> 0x0118 }
            int r5 = net.one97.paytm.landingpage.R.id.edit_profile_user_iv     // Catch:{ Exception -> 0x0118 }
            android.view.View r5 = r13.a((int) r5)     // Catch:{ Exception -> 0x0118 }
            androidx.appcompat.widget.AppCompatImageView r5 = (androidx.appcompat.widget.AppCompatImageView) r5     // Catch:{ Exception -> 0x0118 }
            r6 = 2
            com.paytm.utility.b.b.a.C0750a.a(r0, r5, r2, r6)     // Catch:{ Exception -> 0x0118 }
            int r0 = net.one97.paytm.landingpage.R.id.edit_profile_tv     // Catch:{ Exception -> 0x0118 }
            android.view.View r0 = r13.a((int) r0)     // Catch:{ Exception -> 0x0118 }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x0118 }
            if (r0 == 0) goto L_0x010a
            r0.setVisibility(r4)     // Catch:{ Exception -> 0x0118 }
        L_0x010a:
            int r0 = net.one97.paytm.landingpage.R.id.addProfileImageNudge     // Catch:{ Exception -> 0x0118 }
            android.view.View r0 = r13.a((int) r0)     // Catch:{ Exception -> 0x0118 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x0118 }
            if (r0 == 0) goto L_0x0174
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x0118 }
            goto L_0x0174
        L_0x0118:
            int r0 = net.one97.paytm.landingpage.R.id.edit_profile_tv
            android.view.View r0 = r13.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0126
            r0.setVisibility(r1)
        L_0x0126:
            r13.h()
            goto L_0x0174
        L_0x012a:
            android.content.Context r5 = r13.getContext()     // Catch:{ Exception -> 0x016f }
            if (r5 == 0) goto L_0x0174
            com.paytm.utility.b.b$a r6 = com.paytm.utility.b.b.f43744a     // Catch:{ Exception -> 0x016f }
            java.lang.String r6 = "it"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x016f }
            com.paytm.utility.b.b$a$a r5 = com.paytm.utility.b.b.a.a(r5)     // Catch:{ Exception -> 0x016f }
            r5.f43753a = r0     // Catch:{ Exception -> 0x016f }
            com.paytm.network.a$c r6 = com.paytm.network.a.c.HOME     // Catch:{ Exception -> 0x016f }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x016f }
            com.paytm.utility.b.b$a$a r5 = com.paytm.utility.b.b.a.C0750a.a((com.paytm.utility.b.b.a.C0750a) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x016f }
            r5.n = r3     // Catch:{ Exception -> 0x016f }
            android.content.res.Resources r6 = r13.getResources()     // Catch:{ Exception -> 0x016f }
            int r7 = net.one97.paytm.landingpage.R.drawable.edit_profile_deafult_image     // Catch:{ Exception -> 0x016f }
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)     // Catch:{ Exception -> 0x016f }
            java.lang.String r7 = "resources.getDrawable(R.…it_profile_deafult_image)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x016f }
            com.paytm.utility.b.b$a$a r5 = r5.a((java.lang.Object) r6)     // Catch:{ Exception -> 0x016f }
            int r6 = net.one97.paytm.landingpage.R.id.edit_profile_user_iv     // Catch:{ Exception -> 0x016f }
            android.view.View r6 = r13.a((int) r6)     // Catch:{ Exception -> 0x016f }
            androidx.appcompat.widget.AppCompatImageView r6 = (androidx.appcompat.widget.AppCompatImageView) r6     // Catch:{ Exception -> 0x016f }
            net.one97.paytm.upgradeKyc.editprofile.view.c$r r7 = new net.one97.paytm.upgradeKyc.editprofile.view.c$r     // Catch:{ Exception -> 0x016f }
            r7.<init>(r13, r0)     // Catch:{ Exception -> 0x016f }
            com.paytm.utility.b.b.b r7 = (com.paytm.utility.b.b.b) r7     // Catch:{ Exception -> 0x016f }
            r5.a((android.widget.ImageView) r6, (com.paytm.utility.b.b.b<?>) r7)     // Catch:{ Exception -> 0x016f }
            goto L_0x0174
        L_0x016f:
            goto L_0x0174
        L_0x0171:
            r13.h()
        L_0x0174:
            net.one97.paytm.common.entity.CJRUserDefaultInfo r0 = r14.getUserDefaultInfo()
            if (r0 == 0) goto L_0x0248
            net.one97.paytm.common.entity.CJRUserDefaultInfo r0 = r14.getUserDefaultInfo()
            java.lang.String r5 = "userinfo.userDefaultInfo"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r0 = r0.getEmail()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r6 = "display_email_et"
            java.lang.String r7 = ""
            if (r0 != 0) goto L_0x01dd
            int r0 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r0 = r13.a((int) r0)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            net.one97.paytm.common.entity.CJRUserDefaultInfo r8 = r14.getUserDefaultInfo()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            java.lang.String r8 = r8.getEmail()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            int r0 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r0 = r13.a((int) r0)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setEnabled(r4)
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x021c
            int r0 = net.one97.paytm.landingpage.R.id.edit_email
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x021c
            android.content.Context r6 = r13.getContext()
            if (r6 == 0) goto L_0x01d6
            int r8 = net.one97.paytm.landingpage.R.string.edit
            java.lang.String r6 = r6.getString(r8)
            goto L_0x01d7
        L_0x01d6:
            r6 = r2
        L_0x01d7:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            goto L_0x021c
        L_0x01dd:
            int r0 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r0 = r13.a((int) r0)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            int r0 = net.one97.paytm.landingpage.R.id.display_email_et
            android.view.View r0 = r13.a((int) r0)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r0.setEnabled(r3)
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x021c
            int r0 = net.one97.paytm.landingpage.R.id.edit_email
            android.view.View r0 = r13.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x021c
            android.content.Context r6 = r13.getContext()
            if (r6 == 0) goto L_0x0216
            int r8 = net.one97.paytm.landingpage.R.string.add
            java.lang.String r6 = r6.getString(r8)
            goto L_0x0217
        L_0x0216:
            r6 = r2
        L_0x0217:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
        L_0x021c:
            net.one97.paytm.common.entity.CJRUserDefaultInfo r0 = r14.getUserDefaultInfo()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r0 = r0.getPhone()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x023b
            int r5 = net.one97.paytm.landingpage.R.id.display_mobile_et
            android.view.View r5 = r13.a((int) r5)
            com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
            r5.setText(r0)
            goto L_0x0248
        L_0x023b:
            int r0 = net.one97.paytm.landingpage.R.id.display_mobile_et
            android.view.View r0 = r13.a((int) r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x0248:
            net.one97.paytm.common.entity.wallet.MinKycDetails r14 = r14.getmMinKycDetails()
            r0 = 4
            if (r14 == 0) goto L_0x0568
            java.lang.String r5 = r14.getmKycState()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0260
            int r5 = r5.length()
            if (r5 != 0) goto L_0x025e
            goto L_0x0260
        L_0x025e:
            r5 = 0
            goto L_0x0261
        L_0x0260:
            r5 = 1
        L_0x0261:
            if (r5 != 0) goto L_0x0568
            int r5 = net.one97.paytm.landingpage.R.id.kycStatusGroups
            android.view.View r5 = r13.a((int) r5)
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x0270
            r5.setVisibility(r4)
        L_0x0270:
            java.lang.String r14 = r14.getmKycState()
            java.lang.String r5 = "minKycDetails.getmKycState()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
            r13.t = r14
            java.lang.String r14 = r13.t
            int r5 = r14.hashCode()
            java.lang.String r6 = "PAYTM_BASIC_WALLET"
            java.lang.String r7 = "PAYTM_PRIME_WALLET"
            java.lang.String r8 = "PAYTM_NON_WALLET"
            java.lang.String r9 = "PAYTM_AHDAR_OTP_KYC_EXPIRED"
            java.lang.String r10 = "PAYTM_MIN_KYC_LOCKED"
            java.lang.String r11 = "PAYTM_PRIMITIVE"
            java.lang.String r12 = "PAYTM_ADHAR_OTP_KYC"
            switch(r5) {
                case -2007004454: goto L_0x02d2;
                case -2004957431: goto L_0x02c8;
                case -1686223585: goto L_0x02c1;
                case -1330922216: goto L_0x02ba;
                case -1201059895: goto L_0x02b3;
                case -698611625: goto L_0x02ac;
                case -243305528: goto L_0x02a5;
                case -132749366: goto L_0x029c;
                case 1913706384: goto L_0x0293;
                default: goto L_0x0292;
            }
        L_0x0292:
            goto L_0x02e6
        L_0x0293:
            java.lang.String r5 = "PAYTM_MIN_KYC_EXPIRED"
            boolean r14 = r14.equals(r5)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x029c:
            java.lang.String r5 = "PAYTM_MIN_KYC"
            boolean r14 = r14.equals(r5)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x02a5:
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02ce
        L_0x02ac:
            boolean r14 = r14.equals(r7)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x02b3:
            boolean r14 = r14.equals(r8)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x02ba:
            boolean r14 = r14.equals(r9)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x02c1:
            boolean r14 = r14.equals(r10)
            if (r14 == 0) goto L_0x02e6
            goto L_0x02d8
        L_0x02c8:
            boolean r14 = r14.equals(r11)
            if (r14 == 0) goto L_0x02e6
        L_0x02ce:
            r13.k()
            goto L_0x02e9
        L_0x02d2:
            boolean r14 = r14.equals(r12)
            if (r14 == 0) goto L_0x02e6
        L_0x02d8:
            net.one97.paytm.upgradeKyc.editprofile.e.d r14 = r13.k
            if (r14 == 0) goto L_0x02e9
            net.one97.paytm.upgradeKyc.editprofile.d.a r5 = r14.f65833b
            if (r5 == 0) goto L_0x02e9
            net.one97.paytm.upgradeKyc.editprofile.b.a$d r14 = (net.one97.paytm.upgradeKyc.editprofile.b.a.d) r14
            r5.a((net.one97.paytm.upgradeKyc.editprofile.b.a.d) r14)
            goto L_0x02e9
        L_0x02e6:
            r13.k()
        L_0x02e9:
            java.lang.String r14 = r13.t
            int r5 = r14.hashCode()
            switch(r5) {
                case -2007004454: goto L_0x04a0;
                case -2004957431: goto L_0x0495;
                case -1686223585: goto L_0x048a;
                case -1330922216: goto L_0x0483;
                case -1201059895: goto L_0x047c;
                case -698611625: goto L_0x03dd;
                case -243305528: goto L_0x03d5;
                case -132749366: goto L_0x02fe;
                case 1913706384: goto L_0x02f4;
                default: goto L_0x02f2;
            }
        L_0x02f2:
            goto L_0x0539
        L_0x02f4:
            java.lang.String r1 = "PAYTM_MIN_KYC_EXPIRED"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x0539
            goto L_0x0490
        L_0x02fe:
            java.lang.String r3 = "PAYTM_MIN_KYC"
            boolean r14 = r14.equals(r3)
            if (r14 == 0) goto L_0x0539
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0329
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x0323
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0323
            int r3 = net.one97.paytm.landingpage.R.string.active
            java.lang.String r0 = r0.getString(r3)
            goto L_0x0324
        L_0x0323:
            r0 = r2
        L_0x0324:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
        L_0x0329:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_limit
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0336
            r14.setVisibility(r4)
        L_0x0336:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_limit
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0371
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x0353
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0353
            int r3 = net.one97.paytm.landingpage.R.string.rs
            java.lang.String r0 = r0.getString(r3)
            goto L_0x0354
        L_0x0353:
            r0 = r2
        L_0x0354:
            android.content.Context r3 = r13.getContext()
            if (r3 == 0) goto L_0x0367
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0367
            int r5 = net.one97.paytm.landingpage.R.string.active_ten_thousand_per_month
            java.lang.String r3 = r3.getString(r5)
            goto L_0x0368
        L_0x0367:
            r3 = r2
        L_0x0368:
            java.lang.String r0 = kotlin.g.b.k.a((java.lang.String) r0, (java.lang.Object) r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
        L_0x0371:
            int r14 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x037e
            r14.setVisibility(r1)
        L_0x037e:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x038b
            r14.setCompoundDrawablesWithIntrinsicBounds(r4, r4, r4, r4)
        L_0x038b:
            int r14 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r14 = r13.a((int) r14)
            com.google.android.material.textfield.TextInputEditText r14 = (com.google.android.material.textfield.TextInputEditText) r14
            if (r14 == 0) goto L_0x0398
            r14.setEnabled(r4)
        L_0x0398:
            int r14 = net.one97.paytm.landingpage.R.id.kycVerifiedView
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x03a5
            r14.setVisibility(r1)
        L_0x03a5:
            int r14 = net.one97.paytm.landingpage.R.id.edit_wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x03c6
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x03c1
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x03c1
            int r1 = net.one97.paytm.landingpage.R.string.upgrade_limit
            java.lang.String r2 = r0.getString(r1)
        L_0x03c1:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x03c6:
            int r14 = net.one97.paytm.landingpage.R.id.name_info
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0546
            r14.setVisibility(r4)
            goto L_0x0546
        L_0x03d5:
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x0539
            goto L_0x049b
        L_0x03dd:
            boolean r14 = r14.equals(r7)
            if (r14 == 0) goto L_0x0539
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0406
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x0400
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0400
            int r5 = net.one97.paytm.landingpage.R.string.active
            java.lang.String r0 = r0.getString(r5)
            goto L_0x0401
        L_0x0400:
            r0 = r2
        L_0x0401:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
        L_0x0406:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_limit
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0413
            r14.setVisibility(r1)
        L_0x0413:
            int r14 = net.one97.paytm.landingpage.R.drawable.ic_kyc_verified
            r13.a((int) r14, (boolean) r3)
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0425
            r14.setCompoundDrawablesWithIntrinsicBounds(r4, r4, r4, r4)
        L_0x0425:
            int r14 = net.one97.paytm.landingpage.R.id.kycVerifiedView
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0432
            r14.setVisibility(r4)
        L_0x0432:
            int r14 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x043f
            r14.setVisibility(r1)
        L_0x043f:
            int r14 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r14 = r13.a((int) r14)
            com.google.android.material.textfield.TextInputEditText r14 = (com.google.android.material.textfield.TextInputEditText) r14
            if (r14 == 0) goto L_0x044c
            r14.setEnabled(r4)
        L_0x044c:
            int r14 = net.one97.paytm.landingpage.R.id.edit_wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x046d
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x0468
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0468
            int r1 = net.one97.paytm.landingpage.R.string.view_benefits
            java.lang.String r2 = r0.getString(r1)
        L_0x0468:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x046d:
            int r14 = net.one97.paytm.landingpage.R.id.name_info
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0546
            r14.setVisibility(r4)
            goto L_0x0546
        L_0x047c:
            boolean r14 = r14.equals(r8)
            if (r14 == 0) goto L_0x0539
            goto L_0x049b
        L_0x0483:
            boolean r14 = r14.equals(r9)
            if (r14 == 0) goto L_0x0539
            goto L_0x0490
        L_0x048a:
            boolean r14 = r14.equals(r10)
            if (r14 == 0) goto L_0x0539
        L_0x0490:
            r13.a((boolean) r4)
            goto L_0x0546
        L_0x0495:
            boolean r14 = r14.equals(r11)
            if (r14 == 0) goto L_0x0539
        L_0x049b:
            r13.a((boolean) r3)
            goto L_0x0546
        L_0x04a0:
            boolean r14 = r14.equals(r12)
            if (r14 == 0) goto L_0x0539
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x04c9
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x04c3
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x04c3
            int r3 = net.one97.paytm.landingpage.R.string.active
            java.lang.String r0 = r0.getString(r3)
            goto L_0x04c4
        L_0x04c3:
            r0 = r2
        L_0x04c4:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14.setText(r0)
        L_0x04c9:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_limit
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x04d6
            r14.setVisibility(r1)
        L_0x04d6:
            int r14 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x04e3
            r14.setCompoundDrawablesWithIntrinsicBounds(r4, r4, r4, r4)
        L_0x04e3:
            int r14 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x04f0
            r14.setVisibility(r1)
        L_0x04f0:
            int r14 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r14 = r13.a((int) r14)
            com.google.android.material.textfield.TextInputEditText r14 = (com.google.android.material.textfield.TextInputEditText) r14
            if (r14 == 0) goto L_0x04fd
            r14.setEnabled(r4)
        L_0x04fd:
            int r14 = net.one97.paytm.landingpage.R.id.kycVerifiedView
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x050a
            r14.setVisibility(r1)
        L_0x050a:
            int r14 = net.one97.paytm.landingpage.R.id.edit_wallet_status
            android.view.View r14 = r13.a((int) r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x052b
            android.content.Context r0 = r13.getContext()
            if (r0 == 0) goto L_0x0526
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x0526
            int r1 = net.one97.paytm.landingpage.R.string.upgrade_limit
            java.lang.String r2 = r0.getString(r1)
        L_0x0526:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
        L_0x052b:
            int r14 = net.one97.paytm.landingpage.R.id.name_info
            android.view.View r14 = r13.a((int) r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0546
            r14.setVisibility(r4)
            goto L_0x0546
        L_0x0539:
            int r14 = net.one97.paytm.landingpage.R.id.kycStatusGroups
            android.view.View r14 = r13.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            if (r14 == 0) goto L_0x0546
            r14.setVisibility(r0)
        L_0x0546:
            boolean r14 = r13.v
            if (r14 == 0) goto L_0x0577
            r13.v = r4
            net.one97.paytm.common.b.a r14 = net.one97.paytm.common.b.d.b()
            java.lang.String r0 = "HomeHelper.getAppLaunchModuleInterface()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            android.content.Context r14 = r14.a()
            androidx.localbroadcastmanager.a.a r14 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r14)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "ACTION_UPDATE_PROFILE"
            r0.<init>(r1)
            r14.a((android.content.Intent) r0)
            return
        L_0x0568:
            r13.v = r4
            int r14 = net.one97.paytm.landingpage.R.id.kycStatusGroups
            android.view.View r14 = r13.a((int) r14)
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            if (r14 == 0) goto L_0x0577
            r14.setVisibility(r0)
        L_0x0577:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.a(net.one97.paytm.common.entity.CJRUserInfoV2):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 211) {
            c cVar = this;
            if (i3 == -1) {
                ((TextInputEditText) cVar.a(R.id.display_mobile_et)).setText(intent != null ? intent.getStringExtra("mobileNumber") : null);
                String string = cVar.getString(R.string.phone_no_update_success);
                kotlin.g.b.k.a((Object) string, "getString(R.string.phone_no_update_success)");
                cVar.b("#21C17A", string);
            }
        }
    }

    public static final class r implements com.paytm.utility.b.b.b<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f65940b;

        r(c cVar, String str) {
            this.f65939a = cVar;
            this.f65940b = str;
        }

        public final void onError(Exception exc) {
            ImageView imageView = (ImageView) this.f65939a.a(R.id.edit_profile_tv);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.f65939a.h();
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.f65939a.a(R.id.edit_profile_user_iv);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R.drawable.edit_profile_deafult_image);
            }
        }

        public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
            com.paytm.utility.b.a((Context) this.f65939a.getActivity(), Boolean.TRUE);
            c cVar2 = this.f65939a;
            cVar2.f65928b = new net.one97.paytm.upgradeKyc.editprofile.c.b(cVar2);
            net.one97.paytm.upgradeKyc.editprofile.c.b bVar = this.f65939a.f65928b;
            if (bVar != null) {
                bVar.execute(new String[]{this.f65940b});
            }
            ImageView imageView = (ImageView) this.f65939a.a(R.id.edit_profile_tv);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.f65939a.a(R.id.addProfileImageNudge);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
    }

    public final void j() {
        if (com.paytm.utility.s.a() && getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            if (activity.checkSelfPermission("android.permission.CAMERA") != 0) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                activity2.requestPermissions(new String[]{"android.permission.CAMERA"}, 51);
                return;
            }
        }
        if (com.paytm.utility.s.a() && getActivity() != null) {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                kotlin.g.b.k.a();
            }
            if (activity3.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 56);
                return;
            }
        }
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (kotlin.m.p.a(Environment.getExternalStorageState(), "mounted", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory().toString());
                FragmentActivity activity4 = getActivity();
                if (activity4 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity4, "activity!!");
                sb.append(com.paytm.utility.b.am(activity4.getApplicationContext()));
                String sb2 = sb.toString();
                File file = new File(sb2);
                if (!file.exists() ? file.mkdirs() : true) {
                    File file2 = new File(sb2, "picture.jpg");
                    if (com.paytm.utility.s.b()) {
                        FragmentActivity activity5 = getActivity();
                        if (activity5 == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity5, "activity!!");
                        Uri uriForFile = FileProvider.getUriForFile(activity5.getApplicationContext(), "net.one97.paytm.provider", file2);
                        intent.setFlags(1);
                        intent.putExtra("output", uriForFile);
                    } else {
                        intent.putExtra("output", Uri.fromFile(file2));
                    }
                    FragmentActivity activity6 = getActivity();
                    if (activity6 == null) {
                        kotlin.g.b.k.a();
                    }
                    activity6.startActivityForResult(intent, 212);
                }
            }
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65935a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        d(c cVar) {
            this.f65935a = cVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65935a.a(R.id.fragment_profile_display_name_layout);
            if (textInputLayout != null) {
                textInputLayout.setError("");
            }
            c cVar = this.f65935a;
            cVar.f65929c = true;
            TextInputEditText textInputEditText = (TextInputEditText) cVar.a(R.id.display_name_et);
            if (textInputEditText != null ? textInputEditText.hasFocus() : false) {
                TextView textView = (TextView) this.f65935a.a(R.id.save_name);
                if (textView != null) {
                    textView.setText(this.f65935a.getString(R.string.save));
                    return;
                }
                return;
            }
            TextView textView2 = (TextView) this.f65935a.a(R.id.save_name);
            if (textView2 != null) {
                textView2.setText(this.f65935a.getString(R.string.edit));
            }
        }
    }

    public final void a(File file) {
        net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getApplicationContext();
        }
        String a2 = b2.a(UpiConstantServiceApi.KEY_PROFILE_PIC_URL);
        if (URLUtil.isValidUrl(a2)) {
            a.C0715a aVar = a.C0715a.POST;
            ProgressDialog show = ProgressDialog.show(getActivity(), "Uploading...", "Please wait...", false, false);
            net.one97.paytm.common.b.d.b().i(getActivity());
            HashMap hashMap = new HashMap();
            if (file != null) {
                hashMap.put(UpiConstantServiceApi.KEY_PROFILE_PIC_URL, file);
            } else {
                aVar = a.C0715a.DELETE;
            }
            Map<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("Content-Type", "application/json");
            String b3 = net.one97.paytm.common.b.d.a().b((Context) getActivity());
            kotlin.g.b.k.a((Object) b3, "HomeHelper.getModuleInte…e().getSSOToken(activity)");
            hashMap2.put("session_token", b3);
            HashMap hashMap3 = new HashMap();
            com.paytm.network.e eVar = new com.paytm.network.e();
            eVar.f42918c = hashMap;
            eVar.f42919d = hashMap2;
            eVar.f42923h = a2;
            eVar.n = new CJRProfilePic();
            eVar.f42921f = a.c.HOME;
            eVar.k = "profile";
            eVar.f42916a = getContext();
            eVar.f42917b = hashMap3;
            eVar.f42922g = aVar;
            s sVar = new s(this, show);
            eVar.j = d.a.USER_FACING;
            eVar.f42924i = sVar;
            if (com.paytm.utility.b.c(getContext())) {
                eVar.a().a();
                return;
            }
            if (show != null && show.isShowing()) {
                show.dismiss();
            }
            m();
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.msg_invalid_url));
    }

    public static final class s implements com.paytm.network.listener.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f65942b;

        s(c cVar, ProgressDialog progressDialog) {
            this.f65941a = cVar;
            this.f65942b = progressDialog;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            Context applicationContext;
            CJRUserDefaultInfo userDefaultInfo;
            ProgressDialog progressDialog;
            if (!ImageUtility.isActivityDestroyed(this.f65941a.getActivity()) && (progressDialog = this.f65942b) != null && progressDialog.isShowing()) {
                this.f65942b.dismiss();
            }
            if (iJRPaytmDataModel != null) {
                CJRProfilePic cJRProfilePic = (CJRProfilePic) iJRPaytmDataModel;
                if (cJRProfilePic == null) {
                    return;
                }
                if (cJRProfilePic.getResponseCode() == null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStorageDirectory().toString());
                        FragmentActivity activity = this.f65941a.getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        sb.append(com.paytm.utility.b.am(activity.getApplicationContext()));
                        sb.append(UpiConstants.USER_PROFILE_PIC_FILENAME);
                        File file = new File(sb.toString());
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e2) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                    if (!(this.f65941a.getActivity() == null || cJRProfilePic.getUserPicture() == null || this.f65941a.o == null)) {
                        CJRUserInfoV2 f2 = this.f65941a.o;
                        Context context = null;
                        if ((f2 != null ? f2.getUserDefaultInfo() : null) != null) {
                            CJRUserInfoV2 f3 = this.f65941a.o;
                            if (!(f3 == null || (userDefaultInfo = f3.getUserDefaultInfo()) == null)) {
                                userDefaultInfo.setUserPicture(cJRProfilePic.getUserPicture());
                            }
                            net.one97.paytm.common.b.d.a().a(this.f65941a.o, (Context) this.f65941a.getActivity());
                            net.one97.paytm.common.b.e a2 = net.one97.paytm.common.b.d.a();
                            FragmentActivity activity2 = this.f65941a.getActivity();
                            if (activity2 != null) {
                                context = activity2.getApplicationContext();
                            }
                            a2.E(context);
                            FragmentActivity activity3 = this.f65941a.getActivity();
                            if (!(activity3 == null || (applicationContext = activity3.getApplicationContext()) == null)) {
                                androidx.localbroadcastmanager.a.a.a(applicationContext).a(new Intent(CLPConstants.ACTION_UPDATE_PROFILE_PIC_FLYOUT));
                            }
                        }
                    }
                    try {
                        Context context2 = this.f65941a.getContext();
                        if (context2 != null) {
                            b.a aVar = com.paytm.utility.b.b.f43744a;
                            kotlin.g.b.k.a((Object) context2, "it");
                            b.a.C0750a a3 = b.a.a(context2);
                            a3.f43753a = cJRProfilePic.getUserPicture();
                            b.a.C0750a a4 = b.a.C0750a.a(a3, a.c.HOME.name());
                            a4.n = true;
                            Drawable drawable = this.f65941a.getResources().getDrawable(R.drawable.edit_profile_deafult_image);
                            kotlin.g.b.k.a((Object) drawable, "resources.getDrawable(R.…it_profile_deafult_image)");
                            a4.a((Object) drawable).a((ImageView) (AppCompatImageView) this.f65941a.a(R.id.edit_profile_user_iv), (com.paytm.utility.b.b.b<?>) new a(this, cJRProfilePic));
                        }
                    } catch (Exception unused) {
                    }
                } else if (!kotlin.m.p.a(cJRProfilePic.getResponseCode(), "670", true) && !kotlin.m.p.a(cJRProfilePic.getResponseCode(), "671", true) && !kotlin.m.p.a(cJRProfilePic.getResponseCode(), "672", true) && !kotlin.m.p.a(cJRProfilePic.getResponseCode(), "434", true) && !kotlin.m.p.a(cJRProfilePic.getResponseCode(), "514", true)) {
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRProfilePic");
            }
        }

        public static final class a implements com.paytm.utility.b.b.b<Drawable> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s f65943a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRProfilePic f65944b;

            a(s sVar, CJRProfilePic cJRProfilePic) {
                this.f65943a = sVar;
                this.f65944b = cJRProfilePic;
            }

            public final void onError(Exception exc) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f65943a.f65941a.a(R.id.edit_profile_user_iv);
                if (appCompatImageView != null) {
                    appCompatImageView.setImageResource(R.drawable.edit_profile_deafult_image);
                }
                ImageView imageView = (ImageView) this.f65943a.f65941a.a(R.id.edit_profile_tv);
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                this.f65943a.f65941a.h();
            }

            public final /* synthetic */ void onSuccess(Object obj, com.paytm.utility.b.b.c cVar) {
                com.paytm.utility.b.a((Context) this.f65943a.f65941a.getActivity(), Boolean.TRUE);
                this.f65943a.f65941a.f65928b = new net.one97.paytm.upgradeKyc.editprofile.c.b(this.f65943a.f65941a);
                net.one97.paytm.upgradeKyc.editprofile.c.b bVar = this.f65943a.f65941a.f65928b;
                if (bVar != null) {
                    String[] strArr = new String[1];
                    CJRProfilePic cJRProfilePic = this.f65944b;
                    if (cJRProfilePic == null) {
                        kotlin.g.b.k.a();
                    }
                    strArr[0] = cJRProfilePic.getUserPicture();
                    bVar.execute(strArr);
                }
                ImageView imageView = (ImageView) this.f65943a.f65941a.a(R.id.edit_profile_tv);
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.f65943a.f65941a.a(R.id.addProfileImageNudge);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            ProgressDialog progressDialog = this.f65942b;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f65942b.dismiss();
            }
            if (networkCustomError != null && networkCustomError.networkResponse != null && networkCustomError.networkResponse.statusCode == 410) {
                Activity activity = this.f65941a.getActivity();
                Exception exc = networkCustomError;
                FragmentActivity activity2 = this.f65941a.getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.utils.r.a(activity, exc, activity2.getClass().getName(), (Bundle) null);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        d.a.a.c.a().a((Object) this, false);
    }

    public final void onStop() {
        super.onStop();
        p();
        d.a.a.c.a().b(this);
    }

    public final void onEvent(net.one97.paytm.upgradeKyc.editprofile.c.c cVar) {
        CersaiDetails cersaiDetails;
        Boolean bool;
        net.one97.paytm.upgradeKyc.editprofile.e.d dVar;
        kotlin.g.b.k.c(cVar, "editProfileObj");
        b bVar = this.s;
        if (bVar != null) {
            CersaiDetails cersaiDetails2 = null;
            if (bVar != null) {
                cersaiDetails = bVar.f65918b;
            } else {
                cersaiDetails = null;
            }
            if (cersaiDetails != null) {
                b bVar2 = this.s;
                if (bVar2 != null) {
                    a aVar = bVar2.f65917a;
                    bool = Boolean.valueOf(kotlin.g.b.k.a((Object) aVar != null ? Boolean.valueOf(aVar.e()) : null, (Object) Boolean.TRUE));
                } else {
                    bool = null;
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE) && (dVar = this.k) != null) {
                    b bVar3 = this.s;
                    if (bVar3 != null) {
                        cersaiDetails2 = bVar3.f65918b;
                    }
                    if (cersaiDetails2 == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.c(cersaiDetails2, "cKycData");
                    dVar.f65832a.b();
                    net.one97.paytm.upgradeKyc.editprofile.d.a aVar2 = dVar.f65833b;
                    if (aVar2 != null) {
                        aVar2.a(cersaiDetails2, dVar);
                        return;
                    }
                    return;
                }
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.upgradeKyc.editprofile.e.d dVar = this.k;
        if (dVar != null && dVar.f65833b != null) {
            if (dVar.f65833b != null) {
                net.one97.paytm.upgradeKyc.editprofile.d.a.a();
            }
            dVar.f65833b = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(boolean r6) {
        /*
            r5 = this;
            int r0 = net.one97.paytm.landingpage.R.id.wallet_status
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r0 == 0) goto L_0x0024
            android.content.Context r2 = r5.getContext()
            if (r2 == 0) goto L_0x001e
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x001e
            int r3 = net.one97.paytm.landingpage.R.string.wallet_not_active
            java.lang.String r2 = r2.getString(r3)
            goto L_0x001f
        L_0x001e:
            r2 = r1
        L_0x001f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0024:
            int r0 = net.one97.paytm.landingpage.R.drawable.ic_not_active
            r2 = 0
            r5.a((int) r0, (boolean) r2)
            int r0 = net.one97.paytm.landingpage.R.id.wallet_limit
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = 8
            if (r0 == 0) goto L_0x0039
            r0.setVisibility(r3)
        L_0x0039:
            int r0 = net.one97.paytm.landingpage.R.id.kycVerifiedView
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0046
            r0.setVisibility(r3)
        L_0x0046:
            int r0 = net.one97.paytm.landingpage.R.id.edit_wallet_status
            android.view.View r0 = r5.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x0067
            android.content.Context r4 = r5.getContext()
            if (r4 == 0) goto L_0x0062
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x0062
            int r1 = net.one97.paytm.landingpage.R.string.activate_now
            java.lang.String r1 = r4.getString(r1)
        L_0x0062:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0067:
            if (r6 == 0) goto L_0x0077
            int r6 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0091
            r6.setVisibility(r2)
            goto L_0x0091
        L_0x0077:
            int r6 = net.one97.paytm.landingpage.R.id.save_name
            android.view.View r6 = r5.a((int) r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0084
            r6.setVisibility(r3)
        L_0x0084:
            int r6 = net.one97.paytm.landingpage.R.id.display_name_et
            android.view.View r6 = r5.a((int) r6)
            com.google.android.material.textfield.TextInputEditText r6 = (com.google.android.material.textfield.TextInputEditText) r6
            if (r6 == 0) goto L_0x0091
            r6.setEnabled(r2)
        L_0x0091:
            int r6 = net.one97.paytm.landingpage.R.id.name_info
            android.view.View r6 = r5.a((int) r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x009e
            r6.setVisibility(r3)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.a(boolean):void");
    }

    public final void onResume() {
        super.onResume();
        if (getContext() != null && this.u) {
            this.u = false;
            this.v = true;
            l();
        }
    }

    private final void a(int i2, boolean z2) {
        androidx.vectordrawable.a.a.i iVar;
        if (Build.VERSION.SDK_INT < 21) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            iVar = androidx.vectordrawable.a.a.i.a(context.getResources(), i2, (Resources.Theme) null);
        } else {
            iVar = androidx.vectordrawable.a.a.i.a(getResources(), i2, (Resources.Theme) null);
        }
        if (z2) {
            TextView textView = (TextView) a(R.id.kycVerifiedView);
            if (textView != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(iVar, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) a(R.id.wallet_status);
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, iVar, (Drawable) null);
        }
    }

    private final void m() {
        String string = getString(R.string.err_enable_network_heading);
        kotlin.g.b.k.a((Object) string, "getString(R.string.err_enable_network_heading)");
        b("#FF9D00", string);
    }

    @kotlin.d.b.a.f(b = "KycProfileFragment.kt", c = {407}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.editprofile.view.KycProfileFragment$onClick$1")
    static final class e extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            e eVar = new e(this.this$0, dVar);
            eVar.p$ = (CoroutineScope) obj;
            return eVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                this.L$0 = this.p$;
                this.label = 1;
                if (DelayKt.delay(3000, this) == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                ResultKt.a(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TextView textView = (TextView) this.this$0.a(R.id.nameVerifiedText);
            if (textView != null) {
                textView.setVisibility(8);
            }
            return x.f47997a;
        }
    }

    private final void b(boolean z2) {
        if (z2) {
            View a2 = a(R.id.no_network_layout);
            if (a2 != null) {
                a2.setVisibility(0);
            }
            o();
            return;
        }
        View a3 = a(R.id.no_network_layout);
        if (a3 != null) {
            a3.setVisibility(8);
        }
        n();
    }

    private final void n() {
        ImageView imageView = (ImageView) a(R.id.motifView);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.edit_profile_user_iv);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
        }
        Group group = (Group) a(R.id.textGroups);
        if (group != null) {
            group.setVisibility(0);
        }
        Group group2 = (Group) a(R.id.emailGroups);
        if (group2 != null) {
            group2.setVisibility(0);
        }
        TextView textView = (TextView) a(R.id.edit_email);
        if (textView != null) {
            textView.setVisibility(0);
        }
        Group group3 = (Group) a(R.id.phoneNoGroups);
        if (group3 != null) {
            group3.setVisibility(0);
        }
        Group group4 = (Group) a(R.id.kycStatusGroups);
        if (group4 != null) {
            group4.setVisibility(0);
        }
    }

    private final void o() {
        ImageView imageView = (ImageView) a(R.id.motifView);
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.edit_profile_user_iv);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(4);
        }
        Group group = (Group) a(R.id.textGroups);
        if (group != null) {
            group.setVisibility(4);
        }
        Group group2 = (Group) a(R.id.emailGroups);
        if (group2 != null) {
            group2.setVisibility(4);
        }
        TextView textView = (TextView) a(R.id.edit_email);
        if (textView != null) {
            textView.setVisibility(4);
        }
        Group group3 = (Group) a(R.id.kycStatusGroups);
        if (group3 != null) {
            group3.setVisibility(4);
        }
        Group group4 = (Group) a(R.id.phoneNoGroups);
        if (group4 != null) {
            group4.setVisibility(4);
        }
        p();
    }

    /* JADX WARNING: type inference failed for: r6v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = r5
            net.one97.paytm.upgradeKyc.editprofile.view.c r0 = (net.one97.paytm.upgradeKyc.editprofile.view.c) r0
            android.view.View r0 = r0.f65933h
            r1 = 0
            java.lang.String r2 = "snackBarView"
            if (r0 != 0) goto L_0x0086
            android.view.LayoutInflater r0 = r5.getLayoutInflater()
            int r3 = net.one97.paytm.landingpage.R.layout.result_snackbar_view
            r4 = 0
            android.view.View r0 = r0.inflate(r3, r4, r1)
            java.lang.String r3 = "layoutInflater.inflate(R…ackbar_view, null, false)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r5.f65933h = r0
            android.view.View r0 = r5.f65933h
            if (r0 != 0) goto L_0x0023
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0023:
            int r3 = net.one97.paytm.landingpage.R.id.result_text
            android.view.View r0 = r0.findViewById(r3)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            if (r0 == 0) goto L_0x0032
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x0032:
            android.view.View r7 = r5.f65933h
            if (r7 != 0) goto L_0x0039
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0039:
            int r0 = net.one97.paytm.landingpage.R.id.result_text
            android.view.View r7 = r7.findViewById(r0)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            if (r7 == 0) goto L_0x004a
            int r6 = android.graphics.Color.parseColor(r6)
            r7.setBackgroundColor(r6)
        L_0x004a:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0066
            android.view.Window r6 = r6.getWindow()
            if (r6 == 0) goto L_0x0066
            android.view.View r6 = r6.getDecorView()
            if (r6 == 0) goto L_0x0066
            r7 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r6 = r6.findViewById(r7)
            r4 = r6
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
        L_0x0066:
            if (r4 == 0) goto L_0x0086
            android.view.View r6 = r5.f65933h
            if (r6 != 0) goto L_0x006f
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x006f:
            r7 = -1
            android.content.Context r0 = r5.requireContext()
            java.lang.String r3 = "requireContext()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.res.Resources r0 = r0.getResources()
            int r3 = net.one97.paytm.landingpage.R.dimen.dimen_35dp
            int r0 = r0.getDimensionPixelSize(r3)
            r4.addView(r6, r7, r0)
        L_0x0086:
            android.view.View r6 = r5.f65933h
            if (r6 != 0) goto L_0x008d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x008d:
            r6.setVisibility(r1)
            android.content.Context r6 = r5.getContext()
            int r7 = net.one97.paytm.landingpage.R.anim.slide_in_top
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r7)
            if (r6 == 0) goto L_0x00a6
            android.view.View r7 = r5.f65933h
            if (r7 != 0) goto L_0x00a3
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00a3:
            r7.startAnimation(r6)
        L_0x00a6:
            android.os.Handler r6 = r5.f65934i
            java.lang.Runnable r7 = r5.x
            r0 = 2000(0x7d0, double:9.88E-321)
            r6.postDelayed(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.c.b(java.lang.String, java.lang.String):void");
    }

    private final void p() {
        this.f65934i.removeCallbacksAndMessages((Object) null);
        if (this.f65933h != null) {
            View view = this.f65933h;
            if (view == null) {
                kotlin.g.b.k.a("snackBarView");
            }
            view.setVisibility(8);
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f65936a;

        o(c cVar) {
            this.f65936a = cVar;
        }

        public final void run() {
            if (this.f65936a.f65933h != null && c.g(this.f65936a).isShown()) {
                c.g(this.f65936a).startAnimation(AnimationUtils.loadAnimation(this.f65936a.getContext(), R.anim.slide_out_top));
                c.g(this.f65936a).setVisibility(8);
            }
        }
    }

    private final void q() {
        net.one97.paytm.common.b.d.a().a(getContext(), "personal_details", "Update_email_clicked", "", "/profile_settings", "");
    }

    private final void c(String str, String str2) {
        net.one97.paytm.common.b.d.a().a(getContext(), "personal_details", str, str2, "/profile_settings", "");
    }

    private final void r() {
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).toggleSoftInput(2, 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final void a(Uri uri) {
        kotlin.g.b.k.c(uri, "selectedImage");
        CropImage.a a2 = CropImage.a(uri).a(CropImageView.c.ON);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        a2.a(activity, true, true);
    }

    public final void a(String str) {
        if (str != null) {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = charSequence.charAt(!z2 ? i2 : length) <= ' ';
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (!z3) {
                    z2 = true;
                } else {
                    i2++;
                }
            }
            if (charSequence.subSequence(i2, length + 1).toString().length() != 0) {
                ((TextInputEditText) a(R.id.display_mobile_et)).setText(this.n + str);
            }
        }
    }

    private final void l() {
        if (com.paytm.utility.b.c(getContext())) {
            net.one97.paytm.upgradeKyc.editprofile.e.d dVar = this.k;
            if (dVar != null) {
                dVar.b();
            }
        } else if (y) {
            m();
        }
    }

    public static final /* synthetic */ void d(c cVar) {
        if (cVar.t.equals("PAYTM_PRIME_WALLET")) {
            cVar.u = false;
            cVar.c("profile_clicked", "PAYTM_PRIME_WALLET");
        } else if (cVar.t.equals("PAYTM_MIN_KYC") || cVar.t.equals("PAYTM_ADHAR_OTP_KYC")) {
            cVar.u = true;
            cVar.c("upgrade_limit_clicked", cVar.t);
        } else {
            cVar.u = true;
            cVar.c("activate_wallet_clicked", cVar.t);
        }
        if (com.paytm.utility.b.c(cVar.getContext())) {
            net.one97.paytm.common.b.d.b().a((Context) cVar.getActivity(), "paytmmp://upgrade_wallet", (Bundle) null);
            return;
        }
        cVar.u = false;
        cVar.m();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
