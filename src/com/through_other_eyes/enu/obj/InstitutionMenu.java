/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.obj.base.ButtonGroup;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mike7707
 */
public class InstitutionMenu extends UIElement{
    
    private ArrayList<UIElement> uiElements = new ArrayList<>();
    private ButtonGroup buttonGroup;
    
    public InstitutionMenu(Point position, Dimension dimension) throws IOException {
        super(position, dimension);
        this.buttonGroup = new ButtonGroup();
        CentralBankButton cbb1 = new CentralBankButton(new Point(180, 0), ImageIO.read(new File("res" + File.separator + "zentralbank.png")), ImageIO.read(new File("res" + File.separator + "zentralbank_toggled.png")));
        CentralBankButton cbb2 = new CentralBankButton(new Point(250, 0), ImageIO.read(new File("res" + File.separator + "zentralbank.png")), ImageIO.read(new File("res" + File.separator + "zentralbank_toggled.png")));
        CentralBankButton cbb3 = new CentralBankButton(new Point(320, 0), ImageIO.read(new File("res" + File.separator + "zentralbank.png")), ImageIO.read(new File("res" + File.separator + "zentralbank_toggled.png")));
        CentralBankButton cbb4 = new CentralBankButton(new Point(390, 0), ImageIO.read(new File("res" + File.separator + "zentralbank.png")), ImageIO.read(new File("res" + File.separator + "zentralbank_toggled.png")));
        
        uiElements.add(cbb1);
        uiElements.add(cbb2);
        uiElements.add(cbb3);
        uiElements.add(cbb4);
        
        buttonGroup.addButton(cbb1);
        buttonGroup.addButton(cbb2);
        buttonGroup.addButton(cbb3);
        buttonGroup.addButton(cbb4);
    }

    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        for(GameComponent uiElement : uiElements)
        {
            uiElement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }

    @Override
    public void clicked() {
        System.out.println("INSTMENU");
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}