package com.git.vladkudryshov.testparsejson.http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
