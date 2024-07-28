package net.one97.paytm.nativesdk.instruments.paytmPaymentsBank.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.databinding.f;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Map;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.TermsAndConditionModel;
import net.one97.paytm.nativesdk.common.view.fragment.CustomBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.databinding.LayoutPostpaidTermsBinding;

public class PostPaidTCBottomSheet extends CustomBottomSheetDialogFragment {
    /* access modifiers changed from: private */
    public LayoutPostpaidTermsBinding binding;
    private boolean isApiCall;
    private String linkToLoad;
    /* access modifiers changed from: private */
    public Context mContext;

    public static PostPaidTCBottomSheet getInstance(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("LINK_TO_LOAD_TERMS_N_CONDITION", str);
        bundle.putBoolean("IS_API_CALL", z);
        PostPaidTCBottomSheet postPaidTCBottomSheet = new PostPaidTCBottomSheet();
        postPaidTCBottomSheet.setArguments(bundle);
        return postPaidTCBottomSheet;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.linkToLoad = arguments.getString("LINK_TO_LOAD_TERMS_N_CONDITION");
            this.isApiCall = arguments.getBoolean("IS_API_CALL", false);
            if (this.isApiCall) {
                setFullScreen(true);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (LayoutPostpaidTermsBinding) f.a(layoutInflater, R.layout.layout_postpaid_terms, viewGroup, false);
        this.binding.crossIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PostPaidTCBottomSheet.this.dismiss();
            }
        });
        if (this.isApiCall) {
            getTermsAndCondition();
        } else {
            this.binding.wvTermsNCondition.setWebChromeClient(new WebChromeClient());
            this.binding.wvTermsNCondition.setWebViewClient(new WebViewClient());
            this.binding.wvTermsNCondition.getSettings().setDomStorageEnabled(true);
            this.binding.wvTermsNCondition.getSettings().setJavaScriptEnabled(true);
            this.binding.wvTermsNCondition.loadUrl(this.linkToLoad);
        }
        return this.binding.getRoot();
    }

    private void getTermsAndCondition() {
        this.binding.pbProgress.setVisibility(0);
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(0, this.linkToLoad, (Map<String, String>) null, (Map<String, String>) null, (String) null, new Response.Listener() {
            public void onResponse(Object obj) {
                PostPaidTCBottomSheet.this.processResponse(obj instanceof TermsAndConditionModel ? ((TermsAndConditionModel) obj).getTerms() : "");
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError volleyError) {
                PostPaidTCBottomSheet.this.processResponse("");
            }
        }, TermsAndConditionModel.class);
        if (getContext() != null) {
            VolleyRequestQueue.getInstance(getContext()).addToRequestQueue(volleyPostRequest);
        }
    }

    /* access modifiers changed from: private */
    public void processResponse(final String str) {
        this.binding.wvTermsNCondition.post(new Runnable() {
            public void run() {
                String str = str;
                if (TextUtils.isEmpty(str)) {
                    str = PostPaidTCBottomSheet.this.mContext != null ? PostPaidTCBottomSheet.this.mContext.getString(R.string.no_terms_and_conditions_found) : "";
                }
                PostPaidTCBottomSheet.this.binding.wvTermsNCondition.loadDataWithBaseURL((String) null, str, "text/html", AppConstants.UTF_8, (String) null);
            }
        });
        this.binding.pbProgress.post(new Runnable() {
            public void run() {
                PostPaidTCBottomSheet.this.binding.pbProgress.setVisibility(8);
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }
}
