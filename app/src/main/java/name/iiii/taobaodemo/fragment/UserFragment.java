package name.iiii.taobaodemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import name.iiii.taobaodemo.R;

public class UserFragment extends Fragment {
	private View mViews;
	private TextView top_title;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mViews = inflater.inflate(R.layout.fragment_user, container, false);
		initViews();
		initEvents();
		return mViews;
	}

	private void initViews() {
		top_title = (TextView) mViews.findViewById(R.id.top_title);
		top_title.setText("个人中心");

	}

	private void initEvents() {

	}
}
