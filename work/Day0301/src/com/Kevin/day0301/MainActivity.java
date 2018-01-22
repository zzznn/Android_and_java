package com.Kevin.day0301;

import java.util.ArrayList;
import java.util.List;

import com.Kevin.day0301.MainActivity;
import com.Kevin.day0301.Person;
import com.Kevin.day0301.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private List<Person> mList = new ArrayList<Person>();
	private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

	private void initView() {
		mLv = (ListView) findViewById(R.id.lv);
		//1：数据源
		for(int i = 0;i < 20; i++){
			Person person = new Person();
			person.setAge(i);
			person.setName("年龄是"+i);
			mList.add(person);
		}
		//2：适配器
		MyAdapter myAdapter = new MyAdapter();
		//3：设置适配器
		mLv.setAdapter(myAdapter);
		
	}

	//自定义适配器
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.listview, null);
				holder.tvAge = (TextView) convertView.findViewById(R.id.tv_age);
				holder.tvName = (TextView)convertView.findViewById(R.id.tv_name);
				convertView.setTag(holder);
			}else {
				holder = (ViewHolder) convertView.getTag();
			}
			//加载数据
			Person person = mList.get(position);
			int age = person.getAge();
			String name = person.getName();
			holder.tvAge.setText("年龄是："+age);
			holder.tvName.setText("姓名是："+name);
			
			return convertView;
		}
		class ViewHolder{
			TextView tvName;
			TextView tvAge;
		}
		
	}
  
}
