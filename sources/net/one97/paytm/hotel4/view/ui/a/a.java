package net.one97.paytm.hotel4.view.ui.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApply;
import net.one97.paytm.hotel4.service.model.promocode.PromoCodeApplyData;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeDataItem;
import net.one97.paytm.hotel4.service.model.promocode.PromocodeResponse;
import net.one97.paytm.hotel4.view.a.n;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotel4.viewmodel.ViewModelFactory;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.b.aw;
import net.one97.paytm.i.h;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private aw f28771a;

    /* renamed from: b  reason: collision with root package name */
    private ReviewViewModel f28772b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f28773c;

    /* renamed from: d  reason: collision with root package name */
    private SharedViewModel f28774d;

    static final class b<T> implements z<PromoCodeApply> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28776a;

        b(a aVar) {
            this.f28776a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            a.a(this.f28776a, (PromoCodeApply) obj);
        }
    }

    static final class c<T> implements z<ErrorData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28777a;

        c(a aVar) {
            this.f28777a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            a.a(this.f28777a, (ErrorData) obj);
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28778a;

        d(a aVar) {
            this.f28778a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "status");
            if (bool.booleanValue()) {
                LottieAnimationView lottieAnimationView = a.a(this.f28778a).x;
                k.a((Object) lottieAnimationView, "fragmentHotelOffersBinding.updateProgressBarOffers");
                lottieAnimationView.setVisibility(0);
                net.one97.paytm.common.widgets.a.a(this.f28778a.f28773c);
                return;
            }
            LottieAnimationView lottieAnimationView2 = a.a(this.f28778a).x;
            k.a((Object) lottieAnimationView2, "fragmentHotelOffersBinding.updateProgressBarOffers");
            lottieAnimationView2.setVisibility(8);
            net.one97.paytm.common.widgets.a.b(this.f28778a.f28773c);
        }
    }

    public static final /* synthetic */ aw a(a aVar) {
        aw awVar = aVar.f28771a;
        if (awVar == null) {
            k.a("fragmentHotelOffersBinding");
        }
        return awVar;
    }

    public static final /* synthetic */ ReviewViewModel c(a aVar) {
        ReviewViewModel reviewViewModel = aVar.f28772b;
        if (reviewViewModel == null) {
            k.a("reviewViewModel");
        }
        return reviewViewModel;
    }

    public static final /* synthetic */ SharedViewModel d(a aVar) {
        SharedViewModel sharedViewModel = aVar.f28774d;
        if (sharedViewModel == null) {
            k.a("sharedViewModel");
        }
        return sharedViewModel;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        aw a2 = aw.a(layoutInflater, viewGroup);
        k.a((Object) a2, "H4FragmentHotelOffersBin…flater, container, false)");
        this.f28771a = a2;
        aw awVar = this.f28771a;
        if (awVar == null) {
            k.a("fragmentHotelOffersBinding");
        }
        LottieAnimationView lottieAnimationView = awVar.x;
        k.a((Object) lottieAnimationView, "fragmentHotelOffersBinding.updateProgressBarOffers");
        lottieAnimationView.setVisibility(8);
        aw awVar2 = this.f28771a;
        if (awVar2 == null) {
            k.a("fragmentHotelOffersBinding");
        }
        return awVar2.getRoot();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = am.a(activity).a(SharedViewModel.class);
            k.a((Object) a2, "ViewModelProviders.of(it…redViewModel::class.java)");
            this.f28774d = (SharedViewModel) a2;
            SharedViewModel sharedViewModel = this.f28774d;
            if (sharedViewModel == null) {
                k.a("sharedViewModel");
            }
            ai a3 = am.a(activity, (al.b) new ViewModelFactory(sharedViewModel)).a(ReviewViewModel.class);
            k.a((Object) a3, "ViewModelProviders.of(it…iewViewModel::class.java)");
            this.f28772b = (ReviewViewModel) a3;
            ReviewViewModel reviewViewModel = this.f28772b;
            if (reviewViewModel == null) {
                k.a("reviewViewModel");
            }
            reviewViewModel.getProcodeLoader().postValue(Boolean.FALSE);
        }
        ReviewViewModel reviewViewModel2 = this.f28772b;
        if (reviewViewModel2 == null) {
            k.a("reviewViewModel");
        }
        q qVar = this;
        reviewViewModel2.getApiCallSuccessApplyPromoCode().observe(qVar, new b(this));
        ReviewViewModel reviewViewModel3 = this.f28772b;
        if (reviewViewModel3 == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel3.getApiCallFailure().observe(qVar, new c(this));
        ReviewViewModel reviewViewModel4 = this.f28772b;
        if (reviewViewModel4 == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel4.getProcodeLoader().observe(qVar, new d(this));
        ReviewViewModel reviewViewModel5 = this.f28772b;
        if (reviewViewModel5 == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel5.getOfferTncDialogListener().observe(qVar, new e(this));
    }

    public final void onViewCreated(View view, Bundle bundle) {
        List<PromocodeDataItem> codes;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            aw awVar = this.f28771a;
            if (awVar == null) {
                k.a("fragmentHotelOffersBinding");
            }
            ReviewViewModel reviewViewModel = this.f28772b;
            if (reviewViewModel == null) {
                k.a("reviewViewModel");
            }
            awVar.a(reviewViewModel);
            aw awVar2 = this.f28771a;
            if (awVar2 == null) {
                k.a("fragmentHotelOffersBinding");
            }
            this.f28773c = awVar2.x;
            ReviewViewModel reviewViewModel2 = this.f28772b;
            if (reviewViewModel2 == null) {
                k.a("reviewViewModel");
            }
            PromocodeResponse promoCodeResponse = reviewViewModel2.getPromoCodeResponse();
            if (!(promoCodeResponse == null || (codes = promoCodeResponse.getCodes()) == null)) {
                aw awVar3 = this.f28771a;
                if (awVar3 == null) {
                    k.a("fragmentHotelOffersBinding");
                }
                RecyclerView recyclerView = awVar3.k;
                k.a((Object) recyclerView, "fragmentHotelOffersBinding.offersList");
                recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                ReviewViewModel reviewViewModel3 = this.f28772b;
                if (reviewViewModel3 == null) {
                    k.a("reviewViewModel");
                }
                n nVar = new n(reviewViewModel3, true);
                aw awVar4 = this.f28771a;
                if (awVar4 == null) {
                    k.a("fragmentHotelOffersBinding");
                }
                RecyclerView recyclerView2 = awVar4.k;
                k.a((Object) recyclerView2, "fragmentHotelOffersBinding.offersList");
                recyclerView2.setAdapter(nVar);
                new ArrayList().addAll(codes);
                nVar.a(codes);
            }
            C0505a aVar = new C0505a(this);
            aw awVar5 = this.f28771a;
            if (awVar5 == null) {
                k.a("fragmentHotelOffersBinding");
            }
            awVar5.f29208g.addTextChangedListener(aVar);
        }
    }

    /* renamed from: net.one97.paytm.hotel4.view.ui.a.a$a  reason: collision with other inner class name */
    public static final class C0505a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28775a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        C0505a(a aVar) {
            this.f28775a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            String valueOf = String.valueOf(editable);
            a.c(this.f28775a).setEnteredPromoCode(valueOf);
            if (valueOf.length() == 0) {
                RelativeLayout relativeLayout = a.a(this.f28775a).f29202a;
                k.a((Object) relativeLayout, "fragmentHotelOffersBinding.applyBtnLyt");
                relativeLayout.setVisibility(8);
                return;
            }
            RoboTextView roboTextView = a.a(this.f28775a).n;
            k.a((Object) roboTextView, "fragmentHotelOffersBinding.promoStatusMessage");
            roboTextView.setVisibility(8);
            RelativeLayout relativeLayout2 = a.a(this.f28775a).f29202a;
            k.a((Object) relativeLayout2, "fragmentHotelOffersBinding.applyBtnLyt");
            relativeLayout2.setVisibility(0);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 800) {
            ReviewViewModel reviewViewModel = this.f28772b;
            if (reviewViewModel == null) {
                k.a("reviewViewModel");
            }
            net.one97.paytm.hotel4.service.a.e reviewRepository = reviewViewModel.getReviewRepository();
            if (!TextUtils.isEmpty(reviewRepository != null ? reviewRepository.d() : null)) {
                ReviewViewModel reviewViewModel2 = this.f28772b;
                if (reviewViewModel2 == null) {
                    k.a("reviewViewModel");
                }
                reviewViewModel2.setUserDetails();
                ReviewViewModel reviewViewModel3 = this.f28772b;
                if (reviewViewModel3 == null) {
                    k.a("reviewViewModel");
                }
                reviewViewModel3.applyPromoCodeButtonCLicked();
            }
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f28779a;

        e(a aVar) {
            this.f28779a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList arrayList = new ArrayList();
            PromocodeDataItem value = a.c(this.f28779a).getPromoCodeSelectedForTnC().getValue();
            if (value == null) {
                k.a();
            }
            arrayList.add(value.getTerms());
            net.one97.paytm.hotel4.utils.e eVar = net.one97.paytm.hotel4.utils.e.f28642a;
            net.one97.paytm.hotel4.utils.e.a(this.f28779a.getActivity(), arrayList, this.f28779a.getString(R.string.h4_terms_conditions), true, true, a.d(this.f28779a));
        }
    }

    public static final /* synthetic */ void a(a aVar, PromoCodeApply promoCodeApply) {
        ReviewViewModel reviewViewModel = aVar.f28772b;
        if (reviewViewModel == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel.getProcodeLoader().postValue(Boolean.FALSE);
        ReviewViewModel reviewViewModel2 = aVar.f28772b;
        if (reviewViewModel2 == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel2.getSuccessWalletTokenForPromoApplyListener().postValue(Boolean.FALSE);
        if (promoCodeApply != null) {
            PromoCodeApplyData data = promoCodeApply.getData();
            if (data == null) {
                k.a();
            }
            if (data.getPromocode() != null) {
                PromoCodeApplyData data2 = promoCodeApply.getData();
                if (data2 == null) {
                    k.a();
                }
                String promocode = data2.getPromocode();
                if (promocode == null) {
                    k.a();
                }
                if (promocode.length() > 0) {
                    ReviewViewModel reviewViewModel3 = aVar.f28772b;
                    if (reviewViewModel3 == null) {
                        k.a("reviewViewModel");
                    }
                    reviewViewModel3.setApplyPromoCodeData(promoCodeApply);
                    FragmentActivity activity = aVar.getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    activity.onBackPressed();
                    return;
                }
            }
            ReviewViewModel reviewViewModel4 = aVar.f28772b;
            if (reviewViewModel4 == null) {
                k.a("reviewViewModel");
            }
            reviewViewModel4.setApplyPromoData((PromocodeDataItem) null);
            aw awVar = aVar.f28771a;
            if (awVar == null) {
                k.a("fragmentHotelOffersBinding");
            }
            RoboTextView roboTextView = awVar.n;
            k.a((Object) roboTextView, "fragmentHotelOffersBinding.promoStatusMessage");
            roboTextView.setVisibility(0);
            aw awVar2 = aVar.f28771a;
            if (awVar2 == null) {
                k.a("fragmentHotelOffersBinding");
            }
            RoboTextView roboTextView2 = awVar2.n;
            k.a((Object) roboTextView2, "fragmentHotelOffersBinding.promoStatusMessage");
            PromoCodeApplyData data3 = promoCodeApply.getData();
            if (data3 == null) {
                k.a();
            }
            roboTextView2.setText(data3.getPromotext());
            return;
        }
        ReviewViewModel reviewViewModel5 = aVar.f28772b;
        if (reviewViewModel5 == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel5.setApplyPromoData((PromocodeDataItem) null);
        aw awVar3 = aVar.f28771a;
        if (awVar3 == null) {
            k.a("fragmentHotelOffersBinding");
        }
        RoboTextView roboTextView3 = awVar3.n;
        k.a((Object) roboTextView3, "fragmentHotelOffersBinding.promoStatusMessage");
        roboTextView3.setVisibility(0);
        aw awVar4 = aVar.f28771a;
        if (awVar4 == null) {
            k.a("fragmentHotelOffersBinding");
        }
        RoboTextView roboTextView4 = awVar4.n;
        k.a((Object) roboTextView4, "fragmentHotelOffersBinding.promoStatusMessage");
        roboTextView4.setText("PromoCode not applied");
    }

    public static final /* synthetic */ void a(a aVar, ErrorData errorData) {
        Integer statusCode;
        ReviewViewModel reviewViewModel = aVar.f28772b;
        if (reviewViewModel == null) {
            k.a("reviewViewModel");
        }
        reviewViewModel.getProcodeLoader().postValue(Boolean.FALSE);
        if (errorData == null || (statusCode = errorData.getStatusCode()) == null || statusCode.intValue() != 401) {
            ReviewViewModel reviewViewModel2 = aVar.f28772b;
            if (reviewViewModel2 == null) {
                k.a("reviewViewModel");
            }
            reviewViewModel2.getSuccessWalletTokenForPromoApplyListener().postValue(Boolean.FALSE);
            aw awVar = aVar.f28771a;
            if (awVar == null) {
                k.a("fragmentHotelOffersBinding");
            }
            RoboTextView roboTextView = awVar.n;
            k.a((Object) roboTextView, "fragmentHotelOffersBinding.promoStatusMessage");
            roboTextView.setVisibility(0);
            aw awVar2 = aVar.f28771a;
            if (awVar2 == null) {
                k.a("fragmentHotelOffersBinding");
            }
            RoboTextView roboTextView2 = awVar2.n;
            k.a((Object) roboTextView2, "fragmentHotelOffersBinding.promoStatusMessage");
            roboTextView2.setText("PromoCode not applied");
            return;
        }
        net.one97.paytm.hotels2.utils.c.b().a(aVar.getActivity());
    }
}
