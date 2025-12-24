package io.armandukx.noautopause;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class Main implements ClientModInitializer {
    private boolean AppliedSetting = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!AppliedSetting) {
                if (client.options != null) {
                    client.options.pauseOnLostFocus = false;
                    AppliedSetting = true;
                }
            }
        });
    }
}
