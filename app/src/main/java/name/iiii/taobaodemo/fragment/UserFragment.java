package name.iiii.taobaodemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import name.iiii.taobaodemo.R;
import name.iiii.taobaodemo.activity.LoginActivity;

public class UserFragment extends Fragment {
	private View mViews;
	private TextView top_title;
	private Button login_btn;
	private int login_now = 0;

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
		login_btn = (Button) mViews.findViewById(R.id.login_btn);
		if (login_now == 1){
			login_btn.setText("退　出　登　录");
			login_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

				}
			});
		}else {
			login_btn.setText("请　登　录");
			login_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(UserFragment.this.getActivity(), LoginActivity.class);
					startActivity(intent);
				}
			});
		}
	}

	private void initEvents() {

	}
}
