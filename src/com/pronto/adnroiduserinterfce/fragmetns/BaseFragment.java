package com.pronto.adnroiduserinterfce.fragmetns;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.pronto.adnroiduserinterfce.HidingScrollListnerPartThree;
import com.pronto.adnroiduserinterfce.PartThreeActivity;
import com.pronto.adnroiduserinterfce.R;
import com.pronto.adnroiduserinterfce.RecyclerAdapter;
import com.pronto.adnroiduserinterfce.Utils;

public class BaseFragment extends Fragment {

	private LinearLayout mToolbarContainer;
	private int mToolbarHeight;
	private ImageButton mFabButton;
	private PartThreeActivity partThreeActivity;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_base, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mToolbarContainer = (LinearLayout) partThreeActivity
				.findViewById(R.id.toolbarContainer);
		mToolbarHeight = Utils.getToolbarHeight(getActivity());
		mFabButton = (ImageButton) partThreeActivity
				.findViewById(R.id.fabButton);
		initRecyclerView(view);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (partThreeActivity == null) {
			partThreeActivity = (PartThreeActivity) activity;
		}
	}

	private void initRecyclerView(View view) {
		final RecyclerView recyclerView = (RecyclerView) view
				.findViewById(R.id.basic_recyler_view);

		int paddingTop = Utils.getToolbarHeight(getActivity())
				+ Utils.getTabsHeight(getActivity());
		recyclerView
				.setPadding(recyclerView.getPaddingLeft(), paddingTop,
						recyclerView.getPaddingRight(),
						recyclerView.getPaddingBottom());

		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		RecyclerAdapter recyclerAdapter = new RecyclerAdapter(createItemList());
		recyclerView.setAdapter(recyclerAdapter);

		recyclerView.setOnScrollListener(new HidingScrollListnerPartThree(
				getActivity()) {

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
