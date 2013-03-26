/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.level;

/**
 *
 * @author 41407
 */
public abstract class CellContent {

    String path;

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }

    /**
     * Strips the name of the image file, eg. if
     *      path = unit/kaamio
     * toString of this would be
     *      kaamio
     * 
     * This is used to assign hash keys for graphics
     * 
     * @return 
     */
    @Override
    public String toString() {
        String[] lastMember = this.path.split("/");
        return lastMember[lastMember.length-1];
    }
}
