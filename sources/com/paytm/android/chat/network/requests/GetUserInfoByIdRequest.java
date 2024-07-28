package com.paytm.android.chat.network.requests;

import c.a.a.a;
import com.google.gson.f;
import com.google.gson.o;
import com.paytm.android.chat.bean.UiInfo;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GetUserInfoByIdRequest extends BaseRequest {

    public interface GetUsersInfoCallBack {
        void onFailure(int i2, String str);

        void onGettingGoldData(String str, String str2);

        void onSuccess(String str, UsersInfoJsonBean usersInfoJsonBean);
    }

    public GetUserInfoByIdRequest(String str, final GetUsersInfoCallBack getUsersInfoCallBack) {
        String url = UrlManager.getUrl(UrlProfileList.GET_USER_INFO_BY_ID);
        q.b("url:".concat(String.valueOf(url)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.baseData.c("application/json", new f().b(arrayList));
        c.a.a.f.b(url, this.baseData, new a<String>() {
            public final /* synthetic */ void a(Object obj) {
                String str = (String) obj;
                q.a("====get GetUserInfoByIdRequest response ".concat(String.valueOf(str)));
                try {
                    new com.google.gson.q();
                    o h2 = com.google.gson.q.a(str).h();
                    f fVar = new f();
                    String lVar = h2.b("data").toString();
                    if (lVar == null || lVar.isEmpty()) {
                        getUsersInfoCallBack.onFailure(-1, "user info is Empty");
                    } else if (lVar == null || "null".equals(lVar)) {
                        getUsersInfoCallBack.onFailure(-1, "user info is Empty");
                    } else {
                        try {
                            new com.google.gson.q();
                            o h3 = com.google.gson.q.a(lVar).h();
                            Map map = (Map) fVar.a(h3.b("userDTOMap").toString(), new com.google.gson.b.a<Map<String, UsersInfoJsonBean>>() {
                            }.getType());
                            if (map == null || map.isEmpty()) {
                                getUsersInfoCallBack.onSuccess("0", (UsersInfoJsonBean) null);
                            } else {
                                Iterator it2 = map.keySet().iterator();
                                if (it2.hasNext()) {
                                    String str2 = (String) it2.next();
                                    q.b("key= " + str2 + " and value= " + map.get(str2));
                                    map.get(str2);
                                    GetUsersInfoCallBack getUsersInfoCallBack = getUsersInfoCallBack;
                                    if (getUsersInfoCallBack != null) {
                                        getUsersInfoCallBack.onSuccess(str2, (UsersInfoJsonBean) map.get(str2));
                                    }
                                }
                            }
                            try {
                                UiInfo uiInfo = (UiInfo) fVar.a(h3.b("uiInfo").toString(), UiInfo.class);
                                getUsersInfoCallBack.onGettingGoldData(URLDecoder.decode(uiInfo.getTopRightIcon().getIconUrl(), AppConstants.UTF_8), URLDecoder.decode(uiInfo.getTopRightIcon().getDeepLink(), AppConstants.UTF_8));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            GetUsersInfoCallBack getUsersInfoCallBack2 = getUsersInfoCallBack;
                            if (getUsersInfoCallBack2 != null) {
                                getUsersInfoCallBack2.onFailure(-1, " server data parse error");
                            }
                        }
                    }
                } catch (Exception unused3) {
                    GetUsersInfoCallBack getUsersInfoCallBack3 = getUsersInfoCallBack;
                    if (getUsersInfoCallBack3 != null) {
                        getUsersInfoCallBack3.onFailure(-1, " server data parse error");
                    }
                }
            }

            public final void a(int i2, String str) {
                GetUsersInfoCallBack getUsersInfoCallBack = getUsersInfoCallBack;
                if (getUsersInfoCallBack != null) {
                    getUsersInfoCallBack.onFailure(i2, str);
                }
            }
        });
    }
}
