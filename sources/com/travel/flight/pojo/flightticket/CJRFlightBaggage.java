package com.travel.flight.pojo.flightticket;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightBaggage implements IJRDataModel {
    @com.google.gsonhtcfix.a.b(a = "body")
    private List<Object> body = new ArrayList();
    @com.google.gsonhtcfix.a.b(a = "code")
    private Integer code;
    @com.google.gsonhtcfix.a.b(a = "error")
    private Object error;
    @com.google.gsonhtcfix.a.b(a = "meta")
    private a meta;
    @com.google.gsonhtcfix.a.b(a = "status")
    private b status;

    public class a {
    }

    public class b {
    }

    public Object getError() {
        return this.error;
    }

    public void setError(Object obj) {
        this.error = obj;
    }

    public b getStatus() {
        return this.status;
    }

    public void setStatus(b bVar) {
        this.status = bVar;
    }

    public List<Object> getBody() {
        return this.body;
    }

    public void setBody(List<Object> list) {
        this.body = list;
    }

    public a getMeta() {
        return this.meta;
    }

    public void setMeta(a aVar) {
        this.meta = aVar;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }
}
