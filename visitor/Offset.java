package visitor;

public class Offset {
    private int depth, offset;

    public Offset(int depth, int offset) {
        this.depth = depth;
        this.offset = offset;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getDepth() {
        return depth;
    }

    public int getOffset() {
        return offset;
    }
}
