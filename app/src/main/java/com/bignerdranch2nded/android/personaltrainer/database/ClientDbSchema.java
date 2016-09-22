package com.bignerdranch2nded.android.personaltrainer.database;

/**
 * Created by Jeffrow on 9/12/2016.
 */
public class ClientDbSchema {
    public static final class ClientListTable{
        public static final String NAME = "client";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String CLIENT_NAME = "name";
            public static final String CLIENT_IMAGE = "picture";
        }
    }

    public static final class SessionListTable {
        public static final String NAME = "date";

        public static final class Cols{
            public static final String SESSION_UUID = "session uuid";
            public static final String CLIENT_UUID = "client uuid";
            public static final String DATE = "session date";
            public static final String TITLE = "session title";
            public static final String DESCRIPTION = "session description";
            public static final String COMPLETED = "session completed";
        }
    }
}
