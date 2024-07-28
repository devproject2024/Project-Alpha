package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.MerchantPayOption;
import net.one97.paytm.nativesdk.common.model.ResultInfo;
import net.one97.paytm.nativesdk.databinding.NativeInstrumentLoadingSheetBinding;
import net.one97.paytm.nativesdk.paymethods.listeners.FetchPayInstrumentsListener;
import net.one97.paytm.nativesdk.paymethods.listeners.OnBottomSheetChangeListener;
import net.one97.paytm.nativesdk.paymethods.viewmodel.LoadingInstrumentSheetViewModel;

public final class LoadingInstrumentFragment extends h implements FetchPayInstrumentsListener {
    private HashMap _$_findViewCache;
    private OnBottomSheetChangeListener mBottomSheetChangeListener;
    private LottieAnimationView mFetchPayMethodsProgress;
    private NativeInstrumentLoadingSheetBinding mLoadingInstrumentBinding;

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

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        LoadingInstrumentSheetViewModel loadingInstrumentSheetViewModel = new LoadingInstrumentSheetViewModel(getActivity(), this);
        this.mLoadingInstrumentBinding = (NativeInstrumentLoadingSheetBinding) f.a(getLayoutInflater(), R.layout.native_instrument_loading_sheet, (ViewGroup) null, false);
        NativeInstrumentLoadingSheetBinding nativeInstrumentLoadingSheetBinding = this.mLoadingInstrumentBinding;
        if (nativeInstrumentLoadingSheetBinding == null) {
            k.a();
        }
        View root = nativeInstrumentLoadingSheetBinding.getRoot();
        k.a((Object) root, "mLoadingInstrumentBinding!!.root");
        NativeInstrumentLoadingSheetBinding nativeInstrumentLoadingSheetBinding2 = this.mLoadingInstrumentBinding;
        if (nativeInstrumentLoadingSheetBinding2 == null) {
            k.a();
        }
        nativeInstrumentLoadingSheetBinding2.setSelectedInstrumentSheetViewModel(loadingInstrumentSheetViewModel);
        NativeInstrumentLoadingSheetBinding nativeInstrumentLoadingSheetBinding3 = this.mLoadingInstrumentBinding;
        if (nativeInstrumentLoadingSheetBinding3 == null) {
            k.a();
        }
        this.mFetchPayMethodsProgress = nativeInstrumentLoadingSheetBinding3.dotProgressBar;
        setAnimation(this.mFetchPayMethodsProgress);
        NativeInstrumentLoadingSheetBinding nativeInstrumentLoadingSheetBinding4 = this.mLoadingInstrumentBinding;
        if (nativeInstrumentLoadingSheetBinding4 == null) {
            k.a();
        }
        k.a((Object) nativeInstrumentLoadingSheetBinding4.rlLoading, "mLoadingInstrumentBinding!!.rlLoading");
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            activity.getWindow().setSoftInputMode(3);
        }
        return root;
    }

    public final void onResponseReceived(CJPayMethodResponse cJPayMethodResponse) {
        if (!(cJPayMethodResponse == null || cJPayMethodResponse.getBody() == null)) {
            Body body = cJPayMethodResponse.getBody();
            k.a((Object) body, "payMethodResponse.body");
            if (body.getResultInfo() != null) {
                Body body2 = cJPayMethodResponse.getBody();
                k.a((Object) body2, "payMethodResponse.body");
                ResultInfo resultInfo = body2.getResultInfo();
                k.a((Object) resultInfo, "payMethodResponse.body.resultInfo");
                if (resultInfo.getResultStatus() != null) {
                    Body body3 = cJPayMethodResponse.getBody();
                    k.a((Object) body3, "payMethodResponse.body");
                    ResultInfo resultInfo2 = body3.getResultInfo();
                    k.a((Object) resultInfo2, "payMethodResponse.body.resultInfo");
                    if (!p.a(resultInfo2.getResultStatus(), AppConstants.FEED_SUB_TYPE, true)) {
                        Body body4 = cJPayMethodResponse.getBody();
                        k.a((Object) body4, "payMethodResponse.body");
                        if (body4.getMerchantPayOption() != null) {
                            Body body5 = cJPayMethodResponse.getBody();
                            k.a((Object) body5, "payMethodResponse.body");
                            MerchantPayOption merchantPayOption = body5.getMerchantPayOption();
                            k.a((Object) merchantPayOption, "payMethodResponse.body.merchantPayOption");
                            if (merchantPayOption.getPaymentModes() != null) {
                                Body body6 = cJPayMethodResponse.getBody();
                                k.a((Object) body6, "payMethodResponse.body");
                                MerchantPayOption merchantPayOption2 = body6.getMerchantPayOption();
                                k.a((Object) merchantPayOption2, "payMethodResponse.body.merchantPayOption");
                                if (merchantPayOption2.getPaymentModes().size() > 0) {
                                    DirectPaymentBL.getInstance().setResponse(cJPayMethodResponse);
                                    NativeInstrumentLoadingSheetBinding nativeInstrumentLoadingSheetBinding = this.mLoadingInstrumentBinding;
                                    if (nativeInstrumentLoadingSheetBinding == null) {
                                        k.a();
                                    }
                                    LottieAnimationView lottieAnimationView = nativeInstrumentLoadingSheetBinding.dotProgressBar;
                                    k.a((Object) lottieAnimationView, "mLoadingInstrumentBinding!!.dotProgressBar");
                                    lottieAnimationView.setVisibility(8);
                                    OnBottomSheetChangeListener onBottomSheetChangeListener = this.mBottomSheetChangeListener;
                                    if (onBottomSheetChangeListener == null) {
                                        k.a();
                                    }
                                    Bundle arguments = getArguments();
                                    if (arguments == null) {
                                        k.a();
                                    }
                                    onBottomSheetChangeListener.onChangeBottomSheet(arguments.getString(SDKConstants.INTENT, SDKConstants.FETCH_ONLY), false);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        Context context = getContext();
        if (context != null) {
            k.a((Object) context, "it");
            a.a(context.getApplicationContext()).a(intent);
        }
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionCancel("Failed to initiate Paytm SDK. Please check transaction JSON.");
        }
    }

    private final void setAnimation(LottieAnimationView lottieAnimationView) {
        LottieAnimationView lottieAnimationView2 = this.mFetchPayMethodsProgress;
        if (lottieAnimationView2 == null) {
            k.a();
        }
        lottieAnimationView2.setVisibility(0);
        LottieAnimationView lottieAnimationView3 = this.mFetchPayMethodsProgress;
        if (lottieAnimationView3 == null) {
            k.a();
        }
        lottieAnimationView3.setAnimation("Payments-Loader.json");
        LottieAnimationView lottieAnimationView4 = this.mFetchPayMethodsProgress;
        if (lottieAnimationView4 == null) {
            k.a();
        }
        lottieAnimationView4.loop(true);
        LottieAnimationView lottieAnimationView5 = this.mFetchPayMethodsProgress;
        if (lottieAnimationView5 == null) {
            k.a();
        }
        lottieAnimationView5.playAnimation();
    }

    public final void setBottomSheetChangeListener(OnBottomSheetChangeListener onBottomSheetChangeListener) {
        k.c(onBottomSheetChangeListener, "mBottomSheetChangeListener");
        this.mBottomSheetChangeListener = onBottomSheetChangeListener;
    }
}
