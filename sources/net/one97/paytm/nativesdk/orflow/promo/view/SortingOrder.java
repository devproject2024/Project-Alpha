package net.one97.paytm.nativesdk.orflow.promo.view;

public final class SortingOrder {
    public static final SortingOrder INSTANCE = new SortingOrder();
    private static final int NB = 6;
    private static final int PPBL = 3;
    private static final int Postpaid = 2;
    private static final int SavedCC = 5;
    private static final int SavedDC = 4;
    private static final int UPICollect = 9;
    private static final int UpiPush = 1;
    private static final int newCC = 8;
    private static final int newDC = 7;

    private SortingOrder() {
    }

    public final int getUpiPush() {
        return UpiPush;
    }

    public final int getPostpaid() {
        return Postpaid;
    }

    public final int getPPBL() {
        return PPBL;
    }

    public final int getSavedDC() {
        return SavedDC;
    }

    public final int getSavedCC() {
        return SavedCC;
    }

    public final int getNB() {
        return NB;
    }

    public final int getNewDC() {
        return newDC;
    }

    public final int getNewCC() {
        return newCC;
    }

    public final int getUPICollect() {
        return UPICollect;
    }
}
