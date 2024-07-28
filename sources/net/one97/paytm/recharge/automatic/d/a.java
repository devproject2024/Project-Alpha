package net.one97.paytm.recharge.automatic.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.Serializable;
import java.util.List;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.a.b;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.automatic.b.a.j;
import net.one97.paytm.recharge.b.o;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionManageActivity;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class a extends h implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f60264a;

    /* renamed from: b  reason: collision with root package name */
    private o f60265b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRAutomaticSubscriptionItemModel> f60266c;

    /* renamed from: d  reason: collision with root package name */
    private int f60267d;

    /* renamed from: e  reason: collision with root package name */
    private j f60268e;

    /* renamed from: f  reason: collision with root package name */
    private ai f60269f;

    public static Fragment a(List<CJRAutomaticSubscriptionItemModel> list, CJRItem cJRItem, ai aiVar) {
        if (list == null || list.size() == 0) {
            throw new NullPointerException();
        }
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("autoPayList", (Serializable) list);
        if (cJRItem != null) {
            bundle.putSerializable("item", cJRItem);
        }
        aVar.setArguments(bundle);
        aVar.f60269f = aiVar;
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f60265b = (o) f.a(layoutInflater, R.layout.fragment_utility_automatic_list, viewGroup, false);
        return this.f60265b.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f60266c = (List) getArguments().getSerializable("autoPayList");
        this.f60265b.f60365a.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f60265b.f60365a.setNestedScrollingEnabled(false);
        this.f60265b.f60365a.setAdapter(new b(getContext(), this.f60266c, this));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 239) {
            this.f60268e = (j) intent.getSerializableExtra("statusCode");
            this.f60267d = intent.getIntExtra("extra_intent_item_position", this.f60267d);
            a((CJRAutomaticSubscriptionItemModel) intent.getSerializableExtra("selected_subscription"));
        } else if (i2 == 204 && i3 == -1 && intent != null && intent.getBooleanExtra("is_refresh_needed", false)) {
            this.f60268e = j.ENABLED;
            this.f60267d = intent.getIntExtra("key_position", this.f60267d);
            CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) new com.google.gsonhtcfix.f().a(new com.google.gsonhtcfix.f().a((Object) (CJRAutomaticSubscriptionItemModel) intent.getSerializableExtra("selected_automatic_subscribed_item")), CJRAutomaticSubscriptionItemModel.class);
            if (intent.getBooleanExtra("key_is_delete_automatic", false)) {
                if (getActivity() != null) {
                    h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                    View a2 = h.a.a((Activity) getActivity());
                    h.a aVar2 = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                    h.a.a(a2);
                }
                this.f60268e = j.DELETED;
            }
            a(cJRAutomaticSubscriptionItemModel);
        }
    }

    private void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        RecyclerView.a adapter = this.f60265b.f60365a.getAdapter();
        int i2 = AnonymousClass1.f60270a[this.f60268e.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f60266c.set(this.f60267d, cJRAutomaticSubscriptionItemModel);
            adapter.notifyItemChanged(this.f60267d);
        } else if (i2 == 3) {
            if (!(this.f60264a == null || getContext() == null)) {
                View view = new View(getContext());
                view.setTag(j.DELETED);
                this.f60264a.onClick(view);
            }
            this.f60266c.remove(this.f60267d);
            adapter.notifyItemRemoved(this.f60267d);
            if (this.f60266c.isEmpty()) {
                ai aiVar = this.f60269f;
                if (aiVar != null) {
                    d dVar = d.f64967a;
                    aiVar.a_("", (IJRPaytmDataModel) null, d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED));
                } else if (getActivity() instanceof ai) {
                    CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = new CJRAutomaticSubscriptionListModel();
                    d dVar2 = d.f64967a;
                    ((ai) getActivity()).a_("", cJRAutomaticSubscriptionListModel, d.a(ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS, ERROR_TYPE.UNDEFINED));
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.automatic.d.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f60270a = new int[j.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.recharge.automatic.b.a.j[] r0 = net.one97.paytm.recharge.automatic.b.a.j.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60270a = r0
                int[] r0 = f60270a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.recharge.automatic.b.a.j r1 = net.one97.paytm.recharge.automatic.b.a.j.ENABLED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f60270a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.recharge.automatic.b.a.j r1 = net.one97.paytm.recharge.automatic.b.a.j.DISABLED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f60270a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.recharge.automatic.b.a.j r1 = net.one97.paytm.recharge.automatic.b.a.j.DELETED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.automatic.d.a.AnonymousClass1.<clinit>():void");
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        if (i2 == this.f60266c.size()) {
            net.one97.paytm.recharge.widgets.c.b.a(new kotlin.g.a.a() {
                public final Object invoke() {
                    return a.this.a();
                }
            });
            az azVar = az.f61525a;
            if (az.c(getContext())) {
                az azVar2 = az.f61525a;
                az.i(getContext());
                return;
            }
            startActivity(new Intent(getContext(), AJRAutomaticAddNewBillActivity.class));
            return;
        }
        this.f60267d = i2;
        CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel = (CJRAutomaticSubscriptionItemModel) new com.google.gsonhtcfix.f().a(new com.google.gsonhtcfix.f().a((Object) this.f60266c.get(this.f60267d)), CJRAutomaticSubscriptionItemModel.class);
        az azVar3 = az.f61525a;
        if (az.c(getContext())) {
            az azVar4 = az.f61525a;
            az.a(getContext(), cJRAutomaticSubscriptionItemModel.getSubscriptionId());
            return;
        }
        try {
            startActivityForResult(new Intent(getContext(), AJRAutomaticSubscriptionManageActivity.class).putExtra("selected_automatic_subscribed_item", cJRAutomaticSubscriptionItemModel).putExtra("key_position", this.f60267d), CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a() {
        CJRItem cJRItem;
        String str;
        if (getArguments() == null || (cJRItem = (CJRItem) getArguments().getSerializable("item")) == null) {
            cJRItem = null;
        }
        if (cJRItem != null) {
            String uRLType = cJRItem.getURLType();
            boolean z = true;
            if (TextUtils.isEmpty(uRLType) || (!"mobile-prepaid".equalsIgnoreCase(uRLType) && !"mobile-postpaid".equalsIgnoreCase(uRLType))) {
                z = false;
            }
            if (z && getActivity() != null) {
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                FragmentActivity activity = getActivity();
                String uRLType2 = cJRItem.getURLType();
                if ("mobile-prepaid".equalsIgnoreCase(uRLType2)) {
                    str = "mobile_prepaid";
                } else {
                    str = "mobile-postpaid".equalsIgnoreCase(uRLType2) ? "mobile_postpaid" : "";
                }
                net.one97.paytm.recharge.di.helper.b.a((Context) activity, str, "add_new_automatic_clicked", "");
            }
        }
        return null;
    }
}
