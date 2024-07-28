package net.one97.paytm.nativesdk.bank_mandate.listeners;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandateIFSCBranchDetails;
import net.one97.paytm.nativesdk.common.listeners.NetworkUnavailable;

public interface BankMandateProviderListener extends NetworkUnavailable {
    void onBankListReceived(ArrayList<String> arrayList);

    void onBranchListReceived(ArrayList<BankMandateIFSCBranchDetails> arrayList);

    void onCityListReceived(ArrayList<String> arrayList);

    void onStateListReceived(ArrayList<String> arrayList);
}
