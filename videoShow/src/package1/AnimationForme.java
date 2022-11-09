/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.awt.Graphics;

/**
 */
public abstract class AnimationForme implements IObjetAnimable {
    
    private IObjetDessinable forme;
    private IFormeAnimable formeAnimable;

    public AnimationForme(IObjetDessinable forme, IFormeAnimable formeAnimable) {
        this.forme = forme;
        this.formeAnimable = formeAnimable;
    }

    @Override
    public void deplacer() {
        this.formeAnimable.deplacer(this.forme);
    }

    @Override
    public void dessiner(Graphics g) {
        ((IObjetAnimable) this.forme).dessiner(g);
    }
    
    
    @Override
    public void placer(int x, int y) {
    }
    
}
