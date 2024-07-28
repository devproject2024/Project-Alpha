package com.travel.flight.pojo.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRFareAlertHomeAnalyticsModel extends IJRPaytmDataModel {
    private b body;
    private String code;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public c f25425a;

        /* renamed from: b  reason: collision with root package name */
        public String f25426b;

        /* renamed from: c  reason: collision with root package name */
        public String f25427c;

        /* renamed from: d  reason: collision with root package name */
        public String f25428d;

        /* renamed from: e  reason: collision with root package name */
        public String f25429e;

        /* renamed from: f  reason: collision with root package name */
        public String f25430f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25431g;
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<a> f25432a;
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f25433a;

        /* renamed from: b  reason: collision with root package name */
        public String f25434b;

        /* renamed from: c  reason: collision with root package name */
        public String f25435c;

        /* renamed from: d  reason: collision with root package name */
        public String f25436d;
    }

    public b getBody() {
        return this.body;
    }

    public void setBody(b bVar) {
        this.body = bVar;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }
}
