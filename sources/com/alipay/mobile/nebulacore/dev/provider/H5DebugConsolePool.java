package com.alipay.mobile.nebulacore.dev.provider;

import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebulacore.dev.bugme.H5BugmeConsole;
import java.util.HashMap;

public class H5DebugConsolePool {
    private static H5DebugConsolePool instance;
    private HashMap<String, H5BugmeConsole> mapViewToConsole = new HashMap<>();

    private H5DebugConsolePool() {
    }

    public static H5DebugConsolePool getInstance() {
        if (instance == null) {
            instance = new H5DebugConsolePool();
        }
        return instance;
    }

    public H5BugmeConsole addOrGetConsole(H5Page h5Page) {
        String bugmeViewId = H5BugmeIdGenerator.getBugmeViewId(h5Page);
        H5BugmeConsole h5BugmeConsole = this.mapViewToConsole.get(bugmeViewId);
        if (h5BugmeConsole != null) {
            return h5BugmeConsole;
        }
        H5BugmeConsole h5BugmeConsole2 = new H5BugmeConsole(h5Page.getWebView(), h5Page.getContext().getContext());
        this.mapViewToConsole.put(bugmeViewId, h5BugmeConsole2);
        return h5BugmeConsole2;
    }

    public H5BugmeConsole getConsole(String str) {
        return this.mapViewToConsole.get(str);
    }

    public void release(String str) {
        H5BugmeConsole remove = this.mapViewToConsole.remove(str);
        if (remove != null) {
            remove.release();
        }
    }
}
