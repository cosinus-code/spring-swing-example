/*
 * Copyright 2020 Cosinus Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cosinus.swing.example;

import org.cosinus.swing.boot.SpringSwingApplication;
import org.cosinus.swing.boot.SpringSwingBootApplication;
import org.cosinus.swing.boot.SwingApplicationFrame;

import javax.swing.*;
import java.awt.*;

@SpringSwingBootApplication
public class HelloWorld extends SwingApplicationFrame {

    @Override
    public void initComponents() {
        super.initComponents();

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(translate("hello.world"), SwingConstants.CENTER));
        add(panel);
    }

    public static void main(String[] args) {
        SpringSwingApplication.run(HelloWorld.class, args);
    }
}
