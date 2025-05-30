package util;

import model.Element;

public class Cell {
    private CellType type;
    private Element element;

    public Cell() {
        this.type = CellType.EMPTY;
        this.element = null;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public boolean isWalkable() {
        return type != CellType.OBSTACLE;
    }
}
