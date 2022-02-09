package com.example.kwizy;

import android.provider.BaseColumns;

public class QuizContract {
    private QuizContract () {}

    public static class  QTone implements BaseColumns {
        public static final String TABLE_NAME1 = "quiz_questions_TB1";
        public static  final String COLUMN_QUESTION = "question";
        public static  final String COLUMN_OPTION1 = "option1";
        public static  final String COLUMN_OPTION2 = "option2";
        public static  final String COLUMN_OPTION3 = "option3";
        public static  final String COLUMN_OPTION4 = "option4";

    }

    public static class  QTtwo implements BaseColumns {
        public static final String TABLE_NAME2 = "quiz_questions_TB2";
        public static  final String COLUMN_QUESTION = "question";
        public static  final String COLUMN_OPTION1 = "option1";
        public static  final String COLUMN_OPTION2 = "option2";
        public static  final String COLUMN_OPTION3 = "option3";
        public static  final String COLUMN_OPTION4 = "option4";
    }

    public static class  QTthree implements BaseColumns {
        public static final String TABLE_NAME3 = "quiz_questions_TB3";
        public static  final String COLUMN_QUESTION = "question";
        public static  final String COLUMN_OPTION1 = "option1";
        public static  final String COLUMN_OPTION2 = "option2";
        public static  final String COLUMN_OPTION3 = "option3";
        public static  final String COLUMN_OPTION4 = "option4";

    }
    public static class  QTfour implements BaseColumns {
        public static final String TABLE_NAME4 = "quiz_questions_TB4";
        public static  final String COLUMN_QUESTION = "question";
        public static  final String COLUMN_OPTION1 = "option1";
        public static  final String COLUMN_OPTION2 = "option2";
        public static  final String COLUMN_OPTION3 = "option3";
        public static  final String COLUMN_OPTION4 = "option4";

    }
    public static class  QTfive implements BaseColumns {
        public static final String TABLE_NAME5 = "quiz_questions_TB5";
        public static  final String COLUMN_QUESTION = "question";
        public static  final String COLUMN_OPTION1 = "option1";
        public static  final String COLUMN_OPTION2 = "option2";
        public static  final String COLUMN_OPTION3 = "option3";
        public static  final String COLUMN_OPTION4 = "option4";

    }
}
