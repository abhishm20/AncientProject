package mad.example.mymediaplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	ListView musiclist;
	Cursor musiccursor;
	int music_column_index;
	int count;
	MediaPlayer mMediaPlayer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init_phone_music_grid();
	}

	@SuppressWarnings("deprecation")
	private void init_phone_music_grid() {
		System.gc();
		String[] proj = { MediaStore.Audio.Media._ID,
				MediaStore.Audio.Media.DATA,
				MediaStore.Audio.Media.DISPLAY_NAME,
				MediaStore.Video.Media.SIZE };
		musiccursor = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
				proj, null, null, null);
		count = musiccursor.getCount();
		musiclist = (ListView) findViewById(R.id.PhoneMusicList);
		musiclist.setAdapter(new MusicAdapter(getApplicationContext()));

		musiclist.setOnItemClickListener(musicgridlistener);
		mMediaPlayer = new MediaPlayer();
	}

	private OnItemClickListener musicgridlistener = new OnItemClickListener() {
		public void onItemClick(
				@SuppressWarnings("rawtypes") AdapterView parent, View v,
				int position, long id) {
			System.gc();
			music_column_index = musiccursor
					.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
			musiccursor.moveToPosition(position);
			String filename = musiccursor.getString(music_column_index);
			Bundle bundle = new Bundle();
			bundle.putString("key", filename);
			Intent intent = new Intent("mad.example.mymediaplayer.PlaySong");
			intent.putExtras(bundle);
			startActivity(intent);
			/*
			 * try { if (mMediaPlayer.isPlaying()) { mMediaPlayer.reset(); }
			 * mMediaPlayer.setDataSource(filename); mMediaPlayer.prepare();
			 * mMediaPlayer.start(); } catch (Exception e) {
			 * 
			 * }
			 */
		}
	};

	public class MusicAdapter extends BaseAdapter {
		private Context mContext;

		public MusicAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return count;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			System.gc();
			TextView tv = new TextView(mContext.getApplicationContext());
			String id = null;
			if (convertView == null) {
				music_column_index = musiccursor
						.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
				musiccursor.moveToPosition(position);
				id = musiccursor.getString(music_column_index);
				music_column_index = musiccursor
						.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE);
				musiccursor.moveToPosition(position);
				id += " Size(KB):" + musiccursor.getString(music_column_index);
				tv.setText(id);
			} else
				tv = (TextView) convertView;
			return tv;
		}
	}
}
