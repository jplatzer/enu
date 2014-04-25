/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.through_other_eyes.enu.util;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.InstitutionMenu;
import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * @author mwahlhuetter
 * @date 23.03.2014
 */
public class MouseInputController implements MouseWheelListener, MouseListener, MouseMotionListener {

    //TO DO
    // make interface clickable, check if mouseevent source is game object + clickable, then call click, interact etc method of the object licked
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameCore.state == GameCore.State.MAINMENU) {
            
            for (UIElement uielement : GameCore.mainMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                
                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.clicked();
                }
            }
        }
        if (GameCore.state == GameCore.State.PLAY) {
            for (UIElement uielement : GameCore.map.getInstMenu().getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                
                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.clicked();
                    ButtonGroup buttonGroup = GameCore.map.getInstMenu().getButtonGroup();
                    buttonGroup.selectButton(uielement);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (GameCore.state == GameCore.State.MAINMENU) {
            for (UIElement uielement : GameCore.mainMenu.getUiElements()) {
                Point uiElementPosition = uielement.getPosition();
                Dimension uiElementDimension = uielement.getDimension();
                Point mousePosition = e.getPoint();
                
                if (intersects(uiElementPosition, uiElementDimension, mousePosition)) {
                    uielement.hoverElement();
                    uielement.setMouseHoverPossible(false);
                } else {
                    if (!uielement.isMouseHoverPossible()) {
                        uielement.leaveElement();
                    }
                    uielement.setMouseHoverPossible(true);
                }
            }
        }
    }

    /**
     * Checks with the given parametes if the mouse intersects a specific button
     * @param uiElementPosition
     * @param uiElementDimension
     * @param mousePosition
     * @return 
     */
    private boolean intersects(Point uiElementPosition, Dimension uiElementDimension, Point mousePosition) {
//        System.out.println("x=" + uiElementPosition.x + "y=" + uiElementPosition.y);
//        System.out.println("x=" + mousePosition.x + "y=" + mousePosition.y);
//        System.out.println("x=" + (uiElementPosition.x + uiElementDimension.width) + "y=" + (uiElementPosition.y + uiElementDimension.height));
        return  mousePosition.x >= uiElementPosition.x &&
                mousePosition.y >= uiElementPosition.y &&
                mousePosition.x <= uiElementPosition.x + uiElementDimension.width &&
                mousePosition.y <= uiElementPosition.y + uiElementDimension.height;
    }
}
