package com.example.sunrise_system.bosimemo;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class NameTouroku extends Activity {

    //カレンダー変数
    Calendar cal;


    //年、月、日
    private int year;
    private int month;
    private int day;

    //プレファレンススファイル名
    private static final String PREFS_FILE = "MyPrefsFile";
    //プレファレンスのためのｷｰ
    private static final String YEAR = "YEAR";
    private static final String MONTH = "MONTH";
    private static final String DAY = "DAY";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.nametouroku);



        //EditText未記入がないかチェック＆ボタンを押すと保存＆ページ遷移
        View saveButton = (Button) findViewById(R.id.savebtn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText nameText = (EditText)findViewById(R.id.editt);
                final EditText dayText = (EditText)findViewById(R.id.editcla);

                //未記入があるかチェック
                if(nameText.getText().toString().equals("") == false && dayText.getText().toString().equals("")==false) {


                   //名前など項目を本体に記憶する
                    save();
                    save2();
                    savePrefs();

                    Intent i = new Intent(getApplicationContext(), TopGamen.class);

                    //SubActivityの起動
                    startActivity(i);
                }else {   //未記入があるとページ遷移できずトースト表示
                    Toast.makeText(NameTouroku.this, "未記入があります", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //今日の日付を取得
        cal = Calendar.getInstance();



        //性別をセレクトボックスで選択する
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アイテムを追加します
        adapter.add("選択してください");
        adapter.add("男の子");
        adapter.add("女の子");
        Spinner spinner = (Spinner) findViewById(R.id.sebetuspi);
        // アダプターを設定します
        spinner.setAdapter(adapter);
        // スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得しま
                String item = (String) spinner.getSelectedItem();}
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }

        );
    }





    //edittextを押すと日付を出す
    public void onclickcal(View view) {
        // DatePickerDialogインスタンスを取得
        DatePickerDialog d_date = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                        NameTouroku.this.year = year;
                        month = monthOfYear;
                        day = dayOfMonth;


                        EditText txtDate = (EditText) NameTouroku.this.findViewById(R.id.editcla);
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





    //Preferencesで文字を本体ファイルに保存
    private void save() {
        EditText editText = (EditText) findViewById(R.id.editt);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString("name", editText.getText().toString()).commit();
    }

    private void save2() {
        EditText editTextDay = (EditText) findViewById(R.id.editcla);
        SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
        sp2.edit().putString("birtday", editTextDay.getText().toString()).commit();
    }

    //プレファレンスに保存
    private void savePrefs() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(YEAR, year);
        editor.putInt(MONTH, month);
        editor.putInt(DAY, day);
        editor.commit();

    }


    //戻るボタンでアクティビティを終了、前アクティビティへ
    public void onBackPressed() {
        finish();
    }

}






