package com.paytm.business.merchantprofile.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.arch.core.c.a;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.h;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.a.e;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.common.utility.AppUtility;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.listener.IProfileBusinessDetails;
import com.paytm.business.merchantprofile.model.AddressDetailsModel;
import com.paytm.business.merchantprofile.model.BasicDetailsModel;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.FetchGstinStatusResponse;
import com.paytm.business.merchantprofile.model.GAEventModel;
import com.paytm.business.merchantprofile.model.GSTINLeadStatus;
import com.paytm.business.merchantprofile.model.KycDetailsModel;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;
import com.paytm.business.merchantprofile.model.edc.RentalPlanDetailsModel;
import com.paytm.business.merchantprofile.repo.ProfileRepository;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class ProfileBusinessDetailsViewModel extends c {
    public static final String SCREEN_NAME = ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_business_details_screen);
    public i<String> address;
    public final y<Boolean> addressDetailsApiFlag = new y<>();
    public LiveData<b<AddressDetailsModel>> addressDetailsLiveData = ah.b(this.addressDetailsApiFlag, new a() {
        public final Object apply(Object obj) {
            return ProfileBusinessDetailsViewModel.this.lambda$new$2$ProfileBusinessDetailsViewModel((Boolean) obj);
        }
    });
    public y<Boolean> autoOpenAddressScreenLiveData = new y<>();
    public y<Boolean> autoOpenGstScreenLiveData = new y<>();
    public y<Boolean> autoOpenNameScreenLiveData = new y<>();
    public ObservableBoolean bankChangeVisibility;
    public final y<Boolean> basicDetailsFlag = new y<>();
    public LiveData<b<BasicDetailsModel>> basicLiveData = ah.b(this.basicDetailsFlag, new a() {
        public final Object apply(Object obj) {
            return ProfileBusinessDetailsViewModel.this.lambda$new$3$ProfileBusinessDetailsViewModel((Boolean) obj);
        }
    });
    public i<String> bussinessName;
    public ObservableBoolean bwOptionProgress;
    public i<String> displayName;
    public ObservableBoolean displayNameChangeVisibility;
    public i<String> email;
    public String eventScreenName = getContext().getString(R.string.pr_profile_business_details_screen);
    public i<String> gstin;
    public ObservableBoolean gstinChangeVisibility;
    public IProfileBusinessDetails iProfileBusinessDetails;
    public ObservableBoolean isChangeNamePermissionAvailabel;
    public ObservableBoolean isDeactivateCtaActive;
    public boolean isDeeplinkOpened;
    public ObservableBoolean isGstinExist;
    public ObservableBoolean isGstinPending = new ObservableBoolean(false);
    public ObservableBoolean isMerchantAdmin;
    public ObservableBoolean isNonSDMerchant;
    public ObservableBoolean isRequestinProgress;
    public i<Boolean> isSingleName;
    public ObservableBoolean isTicketStatusFetched;
    public final y<Boolean> kycApiFlag = new y<>();
    public KycDetailsModel kycDetailsModel;
    public LiveData<b<KycDetailsModel>> kycLiveData = ah.b(this.kycApiFlag, new a() {
        public final Object apply(Object obj) {
            return ProfileBusinessDetailsViewModel.this.lambda$new$4$ProfileBusinessDetailsViewModel((Boolean) obj);
        }
    });
    public AddressDetailsModel mAddressDetailsModel;
    public BasicDetailsModel mBasicDetailsModel;
    public i<String> mCurrentPlanType;
    public i<Integer> mEdcDetailsVisibility;
    public i<String> mNumberOfDevicesUnderPlan;
    public final LiveData<b<FetchGstinStatusResponse>> mOEFetchGstinStatus = ah.b(this.mOEFetchGstinStatusApi, new a() {
        public final Object apply(Object obj) {
            return ProfileBusinessDetailsViewModel.this.lambda$new$0$ProfileBusinessDetailsViewModel((Boolean) obj);
        }
    });
    public final y<Boolean> mOEFetchGstinStatusApi = new y<>(Boolean.FALSE);
    public RentalPlanDetailsModel mRentalData;
    public i<List<RentalPlanDetailsModel.RentalSummaryData>> mRentalSummary;
    public i<String> mRentalforDevices;
    public i<String> mTotalRentalForKDevicesText;
    public i<String> mUsageDeposit;
    public i<String> mid;
    public i<String> mobileNumber;
    public i<String> name;
    public i<String> panNo;
    public final y<Boolean> rentalPlanApiDetailsDataApiFlag = new y<>();
    public LiveData<b<RentalPlanDetailsModel>> rentalPlanDetailsLiveData = ah.b(this.rentalPlanApiDetailsDataApiFlag, $$Lambda$ProfileBusinessDetailsViewModel$fScDQQsMPK6d2KHNp7n7vABvB0.INSTANCE);
    public ObservableBoolean showShimmer;
    public final y<Boolean> ticketStatusApiFlag = new y<>();
    public y<String> ticketStatusCaseId = new y<>("");
    public LiveData<b<ProfileTicketStatus>> ticketStatusLiveData = ah.b(this.ticketStatusApiFlag, new a() {
        public final Object apply(Object obj) {
            return ProfileBusinessDetailsViewModel.this.lambda$new$1$ProfileBusinessDetailsViewModel((Boolean) obj);
        }
    });

    public ProfileBusinessDetailsViewModel(Application application) {
        super(application);
    }

    public /* synthetic */ LiveData lambda$new$0$ProfileBusinessDetailsViewModel(Boolean bool) {
        if (!bool.booleanValue()) {
            return new com.business.common_module.utilities.a.a();
        }
        return ProfileRepository.getInstance().getGSTINLeadStatus(ProfileConfig.getInstance().getGTMDataProvider().getString("fetch_gstin_lead_status", ""), RequestParamUtil.getHeaders(this.mAppInstance));
    }

    public /* synthetic */ LiveData lambda$new$1$ProfileBusinessDetailsViewModel(Boolean bool) {
        return bool.booleanValue() ? ProfileRepository.getInstance().getMerchantProfileTicketStatus(this.eventScreenName) : new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$2$ProfileBusinessDetailsViewModel(Boolean bool) {
        if (!bool.booleanValue()) {
            return new com.business.common_module.utilities.a.a();
        }
        return ProfileRepository.getInstance().getProfileAddressDetailsApiCallNew(new GAEventModel(GTMDataProviderImpl.Companion.getMInstance().getMerchantAddress(), this.eventScreenName));
    }

    public /* synthetic */ LiveData lambda$new$3$ProfileBusinessDetailsViewModel(Boolean bool) {
        if (bool.booleanValue()) {
            return getProfileBasicApiCall();
        }
        return new com.business.common_module.utilities.a.a();
    }

    public /* synthetic */ LiveData lambda$new$4$ProfileBusinessDetailsViewModel(Boolean bool) {
        if (!bool.booleanValue()) {
            return new com.business.common_module.utilities.a.a();
        }
        return ProfileRepository.getInstance().getMerchantBankDetailsApi(new GAEventModel(GTMDataProviderImpl.Companion.getMInstance().getProfileKYCUrl(), this.eventScreenName));
    }

    public static /* synthetic */ LiveData lambda$new$5(Boolean bool) {
        if (bool.booleanValue()) {
            String edcRentalApi = GTMDataProviderImpl.Companion.getMInstance().getEdcRentalApi();
            if (!TextUtils.isEmpty(edcRentalApi)) {
                return ProfileRepository.getInstance().getRentalPlanDetails(edcRentalApi, RequestParamUtil.getEDCRentalPlansApiHeaders());
            }
        }
        return new com.business.common_module.utilities.a.a();
    }

    public void resetDeactCTA() {
        this.showShimmer.set(true);
        this.isDeactivateCtaActive.set(false);
        this.isRequestinProgress.set(false);
    }

    private LiveData<b<BasicDetailsModel>> getProfileBasicApiCall() {
        return ProfileRepository.getInstance().getProfileBasicApiCallNew(new GAEventModel(GTMDataProviderImpl.Companion.getMInstance().getBasicDetailAPI(), SCREEN_NAME));
    }

    public void callAllAPI() {
        startFetchGstinLeadOE();
        setAddressDetailsApiFlag(true);
        setTicketStatusApiFlag(true);
        setKycAPI(true);
    }

    public void setAddressDetailsApiFlag(boolean z) {
        this.addressDetailsApiFlag.setValue(Boolean.valueOf(z));
    }

    public void setTicketStatusApiFlag(boolean z) {
        this.ticketStatusApiFlag.setValue(Boolean.valueOf(z));
    }

    public void setBasicDetailsApi(boolean z) {
        this.basicDetailsFlag.setValue(Boolean.valueOf(z));
    }

    public void initDefaultParams() {
        this.name = new i<>("");
        this.displayName = new i<>("");
        this.bussinessName = new i<>("");
        this.isSingleName = new i<>(Boolean.FALSE);
        this.mobileNumber = new i<>("");
        this.email = new i<>("");
        this.gstin = new i<>("");
        this.mid = new i<>("");
        this.panNo = new i<>("");
        this.address = new i<>("");
        this.bwOptionProgress = new ObservableBoolean(false);
        this.bankChangeVisibility = new ObservableBoolean(false);
        this.gstinChangeVisibility = new ObservableBoolean(false);
        this.displayNameChangeVisibility = new ObservableBoolean(false);
        this.isGstinExist = new ObservableBoolean(false);
        this.isDeactivateCtaActive = new ObservableBoolean(false);
        this.showShimmer = new ObservableBoolean(true);
        this.isRequestinProgress = new ObservableBoolean(false);
        this.isChangeNamePermissionAvailabel = new ObservableBoolean(false);
        this.isMerchantAdmin = new ObservableBoolean(ProfileConfig.getInstance().getMerchantDataProvider().s());
        this.isNonSDMerchant = new ObservableBoolean(ProfileConfig.getInstance().getMerchantDataProvider().x());
        this.isTicketStatusFetched = new ObservableBoolean(false);
        this.mNumberOfDevicesUnderPlan = new i<>("");
        this.mRentalforDevices = new i<>("");
        this.mUsageDeposit = new i<>("");
        this.mCurrentPlanType = new i<>("");
        this.mEdcDetailsVisibility = new i<>(8);
        this.mRentalSummary = new i<>((h[]) null);
        this.mTotalRentalForKDevicesText = new i<>(getContext().getString(R.string.pr_total_rental_for_8_devices_excl_gst, new Object[]{this.mNumberOfDevicesUnderPlan.get()}));
    }

    public void setData(IProfileBusinessDetails iProfileBusinessDetails2, BasicDetailsModel basicDetailsModel) {
        this.iProfileBusinessDetails = iProfileBusinessDetails2;
        this.mBasicDetailsModel = basicDetailsModel;
        if (basicDetailsModel != null) {
            setBasicDetails();
        } else {
            setBasicDetailsApi(true);
        }
    }

    public void setAddressDetails(AddressDetailsModel addressDetailsModel) {
        this.mAddressDetailsModel = addressDetailsModel;
        this.address.set(AppUtility.getStringAddressDetailModel(addressDetailsModel));
    }

    public void setBasicDetails() {
        BasicDetailsModel basicDetailsModel = this.mBasicDetailsModel;
        if (basicDetailsModel != null) {
            this.name.set(basicDetailsModel.getBusinessName());
            this.mid.set(this.mBasicDetailsModel.getMid());
            this.email.set(this.mBasicDetailsModel.getEmailId());
            this.mobileNumber.set(this.mBasicDetailsModel.getMobileNo());
            this.bussinessName.set(this.mBasicDetailsModel.getBusinessName());
            this.displayName.set(this.mBasicDetailsModel.getDisplayName());
            if (this.mBasicDetailsModel.getBusinessName().isEmpty()) {
                this.bussinessName.set(this.mBasicDetailsModel.getDisplayName());
                this.isSingleName.set(Boolean.TRUE);
            } else if (this.mBasicDetailsModel.getBusinessName().toLowerCase().trim().equals(this.mBasicDetailsModel.getDisplayName().toLowerCase().trim())) {
                this.isSingleName.set(Boolean.TRUE);
            }
            ProfileSharedPreferences.getInstance().setCurrentMerchantName(this.displayName.get());
        }
        this.isMerchantAdmin.set(ProfileConfig.getInstance().getMerchantDataProvider().s());
    }

    public void setTicketStatus() {
        this.isTicketStatusFetched.set(true);
        if (this.ticketStatusLiveData.getValue() != null && this.ticketStatusLiveData.getValue().f7358c != null) {
            ProfileTicketStatus profileTicketStatus = (ProfileTicketStatus) this.ticketStatusLiveData.getValue().f7358c;
            if (profileTicketStatus.getBankDetails() != null) {
                this.iProfileBusinessDetails.handleBankChangeTicket(profileTicketStatus.getBankDetails());
            }
            if (!(this.mOEFetchGstinStatus.getValue() == null || this.mOEFetchGstinStatus.getValue().f7358c == null)) {
                String leadStatus = ((FetchGstinStatusResponse) this.mOEFetchGstinStatus.getValue().f7358c).getLeadStatus();
                if (GSTINLeadStatus.AWAITING_CLOSE.getValue().equalsIgnoreCase(leadStatus)) {
                    ProfileTicketStatus.TicketItem ticketItem = new ProfileTicketStatus.TicketItem();
                    ticketItem.setStatus("PENDING");
                    this.isGstinPending.set(true);
                    this.iProfileBusinessDetails.handleGstinChangeTicket(ticketItem);
                } else if (GSTINLeadStatus.LEAD_NOT_PRESENT.getValue().equalsIgnoreCase(leadStatus)) {
                    if (profileTicketStatus.getGstinOE() != null && "PENDING".equalsIgnoreCase(profileTicketStatus.getGstinOE().getStatus())) {
                        ProfileTicketStatus.TicketItem ticketItem2 = new ProfileTicketStatus.TicketItem();
                        ticketItem2.setStatus("PENDING");
                        ticketItem2.setCaseId(profileTicketStatus.getGstinOE().getCaseId());
                        this.isGstinPending.set(true);
                        this.iProfileBusinessDetails.handleGstinChangeTicket(ticketItem2);
                    } else if (profileTicketStatus.getGstinOE() != null) {
                        if (profileTicketStatus.getGstinOE().getStatus().equalsIgnoreCase("PENDING")) {
                            this.isGstinPending.set(true);
                        } else {
                            this.isGstinPending.set(false);
                        }
                        this.iProfileBusinessDetails.handleGstinChangeTicket(profileTicketStatus.getGstinOE());
                    } else {
                        this.isGstinPending.set(false);
                    }
                } else if (GSTINLeadStatus.LEAD_CLOSED.getValue().equalsIgnoreCase(leadStatus)) {
                    ProfileTicketStatus.TicketItem ticketItem3 = new ProfileTicketStatus.TicketItem();
                    ticketItem3.setStatus("SUCCESS");
                    this.iProfileBusinessDetails.handleGstinChangeTicket(ticketItem3);
                    this.isGstinPending.set(false);
                } else if (profileTicketStatus.getGstinOE() != null) {
                    if (profileTicketStatus.getGstinOE().getStatus().equalsIgnoreCase("PENDING")) {
                        this.isGstinPending.set(true);
                    } else {
                        this.isGstinPending.set(false);
                    }
                    this.iProfileBusinessDetails.handleGstinChangeTicket(profileTicketStatus.getGstinOE());
                } else {
                    this.isGstinPending.set(false);
                }
            }
            if (profileTicketStatus.getDisplayName() != null) {
                this.iProfileBusinessDetails.handleDisplayNameChangeTicket(profileTicketStatus.getDisplayName());
            }
            if (ProfileConfig.getInstance().getMerchantDataProvider().c()) {
                if (profileTicketStatus == null || profileTicketStatus.getDeactivateMerchant() == null || !profileTicketStatus.getDeactivateMerchant().getStatus().equalsIgnoreCase(SDKConstants.GA_KEY_NEW)) {
                    this.iProfileBusinessDetails.handleActiveMerchantAccountState(false);
                } else {
                    this.iProfileBusinessDetails.handleActiveMerchantAccountState(true);
                }
            }
            this.showShimmer.set(false);
        }
    }

    public void setRentalPlansApiData(int i2) {
        if (this.rentalPlanDetailsLiveData.getValue() != null && this.rentalPlanDetailsLiveData.getValue().f7358c != null && this.rentalPlanDetailsLiveData.getValue().f7357b == e.SUCCESS) {
            RentalPlanDetailsModel rentalPlanDetailsModel = (RentalPlanDetailsModel) this.rentalPlanDetailsLiveData.getValue().f7358c;
            if (rentalPlanDetailsModel.getResults() != null && rentalPlanDetailsModel.getResults().getRentalSummary() != null && rentalPlanDetailsModel.getResults().getRentalSummary().size() > 0 && i2 >= 0 && i2 < rentalPlanDetailsModel.getResults().getRentalSummary().size()) {
                RentalPlanDetailsModel.RentalSummaryData rentalSummaryData = rentalPlanDetailsModel.getResults().getRentalSummary().get(i2);
                this.mCurrentPlanType.set(rentalSummaryData.getPlanType());
                this.mNumberOfDevicesUnderPlan.set(rentalSummaryData.getDeviceCount());
                i<String> iVar = this.mRentalforDevices;
                iVar.set(ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_rupee_symbol) + rentalSummaryData.getTotalRental());
                i<String> iVar2 = this.mUsageDeposit;
                iVar2.set(ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_rupee_symbol) + rentalPlanDetailsModel.getResults().getUsageDeposit());
                this.mEdcDetailsVisibility.set(0);
                this.mRentalSummary.set(rentalPlanDetailsModel.getResults().getRentalSummary());
                this.mTotalRentalForKDevicesText.set(ProfileConfig.getInstance().getAppContext().getResources().getString(R.string.pr_total_rental_for_8_devices_excl_gst, new Object[]{this.mNumberOfDevicesUnderPlan.get()}));
            }
        }
    }

    public void onEDCRentalApiResponse() {
        setRentalPlansApiData(0);
    }

    public EditGstinAddress getEditGstinAddressModel() {
        EditGstinAddress editGstinAddress = new EditGstinAddress();
        editGstinAddress.setPanNo(this.panNo.get());
        editGstinAddress.setOldGstin(this.gstin.get());
        editGstinAddress.setOldBillingAddress(this.mAddressDetailsModel);
        return editGstinAddress;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateEditedValue(com.paytm.business.merchantprofile.event.EditBusinessDetailEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getType()
            int r1 = r0.hashCode()
            r2 = 1
            r3 = -1339964514(0xffffffffb021c39e, float:-5.884945E-10)
            if (r1 == r3) goto L_0x001e
            r3 = -608658121(0xffffffffdbb89d37, float:-1.03928511E17)
            if (r1 != r3) goto L_0x0029
            java.lang.String r1 = "update_gstin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x001e:
            java.lang.String r1 = "update_display_name"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x005c
            if (r0 != r2) goto L_0x00b5
            com.paytm.business.merchantprofile.model.EditGstinAddress r0 = r5.getEditGstinAddress()
            if (r0 == 0) goto L_0x0052
            com.paytm.business.merchantprofile.model.EditGstinAddress r0 = r5.getEditGstinAddress()
            boolean r0 = r0.isAddressOnly()
            if (r0 == 0) goto L_0x0052
            com.paytm.business.merchantprofile.model.EditGstinAddress r5 = r5.getEditGstinAddress()
            com.paytm.business.merchantprofile.model.AddressDetailsModel r5 = r5.getNewBillingAddress()
            r4.mAddressDetailsModel = r5
            androidx.databinding.i<java.lang.String> r0 = r4.address
            java.lang.String r5 = com.paytm.business.merchantprofile.common.utility.AppUtility.getStringAddressDetailModel(r5)
            r0.set(r5)
            return
        L_0x0052:
            com.paytm.business.merchantprofile.listener.IProfileBusinessDetails r5 = r4.iProfileBusinessDetails
            com.paytm.business.merchantprofile.model.ProfileTicketStatus$TicketItem r0 = r4.getCompletedGstinTicketItem()
            r5.handleGstinChangeTicket(r0)
            return
        L_0x005c:
            java.lang.String r0 = r5.getValue()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ac
            androidx.databinding.i<java.lang.String> r0 = r4.displayName
            java.lang.String r1 = r5.getValue()
            r0.set(r1)
            androidx.databinding.i<java.lang.String> r0 = r4.bussinessName
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x00a0
            androidx.databinding.i<java.lang.String> r0 = r4.bussinessName
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = r5.getValue()
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r1 = r1.trim()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a0
            androidx.databinding.i<java.lang.Boolean> r0 = r4.isSingleName
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.set(r1)
        L_0x00a0:
            com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences r0 = com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences.getInstance()
            java.lang.String r5 = r5.getValue()
            r0.setCurrentMerchantName(r5)
            return
        L_0x00ac:
            com.paytm.business.merchantprofile.listener.IProfileBusinessDetails r5 = r4.iProfileBusinessDetails
            com.paytm.business.merchantprofile.model.ProfileTicketStatus$TicketItem r0 = r4.getNewTicketItem()
            r5.handleDisplayNameChangeTicket(r0)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel.updateEditedValue(com.paytm.business.merchantprofile.event.EditBusinessDetailEvent):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTicketStatus(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r2 = r2.toLowerCase()
            int r0 = r2.hashCode()
            switch(r0) {
                case -1867169789: goto L_0x00a6;
                case -1638156514: goto L_0x009c;
                case -1402931637: goto L_0x0091;
                case -1322190954: goto L_0x0086;
                case -1046275722: goto L_0x007b;
                case -896770043: goto L_0x006f;
                case -748084885: goto L_0x0065;
                case -713556508: goto L_0x005a;
                case -682587753: goto L_0x004f;
                case -663317164: goto L_0x0044;
                case -599992529: goto L_0x0039;
                case 108960: goto L_0x002e;
                case 3417674: goto L_0x0023;
                case 311186755: goto L_0x0018;
                case 909281459: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x00b2
        L_0x000d:
            java.lang.String r0 = "pending with other department"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 5
            goto L_0x00b3
        L_0x0018:
            java.lang.String r0 = "re-opened"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 2
            goto L_0x00b3
        L_0x0023:
            java.lang.String r0 = "open"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 0
            goto L_0x00b3
        L_0x002e:
            java.lang.String r0 = "new"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 1
            goto L_0x00b3
        L_0x0039:
            java.lang.String r0 = "pending with customer"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 3
            goto L_0x00b3
        L_0x0044:
            java.lang.String r0 = "pending with agent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 7
            goto L_0x00b3
        L_0x004f:
            java.lang.String r0 = "pending"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 9
            goto L_0x00b3
        L_0x005a:
            java.lang.String r0 = "junk ticket"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 13
            goto L_0x00b3
        L_0x0065:
            java.lang.String r0 = "internal discussion"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 6
            goto L_0x00b3
        L_0x006f:
            java.lang.String r0 = "solved"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 10
            goto L_0x00b3
        L_0x007b:
            java.lang.String r0 = "notification received"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 8
            goto L_0x00b3
        L_0x0086:
            java.lang.String r0 = "auto solved"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 14
            goto L_0x00b3
        L_0x0091:
            java.lang.String r0 = "completed"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 11
            goto L_0x00b3
        L_0x009c:
            java.lang.String r0 = "customer response received"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 4
            goto L_0x00b3
        L_0x00a6:
            java.lang.String r0 = "success"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00b2
            r2 = 12
            goto L_0x00b3
        L_0x00b2:
            r2 = -1
        L_0x00b3:
            switch(r2) {
                case 0: goto L_0x00bc;
                case 1: goto L_0x00bc;
                case 2: goto L_0x00bc;
                case 3: goto L_0x00bc;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00bc;
                case 6: goto L_0x00bc;
                case 7: goto L_0x00bc;
                case 8: goto L_0x00bc;
                case 9: goto L_0x00bc;
                case 10: goto L_0x00b9;
                case 11: goto L_0x00b9;
                case 12: goto L_0x00b9;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            java.lang.String r2 = "FAILURE"
            return r2
        L_0x00b9:
            java.lang.String r2 = "SUCCESS"
            return r2
        L_0x00bc:
            java.lang.String r2 = "PENDING"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.viewmodel.ProfileBusinessDetailsViewModel.getTicketStatus(java.lang.String):java.lang.String");
    }

    private ProfileTicketStatus.TicketItem getNewTicketItem() {
        ProfileTicketStatus.TicketItem ticketItem = new ProfileTicketStatus.TicketItem();
        ticketItem.setStatus("new");
        return ticketItem;
    }

    public void setKycDetails() {
        if (this.kycLiveData.getValue() != null && this.kycLiveData.getValue().f7358c != null && this.kycLiveData.getValue().f7357b == e.SUCCESS) {
            KycDetailsModel kycDetailsModel2 = (KycDetailsModel) this.kycLiveData.getValue().f7358c;
            this.kycDetailsModel = kycDetailsModel2;
            if (!TextUtils.isEmpty(kycDetailsModel2.getPanNo())) {
                this.panNo.set(this.kycDetailsModel.getPanNo());
            } else {
                this.panNo.set("");
            }
            if (!TextUtils.isEmpty(this.kycDetailsModel.getGstin())) {
                this.gstin.set(this.kycDetailsModel.getGstin());
                this.isGstinExist.set(true);
                return;
            }
            this.gstin.set("");
            this.isGstinExist.set(false);
        }
    }

    public void setKycAPI(boolean z) {
        this.kycApiFlag.setValue(Boolean.TRUE);
    }

    public void checkAndOpenDeeplinkScreen(int i2) {
        if (!this.isDeeplinkOpened && i2 != -1) {
            switch (i2) {
                case 129:
                    if (this.basicLiveData.getValue() != null && this.basicLiveData.getValue().f7358c != null) {
                        this.isDeeplinkOpened = true;
                        this.autoOpenNameScreenLiveData.postValue(Boolean.TRUE);
                        return;
                    }
                    return;
                case 130:
                    if (this.basicLiveData.getValue() != null && this.basicLiveData.getValue().f7358c != null && this.kycLiveData.getValue() != null && this.kycLiveData.getValue().f7358c != null) {
                        this.isDeeplinkOpened = true;
                        this.autoOpenGstScreenLiveData.setValue(Boolean.TRUE);
                        return;
                    }
                    return;
                case 131:
                    if (this.basicLiveData.getValue() != null && this.basicLiveData.getValue().f7358c != null) {
                        this.isDeeplinkOpened = true;
                        this.autoOpenAddressScreenLiveData.setValue(Boolean.TRUE);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public String getGstinTicketCaseId() {
        return this.ticketStatusCaseId.getValue();
    }

    private ProfileTicketStatus.TicketItem getCompletedGstinTicketItem() {
        ProfileTicketStatus.TicketItem ticketItem = new ProfileTicketStatus.TicketItem();
        ticketItem.setStatus("completed");
        ticketItem.setCaseId(getGstinTicketCaseId());
        return ticketItem;
    }

    public void startRentalPlanApiCall() {
        this.rentalPlanApiDetailsDataApiFlag.setValue(Boolean.TRUE);
    }

    public void startFetchGstinLeadOE() {
        this.mOEFetchGstinStatusApi.setValue(Boolean.TRUE);
    }
}
