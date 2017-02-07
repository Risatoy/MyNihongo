package com.example.risatoyoshima.mynihongo;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class card1_1 extends Fragment {

    private MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private Button start, stop, play;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_card11, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.fruit1);
        image.setOnTouchListener(new View.OnTouchListener(){
            int clicked = 1;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        if(clicked == 1){
                            MediaPlayer mp = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.banana);
                            mp.start();
                        }
                        break;

                }
                return true;

            }
        });


        start = (Button) rootView.findViewById(R.id.btn_start);
        stop = (Button) rootView.findViewById(R.id.btn_stop);
        play = (Button) rootView.findViewById(R.id.btn_play);

        stop.setEnabled(false);
        play.setEnabled(false);

        outputFile = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/myrecording.3gp";

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
			/*Two basic methods perpare and start to start recording the audio.*/
                    myAudioRecorder.prepare();
                    myAudioRecorder.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                start.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(getActivity().getApplicationContext(), "Recording started",
                        Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*This method stops the recording process.*/
                myAudioRecorder.stop();

		/*This method should be called when the recorder instance is needed.*/
                myAudioRecorder.release();
                myAudioRecorder = null;
                stop.setEnabled(false);
                play.setEnabled(true);
                Toast.makeText(getActivity().getApplicationContext(), "Audio recorded successfully",
                        Toast.LENGTH_LONG).show();

            }
        });

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {
                MediaPlayer m = new MediaPlayer();
                try {
                    m.setDataSource(outputFile);
                    m.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                m.start();
                Toast.makeText(getActivity().getApplicationContext(), "Playing audio",
                        Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}

