package com.bignerdranch2nded.android.personaltrainer.database;

/**
 * Created by Jeffrow on 9/12/2016.
 */
public class ClientDbSchema {
    public static final class ClientListTable{
        public static final String NAME = "client";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String CLIENTNAME = "name";
        }
    }

    public static final class SessionDateTable
    public static final class Cols{
        public static final String UUID = "uuid";
        public static final String SESSIONSDATE = "session date";
        public static final String SESSIONTITLE = "session title";
    }
}
