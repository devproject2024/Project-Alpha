package org.apache.http;

import java.io.IOException;
import java.io.InputStream;

public interface g {
    InputStream getContent() throws IOException, UnsupportedOperationException;

    b getContentEncoding();

    long getContentLength();

    b getContentType();
}
