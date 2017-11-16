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

public class Yobou10 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_10_1;
    private int month2_yobou_10_1;
    private int day_yobou_10_1;


    private int year_yobou_10_2;
    private int month2_yobou_10_2;
    private int day_yobou_10_2;

    private int year_yobou_10_3;
    private int month2_yobou_10_3;
    private int day_yobou_10_3;

    private int year_yobou_10_4;
    private int month2_yobou_10_4;
    private int day_yobou_10_4;





    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR10_1 = "YEAR10_1";
    private static final String MONTH10_1 = "MONTH10_1";
    private static final String DAY10_1 = "DAY10_1";


    private static final String YEAR10_2 = "YEAR10_2";
    private static final String MONTH10_2 = "MONTH10_2";
    private static final String DAY10_2 = "DAY10_2";

    private static final String YEAR10_3 = "YEAR10_3";
    private static final String MONTH10_3 = "MONTH10_3";
    private static final String DAY10_3 = "DAY10_3";

    private static final String YEAR10_4 = "YEAR10_4";
    private static final String MONTH10_4 = "MONTH10_4";
    private static final String DAY10_4 = "DAY10_4";




    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou10);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_10_1 = prefs.getInt(YEAR10_1, 0);
        month2_yobou_10_1 = prefs.getInt(MONTH10_1, 0);
        day_yobou_10_1 = prefs.getInt(DAY10_1, 0);
        //2回目の受診日を読み込み
        year_yobou_10_2 = prefs.getInt(YEAR10_2, 0);
        month2_yobou_10_2 = prefs.getInt(MONTH10_2, 0);
        day_yobou_10_2 = prefs.getInt(DAY10_2, 0);
        //3回目の受診日を読み込み
        year_yobou_10_3 = prefs.getInt(YEAR10_3, 0);
        month2_yobou_10_3 = prefs.getInt(MONTH10_3, 0);
        day_yobou_10_3 = prefs.getInt(DAY10_3, 0);
        //4回目の受診日を読み込み
        year_yobou_10_4 = prefs.getInt(YEAR10_4, 0);
        month2_yobou_10_4 = prefs.getInt(MONTH10_4, 0);
        day_yobou_10_4 = prefs.getInt(DAY10_4, 0);






        //初回予防接種の目安(textview)
        TextView txtyobou10_1 = (TextView)findViewById(R.id.txtyobou10_1);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 3);
        //表示(MONTHに+1を追記)
        String result10_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou10_1.setText(result10_1);


        //2回予防接種の目安(textview)
        TextView txtyobou10_2 = (TextView)findViewById(R.id.txtyobou10_2);
        cal.set(year_yobou_10_1,month2_yobou_10_1,day_yobou_10_1);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        //表示(MONTHに+1を追記)
        String result10_2 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou10_2.setText(result10_2);


        //3回予防接種の目安(textview)
        TextView txtyobou10_3 = (TextView)findViewById(R.id.txtyobou10_3);
        cal.set(year_yobou_10_2,month2_yobou_10_2,day_yobou_10_2);
        cal.add(Calendar.YEAR, 1);
        //表示(MONTHに+1を追記)
        String result10_3 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou10_3.setText(result10_3);

        //4回予防接種の目安(textview)
        TextView txtyobou10_4 = (TextView)findViewById(R.id.txtyobou10_4);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 9);
        //表示(MONTHに+1を追記)
        String result10_4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou10_4.setText(result10_4);








        //１回目の入力のEdittextに反映
        EditText ed_10_1 = (EditText)findViewById(R.id.yoboued10_1);
        ed_10_1.setText("①"+year_yobou_10_1 + "/" + (month2_yobou_10_1+1)+ "/" +  day_yobou_10_1);


        //2回目の入力のEdittextに反映
        EditText ed_10_2 = (EditText)findViewById(R.id.yoboued10_2);
        ed_10_2.setText("②"+year_yobou_10_2 + "/" + (month2_yobou_10_2+1)+ "/" +  day_yobou_10_2);

       //3回目の入力のEdittextに反映
        EditText ed_10_3 = (EditText)findViewById(R.id.yoboued10_3);
        ed_10_3.setText("③"+year_yobou_10_3 + "/" + (month2_yobou_10_3+1)+ "/" +  day_yobou_10_3);

        //4回目の入力のEdittextに反映
        EditText ed_10_4 = (EditText)findViewById(R.id.yoboued10_4);
        ed_10_4.setText("④"+year_yobou_10_4 + "/" + (month2_yobou_10_4+1)+ "/" +  day_yobou_10_4);




    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked10_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_10_1_1.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked10_2(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_10_1_2.class);
        //SubActivityの起動
        startActivity(i);
    }


    public void onclicked10_3(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_10_1_3.class);
        //SubActivityの起動
        startActivity(i);
    }

    public void onclicked10_4(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_10_1_4.class);
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
