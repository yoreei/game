package gameMechanics;

import java.awt.Point;

public class NovaTower extends SpecialTower {

    public NovaTower(int range, Point position, int level, int maxCharge) {
        super(range, position, level, maxCharge);
    }
    @Override
    public void fire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upgrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasInRange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}