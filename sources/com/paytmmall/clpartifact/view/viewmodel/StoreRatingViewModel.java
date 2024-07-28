package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gson.f;
import com.google.gson.o;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.modal.DummyModel;
import com.paytmmall.clpartifact.modal.NoReview;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviewResponseModel;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviews;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.CLPUrlProvider;
import com.paytmmall.clpartifact.utils.UrlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class StoreRatingViewModel extends BaseViewModel {
    private static final int MORE_REVIEW_THRESHOLD = 2;
    private static final int REVIEWS_PER_PAGE = 10;
    private y<List<IRatingReviewModel>> data = new y<>();
    /* access modifiers changed from: private */
    public boolean hasMoreReviews = true;
    private CLPRepository mRepository = new CLPRepository();
    /* access modifiers changed from: private */
    public int pageNumber;
    private ObservableDouble ratingValue;
    private y<Boolean> refreshPageLiveData = new SingleEventLiveData();
    private w<List<IRatingReviewModel>> reviews = new w<>();
    private ObservableInt showEmpty = new ObservableInt(8);
    private ObservableInt showReviewSuccess;
    private CJRRatingReview storeRatingModel;
    private int widgetPostion;

    public int getHeaderImage(int i2) {
        return i2 == 0 ? 8 : 0;
    }

    public ObservableInt getShowReviewSuccess() {
        return this.showReviewSuccess;
    }

    public StoreRatingViewModel(Application application) {
        super(application);
        this.reviews.addSource(this.data, new z() {
            public final void onChanged(Object obj) {
                StoreRatingViewModel.this.lambda$new$0$StoreRatingViewModel((List) obj);
            }
        });
        this.ratingValue = new ObservableDouble(0.0d);
        this.pageNumber = 0;
        this.showReviewSuccess = new ObservableInt(0);
    }

    public /* synthetic */ void lambda$new$0$StoreRatingViewModel(List list) {
        this.showEmpty.set(showReviewsVisibility(list));
        this.reviews.setValue(list);
    }

    private int showReviewsVisibility(List<IRatingReviewModel> list) {
        return (list == null || list.size() == 1) ? 0 : 8;
    }

    public void setInitData(List<IRatingReviewModel> list, int i2) {
        if (this.data.getValue() == null || this.data.getValue().size() == 0) {
            this.data.setValue(list);
        }
        this.widgetPostion = i2;
    }

    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.a<?> aVar) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(aVar);
    }

    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, StoreRatingViewModel storeRatingViewModel) {
        recyclerView.addOnItemTouchListener(new GridRVOnTouchListener(storeRatingViewModel.widgetPostion));
        recyclerView.addOnScrollListener(new RecyclerView.l(storeRatingViewModel) {
            final /* synthetic */ StoreRatingViewModel val$storeRatingViewModel;

            {
                this.val$storeRatingViewModel = r1;
            }

            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
            }

            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int size = this.val$storeRatingViewModel.getReviews().getValue() != null ? this.val$storeRatingViewModel.getReviews().getValue().size() : 0;
                if (linearLayoutManager != null && size > 0 && linearLayoutManager.findLastVisibleItemPosition() == size - 2 && this.val$storeRatingViewModel.hasMoreReviews) {
                    boolean unused = this.val$storeRatingViewModel.hasMoreReviews = false;
                    StoreRatingViewModel storeRatingViewModel = this.val$storeRatingViewModel;
                    storeRatingViewModel.fetchReviews(storeRatingViewModel.pageNumber);
                }
            }
        });
    }

    public void fetchReviews(CJRRatingReview cJRRatingReview, boolean z) {
        if (cJRRatingReview != null) {
            if (this.storeRatingModel != cJRRatingReview) {
                this.storeRatingModel = cJRRatingReview;
            }
            if (this.reviews.getValue() == null || this.reviews.getValue().size() <= 1 || z) {
                if (z) {
                    this.pageNumber = 0;
                }
                fetchReviews(this.pageNumber);
            }
        }
    }

    /* access modifiers changed from: private */
    public void fetchReviews(int i2) {
        CJRRatingReview cJRRatingReview = this.storeRatingModel;
        if (cJRRatingReview != null) {
            if (TextUtils.isEmpty(cJRRatingReview.getEntityIdentifier())) {
                handleReviewError();
            }
            this.mRepository.fetchReviews(UrlUtils.appendSiteIdToUrl(getApplication(), this.storeRatingModel.getSeourl()), getReviewBody(this.storeRatingModel, i2), getRatingHeaders(), new CLPRepository.ISuccessResponseListener() {
                public final void onSuccess(String str, o oVar) {
                    StoreRatingViewModel.this.lambda$fetchReviews$1$StoreRatingViewModel(str, oVar);
                }
            }, new CLPRepository.IErrorResponseListener() {
                public final void onError(String str) {
                    StoreRatingViewModel.this.lambda$fetchReviews$2$StoreRatingViewModel(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$fetchReviews$1$StoreRatingViewModel(String str, o oVar) {
        handleSuccessReviewResponse((CJRReviewResponseModel) new f().a(str, CJRReviewResponseModel.class));
    }

    public /* synthetic */ void lambda$fetchReviews$2$StoreRatingViewModel(String str) {
        handleReviewError();
    }

    private void handleReviewError() {
        List value = this.data.getValue();
        if (value == null) {
            value = new ArrayList();
        }
        value.add(new NoReview());
        this.data.setValue(value);
    }

    private void handleSuccessReviewResponse(CJRReviewResponseModel cJRReviewResponseModel) {
        List value;
        if (cJRReviewResponseModel != null && 200 == cJRReviewResponseModel.getCode() && cJRReviewResponseModel.getReviews() != null) {
            boolean z = false;
            if (!cJRReviewResponseModel.getReviews().isEmpty() && this.data.getValue() != null) {
                List value2 = this.data.getValue();
                if (this.pageNumber == 0 && value2.size() > 1) {
                    value2 = value2.subList(0, 1);
                }
                value2.addAll(cJRReviewResponseModel.getReviews());
                if (value2.size() - 1 < cJRReviewResponseModel.getTotalReviews()) {
                    z = true;
                }
                this.hasMoreReviews = z;
                if (!this.hasMoreReviews) {
                    value2.add(new DummyModel());
                }
                this.pageNumber++;
                this.data.setValue(value2);
            } else if (cJRReviewResponseModel.getReviews().isEmpty() && (value = this.data.getValue()) != null && value.size() < 2) {
                value.add(new NoReview());
                this.data.setValue(value);
                this.hasMoreReviews = false;
            }
        }
    }

    private String getReviewBody(CJRRatingReview cJRRatingReview, int i2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("entityIdentifier", cJRRatingReview.getEntityIdentifier());
            jSONObject2.putOpt("number", Integer.valueOf(i2));
            jSONObject2.putOpt(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, 10);
            jSONObject.putOpt(H5Param.PAGE, jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public y<List<IRatingReviewModel>> getReviews() {
        return this.reviews;
    }

    public ObservableDouble getRatingValue() {
        return this.ratingValue;
    }

    private void setRatingValue(double d2) {
        this.ratingValue.set(d2);
    }

    private void hitAPIForRatingReview(CJRRatingReview cJRRatingReview, float f2, String str, CLPRepository.ISuccessResponseListener iSuccessResponseListener, double d2) {
        if (!TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(getApplication()))) {
            this.mRepository.applyRating(getRatingUrl(cJRRatingReview), getRatingBody(f2, cJRRatingReview, str), getRatingHeaders(), new CLPRepository.ISuccessResponseListener(f2, iSuccessResponseListener) {
                private final /* synthetic */ float f$1;
                private final /* synthetic */ CLPRepository.ISuccessResponseListener f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onSuccess(String str, o oVar) {
                    StoreRatingViewModel.this.lambda$hitAPIForRatingReview$3$StoreRatingViewModel(this.f$1, this.f$2, str, oVar);
                }
            }, new CLPRepository.IErrorResponseListener() {
                public final void onError(String str) {
                    StoreRatingViewModel.this.handleErrorResponse(str);
                }
            });
            return;
        }
        redirect(new RedirectorModel(1006, new HashMap()));
    }

    public /* synthetic */ void lambda$hitAPIForRatingReview$3$StoreRatingViewModel(float f2, CLPRepository.ISuccessResponseListener iSuccessResponseListener, String str, o oVar) {
        setRatingValue((double) f2);
        if (iSuccessResponseListener != null) {
            iSuccessResponseListener.onSuccess(str, oVar);
        }
    }

    /* access modifiers changed from: private */
    public void handleErrorResponse(String str) {
        String string = getApplication().getResources().getString(R.string.sf_network_error_message);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        Toast.makeText(getApplication().getApplicationContext(), str, 0).show();
    }

    private String getRatingUrl(CJRRatingReview cJRRatingReview) {
        Application application = getApplication();
        return UrlUtils.appendSiteIdToUrl(application, getBaseUrl() + getEntityType(cJRRatingReview));
    }

    private String getEntityType(CJRRatingReview cJRRatingReview) {
        if (cJRRatingReview == null) {
            return "";
        }
        return "/" + cJRRatingReview.getEntityType();
    }

    private HashMap<String, String> getRatingHeaders() {
        return new HashMap<String, String>() {
            {
                put("Content-Type", "application/json");
                put(AppConstants.SSO_TOKEN, CLPArtifact.getInstance().getCommunicationListener().getSSOToken(StoreRatingViewModel.this.getApplication()));
                put("X-client-secret", "kybid_brand_fe@123");
                put("X-client-name", "feBrand_client");
            }
        };
    }

    private String getRatingBody(float f2, CJRRatingReview cJRRatingReview, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("entityIdentifier", cJRRatingReview.getEntityIdentifier());
            jSONObject.putOpt("ratingValue", Integer.valueOf((int) f2));
            if (!TextUtils.isEmpty(str)) {
                jSONObject.putOpt("reviewDescription", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String getBaseUrl() {
        return CLPUrlProvider.getRatingUrl();
    }

    public static void setRatingReviewText(TextView textView, Double d2) {
        textView.setText(getSpannableString(tegetRatingText(textView.getContext(), d2), textView));
    }

    private static SpannableString tegetRatingText(Context context, Double d2) {
        if (d2.doubleValue() == 0.0d) {
            return new SpannableString(context.getString(R.string.tap_rate));
        }
        return new SpannableString(Html.fromHtml(context.getString(R.string.thanks_for_rating)));
    }

    private static SpannableString getSpannableString(SpannableString spannableString, final TextView textView) {
        if (TextUtils.isEmpty(spannableString)) {
            return spannableString;
        }
        try {
            spannableString.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(textView.getContext().getResources().getColor(R.color.blue));
                }
            }, spannableString.toString().indexOf("Write"), spannableString.length(), 33);
            return spannableString;
        } catch (Exception e2) {
            e2.printStackTrace();
            return spannableString;
        }
    }

    public void openReviewScreen(final CJRRatingReview cJRRatingReview) {
        if (cJRRatingReview != null) {
            redirect(new RedirectorModel(1001, new HashMap<String, Object>() {
                {
                    put(BaseViewModel.KEY_RATING_MODEL, cJRRatingReview);
                }
            }));
        }
    }

    public void submitReview(RatingBar ratingBar, String str, CJRRatingReview cJRRatingReview, View view) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(getApplication(), "Comment cannot be empty", 0).show();
            return;
        }
        hitAPIForRatingReview(cJRRatingReview, ratingBar.getRating(), str, new CLPRepository.ISuccessResponseListener(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess(String str, o oVar) {
                StoreRatingViewModel.this.lambda$submitReview$4$StoreRatingViewModel(this.f$1, str, oVar);
            }
        }, getRatingValue().get());
    }

    public /* synthetic */ void lambda$submitReview$4$StoreRatingViewModel(View view, String str, o oVar) {
        if (view != null) {
            Toast.makeText(view.getContext(), "Thank you for your feedback.", 0).show();
            view.performClick();
            refreshFragment();
        }
    }

    private void refreshFragment() {
        this.refreshPageLiveData.setValue(Boolean.TRUE);
    }

    public void hitAPIForRatingReview(CJRRatingReview cJRRatingReview, RedirectorModel redirectorModel) {
        hitAPIForRatingReview(cJRRatingReview, Float.parseFloat(String.valueOf(redirectorModel.getDataMap().get("rating"))), "", (CLPRepository.ISuccessResponseListener) null, (double) Float.parseFloat(String.valueOf(redirectorModel.getDataMap().get("defaultRating"))));
    }

    public void reportReview(final RedirectorModel redirectorModel) {
        if (redirectorModel != null) {
            redirect(new RedirectorModel(1003, new HashMap<String, Object>() {
                {
                    put(BaseViewModel.KEY_REVIEW_MODEL, StoreRatingViewModel.this.getReviewModel(redirectorModel.getDataMap()));
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public CJRReviews getReviewModel(Map<String, Object> map) {
        if (map == null || !map.containsKey("review")) {
            return null;
        }
        return (CJRReviews) map.get("review");
    }

    public void reportReview(CJRReviews cJRReviews) {
        this.mRepository.reportReview(UrlUtils.appendSiteIdToUrl(getApplication(), getReportUrl()), getReportBody(cJRReviews), getRatingHeaders(), new CLPRepository.ISuccessResponseListener() {
            public final void onSuccess(String str, o oVar) {
                StoreRatingViewModel.this.lambda$reportReview$5$StoreRatingViewModel(str, oVar);
            }
        }, new CLPRepository.IErrorResponseListener() {
            public final void onError(String str) {
                StoreRatingViewModel.this.lambda$reportReview$6$StoreRatingViewModel(str);
            }
        });
    }

    public /* synthetic */ void lambda$reportReview$5$StoreRatingViewModel(String str, o oVar) {
        handleSuccessReviewResponse(str);
    }

    public /* synthetic */ void lambda$reportReview$6$StoreRatingViewModel(String str) {
        this.showReviewSuccess.set(2);
    }

    private void handleSuccessReviewResponse(String str) {
        try {
            if (new JSONObject(str).optInt("code") == 200) {
                this.showReviewSuccess.set(1);
            } else {
                this.showReviewSuccess.set(2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private String getReportBody(CJRReviews cJRReviews) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reviewId", cJRReviews.getId());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String getReportUrl() {
        return CLPUrlProvider.getReportUrl();
    }

    public String getHeaderText(int i2) {
        Application application;
        int i3;
        if (i2 == 1) {
            application = getApplication();
            i3 = R.string.report_review_des_success;
        } else if (i2 == 2) {
            application = getApplication();
            i3 = R.string.something_went_wrong;
        } else {
            application = getApplication();
            i3 = R.string.review_text;
        }
        return application.getString(i3);
    }

    public String getButtonText(int i2) {
        Application application;
        int i3;
        if (i2 == 1) {
            application = getApplication();
            i3 = R.string.btn_done;
        } else if (i2 == 2) {
            application = getApplication();
            i3 = R.string.ok;
        } else {
            application = getApplication();
            i3 = R.string.report;
        }
        return application.getString(i3);
    }

    public LiveData<Boolean> getRefreshPageLiveData() {
        return this.refreshPageLiveData;
    }
}
