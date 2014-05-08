/*
 * Copyright (C) 2014 mwahlhuetter <m.wahl1996 at gmail.com>
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
import com.through_other_eyes.enu.obj.base.Button;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author mwahlhuetter <m.wahl1996 at gmail.com>
 */
public class CloseQuestionDialogButton extends Button{

    public CloseQuestionDialogButton(Point position, BufferedImage elementImage) {
        super(position, elementImage);
    }

    public CloseQuestionDialogButton(BufferedImage elementImage, GameCore.Align align, int offset, int y) {
        super(elementImage, align, offset, y);
    }
    
    @Override
    public void clicked() {
        GameCore.questionDialog.setVisible(false);
    }

    @Override
    public void hoverElement() {
    }

    @Override
    public void leaveElement() {
    }
}
