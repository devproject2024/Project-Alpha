package net.one97.paytm.upgradeKyc.videokyc.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aj;
import androidx.lifecycle.z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.activity.b;
import net.one97.paytm.upgradeKyc.utils.m;
import net.one97.paytm.upgradeKyc.videokyc.b.c;

public final class h extends f implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66400a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static String f66401i = "VideoKYCChecklistSheetTag";

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.b.a f66402b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.videokyc.b.c f66403c;

    /* renamed from: d  reason: collision with root package name */
    private b f66404d;

    /* renamed from: e  reason: collision with root package name */
    private BottomSheetBehavior<?> f66405e;

    /* renamed from: f  reason: collision with root package name */
    private int f66406f = -1;

    /* renamed from: g  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<String>> f66407g = new d(this);

    /* renamed from: h  reason: collision with root package name */
    private c f66408h = new c(this);
    private HashMap j;

    public interface b {
        void e();
    }

    static final class d<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f66410a;

        d(h hVar) {
            this.f66410a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = i.f66412a[dVar.ordinal()];
                if (i2 == 1) {
                    net.one97.paytm.common.widgets.a.b(h.a(this.f66410a).s);
                    String str = (String) bVar.f66169b;
                    if (k.a((Object) str, (Object) b.d.AVERAGE.name())) {
                        if (this.f66410a.getContext() != null && (this.f66410a.getContext() instanceof UpgradeKycBaseActivity)) {
                            Context context = this.f66410a.getContext();
                            if (context != null) {
                                ((UpgradeKycBaseActivity) context).b("average_internet_detected", "/kyc/video_kyc/checklist");
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                            }
                        }
                        h.b(this.f66410a);
                        h.c(this.f66410a);
                    } else if (k.a((Object) str, (Object) b.d.ACCEPTABLE.name())) {
                        if (this.f66410a.getContext() != null && (this.f66410a.getContext() instanceof UpgradeKycBaseActivity)) {
                            Context context2 = this.f66410a.getContext();
                            if (context2 != null) {
                                ((UpgradeKycBaseActivity) context2).b("fast_internet_detected", "/kyc/video_kyc/checklist");
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                            }
                        }
                        h.b(this.f66410a);
                    } else {
                        if (this.f66410a.getContext() != null && (this.f66410a.getContext() instanceof UpgradeKycBaseActivity)) {
                            Context context3 = this.f66410a.getContext();
                            if (context3 != null) {
                                ((UpgradeKycBaseActivity) context3).b("slow_internet_detected", "/kyc/video_kyc/checklist");
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                            }
                        }
                        h.d(this.f66410a);
                    }
                } else if (i2 == 2) {
                    net.one97.paytm.common.widgets.a.a(h.a(this.f66410a).s);
                } else if (i2 == 3) {
                    net.one97.paytm.common.widgets.a.b(h.a(this.f66410a).s);
                    m.a aVar = m.f66342a;
                    Activity activity = this.f66410a.getActivity();
                    String string = this.f66410a.getString(R.string.some_went_wrong);
                    k.a((Object) string, "getString(R.string.some_went_wrong)");
                    k.c(string, "string");
                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                        Toast.makeText(activity, string, 0).show();
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upgradeKyc.b.a a(h hVar) {
        net.one97.paytm.upgradeKyc.b.a aVar = hVar.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class c extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f66409a;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        c(h hVar) {
            this.f66409a = hVar;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (i2 == 5) {
                this.f66409a.dismiss();
            }
        }
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f66411a;

        e(h hVar) {
            this.f66411a = hVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            h.a(this.f66411a, dialogInterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context, getTheme());
        aVar.setOnShowListener(new e(this));
        Window window = aVar.getWindow();
        if (window == null) {
            k.a();
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ViewDataBinding a2 = androidx.databinding.f.a(layoutInflater, R.layout.bottomsheet_video_kyc_checklist, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(…          false\n        )");
        this.f66402b = (net.one97.paytm.upgradeKyc.b.a) a2;
        net.one97.paytm.upgradeKyc.b.a aVar = this.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        return aVar.getRoot();
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66404d = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement VideoKYCChecklistSheet.InteractionListener");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f66403c = (net.one97.paytm.upgradeKyc.videokyc.b.c) net.one97.paytm.upgradeKyc.kycV3.b.a((Fragment) this, net.one97.paytm.upgradeKyc.videokyc.b.c.class);
        net.one97.paytm.upgradeKyc.videokyc.b.c cVar = this.f66403c;
        if (cVar == null) {
            k.a("viewModel");
        }
        cVar.f66466a.observe(getViewLifecycleOwner(), this.f66407g);
        net.one97.paytm.upgradeKyc.b.a aVar = this.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this;
        aVar.f65570b.setOnCheckedChangeListener(onCheckedChangeListener);
        net.one97.paytm.upgradeKyc.b.a aVar2 = this.f66402b;
        if (aVar2 == null) {
            k.a("binding");
        }
        aVar2.f65571c.setOnCheckedChangeListener(onCheckedChangeListener);
        net.one97.paytm.upgradeKyc.b.a aVar3 = this.f66402b;
        if (aVar3 == null) {
            k.a("binding");
        }
        View.OnClickListener onClickListener = this;
        aVar3.f65572d.setOnClickListener(onClickListener);
        net.one97.paytm.upgradeKyc.b.a aVar4 = this.f66402b;
        if (aVar4 == null) {
            k.a("binding");
        }
        aVar4.j.setOnClickListener(onClickListener);
        net.one97.paytm.upgradeKyc.b.a aVar5 = this.f66402b;
        if (aVar5 == null) {
            k.a("binding");
        }
        aVar5.f65569a.setOnClickListener(onClickListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCheckedChanged(android.widget.CompoundButton r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r9 = "binding.cbQuietPlace"
            java.lang.String r0 = "binding.cbWifi"
            java.lang.String r1 = "binding.cbDoc"
            java.lang.String r2 = "/kyc/video_kyc/checklist"
            java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity"
            java.lang.String r4 = "binding"
            if (r8 == 0) goto L_0x004a
            int r5 = r8.getId()     // Catch:{ Exception -> 0x0047 }
            net.one97.paytm.upgradeKyc.b.a r6 = r7.f66402b     // Catch:{ Exception -> 0x0047 }
            if (r6 != 0) goto L_0x0019
            kotlin.g.b.k.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0047 }
        L_0x0019:
            android.widget.CheckBox r6 = r6.f65570b     // Catch:{ Exception -> 0x0047 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x0047 }
            int r6 = r6.getId()     // Catch:{ Exception -> 0x0047 }
            if (r5 != r6) goto L_0x004a
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            boolean r8 = r8 instanceof net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x0041
            net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity r8 = (net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity) r8     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = "pan_ready_checkbox_selected"
            r8.b(r3, r2)     // Catch:{ Exception -> 0x0047 }
            goto L_0x00be
        L_0x0041:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0047 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x0047 }
            throw r8     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            goto L_0x00be
        L_0x004a:
            if (r8 == 0) goto L_0x0084
            int r5 = r8.getId()     // Catch:{ Exception -> 0x0047 }
            net.one97.paytm.upgradeKyc.b.a r6 = r7.f66402b     // Catch:{ Exception -> 0x0047 }
            if (r6 != 0) goto L_0x0057
            kotlin.g.b.k.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0047 }
        L_0x0057:
            android.widget.CheckBox r6 = r6.f65572d     // Catch:{ Exception -> 0x0047 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x0047 }
            int r6 = r6.getId()     // Catch:{ Exception -> 0x0047 }
            if (r5 != r6) goto L_0x0084
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            boolean r8 = r8 instanceof net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x007e
            net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity r8 = (net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity) r8     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = "Internet_ready_checkbox_selected"
            r8.b(r3, r2)     // Catch:{ Exception -> 0x0047 }
            goto L_0x00be
        L_0x007e:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0047 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x0047 }
            throw r8     // Catch:{ Exception -> 0x0047 }
        L_0x0084:
            if (r8 == 0) goto L_0x00be
            int r8 = r8.getId()     // Catch:{ Exception -> 0x0047 }
            net.one97.paytm.upgradeKyc.b.a r5 = r7.f66402b     // Catch:{ Exception -> 0x0047 }
            if (r5 != 0) goto L_0x0091
            kotlin.g.b.k.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0047 }
        L_0x0091:
            android.widget.CheckBox r5 = r5.f65571c     // Catch:{ Exception -> 0x0047 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)     // Catch:{ Exception -> 0x0047 }
            int r5 = r5.getId()     // Catch:{ Exception -> 0x0047 }
            if (r8 != r5) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            boolean r8 = r8 instanceof net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00be
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x0047 }
            if (r8 == 0) goto L_0x00b8
            net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity r8 = (net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity) r8     // Catch:{ Exception -> 0x0047 }
            java.lang.String r3 = "well_lit_ready_checkbox_selected"
            r8.b(r3, r2)     // Catch:{ Exception -> 0x0047 }
            goto L_0x00be
        L_0x00b8:
            kotlin.u r8 = new kotlin.u     // Catch:{ Exception -> 0x0047 }
            r8.<init>(r3)     // Catch:{ Exception -> 0x0047 }
            throw r8     // Catch:{ Exception -> 0x0047 }
        L_0x00be:
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x00c5
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00c5:
            android.widget.CheckBox r8 = r8.f65570b
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            boolean r8 = r8.isChecked()
            java.lang.String r1 = "binding.tvConfirmPts"
            if (r8 == 0) goto L_0x0116
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x00d9
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00d9:
            android.widget.CheckBox r8 = r8.f65571c
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0116
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x00eb
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00eb:
            android.widget.CheckBox r8 = r8.f65572d
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            boolean r8 = r8.isChecked()
            if (r8 == 0) goto L_0x0116
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x00fd
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00fd:
            android.widget.Button r8 = r8.f65569a
            int r9 = net.one97.paytm.upgradeKyc.R.drawable.bg_kyc_blue_btn
            r8.setBackgroundResource(r9)
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x010b
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x010b:
            android.widget.TextView r8 = r8.p
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            r9 = 8
            r8.setVisibility(r9)
            return
        L_0x0116:
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x011d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x011d:
            android.widget.Button r8 = r8.f65569a
            int r9 = net.one97.paytm.upgradeKyc.R.drawable.bg_kyc_disabled_blue
            r8.setBackgroundResource(r9)
            net.one97.paytm.upgradeKyc.b.a r8 = r7.f66402b
            if (r8 != 0) goto L_0x012b
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x012b:
            android.widget.TextView r8 = r8.p
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            r9 = 0
            r8.setVisibility(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.videokyc.a.h.onCheckedChanged(android.widget.CompoundButton, boolean):void");
    }

    public final void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            net.one97.paytm.upgradeKyc.b.a aVar = this.f66402b;
            if (aVar == null) {
                k.a("binding");
            }
            CheckBox checkBox = aVar.f65572d;
            k.a((Object) checkBox, "binding.cbWifi");
            if (id == checkBox.getId()) {
                net.one97.paytm.upgradeKyc.b.a aVar2 = this.f66402b;
                if (aVar2 == null) {
                    k.a("binding");
                }
                CheckBox checkBox2 = aVar2.f65572d;
                k.a((Object) checkBox2, "binding.cbWifi");
                if (checkBox2.isChecked()) {
                    net.one97.paytm.upgradeKyc.b.a aVar3 = this.f66402b;
                    if (aVar3 == null) {
                        k.a("binding");
                    }
                    CheckBox checkBox3 = aVar3.f65572d;
                    k.a((Object) checkBox3, "binding.cbWifi");
                    net.one97.paytm.upgradeKyc.b.a aVar4 = this.f66402b;
                    if (aVar4 == null) {
                        k.a("binding");
                    }
                    CheckBox checkBox4 = aVar4.f65572d;
                    k.a((Object) checkBox4, "binding.cbWifi");
                    checkBox3.setChecked(!checkBox4.isChecked());
                    net.one97.paytm.upgradeKyc.b.a aVar5 = this.f66402b;
                    if (aVar5 == null) {
                        k.a("binding");
                    }
                    TextView textView = aVar5.r;
                    k.a((Object) textView, "binding.tvWarning");
                    textView.setVisibility(8);
                    net.one97.paytm.upgradeKyc.b.a aVar6 = this.f66402b;
                    if (aVar6 == null) {
                        k.a("binding");
                    }
                    ImageView imageView = aVar6.k;
                    k.a((Object) imageView, "binding.ivNetworkException");
                    imageView.setVisibility(8);
                    net.one97.paytm.upgradeKyc.b.a aVar7 = this.f66402b;
                    if (aVar7 == null) {
                        k.a("binding");
                    }
                    TextView textView2 = aVar7.n;
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    textView2.setTextColor(androidx.core.content.b.c(activity, R.color.black));
                    net.one97.paytm.upgradeKyc.videokyc.b.c cVar = this.f66403c;
                    if (cVar == null) {
                        k.a("viewModel");
                    }
                    Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(cVar), Dispatchers.getIO(), (CoroutineStart) null, new c.a(cVar, (kotlin.d.d) null), 2, (Object) null);
                    return;
                }
                net.one97.paytm.upgradeKyc.b.a aVar8 = this.f66402b;
                if (aVar8 == null) {
                    k.a("binding");
                }
                TextView textView3 = aVar8.p;
                k.a((Object) textView3, "binding.tvConfirmPts");
                textView3.setVisibility(0);
                net.one97.paytm.upgradeKyc.b.a aVar9 = this.f66402b;
                if (aVar9 == null) {
                    k.a("binding");
                }
                aVar9.f65569a.setBackgroundResource(R.drawable.bg_kyc_disabled_blue);
                return;
            }
            net.one97.paytm.upgradeKyc.b.a aVar10 = this.f66402b;
            if (aVar10 == null) {
                k.a("binding");
            }
            ImageView imageView2 = aVar10.j;
            k.a((Object) imageView2, "binding.ivClose");
            if (id == imageView2.getId()) {
                dismiss();
                return;
            }
            net.one97.paytm.upgradeKyc.b.a aVar11 = this.f66402b;
            if (aVar11 == null) {
                k.a("binding");
            }
            Button button = aVar11.f65569a;
            k.a((Object) button, "binding.btnProceed");
            if (id == button.getId()) {
                if (getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
                    Context context = getContext();
                    if (context != null) {
                        ((UpgradeKycBaseActivity) context).b("proceed_button_clicked", "/kyc/video_kyc/checklist");
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                    }
                }
                if (this.f66406f == -1) {
                    net.one97.paytm.upgradeKyc.b.a aVar12 = this.f66402b;
                    if (aVar12 == null) {
                        k.a("binding");
                    }
                    CheckBox checkBox5 = aVar12.f65570b;
                    k.a((Object) checkBox5, "binding.cbDoc");
                    if (checkBox5.isChecked()) {
                        net.one97.paytm.upgradeKyc.b.a aVar13 = this.f66402b;
                        if (aVar13 == null) {
                            k.a("binding");
                        }
                        CheckBox checkBox6 = aVar13.f65571c;
                        k.a((Object) checkBox6, "binding.cbQuietPlace");
                        if (checkBox6.isChecked()) {
                            net.one97.paytm.upgradeKyc.b.a aVar14 = this.f66402b;
                            if (aVar14 == null) {
                                k.a("binding");
                            }
                            CheckBox checkBox7 = aVar14.f65572d;
                            k.a((Object) checkBox7, "binding.cbWifi");
                            if (checkBox7.isChecked()) {
                                net.one97.paytm.upgradeKyc.b.a aVar15 = this.f66402b;
                                if (aVar15 == null) {
                                    k.a("binding");
                                }
                                CheckBox checkBox8 = aVar15.f65572d;
                                k.a((Object) checkBox8, "binding.cbWifi");
                                checkBox8.setVisibility(8);
                                net.one97.paytm.upgradeKyc.b.a aVar16 = this.f66402b;
                                if (aVar16 == null) {
                                    k.a("binding");
                                }
                                CheckBox checkBox9 = aVar16.f65570b;
                                k.a((Object) checkBox9, "binding.cbDoc");
                                checkBox9.setVisibility(8);
                                net.one97.paytm.upgradeKyc.b.a aVar17 = this.f66402b;
                                if (aVar17 == null) {
                                    k.a("binding");
                                }
                                CheckBox checkBox10 = aVar17.f65571c;
                                k.a((Object) checkBox10, "binding.cbQuietPlace");
                                checkBox10.setVisibility(8);
                                net.one97.paytm.upgradeKyc.b.a aVar18 = this.f66402b;
                                if (aVar18 == null) {
                                    k.a("binding");
                                }
                                TextView textView4 = aVar18.m;
                                k.a((Object) textView4, "binding.tv1");
                                textView4.setText(getString(R.string.kyc_dont_refresh));
                                net.one97.paytm.upgradeKyc.b.a aVar19 = this.f66402b;
                                if (aVar19 == null) {
                                    k.a("binding");
                                }
                                TextView textView5 = aVar19.n;
                                k.a((Object) textView5, "binding.tv2");
                                textView5.setText(getString(R.string.kyc_dont_open_other_apps));
                                net.one97.paytm.upgradeKyc.b.a aVar20 = this.f66402b;
                                if (aVar20 == null) {
                                    k.a("binding");
                                }
                                TextView textView6 = aVar20.o;
                                k.a((Object) textView6, "binding.tv3");
                                textView6.setText(getString(R.string.kyc_if_disconnects));
                                net.one97.paytm.upgradeKyc.b.a aVar21 = this.f66402b;
                                if (aVar21 == null) {
                                    k.a("binding");
                                }
                                TextView textView7 = aVar21.q;
                                k.a((Object) textView7, "binding.tvHeading");
                                textView7.setText(getString(R.string.kyc_for_better_exp));
                                net.one97.paytm.upgradeKyc.b.a aVar22 = this.f66402b;
                                if (aVar22 == null) {
                                    k.a("binding");
                                }
                                Button button2 = aVar22.f65569a;
                                k.a((Object) button2, "binding.btnProceed");
                                button2.setText(getString(R.string.kyc_continue_with_v_kyc));
                                net.one97.paytm.upgradeKyc.b.a aVar23 = this.f66402b;
                                if (aVar23 == null) {
                                    k.a("binding");
                                }
                                aVar23.f65575g.setImageResource(R.drawable.kyc_dont_refresh);
                                net.one97.paytm.upgradeKyc.b.a aVar24 = this.f66402b;
                                if (aVar24 == null) {
                                    k.a("binding");
                                }
                                aVar24.f65576h.setImageResource(R.drawable.kyc_dont_open_other_apps);
                                net.one97.paytm.upgradeKyc.b.a aVar25 = this.f66402b;
                                if (aVar25 == null) {
                                    k.a("binding");
                                }
                                aVar25.f65577i.setImageResource(R.drawable.kyc_callback);
                                this.f66406f = 1;
                                return;
                            }
                        }
                    }
                }
                if (this.f66406f == 1) {
                    b bVar = this.f66404d;
                    if (bVar == null) {
                        k.a("mHost");
                    }
                    bVar.e();
                    dismiss();
                }
            }
        }
    }

    public static final /* synthetic */ void a(h hVar, DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (frameLayout != null) {
                frameLayout.setBackground(new ColorDrawable(0));
            }
            hVar.f66405e = frameLayout != null ? BottomSheetBehavior.from(frameLayout) : null;
            BottomSheetBehavior<?> bottomSheetBehavior = hVar.f66405e;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(3);
            }
            BottomSheetBehavior<?> bottomSheetBehavior2 = hVar.f66405e;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.setBottomSheetCallback(hVar.f66408h);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public static final /* synthetic */ void b(h hVar) {
        net.one97.paytm.upgradeKyc.b.a aVar = hVar.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        CheckBox checkBox = aVar.f65572d;
        k.a((Object) checkBox, "binding.cbWifi");
        checkBox.setChecked(true);
        net.one97.paytm.upgradeKyc.b.a aVar2 = hVar.f66402b;
        if (aVar2 == null) {
            k.a("binding");
        }
        hVar.onCheckedChanged(aVar2.f65572d, true);
    }

    public static final /* synthetic */ void c(h hVar) {
        net.one97.paytm.upgradeKyc.b.a aVar = hVar.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        TextView textView = aVar.r;
        k.a((Object) textView, "binding.tvWarning");
        textView.setVisibility(0);
        net.one97.paytm.upgradeKyc.b.a aVar2 = hVar.f66402b;
        if (aVar2 == null) {
            k.a("binding");
        }
        TextView textView2 = aVar2.r;
        k.a((Object) textView2, "binding.tvWarning");
        textView2.setText(hVar.getString(R.string.kyc_avg_internet_warning));
    }

    public static final /* synthetic */ void d(h hVar) {
        net.one97.paytm.upgradeKyc.b.a aVar = hVar.f66402b;
        if (aVar == null) {
            k.a("binding");
        }
        TextView textView = aVar.n;
        FragmentActivity activity = hVar.getActivity();
        if (activity == null) {
            k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_FF9D00));
        net.one97.paytm.upgradeKyc.b.a aVar2 = hVar.f66402b;
        if (aVar2 == null) {
            k.a("binding");
        }
        TextView textView2 = aVar2.r;
        k.a((Object) textView2, "binding.tvWarning");
        textView2.setVisibility(0);
        net.one97.paytm.upgradeKyc.b.a aVar3 = hVar.f66402b;
        if (aVar3 == null) {
            k.a("binding");
        }
        TextView textView3 = aVar3.r;
        k.a((Object) textView3, "binding.tvWarning");
        textView3.setText(hVar.getString(R.string.kyc_low_internet_warning));
        net.one97.paytm.upgradeKyc.b.a aVar4 = hVar.f66402b;
        if (aVar4 == null) {
            k.a("binding");
        }
        ImageView imageView = aVar4.k;
        k.a((Object) imageView, "binding.ivNetworkException");
        imageView.setVisibility(0);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
