package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class UserVpaInfoList extends IJRDataModel {
    public UserVPAInfos list;

    public static class UserVPAInfos extends ArrayList<UserVpaInfo> {
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.list = (UserVPAInfos) fVar.a(str, UserVPAInfos.class);
        return super.parseResponse(str, fVar);
    }
}
