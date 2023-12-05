
package Display;

import javax.swing.JPanel;

public abstract class PanelElement extends JPanel{


    public boolean isActive = false;

    public abstract JPanel create();

}
