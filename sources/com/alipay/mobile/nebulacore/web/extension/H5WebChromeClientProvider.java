package com.alipay.mobile.nebulacore.web.extension;

import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;

public interface H5WebChromeClientProvider {
    H5WebChromeClient createWebChromeClient(H5PageImpl h5PageImpl);
}
