package com.git.vladkudryshov.testparsejson.parser;

import java.text.ParseException;
import java.util.Date;

public interface IUser {

    long getId();

    String getFirstName();

    String getSurName();

    int getAge();

    String getLastSession() throws ParseException;
}
