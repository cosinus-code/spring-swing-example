/*
 * Copyright 2025 Cosinus Software
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

import org.cosinus.swing.boot.SpringSwingBootApplication;
import org.cosinus.swing.boot.SwingApplicationFrame;
import org.cosinus.swing.example.view.View;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.cosinus.swing.boot.SpringSwingApplication.run;

@SpringSwingBootApplication
@EnableScheduling
public class HelloWorld extends SwingApplicationFrame {

    private final View view;

    public HelloWorld(View view) {
        this.view = view;
    }

    @Override
    public void initComponents() {
        super.initComponents();
        add(view);
    }

    public static void main(String[] args) {
        run(HelloWorld.class, args);
    }

    @Override
    protected void loadContent() {
    }
}
