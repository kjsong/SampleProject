package com.example.guideapp_sampleproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

	ListView listView;

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);

		listView = (ListView) this.findViewById(R.id.listView);

		ArrayList<String> items = new ArrayList<>();
		items.add("01 서울서예박물관");
		items.add("02 음악당");
		items.add("03 오페라하우스");
		items.add("04 한가람디자인");
		items.add("05 700(홍보관)");
		items.add("06 야외무대");
		items.add("07 비타민스테이션");
		items.add("08 한가람미술관");

		CustomAdapter adapter = new CustomAdapter(this, 0, items);
		listView.setAdapter(adapter);
	}

	private class CustomAdapter extends ArrayAdapter<String> {
		private ArrayList<String> items;

		public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
			super(context, textViewResourceId, objects);
			this.items = objects;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.listitem_data, null);
			}

			// ImageView 인스턴스
			ImageView imageView = (ImageView) v.findViewById(R.id.icon);

			// 리스트뷰의 아이템에 이미지를 변경한다.
			if ("01 서울서예박물관".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_1);
			else if ("02 음악당".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_2);
			else if ("03 오페라하우스".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_3);
			else if ("04 한가람디자인".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_4);
			else if ("05 700(홍보관)".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_5);
			else if ("06 야외무대".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_6);
			else if ("07 비타민스테이션".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_7);
			else if ("08 한가람미술관".equals(items.get(position)))
				imageView.setImageResource(R.drawable.image_8);

			TextView textView = (TextView) v.findViewById(R.id.userId);
			textView.setText(items.get(position));

			final String text = items.get(position);
			Button button = (Button) v.findViewById(R.id.button);
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// Toast.makeText(ListViewActivity.this, text,
					// Toast.LENGTH_SHORT).show();

					Intent intent = new Intent(ListViewActivity.this, PopupActivity.class);
					intent.putExtra("Data", (String) v.getTag());
					startActivity(intent);
				}
				// public void myOnClick(View view){
				// Intent intent = new Intent(ListViewActivity.this,
				// PopupActivity.class);
				// intent.putExtra("Data", (String)view.getTag());
				// startActivity(intent);
				// }

			});

			return v;
		}
	}

	public void myOnClick(View view) {
		Intent intent = new Intent(ListViewActivity.this, PopupActivity.class);
		intent.putExtra("Data", (String) view.getTag());
		startActivity(intent);
	}
}
