package curtin.edu.au.mapgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import curtin.edu.au.mapgame.Model.Area;
import curtin.edu.au.mapgame.Model.Player;
import curtin.edu.au.mapgame.R;

public class WildernessOptionActivity extends AppCompatActivity {
    private Area currentArea;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilderness_option);

        player = (Player) getIntent().getParcelableExtra("Player");
        currentArea = (Area) getIntent().getParcelableExtra("Area");
        System.out.println("" + player.getHealth());
    }
}
