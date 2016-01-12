package name.iiii.taobaodemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private List<Fragment> mFragments;
	private FragmentPagerAdapter mAdapter;

	private LinearLayout tab_home, tab_hot, tab_discover, tab_cart, tab_user;
	private ImageButton tab_home_img, tab_hot_img, tab_discover_img,
			tab_cart_img, tab_user_img;
	private TextView tab_home_tv, tab_hot_tv, tab_discover_tv, tab_cart_tv,
			tab_user_tv;
	private Fragment mTab01, mTab02, mTab03, mTab04, mTab05;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设定始终保持竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();

		setSelect(0);
	}

	private void initViews() {
		tab_home = (LinearLayout) findViewById(R.id.tab_home);
		tab_hot = (LinearLayout) findViewById(R.id.tab_hot);
		tab_discover = (LinearLayout) findViewById(R.id.tab_discover);
		tab_cart = (LinearLayout) findViewById(R.id.tab_cart);
		tab_user = (LinearLayout) findViewById(R.id.tab_user);

		tab_home_img = (ImageButton) findViewById(R.id.tab_home_img);
		tab_hot_img = (ImageButton) findViewById(R.id.tab_hot_img);
		tab_discover_img = (ImageButton) findViewById(R.id.tab_discover_img);
		tab_cart_img = (ImageButton) findViewById(R.id.tab_cart_img);
		tab_user_img = (ImageButton) findViewById(R.id.tab_user_img);

		tab_home_tv = (TextView) findViewById(R.id.tab_home_tv);
		tab_hot_tv = (TextView) findViewById(R.id.tab_hot_tv);
		tab_discover_tv = (TextView) findViewById(R.id.tab_discover_tv);
		tab_cart_tv = (TextView) findViewById(R.id.tab_cart_tv);
		tab_user_tv = (TextView) findViewById(R.id.tab_user_tv);

		/*
		 * Fragment mTab01 = new HomeFragment(); Fragment mTab02 = new
		 * HotFragment(); Fragment mTab03 = new DiscoverFragment(); Fragment
		 * mTab04 = new CartFragment(); Fragment mTab05 = new UserFragment();
		 */

		/*
		 * mFragments = new ArrayList<Fragment>(); Fragment mTab01 = new
		 * HomeFragment(); Fragment mTab02 = new HotFragment(); Fragment mTab03
		 * = new DiscoverFragment(); Fragment mTab04 = new CartFragment();
		 * Fragment mTab05 = new UserFragment();
		 * 
		 * mFragments.add(mTab01); mFragments.add(mTab02);
		 * mFragments.add(mTab03); mFragments.add(mTab04);
		 * mFragments.add(mTab05);
		 * 
		 * mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
		 * 
		 * @Override public int getCount() { return mFragments.size(); }
		 * 
		 * @Override public Fragment getItem(int arg0) { return
		 * mFragments.get(arg0); } };
		 */
	}

	private void initEvents() {
		tab_home.setOnClickListener(this);
		tab_hot.setOnClickListener(this);
		tab_discover.setOnClickListener(this);
		tab_cart.setOnClickListener(this);
		tab_user.setOnClickListener(this);

	}

	private void setSelect(int i) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		switch (i) {
		case 0:
			if (mTab01 == null) {
				mTab01 = new HomeFragment();
				transaction.add(R.id.main_content, mTab01);
			} else {
				transaction.show(mTab01);
			}
			tab_home_img.setImageResource(R.drawable.icon_home_press);
			tab_home_tv.setTextColor(0xFFEB4F38);
			break;
		case 1:
			if (mTab02 == null) {
				mTab02 = new HotFragment();
				transaction.add(R.id.main_content, mTab02);
			} else {
				transaction.show(mTab02);
			}
			tab_hot_img.setImageResource(R.drawable.icon_hot_press);
			tab_hot_tv.setTextColor(0xFFEB4F38);
			break;
		case 2:
			if (mTab03 == null) {
				mTab03 = new DiscoverFragment();
				transaction.add(R.id.main_content, mTab03);
			} else {
				transaction.show(mTab03);
			}
			tab_discover_img.setImageResource(R.drawable.icon_discover_press);
			tab_discover_tv.setTextColor(0xFFEB4F38);
			break;
		case 3:
			if (mTab04 == null) {
				mTab04 = new CartFragment();
				transaction.add(R.id.main_content, mTab04);
			} else {
				transaction.show(mTab04);
			}
			tab_cart_img.setImageResource(R.drawable.icon_cartfill_press);
			tab_cart_tv.setTextColor(0xFFEB4F38);
			break;
		case 4:
			if (mTab05 == null) {
				mTab05 = new UserFragment();
				transaction.add(R.id.main_content, mTab05);
			} else {
				transaction.show(mTab05);
			}
			tab_user_img.setImageResource(R.drawable.icon_user_press);
			tab_user_tv.setTextColor(0xFFEB4F38);
			break;

		default:
			break;
		}

		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {
		if (mTab01 != null) {
			transaction.hide(mTab01);
		}
		if (mTab02 != null) {
			transaction.hide(mTab02);
		}
		if (mTab03 != null) {
			transaction.hide(mTab03);
		}
		if (mTab04 != null) {
			transaction.hide(mTab04);
		}
		if (mTab05 != null) {
			transaction.hide(mTab05);
		}
	}

	@Override
	public void onClick(View v) {
		resetImgs();
		switch (v.getId()) {
		case R.id.tab_home:
			setSelect(0);
			break;

		case R.id.tab_hot:
			setSelect(1);
			break;

		case R.id.tab_discover:
			setSelect(2);
			break;

		case R.id.tab_cart:
			setSelect(3);
			break;

		case R.id.tab_user:
			setSelect(4);
			break;

		default:
			break;
		}
	}

	private void resetImgs() {
		tab_home_img.setImageResource(R.drawable.icon_home);
		tab_hot_img.setImageResource(R.drawable.icon_hot);
		tab_discover_img.setImageResource(R.drawable.icon_discover);
		tab_cart_img.setImageResource(R.drawable.icon_cart);
		tab_user_img.setImageResource(R.drawable.icon_user);
		tab_home_tv.setTextColor(0xFFA9B7B7);
		tab_hot_tv.setTextColor(0xFFA9B7B7);
		tab_discover_tv.setTextColor(0xFFA9B7B7);
		tab_cart_tv.setTextColor(0xFFA9B7B7);
		tab_user_tv.setTextColor(0xFFA9B7B7);
	}
}
