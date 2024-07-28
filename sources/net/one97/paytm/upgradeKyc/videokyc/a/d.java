package net.one97.paytm.upgradeKyc.videokyc.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aj;
import androidx.lifecycle.z;
import com.bumptech.glide.f;
import com.google.android.material.snackbar.Snackbar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.upgradeKyc.checkappointment.FulfillmentReq;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.videokyc.b.d;

public final class d extends h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f66366b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.videokyc.b.d f66367a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f66368c;

    /* renamed from: d  reason: collision with root package name */
    private final String f66369d = "paytmmp://cst_flow?featuretype=all_topics&verticalId=11";

    /* renamed from: e  reason: collision with root package name */
    private b f66370e;

    /* renamed from: f  reason: collision with root package name */
    private e f66371f = new e(this);

    /* renamed from: g  reason: collision with root package name */
    private final z<HashMap<String, String>> f66372g = new c(this);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f66373h;

    public interface b {
        void f();

        void i();

        net.one97.paytm.upgradeKyc.videokyc.b.d l();
    }

    public final View a(int i2) {
        if (this.f66373h == null) {
            this.f66373h = new HashMap();
        }
        View view = (View) this.f66373h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f66373h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<HashMap<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66374a;

        c(d dVar) {
            this.f66374a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            HashMap hashMap = (HashMap) obj;
            d dVar = this.f66374a;
            k.a((Object) hashMap, "it");
            d.a(dVar, hashMap);
        }
    }

    public final net.one97.paytm.upgradeKyc.videokyc.b.d a() {
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66367a;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        return dVar;
    }

    public static final class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66376a;

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        e(d dVar) {
            this.f66376a = dVar;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            String str;
            k.c(adapterView, "parent");
            if (i2 >= 0) {
                if (this.f66376a.getContext() != null && (this.f66376a.getContext() instanceof UpgradeKycBaseActivity)) {
                    Context context = this.f66376a.getContext();
                    if (context != null) {
                        ((UpgradeKycBaseActivity) context).b("language_drop_down_clicked", "/kyc/video_kyc/start_vkyc");
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                    }
                }
                net.one97.paytm.upgradeKyc.videokyc.b.d a2 = this.f66376a.a();
                HashMap value = this.f66376a.a().f66475g.getValue();
                if (value != null) {
                    Spinner spinner = (Spinner) this.f66376a.a(R.id.spinner_lang);
                    k.a((Object) spinner, "spinner_lang");
                    str = (String) value.get(spinner.getAdapter().getItem(i2));
                } else {
                    str = null;
                }
                a2.f66474f = str;
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f66370e = (b) context;
            return;
        }
        throw new IllegalStateException(context + " must implement FragmentStartVideoKyc.InteractionListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_start_video_kyc, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        List<String> list;
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        b bVar = this.f66370e;
        if (bVar == null) {
            k.a("mHost");
        }
        this.f66367a = bVar.l();
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66367a;
        if (dVar == null) {
            k.a("sharedViewModel");
        }
        String str2 = null;
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(dVar), Dispatchers.getIO(), (CoroutineStart) null, new d.c(dVar, (kotlin.d.d) null), 2, (Object) null);
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar2 = this.f66367a;
        if (dVar2 == null) {
            k.a("sharedViewModel");
        }
        dVar2.f66475g.observe(getViewLifecycleOwner(), this.f66372g);
        View.OnClickListener onClickListener = this;
        ((TextView) a(R.id.tv_help)).setOnClickListener(onClickListener);
        ((Button) a(R.id.btn_continue)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(onClickListener);
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        String a2 = net.one97.paytm.upgradeKyc.helper.d.a("videoKycGif");
        com.bumptech.glide.e.a a3 = ((com.bumptech.glide.e.h) ((com.bumptech.glide.e.h) new com.bumptech.glide.e.h().f()).a(R.drawable.gif_placeholder)).a(f.HIGH);
        k.a((Object) a3, "RequestOptions()\n       … .priority(Priority.HIGH)");
        com.bumptech.glide.e.h hVar = (com.bumptech.glide.e.h) a3;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        com.bumptech.glide.b.a(activity).e().a(0.1f).a(a2).b((com.bumptech.glide.e.a<?>) hVar).a((ImageView) a(R.id.kyc_status_iv));
        net.one97.paytm.upgradeKyc.videokyc.b.d dVar3 = this.f66367a;
        if (dVar3 == null) {
            k.a("sharedViewModel");
        }
        if (k.a((Object) dVar3.p, (Object) "user_missed_appointment")) {
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar4 = this.f66367a;
            if (dVar4 == null) {
                k.a("sharedViewModel");
            }
            FulfillmentReq fulfillmentReq = dVar4.q;
            if (fulfillmentReq == null || (str = fulfillmentReq.dateString) == null) {
                list = null;
            } else {
                list = p.a((CharSequence) str, new String[]{AppConstants.COMMA});
            }
            if (list != null && (!list.isEmpty())) {
                TextView textView = (TextView) a(R.id.tv_missed_appointment_info);
                k.a((Object) textView, "tv_missed_appointment_info");
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.kyc_appointment_missed_text));
                sb.append(" ");
                sb.append(list.get(0));
                sb.append(AppConstants.COMMA);
                net.one97.paytm.upgradeKyc.videokyc.b.d dVar5 = this.f66367a;
                if (dVar5 == null) {
                    k.a("sharedViewModel");
                }
                FulfillmentReq fulfillmentReq2 = dVar5.q;
                if (fulfillmentReq2 != null) {
                    str2 = fulfillmentReq2.itemName;
                }
                sb.append(str2);
                textView.setText(sb.toString());
            }
            LinearLayout linearLayout = (LinearLayout) a(R.id.missed_appointment_view);
            k.a((Object) linearLayout, "missed_appointment_view");
            linearLayout.setVisibility(0);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btn_continue;
        if (valueOf != null && valueOf.intValue() == i2) {
            if (getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
                Context context = getContext();
                if (context != null) {
                    ((UpgradeKycBaseActivity) context).b("start_vkyc_clicked", "/kyc/video_kyc/start_vkyc");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            net.one97.paytm.upgradeKyc.videokyc.b.d dVar = this.f66367a;
            if (dVar == null) {
                k.a("sharedViewModel");
            }
            if (dVar.f66474f != null) {
                b bVar = this.f66370e;
                if (bVar == null) {
                    k.a("mHost");
                }
                bVar.f();
                return;
            }
            String string = getString(R.string.some_went_wrong);
            k.a((Object) string, "getString(R.string.some_went_wrong)");
            Snackbar.a((View) (ConstraintLayout) a(R.id.parent_view), (CharSequence) string, -1).c();
            return;
        }
        int i3 = R.id.tv_help;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
                Context context2 = getContext();
                if (context2 != null) {
                    ((UpgradeKycBaseActivity) context2).b("need_help_clicked ", "/kyc/video_kyc/start_vkyc");
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
                }
            }
            e.a aVar = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            net.one97.paytm.upgradeKyc.helper.f b2 = e.a.b();
            e.a aVar2 = net.one97.paytm.upgradeKyc.helper.e.f66028b;
            b2.a(e.a.b().a(), this.f66369d);
            return;
        }
        int i4 = R.id.iv_back_btn;
        if (valueOf != null && valueOf.intValue() == i4) {
            b bVar2 = this.f66370e;
            if (bVar2 == null) {
                k.a("mHost");
            }
            bVar2.i();
            return;
        }
        int i5 = R.id.kyc_status_iv;
        if (valueOf != null && valueOf.intValue() == i5 && getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
            Context context3 = getContext();
            if (context3 != null) {
                ((UpgradeKycBaseActivity) context3).b("video_play_clicked", "/kyc/video_kyc/start_vkyc");
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
        }
    }

    public final void onResume() {
        super.onResume();
        if (!this.f66368c) {
            this.f66368c = true;
            ((FrameLayout) a(R.id.your_aadhar_v)).postDelayed(new C1333d(this), 2000);
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.videokyc.a.d$d  reason: collision with other inner class name */
    static final class C1333d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f66375a;

        C1333d(d dVar) {
            this.f66375a = dVar;
        }

        public final void run() {
            if (this.f66375a.isAdded() && ((FrameLayout) this.f66375a.a(R.id.your_aadhar_v)) != null) {
                FrameLayout frameLayout = (FrameLayout) this.f66375a.a(R.id.your_aadhar_v);
                k.a((Object) frameLayout, "your_aadhar_v");
                frameLayout.setVisibility(8);
            }
        }
    }

    public static final /* synthetic */ void a(d dVar, HashMap hashMap) {
        FragmentActivity activity = dVar.getActivity();
        if (activity == null) {
            k.a();
        }
        Context context = activity;
        int i2 = R.layout.kyc_layout_spinner_item;
        Set keySet = hashMap.keySet();
        k.a((Object) keySet, "it.keys");
        Object[] array = keySet.toArray(new String[0]);
        if (array != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, i2, array);
            Spinner spinner = (Spinner) dVar.a(R.id.spinner_lang);
            k.a((Object) spinner, "spinner_lang");
            spinner.setAdapter(arrayAdapter);
            Spinner spinner2 = (Spinner) dVar.a(R.id.spinner_lang);
            k.a((Object) spinner2, "spinner_lang");
            spinner2.setOnItemSelectedListener(dVar.f66371f);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66373h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
