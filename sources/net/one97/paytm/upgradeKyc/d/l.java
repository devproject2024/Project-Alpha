package net.one97.paytm.upgradeKyc.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.helper.f;

public final class l extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65710a;

    private View a(int i2) {
        if (this.f65710a == null) {
            this.f65710a = new HashMap();
        }
        View view = (View) this.f65710a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65710a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        e.a aVar = e.f66028b;
        f b2 = e.a.b();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        b2.a("/kyc-wallet-upgrade/user-status", "kyc", context);
        return layoutInflater.inflate(R.layout.fragment_kyc_status, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("leadPostedDate")) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) a(R.id.details_collected_tv);
            k.a((Object) textView, "details_collected_tv");
            textView.setText(getString(R.string.collected_on, str));
        } else {
            TextView textView2 = (TextView) a(R.id.details_collected_tv);
            k.a((Object) textView2, "details_collected_tv");
            textView2.setVisibility(8);
        }
        Bundle arguments2 = getArguments();
        Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("screenId")) : null;
        if (valueOf != null && valueOf.intValue() == 13) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.e_status_iv);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            appCompatImageView.setImageDrawable(androidx.core.content.b.a((Context) activity, R.drawable.ic_timeline_pending));
            RoboTextView roboTextView = (RoboTextView) a(R.id.title_two_tv);
            k.a((Object) roboTextView, "title_two_tv");
            roboTextView.setText(getString(R.string.document_verificatin));
        } else if (valueOf != null && valueOf.intValue() == 14) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.e_status_iv);
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            appCompatImageView2.setImageDrawable(androidx.core.content.b.a((Context) activity2, R.drawable.ic_timeline_failed));
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.title_two_tv);
            k.a((Object) roboTextView2, "title_two_tv");
            roboTextView2.setText(getString(R.string.doc_verification_failed));
            TextView textView3 = (TextView) a(R.id.in_progress_tv);
            k.a((Object) textView3, "in_progress_tv");
            textView3.setText(getString(R.string.doc_rejected_reason));
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.sub_title_two_tv);
            k.a((Object) roboTextView3, "sub_title_two_tv");
            roboTextView3.setVisibility(8);
            Button button = (Button) a(R.id.apply_kyc_again_btn);
            k.a((Object) button, "apply_kyc_again_btn");
            button.setVisibility(0);
        }
        ((ConstraintLayout) a(R.id.need_help_lyt)).setOnClickListener(new a(this));
        ((Button) a(R.id.apply_kyc_again_btn)).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f65711a;

        a(l lVar) {
            this.f65711a = lVar;
        }

        public final void onClick(View view) {
            e.a aVar = e.f66028b;
            f b2 = e.a.b();
            Context context = this.f65711a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b2.a(context, "paytmmp://csttree?featuretype=cst_issue&verticalid=1000007&l1=1600221");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f65712a;

        b(l lVar) {
            this.f65712a = lVar;
        }

        public final void onClick(View view) {
            this.f65712a.startActivity(new Intent(this.f65712a.getActivity(), InPersonVerification.class));
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65710a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
