package com.google.gson;

import com.google.gson.internal.k;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class q {
    public static l a(String str) throws u {
        return a((Reader) new StringReader(str));
    }

    public static l a(Reader reader) throws m, u {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            l a2 = a(jsonReader);
            if (!(a2 instanceof n)) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new u("Did not consume the entire document.");
                }
            }
            return a2;
        } catch (MalformedJsonException e2) {
            throw new u((Throwable) e2);
        } catch (IOException e3) {
            throw new m((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new u((Throwable) e4);
        }
    }

    private static l a(JsonReader jsonReader) throws m, u {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            l a2 = k.a(jsonReader);
            jsonReader.setLenient(isLenient);
            return a2;
        } catch (StackOverflowError e2) {
            throw new p("Failed parsing JSON source: " + jsonReader + " to Json", e2);
        } catch (OutOfMemoryError e3) {
            throw new p("Failed parsing JSON source: " + jsonReader + " to Json", e3);
        } catch (Throwable th) {
            jsonReader.setLenient(isLenient);
            throw th;
        }
    }
}
