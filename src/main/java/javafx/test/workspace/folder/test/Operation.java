package javafx.test.workspace.folder.test;

public enum Operation {

    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    Operation() {

    }

    public double apply(int a, int b) throws UnsupportedOperationException{
        switch (this) {
            case ADD -> {return a + b;}
            case SUBTRACT -> {return a - b;}
            case MULTIPLY -> {return a * b;}
            case DIVIDE -> {return (double) a / b;}
            case null, default -> throw new UnsupportedOperationException();
        }
    }

}
