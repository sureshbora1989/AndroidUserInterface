package com.pronto.adnroiduserinterfce.fragmetns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pronto.adnroiduserinterfce.PartThreeActivity;
import com.pronto.adnroiduserinterfce.R;

public class ContactsFragment extends BaseFragment {

	private PartThreeActivity partThreeActivity;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_contacts, container, false);
	}

}
