package net.one97.paytm.referral.b;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.referral.model.BonusDetail;
import net.one97.paytm.referral.model.RefereeInfo;
import net.one97.paytm.referral.model.ReferralData;
import net.one97.paytm.referral.model.ReferralMain;
import net.one97.paytm.vipcashback.R;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private View f20018a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.referral.d.a f20019b;

    /* renamed from: c  reason: collision with root package name */
    private ReferralData f20020c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f20021d;

    public final void onCreate(Bundle bundle) {
        ReferralData data;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(net.one97.paytm.referral.d.a.class);
            k.a((Object) a2, "ViewModelProviders.of(it…ralViewModel::class.java]");
            this.f20019b = (net.one97.paytm.referral.d.a) a2;
        }
        net.one97.paytm.referral.d.a aVar = this.f20019b;
        if (aVar == null) {
            k.a("mReferralViewModel");
        }
        ReferralMain value = aVar.f20030a.getValue();
        if (value != null && (data = value.getData()) != null) {
            this.f20020c = data;
        }
    }

    public final void setupDialog(Dialog dialog, int i2) {
        BonusDetail bonusDetail;
        BonusDetail bonusDetail2;
        ArrayList<RefereeInfo> referee_info;
        k.c(dialog, "dialog");
        super.setupDialog(dialog, i2);
        Integer num = null;
        View inflate = View.inflate(getContext(), R.layout.fragment_bottom_sheet, (ViewGroup) null);
        k.a((Object) inflate, "View.inflate(context, R.…gment_bottom_sheet, null)");
        this.f20018a = inflate;
        View view = this.f20018a;
        if (view == null) {
            k.a("mRootView");
        }
        dialog.setContentView(view);
        View view2 = this.f20018a;
        if (view2 == null) {
            k.a("mRootView");
        }
        View findViewById = view2.findViewById(R.id.cashback_amount);
        k.a((Object) findViewById, "mRootView.findViewById(R.id.cashback_amount)");
        TextView textView = (TextView) findViewById;
        View view3 = this.f20018a;
        if (view3 == null) {
            k.a("mRootView");
        }
        View findViewById2 = view3.findViewById(R.id.closeBottomSheet);
        k.a((Object) findViewById2, "mRootView.findViewById(R.id.closeBottomSheet)");
        ImageButton imageButton = (ImageButton) findViewById2;
        View view4 = this.f20018a;
        if (view4 == null) {
            k.a("mRootView");
        }
        View findViewById3 = view4.findViewById(R.id.rv_referee);
        k.a((Object) findViewById3, "mRootView.findViewById(R.id.rv_referee)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        ReferralData referralData = this.f20020c;
        if (referralData == null) {
            k.a("mReferralData");
        }
        ArrayList<BonusDetail> bonus_detail = referralData.getBonus_detail();
        if (!(bonus_detail == null || (bonusDetail2 = bonus_detail.get(0)) == null || (referee_info = bonusDetail2.getReferee_info()) == null)) {
            FragmentActivity activity = getActivity();
            recyclerView.setLayoutManager(new LinearLayoutManager(activity != null ? activity.getApplicationContext() : null));
            recyclerView.setAdapter(new net.one97.paytm.referral.a.a(referee_info));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FilterPriceSliderFragment.RUPEE_SYMBOL);
        ReferralData referralData2 = this.f20020c;
        if (referralData2 == null) {
            k.a("mReferralData");
        }
        ArrayList<BonusDetail> bonus_detail2 = referralData2.getBonus_detail();
        if (!(bonus_detail2 == null || (bonusDetail = bonus_detail2.get(0)) == null)) {
            num = bonusDetail.getTotal_bonus();
        }
        sb.append(num);
        textView.setText(sb.toString());
        imageButton.setOnClickListener(new C0352a(this));
    }

    /* renamed from: net.one97.paytm.referral.b.a$a  reason: collision with other inner class name */
    static final class C0352a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20022a;

        C0352a(a aVar) {
            this.f20022a = aVar;
        }

        public final void onClick(View view) {
            this.f20022a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20021d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
