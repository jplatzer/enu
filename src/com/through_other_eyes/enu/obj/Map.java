/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.obj.base.GameComponent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mwahlhuetter
 * @date 04.04.2014
 */
public class Map extends GameComponent {

    private ArrayList<GameComponent> mapLayer = new ArrayList<>();
    private InstitutionMenu instMenu;
    
    public Map() throws IOException {
        instMenu = new InstitutionMenu(new Point(180, 0), new Dimension(280, 40));
    }
    
    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        instMenu.drawObject(g2);
    }

    @Override
    public void move(float delta) {
    }

    public InstitutionMenu getInstMenu() {
        return instMenu;
    }
}
