package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public final class c implements Serializable {
    @b(a = "message")
    private d message;
    @b(a = "result")
    private String result;

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final d getMessage() {
        return this.message;
    }

    public final void setMessage(d dVar) {
        this.message = dVar;
    }
}
