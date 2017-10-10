package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserParser;
import com.google.gson.Gson;

public class UserGsonParser implements IUserParser {


    private final String mSource;

    public UserGsonParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        return new Gson().fromJson(mSource,UserGson.class);
    }
}
