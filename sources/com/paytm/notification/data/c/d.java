package com.paytm.notification.data.c;

import com.paytm.notification.data.datasource.dao.c;
import com.paytm.notification.models.FlashFetchResponse;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.pai.network.model.EventResponse;
import java.util.ArrayList;
import java.util.List;

public interface d {
    EventResponse<Boolean> a(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4);

    EventResponse<ArrayList<FlashFetchResponse>> a(String str, String str2, String str3, String str4, FetchInboxRequest fetchInboxRequest);

    List<c> a() throws Exception;

    List<String> a(String str);

    void a(c cVar) throws Exception;

    void a(String str, String str2) throws Exception;

    void a(List<String> list, String str);

    c b(String str);

    ArrayList<String> b();

    List<c> b(List<c> list, String str);

    void b(String str, String str2);

    void c();

    List<c> d();
}
