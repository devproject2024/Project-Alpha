package com.paytm.business.merchantprofile.listener;

import com.business.common_module.utilities.d;
import com.paytm.business.merchantprofile.model.EditGstinAddress;
import com.paytm.business.merchantprofile.model.ProfileTicketStatus;

public interface IProfileBusinessDetails extends d {
    void handleActiveMerchantAccountState(boolean z);

    void handleBankChangeTicket(ProfileTicketStatus.TicketItem ticketItem);

    void handleDisplayNameChangeTicket(ProfileTicketStatus.TicketItem ticketItem);

    void handleFetchLeadStatusApi(String str, boolean z, String str2, boolean z2);

    void handleGstinChangeTicket(ProfileTicketStatus.TicketItem ticketItem);

    void showBasicDetailsDialogFragment(String str, String str2);

    void showEditAddressDialogFragment(EditGstinAddress editGstinAddress);

    void showEditGstinDialogFragment(EditGstinAddress editGstinAddress);
}
