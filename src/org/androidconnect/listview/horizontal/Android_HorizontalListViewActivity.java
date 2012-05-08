package org.androidconnect.listview.horizontal;

import org.androidconnect.listview.horizontal.adapter.HorizontalListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Android_HorizontalListViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.listviewdemo);
		
		HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
		listview.setAdapter(new HAdapter());
		
	}
	
	private static String[] dataObjects = new String[]{ "Text #1",
		"Text #2",
		"Text #3",
		"Text android",
		"Text connnect",
		"www.androidconnect.org"}; 
	
	private class  HAdapter extends BaseAdapter {

		public HAdapter(){
			super();
		}
		private OnClickListener mOnButtonClicked = new OnClickListener() {
			
			public void onClick(View v) {
				Button bt = (Button) v;
				
				Toast.makeText(getApplicationContext(), "Hola desde " + bt.getText(), Toast.LENGTH_SHORT).show();			
			}
		};

		
		public int getCount() {
			return dataObjects.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		
		public View getView(int position, View convertView, ViewGroup parent) {
			View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
			TextView title = (TextView) retval.findViewById(R.id.title);
			Button button = (Button) retval.findViewById(R.id.clickbutton);
			button.setOnClickListener(mOnButtonClicked);
			title.setText(dataObjects[position]);
			
			return retval;
		}
		
	};

}