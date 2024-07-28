package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConcessionObj implements IJRDataModel {
    @a
    @b(a = "cat_card")
    private CJRCatCard catCard;
    @a
    @b(a = "general_public")
    private k generalPublic;
    @a
    @b(a = "senior_citizen")
    private CJRSeniorCitizen seniorCitizen;

    public CJRCatCard getCatCard() {
        return this.catCard;
    }

    public CJRSeniorCitizen getSeniorCitizen() {
        return this.seniorCitizen;
    }

    public k getGeneralPublic() {
        return this.generalPublic;
    }
}
