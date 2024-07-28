package net.one97.paytm.upi.common.models;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public class Vdc implements UpiBaseDataModel {
    String cardAlias;
    String cardStatus;
    String maskedCardNumber;
    String status;
}
