package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class ChequeBookResponse extends IJRPaytmDataModel {
    @b(a = "pendingChequeBooks")
    private List<PendingChequeBook> pendingChequeBooks = new ArrayList();
    @b(a = "signature")
    private ChequeBookSignature signature;

    public ChequeBookSignature getSignature() {
        return this.signature;
    }

    public void setSignature(ChequeBookSignature chequeBookSignature) {
        this.signature = chequeBookSignature;
    }

    public List<PendingChequeBook> getPendingChequeBooks() {
        return this.pendingChequeBooks;
    }

    public void setPendingChequeBooks(List<PendingChequeBook> list) {
        this.pendingChequeBooks = list;
    }
}
