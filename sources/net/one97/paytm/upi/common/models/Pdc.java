package net.one97.paytm.upi.common.models;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class Pdc extends Vdc implements UpiBaseDataModel {
    String imageId;
    String orderId;
    String walletQRCode;
}
