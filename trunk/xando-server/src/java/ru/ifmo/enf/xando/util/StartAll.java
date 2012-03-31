// Файл создан для удобства во время разработки , в собраной версии он будет отсутствовать!!!

package ru.ifmo.enf.xando.util;


import ru.ifmo.enf.micelius.core.BoletsContainer;
import ru.ifmo.enf.micelius.server.*;
import ru.ifmo.enf.xando.bolets.XandoBolet;

import java.io.File;
import java.util.Properties;

/**
 * Author: Kuznetsov Pavel (palmihal@gmail.com)
 * Date: 27.11.11
 */
public class StartAll {
    static class Frontend implements Runnable {
        public void run() {
            final String workDir = "C:\\work\\xando\\trunk\\xando-view\\"; //"C:\\work\\xando\\trunk\\xando-view";
            final Properties configs = new Properties();
            configs.put(ConfigKeys.PORT, "8028"); // Указываем порт
            configs.put(ConfigKeys.WORK_DIR, workDir); // рабочую директорию
            configs.put(ConfigKeys.MAX_THREADS, "20"); // макс. кол-во одновременно обрабатываемых запросов

            final RequestHandler requestHandler = new FrontendHttpRequestHandler(new File(workDir));

            new Server(configs, requestHandler);
        }
    }

    static class Backend implements Runnable {
        public void run() {
            final Properties configs = new Properties();
            configs.put(ConfigKeys.PORT, "8018"); //Указываем порт
            configs.put(ConfigKeys.WORK_DIR, "C:\\backend"); // рабочую директорию
            configs.put(ConfigKeys.MAX_THREADS, "20"); // макс. кол-во одновременно обрабатываемых запросов

            final BoletsContainer boletsContainer = new BoletsContainer();
            boletsContainer.add("XandoBolet", new XandoBolet());
            final BoletsRequestHandler boletsRequestHandler = new BoletsRequestHandler(boletsContainer);

            new Server(configs, boletsRequestHandler);
        }

    }

    public static void main(String[] args) {
        final Thread threadFrontend = new Thread(new Frontend(), "tFront");
        final Thread threadBackend = new Thread(new Backend(), "tBack");
        threadBackend.start();
        threadFrontend.start();
        threadFrontend.interrupt();
    }
}
