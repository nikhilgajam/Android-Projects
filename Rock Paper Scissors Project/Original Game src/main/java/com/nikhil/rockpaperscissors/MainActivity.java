package com.nikhil.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;      // Java Random Module

public class MainActivity extends AppCompatActivity {

    RockPaperScissors r = new RockPaperScissors();
    String display = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);   // Only Portrait Mode

    }

    public void rock(View v){
        ImageView iconImg = (ImageView)findViewById(R.id.iconImg);
        ImageView rockImg = (ImageView)findViewById(R.id.rockImg);
        ImageView paperImg = (ImageView)findViewById(R.id.paperImg);
        ImageView scissorsImg = (ImageView)findViewById(R.id.scissorsImg);
        iconImg.animate().alpha(0).setDuration(1000);
        paperImg.animate().alpha(0).setDuration(1000);
        scissorsImg.animate().alpha(0).setDuration(1000);
        rockImg.animate().alpha(1).setDuration(1000);   // Animation

        display = r.rock();
        ((TextView)findViewById(R.id.output)).setText(display);  // Dynamic message display

        MediaPlayer rock_sound = MediaPlayer.create(this, R.raw.rock);    // Sounds
        rock_sound.start();
    }

    public void paper(View v){
        ImageView iconImg = (ImageView)findViewById(R.id.iconImg);
        ImageView rockImg = (ImageView)findViewById(R.id.rockImg);
        ImageView paperImg = (ImageView)findViewById(R.id.paperImg);
        ImageView scissorsImg = (ImageView)findViewById(R.id.scissorsImg);
        iconImg.animate().alpha(0).setDuration(1000);
        rockImg.animate().alpha(0).setDuration(1000);
        scissorsImg.animate().alpha(0).setDuration(1000);
        paperImg.animate().alpha(1).setDuration(1000);

        display = r.paper();
        ((TextView)findViewById(R.id.output)).setText(display);

        MediaPlayer paper_sound = MediaPlayer.create(this, R.raw.paper);
        paper_sound.start();
    }

    public void scissors(View v){
        ImageView iconImg = (ImageView)findViewById(R.id.iconImg);
        ImageView rockImg = (ImageView)findViewById(R.id.rockImg);
        ImageView paperImg = (ImageView)findViewById(R.id.paperImg);
        ImageView scissorsImg = (ImageView)findViewById(R.id.scissorsImg);
        iconImg.animate().alpha(0).setDuration(1000);
        rockImg.animate().alpha(0).setDuration(1000);
        paperImg.animate().alpha(0).setDuration(1000);
        scissorsImg.animate().alpha(1).setDuration(1000);

        display = r.scissors();
        ((TextView)findViewById(R.id.output)).setText(display);

        MediaPlayer scissors_sound = MediaPlayer.create(this, R.raw.scissors);
        scissors_sound.start();
    }

    public void done(View v){
        ImageView iconImg = (ImageView)findViewById(R.id.iconImg);
        ImageView rockImg = (ImageView)findViewById(R.id.rockImg);
        ImageView paperImg = (ImageView)findViewById(R.id.paperImg);
        ImageView scissorsImg = (ImageView)findViewById(R.id.scissorsImg);
        rockImg.animate().alpha(0).setDuration(1000);
        paperImg.animate().alpha(0).setDuration(1000);
        scissorsImg.animate().alpha(0).setDuration(1000);
        iconImg.animate().alpha(1).setDuration(1000);

        display = r.done();
        ((TextView)findViewById(R.id.output)).setText(display);

        MediaPlayer done_sound = MediaPlayer.create(this, R.raw.done);
        done_sound.start();

        play_sounds(display);

    }

    public void play_sounds(String str){
        MediaPlayer tie_sound = MediaPlayer.create(this, R.raw.tie);
        MediaPlayer you_won_sound = MediaPlayer.create(this, R.raw.you_won);
        MediaPlayer computer_won_sound = MediaPlayer.create(this, R.raw.computer_won);

        if(str.equals("Tie")){
            tie_sound.start();
        }else if(str.equals("You Won The Game")){
            you_won_sound.start();
        }else {
            computer_won_sound.start();
        }

    }

    public void web_page(View v){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/nikhiltech"));
        startActivity(browserIntent);
    }


    // Logic Class
    class RockPaperScissors{

        long user = 0, comp = 0, count=0;
        String val = "";


        public String rock(){
            val = game(1);
            return val;
        }

        public String paper(){
            val = game(2);
            return val;
        }

        public String scissors(){
            val = game(3);
            return val;
        }

        public String done(){

            if(user == comp){
                val = "Tie";
            }else if(user > comp){
                val = "You Won The Game";
            }else{
                val = "Computer Won The Game";
            }

            user = comp = 0;

            ((TextView)findViewById(R.id.usertxt)).setText(R.string.user_0);
            ((TextView)findViewById(R.id.comptxt)).setText(R.string.comp_0);
            ((TextView)findViewById(R.id.comp_disp)).setText("");
            ((TextView)findViewById(R.id.user_disp)).setText("");
            String it = "Played " + count + " Time(s)";
            ((TextView)findViewById(R.id.action_disp)).setText(it);

            return val;

        }

        public String game(int entered){
            count++;

            String ret="", show;

            Random r = new Random();
            int rand = r.nextInt(3) + 1;

            if(entered == rand){

                if(entered == 1){
                    ((TextView)findViewById(R.id.comp_disp)).setText(R.string.rock);
                    ((TextView)findViewById(R.id.user_disp)).setText(R.string.rock);
                }else if(entered == 2){
                    ((TextView)findViewById(R.id.comp_disp)).setText(R.string.paper);
                    ((TextView)findViewById(R.id.user_disp)).setText(R.string.paper);
                }else{
                    ((TextView)findViewById(R.id.comp_disp)).setText(R.string.scissors);
                    ((TextView)findViewById(R.id.user_disp)).setText(R.string.scissors);
                }

                ((TextView)findViewById(R.id.action_disp)).setText("");

                val = "Draw";
                return val;

            }else if(rand == 1 && entered == 2){
                ret = "You Got A Point";
                user++;
                show = "User : " + user;

                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.rock);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.paper);
                ((TextView)findViewById(R.id.usertxt)).setText(show);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_paper);

            }else if(rand == 2 && entered == 1){
                ret = "Computer Got A Point";
                comp++;
                show = "Comp : " + comp;

                ((TextView)findViewById(R.id.comptxt)).setText(show);
                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.paper);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.rock);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_paper);

            }else if(rand == 3 && entered == 1){
                ret = "You Got A Point";
                user++;
                show = "User : " + user;

                ((TextView)findViewById(R.id.usertxt)).setText(show);
                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.scissors);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.rock);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_rock);

            }else if(rand == 1 && entered == 3){
                ret = "Computer Got A Point";
                comp++;
                show = "Comp : " + comp;

                ((TextView)findViewById(R.id.comptxt)).setText(show);
                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.rock);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.scissors);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_rock);

            }else if(rand == 2 && entered == 3){
                ret = "You Got A Point";
                user++;
                show = "User : " + user;

                ((TextView)findViewById(R.id.usertxt)).setText(show);
                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.paper);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.scissors);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_scissors);

            }else if(rand == 3 && entered == 2){
                ret = "Computer Got A Point";
                comp++;
                show = "Comp : " + comp;

                ((TextView)findViewById(R.id.comptxt)).setText(show);
                ((TextView)findViewById(R.id.comp_disp)).setText(R.string.scissors);
                ((TextView)findViewById(R.id.user_disp)).setText(R.string.paper);
                ((TextView)findViewById(R.id.action_disp)).setText(R.string.action_scissors);

            }

            return ret;

        }

    }

}
