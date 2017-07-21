package com.tutorial.android_tutorial_6.data;

import android.provider.BaseColumns;

/**
 * Created by SEYMA1 on 21.7.2017.
 */
public class HastaKayitContract {

    public static final class HastaEntry implements BaseColumns {

        public static final String TABLE_NAME = "hasta_tablosu";

        public static final String COLUMN_HASTA_ISMI = "hasta_ismi";

        public static final String COLUMN_HASTA_YAS = "yas";

        public static final String COLUMN_HASTA_ADRES = "adres";

    }

    public static final class DoktorEntry implements BaseColumns{

        public static final String TABLE_NAME = "doktor_tablosu";

        public static final String COLUMN_DOKTOR_ISMI = "doktor_ismi";

        public static final String COLUMN_DOKTOR_BRANS = "brans";

    }

}
