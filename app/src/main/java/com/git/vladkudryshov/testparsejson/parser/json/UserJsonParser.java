package com.git.vladkudryshov.testparsejson.parser.json;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserParser;

import org.json.JSONObject;

public class UserJsonParser implements IUserParser {

    private final String mResource;

    public UserJsonParser(final String pResource) {
        mResource = pResource;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mResource);
        return new UserJson(jsonObject);
    }
}
