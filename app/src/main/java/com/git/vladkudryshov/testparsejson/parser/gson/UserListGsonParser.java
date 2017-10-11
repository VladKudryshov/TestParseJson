package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserList;
import com.git.vladkudryshov.testparsejson.parser.IUserListParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

public class UserListGsonParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UserListGsonParser(final InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUserList parse() throws Exception {
        final JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(final JsonElement json, final Type typeOfT,
                                    final JsonDeserializationContext context) throws JsonParseException {
                return json == null ? null : new Date(json.getAsLong());
            }
        };

        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, deser).create();
        final Reader reader = new InputStreamReader(mIntputStream);
        final IUser[] result = gson.fromJson(reader, UserGson[].class);
        return new UserGsonList(Arrays.asList(result));
    }
}
