package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserList;
import com.git.vladkudryshov.testparsejson.parser.IUserListParser;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UserListGsonParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UserListGsonParser(final InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUserList parse() throws Exception {
        final Reader reader = new InputStreamReader(mIntputStream);
        final IUser[] result = new Gson().fromJson(reader, UserGson[].class);
        return new UserGsonList(Arrays.asList(result));
    }
}
