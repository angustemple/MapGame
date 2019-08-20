package curtin.edu.au.mapgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import curtin.edu.au.mapgame.Model.GameMap;
import curtin.edu.au.mapgame.Model.Player;

public class NavigationActivity extends AppCompatActivity
{
    private Player player;
    private GameMap map;
    private Button btn_north;
    private Button btn_south;
    private Button btn_east;
    private Button btn_west;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Buttons
        btn_north = (Button)findViewById(R.id.btn_north);
        btn_south = (Button)findViewById(R.id.btn_south);
        btn_east = (Button)findViewById(R.id.btn_east);
        btn_west = (Button)findViewById(R.id.btn_west);

        // Add Button Listeners
        btn_north.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(NavigationActivity.this, R.string.move_north, Toast.LENGTH_SHORT).show();
            }
        });

        btn_south.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(NavigationActivity.this, R.string.move_south, Toast.LENGTH_SHORT).show();

            }
        });

        btn_east.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(NavigationActivity.this, R.string.move_east, Toast.LENGTH_SHORT).show();

            }
        });

        btn_west.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(NavigationActivity.this, R.string.move_west, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
