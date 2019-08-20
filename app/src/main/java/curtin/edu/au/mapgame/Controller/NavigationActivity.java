package curtin.edu.au.mapgame.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import curtin.edu.au.mapgame.Model.GameMap;
import curtin.edu.au.mapgame.Model.Player;
import curtin.edu.au.mapgame.R;

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
    private TextView location;
    private Button restart;
    private Button options;


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

        // Connect health / cash / mass / location bars --------------------------------------------
        health = findViewById(R.id.tv_health);
        cash = findViewById(R.id.tv_cash);
        mass = findViewById(R.id.tv_mass);
        location = findViewById(R.id.tv_location);

        // Connect Navigation Buttons --------------------------------------------------------------
        north = findViewById(R.id.btn_north);
        south = findViewById(R.id.btn_south);
        east = findViewById(R.id.btn_east);
        west = findViewById(R.id.btn_west);

        // Connect Options Button ------------------------------------------------------------------
        options = findViewById(R.id.btn_options);

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
                health.setText(R.string.label_health);
                cash.setText(R.string.label_cash);
                mass.setText(R.string.label_mass);
                location.setText(R.string.default_location);
            }
        });

        // Add Options Button Listener -------------------------------------------------------------
        options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(NavigationActivity.this, WildernessOptionActivity.class);
                startActivity(i);
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
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.move_north, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
                    player.moveNorth();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                    location.setText(String.valueOf("Current Location: " + "[" + player.getRowLocation() + "][" + player.getColLocation() + "]"));
                }
                else
                {

                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
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
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.move_south, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
                    player.moveSouth();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                    location.setText(String.valueOf("Current Location: " + "[" + player.getRowLocation() + "][" + player.getColLocation() + "]"));
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
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
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.move_east, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
                    player.moveEast();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                    location.setText(String.valueOf("Current Location: " + "[" + player.getRowLocation() + "][" + player.getColLocation() + "]"));
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
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
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.move_west, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
                    player.moveWest();
                    health.setText(String.valueOf("Health: " + player.getHealth()));
                    location.setText(String.valueOf("Current Location: " + "[" + player.getRowLocation() + "][" + player.getColLocation() + "]"));
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 775);
                    toast.show();
                }
            }
        });
    }
}
