package com.dnamaster10.systems;

import com.dnamaster10.Tickable;
import com.dnamaster10.objects.space.ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class ShipManager implements Tickable {
    List<Ship> ships = new ArrayList<>();

    @Override
    public void tick() {
        for (Ship ship : ships) {
            ship.tick();
        }
    }
}
