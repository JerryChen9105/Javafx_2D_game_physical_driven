package javafx.test.workspace.not_related_folder.game_tick_sys;

import javafx.test.workspace.not_related_folder.event.EventBus;
import javafx.test.workspace.not_related_folder.event.GameTickAll;

public class AccumulatorGameLoop implements Runnable {
    private static final double TICK_INTERVAL_NANOS = 50_000_000.0; // 50ms in nanoseconds
    private volatile boolean running = true;
    private double accumulator = 0;
    private long previousTime = System.nanoTime();

    private static EventBus eventBus;

    @Override
    public void run() {
        while (running) {
            long currentTime = System.nanoTime();
            double frameTime = currentTime - previousTime;
            previousTime = currentTime;

            // 防止因长时间暂停（如调试断点）导致“死亡螺旋”
            if (frameTime > 250_000_000.0) { // 超过250ms，丢弃多余时间
                frameTime = 250_000_000.0;
            }

            accumulator += frameTime;

            // 只要累积时间足够一个tick，就执行一次逻辑更新
            while (accumulator >= TICK_INTERVAL_NANOS) {
                updateGameLogic();
                accumulator -= TICK_INTERVAL_NANOS;
            }

            // 渲染或休眠，accumulator 的剩余部分可用于插值
            render(accumulator / TICK_INTERVAL_NANOS);

            // 简单的休眠控制，避免空转占满CPU
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void updateGameLogic() {
        eventBus.publish(new GameTickAll());
    }

    private void render(double partialTick) {
        // 利用 partialTick (0.0 ~ 1.0) 在两次逻辑状态之间进行插值渲染
    }
}
