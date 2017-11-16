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

public class Yobou11 extends Activity {



    //年、月、日
    private int year;
    private int month;
    private int day;


    private int year_yobou_11_1;
    private int month2_yobou_11_1;
    private int day_yobou_11_1;






    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";

    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR11_1 = "YEAR11_1";
    private static final String MONTH11_1 = "MONTH11_1";
    private static final String DAY11_1 = "DAY11_1";


    public void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou11);







        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //1回目の受診日を読み込み
        year_yobou_11_1 = prefs.getInt(YEAR11_1, 0);
        month2_yobou_11_1 = prefs.getInt(MONTH11_1, 0);
        day_yobou_11_1 = prefs.getInt(DAY11_1, 0);




        //初回予防接種の目安(textview)
        TextView txtyobou11_1 = (TextView)findViewById(R.id.txtyobou11_1);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 11);
        //表示(MONTHに+1を追記)
        String result11_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        txtyobou11_1.setText(result11_1);






        //１回目の入力のEdittextに反映
        EditText ed_11_1 = (EditText)findViewById(R.id.yoboued11_1);
        ed_11_1.setText("①"+year_yobou_11_1 + "/" + (month2_yobou_11_1+1)+ "/" +  day_yobou_11_1);





    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();





    public void onclicked11_1(View view) {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou_11_1_1.class);
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
