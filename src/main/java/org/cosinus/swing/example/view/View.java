/*
 * Copyright 2025 Cosinus Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.cosinus.swing.example.view;

import org.cosinus.swing.form.Panel;
import org.cosinus.swing.preference.Preferences;
import org.cosinus.swing.translate.Translator;
import org.springframework.stereotype.Component;

import java.awt.*;

import static java.awt.RenderingHints.*;

@Component
public class View extends Panel {

    public static final String BACKGROUND_COLOR_KEY = "background-color";

    public static final String FOREGROUND_COLOR_KEY = "foreground-color";

    private final Preferences preferences;

    private final Translator translator;

    private final Model model;

    public View(final Preferences preferences, final Translator translator, final Model model) {
        super(new BorderLayout());
        this.preferences = preferences;
        this.translator = translator;
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color backgroundColor = preferences.findColorPreference(BACKGROUND_COLOR_KEY)
            .orElse(getBackground());
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_BILINEAR);

        Color foregroundColor = preferences.findColorPreference(FOREGROUND_COLOR_KEY)
            .orElse(getForeground());
        g.setColor(foregroundColor);
        String text = translator.translate(model.getText());
        g.drawString(text, model.getPosition().x, model.getPosition().y);
    }
}
