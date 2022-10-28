package ClassFile.MipsInstr;

public class JumpTo extends Instr {
    public static int JAL = 0;
    public static int JR = 1;
    private final int type;
    private final String target;

    public JumpTo(int type, String target) {
        this.type = type;
        this.target = target;
    }

    @Override
    public String toString() {
        if (type == JAL) {
            return "\tjal " + target;
        } else if(type == JR){
            return "\tjr " + target;
        }
        return null;
    }
}
