package com.example.sunrise_system.bosimemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**ＬｉｓｔＶｉｅアダプター
 * Created by sunrise-system on 2016/10/14.
 */

public class ListViewCustomAdapter extends ArrayAdapter<ListViewCustomData> {
    private LayoutInflater layoutInflater_;

    public ListViewCustomAdapter(Context context, int textViewResourceId, List<ListViewCustomData> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        ListViewCustomData item = (ListViewCustomData)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.listviewcustom, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする。
        ImageView imageView;
        imageView = (ImageView)convertView.findViewById(R.id.image);
        imageView.setImageBitmap(item.getImageData());

        TextView textView;
        textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(item.getTextData());

        TextView textView2;
        textView2 = (TextView)convertView.findViewById(R.id.text2);
        textView2.setText(item.getTextData2());

        return convertView;
    }
}