package com.paytmmall.clpartifact.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.paytm.ads.PaytmAdView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.AdSdkUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.upi.util.UpiConstants;

public final class InterstetialActivity extends PaytmActivity implements View.OnTouchListener {
    /* access modifiers changed from: private */
    public final String DEEPLINK = "paytmmp";
    /* access modifiers changed from: private */
    public final String HTTP = "http";
    private final int MIN_DISTANCE = 100;
    private HashMap _$_findViewCache;
    private float downX;
    private float downY;
    private float upX;
    private float upY;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getMIN_DISTANCE() {
        return this.MIN_DISTANCE;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra(CLPConstants.IS_BG_ACTIVE, false)) {
            setTheme(R.style.SFSBackGroundAdTheme);
        }
        setContentView(R.layout.activity_interstetial);
        View findViewById = findViewById(R.id.ivAdvertisement);
        k.a((Object) findViewById, "findViewById(R.id.ivAdvertisement)");
        ((ImageView) findViewById).setOnTouchListener(this);
        initViews();
    }

    private final void initViews() {
        if (getIntent().hasExtra(CLPConstants.ISV_AD_ITEM)) {
            x.e eVar = new x.e();
            Serializable serializableExtra = getIntent().getSerializableExtra(CLPConstants.ISV_AD_ITEM);
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(new InterstetialActivity$initViews$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key))), (f) null, (CoroutineStart) null, new InterstetialActivity$initViews$1(this, eVar, serializableExtra, (d) null), 3, (Object) null);
            } catch (VerifyError unused2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setAddSDK(CJRHomePageItem cJRHomePageItem, PaytmAdView paytmAdView) {
        if ((cJRHomePageItem != null ? cJRHomePageItem.getDisplaymetadata() : null) != null && cJRHomePageItem.getDisplaymetadata().getMmetadata() != null) {
            String str = AdSdkUtils.getrequestid(this);
            k.a((Object) str, "AdSdkUtils.getrequestid(this)");
            AdSdkUtils.adsdkSetAdsParams(paytmAdView, cJRHomePageItem.getDisplaymetadata().getMmetadata(), str + cJRHomePageItem.getItemID());
        }
    }

    /* access modifiers changed from: private */
    public final Intent getTargetIntent(String str) {
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra(UpiConstants.FROM, "");
        intent.putExtra("Maintenance", false);
        intent.putExtra("maintaince_error_503", false);
        intent.putExtra("Close", false);
        intent.putExtra("alert_title", "");
        intent.putExtra("alert_message", "");
        return intent;
    }

    /* access modifiers changed from: private */
    public final Item getItem(String str, CJRHomePageItem cJRHomePageItem) {
        Item item = new Item();
        item.setUrl(str);
        item.setUrlType(cJRHomePageItem != null ? cJRHomePageItem.getURLType() : null);
        return item;
    }

    public final void onBackPressed() {
        super.onBackPressed();
        if (isFinishing()) {
            int i2 = R.anim.sf_fade_out;
            overridePendingTransition(i2, i2);
        }
    }

    private final void hidePopUp() {
        PaytmAdView paytmAdView = (PaytmAdView) _$_findCachedViewById(R.id.ivAdvertisement);
        k.a((Object) paytmAdView, "ivAdvertisement");
        PaytmAdView paytmAdView2 = (PaytmAdView) _$_findCachedViewById(R.id.ivAdvertisement);
        k.a((Object) paytmAdView2, "ivAdvertisement");
        translateView(paytmAdView, (float) (paytmAdView2.getMeasuredHeight() * 2), new AccelerateInterpolator(2.0f));
    }

    private final void translateView(View view, float f2, Interpolator interpolator) {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivClose);
        k.a((Object) imageView, "ivClose");
        imageView.setVisibility(8);
        view.animate().translationY(f2).setInterpolator(interpolator).setDuration(500).start();
        new Handler().postDelayed(new InterstetialActivity$translateView$1(this), 600);
    }

    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            this.upX = motionEvent.getX();
            this.upY = motionEvent.getY();
            float f2 = this.downY - this.upY;
            float f3 = this.downX - this.upX;
            if (f2 < 0.0f) {
                hidePopUp();
            } else if ((Math.abs(f2) == 0.0f || Math.abs(f3) == 0.0f) && view != null) {
                view.performClick();
            }
        }
        return false;
    }
}
