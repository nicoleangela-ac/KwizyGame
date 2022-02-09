package com.example.kwizy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.kwizy.QuizContract.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "Kwizy.db";
    private static final int DATABASE_VERSION= 1;

    private SQLiteDatabase db;

    final String SQL_CREATE_QUESTIONS_TABLE1 = "CREATE TABLE " +
            QTone.TABLE_NAME1+ " ( " +
            QTone.COLUMN_QUESTION + " TEXT, " +
            QTone.COLUMN_OPTION1 + " TEXT, " +
            QTone.COLUMN_OPTION2 + " TEXT, " +
            QTone.COLUMN_OPTION3 + " TEXT, " +
            QTone.COLUMN_OPTION4 + " TEXT " + " )";
    final String SQL_CREATE_QUESTIONS_TABLE2 = "CREATE TABLE " +
            QTtwo.TABLE_NAME2+ " ( " +
            QTtwo.COLUMN_QUESTION + " TEXT, " +
            QTtwo.COLUMN_OPTION1 + " TEXT, " +
            QTtwo.COLUMN_OPTION2 + " TEXT, " +
            QTtwo.COLUMN_OPTION3 + " TEXT, " +
            QTtwo.COLUMN_OPTION4 + " TEXT " + " )";
    final String SQL_CREATE_QUESTIONS_TABLE3 = "CREATE TABLE " +
            QTthree.TABLE_NAME3+ " ( " +
            QTthree.COLUMN_QUESTION + " TEXT, " +
            QTthree.COLUMN_OPTION1 + " TEXT, " +
            QTthree.COLUMN_OPTION2 + " TEXT, " +
            QTthree.COLUMN_OPTION3 + " TEXT, " +
            QTthree.COLUMN_OPTION4 + " TEXT " + " )";
    final String SQL_CREATE_QUESTIONS_TABLE4 = "CREATE TABLE " +
            QTfour.TABLE_NAME4+ " ( " +
            QTfour.COLUMN_QUESTION + " TEXT, " +
            QTfour.COLUMN_OPTION1 + " TEXT, " +
            QTfour.COLUMN_OPTION2 + " TEXT, " +
            QTfour.COLUMN_OPTION3 + " TEXT, " +
            QTfour.COLUMN_OPTION4 + " TEXT " + " )";
    final String SQL_CREATE_QUESTIONS_TABLE5 = "CREATE TABLE " +
            QTfive.TABLE_NAME5+ " ( " +
            QTfive.COLUMN_QUESTION + " TEXT, " +
            QTfive.COLUMN_OPTION1 + " TEXT, " +
            QTfive.COLUMN_OPTION2 + " TEXT, " +
            QTfive.COLUMN_OPTION3 + " TEXT, " +
            QTfive.COLUMN_OPTION4 + " TEXT " + " )";

    public QuizDbHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE1);
        fillQuestionsTable1();
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE2);
        fillQuestionsTable2();
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE3);
        fillQuestionsTable3();
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE4);
        fillQuestionsTable4();
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE5);
        fillQuestionsTable5();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+ QTone.TABLE_NAME1 );
        db.execSQL("DROP TABLE IF EXISTS "+ QTtwo.TABLE_NAME2 );
        db.execSQL("DROP TABLE IF EXISTS "+ QTthree.TABLE_NAME3 );
        db.execSQL("DROP TABLE IF EXISTS "+ QTfour.TABLE_NAME4 );
        db.execSQL("DROP TABLE IF EXISTS "+ QTfive.TABLE_NAME5 );
       onCreate(db);
    }

    private void fillQuestionsTable1 () {
        Question q1 = new Question( "Trabaho", "Work", "Task", "Part", "Office" );
        addQuestion(q1, QTone.TABLE_NAME1);
        Question q2 = new Question( "Kahel", "Orange", "Pink", "Blue", "Green" );
        addQuestion(q2, QTone.TABLE_NAME1);
        Question q3 = new Question( "Bansa", "Country", "City", "Avenue", "Boulevard" );
        addQuestion(q3, QTone.TABLE_NAME1);
        Question q4 = new Question( "Magulang", "Parent", "Sibling", "Aunt", "Grandmother");
        addQuestion(q4, QTone.TABLE_NAME1);
        Question q5 = new Question( "Salumpuwit", "Chair", "Spoon", "Cabinet", "Table" );
        addQuestion(q5, QTone.TABLE_NAME1);
        Question q6 = new Question( "Lila", "Violet", "Red", "Pink", "Black");
        addQuestion(q6, QTone.TABLE_NAME1);
        Question q7 = new Question( "Agham", "Science", "Math", "Filipino", "Technology" );
        addQuestion(q7, QTone.TABLE_NAME1);
        Question q8 = new Question( "Miyerkules", "Wednesday", "Tuesday", "Monday", "Saturday" );
        addQuestion(q8, QTone.TABLE_NAME1);
        Question q9 = new Question( "Huwebes", "Thursday", "Sunday", "Monday", "Wednesday" );
        addQuestion(q9, QTone.TABLE_NAME1);
        Question q10 = new Question( "Pamahalaan", "Government", "Govern", "Governor", "Governing" );
        addQuestion(q10, QTone.TABLE_NAME1);
        Question q11 = new Question( "Balarila", "Grammar", "Language", "Dialect", "Gun" );
        addQuestion(q11, QTone.TABLE_NAME1);
        Question q12 = new Question( "Makitid", "Narrow", "Wide", "Far", "Near" );
        addQuestion(q12, QTone.TABLE_NAME1);
        Question q13 = new Question( "Tuwid", "Straight", "Zigzag", "Curve", "Dotted" );
        addQuestion(q13, QTone.TABLE_NAME1);
        Question q14 = new Question( "Maginoo", "Gentleman", "Magic", "Forehead", "Smell" );
        addQuestion(q14, QTone.TABLE_NAME1);
        Question q15 = new Question( "Busilak", "Pure", "Flower", "Bloom", "White" );
        addQuestion(q15, QTone.TABLE_NAME1);
    }

    private void fillQuestionsTable2 () {
        Question q1 = new Question( "The Hero of Tirad Pass. He was the youngest Filipino general who had fought in the Filipino-Spanish Revolution", "General Gregorio del Pilar", "General Emilio Aguinaldo", "General Miguel Malvar", "General Antonio Luna" );
        addQuestion(q1, QTtwo.TABLE_NAME2);
        Question q2 = new Question("He painted the timeless masterpiece The Spolarium which shows the oppression of the Spaniards with the natives in the Philippines.", "Juan Luna", "Jose Rizal", "Apolinario Mabini", "Emilio Aguinaldo" );
        addQuestion(q2, QTtwo.TABLE_NAME2);
        Question q3 = new Question("He was the leader of the longest known Spanish revolt in Bohol.", "Francisco Dagohoy", "Laong Laan", "Sultan Kudarat", "Macario Sakay" );
        addQuestion(q3, QTtwo.TABLE_NAME2);
        Question q4 = new Question("She was known to be the Mother of Katipunan", "Melchora Aquino", "Josefa Llanes-Escoda", "Teodora Alonzo", "Gabriela Silang");
        addQuestion(q4, QTtwo.TABLE_NAME2);
        Question q5 = new Question("He assumed command of the  Philippine revolutionary forces during the latter conflict following the capture of Emilio Aguinaldo in 1901.", "General Miguel Malvar", "General Trias", "General Gregorio del Pilar", "General Ramos" );
        addQuestion(q5, QTtwo.TABLE_NAME2);
        Question q6 = new Question( "He was the composer of the Philippine National Anthem.", "Julian Felipe", "Andres Bonifacio", "Jose Rizal", "Ryan Cayabyab");
        addQuestion(q6, QTtwo.TABLE_NAME2);
        Question q7 = new Question( "Lakambini of the Katipunan and wife of Andres Bonifacio.", "Gregoria de Jesus", "Corazon Aquino", "Melchora Aquino", "Olive Lamason");
        addQuestion(q7, QTtwo.TABLE_NAME2);
        Question q8 = new Question( "First Filipino cannon-maker.", "Panday Pira", "Miguel Malvar", "Jose Protacio", "Jose Mercado");
        addQuestion(q8, QTtwo.TABLE_NAME2);
        Question q9 = new Question( "Prince of Tagalog Poets", "Francisco Baltazar", "Jomapa", "Laong Laan", "Dimasalang" );
        addQuestion(q9, QTtwo.TABLE_NAME2);
        Question q10 = new Question("He was considered The Brain of the Katipunandue to his big contribution in drafting the kartilya and the Malolos Constitution despite of his polio illness.", "Apolinario Mabini", "Jose Rizal", "Diego Silang", "Andres Bonifacio");
        addQuestion(q10, QTtwo.TABLE_NAME2);
        Question q11 = new Question("An Ilocana warrior who substituted the leadership  of the Ilocano wing of the Katipuneros after her husband died in battle.", "Gabriela Silang", "Melchora Aquino", "Corazon Aquino", "Teodora Alonzo");
        addQuestion(q11, QTtwo.TABLE_NAME2);
        Question q12 = new Question("The founder of the Philippine Socialism", "Isabelo de los Reyes", "Lapu-lapu", "Gabriela Silang", "Marcelo H. del Pilar");
        addQuestion(q12, QTtwo.TABLE_NAME2);
        Question q13 = new Question("The current conquerors when Andres Bonifacio died", "Spaniards", "Japanese", "Americans", "Germans");
        addQuestion(q13, QTtwo.TABLE_NAME2);
        Question q14 = new Question("He founded the secret society, Katipunan, on July 7, 1892, to fight Spain.", "Andres Bonifacio", "Jose Rizal", "Jose Palma", "Emilio Aguinaldo");
        addQuestion(q14, QTtwo.TABLE_NAME2);
        Question q15 = new Question( "Political analyst of the Filipino colony in Spain. He founded the nationalistic newspaper, Diariong Tagalog.", "Marcelo H. del Pilar", "Jose Rizal", "Teodora Agoncillo", "Graciano Lopez Jaena");
        addQuestion(q15, QTtwo.TABLE_NAME2);
    }

    private void fillQuestionsTable3 () {
        Question q1 = new Question( "Which of the following actors did not come from the inaugural batch of ABS-CBN’s Star Circle Quest finalist?", "Erich Gonzales", "Sandara Park", " Neri Naig", "Joross Gamboa"  );
        addQuestion(q1,  QTthree.TABLE_NAME3);
        Question q2 = new Question("Variety called this Filipino movie “A deliberately low-rent Filipino cousin to Spider-Man”", "Gagamboy", "Gagambino", "Alakdana", "Spiderboy" );
        addQuestion(q2,  QTthree.TABLE_NAME3);
        Question q3 = new Question( "These personalities both performed as voice actors in the animated movie “RPG Metanoia”", "Aga Muhlach and Eugene Domingo", "Ogie Alcasid and Michael V", "Makisig Morales and Sharlene San Pedro", "Vhong Navarro and Anne Curtis" );
        addQuestion(q3,  QTthree.TABLE_NAME3);
        Question q4 = new Question("“The Echo” starring Jesse Bradford, is the American adaptation of which Filipino horror film?", "Sigaw", "Alingawngaw", "Bulong", "Sumigaw Ka Hanggang Gusto Mo" );
        addQuestion(q4,  QTthree.TABLE_NAME3);
        Question q5 = new Question( "Which cast member of the 2015 “Pangako Sa’yo” TV Series remake are also in the original version aired in early 2000s?", "Jodi Sta. Maria and Amy Austria", "Angelica Panganiban and Bernard Palanca", "Eula Valdez and Gene Garcia", "Jestoni Alarcon and Tonton Guttierrez" );
        addQuestion(q5,  QTthree.TABLE_NAME3);
        Question q6 = new Question("Which title of a “Shake, Rattle and Roll” episode has been used twice?", "Yaya", "Aswang", "Impakto", "Madre" );
        addQuestion(q6,  QTthree.TABLE_NAME3);
        Question q7 = new Question( "She is also known as Asias Songbird.", "Regine Velasquez", "Angeline Quinto", "Lea Salonga", "Sarah Geronimo" );
        addQuestion(q7,  QTthree.TABLE_NAME3);
        Question q8 = new Question("It is the longest-running noontime variety show in the Philippines.", "Eat Bulaga!", " Wowowin", " It’s Showtime!", " Starstruck"  );
        addQuestion(q8,  QTthree.TABLE_NAME3);
        Question q9 = new Question("Prince of Tagalog Poets", "Francisco Baltazar", "Jomapa", "Laong Laan", "Dimasalang"  );
        addQuestion(q9,  QTthree.TABLE_NAME3);
        Question q10 = new Question( "He is the feisty boxer from General Santos City who is now a congressman.", "Manny Pacquiao", "Jinky Pacquiao", "Dionisia Pacquiao", "Jimuel Pacquiao" );
        addQuestion(q10,  QTthree.TABLE_NAME3);
        Question q11 = new Question( "He won the best actor award during the 42nd Metro Manila Film Festival with his movie, Die Beautiful.", "Paolo Ballesteros", " Vice Ganda", " Pooh", " Coco Martin" );
        addQuestion(q11,  QTthree.TABLE_NAME3);
        Question q12 = new Question("Which is the current highest-grossing film in the Philippines?", " Can’t Help Falling in Love", " One More Chance", " My Ex and Whys", " Hello, Love, Goodbye" );
        addQuestion(q12,  QTthree.TABLE_NAME3);
        Question q13 = new Question("Which American Idol alum is the lead actor in the TV5 series “Nandito Ako” which starred Jasmin Curtis-Smith?", "David Archuleta", "David Cook", "Colton Dixo", "Philip Philips"  );
        addQuestion(q13,  QTthree.TABLE_NAME3);
        Question q14 = new Question("Who is the first big winner in the first season of Pinoy Big Brother?", "Nene Tamayo", "Bea Saw", "Melai Cantiveros", "Kim Chiu" );
        addQuestion(q14,  QTthree.TABLE_NAME3);
        Question q15 = new Question( "These two are the couple in the famous soap opera, Sana Maulit Muli.", "Kim Chiu and Gerald Anderson", "Erich Gonzales and Jake Cuenca", " Angelica Panginaban and Derek Ramsey", "Maja Salvador and John Lloyd Cruz" );
        addQuestion(q15, QTthree.TABLE_NAME3);
    }
    private void fillQuestionsTable4 () {
        Question q1 = new Question( "Which of the following actors did not come from the inaugural batch of ABS-CBN’s Star Circle Quest finalist?", "Bicol Region", " Ilocos Region", " Visayas Region", "National Capital Region" );
        addQuestion(q1,  QTfour.TABLE_NAME4);
        Question q2 = new Question("What city in the Philippines is known for durian, Mount. Apo, and Philippine Eagle.", "Davao", "Quezon", "Cagayan De Oro", "Cebu" );
        addQuestion(q2,  QTfour.TABLE_NAME4);
        Question q3 = new Question("If you want to see the Pahiyas Festival, which city in Quezon do you need to visit?", "Lucban", "Lucena", "Candelaria", "Tayabas" );
        addQuestion(q3,  QTfour.TABLE_NAME4);
        Question q4 = new Question("Isabela is included in what region?", "Cagayan Valley", "Ilocos Region", "CALABARZON", "Central Luzon" );
        addQuestion(q4,  QTfour.TABLE_NAME4);
        Question q5 = new Question("What is the longest mountain range in the Philippines?", "Sierra Madre", "Cordillera Central", "Caraballo Mountains", "Mt. Pico de Loro" );
        addQuestion(q5,  QTfour.TABLE_NAME4);
        Question q6 = new Question("Which title of a “Shake, Rattle and Roll” episode has been used twice?", "Yaya", "Aswang", "Impakto", "Madre");
        addQuestion(q6,  QTfour.TABLE_NAME4);
        Question q7 = new Question("What city in the Philippines placed second on the cleanest drinking water in the world?", "Davao", "Makati", "Cebu", "General Santos");
        addQuestion(q7,  QTfour.TABLE_NAME4);
        Question q8 = new Question("What province is the bailiwick of Congressman Manny Pacquiao?", "Saranggani Province",  "Davao Del Sur", "Cebu Province", "General Santos Province");
        addQuestion(q8,  QTfour.TABLE_NAME4);
        Question q9 = new Question( "What is the coldest city in the Philippines?", "Baguio", "Cebu", "Tagaytay", "Davao" );
        addQuestion(q9,  QTfour.TABLE_NAME4);
        Question q10 = new Question("It is where the beautiful white sand of Saud Beach, Pagudpud can be found.", "Ilocos Norte", "Palawan", "Cebu", "Ilocos Sur"  );
        addQuestion(q10,  QTfour.TABLE_NAME4);
        Question q11 = new Question("What is the city of friendship?", "Cagayan De Oro City", "Bacolod City", "Marikina City", "Davao City" );
        addQuestion(q11,  QTfour.TABLE_NAME4);
        Question q12 = new Question("Where can you find Mt. Taal?", "Batangas City", "Legazpi City", "Cebu City", "Zamboanga City");
        addQuestion(q12,  QTfour.TABLE_NAME4);
        Question q13 = new Question("Where can you find the Maria Cristina Falls?", "Iligan City", "Davao Oriental", "Moalboal", "Bukidnon" );
        addQuestion(q13,  QTfour.TABLE_NAME4);
        Question q14 = new Question("What is the number one tourist destination in the Philippines?", "Boracay Island ", "Cebu City", "Bohol", "Davao City" );
        addQuestion(q14,  QTfour.TABLE_NAME4);
        Question q15 = new Question("Where is the Chocolate Hills located?", "Bohol", "Batangas", "Aklan", "Iloilo" );
        addQuestion(q15,  QTfour.TABLE_NAME4);
    }
    private void fillQuestionsTable5 () {
        Question q1 = new Question("The father of the Filipino language", "Manuel L. Quezon", "Jose P. Laurel", "Elpidio Quirino", "Manuel Roxas"  );
        addQuestion(q1, QTfive.TABLE_NAME5);
        Question q2 = new Question( "The 10th President of the Republic of the Philippines?", "Ferdinand Marcos", "Joseph Estrada", "Rodrigo Duterte", "Corazon Aquino" );
        addQuestion(q2, QTfive.TABLE_NAME5);
        Question q3 = new Question( "Which president of the Philippines had a father who was also a president?", "Gloria Macapagal Arroyo", "Ferdinand Marcos", "Ninoy Aquino", "Manuel Roxas" );
        addQuestion(q3, QTfive.TABLE_NAME5);
        Question q4 = new Question("It is the official residence of the presidents of the Philippines.", " Malacañang Palace", " White House", " Perlas ng Silangan", "Bahay na Bato" );
        addQuestion(q4, QTfive.TABLE_NAME5);
        Question q5 = new Question( "How long did Ferdinand Marcos rule the country?", "21 years", "25 years", "20 years", "24 years" );
        addQuestion(q5, QTfive.TABLE_NAME5);
        Question q6 = new Question( "Among the presidents, who was known as the “Ama ng Wikang Pambansa”?", "Manuel L. Quezon", "Carlos P. Garcia", "Sergio Osmeña", "Manuel Roxas");
        addQuestion(q6, QTfive.TABLE_NAME5);
        Question q7 = new Question( "Who was the president of the Philippines when the puppet government was established?", "Jose P. Laurel", "Emilio Aguinaldo", "Diosdado Macapagal", "Ramon Magsaysay" );
        addQuestion(q7, QTfive.TABLE_NAME5);
        Question q8 = new Question( "The first woman to be President of the Philippines or any Asian country", "Corazon Aquino", "Miriam Defensor-Santiago", "Gloria Macapagal-Arroyo", "Josefa Llanes-Escoda" );
        addQuestion(q8, QTfive.TABLE_NAME5);
        Question q9 = new Question("The Philippines was ranked second in Asia’s clean and well-governed countries during his presidency.", "Ramon Magsaysay", "Ferdinand Marcos", "Corazon Aquino", "Jose P. Laurel");
        addQuestion(q9, QTfive.TABLE_NAME5);
        Question q10 = new Question("He Created the Social Security Commission. During his Presidency, Quezon City became capital of the Philippines in 1948.", "Elpidio Quirino", " Andres Bonifacio", "Manuel Roxas", "Carlos P. Garcia"  );
        addQuestion(q10, QTfive.TABLE_NAME5);
        Question q11 = new Question( "The youngest President, taking office at age 28. Also the longest-lived president, passing away at 94.", "Emilio Aguinaldo", " Ferdinand Marcos", "Elpidio Quirino", "Jose Rizal" );
        addQuestion(q11, QTfive.TABLE_NAME5);
        Question q12 = new Question( "President of the Philippines from 1957 - 1961. Remembered for his Filipino First Policy.", "Carlos P. Garcia", " Elpidio Quirino", " Manuel Roxas", "Ramon Magsaysay" );
        addQuestion(q12, QTfive.TABLE_NAME5);
        Question q13 = new Question("Who was the President of the Philippines when it was first occupied by the Japanese?", "Manuel L. Quezon", " Manuel Pacquiao", "Manuel Roxas", "Manuel L. Santos"  );
        addQuestion(q13, QTfive.TABLE_NAME5);
        Question q14 = new Question("During this President’s term, the Agricultural Land Reform Code was passed. He also moved the Independence Day of the Philippines from July 4 to June 12", "Diosdado Macapagal", "Sergio Osmena", "Carlos P. Garcia", "Ferdinand Marcos"  );
        addQuestion(q14, QTfive.TABLE_NAME5);
        Question q15 = new Question( "The first Visayan to become President. The Bell Trade Act was Approved by the US Congress during his presidency. Currently appearing in the 50-peso bill.", "Sergio Osmena", "Diosdado Macapagal", "Emilio Aguinaldo", "Manuel Roxas" );
        addQuestion(q15, QTfive.TABLE_NAME5);
    }
    private void addQuestion (Question question, String tableName) {
        ContentValues cv = new ContentValues();
        cv.put(QTone.COLUMN_QUESTION, question.getQuestion());
        cv.put(QTone.COLUMN_OPTION1, question.getOption1());
        cv.put(QTone.COLUMN_OPTION2, question.getOption2());
        cv.put(QTone.COLUMN_OPTION3, question.getOption3());
        cv.put(QTone.COLUMN_OPTION4, question.getOption4());

        db.insert(tableName, null, cv);
    }

    public List<Question> getAllQuestions(String tableName, String questionStr, String option1, String option2, String option3, String option4) {
         List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + tableName, null);

        if (c.moveToFirst()) {
            do {
               Question question = new Question();
               question.setQuestion(c.getString(c.getColumnIndex(questionStr)));
               question.setOption1(c.getString(c.getColumnIndex(option1)));
               question.setOption2(c.getString(c.getColumnIndex(option2)));
               question.setOption3(c.getString(c.getColumnIndex(option3)));
               question.setOption4(c.getString(c.getColumnIndex(option4)));
               questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

}
