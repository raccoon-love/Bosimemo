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

public class Yobou2 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_2_1;
    private int month2_yobou_2_1;
    private int day_yobou_2_1;


    private int year_yobou_2_2;
    private int month2_yobou_2_2;
    private int day_yobou_2_2;

    private int year_yobou_2_3;
    private int month2_yobou_2_3;
    private int day_yobou_2_3;

    private int year_yobou_2_4;
    private int month2_yobou_2_4;
    private int day_yobou_2_4;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR2_1 = "YEAR2_1";
    private static final String MONTH2_1 = "MONTH2_1";
    private static final String DAY2_1 = "DAY2_1";


    private static final String YEAR2_2 = "YEAR2_2";
    private static final String MONTH2_2 = "MONTH2_2";
    private static final String DAY2_2 = "DAY2_2";

    private static final String YEAR2_3 = "YEAR2_3";
    private static final String MONTH2_3 = "MONTH2_3";
    private static final String DAY2_3 = "DAY2_3";

    private static final String YEAR2_4 = "YEAR2_4";
    private static final String MONTH2_4 = "MONTH2_4";
    private static final String DAY2_4 = "DAY2_4";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou2);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_2_1 = prefs.getInt(YEAR2_1, 0);
        month2_yobou_2_1 = prefs.getInt(MONTH2_1, 0);
        day_yobou_2_1 = prefs.getInt(DAY2_1, 0);
        //2回目の受診日を読み込み
        year_yobou_2_2 = prefs.getInt(YEAR2_2, 0);
        month2_yobou_2_2 = prefs.getInt(MONTH2_2, 0);
        day_yobou_2_2 = prefs.getInt(DAY2_2, 0);
        //3回目の受診日を読み込み
        year_yobou_2_3 = prefs.getInt(YEAR2_3, 0);
        month2_yobou_2_3 = prefs.getInt(MONTH2_3, 0);
        day_yobou_2_3 = prefs.getInt(DAY2_3, 0);
        //4回目の受診日を読み込み
        year_yobou_2_4 = prefs.getInt(YEAR2_4, 0);
        month2_yobou_2_4 = prefs.getInt(MONTH2_4, 0);
        day_yobou_2_4 = prefs.getInt(DAY2_4, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou2_1 = (TextView)findViewById(R.id.txtyobou2_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 60);
        //表示(MONTHに+1を追記)
        String result2_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou2_1.setText(result2_1);


        //2回予防接種の目安(textview)
        TextView txtyobou2_2 = (TextView)findViewById(R.id.txtyobou2_2);
        cal.set(year_yobou_2_1,month2_yobou_2_1,day_yobou_2_1);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result2_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou2_2.setText(result2_2);


        //3回予防接種の目安(textview)
        TextView txtyobou2_3 = (TextView)findViewById(R.id.txtyobou2_3);
        cal.set(year_yobou_2_2,month2_yobou_2_2,day_yobou_2_2);
        cal.add(Calendar.DAY_OF_MONTH, 28);
        //表示(MONTHに+1を追記)
        String result2_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou2_3.setText(result2_3);

       //4回予防接種の目安(textview)
        TextView txtyobou2_4 = (TextView)findViewById(R.id.txtyobou2_4);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 366);
        //表示(MONTHに+1を追記)
        String result2_4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou2_4.setText(result2_4);








        //１回目の入力のEdittextに反映
        EditText ed_2_1 = (EditText)findViewById(R.id.yoboued2_1);
        ed_2_1.setText("①"+year_yobou_2_1 + "/" + (month2_yobou_2_1+1)+ "/" +  day_yobou_2_1);


        //2回目の入力のEdittextに反映
        EditText ed_2_2 = (EditText)findViewById(R.id.yoboued2_2);
        ed_2_2.setText("②"+year_yobou_2_2 + "/" + (month2_yobou_2_2+1)+ "/" +  day_yobou_2_2);

        //3回目の入力のEdittextに反映
        EditText ed_2_3 = (EditText)findViewById(R.id.yoboued2_3);
        ed_2_3.setText("③"+year_yobou_2_3 + "/" + (month2_yobou_2_3+1)+ "/" +  day_yobou_2_3);

        //4回目の入力のEdittextに反映
        EditText ed_2_4 = (EditText)findViewById(R.id.yoboued2_4);
        ed_2_4.setText("④"+year_yobou_2_4 + "/" + (month2_yobou_2_4+1)+ "/" +  day_yobou_2_4);




    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked2_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_2_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked2_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_2_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked2_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_2_1_3.class);
        //SubActivityの起動
        startActivity(i);
    }

    public void onclicked2_4(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_2_1_4.class);
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
