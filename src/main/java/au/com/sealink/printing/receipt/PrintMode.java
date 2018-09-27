package au.com.sealink.printing.receipt;

public enum PrintMode {
    FONT_A(0),
    FONT_B(1),
    EMPHASIZED(8),
    DOUBLE_HEIGHT(16),
    DOUBLE_WIDTH(32),
    UNDERLINE(128);

    private final int id;

    PrintMode(int id) {
        this.id = id;
    }

    public int getValue() {
        return this.id;
    }
}
