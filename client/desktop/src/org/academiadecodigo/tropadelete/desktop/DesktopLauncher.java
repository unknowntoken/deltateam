package org.academiadecodigo.tropadelete.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.tropadelete.ChatClient;
import org.academiadecodigo.tropadelete.views.MainView;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.resizable=false;
		config.fullscreen=false;
		config.width = 1920;
		config.height = 1080;

		new LwjglApplication(new ChatClient(), config);
	}
}
