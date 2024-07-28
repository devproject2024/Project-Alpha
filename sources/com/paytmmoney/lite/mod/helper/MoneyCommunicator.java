package com.paytmmoney.lite.mod.helper;

public class MoneyCommunicator {
    private static MoneyCommunicator mInstance;
    private IMoneyListener iMoneyListener;

    private MoneyCommunicator() {
    }

    public static void init(IMoneyListener iMoneyListener2) {
        if (mInstance == null) {
            MoneyCommunicator moneyCommunicator = new MoneyCommunicator();
            mInstance = moneyCommunicator;
            moneyCommunicator.iMoneyListener = iMoneyListener2;
        }
    }

    public static MoneyCommunicator getInstance() {
        MoneyCommunicator moneyCommunicator = mInstance;
        if (moneyCommunicator != null) {
            return moneyCommunicator;
        }
        throw new RuntimeException("getInstance() called before MoneyImplProvider's init()");
    }

    public static IMoneyListener getMoneyHelper() {
        return getInstance().iMoneyListener;
    }
}
