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

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class Controller {

    private static final int MAX_DELTA = 50;

    private final Model model;

    private final View view;

    private final ThreadLocalRandom random;

    public Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
        random = ThreadLocalRandom.current();
    }

    @Scheduled(fixedDelay = 500)
    public void updateModel() {
        if (model.isStarted()) {
            Point currentPosition = model.getPosition();
            Point newPosition = null;
            while (newPosition == null || newPosition.x < 0 || newPosition.y < 20 ||
                newPosition.x > view.getWidth() - 100 ||
                newPosition.y > view.getHeight() - 5) {

                newPosition = new Point(
                    currentPosition.x + randomSign() * randomDelta(),
                    currentPosition.y + randomSign() * randomDelta());

            }
            model.setPosition(newPosition);
            view.refresh();
        }
    }

    private int randomSign() {
        return random.nextBoolean() ? 1 : -1;
    }

    private int randomDelta() {
        return random.nextInt(1, MAX_DELTA + 1);
    }
}
