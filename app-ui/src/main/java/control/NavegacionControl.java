package control;

import frames.GlobalFrame;
import frames.LogInFrame;

public class NavegacionControl {
    private LogInFrame logInFrame;
    private GlobalFrame globalFrame;

    public NavegacionControl(){
        this.logInFrame = null;
        this.globalFrame = null;
    }

    public void setLogInFrame(LogInFrame logInFrame) {
        this.logInFrame = logInFrame;
    }

    public void abrirGlobalFrame(){
        if(logInFrame != null){
            logInFrame.dispose();
        }

        globalFrame = new GlobalFrame();
        globalFrame.setVisible(true);
    }
}
