package curtin.edu.au.mapgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import curtin.edu.au.mapgame.Model.GameMap;
import curtin.edu.au.mapgame.Model.Player;

public class NavigationActivity extends AppCompatActivity
{
    private static final int MAX_LOC = 3;
    private Player player;
    private GameMap map;
    private Button north;
    private Button south;
    private Button east;
    private Button west;
    private TextView health;
    private TextView cash;
    private TextView mass;
    private Button restart;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(player == null)
        {
            player = new Player();
        }
        if(map == null)
        {
            map = new GameMap();
        }

        // Connect health / cash / mass bars -------------------------------------------------------
        health = findViewById(R.id.tv_health);
        cash = findViewById(R.id.tv_cash);
        mass = findViewById(R.id.tv_mass);

        // Connect Navigation Buttons --------------------------------------------------------------
        north = findViewById(R.id.btn_north);
        south = findViewById(R.id.btn_south);
        east = findViewById(R.id.btn_east);
        west = findViewById(R.id.btn_west);

        // Connect Restart Button ------------------------------------------------------------------
        restart = findViewById(R.id.btn_restart);

        // Add Restart Button Listener -------------------------------------------------------------
        restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                player = new Player();
                map = new GameMap();
                health.setText(String.valueOf("Health: " + player.getHealth()));
                cash.setText(String.valueOf("Cash: " + player.getCash()));
                mass.setText(String.valueOf("Mass: " + player.getEquipmentMass()));
            }
        });

        // Add Navigation Button Listeners ---------------------------------------------------------
        north.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(player.getRowLocation() > 0)
                {
                    Toast.makeText(NavigationActivity.this, R.string.move_north, Toast.LENGTH_SHORT).show();
                    player.moveNorth();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                }
                else
                {
                    Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT).show();
                }
            }
        });

        south.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(player.getRowLocation() < MAX_LOC)
                {
                    Toast.makeText(NavigationActivity.this, R.string.move_south, Toast.LENGTH_SHORT).show();
                    player.moveSouth();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                }
                else
                {
                    Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT).show();
                }
            }
        });

        east.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(player.getColLocation() < MAX_LOC)
                {
                    Toast.makeText(NavigationActivity.this, R.string.move_east, Toast.LENGTH_SHORT).show();
                    player.moveEast();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                }
                else
                {
                    Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT).show();
                }
            }
        });

        west.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(player.getColLocation() > 0)
                {
                    Toast.makeText(NavigationActivity.this, R.string.move_west, Toast.LENGTH_SHORT).show();
                    player.moveWest();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                }
                else
                {
                    Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
