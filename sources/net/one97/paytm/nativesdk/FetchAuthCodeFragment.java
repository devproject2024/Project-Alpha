package net.one97.paytm.nativesdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paytm_finance.R;

public final class FetchAuthCodeFragment extends f {
    private final String TAG;
    private HashMap _$_findViewCache;
    private View mView;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public FetchAuthCodeFragment() {
        String simpleName = FetchAuthCodeFragment.class.getSimpleName();
        k.a((Object) simpleName, "FetchAuthCodeFragment::class.java.simpleName");
        this.TAG = simpleName;
    }

    public final void show(Context context) {
        k.c(context, "context");
        if (context instanceof AppCompatActivity) {
            show(((AppCompatActivity) context).getSupportFragmentManager(), this.TAG);
        } else if (context instanceof FragmentActivity) {
            show(((FragmentActivity) context).getSupportFragmentManager(), this.TAG);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.bs_fragment_fetch_auth_code, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…h_code, container, false)");
        this.mView = inflate;
        setCancelable(false);
        View view = this.mView;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initView();
    }

    private final void initView() {
        String str = null;
        if (a.q(getContext()) != null) {
            TextView textView = (TextView) _$_findCachedViewById(net.one97.paytm.R.id.loading_tv);
            k.a((Object) textView, "loading_tv");
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.custom_sdk_fetch_auth_msg);
            }
            textView.setText(str);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(net.one97.paytm.R.id.lottie_progress_bar);
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setAnimation("Payments-Loader.json");
                lottieAnimationView.setRepeatCount(-1);
                lottieAnimationView.playAnimation();
            }
            new Handler().postDelayed(new FetchAuthCodeFragment$initView$2(this), 3000);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(net.one97.paytm.R.id.loading_tv);
            k.a((Object) textView2, "loading_tv");
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.custom_sdk_fetch_auth_logged_out_msg);
            }
            textView2.setText(str);
            new Handler().postDelayed(new FetchAuthCodeFragment$initView$3(this), 2000);
        }
        ((ImageView) _$_findCachedViewById(net.one97.paytm.R.id.iv_close_arrow)).setOnClickListener(new FetchAuthCodeFragment$initView$4(this));
    }
}
