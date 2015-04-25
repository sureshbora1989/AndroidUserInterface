package com.pronto.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.pronto.adnroiduserinterfce.PartOneActivity;
import com.pronto.adnroiduserinterfce.PartThreeActivity;
import com.pronto.adnroiduserinterfce.PartTwoActivity;
import com.pronto.adnroiduserinterfce.R;
import com.pronto.colorexample.ColorsPaletteActivity;
import com.pronto.scrollexample.StickyScrollActivity;

public class HomeActivity extends ActionBarActivity implements OnClickListener {

	private Button toolbar_hide_with_viewpager, color_platte_finder,
			toolbar_simple, toolbar_with_tabs, sticky_scroll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		color_platte_finder = (Button) findViewById(R.id.color_platte_finder);
		color_platte_finder.setOnClickListener(this);

		toolbar_hide_with_viewpager = (Button) findViewById(R.id.toolbar_hide_with_viewpager);
		toolbar_hide_with_viewpager.setOnClickListener(this);

		toolbar_simple = (Button) findViewById(R.id.simple_toolbar_hide);
		toolbar_simple.setOnClickListener(this);

		toolbar_with_tabs = (Button) findViewById(R.id.toolbar_hide_with_tabs);
		toolbar_with_tabs.setOnClickListener(this);

		sticky_scroll = (Button) findViewById(R.id.sticky_scroll);
		sticky_scroll.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.color_platte_finder: {
			startActivity(new Intent(HomeActivity.this,
					ColorsPaletteActivity.class));
			break;
		}
		case R.id.toolbar_hide_with_viewpager: {
			startActivity(new Intent(HomeActivity.this, PartThreeActivity.class));
			break;
		}

		case R.id.simple_toolbar_hide: {
			startActivity(new Intent(HomeActivity.this, PartOneActivity.class));
			break;
		}

		case R.id.toolbar_hide_with_tabs: {
			startActivity(new Intent(HomeActivity.this, PartTwoActivity.class));
			break;
		}
		case R.id.sticky_scroll: {
			startActivity(new Intent(HomeActivity.this,
					StickyScrollActivity.class));
			break;
		}

		}

	}
}
