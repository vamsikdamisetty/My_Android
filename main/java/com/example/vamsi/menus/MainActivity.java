package com.example.vamsi.menus;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ActionMode actionMode;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        registerForContextMenu((Button) findViewById(R.id.b1));


        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, b2);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu1, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }
        });

        b3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (actionMode != null) {
                    return false;
                }
                actionMode = startSupportActionMode(callback);

                return true;
            }
        });
    }

        private ActionMode.Callback callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.actionmenu,menu);
                mode.setTitle("Choose your option");

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.i1:
                        Toast.makeText(MainActivity.this,"Cicked Main Menu",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.i2:
                        Toast.makeText(MainActivity.this,"I am sub-menu 1",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.i3:
                        Toast.makeText(MainActivity.this,"I am sub-menu 2",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                actionMode = null;
            }
        };






    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu1,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.i1:
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this,"Deleted" +
                        "",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu1,menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.i1:
                Toast.makeText(this,"Clicked Main menu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2:
                Toast.makeText(this,"I am sub-menu 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3:
                Toast.makeText(this,"I am sub-menu 2",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }



}
