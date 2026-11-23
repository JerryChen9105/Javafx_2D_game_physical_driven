package javafx.test.workspace;

import javafx.animation.AnimationTimer;
import javafx.test.workspace.physic_engine.Vector;
import javafx.test.workspace.physic_model.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class GameTickSystem {

    // entity list and timer
    private final AnimationTimer timer;
    private final List<EntityGuiAction> entityGuiActionList;
    private Entity activeEntity;


    // active entity motion variable
    private double pushForce;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;



    public GameTickSystem(Entity activeEntity, Runnable activeEntityAction, double pushForce) {
        this.entityGuiActionList = new ArrayList<>();

        this.activeEntity = activeEntity;
        this.pushForce = pushForce;

        this.entityGuiActionList.add(new EntityGuiAction(activeEntity, activeEntityAction));

        timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double deltaTime = (now - lastTime) / 500_000_000.0;
                lastTime = now;

                entityGuiActionList.forEach(record -> {
                    if (record.entity() == activeEntity) resolveActiveEntityMotion(record, deltaTime);
                    else resolvePassiveEntityMotion(record, deltaTime);
                });
            }
        };
    }



    // entity & GUI action list control
    public void addEntityGuiAction(Entity entity, Runnable guiAction) throws GameTickSystemException {
        if (entity == null) throw new GameTickSystemException("null entity pointer");
        entityGuiActionList.add(new EntityGuiAction(entity, guiAction));
    }

    public EntityGuiAction removeEntity(Entity entity) throws GameTickSystemException {
        if (entity.equals(activeEntity)) throw new GameTickSystemException("unable to remove active entity");
        EntityGuiAction r = null;
        for (EntityGuiAction record : entityGuiActionList) {
            if (!entity.equals(record.entity())) continue;
            r = record;
            break;
        }
        entityGuiActionList.remove(r);
        return r;
    }

    public void setActiveEntity(Entity activeEntity, Runnable guiAction) throws GameTickSystemException {
        addEntityGuiAction(activeEntity, guiAction);
        this.activeEntity = activeEntity;
    }

    // timer control
    public void startGameTick() {
        timer.start();
    }


    public void stopGameTick() {
        timer.stop();
    }


    // entity control
    public void resolveActiveEntityMotion(EntityGuiAction activeRecord, double deltaTime) {
        if (upPressed) activeEntity.getStatus().applyForce(new Vector(0, -pushForce));
        if (downPressed) activeEntity.getStatus().applyForce(new Vector(0, pushForce));
        if (leftPressed) activeEntity.getStatus().applyForce(new Vector(-pushForce, 0));
        if (rightPressed) activeEntity.getStatus().applyForce(new Vector(pushForce, 0));

        activeEntity.getStatus().update(deltaTime);
        activeEntity.resolveBoundaryCollision();
        activeRecord.guiAction().run();
    }


    public void resolvePassiveEntityMotion(EntityGuiAction passiveRecord, double deltaTime) {
        // add code
        passiveRecord.entity().getStatus().update(deltaTime);
        passiveRecord.entity().resolveBoundaryCollision();
        passiveRecord.guiAction().run();
    }

    // active entity motion control


    public void setPushForce(double pushForce) {
        this.pushForce = pushForce;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }
}
