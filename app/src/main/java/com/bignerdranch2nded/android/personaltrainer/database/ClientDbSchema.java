package com.bignerdranch2nded.android.personaltrainer.database;

/**
 * Created by Jeffrow on 9/12/2016.
 */
public class ClientDbSchema {
    public static final class ClientListTable{
        public static final String CLIENT_NAME = "client";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String CLIENT_IMAGE = "picture";
        }
    }

    public static final class SessionListTable {
        public static final String SESSION_NAME = "session";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String DATE = "date";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String COMPLETED = "completed";
        }
    }
}
