package com.medicitadocter.doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 16/8/17.
 */

public class MessageChatMainScreen extends BaseFragment {

    public static MessageChatMainScreen newInstance()
    {
        Bundle args=new Bundle();
        MessageChatMainScreen messageChatMainScreen = new MessageChatMainScreen();
        messageChatMainScreen.setArguments(args);
        return messageChatMainScreen;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_chat_room;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        Utils.customBackPressForChildFragment(getFragmentView(),getHandler(),getActivity());
    }

    @Override
    protected void init() {

    }
}
