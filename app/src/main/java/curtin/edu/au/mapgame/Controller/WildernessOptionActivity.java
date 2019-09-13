package curtin.edu.au.mapgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import curtin.edu.au.mapgame.Model.Area;
import curtin.edu.au.mapgame.Model.Equipment;
import curtin.edu.au.mapgame.Model.Food;
import curtin.edu.au.mapgame.Model.Item;
import curtin.edu.au.mapgame.Model.Player;
import curtin.edu.au.mapgame.R;

public class WildernessOptionActivity extends AppCompatActivity {
    private Area currentArea;
    private Player player;
    private TextView area_item_description;
    private TextView player_item_description;
    private TextView area_item_mass_health;
    private TextView player_item_mass_health;
    private TextView area_value;
    private TextView player_value;
    private TextView label_area_items;
    private TextView label_player_items;
    private TextView health;
    private TextView cash;
    private TextView mass;
    private Item curr_area_item;
    private Item curr_player_item;
    private int area_index = 0;
    private int player_index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilderness_option);

        // Get Data From Intent --------------------------------------------------------------------
        player = (Player) getIntent().getParcelableExtra("Player");
        currentArea = (Area) getIntent().getParcelableExtra("Area");

        // Connect TextViews -----------------------------------------------------------------------
        area_item_description = findViewById(R.id.tv_area_item_description);
        player_item_description = findViewById(R.id.tv_player_item_description);
        area_item_mass_health = findViewById(R.id.tv_area_health_mass);
        player_item_mass_health = findViewById(R.id.tv_player_health_mass);
        area_value = findViewById(R.id.tv_area_item_value);
        player_value = findViewById(R.id.tv_player_item_value);
        label_area_items = findViewById(R.id.tv_area_items);
        label_player_items = findViewById(R.id.tv_player_items);
        health = findViewById(R.id.tv_health);
        cash = findViewById(R.id.tv_cash);
        mass = findViewById(R.id.tv_mass);

        // Connect Buttons -------------------------------------------------------------------------
        Button btn_return = findViewById(R.id.btn_return);
        Button btn_area_next = findViewById(R.id.btn_area_item_next);
        Button btn_area_prev = findViewById(R.id.btn_area_item_prev);
        Button btn_player_next = findViewById(R.id.btn_player_item_next);
        Button btn_player_prev = findViewById(R.id.btn_player_item_prev);
        Button btn_take_item = findViewById(R.id.btn_take_item);
        Button btn_drop_item = findViewById(R.id.btn_drop_item);

        updateArea();
        updatePlayer();

        // Button Listeners ------------------------------------------------------------------------
        btn_take_item.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Item i = currentArea.getItem(area_index);
                if(i instanceof Equipment)
                {
                    player.addEquipment((Equipment) i);
                }
                else if(i instanceof Food)
                {
                    player.consumeFood((Food) i);
                }
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent data = new Intent();
                data.putExtra("Player", player);
                data.putExtra("Area", currentArea);
                setResult(0, data);
                finish();
            }
        });

        btn_area_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(area_index < currentArea.getItemSize() - 1)
                {
                    area_index++;
                    updateArea();
                }
            }
        });

        btn_area_prev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(area_index > 0)
                {
                    area_index--;
                    updateArea();
                }
            }
        });

        btn_player_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(player_index < player.getEquipmentSize() - 1)
                {
                    player_index++;
                    updatePlayer();
                }
            }
        });

        btn_player_prev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(player_index > 0)
                {
                    player_index--;
                    updatePlayer();
                }
            }
        });
    }

    private void updateArea()
    {
        if(currentArea.getItemSize() > 0)
        {
            label_area_items.setText(String.valueOf("Items in Area: (" + (area_index + 1) + "/" + currentArea.getItemSize() + ")"));
            curr_area_item = currentArea.getItem(area_index);
            area_item_description.setText(curr_area_item.getDescription());
            area_item_mass_health.setText(String.valueOf("Mass/Health: " + curr_area_item.getHealthMass()));
            area_value.setText(String.valueOf("Value: " + curr_area_item.getValue()));
        }
        else
        {
            area_item_description.setText("No Items");
            area_item_mass_health.setText("");
            area_value.setText("");
        }
    }

    private void updatePlayer()
    {
        health.setText(String.valueOf("Health: " + player.getHealth()));
        cash.setText(String.valueOf("Cash: " + player.getCash()));
        mass.setText(String.valueOf("Mass: " + player.getEquipmentMass()));
        if(player.getEquipmentSize() > 0)
        {
            label_player_items.setText(String.valueOf("Your Items: (" + (player_index + 1) + "/" + player.getEquipmentSize() + ")"));
            curr_player_item = player.getEquipmentItem(player_index);
            player_item_description.setText(curr_player_item.getDescription());
            player_item_mass_health.setText(String.valueOf("Mass/Health: " + curr_player_item.getHealthMass()));
            player_value.setText(String.valueOf("Value: " + curr_player_item.getValue()));
        }
        else
        {
            player_item_description.setText("No Items");
            player_item_mass_health.setText("");
            player_value.setText("");
        }
    }
}
