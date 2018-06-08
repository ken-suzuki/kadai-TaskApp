package jp.techacademy.ken.suzuki.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater = null;
    private List<Task> mTaskList;

    public TaskAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTaskList(List<Task> taskList) {
        mTaskList = taskList;
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTaskList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            // 作成した、adapter_list_item_card を取得。
            convertView = mLayoutInflater.inflate(R.layout.adapter_list_item_card, null);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.title);

        // category を textView2 に変数として定義する
        TextView textView2 = (TextView) convertView.findViewById(R.id.category);

        TextView textView3 = (TextView) convertView.findViewById(R.id.date);

        textView1.setText(mTaskList.get(position).getTitle());

        // category を追加
        textView2.setText(mTaskList.get(position).getCategory());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE);
        Date date = mTaskList.get(position).getDate();
        textView3.setText(simpleDateFormat.format(date));

        return convertView;
    }
}