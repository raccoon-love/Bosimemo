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

public class Yobou13 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_13_1;
    private int month2_yobou_13_1;
    private int day_yobou_13_1;


    private int year_yobou_13_2;
    private int month2_yobou_13_2;
    private int day_yobou_13_2;






    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR13_1 = "YEAR13_1";
    private static final String MONTH13_1 = "MONTH13_1";
    private static final String DAY13_1 = "DAY13_1";


    private static final String YEAR13_2 = "YEAR13_2";
    private static final String MONTH13_2 = "MONTH13_2";
    private static final String DAY13_2 = "DAY13_2";





    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou13);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_13_1 = prefs.getInt(YEAR13_1, 0);
        month2_yobou_13_1 = prefs.getInt(MONTH13_1, 0);
        day_yobou_13_1 = prefs.getInt(DAY13_1, 0);
       //2回目の受診日を読み込み
        year_yobou_13_2 = prefs.getInt(YEAR13_2, 0);
        month2_yobou_13_2 = prefs.getInt(MONTH13_2, 0);
        day_yobou_13_2 = prefs.getInt(DAY13_2, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou13_1 = (TextView)findViewById(R.id.txtyobou13_1);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 1);
        //表示(MONTHに+1を追記)
        String result13_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou13_1.setText(result13_1);


        //2回予防接種の目安(textview)
        TextView txtyobou13_2 = (TextView)findViewById(R.id.txtyobou13_2);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 5);
        //表示(MONTHに+1を追記)
        String result13_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou13_2.setText(result13_2);







        //１回目の入力のEdittextに反映
        EditText ed_13_1 = (EditText)findViewById(R.id.yoboued13_1);
        ed_13_1.setText("①"+year_yobou_13_1 + "/" + (month2_yobou_13_1+1)+ "/" +  day_yobou_13_1);


        //2回目の入力のEdittextに反映
        EditText ed_13_2 = (EditText)findViewById(R.id.yoboued13_2);
        ed_13_2.setText("②"+year_yobou_13_2 + "/" + (month2_yobou_13_2+1)+ "/" +  day_yobou_13_2);






    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked13_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_13_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked13_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_13_1_2.class);
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
