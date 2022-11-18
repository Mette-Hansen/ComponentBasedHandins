package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.openide.modules.ModuleInstall;

public class Main extends ModuleInstall {

    private static Game game;

    //	public static void main(String[] args) {
//
//		LwjglApplicationConfiguration cfg =
//			new LwjglApplicationConfiguration();
//		cfg.title = "Asteroids";
//		cfg.width = 500;
//		cfg.height = 400;
//		cfg.useGL30 = false;
//		cfg.resizable = false;
//
//		new LwjglApplication(new Game(), cfg);
//
//	}
    @Override
    public void restored() {

        game = new Game();

        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Asteroids";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;

        new LwjglApplication(game, cfg);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.restored();
    }

}
