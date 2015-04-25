package com.pronto.colorexample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.Palette.PaletteAsyncListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.pronto.adnroiduserinterfce.R;

public class ColorsPaletteActivity extends ActionBarActivity implements
		PaletteAsyncListener, OnClickListener {

	private ImageView mMainImage;
	private TextView one, two, three, four;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_colorspalette);
		mMainImage = (ImageView) findViewById(R.id.main_image);
		Bitmap bitmap = ((BitmapDrawable) mMainImage.getDrawable()).getBitmap();
		Palette.generateAsync(bitmap, this);
		one = (TextView) findViewById(R.id.text_one);
		one.setOnClickListener(this);
		two = (TextView) findViewById(R.id.text_two);
		two.setOnClickListener(this);
		three = (TextView) findViewById(R.id.text_three);
		three.setOnClickListener(this);
		four = (TextView) findViewById(R.id.text_four);
		four.setOnClickListener(this);
	}

	@Override
	public void onGenerated(Palette palette) {
		if (palette != null) {
			Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
			Palette.Swatch vibrantLightSwatch = palette.getLightVibrantSwatch();
			Palette.Swatch vibrantDarkSwatch = palette.getDarkVibrantSwatch();
			Palette.Swatch mutedSwatch = palette.getMutedSwatch();
			Palette.Swatch mutedLightSwatch = palette.getLightMutedSwatch();
			Palette.Swatch mutedDarkSwatch = palette.getDarkMutedSwatch();
			one.setTextColor(vibrantSwatch.getRgb());
			two.setTextColor(vibrantDarkSwatch.getRgb());
			three.setTextColor(mutedLightSwatch.getRgb());
			four.setTextColor(mutedSwatch.getRgb());

		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.text_one:

			break;

		case R.id.text_two:

			break;
		case R.id.text_three:

			break;
		case R.id.text_four:

			break;
		}
	}
	
	/*
	 * Used to set tint in the compound drawable to textview
	 * */
	public static void tintAndSetCompoundDrawable(Context context,
			@DrawableRes int drawableRes, int color, TextView textview) {

		Resources res = context.getResources();
		int padding = (int) res
				.getDimension(R.dimen.activity_horizontal_margin);

		Drawable drawable = res.getDrawable(drawableRes);
		drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);

		textview.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable,
				null, null, null);

		textview.setCompoundDrawablePadding(padding);
	}

}
