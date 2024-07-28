package com.paytm.notification.data.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.notification.models.InboxMessageResponse;
import com.paytm.notification.models.request.FetchInboxRequest;
import com.paytm.pai.network.model.EventResponse;
import java.util.ArrayList;
import java.util.List;

public interface f {
    LiveData<List<com.paytm.notification.data.datasource.dao.f>> a();

    EventResponse<Boolean> a(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4);

    EventResponse<ArrayList<InboxMessageResponse>> a(String str, String str2, String str3, String str4, FetchInboxRequest fetchInboxRequest);

    ArrayList<com.paytm.notification.data.datasource.dao.f> a(String str);

    ArrayList<InboxMessageResponse> a(ArrayList<InboxMessageResponse> arrayList, String str);

    void a(String str, String str2);

    EventResponse<Boolean> b(FetchInboxRequest fetchInboxRequest, String str, String str2, String str3, String str4);

    ArrayList<String> b();

    ArrayList<com.paytm.notification.data.datasource.dao.f> b(String str);

    void b(ArrayList<String> arrayList, String str);

    void c();

    void c(String str);

    int d();

    y<Integer> e();

    void f();
}
