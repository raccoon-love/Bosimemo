package com.example.sunrise_system.bosimemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by sunrise-system on 2016/10/14.
 */

public class Yobou5 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_5_1;
    private int month2_yobou_5_1;
    private int day_yobou_5_1;


    private int year_yobou_5_2;
    private int month2_yobou_5_2;
    private int day_yobou_5_2;

    private int year_yobou_5_3;
    private int month2_yobou_5_3;
    private int day_yobou_5_3;

    private int year_yobou_5_4;
    private int month2_yobou_5_4;
    private int day_yobou_5_4;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR5_1 = "YEAR5_1";
    private static final String MONTH5_1 = "MONTH5_1";
    private static final String DAY5_1 = "DAY5_1";


    private static final String YEAR5_2 = "YEAR5_2";
    private static final String MONTH5_2 = "MONTH5_2";
    private static final String DAY5_2 = "DAY5_2";

    private static final String YEAR5_3 = "YEAR5_3";
    private static final String MONTH5_3 = "MONTH5_3";
    private static final String DAY5_3 = "DAY5_3";

    private static final String YEAR5_4 = "YEAR5_4";
    private static final String MONTH5_4 = "MONTH5_4";
    private static final String DAY5_4 = "DAY5_4";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou5);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_5_1 = prefs.getInt(YEAR5_1, 0);
        month2_yobou_5_1 = prefs.getInt(MONTH5_1, 0);
        day_yobou_5_1 = prefs.getInt(DAY5_1, 0);
        //2回目の受診日を読み込み
        year_yobou_5_2 = prefs.getInt(YEAR5_2, 0);
        month2_yobou_5_2 = prefs.getInt(MONTH5_2, 0);
        day_yobou_5_2 = prefs.getInt(DAY5_2, 0);
       //3回目の受診日を読み込み
        year_yobou_5_3 = prefs.getInt(YEAR5_3, 0);
        month2_yobou_5_3 = prefs.getInt(MONTH5_3, 0);
        day_yobou_5_3 = prefs.getInt(DAY5_3, 0);
        //4回目の受診日を読み込み
        year_yobou_5_4 = prefs.getInt(YEAR5_4, 0);
        month2_yobou_5_4 = prefs.getInt(MONTH5_4, 0);
        day_yobou_5_4 = prefs.getInt(DAY5_4, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou5_1 = (TextView)findViewById(R.id.txtyobou5_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 90);
        //表示(MONTHに+1を追記)
        String result5_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou5_1.setText(result5_1);


        //2回予防接種の目安(textview)
        TextView txtyobou5_2 = (TextView)findViewById(R.id.txtyobou5_2);
        cal.set(year_yobou_5_1,month2_yobou_5_1,day_yobou_5_1);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        //表示(MONTHに+1を追記)
        String result5_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou5_2.setText(result5_2);


        //3回予防接種の目安(textview)
        TextView txtyobou5_3 = (TextView)findViewById(R.id.txtyobou5_3);
        cal.set(year_yobou_5_2,month2_yobou_5_2,day_yobou_5_2);
        cal.add(Calendar.DAY_OF_MONTH, 20);
        //表示(MONTHに+1を追記)
        String result5_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou5_3.setText(result5_3);

        //4回予防接種の目安(textview)
        TextView txtyobou5_4 = (TextView)findViewById(R.id.txtyobou5_4);
        cal.set(year_yobou_5_3,month2_yobou_5_3,day_yobou_5_3);
        cal.add(Calendar.DAY_OF_MONTH, 366);
        //表示(MONTHに+1を追記)
        String result5_4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou5_4.setText(result5_4);







        //１回目の入力のEdittextに反映
        EditText ed_5_1 = (EditText)findViewById(R.id.yoboued5_1);
        ed_5_1.setText("①"+year_yobou_5_1 + "/" + (month2_yobou_5_1+1)+ "/" +  day_yobou_5_1);


        //2回目の入力のEdittextに反映
        EditText ed_5_2 = (EditText)findViewById(R.id.yoboued5_2);
        ed_5_2.setText("②"+year_yobou_5_2 + "/" + (month2_yobou_5_2+1)+ "/" +  day_yobou_5_2);

        //3回目の入力のEdittextに反映
        EditText ed_5_3 = (EditText)findViewById(R.id.yoboued5_3);
        ed_5_3.setText("③"+year_yobou_5_3 + "/" + (month2_yobou_5_3+1)+ "/" +  day_yobou_5_3);

        //4回目の入力のEdittextに反映
        EditText ed_5_4 = (EditText)findViewById(R.id.yoboued5_4);
        ed_5_4.setText("④"+year_yobou_5_4 + "/" + (month2_yobou_5_4+1)+ "/" +  day_yobou_5_4);




    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked5_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_5_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked5_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_5_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked5_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_5_1_3.class);
        //SubActivityの起動
        startActivity(i);
    }

    public void onclicked5_4(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_5_1_4.class);
        //SubActivityの起動
        startActivity(i);
    }




    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), YobouGamen.class);
        //SubActivityの起動
        startActivity(i);
    }


}
