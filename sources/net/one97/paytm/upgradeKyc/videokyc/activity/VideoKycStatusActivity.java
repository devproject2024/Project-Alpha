package net.one97.paytm.upgradeKyc.videokyc.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.helper.f;

public final class VideoKycStatusActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f66445a = "paytmmp://cst_flow?featuretype=all_topics&verticalId=11";

    /* renamed from: b  reason: collision with root package name */
    private HashMap f66446b;

    public final View a(int i2) {
        if (this.f66446b == null) {
            this.f66446b = new HashMap();
        }
        View view = (View) this.f66446b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66446b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((ImageView) a(R.id.iv_need_help)).setOnClickListener(new a(this));
        ((TextView) a(R.id.tv_need_help)).setOnClickListener(new b(this));
        ((AppCompatImageView) a(R.id.iv_forward_btn)).setOnClickListener(new c(this));
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(new d(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycStatusActivity f66447a;

        a(VideoKycStatusActivity videoKycStatusActivity) {
            this.f66447a = videoKycStatusActivity;
        }

        public final void onClick(View view) {
            VideoKycStatusActivity.a(this.f66447a);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycStatusActivity f66448a;

        b(VideoKycStatusActivity videoKycStatusActivity) {
            this.f66448a = videoKycStatusActivity;
        }

        public final void onClick(View view) {
            VideoKycStatusActivity.a(this.f66448a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycStatusActivity f66449a;

        c(VideoKycStatusActivity videoKycStatusActivity) {
            this.f66449a = videoKycStatusActivity;
        }

        public final void onClick(View view) {
            VideoKycStatusActivity.a(this.f66449a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VideoKycStatusActivity f66450a;

        d(VideoKycStatusActivity videoKycStatusActivity) {
            this.f66450a = videoKycStatusActivity;
        }

        public final void onClick(View view) {
            this.f66450a.onBackPressed();
        }
    }

    public final int a() {
        return R.layout.activity_video_kyc_lead_status;
    }

    public static final /* synthetic */ void a(VideoKycStatusActivity videoKycStatusActivity) {
        e.a aVar = e.f66028b;
        f b2 = e.a.b();
        e.a aVar2 = e.f66028b;
        b2.a(e.a.b().a(), videoKycStatusActivity.f66445a);
    }
}
