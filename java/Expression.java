
abstract class Expression {

    static class Binary extends Expression {
        final Expression left;
        final Expression right;
        final Token operator;

        Binary(Expression left, Token operator, Expression right) {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }

    }

}
