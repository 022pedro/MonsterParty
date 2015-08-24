package com.pedro022.monsterparty.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.pedro022.monsterparty.Main;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(900, 500);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new Main();
        }
}