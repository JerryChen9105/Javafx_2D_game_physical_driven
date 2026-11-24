package javafx.test.workspace.gametick_system;

import javafx.test.workspace.physic_model.entity.Entity;

public record EntityGuiAction(Entity entity, Runnable guiAction) {
}

