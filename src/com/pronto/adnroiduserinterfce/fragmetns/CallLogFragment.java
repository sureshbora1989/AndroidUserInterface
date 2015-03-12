package com.pronto.adnroiduserinterfce.fragmetns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pronto.adnroiduserinterfce.R;

public class CallLogFragment extends BaseFragment {


	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_calllog, container, false);
	}

}
