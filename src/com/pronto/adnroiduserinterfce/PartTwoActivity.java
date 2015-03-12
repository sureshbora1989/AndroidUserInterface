package com.pronto.adnroiduserinterfce;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class PartTwoActivity extends ActionBarActivity {

	private LinearLayout mToolbarContainer;
	private int mToolbarHeight;
	private ImageButton mFabButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_part_two);

		mToolbarContainer = (LinearLayout) findViewById(R.id.toolbarContainer);
		initToolbar();
		initRecyclerView();
		mFabButton = (ImageButton) findViewById(R.id.fabButton);

	}

	private void initToolbar() {
		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		setTitle(getString(R.string.app_name));
		mToolbar.setTitleTextColor(getResources().getColor(
				android.R.color.white));
		mToolbarHeight = Utils.getToolbarHeight(this);
	}

	private void initRecyclerView() {
		final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

		int paddingTop = Utils.getToolbarHeight(PartTwoActivity.this)
				+ Utils.getTabsHeight(PartTwoActivity.this);
		recyclerView
				.setPadding(recyclerView.getPaddingLeft(), paddingTop,
						recyclerView.getPaddingRight(),
						recyclerView.getPaddingBottom());

		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		RecyclerAdapter recyclerAdapter = new RecyclerAdapter(createItemList());
		recyclerView.setAdapter(recyclerAdapter);

		recyclerView.setOnScrollListener(new HidingScrollListnerPartTwo(this) {

			@Override
			public void onMoved(int distance) {
				mToolbarContainer.setTranslationY(-distance);
				mFabButton.setTranslationY(distance * 2);
			}

			@Override
			public void onShow() {
				mToolbarContainer.animate().translationY(0)
						.setInterpolator(new DecelerateInterpolator(2)).start();
				mFabButton.animate().translationY(0)
						.setInterpolator(new DecelerateInterpolator(2)).start();

			}

			@Override
			public void onHide() {
				mToolbarContainer.animate().translationY(-mToolbarHeight)
						.setInterpolator(new AccelerateInterpolator(2)).start();
				FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton
						.getLayoutParams();
				int fabBottomMargin = lp.bottomMargin;
				mFabButton.animate()
						.translationY(mFabButton.getHeight() + fabBottomMargin)
						.setInterpolator(new AccelerateInterpolator(2)).start();
			}

		});
	}

	private List<String> createItemList() {
		List<String> itemList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			itemList.add("Item " + i);
		}
		return itemList;
	}
}