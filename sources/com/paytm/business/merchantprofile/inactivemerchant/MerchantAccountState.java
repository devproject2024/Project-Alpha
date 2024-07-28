package com.paytm.business.merchantprofile.inactivemerchant;

import androidx.lifecycle.y;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MerchantAccountState {
    public final y<AccountActivationState> accountState;
    public final y<MerchantAccountActivationUIState> uiState;

    public MerchantAccountState() {
        this((y) null, (y) null, 3, (g) null);
    }

    public static /* synthetic */ MerchantAccountState copy$default(MerchantAccountState merchantAccountState, y<AccountActivationState> yVar, y<MerchantAccountActivationUIState> yVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            yVar = merchantAccountState.accountState;
        }
        if ((i2 & 2) != 0) {
            yVar2 = merchantAccountState.uiState;
        }
        return merchantAccountState.copy(yVar, yVar2);
    }

    public final y<AccountActivationState> component1() {
        return this.accountState;
    }

    public final y<MerchantAccountActivationUIState> component2() {
        return this.uiState;
    }

    public final MerchantAccountState copy(y<AccountActivationState> yVar, y<MerchantAccountActivationUIState> yVar2) {
        k.d(yVar, "accountState");
        k.d(yVar2, "uiState");
        return new MerchantAccountState(yVar, yVar2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantAccountState)) {
            return false;
        }
        MerchantAccountState merchantAccountState = (MerchantAccountState) obj;
        return k.a((Object) this.accountState, (Object) merchantAccountState.accountState) && k.a((Object) this.uiState, (Object) merchantAccountState.uiState);
    }

    public final int hashCode() {
        y<AccountActivationState> yVar = this.accountState;
        int i2 = 0;
        int hashCode = (yVar != null ? yVar.hashCode() : 0) * 31;
        y<MerchantAccountActivationUIState> yVar2 = this.uiState;
        if (yVar2 != null) {
            i2 = yVar2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MerchantAccountState(accountState=" + this.accountState + ", uiState=" + this.uiState + ")";
    }

    public MerchantAccountState(y<AccountActivationState> yVar, y<MerchantAccountActivationUIState> yVar2) {
        k.d(yVar, "accountState");
        k.d(yVar2, "uiState");
        this.accountState = yVar;
        this.uiState = yVar2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantAccountState(y yVar, y yVar2, int i2, g gVar) {
        this((i2 & 1) != 0 ? new y(null) : yVar, (i2 & 2) != 0 ? new y(null) : yVar2);
    }

    public final y<AccountActivationState> getAccountState() {
        return this.accountState;
    }

    public final y<MerchantAccountActivationUIState> getUiState() {
        return this.uiState;
    }
}
