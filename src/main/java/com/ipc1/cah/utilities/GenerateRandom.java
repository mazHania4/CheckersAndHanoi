package com.ipc1.cah.utilities;

import com.ipc1.cah.ui.ImageRoutes;

public class GenerateRandom {

    public static int randomInteger(int min, int max) {
        int randomInt = (int) Math.floor(Math.random()*(max-min+1)+min);
       return randomInt;
   }

    public static String randomColorTokenRoute(){
        String answer = "";
        switch (randomInteger(1, 11)) {
            case 1: answer = ImageRoutes.BLACK_TOKEN; break;
            case 2: answer = ImageRoutes.BLUE_TOKEN; break;
            case 3: answer = ImageRoutes.CYAN_TOKEN; break;
            case 4: answer = ImageRoutes.GREEN_TOKEN; break;
            case 5: answer = ImageRoutes.MINT_TOKEN; break;
            case 6: answer = ImageRoutes.ORANGE_TOKEN; break;
            case 7: answer = ImageRoutes.PINK_TOKEN; break;
            case 8: answer = ImageRoutes.PURPLE_TOKEN; break;
            case 9: answer = ImageRoutes.RED_TOKEN; break;
            case 10: answer = ImageRoutes.WHITE_TOKEN; break;
            case 11: answer = ImageRoutes.YELLOW_TOKEN; break;
        }
        return answer;
    }
    
}
