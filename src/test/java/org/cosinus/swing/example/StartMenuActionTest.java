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

package org.cosinus.swing.example;

import org.cosinus.swing.example.view.Model;
import org.cosinus.swing.test.boot.SpringSwingBootTest;
import org.cosinus.swing.test.robot.SwingRobot;
import org.cosinus.swing.test.robot.SwingRobotTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.cosinus.swing.example.action.StartAction.START;

@SwingRobotTest
@SpringSwingBootTest
class StartMenuActionTest {

    @Autowired
    private Model model;

    @Test
    void clickingStartMenuItem(SwingRobot robot) {
        robot.clickMenuItem(START);
        assertThat(model.isStarted()).isTrue();

        assertModelPositionIsChanging();
        assertModelPositionIsChanging();
    }

    private void assertModelPositionIsChanging() {
        Point initialPosition = new Point(model.getPosition());
        await()
             .atMost(5, SECONDS)
             .until(() -> !model.getPosition().equals(initialPosition));

        assertThat(model.getPosition()).isNotEqualTo(initialPosition);
    }
}
