package net.one97.paytm.wallet.newdesign.postcard;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.c;
import net.one97.paytm.wallet.newdesign.postcard.b.e;

public class MyPostcardAnimationActivity extends PaytmActivity implements c.a {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f71137a;

    /* renamed from: b  reason: collision with root package name */
    private c f71138b;

    /* renamed from: c  reason: collision with root package name */
    private IJRDataModel f71139c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f71140d;

    /* renamed from: e  reason: collision with root package name */
    private String f71141e;

    /* renamed from: f  reason: collision with root package name */
    private d f71142f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(12);
        setContentView(R.layout.activity_my_postcard_animation);
        getSupportActionBar().f();
        if (this.f71138b == null) {
            this.f71138b = new c();
            if (getIntent() != null) {
                this.f71140d = getIntent().getBooleanExtra("from_deep_link", false);
                this.f71141e = getIntent().getStringExtra("lifafa_key");
                this.f71139c = (IJRDataModel) getIntent().getSerializableExtra("data");
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("data", this.f71139c);
                bundle2.putBoolean("from_deep_link", this.f71140d);
                bundle2.putString("lifafa_key", this.f71141e);
                this.f71138b.setArguments(bundle2);
                c cVar = this.f71138b;
                try {
                    if (this.f71137a == null || cVar == null || cVar != this.f71137a) {
                        q a2 = getSupportFragmentManager().a();
                        a2.b(R.id.postcardfragments, cVar, cVar.getClass().getSimpleName());
                        a2.a(cVar.getClass().getSimpleName());
                        a2.c();
                        this.f71137a = cVar;
                    }
                } catch (Exception e2) {
                    com.paytm.utility.q.d(String.valueOf(e2));
                }
            }
        }
        this.f71142f = d.a((Context) this);
    }

    public final void a(ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse) {
        Bundle bundle = new Bundle();
        e eVar = new e();
        bundle.putSerializable("data", receivedLifafaDetailsResponse);
        bundle.putBoolean("first_time", true);
        eVar.setArguments(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            a aVar = new a();
            AutoTransition autoTransition = new AutoTransition();
            this.f71138b.setSharedElementReturnTransition(aVar);
            this.f71138b.setExitTransition(autoTransition);
            eVar.setSharedElementEnterTransition(aVar);
            eVar.setEnterTransition(autoTransition);
            q b2 = getSupportFragmentManager().a().b(R.id.postcardfragments, eVar, (String) null);
            getSupportFragmentManager().a().a(e.class.getSimpleName());
            b2.c();
            return;
        }
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.postcardfragments, eVar, eVar.getClass().getSimpleName());
        int i2 = R.anim.envolope_zoom_out_anim;
        a2.a(i2, i2);
        a2.a(e.class.getSimpleName());
        a2.c();
    }

    public void onBackPressed() {
        finish();
    }

    public class a extends TransitionSet {
        public a() {
            setOrdering(0);
            addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform());
            setInterpolator(new DecelerateInterpolator());
            setDuration(400);
        }
    }
}
