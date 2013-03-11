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
     *      path = resources/level/unit/kaamio.png
     * toString of this would be
     *      kaamio
     * 
     * @return 
     */
    @Override
    public String toString() {
        String[] lastMember = this.path.split("/");
        String contentName = lastMember[lastMember.length-1].split(".")[0];
        return contentName;
    }
}
