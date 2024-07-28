package net.one97.paytm.wallet.newdesign.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.universalp2p.a.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;

public final class d extends f {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Context f70834a;

    /* renamed from: b  reason: collision with root package name */
    LottieAnimationView f70835b;

    /* renamed from: c  reason: collision with root package name */
    Button f70836c;

    /* renamed from: d  reason: collision with root package name */
    private View f70837d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.wallet.newdesign.universalp2p.a.a f70838e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.wallet.newdesign.c.b f70839f;

    /* renamed from: g  reason: collision with root package name */
    private List<? extends b.c> f70840g;

    /* renamed from: h  reason: collision with root package name */
    private int f70841h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f70842i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private net.one97.paytm.wallet.newdesign.universalp2p.c.b m;
    private HashMap n;

    public static final /* synthetic */ Button d(d dVar) {
        Button button = dVar.f70836c;
        if (button == null) {
            k.a("payButton");
        }
        return button;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        ViewParent viewParent = null;
        this.f70837d = View.inflate(getContext(), R.layout.p2p_payment_instrument_bottom_sheet, (ViewGroup) null);
        dialog.setContentView(this.f70837d);
        try {
            View view = this.f70837d;
            if (view == null) {
                k.a();
            }
            this.f70835b = (LottieAnimationView) view.findViewById(R.id.paymentInstrumentPayLoader);
            View findViewById = view.findViewById(R.id.paymentInstrumentPayButton);
            k.a((Object) findViewById, "rootView.findViewById(R.…ymentInstrumentPayButton)");
            this.f70836c = (Button) findViewById;
            List<? extends b.c> list = this.f70840g;
            Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (valueOf.intValue() > 1) {
                ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
                k.a((Object) imageView, "rootView.ivClose");
                imageView.setVisibility(0);
            } else {
                List<? extends b.c> list2 = this.f70840g;
                if (list2 == null || list2.size() != 1 || this.k) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.ivClose);
                    k.a((Object) imageView2, "rootView.ivClose");
                    imageView2.setVisibility(8);
                } else {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.ivClose);
                    k.a((Object) imageView3, "rootView.ivClose");
                    imageView3.setVisibility(0);
                }
            }
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.paymentInstrumentRecyclerView);
            k.a((Object) recyclerView, "rootView.paymentInstrumentRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f70834a, 1, false));
            this.f70838e = new net.one97.paytm.wallet.newdesign.universalp2p.a.a(this.f70834a, new a(this), this.f70840g, this.f70841h, this.k);
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.paymentInstrumentRecyclerView);
            k.a((Object) recyclerView2, "rootView.paymentInstrumentRecyclerView");
            recyclerView2.setAdapter(this.f70838e);
            Button button = this.f70836c;
            if (button == null) {
                k.a("payButton");
            }
            button.setOnClickListener(new b(this));
            ((ImageView) view.findViewById(R.id.ivClose)).setOnClickListener(new c(this));
        } catch (Exception unused) {
        }
        Context context = getContext();
        if (context != null) {
            int c2 = androidx.core.content.b.c(context, 17170445);
            View view2 = this.f70837d;
            if (view2 != null) {
                viewParent = view2.getParent();
            }
            if (viewParent != null) {
                ((View) viewParent).setBackgroundColor(c2);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.View");
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (this.f70842i) {
            return;
        }
        if (this.j) {
            net.one97.paytm.wallet.newdesign.c.b bVar = this.f70839f;
            if (bVar != null) {
                bVar.i();
                return;
            }
            return;
        }
        net.one97.paytm.wallet.newdesign.c.b bVar2 = this.f70839f;
        if (bVar2 != null) {
            bVar2.e();
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            onCreateDialog.setOnShowListener(new C1430d(onCreateDialog));
        }
        if (onCreateDialog == null) {
            k.a();
        }
        return onCreateDialog;
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.b.d$d  reason: collision with other inner class name */
    static final class C1430d implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Dialog f70846a;

        C1430d(Dialog dialog) {
            this.f70846a = dialog;
        }

        public final void onShow(DialogInterface dialogInterface) {
            FrameLayout frameLayout = (FrameLayout) this.f70846a.findViewById(R.id.design_bottom_sheet);
            if (frameLayout != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                k.a((Object) from, "BottomSheetBehavior.from<FrameLayout>(it)");
                from.setState(3);
            }
        }
    }

    public final void a(Context context, net.one97.paytm.wallet.newdesign.c.b bVar, List<? extends b.c> list, int i2, net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar2, boolean z, boolean z2) {
        k.c(context, "mContext");
        k.c(bVar, "paymentInstrumentBottomSheetClickListener");
        k.c(list, "paymentInstruments");
        k.c(bVar2, "universalP2PNetworkRequestManager");
        this.f70839f = bVar;
        this.f70840g = list;
        this.f70841h = i2;
        this.f70834a = context;
        this.m = bVar2;
        this.k = z;
        this.l = z2;
    }

    public static final class a implements a.C1449a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70843a;

        a(d dVar) {
            this.f70843a = dVar;
        }

        public final void a(boolean z) {
            this.f70843a.f70842i = false;
            this.f70843a.j = z;
            String str = null;
            if (!this.f70843a.j) {
                Button d2 = d.d(this.f70843a);
                Context e2 = this.f70843a.f70834a;
                if (e2 != null) {
                    str = e2.getString(R.string.pay_securely);
                }
                d2.setText(str);
            } else if (this.f70843a.l) {
                Button d3 = d.d(this.f70843a);
                Context e3 = this.f70843a.f70834a;
                if (e3 != null) {
                    str = e3.getString(R.string.p2p_upi_onboarding_reactivate);
                }
                d3.setText(str);
            } else {
                Button d4 = d.d(this.f70843a);
                Context e4 = this.f70843a.f70834a;
                if (e4 != null) {
                    str = e4.getString(R.string.p2p_upi_onboarding_add_account_pay);
                }
                d4.setText(str);
            }
        }

        public final void a(b.c cVar) {
            net.one97.paytm.wallet.newdesign.c.b f2;
            if (cVar != null && (f2 = this.f70843a.f70839f) != null) {
                f2.a(cVar);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70844a;

        b(d dVar) {
            this.f70844a = dVar;
        }

        public final void onClick(View view) {
            if (!this.f70844a.j) {
                net.one97.paytm.wallet.newdesign.c.b f2 = this.f70844a.f70839f;
                if (f2 != null) {
                    f2.d();
                }
            } else if (this.f70844a.l) {
                net.one97.paytm.wallet.newdesign.c.b f3 = this.f70844a.f70839f;
                if (f3 != null) {
                    f3.g();
                }
                this.f70844a.dismissAllowingStateLoss();
            } else {
                net.one97.paytm.wallet.newdesign.c.b f4 = this.f70844a.f70839f;
                if (f4 != null) {
                    f4.h();
                }
                this.f70844a.dismissAllowingStateLoss();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f70845a;

        c(d dVar) {
            this.f70845a = dVar;
        }

        public final void onClick(View view) {
            this.f70845a.dismissAllowingStateLoss();
        }
    }

    public final void a() {
        FragmentActivity activity;
        if (isAdded() && (activity = getActivity()) != null && !activity.isFinishing()) {
            this.f70842i = true;
            dismissAllowingStateLoss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
