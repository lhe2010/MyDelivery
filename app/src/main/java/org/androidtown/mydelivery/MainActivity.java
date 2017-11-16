package org.androidtown.mydelivery;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyItem> ds1;
    ArrayList<MyItem> ds2;
    ArrayList<MyItem> ds3;
    ArrayList<MyItem> ds4;
//    final static ArrayList<MyItem>
    MyAdapter Adapter1;
    MyAdapter Adapter2;
    MyAdapter Adapter3;
    MyAdapter Adapter4;
    ListView list1;
    ListView list2;
    ListView list3;
    ListView list4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ds1 = new ArrayList<>();
        ds2 = new ArrayList<>();
        ds3 = new ArrayList<>();
        ds4 = new ArrayList<>();
        Adapter1 = new MyAdapter(this, ds1);
        Adapter2 = new MyAdapter(this, ds2);
        Adapter3 = new MyAdapter(this, ds3);
        Adapter4 = new MyAdapter(this, ds4);
        list1 = (ListView) findViewById(R.id.listTab1);
        list2 = (ListView) findViewById(R.id.listTab2);
        list3 = (ListView) findViewById(R.id.listTab3);
        list4 = (ListView) findViewById(R.id.listTab4);

        list1.setAdapter(Adapter1);
        list2.setAdapter(Adapter2);
        list3.setAdapter(Adapter3);
        list4.setAdapter(Adapter4);

        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list4.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        // ds 추가
        ds1.add(new MyItem("노트북", "1일", "월요일", "2017/1/1", "배송중", "서울택배"));
        ds2.add(new MyItem("냉장고", "2일", "화요일", "2017/1/2", "배송완료", "성신택배"));
        ds1.add(new MyItem("김치냉장고", "3일", "수요일", "2017/1/3", "배송중", "삼성택배"));
        Adapter1.notifyDataSetChanged();
        Adapter2.notifyDataSetChanged();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("배송 목록"/*, getDrawable(R.drawable.icnred)*/);
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("등록 예정");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("배송중");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Tab Four");
        spec.setContent(R.id.tab4);
        spec.setIndicator("배송 완료");
        host.addTab(spec);
    }
}


class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<MyItem> ds;

    public MyAdapter(Context context, ArrayList<MyItem> ds) {
        this.context = context;
        this.ds = ds;
    }

    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return ds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {    // 뷰를 생성하기 위한 메소드
        if(ds.size() < 1){
            view = View.inflate(context, R.layout.emptylist, null);
            return view;
        }
        if (view == null) {
            view = View.inflate(context, R.layout.row, null);
        }
        TextView pname = (TextView) (view.findViewById(R.id.pname));
        TextView date = (TextView) (view.findViewById(R.id.date));
        TextView day = (TextView) (view.findViewById(R.id.day));
        TextView deldate = (TextView) (view.findViewById(R.id.deldate));
        TextView status = (TextView) (view.findViewById(R.id.status));
        TextView cname = (TextView) (view.findViewById(R.id.cname));

        pname.setText(ds.get(i).getPname());
        date.setText(ds.get(i).getDate());
        day.setText(ds.get(i).getDay());
        deldate.setText(ds.get(i).getDeldate());
        status.setText(ds.get(i).getStatus());
        cname.setText(ds.get(i).getCname());
        return view;
    }
}