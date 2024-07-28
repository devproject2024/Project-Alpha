package net.one97.paytm.vipcashback.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.d;
import net.one97.paytm.i.h;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.AJRVIPCashBackActivity;
import net.one97.paytm.vipcashback.fragment.d;

public final class FJRCashbackFragmentV2 extends h implements d {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20902c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    AppCompatActivity f20903a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20904b = "scratch_card_home";

    /* renamed from: d  reason: collision with root package name */
    private String f20905d;

    /* renamed from: e  reason: collision with root package name */
    private String f20906e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20907f;

    /* renamed from: g  reason: collision with root package name */
    private final String f20908g = DeepLinkConstant.FEATURES.MERCHANT_CASHBACK;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f20909h;

    private View a(int i2) {
        if (this.f20909h == null) {
            this.f20909h = new HashMap();
        }
        View view = (View) this.f20909h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f20909h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static FJRCashbackFragmentV2 a(boolean z, String str) {
            FJRCashbackFragmentV2 fJRCashbackFragmentV2 = new FJRCashbackFragmentV2();
            Bundle bundle = new Bundle();
            bundle.putBoolean("LOAD_ON_CREATE_DATA", z);
            bundle.putString("screen", str);
            fJRCashbackFragmentV2.setArguments(bundle);
            return fJRCashbackFragmentV2;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        String str = null;
        View inflate = layoutInflater.inflate(R.layout.fragment_cashback_landing, (ViewGroup) null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("screen");
        }
        this.f20905d = str;
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = r3.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r3, android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r3, r0)
            super.onViewCreated(r3, r4)
            androidx.appcompat.app.AppCompatActivity r3 = r2.f20903a
            r4 = 1
            if (r3 == 0) goto L_0x002d
            android.content.Intent r3 = r3.getIntent()
            if (r3 == 0) goto L_0x002d
            java.lang.String r0 = "offertag"
            boolean r3 = r3.hasExtra(r0)
            if (r3 != r4) goto L_0x002d
            androidx.appcompat.app.AppCompatActivity r3 = r2.f20903a
            if (r3 == 0) goto L_0x002a
            android.content.Intent r3 = r3.getIntent()
            if (r3 == 0) goto L_0x002a
            java.lang.String r3 = r3.getStringExtra(r0)
            goto L_0x002b
        L_0x002a:
            r3 = 0
        L_0x002b:
            r2.f20906e = r3
        L_0x002d:
            net.one97.paytm.vipcashback.c.a r3 = net.one97.paytm.vipcashback.c.a.a()
            java.lang.String r0 = "CashbackHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.String r3 = r3.c()
            java.lang.String r0 = "p4b"
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)
            if (r3 == 0) goto L_0x0046
            r2.a()
            goto L_0x00a3
        L_0x0046:
            java.lang.String r3 = r2.f20905d
            if (r3 != 0) goto L_0x004b
            goto L_0x0061
        L_0x004b:
            int r0 = r3.hashCode()
            r1 = 777536755(0x2e5844f3, float:4.9173953E-11)
            if (r0 == r1) goto L_0x0055
            goto L_0x0061
        L_0x0055:
            java.lang.String r0 = "homescreenMerchant"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0061
            r2.a()
            goto L_0x00a3
        L_0x0061:
            r2.f20907f = r4
            int r3 = net.one97.paytm.vipcashback.R.id.landingFragLayout
            android.view.View r3 = r2.a((int) r3)
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            if (r3 == 0) goto L_0x007a
            android.content.res.Resources r4 = r2.getResources()
            int r0 = net.one97.paytm.vipcashback.R.color.white
            int r4 = r4.getColor(r0)
            r3.setBackgroundColor(r4)
        L_0x007a:
            int r3 = net.one97.paytm.vipcashback.R.id.headerLayout
            android.view.View r3 = r2.a((int) r3)
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources r4 = r2.getResources()
            int r0 = net.one97.paytm.vipcashback.R.color.white
            int r4 = r4.getColor(r0)
            r3.setBackgroundColor(r4)
        L_0x008f:
            int r3 = net.one97.paytm.vipcashback.R.id.stripLayout
            android.view.View r3 = r2.a((int) r3)
            if (r3 == 0) goto L_0x009c
            r4 = 8
            r3.setVisibility(r4)
        L_0x009c:
            java.lang.String r3 = r2.f20904b
            java.lang.String r4 = r2.f20908g
            r2.a(r3, r4)
        L_0x00a3:
            int r3 = net.one97.paytm.vipcashback.R.id.backArrow
            android.view.View r3 = r2.a((int) r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x00b7
            net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2$b r4 = new net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2$b
            r4.<init>(r2)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FJRCashbackFragmentV2 f20910a;

        b(FJRCashbackFragmentV2 fJRCashbackFragmentV2) {
            this.f20910a = fJRCashbackFragmentV2;
        }

        public final void onClick(View view) {
            AppCompatActivity appCompatActivity;
            FJRCashbackFragmentV2 fJRCashbackFragmentV2 = this.f20910a;
            if ((fJRCashbackFragmentV2.f20903a instanceof AJRVIPCashBackActivity) && (appCompatActivity = fJRCashbackFragmentV2.f20903a) != null) {
                appCompatActivity.onBackPressed();
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (context instanceof AppCompatActivity) {
            this.f20903a = (AppCompatActivity) context;
        }
    }

    private final void a() {
        this.f20907f = false;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.landingFragLayout);
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.scratch_card_bg_color));
        }
        View a2 = a(R.id.headerLayout);
        if (a2 != null) {
            a2.setVisibility(8);
        }
        View a3 = a(R.id.stripLayout);
        if (a3 != null) {
            a3.setVisibility(0);
        }
        a(this.f20908g, this.f20904b);
    }

    private void a(String str, String str2) {
        k.c(str, "selectedFrag");
        k.c(str2, "otherFrag");
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (getChildFragmentManager().c(str) != null) {
                q a2 = getChildFragmentManager().a();
                Fragment c2 = getChildFragmentManager().c(str);
                if (c2 == null) {
                    k.a();
                }
                a2.c(c2).c();
            } else {
                getChildFragmentManager().a().b(R.id.fragmentContainer, a(str), str).c();
            }
            if (getChildFragmentManager().c(str2) != null) {
                q a3 = getChildFragmentManager().a();
                Fragment c3 = getChildFragmentManager().c(str2);
                if (c3 == null) {
                    k.a();
                }
                a3.b(c3).c();
            }
        }
    }

    private final Fragment a(String str) {
        if (k.a((Object) str, (Object) this.f20908g)) {
            d.a aVar = d.f20943a;
            return d.a.a(this.f20906e);
        } else if (k.a((Object) str, (Object) this.f20904b)) {
            return new net.one97.paytm.v2.features.cashbacklanding.c.d();
        } else {
            return new net.one97.paytm.v2.features.cashbacklanding.c.d();
        }
    }

    public final void a(boolean z) {
        if (z) {
            TextView textView = (TextView) a(R.id.fragmentHeading);
            if (textView != null) {
                textView.setVisibility(0);
            }
            ImageView imageView = (ImageView) a(R.id.headerImage);
            if (imageView != null) {
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) a(R.id.fragmentHeading);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        ImageView imageView2 = (ImageView) a(R.id.headerImage);
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20909h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
