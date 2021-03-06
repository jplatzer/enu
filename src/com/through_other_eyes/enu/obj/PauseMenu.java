/* Europa NON Universalis - A dogma 2001 game
 * Copyright (C) 2014 through.other.eyes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.through_other_eyes.enu.obj;

import com.through_other_eyes.enu.core.GameCore;
import com.through_other_eyes.enu.obj.base.GameComponent;
import com.through_other_eyes.enu.obj.base.Resource;
import com.through_other_eyes.enu.obj.base.UIElement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author mwahlhuetter
 * @date 05.04.2014
 */
public class PauseMenu extends GameComponent {

    private BufferedImage background;
    private ArrayList<UIElement> uiElements;

    public PauseMenu() throws IOException {
        super(new Point(0, 0), new Dimension(GameCore.WIDTH, GameCore.HEIGHT), true, true);
        this.background = ImageIO.read(Resource.PAUSEMENU_BACKGROUND);
        this.uiElements = new ArrayList<>();
        MainMenuButton play = new MainMenuButton(Resource.MAINMENU, GameCore.Align.CENTER, 0, 225);
        ExitButton exit = new ExitButton(Resource.EXIT, GameCore.Align.CENTER, 0, 260);
        uiElements.add(play);
        uiElements.add(exit);
    }

    @Override
    public void update() {
    }

    @Override
    public void drawObject(Graphics2D g2) {
        g2.drawImage(background, 0, 0, getDimension().width, getDimension().height, null);
        g2.setFont(GameCore.font.deriveFont(50f));
        int fontWidth = g2.getFontMetrics().stringWidth("PAUSED");
        g2.setColor(Color.BLACK);
        g2.drawString("PAUSED", GameCore.WIDTH / 2 - fontWidth / 2 + 2, 62);
        g2.setColor(new Color(251, 224, 21));
        g2.drawString("PAUSED", GameCore.WIDTH / 2 - fontWidth / 2, 60);
        for (UIElement uilement : uiElements) {
            uilement.drawObject(g2);
        }
    }

    @Override
    public void move(float delta) {
    }

    public ArrayList<UIElement> getUiElements() {
        return uiElements;
    }
}
