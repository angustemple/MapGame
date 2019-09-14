package curtin.edu.au.mapgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import curtin.edu.au.mapgame.R;

public class WinLoseActivity extends AppCompatActivity {
    private static final String PLAYER_HAS_WON = "Player has won";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose);

        // Get data from intent to determine if player has won or lost -----------------------------
        boolean hasWon = getIntent().getBooleanExtra(PLAYER_HAS_WON, false);

        // Establish connections to front end ------------------------------------------------------
        TextView tv_win_lose = findViewById(R.id.tv_win_lose);
        Button restart = findViewById(R.id.btn_restart);

        // Set text depending on whether or not player has won -------------------------------------
        if(hasWon)
        {
            tv_win_lose.setText(R.string.has_won);
        }
        else
        {
            tv_win_lose.setText(R.string.has_lost);
        }

        // Button Listeners ------------------------------------------------------------------------
        restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent data = new Intent();
                setResult(1, data);
                finish();
            }
        });
    }
}
