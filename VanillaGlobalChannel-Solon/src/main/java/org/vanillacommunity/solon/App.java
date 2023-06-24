package org.vanillacommunity.solon;

import lombok.Getter;
import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.SolonMain;
import org.vanillacommunity.solon.config.ChannelsConfig;
import org.vanillacommunity.solon.config.ClientsConfig;

/**
 * Solon APP 主类
 */
@SolonMain
public class App {
    @Getter
    private static SolonApp solonApp;

    /**
     * Solon 主方法，在 Solon 启动时调用该方法
     */
    public static void main(String[] args) {
        solonApp = Solon.start(App.class, args, app -> {
            app.enableWebSocket(true);
            app.enableWebSocketMvc(false);
        });
        initCfg();
    }

    /**
     * 初始化 Solon 相关的配置文件
     */
    private static void initCfg() {
        ClientsConfig clientsConfig = IOC.get(ClientsConfig.class);
        clientsConfig.load(solonApp);
        ChannelsConfig channelsConfig = IOC.get(ChannelsConfig.class);
        channelsConfig.load(solonApp);
    }
}