package com.ipc1.cah.ui;

public interface ImageRoutes {

    String IMAGES_HOME = "/com/ipc1/cah/ui/image-resourses/";
    String EXTENSION = ".png";
    String FULL_BACKGROUND = IMAGES_HOME + "fullBackground" + EXTENSION;
    String EDGE_BACKGROUND = IMAGES_HOME + "edgeBackground" + EXTENSION;
    String GAME_TITLE = IMAGES_HOME + "gameTitle" + EXTENSION;
    String PLAY_CHECKERS = IMAGES_HOME + "playCheckersButton" + EXTENSION;
    String PLAY_HANOI = IMAGES_HOME + "playHanoiButton" + EXTENSION;
    String REPORTS = IMAGES_HOME + "reportsButton" + EXTENSION;

    String TOKENS_HOME = IMAGES_HOME + "checkers/tokens/";
    String BLACK_TOKEN = TOKENS_HOME + "black" + EXTENSION;
    String BLUE_TOKEN = TOKENS_HOME + "blue" + EXTENSION;
    String CYAN_TOKEN = TOKENS_HOME + "cyan" + EXTENSION;
    String GREEN_TOKEN = TOKENS_HOME + "green" + EXTENSION;
    String MINT_TOKEN = TOKENS_HOME + "mint" + EXTENSION;
    String ORANGE_TOKEN = TOKENS_HOME + "orange" + EXTENSION;
    String PINK_TOKEN = TOKENS_HOME + "pink" + EXTENSION;
    String PURPLE_TOKEN = TOKENS_HOME + "purple" + EXTENSION;
    String RED_TOKEN = TOKENS_HOME + "red" + EXTENSION;
    String WHITE_TOKEN = TOKENS_HOME + "white" + EXTENSION;
    String YELLOW_TOKEN = TOKENS_HOME + "yellow" + EXTENSION;

    String SQUARES_HOME = IMAGES_HOME + "checkers/squares/";
    String LIGHT_SQUARE = SQUARES_HOME + "light" + EXTENSION;
    String DARK_SQUARE = SQUARES_HOME +"dark"+ EXTENSION;
    
}
