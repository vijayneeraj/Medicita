package com.medicitadocter.doctor.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.medicitadocter.R;
import com.medicitadocter.base.BaseFragment;
import com.medicitadocter.utils.Utils;

/**
 * Created by br on 16/8/17.
 */

public class VideoChatMainScreen extends BaseFragment {

    private TextView tvTitle,tvSubtitle;
    private ImageView ivCallDisconnect;
    private ImageView ivHelp,ivDollar,ivRx,ivNote,ivAttachment,ivMessages;
    private ImageView ivClientVideoView;
    private ImageView ivVideo,ivMice,ivSpeaker,ivShare;
    private RelativeLayout rlMain;
    private LinearLayout llShare,llSpeaker,llMice,llVideo;
    private LinearLayout llVideoCallControls,llVideoChatServices,llClientVideoView,llMessages;

    public static VideoChatMainScreen newInstance()
    {
        Bundle args=new Bundle();
        VideoChatMainScreen videoChatMainScreen = new VideoChatMainScreen();
        videoChatMainScreen.setArguments(args);
        return videoChatMainScreen;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayoutResourceView() {
        return R.layout.doc_video_calling_main_screen;
    }

    @Override
    protected void findView() {
        getHandler().toolbarVisibility(true);
        Utils.customBackPressForFragment(getFragmentView(),getHandler(),getActivity());

        rlMain = (RelativeLayout) findViewByIds(R.id.rlMain);

        tvTitle = (TextView) findViewByIds(R.id.tvTitle);
        tvSubtitle = (TextView) findViewByIds(R.id.tvSubtitle);

        ivCallDisconnect = (ImageView) findViewByIds(R.id.ivCallDisconnect);
        ivCallDisconnect.setOnClickListener(this);

        llClientVideoView = (LinearLayout) findViewByIds(R.id.llClientVideoView);
        ivClientVideoView = (ImageView) findViewByIds(R.id.ivClientVideoView);
        llClientVideoView.setTag("n");
        ivClientVideoView.setTag("n");
        llClientVideoView.setOnClickListener(this);

        ivVideo = (ImageView) findViewByIds(R.id.ivVideo);
        ivMice = (ImageView) findViewByIds(R.id.ivMice);
        ivSpeaker = (ImageView) findViewByIds(R.id.ivSpeaker);
        ivShare = (ImageView) findViewByIds(R.id.ivShare);
        llShare = (LinearLayout) findViewByIds(R.id.llShare);
        llShare.setTag("n");
        llSpeaker = (LinearLayout) findViewByIds(R.id.llSpeaker);
        llSpeaker.setTag("n");
        llMice = (LinearLayout) findViewByIds(R.id.llMice);
        llMice.setTag("n");
        llVideo = (LinearLayout) findViewByIds(R.id.llVideo);
        llVideo.setTag("n");
        llShare.setOnClickListener(this);
        llSpeaker.setOnClickListener(this);
        llMice.setOnClickListener(this);
        llVideo.setOnClickListener(this);

        ivHelp = (ImageView) findViewByIds(R.id.ivHelp);
        ivDollar = (ImageView) findViewByIds(R.id.ivDollar);
        ivRx = (ImageView) findViewByIds(R.id.ivRx);
        ivNote = (ImageView) findViewByIds(R.id.ivNote);
        ivAttachment = (ImageView) findViewByIds(R.id.ivAttachment);
        ivMessages = (ImageView) findViewByIds(R.id.ivMessages);
        llMessages = (LinearLayout) findViewByIds(R.id.llMessages);
        ivMessages.setOnClickListener(this);
        ivAttachment.setOnClickListener(this);
        ivNote.setOnClickListener(this);
        ivRx.setOnClickListener(this);
        ivDollar.setOnClickListener(this);
        ivHelp.setOnClickListener(this);

        llVideoCallControls = (LinearLayout) findViewByIds(R.id.llVideoCallControls);

        llVideoChatServices = (LinearLayout) findViewByIds(R.id.llVideoChatServices);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ivCallDisconnect:
            {
                getHandler().toolbarVisibility(false);
                getActivity().onBackPressed();
                break;
            }
            case R.id.llClientVideoView:
            {
                Drawable client = ivClientVideoView.getBackground();
                Drawable provider = rlMain.getBackground();
                if(ivClientVideoView.getTag().equals("n"))
                {
                    ivClientVideoView.setBackground(provider);
                    rlMain.setBackground(client);
                    ivClientVideoView.setTag("r");
                    break;
                }
                else if (ivClientVideoView.getTag().equals("r"))
                {
                    ivClientVideoView.setBackground(client);
                    rlMain.setBackground(provider);
                    ivClientVideoView.setTag("n");
                    break;
                }
                break;
            }
            case R.id.llShare:
            {
                setBackgroundColorOnControlButtons(v.getId());
                break;
            }
            case R.id.llSpeaker:
            {
                setBackgroundColorOnControlButtons(v.getId());
                break;
            }
            case R.id.llMice:
            {
                setBackgroundColorOnControlButtons(v.getId());
                break;
            }
            case R.id.llVideo:
            {
                setBackgroundColorOnControlButtons(v.getId());
                break;
            }
            case R.id.ivMessages:
            {
                setFragments(R.id.flPatientMain, MessageChatMainScreen.newInstance(),true);
                break;
            }
            case R.id.ivAttachment:
            {
                setFragments(R.id.flPatientMain, VideoChatAttachmentFragment.newInstance(),true);
                break;
            }
            case R.id.ivNote:
            {
                setFragments(R.id.flPatientMain, VideoChatNoteFragment.newInstance(),true);
                break;
            }
            case R.id.ivRx:
            {
                setFragments(R.id.flPatientMain, VideoChatRxFragment.newInstance(),true);
                break;
            }
            case R.id.ivDollar:
            {
                setFragments(R.id.flPatientMain, VideoCahtDollerFragment.newInstance(),true);
                break;
            }
            case R.id.ivHelp:
            {

                break;
            }
        }
    }

    private void setBackgroundColorOnControlButtons(int id) {
            switch (id)
            {
                case R.id.llVideo:
                {
                    if(llVideo.getTag().equals("n"))
                    {
                        llVideo.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
                        Log.d("rahul"," : r ");
                        llVideo.setTag("r");
                        break;
                    }
                    else
                    {
                        llVideo.setBackgroundColor(getActivity().getResources().getColor(R.color.transparent));
                        Log.d("rahul"," : n ");
                        llVideo.setTag("n");
                        break;
                    }
                }
                case R.id.llMice:
                {
                    if(llMice.getTag().equals("n"))
                    {
                        llMice.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
                        llMice.setTag("r");
                        break;
                    }
                    else
                    {
                        llMice.setBackgroundColor(getActivity().getResources().getColor(R.color.transparent));
                        llMice.setTag("n");
                        break;
                    }
                }
                case R.id.llSpeaker:
                {
                    if(llSpeaker.getTag().equals("n"))
                    {
                        llSpeaker.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
                        llSpeaker.setTag("r");
                        break;
                    }
                    else
                    {
                        llSpeaker.setBackgroundColor(getActivity().getResources().getColor(R.color.transparent));
                        llSpeaker.setTag("n");
                        break;
                    }
                }
                case R.id.llShare:
                {
                    if(llShare.getTag().equals("n"))
                    {
                        llShare.setBackgroundColor(getActivity().getResources().getColor(R.color.red));
                        llShare.setTag("r");
                        break;
                    }
                    else
                    {
                        llShare.setBackgroundColor(getActivity().getResources().getColor(R.color.transparent));
                        llShare.setTag("n");
                        break;
                    }
                }
            }
    }
}
