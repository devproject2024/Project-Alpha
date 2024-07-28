package com.paytm.business.merchantprofile.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.business.common_module.e.a;
import com.business.common_module.events.d;
import com.business.common_module.utilities.c;
import com.business.common_module.utilities.i;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.BaseActivity;
import com.paytm.business.merchantprofile.common.ErrorUtil;
import com.paytm.business.merchantprofile.common.ProfileConstants;
import com.paytm.business.merchantprofile.common.ProfileGTMConstants;
import com.paytm.business.merchantprofile.common.gtm.GAGTMTagAnalytics;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.MerchantTypeToPPIMapper;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.business.merchantprofile.databinding.PrActivityProfileBusinessDetailsNewBinding;
import com.paytm.business.merchantprofile.event.EditBusinessDetailEvent;
import com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState;
import com.paytm.business.merchantprofile.inactivemerchant.AccountReactivationRequestEvent;
import com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress;
import com.paytm.business.merchantprofile.inactivemerchant.Active;
import com.paytm.business.merchantprofile.inactivemerchant.ActiveChangeNotAllowed;
import com.paytm.business.merchantprofile.inactivemerchant.DeActivatedEligibleForInstantReactivation;
import com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation;
import com.paytm.business.merchantprofile.inactivemerchant.DeActivationInProgress;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountActivationUIState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess;
import com.paytm.business.merchantprofile.inactivemerchant.PaymentAcceptanceHoldBottomSheet;
import com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed;
import com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress;
import com.paytm.business.merchantprofile.listener.IProfileBusinessDetails;
import com.paytm.business.merchantprofile.listener.MerchantSwitchListener;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.BasicDetailsModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.KycDetailsModel;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import com.paytm.business.merchantprofile.model.edc.RentalPlanDetailsModel;
import com.paytm.business.merchantprofile.repo.ProfileRepository;
import com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel;
import com.paytm.business.merchantprofile.webview.EmbedWebViewActivity;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;
import retrofit2.Response;

public class ProfileBusinessDetailsActivity extends BaseActivity implements InactiveMerchantListener, IProfileBusinessDetails, MerchantSwitchListener {
    public final String TAG = "ProfileBusinessDetailsActivity";
    public boolean didOEGstinStatusResponseCome = false;
    public boolean didTicketStatusResponseCome = false;
    public Snackbar errorSnackBar;
    public boolean isMoreMerchants;
    public PrActivityProfileBusinessDetailsNewBinding mBinding;
    public String mToBeHighlightedSection = "";
    public ProfileBusinessDetailsViewModel mViewModel;
    public View mViewToBeHighLighted;
    public MerchantAccountStateManager merchantAccountStateManager;

    private void closeReactivationTicket() {
    }

    private void openEditDetailsFragment() {
    }

    public void getAccountReActivationStatus() {
    }

    public void handleBankChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
    }

    public void handleFetchLeadStatusApi(String str, boolean z, String str2, boolean z2) {
    }

    public void onInactiveMerchantDataChange(AccountActivationState accountActivationState, MerchantAccountActivationUIState merchantAccountActivationUIState) {
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    public void onReactivationInProgress() {
    }

    public void onViewPastPaymentsClick() {
    }

    public void showEditAddressDialogFragment(EditGstinAddress editGstinAddress) {
    }

    public void showEditGstinDialogFragment(EditGstinAddress editGstinAddress) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getTargetScreenDeeplink();
        this.mBinding = (PrActivityProfileBusinessDetailsNewBinding) f.a(this, R.layout.pr_activity_profile_business_details_new);
        ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel = (ProfileBusinessDetailsViewModel) provideViewModel(ProfileBusinessDetailsViewModel.class, (Fragment) null);
        this.mViewModel = profileBusinessDetailsViewModel;
        profileBusinessDetailsViewModel.setData(this, (BasicDetailsModel) getIntent().getSerializableExtra("mBasicDetailsModel"));
        this.mBinding.setViewModel(this.mViewModel);
        this.merchantAccountStateManager = new MerchantAccountStateManager(this);
        startShimmer();
        initBasicUi();
        checkNetwork();
        initToolBar();
        setData();
        setClickEvents();
        handleDeactiveMerchantAccountState();
    }

    private void initBasicUi() {
        if (ProfileConfig.getInstance().getMerchantDataProvider().b() == null || ProfileConfig.getInstance().getMerchantDataProvider().b().getMerchants() == null || ProfileConfig.getInstance().getMerchantDataProvider().b().getMerchants().size() <= 1) {
            this.isMoreMerchants = false;
        } else {
            this.isMoreMerchants = true;
        }
        String userPicUrl = ProfileSharedPreferences.getInstance().getUserPicUrl();
        if (!TextUtils.isEmpty(userPicUrl)) {
            w.a().a(userPicUrl).a().a((ImageView) this.mBinding.viewProfileHeader.profilePic, (e) new e() {
                public void onError(Exception exc) {
                }

                public void onSuccess() {
                    ProfileBusinessDetailsActivity.this.mBinding.viewProfileHeader.profilePic.setBorderWidth(ProfileBusinessDetailsActivity.this.getResources().getDimension(R.dimen.dimen_5dp));
                }
            });
        }
        if (!ProfileConstants.isP4BClient()) {
            this.mBinding.viewProfileHeader.merchantSwitchView.setVisibility(8);
        } else if (!this.isMoreMerchants) {
            this.mBinding.viewProfileHeader.businessDisplayName.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.mBinding.viewProfileHeader.businessDisplayName.setPadding(0, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 23) {
                this.mBinding.viewProfileHeader.merchantSwitchView.setForeground((Drawable) null);
            }
        }
        if (ProfileConstants.isP4BClient()) {
            this.mBinding.logoutBtn.setVisibility(0);
        }
        this.mBinding.viewProfileHeader.userName.setText(getDisplyNameOfUserWithFallback());
    }

    public String getDisplyNameOfUserWithFallback() {
        String G = ProfileConfig.getInstance().getMerchantDataProvider().G();
        a b2 = ProfileConfig.getInstance().getMerchantDataProvider().b();
        if (!TextUtils.isEmpty(G) || b2 == null) {
            return G;
        }
        String firstName = b2.getFirstName();
        String lastName = b2.getLastName();
        if (!TextUtils.isEmpty(firstName)) {
            G = firstName;
        }
        if (!TextUtils.isEmpty(lastName)) {
            G = G + lastName;
        }
        return TextUtils.isEmpty(G) ? b2.getUsername() : G;
    }

    public void getTargetScreenDeeplink() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().hasExtra(AppConstants.DeepLinkConstants.KEY_DEEPLINK_HIGHLIGHT_SECTION)) {
                this.mToBeHighlightedSection = getIntent().getStringExtra(AppConstants.DeepLinkConstants.KEY_DEEPLINK_HIGHLIGHT_SECTION);
            }
            getIntent().getIntExtra("key_deeplink_target_screen_id", -1);
        }
    }

    private void startShimmer() {
        this.mBinding.shimmerContainer.sBfContainer.setVisibility(0);
        this.mBinding.shimmerContainer.sBfContainer.startShimmer();
        this.mBinding.scrollView.setVisibility(8);
    }

    private void removeShimmer() {
        if (!(this.mBinding.shimmerContainer.sBfContainer.getVisibility() != 0 || this.mViewModel.basicLiveData.getValue() == null || this.mViewModel.basicLiveData.getValue().f7358c == null || this.mViewModel.basicLiveData.getValue().f7357b != com.business.common_module.utilities.a.e.SUCCESS || this.mViewModel.kycLiveData.getValue() == null || this.mViewModel.kycLiveData.getValue().f7358c == null || this.mViewModel.kycLiveData.getValue().f7357b != com.business.common_module.utilities.a.e.SUCCESS)) {
            this.mBinding.shimmerContainer.sBfContainer.stopShimmer();
        }
        this.mBinding.shimmerContainer.sBfContainer.setVisibility(8);
        this.mBinding.scrollView.setVisibility(0);
    }

    private void checkNetwork() {
        if (!i.a(ProfileConfig.getInstance().getApplication())) {
            showErroSnackBar(getResources().getString(R.string.pr_no_internet_connection));
        } else {
            startApiCall();
        }
    }

    public void startApiCall() {
        resetGstinResponseFlags();
        this.mViewModel.setAddressDetailsApiFlag(true);
        this.mViewModel.setBasicDetailsApi(true);
        this.mViewModel.setTicketStatusApiFlag(true);
        this.mViewModel.setKycAPI(true);
        this.mViewModel.startFetchGstinLeadOE();
        this.mViewModel.gstinChangeVisibility.set(false);
        if (ProfileConfig.getInstance().getMerchantDataProvider().v()) {
            this.mViewModel.startRentalPlanApiCall();
        }
    }

    private void showErroSnackBar(String str) {
        Snackbar snackbar = this.errorSnackBar;
        if (snackbar != null) {
            snackbar.d();
        }
        Snackbar a2 = Snackbar.a((View) this.mBinding.rlParentContainer, (CharSequence) str, -2).a((CharSequence) getString(R.string.pr_retry), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$showErroSnackBar$0$ProfileBusinessDetailsActivity(view);
            }
        });
        this.errorSnackBar = a2;
        a2.d(getResources().getColor(R.color.color_00b9f5));
        View b2 = this.errorSnackBar.b();
        b2.setBackgroundColor(b.c(this, R.color.black));
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_action)).setAllCaps(false);
        ((TextView) b2.findViewById(com.google.android.material.R.id.snackbar_text)).setTextColor(-1);
        this.errorSnackBar.a(str);
        this.errorSnackBar.c();
    }

    public /* synthetic */ void lambda$showErroSnackBar$0$ProfileBusinessDetailsActivity(View view) {
        this.errorSnackBar.d();
        checkNetwork();
    }

    public void setBasicFromAPI() {
        com.business.common_module.utilities.a.e eVar;
        if (this.mViewModel.basicLiveData.getValue() != null && (eVar = this.mViewModel.basicLiveData.getValue().f7357b) != com.business.common_module.utilities.a.e.OFFLINE) {
            if (this.mViewModel.basicLiveData.getValue().f7356a == null || !ErrorUtil.handleInvalidToken("UMP", this.mViewModel.basicLiveData.getValue().f7356a)) {
                if (eVar == com.business.common_module.utilities.a.e.FAILURE || eVar == com.business.common_module.utilities.a.e.ERROR) {
                    showErroSnackBar(getResources().getString(R.string.pr_some_went_wrong));
                }
                if (this.mViewModel.basicLiveData.getValue().f7358c != null && this.mViewModel.basicLiveData.getValue().f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                    removeShimmer();
                    ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel = this.mViewModel;
                    profileBusinessDetailsViewModel.mBasicDetailsModel = (BasicDetailsModel) profileBusinessDetailsViewModel.basicLiveData.getValue().f7358c;
                    this.mViewModel.setBasicDetails();
                }
            }
        }
    }

    private void initToolBar() {
        setSupportActionBar(this.mBinding.toolbar);
        getSupportActionBar();
        getSupportActionBar().b(true);
        getSupportActionBar().a((CharSequence) " ");
    }

    private void setData() {
        this.mViewModel.basicLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$1$ProfileBusinessDetailsActivity((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mViewModel.addressDetailsLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.setAddressDetails((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mViewModel.kycLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.setKycDetails((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mViewModel.ticketStatusLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$2$ProfileBusinessDetailsActivity((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mViewModel.rentalPlanDetailsLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$3$ProfileBusinessDetailsActivity((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.mViewModel.autoOpenNameScreenLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$4$ProfileBusinessDetailsActivity((Boolean) obj);
            }
        });
        this.mViewModel.autoOpenGstScreenLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$5$ProfileBusinessDetailsActivity((Boolean) obj);
            }
        });
        this.mViewModel.autoOpenAddressScreenLiveData.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$6$ProfileBusinessDetailsActivity((Boolean) obj);
            }
        });
        this.mViewModel.mOEFetchGstinStatus.observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$7$ProfileBusinessDetailsActivity((com.business.common_module.utilities.a.b) obj);
            }
        });
        this.merchantAccountStateManager.getInactiveMerchantData().getAccountState().observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$8$ProfileBusinessDetailsActivity((AccountActivationState) obj);
            }
        });
        this.merchantAccountStateManager.getInactiveMerchantData().getUiState().observe(this, new z() {
            public final void onChanged(Object obj) {
                ProfileBusinessDetailsActivity.this.lambda$setData$9$ProfileBusinessDetailsActivity((MerchantAccountActivationUIState) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setData$1$ProfileBusinessDetailsActivity(com.business.common_module.utilities.a.b bVar) {
        setBasicFromAPI();
    }

    public /* synthetic */ void lambda$setData$2$ProfileBusinessDetailsActivity(com.business.common_module.utilities.a.b bVar) {
        this.didTicketStatusResponseCome = true;
        handleGstinTicketStatusResponse();
    }

    public /* synthetic */ void lambda$setData$3$ProfileBusinessDetailsActivity(com.business.common_module.utilities.a.b bVar) {
        this.mViewModel.onEDCRentalApiResponse();
    }

    public /* synthetic */ void lambda$setData$4$ProfileBusinessDetailsActivity(Boolean bool) {
        editDisplayName();
    }

    public /* synthetic */ void lambda$setData$5$ProfileBusinessDetailsActivity(Boolean bool) {
        editGstin();
    }

    public /* synthetic */ void lambda$setData$6$ProfileBusinessDetailsActivity(Boolean bool) {
        editAddress();
    }

    public /* synthetic */ void lambda$setData$7$ProfileBusinessDetailsActivity(com.business.common_module.utilities.a.b bVar) {
        this.didOEGstinStatusResponseCome = true;
        handleGstinTicketStatusResponse();
    }

    /* access modifiers changed from: private */
    /* renamed from: onMercantAccountUIStateChange */
    public void lambda$setData$9$ProfileBusinessDetailsActivity(MerchantAccountActivationUIState merchantAccountActivationUIState) {
        if (merchantAccountActivationUIState instanceof ActivationStatusCheckInProgress) {
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(8);
            this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(8);
            this.mBinding.llDeactivateContainer.shimmerDeactivate.setVisibility(0);
            this.mBinding.llDeactivateContainer.shimmerDeactivate.startShimmer();
            return;
        }
        this.mBinding.llDeactivateContainer.shimmerDeactivate.setVisibility(8);
        this.mBinding.llDeactivateContainer.shimmerDeactivate.stopShimmer();
    }

    /* access modifiers changed from: private */
    /* renamed from: onMercantAccountStateChange */
    public void lambda$setData$8$ProfileBusinessDetailsActivity(AccountActivationState accountActivationState) {
        this.mBinding.llDeactivateContainer.llDeactivate.setVisibility(0);
        this.mBinding.llDeactivateContainer.viewDisplayDeactivationStatus.parent.setVisibility(8);
        if (ProfileConfig.getInstance().getMerchantDataProvider().c()) {
            this.mBinding.llDeactivateContainer.tvAccountStatus.setText(getString(R.string.pr_deactivate_account));
        } else {
            this.mBinding.llDeactivateContainer.tvAccountStatus.setText(getString(R.string.pr_reactivate_account));
        }
        if (accountActivationState == null) {
            this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(8);
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(8);
        } else if (accountActivationState instanceof DeActivationInProgress) {
            this.mBinding.llDeactivateContainer.viewDisplayDeactivationStatus.parent.setVisibility(0);
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(8);
            this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
            this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_deactivate_account_subtext);
        } else if (accountActivationState instanceof ActiveChangeNotAllowed) {
            this.mBinding.llDeactivateContainer.llDeactivate.setVisibility(8);
        } else if (accountActivationState instanceof Active) {
            this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
            this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_deactivate_account_subtext);
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(0);
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setText(getString(R.string.pr_deactivate_my_account));
            this.mBinding.llDeactivateContainer.tvDeactivateAccount.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ProfileBusinessDetailsActivity.this.lambda$onMercantAccountStateChange$10$ProfileBusinessDetailsActivity(view);
                }
            });
        } else {
            boolean z = accountActivationState instanceof ReActivationFailed;
            if (z || (accountActivationState instanceof DeActivatedNotEligibleForInstantReactivation)) {
                if (z) {
                    showReActivationFailedBottomSheet();
                }
                this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_reactivate_msg);
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(0);
                TextView textView = this.mBinding.llDeactivateContainer.tvDeactivateAccount;
                textView.setText(getString(R.string.pr_call_help_desk) + " " + getHelpLineNumber());
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ProfileBusinessDetailsActivity.this.lambda$onMercantAccountStateChange$11$ProfileBusinessDetailsActivity(view);
                    }
                });
                ProfileConfig.getInstance().getEventPublisher().a(this, "Profile Page", "Account Deactivated -> Call MHD Shown", "", "");
            } else if (accountActivationState instanceof DeActivatedEligibleForInstantReactivation) {
                this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_instant_reactivate_msg);
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setText(getString(R.string.pr_instant_reactivate_cta));
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ProfileBusinessDetailsActivity.this.lambda$onMercantAccountStateChange$12$ProfileBusinessDetailsActivity(view);
                    }
                });
                ProfileConfig.getInstance().getEventPublisher().a(this, "Profile Page", "Account Deactivated - Reactivation CTA Shown", "", "");
            } else if (accountActivationState instanceof ReActivationInProgress) {
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(8);
                this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_instant_act_submit_message);
            } else if (accountActivationState instanceof MerchantReactivationSuccess) {
                if (shouldShowDeActivationCTA()) {
                    this.mBinding.llDeactivateContainer.llDeactivate.setVisibility(0);
                } else {
                    this.mBinding.llDeactivateContainer.llDeactivate.setVisibility(8);
                }
                this.mBinding.llDeactivateContainer.tvStatusMsg.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvStatusMsg.setText(R.string.pr_deactivate_account_subtext);
                this.mBinding.llDeactivateContainer.tvAccountStatus.setText(getString(R.string.pr_deactivate_account));
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setVisibility(0);
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setText(getString(R.string.pr_deactivate_my_account));
                this.mBinding.llDeactivateContainer.tvDeactivateAccount.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        ProfileBusinessDetailsActivity.this.lambda$onMercantAccountStateChange$13$ProfileBusinessDetailsActivity(view);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onMercantAccountStateChange$10$ProfileBusinessDetailsActivity(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Deactivate Account Clicked", "", "");
        ProfileConfig.getInstance().getDeepLinkUtils().a(this, "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().geteedHelpNavEngineAccountsUrl() + "&view=");
    }

    public /* synthetic */ void lambda$onMercantAccountStateChange$11$ProfileBusinessDetailsActivity(View view) {
        onContactUsClick(getHelpLineNumber());
    }

    public /* synthetic */ void lambda$onMercantAccountStateChange$12$ProfileBusinessDetailsActivity(View view) {
        reactivateMerchantAccount();
    }

    public /* synthetic */ void lambda$onMercantAccountStateChange$13$ProfileBusinessDetailsActivity(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Deactivate Account Clicked", "", "");
        ProfileConfig.getInstance().getDeepLinkUtils().a(this, "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().geteedHelpNavEngineAccountsUrl() + "&view=");
    }

    private void showReActivationFailedBottomSheet() {
        new PaymentAcceptanceHoldBottomSheet().show(getSupportFragmentManager(), PaymentAcceptanceHoldBottomSheet.TAG);
    }

    private void setClickEvents() {
        if (ProfileConfig.getInstance().getMerchantDataProvider().w()) {
            this.mBinding.editDisplayName.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ProfileBusinessDetailsActivity.this.lambda$setClickEvents$14$ProfileBusinessDetailsActivity(view);
                }
            });
            this.mViewModel.isChangeNamePermissionAvailabel.set(true);
        } else {
            this.mViewModel.isChangeNamePermissionAvailabel.set(false);
        }
        this.mBinding.editAddress.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$15$ProfileBusinessDetailsActivity(view);
            }
        });
        this.mBinding.addAddress.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$16$ProfileBusinessDetailsActivity(view);
            }
        });
        this.mBinding.addGstIn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$17$ProfileBusinessDetailsActivity(view);
            }
        });
        this.mBinding.planTypeMenuContainer.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$18$ProfileBusinessDetailsActivity(view);
            }
        });
        this.mBinding.termsAndConditionsTxt.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$19$ProfileBusinessDetailsActivity(view);
            }
        });
        if (ProfileConstants.isP4BClient()) {
            this.mBinding.viewProfileHeader.merchantSwitchView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ProfileBusinessDetailsActivity.this.lambda$setClickEvents$20$ProfileBusinessDetailsActivity(view);
                }
            });
        }
        this.mBinding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileBusinessDetailsActivity.this.lambda$setClickEvents$21$ProfileBusinessDetailsActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$setClickEvents$14$ProfileBusinessDetailsActivity(View view) {
        editDisplayName();
    }

    public /* synthetic */ void lambda$setClickEvents$15$ProfileBusinessDetailsActivity(View view) {
        editAddress();
    }

    public /* synthetic */ void lambda$setClickEvents$16$ProfileBusinessDetailsActivity(View view) {
        editAddress();
    }

    public /* synthetic */ void lambda$setClickEvents$17$ProfileBusinessDetailsActivity(View view) {
        editGstin();
    }

    public /* synthetic */ void lambda$setClickEvents$18$ProfileBusinessDetailsActivity(View view) {
        Intent intent = new Intent(this, EDCBottomSheetActivity.class);
        androidx.databinding.i<List<RentalPlanDetailsModel.RentalSummaryData>> iVar = this.mViewModel.mRentalSummary;
        if (iVar != null && iVar.get() != null && this.mViewModel.mRentalSummary.get().size() != 0) {
            int size = this.mViewModel.mRentalSummary.get().size();
            String[] strArr = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = ((RentalPlanDetailsModel.RentalSummaryData) this.mViewModel.mRentalSummary.get().get(i2)).getPlanType();
            }
            intent.putExtra(AppConstants.RENTAL_SERIALIZABLE_DATA, strArr);
            startActivityForResult(intent, 130);
        }
    }

    public /* synthetic */ void lambda$setClickEvents$19$ProfileBusinessDetailsActivity(View view) {
        Intent intent = new Intent(this, EmbedWebViewActivity.class);
        intent.putExtra("intent_extra_url", GTMDataProviderImpl.Companion.getMInstance().getEdcRefundPolicyTermsAndConditionsUrl());
        intent.putExtra("intent_extra_page_title", ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_terms_amp_conditions));
        startActivity(intent);
    }

    public /* synthetic */ void lambda$setClickEvents$20$ProfileBusinessDetailsActivity(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Change Buisness Clicked", "", this.isMoreMerchants ? CommonPayParams.Builder.YES : CommonPayParams.Builder.NO);
        if (this.isMoreMerchants) {
            showMerchantSwitchBottomSheet();
        }
    }

    public /* synthetic */ void lambda$setClickEvents$21$ProfileBusinessDetailsActivity(View view) {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Logout Account Clicked", "", "");
        AppUtility.onSignOut(this, ProfileBusinessDetailsActivity.class.getName(), (Bundle) null, (NetworkCustomError) null);
    }

    private void editGstin() {
        Intent intent = new Intent(this, EditBusinessProfileDetailsActivity.class);
        intent.putExtra("type", "update_gstin");
        intent.putExtra("value", this.mViewModel.getEditGstinAddressModel());
        intent.putExtra("businessName", this.mViewModel.bussinessName.get());
        startActivityForResult(intent, 125);
    }

    /* access modifiers changed from: private */
    public void setKycDetails(com.business.common_module.utilities.a.b<KycDetailsModel> bVar) {
        com.business.common_module.utilities.a.e eVar;
        if (bVar != null && (eVar = bVar.f7357b) != com.business.common_module.utilities.a.e.LOADING && eVar != com.business.common_module.utilities.a.e.OFFLINE) {
            Response<?> response = bVar.f7356a;
            if (response != null && ErrorUtil.handleInvalidToken("UMP", response)) {
                return;
            }
            if (eVar == com.business.common_module.utilities.a.e.FAILURE || eVar == com.business.common_module.utilities.a.e.ERROR) {
                showErroSnackBar(getResources().getString(R.string.pr_some_went_wrong));
                return;
            }
            removeShimmer();
            this.mViewModel.setKycDetails();
        }
    }

    private void editAddress() {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Change Business Address Clicked", "", "");
        Intent intent = new Intent(this, EditBusinessProfileDetailsActivity.class);
        intent.putExtra("type", AppConstants.UPDATE_DETAILS.ADDRESS);
        intent.putExtra("value", this.mViewModel.getEditGstinAddressModel());
        startActivityForResult(intent, 125);
    }

    private void editDisplayName() {
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Profile Page", "Change Business Name Clicked", "", "");
        Intent intent = new Intent(this, EditBusinessProfileDetailsActivity.class);
        intent.putExtra("type", EditBasicDetailsDialogFragment.TYPE_DISPLAY_NAME);
        intent.putExtra("value", this.mViewModel.displayName.get());
        startActivityForResult(intent, 125);
    }

    /* access modifiers changed from: private */
    public void setAddressDetails(com.business.common_module.utilities.a.b<AddressDetailsModel> bVar) {
        com.business.common_module.utilities.a.e eVar;
        if (bVar != null && (eVar = bVar.f7357b) != com.business.common_module.utilities.a.e.LOADING) {
            Response<?> response = bVar.f7356a;
            if (response != null && ErrorUtil.handleInvalidToken("UMP", response)) {
                return;
            }
            if (eVar == com.business.common_module.utilities.a.e.FAILURE || eVar == com.business.common_module.utilities.a.e.ERROR) {
                showErroSnackBar(getResources().getString(R.string.pr_some_went_wrong));
                return;
            }
            T t = bVar.f7358c;
            if (t != null && bVar.f7357b == com.business.common_module.utilities.a.e.SUCCESS) {
                this.mViewModel.setAddressDetails((AddressDetailsModel) t);
                ProfileSharedPreferences.getInstance().setUserCity(((AddressDetailsModel) bVar.f7358c).getCity());
                ProfileSharedPreferences.getInstance().setUserArea(((AddressDetailsModel) bVar.f7358c).getState());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleTicketStatus(com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding r6, com.paytm.business.merchantprofile.model.ProfileTicketStatus.TicketItem r7, androidx.databinding.ObservableBoolean r8) {
        /*
            r5 = this;
            r0 = 1
            r8.set(r0)
            com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel r1 = r5.mViewModel
            java.lang.String r2 = r7.getStatus()
            java.lang.String r1 = r1.getTicketStatus(r2)
            int r2 = r1.hashCode()
            r3 = 2
            r4 = -1149187101(0xffffffffbb80cbe3, float:-0.003930555)
            if (r2 == r4) goto L_0x0036
            r4 = -368591510(0xffffffffea07bd6a, float:-4.1024867E25)
            if (r2 == r4) goto L_0x002c
            r4 = 35394935(0x21c1577, float:1.146723E-37)
            if (r2 != r4) goto L_0x0040
            java.lang.String r2 = "PENDING"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 0
            goto L_0x0041
        L_0x002c:
            java.lang.String r2 = "FAILURE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 2
            goto L_0x0041
        L_0x0036:
            java.lang.String r2 = "SUCCESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0040
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = -1
        L_0x0041:
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x008a
            if (r1 == r0) goto L_0x0063
            if (r1 != r3) goto L_0x00b1
            android.widget.TextView r8 = r6.tvDescription
            int r0 = com.paytm.business.merchantprofile.R.string.pr_change_request_denied
            java.lang.String r0 = r5.getString(r0)
            r8.setText(r0)
            android.widget.ImageView r6 = r6.ivTicketStatus
            int r8 = com.paytm.business.merchantprofile.R.drawable.pr_ic_error
            android.graphics.drawable.Drawable r8 = androidx.core.content.b.a((android.content.Context) r5, (int) r8)
            r6.setImageDrawable(r8)
            r5.setTicketStatusCompleted(r7)
            return
        L_0x0063:
            com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel r0 = r5.mViewModel
            androidx.databinding.ObservableBoolean r1 = r0.displayNameChangeVisibility
            if (r8 != r1) goto L_0x0070
            int r8 = com.paytm.business.merchantprofile.R.string.pr_business_display_success
            java.lang.String r2 = r5.getString(r8)
            goto L_0x007a
        L_0x0070:
            androidx.databinding.ObservableBoolean r0 = r0.gstinChangeVisibility
            if (r8 != r0) goto L_0x007a
            int r8 = com.paytm.business.merchantprofile.R.string.pr_change_request_approved
            java.lang.String r2 = r5.getString(r8)
        L_0x007a:
            android.widget.TextView r8 = r6.tvDescription
            r8.setText(r2)
            android.widget.ImageView r6 = r6.ivTicketStatus
            int r8 = com.paytm.business.merchantprofile.R.drawable.pr_ic_success_tick
            r6.setImageResource(r8)
            r5.setTicketStatusCompleted(r7)
            return
        L_0x008a:
            com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel r7 = r5.mViewModel
            androidx.databinding.ObservableBoolean r0 = r7.displayNameChangeVisibility
            if (r8 != r0) goto L_0x0097
            int r7 = com.paytm.business.merchantprofile.R.string.pr_update_disp_msg
            java.lang.String r2 = r5.getString(r7)
            goto L_0x00a1
        L_0x0097:
            androidx.databinding.ObservableBoolean r7 = r7.gstinChangeVisibility
            if (r8 != r7) goto L_0x00a1
            int r7 = com.paytm.business.merchantprofile.R.string.pr_gst_update_msg
            java.lang.String r2 = r5.getString(r7)
        L_0x00a1:
            android.widget.TextView r7 = r6.tvDescription
            r7.setText(r2)
            android.widget.ImageView r6 = r6.ivTicketStatus
            int r7 = com.paytm.business.merchantprofile.R.drawable.pr_ic_pending
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r5, (int) r7)
            r6.setImageDrawable(r7)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.view.ProfileBusinessDetailsActivity.handleTicketStatus(com.paytm.business.merchantprofile.databinding.PrViewEditChangeInProgressNewBinding, com.paytm.business.merchantprofile.model.ProfileTicketStatus$TicketItem, androidx.databinding.ObservableBoolean):void");
    }

    private void setTicketStatusCompleted(ProfileTicketStatus.TicketItem ticketItem) {
        ticketItem.setStatus("COMPLETED");
        HashMap hashMap = new HashMap();
        hashMap.put("caseid", ticketItem.getCaseId());
        hashMap.put("status", ticketItem.getStatus());
        ProfileRepository.getInstance().updateMerchantProfileTicketStatus(hashMap, "");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void showBasicDetailsDialogFragment(String str, String str2) {
        EditBasicDetailsDialogFragment.newInstance(str, str2);
    }

    public void handleGstinChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
        handleTicketStatus(this.mBinding.viewGstinChange, ticketItem, this.mViewModel.gstinChangeVisibility);
    }

    public void handleDisplayNameChangeTicket(ProfileTicketStatus.TicketItem ticketItem) {
        handleTicketStatus(this.mBinding.viewDisplayNameChange, ticketItem, this.mViewModel.displayNameChangeVisibility);
    }

    private void handleDeactiveMerchantAccountState() {
        if (!ProfileConfig.getInstance().getMerchantDataProvider().c()) {
            this.merchantAccountStateManager.getMerchantAccountState();
        }
    }

    public void handleActiveMerchantAccountState(boolean z) {
        if (z) {
            if (!ProfileConfig.getInstance().getMerchantDataProvider().s() || !ProfileConstants.isP4BClient()) {
                this.merchantAccountStateManager.getInactiveMerchantData().getAccountState().setValue(ActiveChangeNotAllowed.INSTANCE);
            } else {
                this.merchantAccountStateManager.getInactiveMerchantData().getAccountState().setValue(DeActivationInProgress.INSTANCE);
            }
        } else if (shouldShowDeActivationCTA()) {
            this.merchantAccountStateManager.getInactiveMerchantData().getAccountState().setValue(Active.INSTANCE);
        } else {
            this.merchantAccountStateManager.getInactiveMerchantData().getAccountState().setValue(ActiveChangeNotAllowed.INSTANCE);
        }
    }

    public void onStart() {
        super.onStart();
        c.a().a((Object) this);
    }

    public void onStop() {
        super.onStop();
        ProfileBusinessDetailsViewModel profileBusinessDetailsViewModel = this.mViewModel;
        if (profileBusinessDetailsViewModel != null) {
            profileBusinessDetailsViewModel.resetDeactCTA();
        }
        c.a().b(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onEditBusinessDetailEvent(com.paytm.business.merchantprofile.event.EditBusinessDetailEvent r5) {
        /*
            r4 = this;
            com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel r0 = r4.mViewModel
            r0.updateEditedValue(r5)
            java.lang.String r0 = r5.getType()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = -1339964514(0xffffffffb021c39e, float:-5.884945E-10)
            if (r1 == r3) goto L_0x0023
            r3 = -608658121(0xffffffffdbb89d37, float:-1.03928511E17)
            if (r1 != r3) goto L_0x002e
            java.lang.String r1 = "update_gstin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            r0 = 1
            goto L_0x002f
        L_0x0023:
            java.lang.String r1 = "update_display_name"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = -1
        L_0x002f:
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0061
            if (r0 != r2) goto L_0x005f
            com.paytm.business.merchantprofile.model.EditGstinAddress r0 = r5.getEditGstinAddress()
            if (r0 == 0) goto L_0x0052
            com.paytm.business.merchantprofile.model.EditGstinAddress r0 = r5.getEditGstinAddress()
            boolean r0 = r0.isAddressOnly()
            if (r0 == 0) goto L_0x0052
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_success_address_title
            java.lang.String r1 = r4.getString(r0)
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_success_address_sub_title
            java.lang.String r0 = r4.getString(r0)
            goto L_0x0084
        L_0x0052:
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_success_gstin_title
            java.lang.String r1 = r4.getString(r0)
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_ticket_raised_sub_title
            java.lang.String r0 = r4.getString(r0)
            goto L_0x0084
        L_0x005f:
            r0 = r1
            goto L_0x0084
        L_0x0061:
            java.lang.String r0 = r5.getValue()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0078
            int r0 = com.paytm.business.merchantprofile.R.string.pr_updated_display_name
            java.lang.String r1 = r4.getString(r0)
            int r0 = com.paytm.business.merchantprofile.R.string.pr_new_display
            java.lang.String r0 = r4.getString(r0)
            goto L_0x0084
        L_0x0078:
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_success_display_name_title
            java.lang.String r1 = r4.getString(r0)
            int r0 = com.paytm.business.merchantprofile.R.string.pr_edit_success_display_name_sub_title
            java.lang.String r0 = r4.getString(r0)
        L_0x0084:
            java.lang.String r3 = r5.getValue()
            java.lang.String r5 = r5.getType()
            com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment r5 = com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment.newInstance(r1, r0, r3, r5)
            r5.setCancelable(r2)
            androidx.fragment.app.j r0 = r4.getSupportFragmentManager()
            java.lang.String r1 = "message bottom sheet"
            r5.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            r4.startShimmer()
            r4.startApiCall()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.view.ProfileBusinessDetailsActivity.onEditBusinessDetailEvent(com.paytm.business.merchantprofile.event.EditBusinessDetailEvent):void");
    }

    public void onResume() {
        super.onResume();
        highlightParticularSection();
        if (this.mViewModel != null && i.a(ProfileConfig.getInstance().getApplication())) {
            this.mViewModel.setTicketStatusApiFlag(true);
            this.mViewModel.startFetchGstinLeadOE();
            this.mBinding.llDeactivateContainer.shimmerDeactivate.startShimmer();
        }
        GAGTMTagAnalytics.getSingleInstance().pushScreenEvent("/business-app/Account/Business Profile");
    }

    private void highlightParticularSection() {
        String str = this.mToBeHighlightedSection;
        if (str != null && !str.isEmpty()) {
            String str2 = this.mToBeHighlightedSection;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1187588811) {
                if (hashCode != -1099019263) {
                    if (hashCode != -380837161) {
                        if (hashCode == 583709816 && str2.equals("business-name")) {
                            c2 = 0;
                        }
                    } else if (str2.equals("change-address")) {
                        c2 = 3;
                    }
                } else if (str2.equals("add-gstin")) {
                    c2 = 2;
                }
            } else if (str2.equals("business-details")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.mViewToBeHighLighted = this.mBinding.viewOverlayBusinessName;
            } else if (c2 == 1) {
                this.mViewToBeHighLighted = this.mBinding.viewOverlayBusinessDetails;
            } else if (c2 == 2) {
                this.mViewToBeHighLighted = this.mBinding.llGstin;
            } else if (c2 == 3) {
                this.mViewToBeHighLighted = this.mBinding.viewOverlayRegisteredAddress;
            }
            if (this.mViewToBeHighLighted != null) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ScrollView scrollView = ProfileBusinessDetailsActivity.this.mBinding.scrollView;
                        c.a aVar = com.business.common_module.utilities.c.f7365a;
                        View access$100 = ProfileBusinessDetailsActivity.this.mViewToBeHighLighted;
                        k.d(access$100, "view");
                        int[] iArr = new int[2];
                        access$100.getLocationOnScreen(iArr);
                        scrollView.smoothScrollTo(0, iArr[1] - access$100.getHeight());
                        if (ProfileBusinessDetailsActivity.this.mViewToBeHighLighted instanceof ViewGroup) {
                            c.a aVar2 = com.business.common_module.utilities.c.f7365a;
                            c.a.a(ProfileBusinessDetailsActivity.this.mViewToBeHighLighted, (Context) ProfileBusinessDetailsActivity.this);
                        } else {
                            c.a aVar3 = com.business.common_module.utilities.c.f7365a;
                            c.a.a(ProfileBusinessDetailsActivity.this.mViewToBeHighLighted, ProfileBusinessDetailsActivity.this, true);
                        }
                        String unused = ProfileBusinessDetailsActivity.this.mToBeHighlightedSection = "";
                    }
                }, 1000);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 125) {
            if (i2 == 130 && i3 == -1 && intent != null && intent.getExtras() != null) {
                this.mViewModel.setRentalPlansApiData(intent.getExtras().getInt(AppConstants.BOTTOM_SHEET_SELECTED_INDEX, 0));
            }
        } else if (i3 == -1 && intent != null && intent.getSerializableExtra(AppConstants.EDIT_OBJECT) != null) {
            onEditBusinessDetailEvent((EditBusinessDetailEvent) intent.getSerializableExtra(AppConstants.EDIT_OBJECT));
        }
    }

    private void showMerchantSwitchBottomSheet() {
        MerchantSwitchBottomSheet.newInstance().show(getSupportFragmentManager(), "MERCHANT_SWITCH");
    }

    public void onMerchantSwitch(com.business.common_module.e.b bVar) {
        com.business.common_module.events.c merchantSwitchEvent = getMerchantSwitchEvent(bVar);
        ProfileConfig.getInstance().getMerchantDataProvider().a(bVar);
        org.greenrobot.eventbus.c.a().c(merchantSwitchEvent);
        updatePrefsFromEvent();
        GAGTMTagAnalytics.getSingleInstance().sendEvent(ProfileConfig.getInstance().getAppContext(), "Account", "Select Merchant", "", "");
        ProfileSharedPreferences.getInstance().clearChannelsPreferences();
        ProfileSharedPreferences.getInstance().clearGVPreferences();
        startApiCall();
    }

    public com.business.common_module.events.c getMerchantSwitchEvent(com.business.common_module.e.b bVar) {
        return new com.business.common_module.events.c(bVar.getId(), bVar.getEmail(), bVar.getMid(), bVar.getName(), bVar.getMobile(), bVar.getGuid(), bVar.getCreatedOn(), bVar.getKybid(), bVar.getMerchantType(), bVar.isMigrated(), bVar.getIsMerchant(), bVar.isActive(), bVar.getAggregator(), bVar.isChild());
    }

    public void updatePrefsFromEvent() {
        AppConstants.showBlockedWalletBottomSheet = true;
    }

    private boolean shouldShowDeActivationCTA() {
        if (ProfileConfig.getInstance().getMerchantDataProvider().s() && ProfileConstants.isP4BClient()) {
            try {
                String[] split = ProfileConfig.getInstance().getGTMDataProvider().getString(ProfileConstants.DEACTIVATION_ENABLED_PPI_CHANGES, "").split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                String mapMerchantTypeToPPI = MerchantTypeToPPIMapper.mapMerchantTypeToPPI(ProfileConfig.getInstance().getMerchantDataProvider().t());
                for (String equalsIgnoreCase : split) {
                    if (equalsIgnoreCase.equalsIgnoreCase(mapMerchantTypeToPPI)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void resetGstinResponseFlags() {
        this.didTicketStatusResponseCome = false;
        this.didOEGstinStatusResponseCome = false;
    }

    private void handleGstinTicketStatusResponse() {
        if (this.didOEGstinStatusResponseCome && this.didTicketStatusResponseCome) {
            resetGstinResponseFlags();
            this.mViewModel.setTicketStatus();
            this.mBinding.llDeactivateContainer.shimmerDeactivate.stopShimmer();
        }
    }

    private void openDialer(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        if (str != null) {
            intent.setData(Uri.parse("tel: ".concat(String.valueOf(str))));
        }
        startActivity(intent);
    }

    public void onContactUsClick(String str) {
        ProfileConfig.getInstance().getEventPublisher().a(this, "Profile Page", "Account Deactivated -> Call MHD Clicked", "", "");
        openDialer(str);
    }

    public MerchantAccountState getInactivateMerchantData() {
        return this.merchantAccountStateManager.getInactiveMerchantData();
    }

    public String getHelpLineNumber() {
        return AppUtility.getMHDHelpLineNumber();
    }

    public void onReactivationSuccessful() {
        closeReactivationTicket();
    }

    public void reactivateMerchantAccount() {
        ProfileConfig.getInstance().getEventPublisher().a(this, "Profile Page", "Account Deactivated - Reactivation CTA Clicked", "", "");
        com.business.common_module.b.c deepLinkUtils = ProfileConfig.getInstance().getDeepLinkUtils();
        deepLinkUtils.a(this, "paytmba://business-app/ump-web?url=" + GTMDataProviderImpl.Companion.getMInstance().getUMPBaseUrl() + ProfileConfig.getInstance().getGTMDataProvider().getString(ProfileGTMConstants.INSTANT_REACTIVATION_REACT_URL, ""));
    }

    @j(a = ThreadMode.MAIN, b = true)
    public void onAccountActivationRequest(AccountReactivationRequestEvent accountReactivationRequestEvent) {
        org.greenrobot.eventbus.c.a().e(accountReactivationRequestEvent);
        this.merchantAccountStateManager.getMerchantAccountState(Boolean.TRUE);
    }

    public void onReactivationFailure() {
        closeReactivationTicket();
    }

    @j
    public void onErrorRetryEvent(com.business.common_module.events.b bVar) {
        if ("ProfileBusinessDetailsActivity".equals(bVar.f7341a) && this.mViewModel != null) {
            resetGstinResponseFlags();
            this.mViewModel.gstinChangeVisibility.set(false);
            this.mViewModel.callAllAPI();
        }
    }

    @j
    public void progressEvnt(d dVar) {
        if (dVar.f7351a) {
            showProgressDialog();
        } else {
            removeProgressDialog();
        }
    }
}
