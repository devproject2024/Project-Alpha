package net.one97.paytm.common.entity.vipcashback;

import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;

public class PostTxnScratchCardWrapper {
    public boolean isStageComplete;
    public boolean openLandingScreen;
    public ArrayList<ScratchCard> scratchCards;
    public VIPCashBackOfferV4 vipCashBackOfferV4;
}
