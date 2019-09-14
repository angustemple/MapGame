package curtin.edu.au.mapgame.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import curtin.edu.au.mapgame.Model.Area;
import curtin.edu.au.mapgame.Model.GameMap;
import curtin.edu.au.mapgame.Model.Player;
import curtin.edu.au.mapgame.R;

public class NavigationActivity extends AppCompatActivity
{
    private static final String PLAYER_HAS_WON = "Player has won";
    private static final int MAX_LOC = 3;
    private Player player;
    private GameMap map;
    private TextView health;
    private TextView cash;
    private TextView mass;
    private TextView location;
    private Area currArea;
    private TextView areaDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        if(player == null)
        {
            player = new Player();
        }
        if(map == null)
        {
            map = new GameMap();
            currArea = map.getArea(0,0);
        }

        // Connect health / cash / mass / location bars --------------------------------------------
        health = findViewById(R.id.tv_health);
        cash = findViewById(R.id.tv_cash);
        mass = findViewById(R.id.tv_mass);
        location = findViewById(R.id.tv_location);
        areaDescription = findViewById(R.id.tv_area_description);

        // Connect Navigation Buttons --------------------------------------------------------------
        Button north = findViewById(R.id.btn_north);
        Button south = findViewById(R.id.btn_south);
        Button east = findViewById(R.id.btn_east);
        Button west = findViewById(R.id.btn_west);

        // Connect Options Button ------------------------------------------------------------------
        Button options = findViewById(R.id.btn_options);

        // Connect Restart Button ------------------------------------------------------------------
        Button restart = findViewById(R.id.btn_restart);

        // Add Restart Button Listener -------------------------------------------------------------
        restart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                restartGame();
            }
        });

        // Add Options Button Listener -------------------------------------------------------------
        options.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(currArea.isTown())
                {
                    Intent i = new Intent(NavigationActivity.this, MarketOptionActivity.class);
                    i.putExtra("Player", player);
                    i.putExtra("Area", currArea);
                    startActivityForResult(i, 0);
                }
                else
                {
                    Intent i = new Intent(NavigationActivity.this, WildernessOptionActivity.class);
                    i.putExtra("Player", player);
                    i.putExtra("Area", currArea);
                    startActivityForResult(i, 0);
                }
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
                    player.moveNorth();
                    navCommonOperations();
                    if(playerHasLost())
                    {
                        Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                        i.putExtra(PLAYER_HAS_WON, false);
                        startActivityForResult(i, 1);
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 125);
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
                    player.moveSouth();
                    navCommonOperations();
                    if(playerHasLost())
                    {
                        Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                        i.putExtra(PLAYER_HAS_WON, false);
                        startActivityForResult(i, 1);
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 125);
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
                    player.moveEast();
                    navCommonOperations();
                    if(playerHasLost())
                    {
                        Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                        i.putExtra(PLAYER_HAS_WON, false);
                        startActivityForResult(i, 1);
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 125);
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
                    player.moveWest();
                    navCommonOperations();
                    if(playerHasLost())
                    {
                        Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                        i.putExtra(PLAYER_HAS_WON, false);
                        startActivityForResult(i, 1);
                    }
                }
                else
                {
                    Toast toast = Toast.makeText(NavigationActivity.this, R.string.cannot_move, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 125);
                    toast.show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 0)
        {
            Player returnedPlayer = data.getParcelableExtra("Player");
            Area returnedArea = data.getParcelableExtra("Area");
            if(returnedArea != null)
            {
                updateArea(returnedArea);
            }
            if(returnedPlayer != null)
            {
                updatePlayer(returnedPlayer);
            }

            if(playerHasWon())
            {
                Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                i.putExtra(PLAYER_HAS_WON, true);
                startActivityForResult(i, 1);
            }
            else if(playerHasLost())
            {
                Intent i = new Intent(NavigationActivity.this, WinLoseActivity.class);
                i.putExtra(PLAYER_HAS_WON, false);
                startActivityForResult(i, 1);
            }
        }
        else if(requestCode == 1)
        {
            if(resultCode == 1)
            {
                restartGame();
            }
        }
    }

    private void restartGame()
    {
        player = new Player();
        map = new GameMap();
        currArea = map.getArea(0, 0);
        health.setText(R.string.default_health);
        cash.setText(R.string.default_cash);
        mass.setText(R.string.default_mass);
        location.setText(R.string.default_location);
        areaDescription.setText(R.string.label_wilderness);
    }

    private boolean playerHasWon()
    {
        return player.hasAllItems();
    }

    private boolean playerHasLost()
    {
        return (player.getHealth() <= 0);
    }

    private void updateArea(Area newArea)
    {
        currArea = newArea;
        map.setArea(currArea, player.getRowLocation(), player.getColLocation());
    }

    private void updatePlayer(Player player)
    {
        this.player = player;
        this.health.setText(getString(R.string.label_health, player.getHealth()));
        this.cash.setText(getString(R.string.label_cash, player.getCash()));
        this.mass.setText(getString(R.string.label_mass, player.getEquipmentMass()));
    }

    private void navCommonOperations()
    {
        currArea = map.getArea(player.getRowLocation(), player.getColLocation());
        if(currArea.isTown())
        {
            areaDescription.setText(R.string.label_town);
        }
        else
        {
            areaDescription.setText(R.string.label_wilderness);
        }
        this.health.setText(getString(R.string.label_health, player.getHealth()));
        this.location.setText(getString(R.string.location, player.getRowLocation(), player.getColLocation()));
    }
}
