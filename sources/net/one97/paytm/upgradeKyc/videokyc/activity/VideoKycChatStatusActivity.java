package net.one97.paytm.upgradeKyc.videokyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.b;

public final class VideoKycChatStatusActivity extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f66442a;

    /* renamed from: b  reason: collision with root package name */
    private final String f66443b = "paytmmp://payment_bank?featuretype=bank_landing";

    /* renamed from: d  reason: collision with root package name */
    private HashMap f66444d;

    public final View a(int i2) {
        if (this.f66444d == null) {
            this.f66444d = new HashMap();
        }
        View view = (View) this.f66444d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66444d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.iv_back_btn)).setOnClickListener(onClickListener);
        ((Button) a(R.id.btn_ok)).setOnClickListener(onClickListener);
        ((ImageView) a(R.id.iv_bank)).setOnClickListener(onClickListener);
        ((AppCompatImageView) a(R.id.iv_open_bank)).setOnClickListener(onClickListener);
        ((TextView) a(R.id.tv_open_bank_acc)).setOnClickListener(onClickListener);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null) {
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                Bundle extras = intent2.getExtras();
                if (extras == null) {
                    k.a();
                }
                if (extras.containsKey("video_kyc_status")) {
                    Intent intent3 = getIntent();
                    k.a((Object) intent3, "intent");
                    Bundle extras2 = intent3.getExtras();
                    if (extras2 == null) {
                        k.a();
                    }
                    this.f66442a = extras2.getString("video_kyc_status");
                    String str = this.f66442a;
                    if (str != null && str.hashCode() == -1281977283 && str.equals("failed")) {
                        TextView textView = (TextView) a(R.id.check_kyc_tv);
                        k.a((Object) textView, "check_kyc_tv");
                        b.a((View) textView);
                        TextView textView2 = (TextView) a(R.id.submitted);
                        k.a((Object) textView2, "submitted");
                        b.a((View) textView2);
                        Group group = (Group) a(R.id.group_submitted);
                        k.a((Object) group, "group_submitted");
                        b.a((View) group);
                        TextView textView3 = (TextView) a(R.id.video_kyc_tv);
                        k.a((Object) textView3, "video_kyc_tv");
                        textView3.setText(getString(R.string.video_kyc_could_not));
                        TextView textView4 = (TextView) a(R.id.post_doc_tv);
                        k.a((Object) textView4, "post_doc_tv");
                        textView4.setText(getString(R.string.video_kyc_you_can_retry));
                        ((ImageView) a(R.id.submitted_iv)).setImageResource(R.drawable.ic_oops_mark);
                    }
                }
            }
        }
    }

    public final void onBackPressed() {
        e.a aVar = e.f66028b;
        e.a.b().a((Activity) this);
    }

    public final int a() {
        return R.layout.activity_video_kyc_submitted;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iv_back_btn;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.btn_ok;
            if (valueOf == null || valueOf.intValue() != i3) {
                int i4 = R.id.iv_bank;
                if (valueOf == null || valueOf.intValue() != i4) {
                    int i5 = R.id.iv_open_bank;
                    if (valueOf == null || valueOf.intValue() != i5) {
                        int i6 = R.id.tv_open_bank_acc;
                        if (valueOf == null || valueOf.intValue() != i6) {
                            return;
                        }
                    }
                }
                b("success_openSA", "/kyc/video_kyc/vkyv_success");
                e.a aVar = e.f66028b;
                e.a.b().a((Context) this, this.f66443b);
                return;
            }
        }
        if (TextUtils.isEmpty(this.f66442a) || !p.a(this.f66442a, "failed", true)) {
            b("success_ok_clicked", "/kyc/video_kyc/vkyv_success");
        } else {
            b("reject_ok_clicked", "/kyc/video_kyc/vkyv_reject");
        }
        e.a aVar2 = e.f66028b;
        e.a.b().a((Activity) this);
    }

    public final void onDestroy() {
        super.onDestroy();
        if (TextUtils.isEmpty(this.f66442a) || !p.a(this.f66442a, "failed", true)) {
            b("success_close", "/kyc/video_kyc/vkyv_success");
        } else {
            b("reject_close", "/kyc/video_kyc/vkyv_reject");
        }
    }
}
