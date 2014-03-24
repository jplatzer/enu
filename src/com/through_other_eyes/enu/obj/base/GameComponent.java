/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj.base;

import java.awt.Dimension;
import java.awt.Point;

/**
 * @author jplatzer
 * @date 22.03.2014
 */
public abstract class GameComponent implements Drawable, Moveable{
    private Point position;
    private Dimension dimension;
    private boolean visible;
    private boolean updateRequired;

    public GameComponent() {
    }
    
    public GameComponent(Point position, Dimension dimension, boolean visible)
    {
        this.position = position;
        this.dimension = dimension;
        this.visible = visible;
    }
    
    public abstract void update();

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isUpdateRequired() {
        return updateRequired;
    }

    public void setUpdateRequired(boolean updateRequired) {
        this.updateRequired = updateRequired;
        if(!updateRequired) {
            this.setVisible(false);
        }
    }
}
