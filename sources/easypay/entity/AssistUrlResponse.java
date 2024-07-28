package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class AssistUrlResponse implements Serializable {
    @c(a = "operations")
    private ArrayList<Operation> operations = null;
    @c(a = "url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public ArrayList<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(ArrayList<Operation> arrayList) {
        this.operations = arrayList;
    }
}
