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

public class Yobou_10_1_4 extends Activity {




    //年、月、日
    //年、月、日
    private int year;
    private int month;
    private int day;

    private int year_yobou_10_4;
    private int month2_yobou_10_4;
    private int day_yobou_10_4;


    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";


    public void onCreate(Bundle savedInstanceState) {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.yobou_10_1_4);


        //生年月日のデータの読み込み
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        year = prefs.getInt(YEAR, 0);
        month = prefs.getInt(MONTH, 0);
        day = prefs.getInt(DAY, 0);

        //初回予防接種の目安
        TextView meyasu10_4 = (TextView)findViewById(R.id.meyasu10_4);
        cal.set(year,month,day);
        cal.add(Calendar.YEAR, 9);
        //表示(MONTHに+1を追記)
        String result10_4 = cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DATE)+"日～";
        meyasu10_4.setText(result10_4);








        //EditText未記入がないかチェック＆ボタンを押すと保存＆ページ遷移
        View saveButton10_4 = (Button) findViewById(R.id.save10_4);
        saveButton10_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameText10_4 = (EditText)findViewById(R.id.edityobou10_4);


                //未記入があるかチェック
                if(nameText10_4.getText().toString().equals("") == false)
                {


                    //1回目接種日を本体に記憶する
                    savePrefs10_4();

                    Intent i = new Intent(getApplicationContext(), Yobou10.class);

                    //SubActivityの起動
                    startActivity(i);
                }else {   //未記入があるとページ遷移できずトースト表示
                    Toast.makeText(Yobou_10_1_4.this, "日付を入力してください", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    //今日の日付を取得
    Calendar cal = Calendar.getInstance();



    //1回目のedittextを押すと日付を出す
    public void onclick_ed_10_4(View view) {
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                Yobou_10_1_4.this.year_yobou_10_4 = year;
                month2_yobou_10_4 = monthOfYear;
                day_yobou_10_4 = dayOfMonth;


                EditText txtDate = (EditText) Yobou_10_1_4.this.findViewById(R.id.edityobou10_4);
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
    private void savePrefs10_4() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("YEAR10_4", year_yobou_10_4);
        editor.putInt("MONTH10_4", month2_yobou_10_4);
        editor.putInt("DAY10_4", day_yobou_10_4);
        editor.commit();

    }


    //戻るボタンで前アクティビティへ
    public void onBackPressed() {
        // インテントで予防接種ページ移動
        Intent i = new Intent(getApplicationContext(), Yobou10.class);
        //SubActivityの起動
        startActivity(i);
    }
}
