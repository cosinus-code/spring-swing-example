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

package org.cosinus.swing.example.action;

import org.cosinus.swing.action.SwingAction;
import org.cosinus.swing.example.view.Model;
import org.springframework.stereotype.Component;

@Component
public class StartAction implements SwingAction {

    public static final String START = "start";

    private final Model model;

    public StartAction(final Model model) {
        this.model = model;
    }

    @Override
    public void run() {
        model.setStarted(true);
    }

    @Override
    public String getId() {
        return START;
    }
}
