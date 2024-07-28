package com.business.merchant_payments.mapqr.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.utilities.a.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseFragment;
import com.business.merchant_payments.databinding.MpFragmentSaveFeedbackBinding;
import com.business.merchant_payments.mapqr.viewmodel.QRSurveyViewModel;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class FeedbackCollectionFragment extends BaseFragment {
    public static final Companion Companion = new Companion((g) null);
    public HashMap _$_findViewCache;
    public String code = "";
    public MpFragmentSaveFeedbackBinding mBinding;
    public QRSurveyViewModel mQrSurveyViewModel;

    public static final FeedbackCollectionFragment newInstance() {
        return Companion.newInstance();
    }

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

    public static final /* synthetic */ MpFragmentSaveFeedbackBinding access$getMBinding$p(FeedbackCollectionFragment feedbackCollectionFragment) {
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding = feedbackCollectionFragment.mBinding;
        if (mpFragmentSaveFeedbackBinding == null) {
            k.a("mBinding");
        }
        return mpFragmentSaveFeedbackBinding;
    }

    public static final /* synthetic */ QRSurveyViewModel access$getMQrSurveyViewModel$p(FeedbackCollectionFragment feedbackCollectionFragment) {
        QRSurveyViewModel qRSurveyViewModel = feedbackCollectionFragment.mQrSurveyViewModel;
        if (qRSurveyViewModel == null) {
            k.a("mQrSurveyViewModel");
        }
        return qRSurveyViewModel;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        k.d(str, "<set-?>");
        this.code = str;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.mp_fragment_save_feedback, (ViewGroup) null, false);
        k.b(a2, "DataBindingUtil.inflate(…ave_feedback, null,false)");
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding = (MpFragmentSaveFeedbackBinding) a2;
        this.mBinding = mpFragmentSaveFeedbackBinding;
        if (mpFragmentSaveFeedbackBinding == null) {
            k.a("mBinding");
        }
        return mpFragmentSaveFeedbackBinding.getRoot();
    }

    public final void initUI() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        c provideViewModel = provideViewModel(instance.getApplication(), QRSurveyViewModel.class, this);
        k.b(provideViewModel, "provideViewModel(Payment…wModel::class.java, this)");
        this.mQrSurveyViewModel = (QRSurveyViewModel) provideViewModel;
        setListeners();
        setObservers();
    }

    public final void setListeners() {
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding = this.mBinding;
        if (mpFragmentSaveFeedbackBinding == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding.ivReasonOther.setOnClickListener(new FeedbackCollectionFragment$setListeners$1(this));
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding2 = this.mBinding;
        if (mpFragmentSaveFeedbackBinding2 == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding2.ivBack.setOnClickListener(new FeedbackCollectionFragment$setListeners$2(this));
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding3 = this.mBinding;
        if (mpFragmentSaveFeedbackBinding3 == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding3.ivReasonOther.setOnClickListener(new FeedbackCollectionFragment$setListeners$3(this));
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding4 = this.mBinding;
        if (mpFragmentSaveFeedbackBinding4 == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding4.ivReason1.setOnClickListener(new FeedbackCollectionFragment$setListeners$4(this));
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding5 = this.mBinding;
        if (mpFragmentSaveFeedbackBinding5 == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding5.ivReason2.setOnClickListener(new FeedbackCollectionFragment$setListeners$5(this));
        MpFragmentSaveFeedbackBinding mpFragmentSaveFeedbackBinding6 = this.mBinding;
        if (mpFragmentSaveFeedbackBinding6 == null) {
            k.a("mBinding");
        }
        mpFragmentSaveFeedbackBinding6.btnSubmit.setOnClickListener(new FeedbackCollectionFragment$setListeners$6(this));
    }

    public final void setObservers() {
        QRSurveyViewModel qRSurveyViewModel = this.mQrSurveyViewModel;
        if (qRSurveyViewModel == null) {
            k.a("mQrSurveyViewModel");
        }
        qRSurveyViewModel.getQrSurveyViewModel().observe(this, new FeedbackCollectionFragment$setObservers$1(this));
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final FeedbackCollectionFragment newInstance() {
            return new FeedbackCollectionFragment();
        }
    }
}
