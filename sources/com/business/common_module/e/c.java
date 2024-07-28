package com.business.common_module.e;

import com.business.common_module.f.a;
import java.util.ArrayList;

public final class c extends a {
    private static final long serialVersionUID = 421740982163208147L;
    private ArrayList<String> permissions;
    private String role;

    public final ArrayList<String> getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(ArrayList<String> arrayList) {
        this.permissions = arrayList;
    }

    public final String getRole() {
        return this.role;
    }

    public final void setRole(String str) {
        this.role = str;
    }
}
