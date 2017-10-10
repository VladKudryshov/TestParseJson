package com.git.vladkudryshov.testparsejson.mocks;

import junit.framework.Assert;

import java.io.InputStream;

public final class Mocks {

    public static InputStream stream(final String pName) {
        final InputStream resourceAsStream = Mocks.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("resource not found, maybe you forget add .json?", resourceAsStream);
        return resourceAsStream;
    }
}