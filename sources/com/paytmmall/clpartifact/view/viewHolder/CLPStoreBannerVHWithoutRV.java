package com.paytmmall.clpartifact.view.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.o;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.repositories.CLPRepository;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPUrlProvider;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.utils.PopupUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CLPStoreBannerVHWithoutRV extends CLPItemVHWithoutRV {
    private CustomAction customAction;
    private ViewDataBinding mViewDataBinding;

    static /* synthetic */ void lambda$onFollowClick$1() {
    }

    public CLPStoreBannerVHWithoutRV(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mViewDataBinding = viewDataBinding;
        this.customAction = customAction2;
        this.itemView.post(new Runnable() {
            public final void run() {
                CLPStoreBannerVHWithoutRV.this.lambda$new$0$CLPStoreBannerVHWithoutRV();
            }
        });
    }

    public /* synthetic */ void lambda$new$0$CLPStoreBannerVHWithoutRV() {
        CLPConstants.STORE_BANNER_HEIGHT = this.itemView.getHeight();
        if (CLPConstants.INFINITE_GRID_HEIGHT_RUNNABLE != null) {
            CLPConstants.INFINITE_GRID_HEIGHT_RUNNABLE.run();
        }
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.view, view);
        this.mViewDataBinding.executePendingBindings();
    }

    public static void setText(TextView textView, View view) {
        if (textView != null && view.getRatingReview() != null && view.getRatingReview().getTotalReview() != null) {
            String str = "Review";
            Integer totalReview = view.getRatingReview().getTotalReview();
            if (totalReview.intValue() > 1) {
                str = str + "s";
            }
            int i2 = 8;
            textView.setPaintFlags(8);
            textView.setText(String.format("%s ".concat(String.valueOf(str)), new Object[]{totalReview}));
            if (totalReview.intValue() != 0) {
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
    }

    public void openReviewsTab(android.view.View view) {
        CustomAction customAction2 = this.customAction;
        if (customAction2 != null && customAction2.getMallSdkVHListener() != null) {
            this.customAction.getMallSdkVHListener().openReviewsTab();
        }
    }

    public static void setRatingText(TextView textView, View view) {
        if (textView != null && view.getRatingReview() != null && view.getRatingReview().getAvgRating() != null) {
            textView.setText(String.format("%s ", new Object[]{view.getRatingReview().getAvgRating()}));
        }
    }

    public void openAllStoresTab(android.view.View view) {
        if ((view.getContext() instanceof FragmentActivity ? (FragmentActivity) view.getContext() : null) != null) {
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            Context context = view.getContext();
            communicationListener.sendCustomGTMEvents(context, "clp", "View All Stores clicked", "homescreen(" + GAUtil.getGakey() + ")", (String) null, CLPConstants.GA_CHANNEL_NAME, GAUtil.MARKET_PLACE);
            CustomAction customAction2 = this.customAction;
            if (customAction2 != null && customAction2.getMallSdkVHListener() != null) {
                this.customAction.getMallSdkVHListener().openAllStoresTab();
            }
        }
    }

    public static void setFollowText(TextView textView, boolean z) {
        if (textView != null) {
            textView.setText(getFollowString(z));
            textView.setBackground(b.a(textView.getContext(), getFollowBackground(z)));
            textView.setTextColor(b.c(textView.getContext(), getTextColor(z)));
        }
    }

    private static int getTextColor(boolean z) {
        return z ? R.color.clp_white : R.color.primaryBlue;
    }

    private static int getFollowBackground(boolean z) {
        return z ? R.drawable.clp_blue_rounded_background : R.drawable.clp_white_rounded_backhground;
    }

    private static int getFollowString(boolean z) {
        return z ? R.string.following : R.string.follow;
    }

    public void onFollowClick(android.view.View view, View view2) {
        CustomAction customAction2;
        FragmentActivity fragmentActivity = view.getContext() instanceof FragmentActivity ? (FragmentActivity) view.getContext() : null;
        if (fragmentActivity != null && (customAction2 = this.customAction) != null && customAction2.getMallSdkVHListener() != null) {
            if (isPopupNeeded(view2)) {
                PopupUtils.showPopup(fragmentActivity, fragmentActivity.getString(R.string.unfollow), fragmentActivity.getString(R.string.unfollow_content), fragmentActivity.getString(R.string.cancel), fragmentActivity.getString(R.string.unfollow).toUpperCase(), $$Lambda$CLPStoreBannerVHWithoutRV$yYXVVLe9oIAkGAc30Wok_Mvk_VU.INSTANCE, new PopupUtils.IOkListener(view2, view) {
                    private final /* synthetic */ View f$1;
                    private final /* synthetic */ android.view.View f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onOkClick() {
                        CLPStoreBannerVHWithoutRV.this.lambda$onFollowClick$2$CLPStoreBannerVHWithoutRV(this.f$1, this.f$2);
                    }
                });
                return;
            }
            applyFollow(view2, view);
            GaHandler.getInstance().fireClickUnFollowEvent(view2.getStoreInfo().getName(), this.customAction.getMallSdkVHListener().getGAKey());
        }
    }

    public /* synthetic */ void lambda$onFollowClick$2$CLPStoreBannerVHWithoutRV(View view, android.view.View view2) {
        applyFollow(view, view2);
        GaHandler.getInstance().fireClickUnFollowEvent(view.getStoreInfo().getName(), this.customAction.getMallSdkVHListener().getGAKey());
    }

    private void applyFollow(View view, android.view.View view2) {
        if (view.getStoreInfo() != null && view.getRatingReview() != null && !TextUtils.isEmpty(view.getRatingReview().getEntityType())) {
            if (!TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(view2.getContext().getApplicationContext()))) {
                Context applicationContext = view2.getContext().getApplicationContext();
                new CLPRepository().applyFollow(UrlUtils.appendSiteIdToUrl(applicationContext, getBaseUrl() + getAction(view)), getFollowBody(view), getFollowHeader(view2.getContext().getApplicationContext()), new CLPRepository.ISuccessResponseListener(view) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onSuccess(String str, o oVar) {
                        CLPStoreBannerVHWithoutRV.this.lambda$applyFollow$3$CLPStoreBannerVHWithoutRV(this.f$1, str, oVar);
                    }
                }, (CLPRepository.IErrorResponseListener) null);
                return;
            }
            CLPArtifact.getInstance().getCommunicationListener().openLoginScreen(view2.getContext());
        }
    }

    public /* synthetic */ void lambda$applyFollow$3$CLPStoreBannerVHWithoutRV(View view, String str, o oVar) {
        handleSuccessResponse(str, view);
    }

    private void updateIsFollowing(View view) {
        view.getStoreInfo().setFollowing(!view.getStoreInfo().isFollowing());
    }

    public static void setBGColor(ViewGroup viewGroup, View view, Context context) {
        if (!ImageUtility.isActivitydestroyed(viewGroup)) {
            if (context == null) {
                context = viewGroup.getContext();
            }
            String coverPic = view.getStoreInfo().getCoverPic();
            if (TextUtils.isEmpty(coverPic) && view.getItems() != null && view.getItems().size() > 0) {
                coverPic = view.getItems().get(0).getImageUrl();
            }
            ImageUtility.loadBackgroundImageAsync(viewGroup, context, coverPic);
        }
    }

    public void handleBackPress() {
        ViewDataBinding viewDataBinding = this.mViewDataBinding;
        if (viewDataBinding != null) {
            viewDataBinding.getRoot();
            Activity hostActivity = CustomActionHelper.INSTANCE.getHostActivity(this.mViewDataBinding.getRoot().getContext(), this.customAction);
            if (hostActivity != null) {
                hostActivity.finish();
            }
        }
    }

    private boolean isPopupNeeded(View view) {
        return (view == null || view.getStoreInfo() == null || !view.getStoreInfo().isFollowing()) ? false : true;
    }

    private String getBaseUrl() {
        return CLPUrlProvider.getFollowUrl();
    }

    private void handleSuccessResponse(String str, View view) {
        try {
            if (new JSONObject(str).optInt("code") == 200) {
                updateIsFollowing(view);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private HashMap<String, String> getFollowHeader(final Context context) {
        return new HashMap<String, String>() {
            {
                put("Content-Type", "application/json");
                put(AppConstants.SSO_TOKEN, CLPArtifact.getInstance().getCommunicationListener().getSSOToken(context));
                put("X-client-secret", "kybid_brand_fe@123");
                put("X-client-name", "feBrand_client");
            }
        };
    }

    private String getFollowBody(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("bucketName", view.getRatingReview().getEntityType());
            jSONObject.putOpt("entityIdentifier", view.getRatingReview().getEntityIdentifier());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String getAction(View view) {
        String str = view.getStoreInfo().isFollowing() ? "unbucketItem" : "bucketItem";
        return str + "/" + view.getRatingReview().getEntityType();
    }
}
