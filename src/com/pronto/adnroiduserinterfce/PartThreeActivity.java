package com.pronto.adnroiduserinterfce;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.pronto.adnroiduserinterfce.fragmetns.CallLogFragment;
import com.pronto.adnroiduserinterfce.fragmetns.ContactsFragment;
import com.pronto.adnroiduserinterfce.view.SlidingTabLayout;

public class PartThreeActivity extends ActionBarActivity {

	private SlidingTabLayout mSlidingTabLayout;
	public ViewPager mViewPager;
	private List<SamplePagerItem> mTabs = new ArrayList<SamplePagerItem>();
	public LinearLayout mToolbarContainer;
	public int mToolbarHeight;
	public ImageButton mFabButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_part_three);
		initTabs();
		initToolbar();
		mToolbarContainer = (LinearLayout) findViewById(R.id.toolbarContainer);
		mFabButton = (ImageButton) findViewById(R.id.fabButton);

		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mViewPager.setAdapter(new SampleFragmentPagerAdapter(
				getSupportFragmentManager()));
		mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setDistributeEvenly(true);
		mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(
				android.R.color.white));
		mSlidingTabLayout.setViewPager(mViewPager);
	}

	private void initToolbar() {
		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		setTitle(getString(R.string.app_name));
		mToolbar.setTitleTextColor(getResources().getColor(
				android.R.color.white));
		mToolbarHeight = Utils.getToolbarHeight(this);
	}

	private void initTabs() {
		mTabs.add(new SamplePagerItem(getString(R.string.app_name),
				Color.WHITE, Color.WHITE, 0));
		mTabs.add(new SamplePagerItem(getString(R.string.hello_world),
				Color.WHITE, Color.WHITE, 2));

	}

	class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

		public SampleFragmentPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int i) {
			return mTabs.get(i).createFragment();
		}

		@Override
		public int getCount() {
			return mTabs.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTabs.get(position).getTitle();
		}

	}

	static class SamplePagerItem {
		private final CharSequence mTitle;
		private final int mIndicatorColor;
		private final int mDividerColor;
		private final int mTabPosition;

		SamplePagerItem(CharSequence title, int indicatorColor,
				int dividerColor, int tabPosition) {
			mTitle = title;
			mIndicatorColor = indicatorColor;
			mDividerColor = dividerColor;
			mTabPosition = tabPosition;
		}

		/**
		 * @return A new {@link Fragment} to be displayed by a {@link ViewPager}
		 */
		Fragment createFragment() {
			if (mTabPosition == 0) {
				return new CallLogFragment();
			} else {
				return new ContactsFragment();
			}

		}

		/**
		 * @return the color to be used for indicator on the
		 *         {@link SlidingTabLayout}
		 */
		int getTabPosition() {
			return mTabPosition;
		}

		/**
		 * @return the title which represents this tab. In this sample this is
		 *         used directly by
		 *         {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
		 */
		CharSequence getTitle() {
			return mTitle;
		}

		/**
		 * @return the color to be used for indicator on the
		 *         {@link SlidingTabLayout}
		 */
		int getIndicatorColor() {
			return mIndicatorColor;
		}

		/**
		 * @return the color to be used for right divider on the
		 *         {@link SlidingTabLayout}
		 */
		int getDividerColor() {
			return mDividerColor;
		}
	}

}
