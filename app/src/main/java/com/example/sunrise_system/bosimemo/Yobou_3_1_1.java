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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by sunrise-system on 2016/10/19.
 */

public class Yobou_3_1_1 extends Activity {




    //年、月、日
    private int year;
    private int month;
    private int day;

    private int year_yobou_3_1;
    private int month2_yobou_3_1;
    private int day_yobou_3_1;


    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";

    private static final String YEAR3_1 = "YEAR3_1";
    private static final String MONTH3_1 = "MONTH3_1";
    private static final String DAY3_1 = "DAY3_1";




    public void onCreate(Bundle savedInstanceState) {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou_3_1_1);


        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);


        //初回予防接種の目安
        TextView meyasu3_1 = (TextView)findViewById(R.id.meyasu3_1);
        cal.set(year,month,day);
        cal.add(Calendar.DAY_OF_MONTH, 60);
        //表示(MONTHに+1を追記)
        String result3_1 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        meyasu3_1.setText(result3_1);








        //EditText未記入がないかチェック＆ボタンを押すと保存＆ページ遷移
        View saveButton3_1 = (Button) findViewById(R.id.save3_1);
        saveButton3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameText3_1 = (EditText)findViewById(R.id.edityobou3_1);


                //未記入があるかチェック
                if(nameText3_1.getText().toString().equals("") == false)
                {


                    //1回目接種日を本体に記憶する
                    savePrefs3_1();

                    Intent i = new Intent(getApplicationContext(), Yobou3.class);

                    //SubActivityの起動
                    startActivity(i);
                }else {   //未記入があるとページ遷移できずトースト表示
                    Toast.makeText(Yobou_3_1_1.this, "日付を入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();



    //1回目のedittextを押すと日付を出す
    public void onclick_ed_3_1(View view) {
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Yobou_3_1_1.this.year_yobou_3_1 = year;
                month2_yobou_3_1 = monthOfYear;
                day_yobou_3_1 = dayOfMonth;


                EditText txtDate = (EditText) Yobou_3_1_1.this.findViewById(R.id.edityobou3_1);
                // Setした日付を取得する
                txtDate.setText(String.format("%02d/%02d/%02d", year, monthOfYear + 1, dayOfMonth));
            }
        },
                cal.get(java.util.Calendar.YEAR),
                cal.get(java.util.Calendar.MONTH),
                cal.get(java.util.Calendar.DAY_OF_MONTH)
        );
        // ダイアログを表示する
        d_date.show();


    }




    //プレファレンスに保存
    private void savePrefs3_1() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("YEAR3_1", year_yobou_3_1);
        editor.putInt("MONTH3_1", month2_yobou_3_1);
        editor.putInt("DAY3_1", day_yobou_3_1);
        editor.commit();

    }


    //戻るボタンで前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou3.class);
        //SubActivityの起動
        startActivity(i);
    }
}
